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
import javax.swing.JTextArea;

/**
 *
 * @author X507U-PC
 */
public class ReadingThread extends Thread {

    private UserConnection userConnection;
    private JTextArea txtaChatBox;

    public ReadingThread(JTextArea txtaChatBox, UserConnection userConnection) {
        this.txtaChatBox = txtaChatBox;
        this.userConnection = userConnection;
    }

    @Override
    public void run() {
        try {
            while (true) {
                ObjectInputStream ois = userConnection.getObjectInputStream();
                AttachmentDTO attachmentDTO = (AttachmentDTO) ois.readObject();
                txtaChatBox.append(attachmentDTO.getMessage());
                txtaChatBox.selectAll();
                int bottom = txtaChatBox.getSelectionEnd();;
                txtaChatBox.select(bottom, bottom);
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
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(txtaChatBox, ex.getMessage());
            ex.printStackTrace();
        }
    }

}
