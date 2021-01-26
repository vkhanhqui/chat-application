/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detai1.tools;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
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

    private Socket socket;
    private StyledDocument sd;
    private JRootPane rootPane;
    private final Path rootLocation;
    private ObjectInputStream ois;

    public ReadingThread(Socket socket, StyledDocument sd, JRootPane rootPane, ObjectInputStream ois) {
        this.socket = socket;
        this.sd = sd;
        this.rootPane = rootPane;
        this.rootLocation = Paths.get("archive");
        this.ois = ois;
    }

    @Override
    public void run() {
        try {
            while (true) {
                AttachmentDTO attachmentDTO = (AttachmentDTO) ois.readObject();
                sd.insertString(sd.getLength(), attachmentDTO.getMessage(), null);
                if (attachmentDTO.getFile() != null) {
                    File receive = attachmentDTO.getFile();
                    Files.copy(receive.toPath(),
                            rootLocation.resolve(Paths.get(receive.getName()))
                                    .normalize()
                                    .toAbsolutePath(),
                            StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException | ClassNotFoundException | BadLocationException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

}
