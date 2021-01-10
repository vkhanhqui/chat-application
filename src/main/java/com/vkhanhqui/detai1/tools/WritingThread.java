/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vkhanhqui.detai1.tools;

import java.io.DataOutputStream;
import java.io.IOException;
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
    private String name;

    public WritingThread(Socket socket, JTextArea txtaMessage, JRootPane rootPane, String name) {
        this.socket = socket;
        this.txtaMessage = txtaMessage;
        this.rootPane = rootPane;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String sms = txtaMessage.getText();
            dos.writeUTF("\n" + name + ": " + sms);
            dos.flush();
            if (sms.equals("exit")) {
                System.exit(0);
            }
            txtaMessage.setText("");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
}
