/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package apple.istore;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.JOptionPane;

/**
 *
 * @author Heoug
 */

public class Loginportal extends javax.swing.JFrame {

    File f = new File("\\iStoreApp\\Database");
    int ln;
    String Username, Password;
    /**
     * Creates new form Loginportal
     */
    public Loginportal() {
        initComponents();
        centerWindow();
        this.jLabelPwInvisible.setVisible(false);
        
        //add placeholder style for username, pw text
        addPlaceholderStyle (txtUsername);
        addPlaceholderStyle (txtPassword);
    }
    //creates folder if it doesn't exists
    void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
    }
    //reads text file
    void readFile(){
        try {
            FileReader fr = new FileReader(f+"\\accounts.txt");
            System.out.println("file exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f+"\\accounts.txt");
                System.out.println("File created");
                
                // When you're opening this application for the first time,
                // It will create the text file along with the below Manager Account.
                addData("M.Admin","1234");
                
                        } catch (IOException ex1) {
                Logger.getLogger(Loginportal.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } 
    }
    //add Data to the accounts.txt
    void addData(String userr, String passw){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\accounts.txt", "rw");
            for(int i=0;i<ln;i++){
                raf.readLine();
            }
            raf.writeBytes("Username:"+userr+"\r\n");
            raf.writeBytes("Password:"+passw);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loginportal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Loginportal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Reads accounts.txt and compares login details and make a decision.
    // Reminder to myself: There was a bug in the previous void logic. so i implemented a new one.
    // now there's no issue even if there's blank spaces in the code.
 
    void logic(String userr, String passw){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\accounts.txt", "rw");
            for(int i=0;i<ln;i+=3){
                String forUser = raf.readLine().substring(9); //starts reading after skipping 9 characters.
                String forPassword = raf.readLine().substring(9); //starts reading after skipping 9 characters.
                
                if (forUser.startsWith("M.")) { // Manager accounts starts with "M.", then Manager accounts can identify seperately and show Manager UI.
                    if (userr.equals(forUser) && passw.equals(forPassword)) {
                    
                    dispose(); // Close Current UI
                    
                    // Open Manager UI
                    ManagerUI managerUI = new ManagerUI();
                    managerUI.setVisible(true);
                    }
                } else { // Cashier login
                if (userr.equals(forUser) && passw.equals(forPassword)) { 
                    // Cashier account Usernames can start with any letter. Usernames that doesn't starts with "M." gets Cashier UI.
                    
                    dispose(); // Close Current UI
                    
                    // Open Cashier UI
                    CashierUI cashierUI = new CashierUI();
                    cashierUI.setVisible(true);
                    }
                }
                if(i==(ln-3)) {
                    jLabelErrorMsg.setText("Incorrect User/Password"); // Update the error message label
                }
                for(int k=1;k<=1;k++){
                    raf.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loginportal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Loginportal.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    //count lines and set the pointer ( to prevent overwrite issues ).
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

    // create seperate methods to add/remove placeholder style.
    
    public void addPlaceholderStyle (JTextField textField){
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.gray); // font color
    }
    
    public void removePlaceholderStyle (JTextField textField){
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN|Font.BOLD);
        textField.setFont(font);
        textField.setForeground(Color.black); // font color
    }
    
    private void centerWindow() { // to make the program always open at middle of the screen
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = getWidth();
        int frameHeight = getHeight();
        setLocation((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtPassword = new javax.swing.JPasswordField();
        jLabelPwVisible = new javax.swing.JLabel();
        jLabelPwInvisible = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelExit = new javax.swing.JLabel();
        jLabelMinimize = new javax.swing.JLabel();
        jMovePanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabelErrorMsg = new javax.swing.JLabel();
        jLabelBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sign in your account");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 153, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        txtUsername.setText("Username");
        txtUsername.setBorder(null);
        txtUsername.setName(""); // NOI18N
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 194, 240, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        txtPassword.setText("Password");
        txtPassword.setBorder(null);
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });

        jLabelPwVisible.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPwVisible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Eye.png"))); // NOI18N
        jLabelPwVisible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelPwVisibleMousePressed(evt);
            }
        });

        jLabelPwInvisible.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPwInvisible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/EyeCross.png"))); // NOI18N
        jLabelPwInvisible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelPwInvisibleMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPwInvisible, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelPwVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPwInvisible, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPwVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 237, 240, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Apple Logo_1.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 87, -1, -1));

        jLabelExit.setBackground(new java.awt.Color(255, 255, 255));
        jLabelExit.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabelExit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelExit.setText("X");
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 40, 30));

        jLabelMinimize.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabelMinimize.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinimize.setText("-");
        jLabelMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 40, 30));

        jMovePanel.setBackground(new java.awt.Color(26, 28, 29));
        jMovePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jMovePanelMouseDragged(evt);
            }
        });
        jMovePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMovePanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jMovePanelLayout = new javax.swing.GroupLayout(jMovePanel);
        jMovePanel.setLayout(jMovePanelLayout);
        jMovePanelLayout.setHorizontalGroup(
            jMovePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        jMovePanelLayout.setVerticalGroup(
            jMovePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jMovePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 90, 30));

        jLabelErrorMsg.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        jLabelErrorMsg.setForeground(new java.awt.Color(204, 0, 0));
        jLabelErrorMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelErrorMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 170, 20));

        jLabelBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Black800x500.png"))); // NOI18N
        getContentPane().add(jLabelBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 750, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        // TODO add your handling code here:
        if(txtUsername.getText().equals("Username")){
            txtUsername.setText(null);
            txtUsername.requestFocus();
            //remove placeholder style
            removePlaceholderStyle(txtUsername);
        }
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        // TODO add your handling code here:
        if(txtPassword.getText().equals("Password")){
            txtPassword.setText(null);
            txtPassword.requestFocus();
            //set password character
            txtPassword.setEchoChar('\u2022');  //black dots - \uu25CF
            //remove placeholder style
            removePlaceholderStyle(txtPassword);
            
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        // TODO add your handling code here:
        if(txtUsername.getText().length()==0){
            //add placeholder style
            addPlaceholderStyle(txtUsername);
            txtUsername.setText("Username");
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        // TODO add your handling code here:
        if(txtPassword.getText().length()==0){
            addPlaceholderStyle(txtPassword);
            txtPassword.setText("Password");
            txtPassword.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        this.requestFocusInWindow();
    }//GEN-LAST:event_formWindowGainedFocus

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        // TODO add your handling code here:
        System.exit(0); // exit the application
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jLabelMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseClicked
        // TODO add your handling code here:
        setState(Loginportal.ICONIFIED); // minimizes this application
    }//GEN-LAST:event_jLabelMinimizeMouseClicked
        
    // To Drag and Move the application
    private int xMouse,yMouse;
    private void jMovePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMovePanelMousePressed
        // TODO add your handling code here:
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_jMovePanelMousePressed

    private void jMovePanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMovePanelMouseDragged
        // TODO add your handling code here:
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_jMovePanelMouseDragged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        createFolder();
        readFile();
        countLines();
        //addData("nilesh","1234");  test
        //CheckData("nilesh", "1234"); Just to test if the code works
        logic(txtUsername.getText(), txtPassword.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabelPwVisibleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPwVisibleMousePressed
        jLabelPwInvisible.setVisible(true);
        jLabelPwVisible.setVisible(false);
        txtPassword.setEchoChar((char)0); // sets password to char
    }//GEN-LAST:event_jLabelPwVisibleMousePressed

    private void jLabelPwInvisibleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPwInvisibleMousePressed
        jLabelPwVisible.setVisible(true);
        jLabelPwInvisible.setVisible(false);
        txtPassword.setEchoChar('\u2022'); // sets passwod to black dots
    }//GEN-LAST:event_jLabelPwInvisibleMousePressed

    /**s
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
            java.util.logging.Logger.getLogger(Loginportal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loginportal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loginportal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loginportal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loginportal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBg;
    private javax.swing.JLabel jLabelErrorMsg;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JLabel jLabelPwInvisible;
    private javax.swing.JLabel jLabelPwVisible;
    private javax.swing.JPanel jMovePanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
