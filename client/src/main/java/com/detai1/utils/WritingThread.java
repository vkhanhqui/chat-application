/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detai1.utils;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author X507U-PC
 */
public class WritingThread extends Thread {

    private JTextArea txtaMessage;
    private File file;
    private UserConnection userConnection;

    public WritingThread(JTextArea txtaMessage, File file, UserConnection userConnection) {
        this.txtaMessage = txtaMessage;
        this.file = file;
        this.userConnection = userConnection;
    }

    @Override
    public void run() {
        try {
            String sender = userConnection.getUsername();
            String message = "\n" + sender + ": " + txtaMessage.getText();
            AttachmentDTO attachmentDTO = new AttachmentDTO(message, file);
            ObjectOutputStream oos = userConnection.getObjectOutputStream();
            oos.writeObject(attachmentDTO);
            oos.flush();
            if (txtaMessage.getText().equals("exit")) {
                System.exit(0);
            }
            txtaMessage.setText("");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(txtaMessage, ex.getMessage());
        }
    }
}
