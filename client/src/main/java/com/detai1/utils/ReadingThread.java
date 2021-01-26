/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detai1.utils;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author X507U-PC
 */
public class ReadingThread extends Thread {

    private StyledDocument styledDocument;
    private JRootPane rootPane;
    private UserConnection userConnection;

    public ReadingThread(StyledDocument styledDocument, JRootPane rootPane, UserConnection userConnection) {
        this.styledDocument = styledDocument;
        this.rootPane = rootPane;
        this.userConnection = userConnection;
    }

    @Override
    public void run() {
        try {
            while (true) {
                ObjectInputStream ois = userConnection.getObjectInputStream();
                AttachmentDTO attachmentDTO = (AttachmentDTO) ois.readObject();
                styledDocument.insertString(styledDocument.getLength(), attachmentDTO.getMessage(), null);
                if (attachmentDTO.getFile() != null) {
                    File receive = attachmentDTO.getFile();
                    Path rootLocation = Paths.get("archive");
                    Files.copy(receive.toPath(),
                            rootLocation.resolve(Paths.get(receive.getName()))
                                    .normalize()
                                    .toAbsolutePath(),
                            StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException | ClassNotFoundException | BadLocationException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            ex.printStackTrace();
        }
    }

}
