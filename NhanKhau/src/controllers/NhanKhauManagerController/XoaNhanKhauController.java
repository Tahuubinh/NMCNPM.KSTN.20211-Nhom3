package controllers.NhanKhauManagerController;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Bean.NhanKhauBean;
import models.ChungMinhThuModel;
import models.GiaDinhModel;
import models.KhaiTuModel;
import models.NhanKhauModel;
import models.TieuSuModel;
import services.MysqlConnection;

/**
 *
 * @author Hai
 */
public class XoaNhanKhauController {
    public boolean XoaNhanKhau(int id, String lydoString, Date ngayMatDate, String soGiayString) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM nhan_khau WHERE id = (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            String hotenString = "";
            String gioitinhString = "";
            Date ngaysinhDate = null;
            while (rs.next()){
                hotenString = rs.getString("hoTen");
                gioitinhString = rs.getString("gioiTinh");
                ngaysinhDate = rs.getDate("namSinh");
            }
            query = "INSERT INTO xoa_nhan_khau (hoTen, gioitinh, namSinh, ngayxoa, lydo, sogiay)" 
                    + " values (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, hotenString);
            preparedStatement.setString(2, gioitinhString);
            //java.sql.Date namSinh = new java.sql.Date(nhanKhau.getNamSinh().getTime());
            preparedStatement.setDate(3, ngaysinhDate);
            preparedStatement.setDate(4, ngayMatDate);
            preparedStatement.setString(5, lydoString);
            preparedStatement.setString(6, soGiayString);
            preparedStatement.executeUpdate();
            
            query = "DELETE FROM nhan_khau WHERE id = (?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public boolean XoaTamTru(int id) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "DELETE FROM tam_tru WHERE id = (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public boolean addNew(KhaiTuModel khaiTuModel) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "INSERT INTO khai_tu(idNhanKhau, , lyDo)" + " value (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, tamTruModel.getIdNhanKhau());
//            preparedStatement.setString(2, tamTruModel.getMaGiayTamTru());
//            preparedStatement.setString(3, tamTruModel.getSoDienThoaiNguoiDangKy());
//            Date tuNgay = new Date(tamTruModel.getTuNgay().getTime());
//            preparedStatement.setDate(4, tuNgay);
//            Date denNgay = new Date(tamTruModel.getDenNgay().getTime());
//            preparedStatement.setDate(5, denNgay);
//            preparedStatement.setString(6, tamTruModel.getLyDo());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}

