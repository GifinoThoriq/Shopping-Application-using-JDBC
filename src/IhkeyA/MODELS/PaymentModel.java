package IhkeyA.MODELS;


import IhkeyA.UTILS.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class PaymentModel {
    private Integer id_payment;
    private Integer id_user;
    private Integer id_item;
    private Integer quantity;
   
    private Date paymentDate;
    
    private Integer totalPayment;
    
    private String StatusPayment;

    public PaymentModel(){}
    
    public PaymentModel(Integer id_payment, Integer id_user, Integer id_item, Integer quantity, Date paymentDate, Integer totalPayment, String StatusPayment) {
        this.id_payment = id_payment;
        this.id_user = id_user;
        this.id_item = id_item;
        this.quantity = quantity;
        this.paymentDate = paymentDate;
        this.totalPayment = totalPayment;
        this.StatusPayment = StatusPayment;
    }

    public int getId_payment() {
        return id_payment;
    }

    public void setId_payment(int id_payment) {
        this.id_payment = id_payment;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }
    
    public String getStatusPayment(){
        return StatusPayment;
    }
    
    public void setStatusPayment(String StatusPayment){
        this.StatusPayment = StatusPayment;
    }
    
    public void insertPayment(PaymentModel payment){
        Connection conn = new DBConnection().setConnection();
        PreparedStatement ps;
        String sql = "INSERT INTO userpayment (id_user, id_item, quantity, paymentDate, totalPayment, StatusPayment)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, payment.getId_user());
            ps.setInt(2, payment.getId_item());
            ps.setInt(3, payment.getQuantity());
            ps.setDate(4, payment.getPaymentDate());
            ps.setInt(5, payment.getTotalPayment());
            ps.setString(6, payment.getStatusPayment());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Order added!");
        }catch(SQLException ex){
            Logger.getLogger(ItemModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updatePayment(PaymentModel payment){
        Connection conn = new DBConnection().setConnection();
        PreparedStatement ps;
        String sql = " UPDATE userpayment SET StatusPayment = 'sudah bayar'"
                + "WHERE id_user = ?";
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, payment.getId_user());

            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Order Finished, Terima Kasih Sudah Berbelanja!");
        }catch(SQLException ex){
            Logger.getLogger(ItemModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void deletePayment(PaymentModel payment){
        Connection conn = new DBConnection().setConnection();
        PreparedStatement ps;
        String sql = "DELETE FROM userpayment WHERE id_payment = ?";
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, payment.getId_payment());

            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item Dihapus!");
        }catch(SQLException ex){
            Logger.getLogger(ItemModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<PaymentModel> PaymentModelList(String query){
       
        ArrayList<PaymentModel> paymentmodel = new ArrayList<>();
        
        Connection conn = new DBConnection().setConnection();
        Statement st;
        ResultSet rs;
        
        
        
        try {
            
            
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            PaymentModel pm;
            
            while(rs.next()){
                pm = new PaymentModel(rs.getInt("id_payment"),
                                   rs.getInt("id_user"),
                                   rs.getInt("id_item"),
                                   rs.getInt("quantity"),
                                   rs.getDate("paymentDate"),
                                   rs.getInt("totalPayment"),
                                   rs.getString("StatusPayment"));
                                   
                
               paymentmodel.add(pm); 
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return paymentmodel;
                
    }
}
