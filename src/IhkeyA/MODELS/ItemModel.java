/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IhkeyA.MODELS;

import IhkeyA.UTILS.DBConnection;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ItemModel {
        
    private Integer id_item;
    private String item_name;
    private String description;
    private String category;
    private String size;
    private String price;
    private byte[] image;

    
    public ItemModel(){}
    
    public ItemModel(Integer id_item, String item_name, String description, String category, String size, String price, byte[] image) {
        this.id_item = id_item;
        this.item_name = item_name;
        this.description = description;
        this.category = category;
        this.size = size;
        this.price = price;
        this.image = image;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    
    
    //to insert item
    public void insertItem(ItemModel item){
        
        
        Connection conn = new DBConnection().setConnection();
        PreparedStatement ps;
        
        String sql = "INSERT INTO item (item_name, description, category, size, price, image)"
                + "VALUES (? ,?, ?, ?, ?, ?)";
        
        try {
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, item.getItem_name());
            ps.setString(2, item.getDescription());
            ps.setString(3, item.getCategory());
            ps.setString(4, item.getSize());
            ps.setString(5, item.getPrice());
            ps.setBytes(6, item.getImage());
            
            int rt = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item Added!");
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
     public void UpdateItem(ItemModel item, boolean withImage){
        
        
        Connection conn = new DBConnection().setConnection();
        PreparedStatement ps;
        
        String sql;
        
        //to update image
        if(withImage == true)
        {
            sql = "UPDATE item SET item_name = ?,"
                + " description = ?, "
                + "category = ?, "
                + "size = ?, "
                + "price = ?, "
                + "image = ?"
                + "WHERE id_item = ? ";
            
            
            try {
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, item.getItem_name());
            ps.setString(2, item.getDescription());
            ps.setString(3, item.getCategory());
            ps.setString(4, item.getSize());
            ps.setString(5, item.getPrice());
            ps.setInt(7, item.getId_item());
            ps.setBytes(6, item.getImage());
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Item Updated!");
            
            
            
            } catch (SQLException ex) {
            Logger.getLogger(ItemModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            sql = "UPDATE item SET item_name = ?,"
                + " description = ?, "
                + "category = ?, "
                + "size = ?, "
                + "price = ? "
                + "WHERE id_item = ? ";
            
            try {
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, item.getItem_name());
            ps.setString(2, item.getDescription());
            ps.setString(3, item.getCategory());
            ps.setString(4, item.getSize());
            ps.setString(5, item.getPrice());
            ps.setInt(6, item.getId_item());
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Item Updated!");
            
            
            
            } catch (SQLException ex) {
            Logger.getLogger(ItemModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        
        
    }
     
     
    public void deleteItem(ItemModel item){
        Connection conn = new DBConnection().setConnection();
        PreparedStatement ps;
        
        String sql = "DELETE FROM item WHERE id_item = ?";
        try {
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, getId_item());
            
            int responseLogout = JOptionPane.showConfirmDialog(null, "Are you sure?","Logout",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            
            
            if(responseLogout == JOptionPane.YES_NO_OPTION){
            ps.execute();
            JOptionPane.showMessageDialog(null, "Item Deleted!");
            }else{
                JOptionPane.showMessageDialog(null, "OK");
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    //to resize image item
    public ImageIcon resizePic(String picPath,byte[] BLOBpic, int width, int height){
       
        ImageIcon myImg;
        
        if(picPath != null){
          myImg = new ImageIcon(picPath); 
       }else{
          myImg = new ImageIcon(BLOBpic);  
        }
       
       Image img = myImg.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
       ImageIcon itemPicture = new ImageIcon(img);
       return itemPicture;
       
    }
    
    
    //browse file to import image
    public String browseImage(JLabel lbl){
        
        String path = "";
        JFileChooser filec = new JFileChooser();
        filec.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        //file extension
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("*.Images", "jpg", "png");
        filec.addChoosableFileFilter(fileFilter);
        
        int fileState = filec.showSaveDialog(null);
        
        //if user select file
        if (fileState == JFileChooser.APPROVE_OPTION){
            File selectedFile = filec.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            
            
            
            //display the image in the jlabel using resize image
            
            lbl.setIcon(resizePic(path,null,lbl.getWidth(), lbl.getHeight()));
            
            
        }else if (fileState == JFileChooser.CANCEL_OPTION){
            System.out.println("No Image Selected");
        }
        
        return path;
        
    }
    
    
    //array list item
    public ArrayList<ItemModel> ItemModelList(String query){
       
        ArrayList<ItemModel> itemlist = new ArrayList<>();
        
        Connection conn = new DBConnection().setConnection();
        Statement st;
        ResultSet rs;
        
        
        
        try {
            
            
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            ItemModel im;
            
            while(rs.next()){
                im = new ItemModel(rs.getInt("id_item"),
                                   rs.getString("item_name"),
                                   rs.getString("description"),
                                   rs.getString("category"),
                                   rs.getString("size"),
                                   rs.getString("price"),
                                   rs.getBytes("image"));
                
               itemlist.add(im); 
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return itemlist;
                
    }
    
    
    
}
