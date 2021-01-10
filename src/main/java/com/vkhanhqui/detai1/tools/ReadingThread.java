/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vkhanhqui.detai1.tools;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextArea;

/**
 *
 * @author X507U-PC
 */
public class ReadingThread extends Thread {

    private Socket socket;
    private JTextArea txtaChatBox;
    private JRootPane rootPane;

    public ReadingThread(Socket socket, JTextArea txtaChatBox, JRootPane rootPane) {
        this.socket = socket;
        this.txtaChatBox = txtaChatBox;
        this.rootPane = rootPane;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while (true) {
                String sms = dis.readUTF();
                txtaChatBox.append(sms);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

}
