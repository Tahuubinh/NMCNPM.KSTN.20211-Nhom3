package ControllersAddNewController;

import Bean.CoSoVatChatBean;
import Bean.MuonTraBean;
import Bean.PhongBanBean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.JOptionPane;

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
   
	//add thong tin nguoi muon vao database, neu add that bai tra ve false
    public boolean addNewNguoiMuon(MuonTraBean muonTraBean) throws SQLException, ClassNotFoundException{
        NguoiMuonModel nguoiMuonModel = muonTraBean.getNguoiMuonModel();
        ThoiGianModel thoiGianModel = muonTraBean.getThoiGianModel();
        List<CoSoVatChatModel> listCoSoVatChatModels = muonTraBean.getListCoSoVatChatModels();
        List<PhongBanModel> listPhongBanModels = muonTraBean.getListPhongBanModels();
        int idNguoiMuon=-1;
        Connection connection = MysqlConnection.getMysqlConnection();
        String query1 = "SELECT user_id FROM registers WHERE user_name = " + nguoiMuonModel.getTenNguoiMuon() 
        			 + " AND cccd = " + nguoiMuonModel.getCccd();
        PreparedStatement st1 = connection.prepareStatement(query1);
        ResultSet rs1 = st1.executeQuery();
        while(rs1.next()) {
        	idNguoiMuon = rs1.getInt(1);
        }
        if(idNguoiMuon < 0) return false;
        
        String query2 = "INSERT INTO schedule (time_start, time_end, real_time_end) values (?, ?, ?)";
        PreparedStatement st2 = connection.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
    	st2.setTimestamp(1, (Timestamp) thoiGianModel.getThoiGianMuon());
    	st2.setTimestamp(2, (Timestamp) thoiGianModel.getThoiGianTra());
    	st2.setTimestamp(3, null);
    	st2.executeUpdate();
    	st2.close();
        listCoSoVatChatModels.forEach(coSoVatChat ->{
        	int soLuongMuon = coSoVatChat.getSoLuongMuon();
        	String query3 = "INSERT INTO itemregistered (item_id, user_id, event_no, item_number) values "
        				  + "((SELECT item_id FROM item WHERE item_name = "
        				  + coSoVatChat.getTenCoSoVatChat()
        				  + ", ?, ?, ?)";
        	try {
				PreparedStatement st3 = connection.prepareStatement(query3);
				st3.setInt(2, rs1.getInt(1));
//				st3.setInt(3, );
				st3.setInt(4, coSoVatChat.getSoLuongMuon());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				this.exceptionHandle(e.getMessage());
			}
        });
        listPhongBanModels.forEach(phongBan ->{
        	String query3 = "INSERT INTO itemregistered (infra_id, user_id, event_no) values "
        				  + "((SELECT item_id FROM item WHERE item_name = "
        				  + phongBan.getTenPhongBan()
        				  + ", ?, ?)";
        	try {
				PreparedStatement st3 = connection.prepareStatement(query3);
				st3.setInt(2, rs1.getInt(1));
//				st3.setInt(3, );
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				this.exceptionHandle(e.getMessage());
			}
        });
        st1.close();
        connection.close();
        return true;
    }
    
    //add thong tin co so vat chat vao database, neu add that bai tra ve false
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
    
    //add thong tinphong ban vao database, neu add that bai tra ve false
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
    
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
