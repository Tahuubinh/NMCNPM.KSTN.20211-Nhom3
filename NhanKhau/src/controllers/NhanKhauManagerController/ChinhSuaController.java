package controllers.NhanKhauManagerController;

import Bean.NhanKhauBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.ChungMinhThuModel;
import models.NhanKhauModel;
import services.MysqlConnection;

/**
 *
 * @author Hai
 */

// lop thuc hien cac chuc nang trong giao dien them moi nhan khau

public class ChinhSuaController {

	public boolean UpdatePeople(NhanKhauBean nhanKhauBean, int id) throws SQLException, ClassNotFoundException{
        NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
        Connection connection = MysqlConnection.getMysqlConnection();
        // 1 - 19
        String query = "UPDATE nhan_khau " 
                        + " SET hoTen = ?, gioiTinh = ?, namSinh = ?, tcc = ?, tongiao = ?, lienhe = ?, ghichu = ? "
                        + "WHERE id = ?";
        // System.err.println(query);
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, nhanKhau.getHoTen());
        preparedStatement.setString(2, nhanKhau.getGioiTinh());
        java.sql.Date namSinh = new java.sql.Date(nhanKhau.getNamSinh().getTime());
        preparedStatement.setDate(3, namSinh);
        preparedStatement.setString(4, nhanKhau.getTccString());
        preparedStatement.setString(5, nhanKhau.getTonGiao());
        preparedStatement.setString(6, nhanKhau.getLienheString());
        preparedStatement.setString(7, nhanKhau.getGhiChu());
        preparedStatement.setInt(8, id);
        preparedStatement.executeUpdate();
        
        
        connection.close();
        return true;
    }
}
