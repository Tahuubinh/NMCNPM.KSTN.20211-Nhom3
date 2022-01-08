package controllersMuonTraController;

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
        PhongBanModel coSoHaTangModel = muonTraBean.getCoSoHaTangModel();
        ThoiGianModel thoiGianModel = muonTraBean.getThoiGianModel();
        Connection connection = MysqlConnection.getMysqlConnection();
        connection.close();
        return true;
    }
    
    public boolean addNewCoSoVatChat(CoSoVatChatBean coSoVatChatBean) throws SQLException, ClassNotFoundException{
        CoSoVatChatModel coSoVatChatModel = coSoVatChatBean.getCoSoVatChatModel();
        Connection connection = MysqlConnection.getMysqlConnection();
        connection.close();
        return true;
    }
    
    public boolean addNewPhongBan(PhongBanBean phongBanBean) throws SQLException, ClassNotFoundException{
        PhongBanModel phongBanModel = phongBanBean.getPhongBanModel();
        Connection connection = MysqlConnection.getMysqlConnection();
        connection.close();
        return true;
    }
}
