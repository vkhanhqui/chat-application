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
    private String sender;
    private File file;
    private ObjectOutputStream oos;

    public WritingThread(JTextArea txtaMessage, String sender, File file, ObjectOutputStream oos) {
        this.txtaMessage = txtaMessage;
        this.sender = sender;
        this.file = file;
        this.oos = oos;
    }

    @Override
    public void run() {
        try {
            String message = "\n" + sender + ": " + txtaMessage.getText();
            AttachmentDTO attachmentDTO = new AttachmentDTO(message, file);
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
