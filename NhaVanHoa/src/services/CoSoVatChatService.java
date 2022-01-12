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
import models.ListNguoiMuonCoSoVatChatDetailModel;



public class CoSoVatChatService {
	
	//tra ve danh sach cac nguoi muon co so vat chat nay, cung voi thoi gian ho muon, tra ve danh sach nha tai tro co so vat chat neu co
	public CoSoVatChatBean getCoSoVatChatDetail(String tenCoSoVatChat) {
		Connection connection;
		CoSoVatChatBean coSoVatChatBean = new CoSoVatChatBean(); 
		List<ListNguoiMuonCoSoVatChatDetailModel> list = coSoVatChatBean.getListNguoiMuonCoSoVatChatDetailModels();
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
	        
	        query = "SELECT ir.item_number, r.user_name, s.time_start, s.time_end FROM itemregistered ir "
	        	  + "LEFT JOIN registers r ON ir.user_id = r.user_id LEFT JOIN item i ON ir.item_id = i.item_id "
	        	  + "LEFT JOIN schedule s ON ir.event_no = s.event_no WHERE item_name = "
	        	  + tenCoSoVatChat;
	        preparedStatement = (PreparedStatement)connection.prepareStatement(query);
	        rs = preparedStatement.executeQuery();
	        
	        while(rs.next()) {
	        	
	        	ListNguoiMuonCoSoVatChatDetailModel detail = new ListNguoiMuonCoSoVatChatDetailModel();
	        	detail.setSoLuongMuon(rs.getInt("item_number"));
	        	detail.setTenNguoiMuon(rs.getString("user_name"));
	        	detail.setThoiGianMuon(rs.getString("time_start"));
	        	detail.setThoiGianTra(rs.getString("time_end"));
	        	list.add(detail);
	        }
	        coSoVatChatBean.setListNguoiMuonCoSoVatChatDetailModels(list);
	        preparedStatement.close();
	        
	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
		System.out.print(list.size());
		return coSoVatChatBean;
	}
	
	public CoSoVatChatBean getCoSoVatChat(String tenCoSoVatChat) {
		Connection connection;
		CoSoVatChatBean coSoVatChatBean = new CoSoVatChatBean(); 
		List<ListNguoiMuonCoSoVatChatDetailModel> listNguoiMuonCoSoVatChatDetailModels = new ArrayList<>();
		coSoVatChatBean.setListNguoiMuonCoSoVatChatDetailModels(listNguoiMuonCoSoVatChatDetailModels);
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
    
    // them so luong cua ten csvc tuong ung
    // tu dong add thoi gian xoa
    public void themSoLuongCoSoVatChat(String tenCoSoVatChat, int soLuongXoa) {
    	try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "UPDATE item SET item_quantity = item_quantity + "
            			 + soLuongXoa + "WHERE item_name = "+ tenCoSoVatChat; 
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            preparedStatement.executeQuery();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {

        	this.exceptionHandle(e.getMessage());
        }
    	
    }
    // xoa ten ten va so luong
    // tu dong add thoi gian xoa
    public void xoaCoSoVatChat(String tenCoSoVatChat, int soLuongXoa) {
    	try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "UPDATE item SET item_quantity = item_quantity - "
            			 + soLuongXoa + "WHERE item_name = "+ tenCoSoVatChat; 
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            preparedStatement.executeQuery();
            preparedStatement.close();
            query = "DELETE FROM item WHERE item_quantity = 0";
            PreparedStatement st = (PreparedStatement)connection.prepareStatement(query);
            st.executeQuery();
            st.close();
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
