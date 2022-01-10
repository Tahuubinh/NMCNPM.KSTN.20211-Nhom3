package services;

import Bean.MuonTraBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

import models.CoSoVatChatModel;
import models.PhongBanModel;

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
	        ResultSet rs2 = preparedStatement1.executeQuery();
	        while(rs1.next()) {
	        	CoSoVatChatModel coSoVatChat = muonTraBean.getCoSoVatChatModel();
                coSoVatChat.setId(rs1.getInt("item_id"));
                coSoVatChat.setTenCoSoVatChat(rs1.getString("item_name"));
                coSoVatChat.setSoLuong(rs1.getInt("item_quantity"));
                coSoVatChat.setDonVi(rs1.getString("item_unit"));
                coSoVatChat.setSoLuongMuon(rs1.getInt("lended"));
                coSoVatChat.setSoLuongTrongKho(rs1.getInt("remain"));
	        }
	        while(rs2.next()) {
	        	PhongBanModel phongBan = muonTraBean.getPhongBanModel();
                phongBan.setId(rs2.getInt("infra_id"));
                phongBan.setTenPhongBan(rs2.getString("infra_name"));
                phongBan.setThoiGianSuDung(rs2.getString("thoigian"));
                phongBan.setLyDo(rs2.getString("reason"));
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
	        PreparedStatement preparedStatement2 = (PreparedStatement)connection.prepareStatement(query2);
	        ResultSet rs2 = preparedStatement1.executeQuery();
	        while(rs1.next()) {
	        	MuonTraBean muonTraBean = new MuonTraBean(); 
	        	CoSoVatChatModel coSoVatChat = muonTraBean.getCoSoVatChatModel();
                coSoVatChat.setId(rs1.getInt("item_id"));
                coSoVatChat.setTenCoSoVatChat(rs1.getString("item_name"));
                coSoVatChat.setSoLuong(rs1.getInt("item_quantity"));
                coSoVatChat.setDonVi(rs1.getString("item_unit"));
                coSoVatChat.setSoLuongMuon(rs1.getInt("lended"));
                coSoVatChat.setSoLuongTrongKho(rs1.getInt("remain"));
                list.add(muonTraBean);
	        }
	        while(rs2.next()) {
	        	MuonTraBean muonTraBean = new MuonTraBean(); 
	        	PhongBanModel phongBan = muonTraBean.getPhongBanModel();
                phongBan.setId(rs2.getInt("infra_id"));
                phongBan.setTenPhongBan(rs2.getString("infra_name"));
                phongBan.setThoiGianSuDung(rs2.getString("thoigian"));
                phongBan.setLyDo(rs2.getString("reason"));
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
	        ResultSet rs2 = preparedStatement1.executeQuery();
	        while(rs1.next()) {
	        	MuonTraBean muonTraBean = new MuonTraBean(); 
	        	CoSoVatChatModel coSoVatChat = muonTraBean.getCoSoVatChatModel();
                coSoVatChat.setId(rs1.getInt("item_id"));
                coSoVatChat.setTenCoSoVatChat(rs1.getString("item_name"));
                coSoVatChat.setSoLuong(rs1.getInt("item_quantity"));
                coSoVatChat.setDonVi(rs1.getString("item_unit"));
                coSoVatChat.setSoLuongMuon(rs1.getInt("lended"));
                coSoVatChat.setSoLuongTrongKho(rs1.getInt("remain"));
                list.add(muonTraBean);
	        }
	        while(rs2.next()) {
	        	MuonTraBean muonTraBean = new MuonTraBean(); 
	        	PhongBanModel phongBan = muonTraBean.getPhongBanModel();
                phongBan.setId(rs2.getInt("infra_id"));
                phongBan.setTenPhongBan(rs2.getString("infra_name"));
                phongBan.setThoiGianSuDung(rs2.getString("thoigian"));
                phongBan.setLyDo(rs2.getString("reason"));
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
