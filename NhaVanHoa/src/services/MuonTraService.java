package services;

import Bean.MuonTraBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
    public List<MuonTraBean> search(String tenNguoiMuon, String lienHe, Timestamp tuNgayTimeStamp, Timestamp denNgayTimeStamp) {
        List<MuonTraBean> list = new  ArrayList<>();
        TimeService timeService = new TimeService();
        String tuNgay = timeService.convertToDate(tuNgayTimeStamp);
        String denNgay = timeService.convertToDate(denNgayTimeStamp);
        Connection connection;
        
        try {
			connection = MysqlConnection.getMysqlConnection();						
			String query1 = "SELECT s.event_no, r.user_name, r.cccd, r.user_phone, s.time_start, s.time_end, i.item_name, ir.item_number "
			    	  + "FROM registers r JOIN itemregistered ir ON r.user_id = ir.user_id "
			    	  + "JOIN schedule s ON ir.event_no = s.event_no JOIN item i ON i.item_id = ir.item_id "
			    	  + "WHERE r.user_name LIKE '%"
			    	  + tenNguoiMuon
			    	  + "%' AND CAST(r.user_phone as character) = "
			    	  + lienHe
			    	  + " AND CAST(s.time_start as date) BETWEEN "
			    	  + tuNgay
			    	  + " AND "
			    	  + denNgay;
			String query2 = "SELECT s.event_no, r.user_name, r.cccd, r.user_phone, s.time_start, s.time_end, i.infra_name "
		  		  	  + "FROM registers r JOIN infraregistered ir ON r.user_id = ir.user_id "
		  		  	  + "JOIN schedule s ON ir.event_no = s.event_no JOIN infrastructure i ON i.infra_id = ir.infra_id "
		  		  	  + "WHERE r.user_name LIKE '%"
			    	  + tenNguoiMuon
			    	  + "%' AND CAST(r.user_phone as character) = "
			    	  + lienHe
			    	  + " AND CAST(s.time_start as date) BETWEEN "
			    	  + tuNgay
			    	  + " AND "
			    	  + denNgay;
	        PreparedStatement preparedStatement1 = (PreparedStatement)connection.prepareStatement(query1);
	        ResultSet rs1 = preparedStatement1.executeQuery();
	        PreparedStatement preparedStatement2 = (PreparedStatement)connection.prepareStatement(query2);
	        ResultSet rs2 = preparedStatement2.executeQuery();
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
	        while(rs2.next()) {
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
	        preparedStatement2.close();
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
        	String query1 = "SELECT i.item_name, i.item_quantity, s.real_time_end FROM item i LEFT JOIN deleteditem d ON i.item_id = d.item_id "
        				  + "LEFT JOIN itemregistered ir ON "
        				  + "i.item_id = ir.item_id LEFT JOIN registers r ON r.user_id = ir.user_id LEFT JOIN schedule s "
        				  + "ON s.event_no = ir.event_no WHERE r.cccd = " + cccdNguoiMuon + " AND s.time_start = '"+ thoiGianMuon + "'";
        	PreparedStatement st1 = (PreparedStatement)connection.prepareStatement(query1);
        	ResultSet rs1 = st1.executeQuery();
        	while(rs1.next()) {
        		int soLuongDaTra = rs1.getInt(2);
        		CoSoVatChatModel coSoVatChatModel = new CoSoVatChatModel();
        		coSoVatChatModel.setTenCoSoVatChat(rs1.getString(1));
        		coSoVatChatModel.setSoLuong(rs1.getInt(2));
        		coSoVatChatModel.setThoiGianTraReal(rs1.getTimestamp(3));
        		if (rs1.getTimestamp(3) == null) coSoVatChatModel.setSoLuongDaTra(1);
        		else {
        			String query2 = "SELECT item_number FROM deleteditem d LEFT JOIN item i ON d.item_id = i.item_id WHERE i.item_name = '"
        						  + rs1.getString(1)
        						  + "' AND d.date = '" + rs1.getTimestamp(3) + "'";
        			PreparedStatement st2 = (PreparedStatement)connection.prepareStatement(query2);
        			ResultSet rs2 = st2.executeQuery();
        			while(rs2.next()) soLuongDaTra-=rs2.getInt(1);
        			coSoVatChatModel.setSoLuongDaTra(soLuongDaTra);
        			st2.close();
        		}
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
        	String query1 = "DELETE FROM itemregistered WHERE user_id = (SELECT user_id FROM registers WHERE cccd = '" 
        				  + cccdNguoiMuon + "') AND event_no = (SELECT event_no FROM schedule WHERE time_start = '"+ timestamp + "')";
        	PreparedStatement st1 = (PreparedStatement)connection.prepareStatement(query1);
        	st1.executeQuery();
	        st1.close();
	        String query2 = "DELETE FROM infraregistered WHERE user_id = (SELECT user_id FROM registers WHERE cccd = '" 
  				  		  + cccdNguoiMuon + "') AND event_no = (SELECT event_no FROM schedule WHERE time_start = '"+ timestamp + "')";
	        PreparedStatement st2 = (PreparedStatement)connection.prepareStatement(query2);
	        st2.executeQuery();
	        st2.close();	     	        
	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
            return false;
        }
		return true;
	}
    
    /*
     * ban giao toan bo csvc, phong ban theo cccd nguoi muon
     */
    public boolean hoanTraToanBo(String cccdNguoiMuon, String thoiGianMuon) {
		// TODO Auto-generated method stub
    	Timestamp timestamp = Timestamp.valueOf(thoiGianMuon);
    	try {
        	Connection connection = MysqlConnection.getMysqlConnection();
        	String query = "UPDATE schedule SET real_time_end = CURRENT_TIMESTAMP WHERE event_no = (SELECT event_no FROM itemregistered ir LEFT JOIN schedule s ON "
        			  + "ir.event_no = s.event_no WHERE s.time_start = '"+ timestamp + "' AND "
        			  + "ir.user_id = (SELECT user_id FROM registers WHERE cccd = '" + cccdNguoiMuon + "'))";
          	PreparedStatement st = (PreparedStatement)connection.prepareStatement(query);
  	        st.executeQuery();
  	        st.close();
  	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
            return false;
        }
		return true;
	}
    
    /*
     * input: cccd nguoi muon, coSoVatChatModel.tenCoSoVatChat, coSoVatChatModel.soLuongMuon, thoi gian muon
     * tra ve false neu so luong duoc chinh sua > so luong con lai trong kho
     */
    public boolean chinhSuaCoSoVatChatMuon(String cccdNguoiMuon, CoSoVatChatModel coSoVatChatModel, String thoiGianMuon) {
    	Timestamp timestamp = Timestamp.valueOf(thoiGianMuon);
    	try {
        	Connection connection = MysqlConnection.getMysqlConnection();
        	String query = "SELECT (i.item_quantity-COALESCE(sum(ir.item_number), 0)) FROM item i LEFT JOIN itemregistered ir "
        				 + "ON i.item_id = ir.item_id WHERE i.item_name = '" + coSoVatChatModel.getTenCoSoVatChat() + "' GROUP BY "
        				 + "i.item_id";
        	PreparedStatement st = (PreparedStatement)connection.prepareStatement(query);
  	        ResultSet rs = st.executeQuery();
  	        int remain = rs.getInt(1);
  	        String query2 = "SELECT ir.item_number FROM item i LEFT JOIN itemregistered ir ON i.item_id = ir.item_id WHERE i.item_name ="
  	        			  + coSoVatChatModel.getTenCoSoVatChat() + " AND ir.user_id = (SELECT user_id FROM registers WHERE cccd = '"
  	        			  + cccdNguoiMuon + "') AND ir.event_no = (SELECT event_no FROM schedule WHERE time_start = '" + timestamp
  	        			  + "')";
  	        PreparedStatement st2 = (PreparedStatement)connection.prepareStatement(query2);
	        ResultSet rs2 = st2.executeQuery();
	        int dangMuon = rs2.getInt(1);
	        if(coSoVatChatModel.getSoLuongMuon() > remain + dangMuon) return false;
        	String query1 = "UPDATE itemregisters SET item_number = " + coSoVatChatModel.getSoLuongMuon() 
        				  + " WHERE event_no = (SELECT event_no FROM itemregistered ir LEFT JOIN schedule s ON "
        			  	  + "ir.event_no = s.event_no WHERE s.time_start = '"+ timestamp + "' AND "
        			  	  + "ir.user_id = (SELECT user_id FROM registers WHERE cccd = '" + cccdNguoiMuon + "'))";
          	PreparedStatement st1 = (PreparedStatement)connection.prepareStatement(query1);
  	        st1.executeQuery();
  	        st1.close();
  	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
            return false;
        }
		return true;	
    }
    
    /*
     * huy ten csvc dang ky muon hien tai theo ten csvc va theo cccd nguoi muon
     */
    public boolean huyMuonCoSoVatChat(String cccdNguoiMuon, String tenCoSoVatChat, String thoiGianMuon) {
    	Timestamp timestamp = Timestamp.valueOf(thoiGianMuon);
    	try {
    		Connection connection = MysqlConnection.getMysqlConnection();
    	    String query = "DELETE FROM itemregistered WHERE user_id = (SELECT user_id FROM registers WHERE cccd = '"
   				 		 + cccdNguoiMuon + "') AND item_id = (SELECT item_id FROM item WHERE item_name = '"
   				 		 + tenCoSoVatChat + "') AND event_no = (SELECT event_no FROM schedule WHERE time_start = '"
   				 		 + timestamp + "')";
    	    PreparedStatement st = (PreparedStatement)connection.prepareStatement(query);
    	  	st.executeQuery();
    	  	st.close();
    	  	connection.close();
    		} catch (Exception e) {
    	        this.exceptionHandle(e.getMessage());
    	        return false;
    	    }
		return true;	
    }
    
    /*
     * input: cccd nguoi muon, coSoVatChatModel.tenCoSoVatChat, coSoVatChatModel.soLuongDaTra, thoi gian muon, thoiGianDaTraReal = thoi gian hien tai
     * so luong thieu = so luong da muon - so luong da tra, so luong thieu add vao bang xoa trong csdl, thoi gian add la thoi gian them hien tai
     */
    public boolean hoanTraCoSoVatChatMuon(String cccdNguoiMuon, CoSoVatChatModel coSoVatChatModel, String thoiGianMuon) {
    	Timestamp timestamp = Timestamp.valueOf(thoiGianMuon);
    	Date date = new Date();
    	Timestamp currentTimestamp = new Timestamp(date.getTime());
    	try {
        	Connection connection = MysqlConnection.getMysqlConnection();
        	String query = "UPDATE schedule SET real_time_end = '" + currentTimestamp + "' WHERE event_no = (SELECT event_no FROM itemregistered ir LEFT JOIN schedule s ON "
        			  	 + "ir.event_no = s.event_no WHERE s.time_start = '"+ timestamp + "' AND "
        			  	 + "ir.user_id = (SELECT user_id FROM registers WHERE cccd = '" + cccdNguoiMuon + "'))";
          	PreparedStatement st = (PreparedStatement)connection.prepareStatement(query);
  	        st.executeQuery();
  	        st.close();
  	        String query1 = "INSERT INTO deleteditem (item_id, date_delete, reason, item_number) VALUES "
  	        			  + "((SELECT item_id FROM item WHERE item_name = '" + coSoVatChatModel.getTenCoSoVatChat() + "'), '"
  	        			  + currentTimestamp + "', concat((SELECT user_name FROM registers WHERE cccd = '" + cccdNguoiMuon + "'), ' làm mất'), ?)";
  	        PreparedStatement st1 = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
  	        st1.setInt(1, coSoVatChatModel.getSoLuongMuon() - coSoVatChatModel.getSoLuongDaTra());
  	        st1.executeUpdate();
  	        st1.close();
  	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
            return false;
        }
		return true;	
    }
    
    /*
     * huy ten phong ban dang ky muon hien tai theo ten phong ban va theo cccd nguoi muon
     */
    public boolean huyMuonPhongBan(String cccdNguoiMuon, String tenPhongBan, String thoiGianMuon) {
    	Timestamp timestamp = Timestamp.valueOf(thoiGianMuon);
    	try {
    		Connection connection = MysqlConnection.getMysqlConnection();
    	    String query = "DELETE FROM infraregistered WHERE user_id = (SELECT user_id FROM registers WHERE cccd = '"
   				 		 + cccdNguoiMuon + "') AND infra_id = (SELECT infra_id FROM infrastructure WHERE infra_name = '"
   				 		 + tenPhongBan + "') AND event_no = (SELECT event_no FROM schedule WHERE time_start = '"
   				 		 + timestamp + "')";
    	    PreparedStatement st = (PreparedStatement)connection.prepareStatement(query);
    	  	st.executeQuery();
    	  	st.close();
    	  	connection.close();
    		} catch (Exception e) {
    	        this.exceptionHandle(e.getMessage());
    	        return false;
    	    }
		return true;	
    }
    
    /*
     * input: cccd nguoi muon, tenPhongBan , thoi gian muon, thoiGianDaTraReal = thoi gian hien tai
     */
    public boolean hoanTraPhongBanMuon(String cccdNguoiMuon, String tenPhongBan, String thoiGianMuon) {
    	Timestamp timestamp = Timestamp.valueOf(thoiGianMuon);
    	try {
        	Connection connection = MysqlConnection.getMysqlConnection();
        	String query = "UPDATE schedule SET real_time_end = CURRENT_TIMESTAMP WHERE event_no = (SELECT event_no FROM infraregistered ir LEFT JOIN schedule s ON "
        			  + "ir.event_no = s.event_no WHERE s.time_start = '"+ timestamp + "' AND "
        			  + "ir.user_id = (SELECT user_id FROM registers WHERE cccd = '" + cccdNguoiMuon + "'))";
          	PreparedStatement st = (PreparedStatement)connection.prepareStatement(query);
  	        st.executeQuery();
  	        st.close();
  	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
            return false;
        }
		return true;	
    }
    
    /*
     * input: cccd nguoi muon, coSoVatChatModel.tenCoSoVatChat, coSoVatChatModel.soLuongDaTra, thoi gian muon, thoiGianDaTraReal = thoi gian hien tai
     * so luong thieu = so luong da muon - so luong da tra, so luong thieu add vao bang xoa trong csdl, thoi gian add la thoi gian them hien tai
     * kiem tra soLuongDaTra hien tai truoc khi chinh sua, check thoi gian da tra real va check tai bang xoa de biet so luong da tra hien tai
     * out put: giu nguyen thoi gian da tra neu soLuongDaTra > 0, thay doi thong tin o bang xoa trong csdl
     */
    
    public boolean chinhSuaHoanTraCoSoVatChat(String cccdNguoiMuon, CoSoVatChatModel coSoVatChatModel, String thoiGianMuon) {
    	Timestamp timestamp = Timestamp.valueOf(thoiGianMuon);
    	Date date = new Date();
    	Timestamp currentTimestamp = new Timestamp(date.getTime());
    	if (coSoVatChatModel.getSoLuongMuon() - coSoVatChatModel.getSoLuongDaTra() == 0) try {
        	Connection connection = MysqlConnection.getMysqlConnection();
  	        String query1 = "DELETE FROM deleteditem WHERE item_id = (SELECT item_id FROM item WHERE item_name = '" + coSoVatChatModel.getTenCoSoVatChat()
  	        			  + "') AND date_delete = '" + coSoVatChatModel.getThoiGianTraReal() + "'";
  	        PreparedStatement st1 = (PreparedStatement)connection.prepareStatement(query1);
  	        st1.executeQuery();
  	        st1.close();
  	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
            return false;
        }
    	else try {
    		int lamMat = coSoVatChatModel.getSoLuongMuon() - coSoVatChatModel.getSoLuongDaTra();
        	Connection connection = MysqlConnection.getMysqlConnection();
        	String query1 = "UPDATE deleteditem SET item_number = " + lamMat + " WHERE item_id = (SELECT item_id FROM item WHERE item_name = '" + coSoVatChatModel.getTenCoSoVatChat()
			  			  + "') AND date_delete = '" + coSoVatChatModel.getThoiGianTraReal() + "'";
  	        PreparedStatement st1 = (PreparedStatement)connection.prepareStatement(query1);
  	        st1.executeQuery();
  	        st1.close();
  	        connection.close();
		} catch (Exception e) {
            this.exceptionHandle(e.getMessage());
            return false;
        }
    	return true;
    }
    
    /*
     * input: cccd nguoi muon, coSoVatChatModel.tenCoSoVatChat, coSoVatChatModel.soLuongDaTra, thoi gian muon, thoiGianDaTraReal = thoi gian hien tai
     * out put: neu tenPhongBanMuon co thoiGianTraReal thi xoa thoiGianTraReal, va nguoc lai neu tenPhongBanMuon khong co thoiGianTraReal thi add
     * thoiGianTraReal la thoiGianHienTai, thay doi thong tin o bang xoa trong csdl
     */
    public boolean chinhSuaHoanTraPhongBan(String cccdNguoiMuon, String tenPhongBan, String thoiGianMuon) {
    	
    	return true;
    }
    
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }

	
}
