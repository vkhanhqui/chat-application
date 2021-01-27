/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detai1;

import com.detai1.utils.UserConnection;
import com.detai1.utils.ReadingThread;
import com.detai1.utils.WritingThread;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author X507U-PC
 */
public class ServerForm extends javax.swing.JFrame {

    private ServerSocket server;
    private LinkedHashSet<UserConnection> userConnections;
    private JFileChooser jFileChooser;

    private void startingServer() {
        Thread serverStart = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Socket socket = server.accept();
                        if (socket.isConnected()) {
                            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                            UserConnection userConnection = new UserConnection(socket, ois, oos, "");
                            checkUserWhenSocketIsConnected(userConnection);
                        }
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
            }
        };
        serverStart.start();
    }

    private void checkUserWhenSocketIsConnected(UserConnection userConnection) {
        try {
            ObjectInputStream ois = userConnection.getObjectInputStream();
            ObjectOutputStream oos = userConnection.getObjectOutputStream();
            do {
                String get = ois.readUTF();
                String username = get.split(" ")[0];
                String pwd = get.split(" ")[1];
                //username.equals("1") && 
                if (pwd.equals("2")) {
                    oos.writeBoolean(true);
                    String status = "\n" + username + " is logging";
                    txtaChatBox.append(status);
                    userConnection.setUsername(username);
                    userConnections.add(userConnection);
                    oos.flush();
                    break;
                } else {
                    oos.writeBoolean(false);
                    oos.flush();
                }
            } while (true);
            Thread read = new ReadingThread(txtaChatBox, userConnection,
                    userConnections, txtUsersConn);
            read.start();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }

    }

    /**
     * Creates new form ServerForm
     */
    public ServerForm() {
        initComponents();
        formWhenInit();
    }

    private void formWhenInit() {
        try {
            jFileChooser = new JFileChooser();
            userConnections = new LinkedHashSet<>();
            server = new ServerSocket(9999);
            txtaMessage.setLineWrap(true);
            txtaChatBox.setLineWrap(true);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        btnListen = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtaMessage = new javax.swing.JTextArea();
        btnFile = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaChatBox = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        txtUsersConn = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Chat Server");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Port");

        btnListen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnListen.setText("Listen");
        btnListen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListenActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Message");

        btnSend.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        txtaMessage.setColumns(20);
        txtaMessage.setRows(5);
        jScrollPane3.setViewportView(txtaMessage);

        btnFile.setText("Choose File");
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });

        txtaChatBox.setColumns(20);
        txtaChatBox.setRows(5);
        jScrollPane2.setViewportView(txtaChatBox);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Users Connected");

        txtUsersConn.setEditable(false);
        txtUsersConn.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        txtUsersConn.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtUsersConn.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(48, 48, 48)
                                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnListen))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnFile)
                                                .addGap(333, 333, 333))
                                            .addComponent(jScrollPane3))))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUsersConn))
                            .addComponent(btnSend)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel3)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListen)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsersConn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSend)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnFile)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListenActionPerformed
        // TODO add your handling code here:
        txtaChatBox.setText("server is listening");
        startingServer();
    }//GEN-LAST:event_btnListenActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        if (userConnections.size() > 0 && txtaMessage.getText() != null) {
            for (UserConnection userConnection : userConnections) {
                ObjectOutputStream oos = userConnection.getObjectOutputStream();
                Thread write = new WritingThread(txtaMessage, "Server",
                        jFileChooser.getSelectedFile(), oos);
                write.start();
            }
            jFileChooser.cancelSelection();
            String message = "\nYou: " + txtaMessage.getText();
            txtaChatBox.append(message);
            txtaChatBox.selectAll();
            int bottom = txtaChatBox.getSelectionEnd();
            txtaChatBox.select(bottom, bottom);
        } else {
            JOptionPane.showMessageDialog(this, "Text could not be null");
        }

    }//GEN-LAST:event_btnSendActionPerformed

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        // TODO add your handling code here:
        jFileChooser.showOpenDialog(this);
        if (jFileChooser.getSelectedFile() != null) {
            txtaMessage.setText(jFileChooser.getSelectedFile().getName());
        }
    }//GEN-LAST:event_btnFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFile;
    private javax.swing.JButton btnListen;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtUsersConn;
    private javax.swing.JTextArea txtaChatBox;
    private javax.swing.JTextArea txtaMessage;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the server
     */
    public ServerSocket getServer() {
        return server;
    }

    /**
     * @param server the server to set
     */
    public void setServer(ServerSocket server) {
        this.server = server;
    }
}
