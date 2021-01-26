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
import javax.swing.JRootPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author X507U-PC
 */
public class ReadingThread extends Thread {

    private StyledDocument sd;
    private JRootPane rootPane;
    private UserConnection userConnection;
    private LinkedHashSet<UserConnection> userConnections;

    public ReadingThread(StyledDocument sd, JRootPane rootPane, UserConnection userConnection,
            LinkedHashSet<UserConnection> userConnections) {
        this.sd = sd;
        this.rootPane = rootPane;
        this.userConnection = userConnection;
        this.userConnections = userConnections;
    }

    @Override
    public void run() {
        try {
            Socket socket = userConnection.getSocket();
            ObjectInputStream ois = userConnection.getObjectInputStream();
            while (true) {
                AttachmentDTO attachmentDTO = (AttachmentDTO) ois.readObject();
                if (attachmentDTO.getMessage().contains("exit")) {
                    userConnections.remove(userConnection);
                    ois.close();
                    socket.close();
                }
                sd.insertString(sd.getLength(), attachmentDTO.getMessage(), null);
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
        }
    }

}
