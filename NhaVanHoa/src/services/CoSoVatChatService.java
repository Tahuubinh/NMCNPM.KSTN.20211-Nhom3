package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import Bean.CoSoVatChatBean;
import models.CoSoVatChatModel;
import models.NguoiMuonModel;
import models.NhaTaiTroModel;
import models.ThoiGianModel;


public class CoSoVatChatService {
	
	//tra ve danh sach cac nguoi muon co so vat chat nay, cung voi thoi gian ho muon, tra ve danh sach nha tai tro co so vat chat neu co
	public CoSoVatChatBean getCoSoVatChatDetail(String tenCoSoVatChat) {
		Connection connection;
		CoSoVatChatBean coSoVatChatBean = new CoSoVatChatBean(); 
		List<NguoiMuonModel> listNguoiMuon = coSoVatChatBean.getListNguoiMuonModels();
		List<ThoiGianModel> listThoiGian = coSoVatChatBean.getListThoiGianModels();
		try {
			connection = MysqlConnection.getMysqlConnection();
			 
	        String query = "SELECT i.item_id, i.item_name, i.item_quantity, sum(coalesce((ir.item_number),0)) AS lended, (i.item_quantity-COALESCE(sum(ir.item_number), 0)) AS remain "
	   			 		 + "FROM item i JOIN itemregistered ir ON i.item_id=ir.item_id WHERE i.item_name = "
	   			 		 + tenCoSoVatChat
	   			 		 + " GROUP BY i.item_id";
	        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();
	        while(rs.next()) {
	        	CoSoVatChatModel coSoVatChat = coSoVatChatBean.getCoSoVatChatModel();
                coSoVatChat.setId(rs.getInt("item_id"));
                coSoVatChat.setTenCoSoVatChat(rs.getString("item_name"));
                coSoVatChat.setSoLuong(rs.getInt("item_quantity"));
                coSoVatChat.setSoLuongMuon(rs.getInt("lended"));
                coSoVatChat.setSoLuongTrongKho(rs.getInt("remain"));
	        }
	        preparedStatement.close();
	        
	        query = "SELECT ir.event_no, r.user_id, r.user_name, r.user_address, r.user_phone, r.fee_register, r.cccd FROM itemregistered ir "
	        	  + "LEFT JOIN registers r ON ir.user_id = r.user_id LEFT JOIN item i ON ir.item_id = i.item_id WHERE item_name = "
	        	  + tenCoSoVatChat;
	        preparedStatement = (PreparedStatement)connection.prepareStatement(query);
	        rs = preparedStatement.executeQuery();
	        
	        while(rs.next()) {
	        	
	        	NguoiMuonModel nguoiMuon = new NguoiMuonModel();
	        	nguoiMuon.setId(rs.getString("user_id"));
	        	nguoiMuon.setTenNguoiMuon(rs.getString("user_name"));
	        	nguoiMuon.setDiaChi(rs.getString("user_address"));
	        	nguoiMuon.setLienHe(rs.getString("user_phone"));
	        	nguoiMuon.setPhiDangKi(rs.getInt("fee_register"));
	        	nguoiMuon.setCccd(rs.getString("cccd"));
	        	listNguoiMuon.add(nguoiMuon);
	        	int event_no = rs.getInt("event_no");
	        	ThoiGianModel thoiGian = new ThoiGianModel();	        	
	        	String query1 = "SELECT * FROM schedule WHERE event_no = " + event_no;
	        	PreparedStatement st1 = (PreparedStatement)connection.prepareStatement(query1);
	        	ResultSet rs1 = st1.executeQuery();
	        	thoiGian.setId(event_no);
	        	thoiGian.setThoiGianMuon(rs1.getTimestamp("time_start"));
	        	thoiGian.setThoiGianTra(rs1.getTimestamp("time_end"));
	        	thoiGian.setThoiGianTraThucTe(null);
	        	listThoiGian.add(thoiGian);
	        	st1.close();
	        }
	        preparedStatement.close();
	        
	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
		return coSoVatChatBean;
	}
	public CoSoVatChatBean getCoSoVatChat(String tenCoSoVatChat) {
		Connection connection;
		CoSoVatChatBean coSoVatChatBean = new CoSoVatChatBean(); 
//		try {
//			connection = MysqlConnection.getMysqlConnection();
//			 
//	        String query = "SELECT i.item_id, i.item_name, i.item_quantity, sum(ir.item_number) AS lended, (i.item_quantity-sum(ir.item_number)) AS remain "
//	   			 		 + "FROM item i JOIN itemregistered ir ON i.item_id=ir.item_id WHERE CAST(i.item_id AS string) = "
//	   			 		 + id
//	   			 		 + " GROUP BY i.item_id";
//	        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
//	        ResultSet rs = preparedStatement.executeQuery();
//	        int idCoSoVatChat = -1;
//	        while(rs.next()) {
//	        	CoSoVatChatModel coSoVatChat = coSoVatChatBean.getCoSoVatChatModel();
//                idCoSoVatChat = rs.getInt("item_id");
//                coSoVatChat.setId(idCoSoVatChat);
//                coSoVatChat.setTenCoSoVatChat(rs.getString("item_name"));
//                coSoVatChat.setSoLuong(rs.getInt("item_quantity"));
//                coSoVatChat.setSoLuongMuon(rs.getInt("lended"));
//                coSoVatChat.setSoLuongTrongKho(rs.getInt("remain"));
//	        }
//	        preparedStatement.close();
//	        connection.close();
//		} catch (Exception e) {
//            this.exceptionHandle(e.getMessage());
//        }
        
        return coSoVatChatBean;
    }
    
     // lay danh sach co so vat chat
    public List<CoSoVatChatBean> getListCoSoVatChat() {
    	
        List<CoSoVatChatBean> list = new ArrayList<>();
        
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT i.item_id, i.item_name, i.item_quantity, sum(coalesce((ir.item_number),0)) AS lended, (i.item_quantity-COALESCE(sum(ir.item_number), 0)) AS remain "
       			 		 + "FROM item i LEFT JOIN itemregistered ir ON i.item_id=ir.item_id GROUP BY i.item_id, i.item_name, i.item_quantity";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
            	CoSoVatChatBean coSoVatChatBean = new CoSoVatChatBean(); 
                CoSoVatChatModel coSoVatChat = coSoVatChatBean.getCoSoVatChatModel();
                coSoVatChat.setId(rs.getInt("item_id"));
                coSoVatChat.setTenCoSoVatChat(rs.getString("item_name"));
                coSoVatChat.setSoLuong(rs.getInt("item_quantity"));
                coSoVatChat.setSoLuongMuon(rs.getInt("lended"));
                coSoVatChat.setSoLuongTrongKho(rs.getInt("remain"));
                list.add(coSoVatChatBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {

        	this.exceptionHandle(e.getMessage());
        }
        return list;
    }
    
    //lay so luong co so vat chat con lai theo ten
    public int getSoLuongConLai(String tenCoSoVatChat) throws ClassNotFoundException, SQLException {
    	int soLuong = 0;
        
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT (i.item_quantity-sum(coalesce((ir.item_number),0))) as remain FROM item i LEFT JOIN itemregistered ir on i.item_id=ir.item_id "
       			 		 + "WHERE i.item_name = " + tenCoSoVatChat + " GROUP BY ir.item_id, i.item_name, i.item_quantity";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            soLuong = rs.getInt("remain");
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {

        	this.exceptionHandle(e.getMessage());
        }
        
        return soLuong;
    }
    
    //danh sach co so vat chat phuc vu viec search
    public List<CoSoVatChatBean> search(String tenCoSoVatChat) {
        List<CoSoVatChatBean> list = new ArrayList<>();
        //viết truy vấn
        
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT i.item_id, i.item_name, i.item_quantity, sum(coalesce((ir.item_number),0)) AS lended, (i.item_quantity-COALESCE(sum(ir.item_number), 0)) AS remain "
			 		 	 + "FROM item i LEFT JOIN itemregistered ir ON i.item_id=ir.item_id WHERE i.item_name LIKE '%"
			 		 	 + tenCoSoVatChat
			 		 	 + "%' GROUP BY i.item_id, i.item_name, i.item_quantity"; 
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
            	CoSoVatChatBean coSoVatChatBean = new CoSoVatChatBean(); 
                CoSoVatChatModel coSoVatChat = coSoVatChatBean.getCoSoVatChatModel();
                coSoVatChat.setId(rs.getInt("item_id"));
                coSoVatChat.setTenCoSoVatChat(rs.getString("item_name"));
                coSoVatChat.setSoLuong(rs.getInt("item_quantity"));
                coSoVatChat.setSoLuongMuon(rs.getInt("lended"));
                coSoVatChat.setSoLuongTrongKho(rs.getInt("remain"));
                list.add(coSoVatChatBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {

        	this.exceptionHandle(e.getMessage());
        }
        System.out.println(list.size());
        return list;
    }
    
    public void xoaCoSoVatChat(int id) {
    	 try {
             Connection connection = MysqlConnection.getMysqlConnection();
             String query = "DELETE FROM item WHERE item_id = "+ id; 
             PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
             preparedStatement.executeQuery();
             preparedStatement.close();
             connection.close();
         } catch (Exception e) {

         	this.exceptionHandle(e.getMessage());
         }
    }
    
    /*
     * Ham sử lý ngoại lệ : thông báo ra lỗi nhận được
     */
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
