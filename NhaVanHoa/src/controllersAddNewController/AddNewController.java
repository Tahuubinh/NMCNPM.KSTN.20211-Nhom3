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
   
	//add thong tin nguoi muon vao database, neu add that bai tra ve false
    public boolean addNewNguoiMuon(MuonTraBean muonTraBean) throws SQLException, ClassNotFoundException{
        NguoiMuonModel nguoiMuonModel = muonTraBean.getNguoiMuonModel();
        CoSoVatChatModel coSoVatChatModel = muonTraBean.getCoSoVatChatModel();
        PhongBanModel phongBanModel = muonTraBean.getPhongBanModel();
        ThoiGianModel thoiGianModel = muonTraBean.getThoiGianModel();
        Connection connection = MysqlConnection.getMysqlConnection();
        connection.close();
        return true;
    }
    
    //add thong tin co so vat chat vao database, neu add that bai tra ve false
    public boolean addNewCoSoVatChat(CoSoVatChatBean coSoVatChatBean) throws SQLException, ClassNotFoundException{
        CoSoVatChatModel coSoVatChatModel = coSoVatChatBean.getCoSoVatChatModel();
        Connection connection = MysqlConnection.getMysqlConnection();
        
        String query = "INSERT INTO nhan_khau (hoTen, gioiTinh)" 
                        + " values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, nhanKhau.getHoTen());
        preparedStatement.setString(2, nhanKhau.getGioiTinh());
        preparedStatement.executeUpdate();
        connection.close();
        return true;
    }
    
    //add thong tinphong ban vao database, neu add that bai tra ve false
    public boolean addNewPhongBan(PhongBanBean phongBanBean) throws SQLException, ClassNotFoundException{
        PhongBanModel phongBanModel = phongBanBean.getPhongBanModel();
        Connection connection = MysqlConnection.getMysqlConnection();
        connection.close();
        return true;
    }
}
