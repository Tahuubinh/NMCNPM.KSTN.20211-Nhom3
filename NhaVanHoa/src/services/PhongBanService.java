package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Bean.PhongBanBean;
import models.PhongBanModel;

public class PhongBanService {
	
	//lay ten co so vat chat thong qua id
	public PhongBanBean getPhongBan(String id) {
        PhongBanBean phongBanBean = new PhongBanBean();  
        Connection connection;
        try {
			connection = MysqlConnection.getMysqlConnection();
			 
			String query = "SELECT DISTINCT(i.infra_id), s.time_start, i.infra_name, concat_ws('     -     ', coalesce(s.time_start , null), coalesce(s.time_end ,'')) AS thoigian, i.reason "
       			 + "FROM infrastructure i LEFT JOIN infraregistered ir ON i.infra_id = ir.infra_id "
       			 + "LEFT JOIN schedule s on ir.event_no = s.event_no WHERE (s.time_end >= CURRENT_TIMESTAMP or s.time_start is null) AND CAST(infra_id AS string) = "
       			 + id
       			 + " ORDER BY s.time_start";
	        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();
	        int idPhongBan = -1;
	        while(rs.next()) {
	        	PhongBanModel phongBan = phongBanBean.getPhongBanModel();
	        	idPhongBan = rs.getInt("infra_id");
                phongBan.setId(idPhongBan);
                phongBan.setTenPhongBan(rs.getString("infra_name"));
                phongBan.setThoiGianSuDung(rs.getString("thoigian"));
                phongBan.setLyDo(rs.getString("reason"));
	        }
	        preparedStatement.close();
	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        return phongBanBean;
    }
    
     // lay danh sach co so vat chat
    public List<PhongBanBean> getListPhongBan() {
    	Connection connection;
        List<PhongBanBean> list = new ArrayList<>();
        
        try {
			connection = MysqlConnection.getMysqlConnection();
			 
			String query = "SELECT DISTINCT(i.infra_id), s.time_start, i.infra_name, concat_ws('     -     ', s.time_start, s.time_end) as thoigian, i.reason "
  			 		 + "FROM infrastructure i LEFT JOIN infraregistered ir ON i.infra_id = ir.infra_id "
  			 		 + "LEFT JOIN schedule s on ir.event_no = s.event_no WHERE (s.time_end >= CURRENT_TIMESTAMP or s.time_start is null) "
  			 		 + "ORDER BY s.time_start";
	        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();
	        int idPhongBan = -1;
	        while(rs.next()) {
	        	PhongBanBean phongBanBean = new PhongBanBean();
	        	PhongBanModel phongBan = phongBanBean.getPhongBanModel();
	        	idPhongBan = rs.getInt("infra_id");
                phongBan.setId(idPhongBan);
                phongBan.setTenPhongBan(rs.getString("infra_name"));
                phongBan.setThoiGianSuDung(rs.getString("thoigian"));
                phongBan.setLyDo(rs.getString("reason"));
                list.add(phongBanBean);
	        }
	        preparedStatement.close();
	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        return list;
    }
    
    
    //danh sach co so vat chat phuc vu viec search
    public List<PhongBanBean> search(String tenPhongBan) {
        
        Connection connection;
        List<PhongBanBean> list = new ArrayList<>();
        
        try {
			connection = MysqlConnection.getMysqlConnection();
			 
			String query = "SELECT DISTINCT(i.infra_id), s.time_start, i.infra_name, concat_ws('     -     ', s.time_start), s.time_end) as thoigian, i.reason "
		   			 + "FROM infrastructure i LEFT JOIN infraregistered ir ON i.infra_id = ir.infra_id "
		   			 + "LEFT JOIN schedule s on ir.event_no = s.event_no WHERE (s.time_start >= CURRENT_TIMESTAMP or s.time_start is null) AND infra_name LIKE '%"
		   			 + tenPhongBan
		   			 + "%' ORDER BY s.time_start";
	        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
	        ResultSet rs = preparedStatement.executeQuery();
	        int idPhongBan = -1;
	        while(rs.next()) {
	        	PhongBanBean phongBanBean = new PhongBanBean();
	        	PhongBanModel phongBan = phongBanBean.getPhongBanModel();
	        	idPhongBan = rs.getInt("infra_id");
                phongBan.setId(idPhongBan);
                phongBan.setTenPhongBan(rs.getString("infra_name"));
                phongBan.setThoiGianSuDung(rs.getString("thoigian"));
                phongBan.setLyDo(rs.getString("reason"));
                list.add(phongBanBean);
	        }
	        preparedStatement.close();
	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        return list;
    }
    
    /*
     * check lich su dung sap toi, neu co lich su dung, tra ve false
     */
    public boolean huyPhongBan(String tenPhongBan) {
    	//viết truy vấn
        Connection connection;
        String query = "SELECT * FROM infraregistered ir LEFT JOIN schedule s on s.event_no=ir.event_no LEFT JOIN infrastructure i "
        			 + "ON ir.infra_id = i.infra_id WHERE infra_name = '"
        			 + tenPhongBan + "' AND s.time_start >= CURRENT_TIMESTAMP";
        
        
        try {
        	connection = MysqlConnection.getMysqlConnection();
        	PreparedStatement st = (PreparedStatement)connection.prepareStatement(query);
        	ResultSet rs = st.executeQuery();
            while(rs.next()) return false;
            huyPhongBanBatBuoc(tenPhongBan);
	        st.close();
	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
            return false;
        }
        return true;
    }
    
    /*
     * xoa phong ban, bat ke co lich su dung
     */
    public boolean huyPhongBanBatBuoc(String tenPhongBan) {
         //viết truy vấn
     	String query = "DELETE FROM infrastructure WHERE infra_name = '" + tenPhongBan + "'";
     	Connection connection;
 		try {
 			connection = MysqlConnection.getMysqlConnection();
 			PreparedStatement st = (PreparedStatement)connection.prepareStatement(query);
            st.executeUpdate();
 	    	st.close();
 	    	connection.close();
 		} catch (ClassNotFoundException e) {
 			return false;
 		} catch (SQLException e) {
 			return false;
 		}
     	
         return true;
    }
    
    public PhongBanBean doiTenPhongBan(String tenPhongBanCu, String tenPhongBan) {
        PhongBanBean phongBanBean = new PhongBanBean();
        //viết truy vấn
        String query = "UPDATE infrastructure SET infra_name = '" + tenPhongBan + "'WHERE infra_name = '" + tenPhongBanCu + "'";
     	Connection connection;
 		try {
 			connection = MysqlConnection.getMysqlConnection();
 			PreparedStatement st = (PreparedStatement)connection.prepareStatement(query);
            st.executeUpdate();
 	    	st.close();
 	    	connection.close();
 		} catch (ClassNotFoundException e) {
 			this.exceptionHandle(e.getMessage());
 		} catch (SQLException e) {
 			this.exceptionHandle(e.getMessage());
 		}
        return phongBanBean;
    }
    /*
     * Ham sử lý ngoại lệ : thông báo ra lỗi nhận được
     */
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
