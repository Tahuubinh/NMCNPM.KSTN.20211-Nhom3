package services;

import Bean.MuonTraBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import models.MuonTraModel;


/**
 *
 * @author Hai
 */
public class MuonTraService {
    
    /* 
     * Ham lay ra 1 nguoi muon trong database thong qua id
     * id la cccd, tcc, hc
     * 
     */
    public MuonTraBean getMuonTra(String id) {
        MuonTraBean muonTraBean = new MuonTraBean(); 
        Connection connection;
        
        try {
			connection = MysqlConnection.getMysqlConnection();
			 
			String query1 = "SELECT s.event_no, r.user_name, r.cccd, r.user_phone, s.time_start, s.time_end, i.item_name, ir.item_number "
      			  + "FROM registers r JOIN itemregistered ir ON r.user_id = ir.user_id "
      			  + "JOIN schedule s ON ir.event_no = s.event_no JOIN item i ON i.item_id = ir.item_id "
      			  + "WHERE CAST(r.cccd AS string) = "
      			  + id;
			String query2 = "SELECT s.event_no, r.user_name, r.cccd, r.user_phone, s.time_start, s.time_end, i.infra_name "
			  		  + "FROM registers r JOIN infraregistered ir ON r.user_id = ir.user_id "
			  		  + "JOIN schedule s ON ir.event_no = s.event_no JOIN infrastructure i ON i.infra_id = ir.infra_id "
			  		  + "WHERE CAST(r.cccd AS string) = "
			  		  + id;
	        PreparedStatement preparedStatement1 = (PreparedStatement)connection.prepareStatement(query1);
	        ResultSet rs1 = preparedStatement1.executeQuery();
	        PreparedStatement preparedStatement2 = (PreparedStatement)connection.prepareStatement(query2);
	        ResultSet rs2 = preparedStatement2.executeQuery();
	        while(rs1.next()) {
	        	MuonTraModel muonTra = muonTraBean.getMuonTraModel();
	        	muonTra.setStt(rs1.getInt("event_no"));
	        	muonTra.setTenNguoiMuon(rs1.getString("user_name"));
	        	muonTra.setid(rs1.getString("cccd"));
	        	muonTra.setLienHe(rs1.getString("user_phone"));
	        	muonTra.setThoiGianMuon(rs1.getTimestamp("time_start"));
	        	muonTra.setThoiGianTra(rs1.getTimestamp("time_end"));
	        	muonTra.setCoSoVatChat(rs1.getString("item_name"));
	        	muonTra.setSoLuong(rs1.getInt("item_number"));
	        }
	        while(rs2.next()) {
	        	MuonTraModel muonTra = muonTraBean.getMuonTraModel();
	        	muonTra.setStt(rs1.getInt("event_no"));
	        	muonTra.setTenNguoiMuon(rs1.getString("user_name"));
	        	muonTra.setid(rs1.getString("cccd"));
	        	muonTra.setLienHe(rs1.getString("user_phone"));
	        	muonTra.setThoiGianMuon(rs1.getTimestamp("time_start"));
	        	muonTra.setThoiGianTra(rs1.getTimestamp("time_end"));
	        	muonTra.setCoSoVatChat(rs1.getString("infra_name"));
	        	muonTra.setSoLuong(1);
	        }
	        preparedStatement1.close();
	        preparedStatement2.close();
	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        return muonTraBean;
    }
    
     // lay danh sach nguoi muon
    public List<MuonTraBean> getListMuonTra() {
    	
    	List<MuonTraBean> list = new ArrayList<>();
        Connection connection;
        
        try {
			connection = MysqlConnection.getMysqlConnection();						
	        String query1 = "SELECT s.event_no, r.user_name, r.cccd, r.user_phone, s.time_start, s.time_end, i.item_name, ir.item_number "
	  			  		  + "FROM registers r JOIN itemregistered ir ON r.user_id = ir.user_id "
	  			  		  + "JOIN schedule s ON ir.event_no = s.event_no JOIN item i ON i.item_id = ir.item_id ";
	        String query2 = "SELECT s.event_no, r.user_name, r.cccd, r.user_phone, s.time_start, s.time_end, i.infra_name "
			  		  	  + "FROM registers r JOIN infraregistered ir ON r.user_id = ir.user_id "
			  		  	  + "JOIN schedule s ON ir.event_no = s.event_no JOIN infrastructure i ON i.infra_id = ir.infra_id ";
	        PreparedStatement preparedStatement1 = (PreparedStatement)connection.prepareStatement(query1);
	        ResultSet rs1 = preparedStatement1.executeQuery();

	        while(rs1.next()) {
	        	MuonTraBean muonTraBean = new MuonTraBean(); 
	        	MuonTraModel muonTra = muonTraBean.getMuonTraModel();
	        	muonTra.setStt(rs1.getInt("event_no"));
	        	muonTra.setTenNguoiMuon(rs1.getString("user_name"));
	        	muonTra.setid(rs1.getString("cccd"));
	        	muonTra.setLienHe(rs1.getString("user_phone"));
	        	muonTra.setThoiGianMuon(rs1.getTimestamp("time_start"));
	        	muonTra.setThoiGianTra(rs1.getTimestamp("time_end"));
	        	muonTra.setCoSoVatChat(rs1.getString("item_name"));
	        	muonTra.setSoLuong(rs1.getInt("item_number"));
                list.add(muonTraBean);
	        }
	        preparedStatement1 = (PreparedStatement)connection.prepareStatement(query2);
	        rs1 = preparedStatement1.executeQuery();
	        while(rs1.next()) {
	        	MuonTraBean muonTraBean = new MuonTraBean(); 
	        	MuonTraModel muonTra = muonTraBean.getMuonTraModel();
	        	muonTra.setStt(rs1.getInt("event_no"));
	        	muonTra.setTenNguoiMuon(rs1.getString("user_name"));
	        	muonTra.setid(rs1.getString("cccd"));
	        	muonTra.setLienHe(rs1.getString("user_phone"));
	        	muonTra.setThoiGianMuon(rs1.getTimestamp("time_start"));
	        	muonTra.setThoiGianTra(rs1.getTimestamp("time_end"));
	        	muonTra.setCoSoVatChat(rs1.getString("infra_name"));
	        	muonTra.setSoLuong(1);
                list.add(muonTraBean);
	        }
	        preparedStatement1.close();
	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        return list;
    }
    
    //danh sach nguoi muon, phuc vu cho viec search
    public List<MuonTraBean> statisticMuonTra(String tenNguoiMuon, String lienHe, Date tuNgay, Date denNgay) {
        List<MuonTraBean> list = new ArrayList<>();
        //viết truy vấn
        return list;
    }
    
    /*
     * ham tim kiem nhan khau theo ten, lien he, tu ngay, den ngay
     */
    public List<MuonTraBean> search(String tenNguoiMuon, String lienHe, Date tuNgay, Date denNgay) {
        List<MuonTraBean> list = new  ArrayList<>();
        
        Connection connection;
        
        try {
			connection = MysqlConnection.getMysqlConnection();						
			String query1 = "SELECT s.event_no, r.user_name, r.cccd, r.user_phone, s.time_start, s.time_end, i.item_name, ir.item_number "
			    	  + "FROM registers r JOIN itemregistered ir ON r.user_id = ir.user_id "
			    	  + "JOIN schedule s ON ir.event_no = s.event_no JOIN item i ON i.item_id = ir.item_id "
			    	  + "WHERE r.user_name LIKE '%"
			    	  + tenNguoiMuon
			    	  + "%' AND CAST(r.user_phone as string) = "
			    	  + lienHe
			    	  + " AND CAST(s.time_start as date) BETWEEN "
			    	  + tuNgay
			    	  + " AND "
			    	  + denNgay;
      String query2 = "SELECT s.event_no, r.user_name, r.cccd, r.user_phone, s.time_start, s.time_end, i.infra_name "
		  		  	  + "FROM registers r JOIN infraregistered ir ON r.user_id = ir.user_id "
		  		  	  + "JOIN schedule s ON ir.event_no = s.event_no JOIN infrastructure i ON i.infra_id = ir.infra_id "
		  		  	  + "WHERE r.user_name LIKE '%"
			    	  + tenNguoiMuon
			    	  + "%' AND CAST(r.user_phone as string) = "
			    	  + lienHe
			    	  + " AND CAST(s.time_start as date) BETWEEN "
			    	  + tuNgay
			    	  + " AND "
			    	  + denNgay;
	        PreparedStatement preparedStatement1 = (PreparedStatement)connection.prepareStatement(query1);
	        ResultSet rs1 = preparedStatement1.executeQuery();
	        PreparedStatement preparedStatement2 = (PreparedStatement)connection.prepareStatement(query2);
	        ResultSet rs2 = preparedStatement2.executeQuery();
	        while(rs1.next()) {
	        	MuonTraBean muonTraBean = new MuonTraBean(); 
	        	MuonTraModel muonTra = muonTraBean.getMuonTraModel();
	        	muonTra.setStt(rs1.getInt("event_no"));
	        	muonTra.setTenNguoiMuon(rs1.getString("user_name"));
	        	muonTra.setid(rs1.getString("cccd"));
	        	muonTra.setLienHe(rs1.getString("user_phone"));
	        	muonTra.setThoiGianMuon(rs1.getTimestamp("time_start"));
	        	muonTra.setThoiGianTra(rs1.getTimestamp("time_end"));
	        	muonTra.setCoSoVatChat(rs1.getString("item_name"));
	        	muonTra.setSoLuong(rs1.getInt("item_number"));
                list.add(muonTraBean);
	        }
	        while(rs2.next()) {
	        	MuonTraBean muonTraBean = new MuonTraBean(); 
	        	MuonTraModel muonTra = muonTraBean.getMuonTraModel();
	        	muonTra.setStt(rs1.getInt("event_no"));
	        	muonTra.setTenNguoiMuon(rs1.getString("user_name"));
	        	muonTra.setid(rs1.getString("cccd"));
	        	muonTra.setLienHe(rs1.getString("user_phone"));
	        	muonTra.setThoiGianMuon(rs1.getTimestamp("time_start"));
	        	muonTra.setThoiGianTra(rs1.getTimestamp("time_end"));
	        	muonTra.setCoSoVatChat(rs1.getString("infra_name"));
	        	muonTra.setSoLuong(1);
                list.add(muonTraBean);
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
     * Ham sử lý ngoại lệ : thông báo ra lỗi nhận được
     */
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
