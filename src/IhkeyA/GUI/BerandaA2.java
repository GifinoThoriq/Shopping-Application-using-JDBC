/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IhkeyA.GUI;

import IhkeyA.MODELS.ItemModel;
import IhkeyA.MODELS.ShowItem;
import IhkeyA.UTILS.DBConnection;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class BerandaA2 extends javax.swing.JFrame {
    
    static Connection conn;
    String imagePth = null;
    String sql;
    PreparedStatement ps;
    String tableQuery = "SELECT * FROM item";
    /**
     * Creates new form BerandaA2
     */
    public BerandaA2() {
        conn = new DBConnection().setConnection();
        initComponents();
        populateItemTable(tableQuery);
        tblItem.setShowGrid(true);
        tblItem.setSelectionBackground(Color.DARK_GRAY);
        tfIdItem.setEditable(false);
    }
    
    public void reset(){
        tfIdItem.setText("");
        tfItemName.setText("");
        tfSize.setText("");
        tfPrice.setText("");
        tfDescription.setText("");
        lbImage.setIcon(null);
        lbImage.revalidate();
    }
    
    
    public void populateItemTable(String query){
        
        ItemModel im = new ItemModel();
        ArrayList<ItemModel> itemlist = im.ItemModelList(query);
        String[] columnsName = {"id_item", "item name", "description", "category", "size", "price", "image"};
        Object[][] rows = new Object[itemlist.size()][7]; //sesuai dengan column yang ada
        
        for(int i = 0; i < itemlist.size() ; i++){
            rows[i][0] = itemlist.get(i).getId_item();
            rows[i][1] = itemlist.get(i).getItem_name();
            rows[i][2] = itemlist.get(i).getDescription();
            rows[i][3] = itemlist.get(i).getCategory();
            rows[i][4] = itemlist.get(i).getSize();
            rows[i][5] = itemlist.get(i).getPrice();
           
            ImageIcon pic = new ImageIcon(new ImageIcon(itemlist.get(i).getImage()).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            
            rows[i][6] = pic;
        }
        
        ShowItem si = new ShowItem(rows, columnsName);
        tblItem.setModel(si);
        tblItem.setRowHeight(100);
        tblItem.getColumnModel().getColumn(6).setPreferredWidth(100);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDelete1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfItemName = new javax.swing.JTextField();
        tfSize = new javax.swing.JTextField();
        tfPrice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfDescription = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        lbImage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        tfIdItem = new javax.swing.JTextField();
        cbSortCategory = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        btnDelete1.setText("DELETE");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 74, 173));
        jPanel1.setForeground(new java.awt.Color(0, 74, 173));

        tblItem.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_item", "item name", "description", "category", "size", "price", "image"
            }
        ));
        tblItem.setGridColor(new java.awt.Color(0, 0, 0));
        tblItem.setName(""); // NOI18N
        tblItem.setRowHeight(20);
        tblItem.setRowMargin(5);
        tblItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblItem);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("DASHBOARD PRODUCTS");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("LOGIN AS ADMINISTRATOR");

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setText("LOGOUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Product");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Item Name");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Size");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Price");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("General");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Description");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("Image");

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        lbImage.setOpaque(true);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Category");

        cbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Meja", "Kursi", "Lemari" }));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Id Item");

        tfIdItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdItemActionPerformed(evt);
            }
        });

        cbSortCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Meja", "Kursi", "Lemari" }));

        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfItemName)
                                    .addComponent(tfSize)
                                    .addComponent(tfPrice)
                                    .addComponent(cbCategory, 0, 100, Short.MAX_VALUE)
                                    .addComponent(tfIdItem))))
                        .addGap(253, 253, 253)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBrowse)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbSortCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addComponent(jButton1)
                    .addComponent(btnUpdate)
                    .addComponent(btnAdd)
                    .addComponent(btnRefresh))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tfItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(tfSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnAdd)
                        .addGap(12, 12, 12)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBrowse)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSortCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

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

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        // TODO add your handling code here:
        ItemModel im = new ItemModel();
        imagePth = im.browseImage(lbImage);
        System.out.println(imagePth);
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String Price = tfPrice.getText();
        String checkPrice = ".,";

        String itemName = tfItemName.getText();
        String Size = tfSize.getText();
        String Description = tfDescription.getText();
        String Category = cbCategory.getSelectedItem().toString();
        byte[] img = null;

        try {

            Path pth = Paths.get(imagePth);
            img = Files.readAllBytes(pth);

        } catch (FileNotFoundException ex) {

            Logger.getLogger(BerandaA2.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(BerandaA2.class.getName()).log(Level.SEVERE, null, ex);
        }

        ItemModel item = new ItemModel(null, itemName, Description, Category, Size, Price, img);
        item.insertItem(item);
        populateItemTable(tableQuery);
        tblItem.setShowGrid(true);
        tblItem.setSelectionBackground(Color.DARK_GRAY);
        reset();


    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoginScreen ls = new LoginScreen();
        this.dispose();
        ls.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemMouseClicked

        //get row index
        int rowIndexTable = tblItem.getSelectedRow();
        tfIdItem.setText(tblItem.getValueAt(rowIndexTable,0).toString());
        tfItemName.setText(tblItem.getValueAt(rowIndexTable, 1).toString());
        tfDescription.setText(tblItem.getValueAt(rowIndexTable, 2).toString());
        cbCategory.setSelectedItem(tblItem.getValueAt(rowIndexTable, 3));
        tfSize.setText(tblItem.getValueAt(rowIndexTable,4).toString());
        tfPrice.setText(tblItem.getValueAt(rowIndexTable, 5).toString());

        Image pic = ((ImageIcon)tblItem.getValueAt(rowIndexTable, 6)).getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(pic);
        
        tfIdItem.setEditable(false);
        
        lbImage.setIcon(img);
    }//GEN-LAST:event_tblItemMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int id_item = Integer.valueOf(tfIdItem.getText());
        String itemName = tfItemName.getText();
        String description = tfDescription.getText();
        String category = cbCategory.getSelectedItem().toString();
        String size = tfSize.getText();
        String price = tfPrice.getText();

        //to update image
        if(imagePth != null){
            byte[] img = null;

            try {
                Path pth = Paths.get(imagePth);
                img = Files.readAllBytes(pth);

                ItemModel it = new ItemModel(id_item, itemName, description, category, size, price, img);
                it.UpdateItem(it, true);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(BerandaA2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(BerandaA2.class.getName()).log(Level.SEVERE, null, ex);

            }
    }//GEN-LAST:event_btnUpdateActionPerformed

        else{
            ItemModel it = new ItemModel(id_item, itemName, description, category, size, price, null);
            it.UpdateItem(it, false);
            
        }
        
        populateItemTable(tableQuery);
        tblItem.setShowGrid(true);
        tblItem.setSelectionBackground(Color.DARK_GRAY);
         
    
    }
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int id_item = Integer.valueOf(tfIdItem.getText());
        ItemModel it = new ItemModel(id_item, null, null, null, null, null, null);
        it.deleteItem(it);
        populateItemTable(tableQuery);
        tblItem.setShowGrid(true);
        tblItem.setSelectionBackground(Color.DARK_GRAY);
        reset();
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        String category = cbSortCategory.getSelectedItem().toString();
        if(category.equals("Meja")){
            String searchQuery = "SELECT * FROM item WHERE category = '" + category + "'";
            populateItemTable(searchQuery);
        }else{
            if(category.equals("Kursi")){
               String searchQuery = "SELECT * FROM item WHERE category = '" + category + "'";
               populateItemTable(searchQuery); 
            }else{
                if(category.equals("Lemari")){
                    String searchQuery = "SELECT * FROM item WHERE category = '" + category + "'";
                    populateItemTable(searchQuery);
                }else{
                    String searchQuery = "SELECT * FROM item ";
                    populateItemTable(searchQuery);
                }
            }
            
        }
        
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tfIdItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdItemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tfIdItemActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        reset();
        String sql = "SELECT * FROM item";
        populateItemTable(sql);
    }//GEN-LAST:event_btnRefreshActionPerformed
        
    
    
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
            java.util.logging.Logger.getLogger(BerandaA2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BerandaA2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BerandaA2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BerandaA2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BerandaA2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JComboBox<String> cbSortCategory;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbImage;
    private javax.swing.JTable tblItem;
    private javax.swing.JTextField tfDescription;
    private javax.swing.JTextField tfIdItem;
    private javax.swing.JTextField tfItemName;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfSize;
    // End of variables declaration//GEN-END:variables
}
