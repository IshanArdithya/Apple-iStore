/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package apple.istore;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Heoug
 */
public class PanelProducts extends javax.swing.JInternalFrame {
    
    File p = new File("\\iStoreApp\\Database");
    int ln;
    String sProducts,sCategory,sStocks,sPrice;

    /**
     * Creates new form PanelProducts
     */
    public PanelProducts() {
        initComponents();
        
        //removes borderline of the InternalFrame window.
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        addPlaceholderStyle (jTextSearch);
    }
    
    void pCreateFolder(){
        if(!p.exists()){
            p.mkdirs();
        }
    }
    
    void pAddData(String productss, String categoryy, String stockss, String pricee){
        try {
            RandomAccessFile raf = new RandomAccessFile(p+"\\products.txt", "rw");
            for(int i=0;i<ln;i++){
                raf.readLine();
            }
            raf.writeBytes("Products:"+productss+"\r\n");
            raf.writeBytes("Category:"+categoryy+"\r\n");
            raf.writeBytes("Stocks:"+stockss+"\r\n");
            raf.writeBytes("Price:"+pricee+"\r\n");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loginportal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Loginportal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void pCountLines(){
        try {
            ln=1;
            RandomAccessFile raf = new RandomAccessFile(p+"\\products.txt", "rw");
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
    
    //i implemented this to "Refresh" ( jPanelRefresh ).. have to press the label to get the product list from products.txt
    void loadProductData() {
    File file = new File("\\iStoreApp\\Database\\products.txt");
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Clear existing table data
    
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        String[] rowData = new String[4];
        
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(":");
            String key = parts[0].trim();
            String value = parts[1].trim();
            
            switch (key) {
                case "Products":
                    rowData[0] = value;
                    break;
                case "Category":
                    rowData[1] = value;
                    break;
                case "Stocks":
                    rowData[2] = value;
                    break;
                case "Price":
                    rowData[3] = "LKR " + value;
                    model.addRow(rowData.clone());
                    break;
            }
        }
        // Set up TableRowSorter for jTable1
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);
        
        // Config custom comparators for Price and Stocks columns
        Comparator<String> priceComparator = Comparator.comparingDouble(this::parsePrice);
        Comparator<String> stocksComparator = Comparator.comparingInt(this::parseStocks);
        
        // Set the custom comparators for Price and Stocks columns
        sorter.setComparator(3, priceComparator);
        sorter.setComparator(2, stocksComparator);
        
        // Table always Sort by default column (Products)
        sorter.setSortKeys(List.of(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
        sorter.sort();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    private double parseDoubleValue(String value) {
    return Double.parseDouble(value.replace("LKR ", ""));
    }

    private int parseIntValue(String value) {
    return Integer.parseInt(value);
    }
    
    private double parsePrice(String value) {
    try {
        return parseDoubleValue(value);
    } catch (NumberFormatException e) {
        e.printStackTrace();
    }
    return 0;
    }

    private int parseStocks(String value) {
        try {
            return parseIntValue(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    // Can filter products from product names.
private void filterTable(String searchText) {
    TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) jTable1.getRowSorter();
    
    if (searchText.trim().isEmpty()) {
        // If the search text is empty, remove any existing filters
        sorter.setRowFilter(null);
    } else {
        // Create a RowFilter based on the search text
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText, 0);
        sorter.setRowFilter(rowFilter);
    }
}

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
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanelRefresh = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTextSearch = new javax.swing.JTextField();
        jLabelSearch = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(242, 242, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(251, 251, 251));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 490));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Products", "Category", "Stocks", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jScrollPane1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 800, 440));

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel1.setText("Refresh to get the Product Details");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 30));

        jPanelRefresh.setBackground(new java.awt.Color(251, 251, 251));
        jPanelRefresh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanelRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelRefreshMouseClicked(evt);
            }
        });
        jPanelRefresh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanelRefreshKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Refresh.png"))); // NOI18N
        jLabel3.setText("Refresh");

        javax.swing.GroupLayout jPanelRefreshLayout = new javax.swing.GroupLayout(jPanelRefresh);
        jPanelRefresh.setLayout(jPanelRefreshLayout);
        jPanelRefreshLayout.setHorizontalGroup(
            jPanelRefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRefreshLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelRefreshLayout.setVerticalGroup(
            jPanelRefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanelRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, 30));

        jPanel4.setBackground(new java.awt.Color(251, 251, 251));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextSearch.setText("Search Product Name");
        jTextSearch.setVerifyInputWhenFocusTarget(false);
        jTextSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextSearchFocusLost(evt);
            }
        });
        jPanel4.add(jTextSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 170, 30));

        jLabelSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/SearchProperty.png"))); // NOI18N
        jLabelSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSearchMouseClicked(evt);
            }
        });
        jPanel4.add(jLabelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 25, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 210, 30));

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

    private void jPanelRefreshKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanelRefreshKeyPressed
        
    }//GEN-LAST:event_jPanelRefreshKeyPressed

    private void jPanelRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelRefreshMouseClicked
        loadProductData();
        //jTextSearch.setText("");
        //if(jTextSearch.getText().length()==0){
            //add placeholder style
            //addPlaceholderStyle(jTextSearch);
            //jTextSearch.setText("Search Product Name");
        //}
    }//GEN-LAST:event_jPanelRefreshMouseClicked

    private void jLabelSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSearchMouseClicked
        String searchText = jTextSearch.getText();
        filterTable(searchText);
    }//GEN-LAST:event_jLabelSearchMouseClicked

    private void jTextSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextSearchFocusGained
        if(jTextSearch.getText().equals("Search Product Name")){
            jTextSearch.setText(null);
            jTextSearch.requestFocus();
            //remove placeholder style
            removePlaceholderStyle(jTextSearch);
        }
    }//GEN-LAST:event_jTextSearchFocusGained

    private void jTextSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextSearchFocusLost
        if(jTextSearch.getText().length()==0){
            //add placeholder style
            addPlaceholderStyle(jTextSearch);
            jTextSearch.setText("Search Product Name");
        }
    }//GEN-LAST:event_jTextSearchFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextSearch;
    // End of variables declaration//GEN-END:variables
}
