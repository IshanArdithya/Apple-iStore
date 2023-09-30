/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package apple.istore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Heoug
 */
public class PanelCreateAccounts extends javax.swing.JInternalFrame {

    File f = new File("\\iStoreApp\\Database");
    int ln;
    String Username, Password;
    
    /**
     * Creates new form PanelCreateAccounts
     */
    public PanelCreateAccounts() {
        initComponents();
        
        //removes borderline of the InternalFrame window.
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
    }
    
    void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
    }
    
    void readFile(){
        try {
            FileReader fr = new FileReader(f+"\\accounts.txt");
            System.out.println("file exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f+"\\accounts.txt");
                System.out.println("File created");
                        } catch (IOException ex1) {
                Logger.getLogger(Loginportal.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } 
    }
    
    
    void addData(String userr, String passw){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\accounts.txt", "rw");
            for(int i=0;i<ln;i++){
                raf.readLine();
            }
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            raf.writeBytes("Username:"+userr+"\r\n");
            raf.writeBytes("Password:"+passw);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loginportal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Loginportal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void countLines(){
        try {
            ln=1;
            RandomAccessFile raf = new RandomAccessFile(f+"\\accounts.txt", "rw");
            for(int i=0;raf.readLine()!=null;i++){
                ln++;
            }
            System.out.println("number of lines:"+ln);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loginportal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Loginportal.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        setUsername = new javax.swing.JTextField();
        setPassword = new javax.swing.JPasswordField();
        jUserRegister = new javax.swing.JButton();
        jUsernameError = new javax.swing.JLabel();
        jPasswordError = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 490));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(242, 242, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(251, 251, 251));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 490));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 0, 24)); // NOI18N
        jLabel1.setText("Create a New Account");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 22, -1, -1));

        jLabelPassword.setFont(new java.awt.Font("SF Pro Display", 0, 17)); // NOI18N
        jLabelPassword.setText("Password");
        jPanel2.add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        jLabelUsername.setFont(new java.awt.Font("SF Pro Display", 0, 17)); // NOI18N
        jLabelUsername.setText("Username");
        jPanel2.add(jLabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));
        jPanel2.add(setUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 210, 40));
        jPanel2.add(setPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 210, 40));

        jUserRegister.setBackground(new java.awt.Color(0, 0, 0));
        jUserRegister.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        jUserRegister.setForeground(new java.awt.Color(255, 255, 255));
        jUserRegister.setText("Register");
        jUserRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUserRegisterActionPerformed(evt);
            }
        });
        jPanel2.add(jUserRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 100, 30));

        jUsernameError.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        jUsernameError.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(jUsernameError, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 180, 20));

        jPasswordError.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        jPasswordError.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(jPasswordError, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 180, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 800, 490));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jUserRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUserRegisterActionPerformed
        
        if(setUsername.getText().equals("")){
            jUsernameError.setText("Username can't be Empty!"); // Update the error message label
            jPasswordError.setText(""); // Update the error message label
        }
        else if(setPassword.getText().equals("")){
            jUsernameError.setText(""); // Update the error message label
            jPasswordError.setText("Password can't be Empty"); // Update the error message label
        }
        else{
        
        createFolder();
        readFile();
        countLines();
        addData(setUsername.getText(),setPassword.getText());
        jUsernameError.setText(""); // Update the error message label
        jPasswordError.setText(""); // Update the error message label
        JOptionPane.showMessageDialog(null, "Account Created Successfully!");
        }
    }//GEN-LAST:event_jUserRegisterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jPasswordError;
    private javax.swing.JButton jUserRegister;
    private javax.swing.JLabel jUsernameError;
    private javax.swing.JPasswordField setPassword;
    private javax.swing.JTextField setUsername;
    // End of variables declaration//GEN-END:variables
}