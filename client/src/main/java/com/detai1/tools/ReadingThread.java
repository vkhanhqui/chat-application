/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detai1.tools;

import java.io.DataInputStream;
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
import javax.swing.JTextArea;

/**
 *
 * @author X507U-PC
 */
public class ReadingThread extends Thread {

    private Socket socket;
    private JTextArea txtaChatBox;
    private JRootPane rootPane;
    private final Path rootLocation;

    public ReadingThread(Socket socket, JTextArea txtaChatBox, JRootPane rootPane) {
        this.socket = socket;
        this.txtaChatBox = txtaChatBox;
        this.rootPane = rootPane;
        this.rootLocation = Paths.get("archive");
    }

    @Override
    public void run() {
        try {
//            Files.createDirectories(rootLocation);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            File receive = (File) ois.readObject();
            Files.move(receive.toPath(),
                    rootLocation.resolve(Paths.get(receive.getName()))
                            .normalize()
                            .toAbsolutePath(),
                    StandardCopyOption.REPLACE_EXISTING);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while (true) {
                String sms = dis.readUTF();
                txtaChatBox.append(sms);
            }
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

}
