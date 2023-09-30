/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package apple.istore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Heoug
 */
public class PanelDeleteProducts extends javax.swing.JInternalFrame {

    File p = new File("\\iStoreApp\\Database");
    int ln;
    String sProducts,sCategory,sStocks,sPrice;
    
    /**
     * Creates new form PanelDeleteProducts
     */
    public PanelDeleteProducts() {
        initComponents();
        
        //removes borderline of the InternalFrame window.
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
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
        jLabel2 = new javax.swing.JLabel();
        jTFDeleteProduct = new javax.swing.JTextField();
        jButtonDelete = new javax.swing.JButton();
        jUserDeleteError = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(242, 242, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(251, 251, 251));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 490));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 0, 24)); // NOI18N
        jLabel1.setText("Delete Products");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 37, -1, -1));

        jLabel2.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        jLabel2.setText("Product Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        jTFDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDeleteProductActionPerformed(evt);
            }
        });
        jPanel2.add(jTFDeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 220, 40));

        jButtonDelete.setBackground(new java.awt.Color(0, 0, 0));
        jButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 120, 30));

        jUserDeleteError.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        jUserDeleteError.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(jUserDeleteError, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 140, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 800, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDeleteProductActionPerformed
        
    }//GEN-LAST:event_jTFDeleteProductActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        if(jTFDeleteProduct.getText().equals("")){
            jUserDeleteError.setText("Username can't be Empty!"); // Update the error message label
        }
        else{
        
        String productNameToDelete = jTFDeleteProduct.getText().trim(); // Get the product name to delete from the text field

    try {
        File productsFile = new File(p, "products.txt");
        File tempFile = new File(p, "temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(productsFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;

        // Read the file line by line
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Products:") && line.substring(9).equals(productNameToDelete)) {
                // Skip the lines corresponding to the product to be deleted
                reader.readLine();
                reader.readLine();
                reader.readLine();
            } else {
                // Write the line to the temporary file
                writer.write(line);
                writer.newLine();
            }
        }

        reader.close();
        writer.close();

        // Rename the temporary file to the original file
        if (productsFile.delete() && tempFile.renameTo(productsFile)) {
            JOptionPane.showMessageDialog(null, "Product Deleted Successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to Delete! Try Restarting the Application!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (IOException ex) {
        Logger.getLogger(PanelDeleteProducts.class.getName()).log(Level.SEVERE, null, ex);
    }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTFDeleteProduct;
    private javax.swing.JLabel jUserDeleteError;
    // End of variables declaration//GEN-END:variables
}
