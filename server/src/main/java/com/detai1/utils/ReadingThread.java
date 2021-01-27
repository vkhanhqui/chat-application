/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detai1.utils;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedHashSet;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author X507U-PC
 */
public class ReadingThread extends Thread {

    private JTextArea txtaChatBox;
    private UserConnection userConnection;
    private LinkedHashSet<UserConnection> userConnections;
    private JTextField txtUsersConn;

    public ReadingThread(JTextArea txtaChatBox, UserConnection userConnection,
            LinkedHashSet<UserConnection> userConnections, JTextField txtUsersConn) {
        this.txtaChatBox = txtaChatBox;
        this.userConnection = userConnection;
        this.userConnections = userConnections;
        this.txtUsersConn = txtUsersConn;
    }

    @Override
    public void run() {
        try {
            Socket socket = userConnection.getSocket();
            ObjectInputStream ois = userConnection.getObjectInputStream();
            while (true) {
                txtUsersConn.setText("0" + userConnections.size());
                AttachmentDTO attachmentDTO = (AttachmentDTO) ois.readObject();
                if (attachmentDTO.getMessage().equals("exit")) {
                    String alert = "\nUser " + userConnection.getUsername()
                            + " exited";
                    txtaChatBox.append(alert);
                    userConnections.remove(userConnection);
                    txtUsersConn.setText("0" + userConnections.size());
                    ois.close();
                    socket.close();
                } else {
                    String customReceivedMessage = "\n" + userConnection.getUsername()
                            + ": " + attachmentDTO.getMessage();
                    txtaChatBox.append(customReceivedMessage);
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
            }
        } catch (IOException | ClassNotFoundException ex) {
//            JOptionPane.showMessageDialog(txtaChatBox, ex.getMessage());
        }
    }

}
