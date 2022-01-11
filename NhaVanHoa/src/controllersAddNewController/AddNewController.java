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
import java.util.List;

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
        
        Connection connection = MysqlConnection.getMysqlConnection();
        connection.close();
        return true;
    }
    
    //add thong tin co so vat chat vao database, neu add that bai tra ve false
    public boolean addNewCoSoVatChat(CoSoVatChatBean coSoVatChatBean) throws SQLException, ClassNotFoundException{
        CoSoVatChatModel coSoVatChatModel = coSoVatChatBean.getCoSoVatChatModel();
        Connection connection = MysqlConnection.getMysqlConnection();

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
