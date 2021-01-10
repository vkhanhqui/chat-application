/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vkhanhqui.detai1;

import com.vkhanhqui.detai1.tools.ReadingThread;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author X507U-PC
 */
public class LoginForm extends javax.swing.JFrame {

    private Socket client;

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        btnLogin.setVisible(false);
        txtUsername.setVisible(false);
        txtPwd.setVisible(false);
        lbUsername.setVisible(false);
        lbPwd.setVisible(false);
        lbLogin.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbUsername = new javax.swing.JLabel();
        lbPwd = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtPwd = new javax.swing.JTextField();
        lbLogin = new javax.swing.JLabel();
        lbHost = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        lbPort = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        btnConn = new javax.swing.JButton();
        lbConn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUsername.setText("Username");

        lbPwd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPwd.setText("Password");

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        lbLogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbLogin.setText("Login");

        lbHost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbHost.setText("Server Host");

        lbPort.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPort.setText("Port");

        btnConn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConn.setText("Connect");
        btnConn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnActionPerformed(evt);
            }
        });

        lbConn.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbConn.setText("Connect server");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(lbLogin)
                                .addGap(18, 18, 18)
                                .addComponent(lbConn))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbPwd)
                                    .addComponent(lbUsername))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnLogin)
                                        .addGap(63, 63, 63))
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbHost)
                        .addGap(27, 27, 27)
                        .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbPort)
                        .addGap(18, 18, 18)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)))
                .addComponent(btnConn)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLogin)
                    .addComponent(lbConn))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHost)
                    .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPort)
                    .addComponent(btnConn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUsername))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPwd)
                    .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnLogin)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        boolean isLogged = false;
        try {
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dos.writeUTF(txtUsername.getText() + " " + txtPwd.getText());
            DataInputStream dis = new DataInputStream(client.getInputStream());
            isLogged = dis.readBoolean();
            dos.flush();
            if (isLogged == true) {
                this.setVisible(false);
                ClientForm cf = new ClientForm();
                cf.setClient(client);
                cf.setUsername(txtUsername.getText());
                cf.setVisible(true);
                Thread read = new ReadingThread(client, cf.getTxtaChatBox(), rootPane);
                read.start();
                JOptionPane.showMessageDialog(rootPane, "dang nhap thanh cong");
            } else {
                JOptionPane.showMessageDialog(rootPane, "tai khoan hoac mat khau sai");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnConnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnActionPerformed
        // TODO add your handling code here:
        try {
            //            int port = Integer.parseInt(txtPort.getText());
            client = new Socket(InetAddress.getLocalHost(), 9999);
            if (client.isConnected()) {
                btnLogin.setVisible(true);
                txtUsername.setVisible(true);
                txtPwd.setVisible(true);
                lbUsername.setVisible(true);
                lbPwd.setVisible(true);
                lbLogin.setVisible(true);
                btnConn.setVisible(false);
                lbConn.setVisible(false);
                lbHost.setVisible(false);
                lbPort.setVisible(false);
                txtHost.setVisible(false);
                txtPort.setVisible(false);
                JOptionPane.showMessageDialog(this, "connected");
            } else {
                JOptionPane.showMessageDialog(this, "could not connect");
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnConnActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConn;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lbConn;
    private javax.swing.JLabel lbHost;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbPort;
    private javax.swing.JLabel lbPwd;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JTextField txtHost;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtPwd;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    public Socket getSocket() {
        return client;
    }

    public void setSocket(Socket socket) {
        client = socket;
    }
}
