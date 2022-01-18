package services;

import Bean.MuonTraBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

import models.CoSoVatChatModel;
import models.MuonTraModel;
import models.PhongBanModel;


/**
 *
 * @author Hai
 */
public class MuonTraService {
    
    /* 
     * Ham lay ra 1 nguoi muon trong database thong qua id
     * id la cccd, tcc, hc
     * 
     */
    public MuonTraBean getMuonTra(String id) {
        MuonTraBean muonTraBean = new MuonTraBean(); 
        Connection connection;
        
        try {
			connection = MysqlConnection.getMysqlConnection();
			 
			String query1 = "SELECT s.event_no, r.user_name, r.cccd, r.user_phone, s.time_start, s.time_end, i.item_name, ir.item_number "
      			  + "FROM registers r JOIN itemregistered ir ON r.user_id = ir.user_id "
      			  + "JOIN schedule s ON ir.event_no = s.event_no JOIN item i ON i.item_id = ir.item_id "
      			  + "WHERE CAST(r.cccd AS character) = '"
      			  + id + "'";
			String query2 = "SELECT s.event_no, r.user_name, r.cccd, r.user_phone, s.time_start, s.time_end, i.infra_name "
			  		  + "FROM registers r JOIN infraregistered ir ON r.user_id = ir.user_id "
			  		  + "JOIN schedule s ON ir.event_no = s.event_no JOIN infrastructure i ON i.infra_id = ir.infra_id "
			  		  + "WHERE CAST(r.cccd AS character) = '"
			  		  + id + "'";
	        PreparedStatement preparedStatement1 = (PreparedStatement)connection.prepareStatement(query1);
	        ResultSet rs1 = preparedStatement1.executeQuery();

	        while(rs1.next()) {
	        	MuonTraModel muonTra = muonTraBean.getMuonTraModel();
	        	muonTra.setStt(rs1.getInt("event_no"));
	        	muonTra.setTenNguoiMuon(rs1.getString("user_name"));
	        	muonTra.setid(rs1.getString("cccd"));
	        	muonTra.setLienHe(rs1.getString("user_phone"));
	        	muonTra.setThoiGianMuon(rs1.getTimestamp("time_start"));
	        	muonTra.setThoiGianTra(rs1.getTimestamp("time_end"));
	        	muonTra.setCoSoVatChat(rs1.getString("item_name"));
	        	muonTra.setSoLuong(rs1.getInt("item_number"));
	        }
	        preparedStatement1 = (PreparedStatement)connection.prepareStatement(query2);
	        rs1 = preparedStatement1.executeQuery();
	        while(rs1.next()) {
	        	MuonTraModel muonTra = muonTraBean.getMuonTraModel();
	        	muonTra.setStt(rs1.getInt("event_no"));
	        	muonTra.setTenNguoiMuon(rs1.getString("user_name"));
	        	muonTra.setid(rs1.getString("cccd"));
	        	muonTra.setLienHe(rs1.getString("user_phone"));
	        	muonTra.setThoiGianMuon(rs1.getTimestamp("time_start"));
	        	muonTra.setThoiGianTra(rs1.getTimestamp("time_end"));
	        	muonTra.setCoSoVatChat(rs1.getString("infra_name"));
	        	muonTra.setSoLuong(1);
	        }
	        preparedStatement1.close();
	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        return muonTraBean;
    }
    
     // lay danh sach nguoi muon
    public List<MuonTraBean> getListMuonTra() {
    	
    	List<MuonTraBean> list = new ArrayList<>();
        Connection connection;
        
        try {
			connection = MysqlConnection.getMysqlConnection();						
	        String query1 = "SELECT s.event_no, r.user_name, r.cccd, r.user_phone, s.time_start, s.time_end, i.item_name, ir.item_number "
	  			  		  + "FROM registers r JOIN itemregistered ir ON r.user_id = ir.user_id "
	  			  		  + "JOIN schedule s ON ir.event_no = s.event_no JOIN item i ON i.item_id = ir.item_id ";
	        String query2 = "SELECT s.event_no, r.user_name, r.cccd, r.user_phone, s.time_start, s.time_end, i.infra_name "
			  		  	  + "FROM registers r JOIN infraregistered ir ON r.user_id = ir.user_id "
			  		  	  + "JOIN schedule s ON ir.event_no = s.event_no JOIN infrastructure i ON i.infra_id = ir.infra_id ";
	        PreparedStatement preparedStatement1 = (PreparedStatement)connection.prepareStatement(query1);
	        ResultSet rs1 = preparedStatement1.executeQuery();

	        while(rs1.next()) {
	        	MuonTraBean muonTraBean = new MuonTraBean(); 
	        	MuonTraModel muonTra = muonTraBean.getMuonTraModel();
	        	muonTra.setStt(rs1.getInt("event_no"));
	        	muonTra.setTenNguoiMuon(rs1.getString("user_name"));
	        	muonTra.setid(rs1.getString("cccd"));
	        	muonTra.setLienHe(rs1.getString("user_phone"));
	        	muonTra.setThoiGianMuon(rs1.getTimestamp("time_start"));
	        	muonTra.setThoiGianTra(rs1.getTimestamp("time_end"));
	        	muonTra.setCoSoVatChat(rs1.getString("item_name"));
	        	muonTra.setSoLuong(rs1.getInt("item_number"));
                list.add(muonTraBean);
	        }
	        preparedStatement1 = (PreparedStatement)connection.prepareStatement(query2);
	        rs1 = preparedStatement1.executeQuery();
	        while(rs1.next()) {
	        	MuonTraBean muonTraBean = new MuonTraBean(); 
	        	MuonTraModel muonTra = muonTraBean.getMuonTraModel();
	        	muonTra.setStt(rs1.getInt("event_no"));
	        	muonTra.setTenNguoiMuon(rs1.getString("user_name"));
	        	muonTra.setid(rs1.getString("cccd"));
	        	muonTra.setLienHe(rs1.getString("user_phone"));
	        	muonTra.setThoiGianMuon(rs1.getTimestamp("time_start"));
	        	muonTra.setThoiGianTra(rs1.getTimestamp("time_end"));
	        	muonTra.setCoSoVatChat(rs1.getString("infra_name"));
	        	muonTra.setSoLuong(1);
                list.add(muonTraBean);
	        }
	        preparedStatement1.close();
	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        return list;
    }
    
    
    /*
     * ham tim kiem nhan khau theo ten, lien he, tu ngay, den ngay
     */
    public List<MuonTraBean> search(String tenNguoiMuon, String lienHe, Timestamp tuNgay, Timestamp denNgay) {
        List<MuonTraBean> list = new  ArrayList<>();
        Connection connection;
        
        try {
			connection = MysqlConnection.getMysqlConnection();						
			String query1 = "SELECT s.event_no, r.user_name, r.cccd, r.user_phone, s.time_start, s.time_end, i.item_name, ir.item_number "
			    	  + "FROM registers r JOIN itemregistered ir ON r.user_id = ir.user_id "
			    	  + "JOIN schedule s ON ir.event_no = s.event_no JOIN item i ON i.item_id = ir.item_id "
			    	  + "WHERE r.user_name LIKE '%"
			    	  + tenNguoiMuon
			    	  + "%' AND r.user_phone Like '%"
			    	  + lienHe
			    	  + "%' AND (s.time_start BETWEEN '"
			    	  + tuNgay
			    	  + "' AND '"
			    	  + denNgay + "' )";
			String query2 = "SELECT s.event_no, r.user_name, r.cccd, r.user_phone, s.time_start, s.time_end, i.infra_name "
		  		  	  + "FROM registers r JOIN infraregistered ir ON r.user_id = ir.user_id "
		  		  	  + "JOIN schedule s ON ir.event_no = s.event_no JOIN infrastructure i ON i.infra_id = ir.infra_id "
		  		  	  + "WHERE r.user_name LIKE '%"
			    	  + tenNguoiMuon
			    	  + "%' AND r.user_phone  Like '%"
			    	  + lienHe
			    	  + "%' AND (s.time_start BETWEEN '"
			    	  + tuNgay
			    	  + "' AND '"
			    	  + denNgay + "' )";
	        PreparedStatement preparedStatement1 = (PreparedStatement)connection.prepareStatement(query1);
	        System.out.println(preparedStatement1);
	        ResultSet rs1 = preparedStatement1.executeQuery();

	        while(rs1.next()) {
	        	MuonTraBean muonTraBean = new MuonTraBean(); 
	        	MuonTraModel muonTra = muonTraBean.getMuonTraModel();
	        	muonTra.setStt(rs1.getInt("event_no"));
	        	muonTra.setTenNguoiMuon(rs1.getString("user_name"));
	        	muonTra.setid(rs1.getString("cccd"));
	        	muonTra.setLienHe(rs1.getString("user_phone"));
	        	muonTra.setThoiGianMuon(rs1.getTimestamp("time_start"));
	        	muonTra.setThoiGianTra(rs1.getTimestamp("time_end"));
	        	muonTra.setCoSoVatChat(rs1.getString("item_name"));
	        	muonTra.setSoLuong(rs1.getInt("item_number"));
                list.add(muonTraBean);
	        }
	         preparedStatement1 = (PreparedStatement)connection.prepareStatement(query2);
	         rs1 = preparedStatement1.executeQuery();
	        while(rs1.next()) {
	        	MuonTraBean muonTraBean = new MuonTraBean(); 
	        	MuonTraModel muonTra = muonTraBean.getMuonTraModel();
	        	muonTra.setStt(rs1.getInt("event_no"));
	        	muonTra.setTenNguoiMuon(rs1.getString("user_name"));
	        	muonTra.setid(rs1.getString("cccd"));
	        	muonTra.setLienHe(rs1.getString("user_phone"));
	        	muonTra.setThoiGianMuon(rs1.getTimestamp("time_start"));
	        	muonTra.setThoiGianTra(rs1.getTimestamp("time_end"));
	        	muonTra.setCoSoVatChat(rs1.getString("infra_name"));
	        	muonTra.setSoLuong(1);
                list.add(muonTraBean);
	        }
	        preparedStatement1.close();
	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        return list;
    }

    
    // add cac gia tri nhan ve vao ListMuonTraDetail
    /*
     * Out put: ten csvc/phong ban, soLuongCSVC, soLuongDaTra, thoiGianTraReal
     * kiem tra soLuongDaTra hien tai bang cach check thoiGianTraReal va check bang xoa trong database cua no, 
     * neu coThoiGianTraReal va khong co thong tin trong bang xoa => tra du
     * neu coThoiGianTraReal va  co thong tin trong bang xoa => so luong da tra = soLuongMuon - soLuongXoa
     * neu khongCoThoiGianTraReal => chua tra
     */
    public MuonTraBean getChiTietMuonTra(String cccdNguoiMuon, String thoiGianMuon) {
        MuonTraBean muonTraBean = new MuonTraBean();
        List<CoSoVatChatModel> listCoSoVatChatModels = muonTraBean.getListCoSoVatChatModels();
        List<PhongBanModel> listPhongBanModels = muonTraBean.getListPhongBanModels();

        //viết truy vấn
        try {
        	Connection connection = MysqlConnection.getMysqlConnection();
        	String query1 = "SELECT i.item_name, i.item_quantity, (ir.item FROM item i LEFT JOIN deleteditem d ON i.item_id = d.item_id LEFT JOIN itemregistered ir ON "
       		     + "i.item_id = ir.item_id LEFT JOIN registers r ON r.user_id = ir.user_id LEFT JOIN schedule s "
       		     + "ON s.event_no = ir.event_no WHERE r.cccd = " + cccdNguoiMuon + " AND s.time_start = '"+ thoiGianMuon + "'";
        	PreparedStatement st1 = (PreparedStatement)connection.prepareStatement(query1);
        	ResultSet rs1 = st1.executeQuery();
        	while(rs1.next()) {
        		String query = "SELECT ";
        	}
	        st1.close();
	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        return muonTraBean;
    }
    /*
     * Ham sử lý ngoại lệ : thông báo ra lỗi nhận được
     */
    
    /*
     * huy lich muon hien tai theo cccd nguoi muon
     */
    public boolean huyLichMuon(String cccdNguoiMuon, String thoiGianMuon) {
		// TODO Auto-generated method stub
    	Timestamp timestamp = Timestamp.valueOf(thoiGianMuon);
    	try {
        	Connection connection = MysqlConnection.getMysqlConnection();
        	String query1 = "DELETE FROM itemregistered WHERE r.cccd = " + cccdNguoiMuon + " AND s.time_start = '"+ timestamp + "'";
        	PreparedStatement st1 = (PreparedStatement)connection.prepareStatement(query1);
        	ResultSet rs1 = st1.executeQuery();
        	while(rs1.next()) {
        		String query = "SELECT ";
        	}
	        st1.close();
	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
		return true;
	}
    
    /*
     * ban giao toan bo csvc, phong ban theo cccd nguoi muon
     */
    public boolean hoanTraToanBo(String cccdNguoiMuon, String thoiGianMuon) {
		// TODO Auto-generated method stub
		
		return true;
	}
    
    /*
     * input: cccd nguoi muon, coSoVatChatModel.tenCoSoVatChat, coSoVatChatModel.soLuongMuon, thoi gian muon
     * tra ve false neu so luong duoc chinh sua > so luong con lai trong kho
     */
    public boolean chinhSuaCoSoVatChatMuon(String cccdNguoiMuon, CoSoVatChatModel coSoVatChatModel, String thoiGianMuon) {
    	
		return true;	
    }
    
    /*
     * huy ten csvc dang ky muon hien tai theo ten csvc va theo cccd nguoi muon
     */
    public boolean huyMuonCoSoVatChat(String cccdNguoiMuon, String tenCoSoVatChat, String thoiGianMuon) {
    	
		return true;	
    }
    
    /*
     * input: cccd nguoi muon, coSoVatChatModel.tenCoSoVatChat, coSoVatChatModel.soLuongDaTra, thoi gian muon, thoiGianDaTraReal = thoi gian hien tai
     * so luong thieu = so luong da muon - so luong da tra, so luong thieu add vao bang xoa trong csdl, thoi gian add la thoi gian them hien tai
     */
    public boolean hoanTraCoSoVatChatMuon(String cccdNguoiMuon, CoSoVatChatModel coSoVatChatModel, String thoiGianMuon) {
    	
		return true;	
    }
    
    /*
     * huy ten phong ban dang ky muon hien tai theo ten phong ban va theo cccd nguoi muon
     */
    public boolean huyMuonPhongBan(String cccdNguoiMuon, String tenPhongBan, String thoiGianMuon) {
    	
		return true;	
    }
    
    /*
     * input: cccd nguoi muon, tenPhongBan , thoi gian muon, thoiGianDaTraReal = thoi gian hien tai
     */
    public boolean hoanTraPhongBanMuon(String cccdNguoiMuon, String tenPhongBan, String thoiGianMuon) {
    	
		return true;	
    }
    
    /*
     * input: cccd nguoi muon, coSoVatChatModel.tenCoSoVatChat, coSoVatChatModel.soLuongDaTra, thoi gian muon, thoiGianDaTraReal = thoi gian hien tai
     * so luong thieu = so luong da muon - so luong da tra, so luong thieu add vao bang xoa trong csdl, thoi gian add la thoi gian them hien tai
     * kiem tra soLuongDaTra hien tai truoc khi chinh sua, check thoi gian da tra real va check tai bang xoa de biet so luong da tra hien tai
     * out put: giu nguyen thoi gian da tra neu soLuongDaTra > 0, thay doi thong tin o bang xoa trong csdl
     */
    
    public boolean chinhSuaHoanTraCoSoVatChat(String cccdNguoiMuon, CoSoVatChatModel coSoVatChatModel, String thoiGianMuon) {
    	return true;
    }
    
    /*
     * input: cccd nguoi muon, coSoVatChatModel.tenCoSoVatChat, coSoVatChatModel.soLuongDaTra, thoi gian muon, thoiGianDaTraReal = thoi gian hien tai
     * out put: neu tenPhongBanMuon co thoiGianTraReal thi xoa thoiGianTraReal, va nguoc lai neu tenPhongBanMuon khong co thoiGianTraReal thi add
     * thoiGianTraReal la thoiGianHienTai, thay doi thong tin o bang xoa trong csdl
     */
    public boolean chinhSuaHoanTraPhongBan(String cccdNguoiMuon, String tenPhongBan, String thoiGianMuon, String thoiGianTraReal) {
    	return true;
    }
    
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }

	
}
