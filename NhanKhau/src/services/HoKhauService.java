package services;

import Bean.HoKhauBean;
import Bean.NhanKhauBean;
import controllers.LoginController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.HoKhauModel;
import models.NhanKhauModel;
import models.ThanhVienCuaHoModel;

/**
 *
 * @author Hai
 */
public class HoKhauService {
    // them moi ho khau
    public boolean addNew(HoKhauBean hoKhauBean) throws ClassNotFoundException, SQLException{
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO ho_khau(maHoKhau, idChuHo, maKhuVuc, diaChi, ngayLap)" 
                    + " values (?, ?, ?, ?, NOW())";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, hoKhauBean.getHoKhauModel().getMaHoKhau());
        preparedStatement.setInt(2, hoKhauBean.getChuHo().getID());
        preparedStatement.setString(3, hoKhauBean.getHoKhauModel().getMaKhuVuc());
        preparedStatement.setString(4, hoKhauBean.getHoKhauModel().getDiaChi());

        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            int genID = rs.getInt(1);
            String sql = "INSERT INTO thanh_vien_cua_ho(idNhanKhau, idHoKhau, quanHeVoiChuHo)" 
                            + " values (?, ?, ?)";
            hoKhauBean.getListThanhVienCuaHo().forEach((ThanhVienCuaHoModel thanhVien) -> {     
                try { 
                    PreparedStatement preStatement = connection.prepareStatement(sql);
                    preStatement.setInt(1, thanhVien.getIdNhanKhau());
                    preStatement.setInt(2, genID);
                    preStatement.setString(3, thanhVien.getQuanHeVoiChuHo());
                    preStatement.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(HoKhauService.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
        }
        preparedStatement.close();
        connection.close();
        return true;
    }
    
    public int addHoKhau(HoKhauBean hoKhauBean) throws ClassNotFoundException, SQLException{
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO ho_khau(maHoKhau, idChuHo, maKhuVuc, diaChi, ngayLap)" 
                    + " values (?, ?, ?, ?, NOW())";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, hoKhauBean.getHoKhauModel().getMaHoKhau());
        preparedStatement.setInt(2, hoKhauBean.getChuHo().getID());
        preparedStatement.setString(3, hoKhauBean.getHoKhauModel().getMaKhuVuc());
        preparedStatement.setString(4, hoKhauBean.getHoKhauModel().getDiaChi());

        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        int id = 0;
        if (rs.next()) {
            int genID = rs.getInt(1);
            id = genID;
            String sql = "INSERT INTO thanh_vien_cua_ho(idNhanKhau, idHoKhau, quanHeVoiChuHo)" 
                            + " values (?, ?, ?)";
            hoKhauBean.getListThanhVienCuaHo().forEach((ThanhVienCuaHoModel thanhVien) -> {     
                try { 
                    PreparedStatement preStatement = connection.prepareStatement(sql);
                    preStatement.setInt(1, thanhVien.getIdNhanKhau());
                    preStatement.setInt(2, genID);
                    preStatement.setString(3, thanhVien.getQuanHeVoiChuHo());
                    preStatement.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(HoKhauService.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
        }
        preparedStatement.close();
        connection.close();
        return id;
    }
    
    public NhanKhauModel getThongTinChuHo(int id) throws ClassNotFoundException, SQLException{
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "SELECT * FROM nhan_khau WHERE id = (\r\n"
        		+ "	SELECT idchuho FROM ho_khau\r\n"
        		+ "	WHERE id = \r\n"
        		+ id + ")";
        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        //System.err.println(query);

        NhanKhauBean nhanKhauBean = new NhanKhauBean();
        NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
        if (rs.next()) {
        	nhanKhau.setID(rs.getInt("ID"));
        	System.err.println(rs.getString("hoTen"));
        	nhanKhau.setHoTen(rs.getString("hoTen"));
            nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
            nhanKhau.setNamSinh(rs.getDate("namSinh"));
            nhanKhau.setTccString(rs.getString("tcc"));
        }
        preparedStatement.close();
        connection.close();
        return nhanKhau;
    }
    
    
    public boolean checkPerson(int id) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM ho_khau INNER JOIN thanh_vien_cua_ho ON ho_khau.ID = thanh_vien_cua_ho.idHoKhau"
                        + " WHERE ho_khau.idChuHo = "
                        + id 
                        + " OR thanh_vien_cua_ho.idNhanKhau = "
                        + id;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }
    
    public boolean addThanhVien(int id_nhan_khau, int id_ho_khau) throws ClassNotFoundException, SQLException{
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "INSERT INTO thanh_vien_cua_ho (idnhankhau, idhokhau)" 
                    + " values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, id_nhan_khau);
        preparedStatement.setInt(2, id_ho_khau);

        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }
    
    public boolean subThanhVien(int id_nhan_khau, int id_ho_khau) throws ClassNotFoundException, SQLException{
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "DELETE FROM thanh_vien_cua_ho " 
                    + " WHERE idnhankhau = ? and idhokhau = ?";
//        System.err.println(query);
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, id_nhan_khau);
        preparedStatement.setInt(2, id_ho_khau);
//        System.err.println(id_nhan_khau);
//        System.err.println(id_ho_khau);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }
    
    public boolean doiChuHo(int id_nhan_khau, int id_ho_khau) throws ClassNotFoundException, SQLException{
    	try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM ho_khau WHERE id = " + id_ho_khau;
            int id_chu_ho = 0;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
            	id_chu_ho = rs.getInt("idChuHo");
            }
            addThanhVien(id_chu_ho, id_ho_khau);
            subThanhVien(id_nhan_khau, id_ho_khau);
            preparedStatement.close();
            
            query = "UPDATE ho_khau "
            		+ "SET idchuho = ?"
            		+ "WHERE id = ?";
	//        System.err.println(query);
	        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        preparedStatement.setInt(1, id_nhan_khau);
	        preparedStatement.setInt(2, id_ho_khau);
	//        System.err.println(id_nhan_khau);
	//        System.err.println(id_ho_khau);
	        preparedStatement.executeUpdate();
	        preparedStatement.close();
	        connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    public boolean xoaHoKhau(int id_ho_khau) throws ClassNotFoundException, SQLException{
        Connection connection = MysqlConnection.getMysqlConnection();
        String query = "DELETE FROM thanh_vien_cua_ho " 
                    + " WHERE idhokhau = ?";
//        System.err.println(query);
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, id_ho_khau);
//        System.err.println(id_nhan_khau);
//        System.err.println(id_ho_khau);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        
        connection = MysqlConnection.getMysqlConnection();
        query = "DELETE FROM ho_khau " 
                    + " WHERE id = ?";
//        System.err.println(query);
        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, id_ho_khau);
//        System.err.println(id_nhan_khau);
//        System.err.println(id_ho_khau);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return true;
    }
     
    // lay ra 10 ho khau
    public List<HoKhauBean> getListHoKhau() {
        List<HoKhauBean> list = new ArrayList<>();
        
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM ho_khau INNER JOIN nhan_khau ON ho_khau.idChuHo = nhan_khau.ID";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                HoKhauBean temp = new HoKhauBean();
                HoKhauModel hoKhauModel = temp.getHoKhauModel();
                hoKhauModel.setID(rs.getInt("ID"));
                hoKhauModel.setIdChuHo(rs.getInt("idCHuHo"));
                hoKhauModel.setMaHoKhau(rs.getString("maHoKhau"));
                hoKhauModel.setMaKhuVuc(rs.getString("maKhuVuc"));
                hoKhauModel.setNgayLap(rs.getDate("ngayLap"));
                hoKhauModel.setDiaChi(rs.getString("diaChi"));
                NhanKhauModel chuHo = temp.getChuHo();
                chuHo.setID(rs.getInt("ID"));
                chuHo.setHoTen(rs.getString("hoTen"));
                chuHo.setGioiTinh(rs.getString("gioiTinh"));
                chuHo.setNamSinh(rs.getDate("namSinh"));
                chuHo.setDiaChiHienNay(rs.getString("diaChiHienNay"));
                try {
                    String sql = "SELECT * FROM nhan_khau INNER JOIN thanh_vien_cua_ho ON nhan_khau.ID = thanh_vien_cua_ho.idNhanKhau "
                            + "WHERE thanh_vien_cua_ho.idHoKhau = "
                            + hoKhauModel.getID();
                    PreparedStatement prst = connection.prepareStatement(sql);
                    ResultSet rs_1 = prst.executeQuery();
                    List<NhanKhauModel> listNhanKhau = temp.getListNhanKhauModels();
                    List<ThanhVienCuaHoModel> listThanhVienCuaHo = temp.getListThanhVienCuaHo();
                    while (rs_1.next()) {
                        NhanKhauModel nhanKhauModel = new NhanKhauModel();
                        ThanhVienCuaHoModel thanhVienCuaHoModel = new ThanhVienCuaHoModel();
                        nhanKhauModel.setID(rs_1.getInt("idNhanKhau"));
                        nhanKhauModel.setBietDanh(rs_1.getString("bietDanh"));
                        nhanKhauModel.setHoTen(rs_1.getString("hoTen"));
                        nhanKhauModel.setGioiTinh(rs_1.getString("gioiTinh"));
                        nhanKhauModel.setNamSinh(rs_1.getDate("namSinh"));
                        nhanKhauModel.setNguyenQuan(rs_1.getString("nguyenQuan"));
                        nhanKhauModel.setTonGiao(rs_1.getString("tonGiao"));
                        nhanKhauModel.setDanToc(rs_1.getString("danToc"));
                        nhanKhauModel.setQuocTich(rs_1.getString("quocTich"));
                        nhanKhauModel.setSoHoChieu(rs_1.getString("soHoChieu"));
                        nhanKhauModel.setNoiThuongTru(rs_1.getString("noiThuongTru"));
                        nhanKhauModel.setDiaChiHienNay(rs_1.getString("diaChiHienNay"));
                        
                        thanhVienCuaHoModel.setIdHoKhau(rs_1.getInt("idHoKhau"));
                        thanhVienCuaHoModel.setIdNhanKhau(rs_1.getInt("idNhanKhau"));
                        thanhVienCuaHoModel.setQuanHeVoiChuHo(rs_1.getString("quanHeVoiChuHo"));
                        listNhanKhau.add(nhanKhauModel);
                        listThanhVienCuaHo.add(thanhVienCuaHoModel);
                    }
                } catch (Exception e) {
                    System.out.println("services.HoKhauService.getListHoKhau()");
                    System.out.println(e.getMessage());
                }
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    // tim kiem the ten chu ho va ma ho khau
    public List<HoKhauBean> search(String key) {
        List<HoKhauBean> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * "
                        + "FROM ho_khau "
                        + "INNER JOIN nhan_khau "
                        + "ON ho_khau.idChuHo = nhan_khau.ID "
                        + "WHERE MATCH(maHoKhau) AGAINST ('"
                        + key
                        + "' IN NATURAL LANGUAGE MODE);";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                HoKhauBean temp = new HoKhauBean();
                HoKhauModel hoKhauModel = temp.getHoKhauModel();
                hoKhauModel.setID(rs.getInt("ID"));
                hoKhauModel.setIdChuHo(rs.getInt("idChuHo"));
                hoKhauModel.setMaHoKhau(rs.getString("maHoKhau"));
                hoKhauModel.setMaKhuVuc(rs.getString("maKhuVuc"));
                hoKhauModel.setNgayLap(rs.getDate("ngayLap"));
                hoKhauModel.setDiaChi(rs.getString("diaChi"));
                NhanKhauModel chuHo = temp.getChuHo();
                chuHo.setID(rs.getInt("ID"));
                chuHo.setHoTen(rs.getString("hoTen"));
                chuHo.setGioiTinh(rs.getString("gioiTinh"));
                chuHo.setNamSinh(rs.getDate("namSinh"));
                chuHo.setDiaChiHienNay(rs.getString("diaChiHienNay"));
                try {
                    String sql = "SELECT * FROM nhan_khau INNER JOIN thanh_vien_cua_ho ON nhan_khau.ID = thanh_vien_cua_ho.idNhanKhau "
                            + "WHERE thanh_vien_cua_ho.idHoKhau = "
                            + hoKhauModel.getID();
                    PreparedStatement prst = connection.prepareStatement(sql);
                    ResultSet rs_1 = prst.executeQuery();
                    List<NhanKhauModel> listNhanKhau = temp.getListNhanKhauModels();
                    List<ThanhVienCuaHoModel> listThanhVienCuaHo = temp.getListThanhVienCuaHo();
                    while (rs_1.next()) {
                        NhanKhauModel nhanKhauModel = new NhanKhauModel();
                        ThanhVienCuaHoModel thanhVienCuaHoModel = new ThanhVienCuaHoModel();
                        nhanKhauModel.setID(rs_1.getInt("ID"));
                        nhanKhauModel.setBietDanh(rs_1.getString("bietDanh"));
                        nhanKhauModel.setHoTen(rs_1.getString("hoTen"));
                        nhanKhauModel.setGioiTinh(rs_1.getString("gioiTinh"));
                        nhanKhauModel.setNamSinh(rs_1.getDate("namSinh"));
                        nhanKhauModel.setNguyenQuan(rs_1.getString("nguyenQuan"));
                        nhanKhauModel.setTonGiao(rs_1.getString("tonGiao"));
                        nhanKhauModel.setDanToc(rs_1.getString("danToc"));
                        nhanKhauModel.setQuocTich(rs_1.getString("quocTich"));
                        nhanKhauModel.setSoHoChieu(rs_1.getString("soHoChieu"));
                        nhanKhauModel.setNoiThuongTru(rs_1.getString("noiThuongTru"));
                        nhanKhauModel.setDiaChiHienNay(rs_1.getString("diaChiHienNay"));
                        
                        thanhVienCuaHoModel.setIdHoKhau(rs_1.getInt("idHoKhau"));
                        thanhVienCuaHoModel.setIdNhanKhau(rs_1.getInt("ID"));
                        thanhVienCuaHoModel.setQuanHeVoiChuHo(rs_1.getString("quanHeVoiChuHo"));
                        listNhanKhau.add(nhanKhauModel);
                        listThanhVienCuaHo.add(thanhVienCuaHoModel);
                    }
                } catch (Exception e) {
                    System.out.println("services.HoKhauService.search()");
                    System.out.println(e.getMessage());
                }
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public List<HoKhauBean> search(String key, String chu_ho, String dia_chi) {
        List<HoKhauBean> list = new ArrayList<>();
        try {
        	Boolean hasAndBoolean = false;
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * "
                        + "FROM ho_khau "
                        + "INNER JOIN nhan_khau "
                        + "ON ho_khau.idChuHo = nhan_khau.ID ";
            if (!key.isEmpty() || !chu_ho.isEmpty() || !dia_chi.isEmpty()) {
            	query += " WHERE ";
            }
            if (!key.isEmpty()) {
            	hasAndBoolean = true;
            	query += "mahokhau LIKE '%"
                        + key
                        + "%'"
    						;
            }
            if (!chu_ho.isEmpty()) {
            	if (hasAndBoolean == true) {
            		query += " AND ";
            	}
            	hasAndBoolean = true;
            	query += "hoten LIKE '%"
                        + chu_ho
                        + "%'"
						;
            }
            if (!dia_chi.isEmpty()) {
            	if (hasAndBoolean == true) {
            		query += " AND ";
            	}
            	hasAndBoolean = true;
            	query += "diachi LIKE '%"
                        + dia_chi
                        + "%' "
						;
            }
            //System.err.println(query);
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                HoKhauBean temp = new HoKhauBean();
                HoKhauModel hoKhauModel = temp.getHoKhauModel();
                hoKhauModel.setID(rs.getInt("ID"));
                hoKhauModel.setIdChuHo(rs.getInt("idChuHo"));
                hoKhauModel.setMaHoKhau(rs.getString("maHoKhau"));
                hoKhauModel.setDiaChi(rs.getString("diaChi"));
                NhanKhauModel chuHo = temp.getChuHo();
                chuHo.setID(rs.getInt("ID"));
                chuHo.setHoTen(rs.getString("hoTen"));
//                chuHo.setGioiTinh(rs.getString("gioiTinh"));
//                chuHo.setNamSinh(rs.getDate("namSinh"));
//                chuHo.setDiaChiHienNay(rs.getString("diaChiHienNay"));
//                try {
//                    String sql = "SELECT * FROM nhan_khau INNER JOIN thanh_vien_cua_ho ON nhan_khau.ID = thanh_vien_cua_ho.idNhanKhau "
//                            + "WHERE thanh_vien_cua_ho.idHoKhau = "
//                            + hoKhauModel.getID();
//                    PreparedStatement prst = connection.prepareStatement(sql);
//                    ResultSet rs_1 = prst.executeQuery();
//                    List<NhanKhauModel> listNhanKhau = temp.getListNhanKhauModels();
//                    List<ThanhVienCuaHoModel> listThanhVienCuaHo = temp.getListThanhVienCuaHo();
//                    while (rs_1.next()) {
//                        NhanKhauModel nhanKhauModel = new NhanKhauModel();
//                        ThanhVienCuaHoModel thanhVienCuaHoModel = new ThanhVienCuaHoModel();
//                        nhanKhauModel.setID(rs_1.getInt("ID"));
//                        nhanKhauModel.setBietDanh(rs_1.getString("bietDanh"));
//                        nhanKhauModel.setHoTen(rs_1.getString("hoTen"));
//                        nhanKhauModel.setGioiTinh(rs_1.getString("gioiTinh"));
//                        nhanKhauModel.setNamSinh(rs_1.getDate("namSinh"));
//                        nhanKhauModel.setNguyenQuan(rs_1.getString("nguyenQuan"));
//                        nhanKhauModel.setTonGiao(rs_1.getString("tonGiao"));
//                        nhanKhauModel.setDanToc(rs_1.getString("danToc"));
//                        nhanKhauModel.setQuocTich(rs_1.getString("quocTich"));
//                        nhanKhauModel.setSoHoChieu(rs_1.getString("soHoChieu"));
//                        nhanKhauModel.setNoiThuongTru(rs_1.getString("noiThuongTru"));
//                        nhanKhauModel.setDiaChiHienNay(rs_1.getString("diaChiHienNay"));
//                        
//                        thanhVienCuaHoModel.setIdHoKhau(rs_1.getInt("idHoKhau"));
//                        thanhVienCuaHoModel.setIdNhanKhau(rs_1.getInt("ID"));
//                        thanhVienCuaHoModel.setQuanHeVoiChuHo(rs_1.getString("quanHeVoiChuHo"));
//                        listNhanKhau.add(nhanKhauModel);
//                        listThanhVienCuaHo.add(thanhVienCuaHoModel);
//                    }
//                } catch (Exception e) {
//                    System.out.println("services.HoKhauService.search()");
//                    System.out.println(e.getMessage());
//                }
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    /**
     * ham tao moi ho khau va up date lai thong tin nhan khau co trong ho cu
     * @param hoKhauBean ho khau moi duoc tach ra
     */
    public void tachHoKhau(HoKhauBean hoKhauBean) {
        /**
         * xoa cac thanh vien co trong moi ra khoi bang thanh_vien_cua_ho
         */
        
        // xoa chu ho
        String query = "DELETE FROM thanh_vien_cua_ho WHERE idNhanKhau = " + hoKhauBean.getChuHo().getID();   
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int rs = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // xoa cac thanh vien
        
        hoKhauBean.getListThanhVienCuaHo().forEach((ThanhVienCuaHoModel item) -> {
            String sql = "DELETE FROM thanh_vien_cua_ho WHERE idNhanKhau = " + item.getIdHoKhau();
            try {
                Connection connection = MysqlConnection.getMysqlConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                int rs = preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        
        /**
         * tao ho khau moi voi hoKhauBean
         */
        try {
            this.addNew(hoKhauBean);
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
        } catch (Exception e) {
            System.out.println("services.HoKhauService.tachHoKhau()");
        } 
    }
    public void chuyenDi(int idhoKhau, String noiChuyenDen, String lyDoChuyen) {
        String sql = "UPDATE ho_khau SET lyDoChuyen = '"
                + lyDoChuyen
                + "',"
                + "ngayChuyenDi = NOW(), "
                + "diaChi = '"
                + noiChuyenDen
                + "',"
                + "nguoiThucHien = "
                + LoginController.currentUser.getID()
                + " WHERE ho_khau.ID = " + idhoKhau;
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int rs = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("services.HoKhauService.chuyenDi()");
            System.out.println(e.getMessage());
        }
    }
    public void updateQuanHe(int id, String quanheString) {
        String query = "UPDATE thanh_vien_cua_ho\r\n"
        		+ "SET quanhevoichuho = ?\r\n"
        		+ "WHERE idnhankhau = ?";
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, quanheString);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}











