package controllersAddNewController;

import Bean.CoSoVatChatBean;
import Bean.MuonTraBean;
import Bean.PhongBanBean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.PhongBanModel;
import models.CoSoVatChatModel;
import models.NguoiMuonModel;
import models.ThoiGianModel;
import services.MysqlConnection;

/**
 *
 * @author Hai
 */

// lop thuc hien cac chuc nang trong giao dien them moi nhan khau

public class AddNewController {
   
    public boolean addNewNguoiMuon(MuonTraBean muonTraBean) throws SQLException, ClassNotFoundException{
        NguoiMuonModel nguoiMuonModel = muonTraBean.getNguoiMuonModel();
        CoSoVatChatModel coSoVatChatModel = muonTraBean.getCoSoVatChatModel();
        PhongBanModel phongBanModel = muonTraBean.getPhongBanModel();
        ThoiGianModel thoiGianModel = muonTraBean.getThoiGianModel();
        
        Connection connection = MysqlConnection.getMysqlConnection();
        connection.close();
        return true;
    }
    
    public boolean addNewCoSoVatChat(CoSoVatChatBean coSoVatChatBean) throws SQLException, ClassNotFoundException{
        CoSoVatChatModel coSoVatChatModel = coSoVatChatBean.getCoSoVatChatModel();
        Connection connection = MysqlConnection.getMysqlConnection();
        
        String query = "SELECT item_id FROM item WHERE item_name = '"
        			 + coSoVatChatModel.getTenCoSoVatChat()
        			 + "'";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = preparedStatement.executeQuery();
        int idCoSoVatChat = -1;
        idCoSoVatChat = rs.getInt("item_id");
        if (idCoSoVatChat > 0) {
        	String query1 = "UPDATE item SET item_quantity = item_quantity + " 
        				  + coSoVatChatModel.getSoLuong()
        				  + " WHERE item_name = "
        				  + coSoVatChatModel.getTenCoSoVatChat();
        	PreparedStatement preparedStatement1 = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
        	preparedStatement1.execute();
        	preparedStatement1.close();
        }
        else {
        	String query1 = "INSERT INTO item (item_name, item_quantity) "
        				  + "values (?, ?)";
        	PreparedStatement preparedStatement1 = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
        	preparedStatement1.setString(1, coSoVatChatModel.getTenCoSoVatChat());
        	preparedStatement1.setInt(2, coSoVatChatModel.getSoLuong());
        	preparedStatement1.executeUpdate();
        	preparedStatement1.close();
        }
        String query2 = "INSERT INTO money (item_id, item_number, date, reason) "
        			  + "values ((SELECT item_id FROM item WHERE item_name = "
        			  + coSoVatChatModel.getTenCoSoVatChat()
        			  + "), ?, CURRENT_DATE, ?)";
        PreparedStatement preparedStatement2 = connection.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
        preparedStatement2.setInt(2, coSoVatChatModel.getSoLuong());
        preparedStatement2.setString(4, coSoVatChatModel.getLyDo());
        preparedStatement2.close();
        preparedStatement.close();
        connection.close();
        return true;
    }
    
    public boolean addNewPhongBan(PhongBanBean phongBanBean) throws SQLException, ClassNotFoundException{
        PhongBanModel phongBanModel = phongBanBean.getPhongBanModel();       
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO infrastructure (infra_name, reason) "
				  	 + "values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, phongBanModel.getTenPhongBan());
        preparedStatement.setString(2, phongBanModel.getLyDo());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }
}
