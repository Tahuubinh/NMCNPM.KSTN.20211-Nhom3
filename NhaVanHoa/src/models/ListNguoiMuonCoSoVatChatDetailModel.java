package models;

import java.sql.Timestamp;

import services.TimeService;

public class ListNguoiMuonCoSoVatChatDetailModel {
	private String tenNguoiMuon;
	private int soLuongMuon;
	private Timestamp thoiGianMuon;
	private Timestamp thoiGianTra;
	private TimeService timeService = new TimeService();
	public String getTenNguoiMuon() {
		return tenNguoiMuon;
	}
	public void setTenNguoiMuon(String tenNguoiMuon) {
		this.tenNguoiMuon = tenNguoiMuon;
	}
	public int getSoLuongMuon() {
		return soLuongMuon;
	}
	public void setSoLuongMuon(int soLuongMuon) {
		this.soLuongMuon = soLuongMuon;
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
	public void setThoiGianMuon(String thoiGianMuon) {
		// TODO Auto-generated method stub
		this.thoiGianMuon = Timestamp.valueOf(thoiGianMuon);
	}
	public void setThoiGianTra(String thoiGianTra) {
		// TODO Auto-generated method stub
		this.thoiGianTra = Timestamp.valueOf(thoiGianTra); 
	}
}
