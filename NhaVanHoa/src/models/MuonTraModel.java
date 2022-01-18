package models;
import java.sql.Timestamp;

import services.TimeService;


/**
 *
 * @author Hai
 */
public class MuonTraModel {
    private int stt;
    private String tenNguoiMuon;
    private String id;
    private String lienHe;
	private Timestamp thoiGianMuon;
    private Timestamp thoiGianTra;
    private String coSoVatChat;
    private int soLuong = -1;
    private TimeService timeService = new TimeService();
    
    public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public String getTenNguoiMuon() {
		return tenNguoiMuon;
	}
	public void setTenNguoiMuon(String tenNguoiMuon) {
		this.tenNguoiMuon = tenNguoiMuon;
	}
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getLienHe() {
		return lienHe;
	}
	public void setLienHe(String lienHe) {
		this.lienHe = lienHe;
	}
	public Timestamp getThoiGianMuon() {
		return thoiGianMuon;
	}
	public void setThoiGianMuon(Timestamp thoiGianMuon) {
		this.thoiGianMuon = thoiGianMuon;
	}
	public Timestamp getThoiGianTra() {
		return thoiGianTra;
	}
	public void setThoiGianTra(Timestamp thoiGianTra) {
		this.thoiGianTra = thoiGianTra;
	}
	public String getCoSoVatChat() {
		return coSoVatChat;
	}
	public void setCoSoVatChat(String coSoVatChat) {
		this.coSoVatChat = coSoVatChat;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
}
