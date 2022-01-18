package services;

import Bean.LichSuBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import models.LichSuModel;

/**
 *
 * @author Hai
 */
public class LichSuService {
    
    /* 
     * Ham lay ra 1 nguoi muon trong database thong qua id
     * 
     */
    public LichSuBean getLichSu(String id) {
        LichSuBean LichSuBean = new LichSuBean();  
        
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query1 = "SELECT m.money_id, m.reason, i.item_name, m.item_number, m.date "
      			  + "FROM money m JOIN item i on m.item_id = i.item_id WHERE m.money_id = '"
      			  + id + "'";
            String query2 = "SELECT d.delete_id, d.reason, i.item_name, d.item_number, d.date "
        			  + "FROM deleteditem d JOIN item i on d.item_id = i.item_id WHERE d.delete_id = '"
        			  + id + "'";
            PreparedStatement preparedStatement1 = (PreparedStatement)connection.prepareStatement(query1);
            ResultSet rs1 = preparedStatement1.executeQuery();
            PreparedStatement preparedStatement2 = (PreparedStatement)connection.prepareStatement(query2);
            ResultSet rs2 = preparedStatement2.executeQuery();
            while (rs1.next()){
            	LichSuBean lichSuBean = new LichSuBean(); 
                LichSuModel lichSu = lichSuBean.getLichSuModel();
                lichSu.setStt(rs1.getInt("money_id"));
                lichSu.setLyDo(rs1.getString("reason"));
                lichSu.setDungCu(rs1.getString("item_name"));
                lichSu.setSoLuong(rs1.getInt("item_number"));
                lichSu.setThoiGian(rs1.getTimestamp("date"));
            }
            while (rs2.next()){
            	LichSuBean lichSuBean = new LichSuBean(); 
                LichSuModel lichSu = lichSuBean.getLichSuModel();
                lichSu.setStt(rs2.getInt("delete_id"));
                lichSu.setLyDo(rs2.getString("reason"));
                lichSu.setDungCu(rs2.getString("item_name"));
                lichSu.setSoLuong(rs2.getInt("item_number"));
                lichSu.setThoiGian(rs2.getTimestamp("date"));
            }
            preparedStatement1.close();
            preparedStatement2.close();
            connection.close();
        } catch (Exception e) {

        	this.exceptionHandle(e.getMessage());
        }
        return LichSuBean;
    }
    
     // lay danh sach nguoi muon
    public List<LichSuBean> getListLichSu() {
    	
        List<LichSuBean> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query1 = "SELECT m.money_id, m.reason, i.item_name, m.item_number, m.date "
      			  		  + "FROM money m JOIN item i on m.item_id = i.item_id";
            String query2 = "SELECT d.delete_id, d.reason, i.item_name, d.item_number, d.date "
        			  	  + "FROM deleteditem d JOIN item i ON d.item_id = i.item_id";
            PreparedStatement preparedStatement1 = (PreparedStatement)connection.prepareStatement(query1);
            ResultSet rs1 = preparedStatement1.executeQuery();
            PreparedStatement preparedStatement2 = (PreparedStatement)connection.prepareStatement(query2);
            ResultSet rs2 = preparedStatement2.executeQuery();
            while (rs1.next()){
            	LichSuBean lichSuBean = new LichSuBean(); 
                LichSuModel lichSu = lichSuBean.getLichSuModel();
                lichSu.setStt(rs1.getInt("money_id"));
                lichSu.setLyDo(rs1.getString("reason"));
                lichSu.setDungCu(rs1.getString("item_name"));
                lichSu.setSoLuong(rs1.getInt("item_number"));
                lichSu.setThoiGian(rs1.getTimestamp("date"));
                list.add(lichSuBean);
            }
            while (rs2.next()){
            	LichSuBean lichSuBean = new LichSuBean(); 
                LichSuModel lichSu = lichSuBean.getLichSuModel();
                lichSu.setStt(rs2.getInt("delete_id"));
                lichSu.setLyDo(rs2.getString("reason"));
                lichSu.setDungCu(rs2.getString("item_name"));
                lichSu.setSoLuong(rs2.getInt("item_number"));
                lichSu.setThoiGian(rs2.getTimestamp("date"));
                list.add(lichSuBean);
            }
            preparedStatement1.close();
            preparedStatement2.close();
            connection.close();
        } catch (Exception e) {

        	this.exceptionHandle(e.getMessage());
        }
        return list;
    }
    
    
    /*
     * ham tim kiem nhan khau theo ten, lien he, tu ngay, den ngay
     */
    public List<LichSuBean> search(Timestamp thoiGian, String status) {
        List<LichSuBean> list = new  ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query1 = "SELECT m.money_id, m.reason, i.item_name, m.item_number, m.date "
      			  		  + "FROM money m JOIN item i on m.item_id = i.item_id WHERE m.date >= '"
      			  		  + thoiGian + "'";
            String query2 = "SELECT d.delete_id, d.reason, i.item_name, d.item_number, d.date "
        			  	  + "FROM deleteditem d JOIN item i ON d.item_id = i.item_id WHERE d.date >= '"
        			  	  + thoiGian + "'";

            PreparedStatement preparedStatement1 = (PreparedStatement)connection.prepareStatement(query1);
            ResultSet rs1 = preparedStatement1.executeQuery();
            while (rs1.next()){
            	LichSuBean lichSuBean = new LichSuBean(); 
                LichSuModel lichSu = lichSuBean.getLichSuModel();
                lichSu.setStt(rs1.getInt("money_id"));
                lichSu.setLyDo(rs1.getString("reason"));
                lichSu.setDungCu(rs1.getString("item_name"));
                lichSu.setSoLuong(rs1.getInt("item_number"));
                lichSu.setThoiGian(rs1.getTimestamp("date"));
                if(status == "Toàn bộ" || status == "Đóng góp") list.add(lichSuBean);
            }
            preparedStatement1 = (PreparedStatement)connection.prepareStatement(query2);
            System.out.println(preparedStatement1);
            rs1 = preparedStatement1.executeQuery();
            while (rs1.next()){
            	LichSuBean lichSuBean = new LichSuBean(); 
                LichSuModel lichSu = lichSuBean.getLichSuModel();
                lichSu.setStt(rs1.getInt("delete_id"));
                lichSu.setLyDo(rs1.getString("reason"));
                lichSu.setDungCu(rs1.getString("item_name"));
                lichSu.setSoLuong(rs1.getInt("item_number"));
                lichSu.setThoiGian(rs1.getTimestamp("date"));
                System.out.println(rs1.getTimestamp("date"));
                if(status == "Toàn bộ" || status == "Loại bỏ") list.add(lichSuBean);
            }
            preparedStatement1.close();
            connection.close();
        } catch (Exception e) {

        	this.exceptionHandle(e.getMessage());
        }
        return list;
    }
    
    /*
     * Ham sử lý ngoại lệ : thông báo ra lỗi nhận được
     */
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }


}
