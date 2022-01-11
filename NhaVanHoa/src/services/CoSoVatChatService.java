package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import Bean.CoSoVatChatBean;
import models.CoSoVatChatModel;


public class CoSoVatChatService {
	
	//lay ten co so vat chat thong qua id
	public CoSoVatChatBean getCoSoVatChat(String id) {
		Connection connection;
		CoSoVatChatBean coSoVatChatBean = new CoSoVatChatBean(); 
		try {
			connection = MysqlConnection.getMysqlConnection();
			 
	        String query = "SELECT i.item_id, i.item_name, i.item_quantity, sum(ir.item_number) AS lended, (i.item_quantity-sum(ir.item_number)) AS remain "
	   			 		 + "FROM item i JOIN itemregistered ir ON i.item_id=ir.item_id WHERE CAST(i.item_id AS string) = "
	   			 		 + id
	   			 		 + " GROUP BY i.item_id";
	        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();
	        int idCoSoVatChat = -1;
	        while(rs.next()) {
	        	CoSoVatChatModel coSoVatChat = coSoVatChatBean.getCoSoVatChatModel();
                idCoSoVatChat = rs.getInt("item_id");
                coSoVatChat.setId(idCoSoVatChat);
                coSoVatChat.setTenCoSoVatChat(rs.getString("item_name"));
                coSoVatChat.setSoLuong(rs.getInt("item_quantity"));
                coSoVatChat.setSoLuongMuon(rs.getInt("lended"));
                coSoVatChat.setSoLuongTrongKho(rs.getInt("remain"));
	        }
	        preparedStatement.close();
	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        
        return coSoVatChatBean;
    }
    
     // lay danh sach co so vat chat
    public List<CoSoVatChatBean> getListCoSoVatChat() {
    	
        List<CoSoVatChatBean> list = new ArrayList<>();
        
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT i.item_id, i.item_name, i.item_quantity, sum(ir.item_number) AS lended, (i.item_quantity-sum(ir.item_number)) AS remain "
       			 		 + "FROM item i JOIN itemregistered ir ON i.item_id=ir.item_id GROUP BY i.item_id";
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
    public int getSoLuongConLai(String tenCoSoVatChat) {
    	int soLuong = 0;
        //viết truy vấn
        
        return soLuong;
    }
    
    //danh sach co so vat chat phuc vu viec search
    public List<CoSoVatChatBean> search(String tenCoSoVatChat) {
        List<CoSoVatChatBean> list = new ArrayList<>();
        //viết truy vấn
        
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT i.item_id, i.item_name, i.item_quantity, sum(ir.item_number) AS lended, (i.item_quantity-sum(ir.item_number)) AS remain "
			 		 	 + "FROM item i JOIN itemregistered ir ON i.item_id=ir.item_id WHERE i.item_name LIKE '% "
			 		 	 + tenCoSoVatChat
			 		 	 + "%' GROUP BY i.item_id";
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
    
    /*
     * Ham sử lý ngoại lệ : thông báo ra lỗi nhận được
     */
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
