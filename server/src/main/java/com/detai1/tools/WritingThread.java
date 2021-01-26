/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detai1.tools;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextArea;

/**
 *
 * @author X507U-PC
 */
public class WritingThread extends Thread {

    private Socket socket;
    private JTextArea txtaMessage;
    private JRootPane rootPane;
    private String sender;
    private File file;
    private ObjectOutputStream oos;

    public WritingThread(Socket socket, JTextArea txtaMessage, JRootPane rootPane, String sender, File file, ObjectOutputStream oos) {
        this.socket = socket;
        this.txtaMessage = txtaMessage;
        this.rootPane = rootPane;
        this.sender = sender;
        this.file = file;
        this.oos = oos;
    }

    @Override
    public void run() {
        try {
            AttachmentDTO attachmentDTO = new AttachmentDTO();
            String message = "\n" + sender + ": " + txtaMessage.getText();
            attachmentDTO.setMessage(message);
            attachmentDTO.setFile(file);
            oos.writeObject(attachmentDTO);
            oos.flush();
            if (txtaMessage.getText().equals("exit")) {
                System.exit(0);
            }
            txtaMessage.setText("");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
}
