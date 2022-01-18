package models;

import java.sql.Timestamp;

public class ListMuonTraDetailModel {
	private String tenCoSoVatChat;
	private String tenPhongBan;
	private int soLuongMuon = -1;
	private int soLuongHoanTra;
	private Timestamp thoiGianTraReal;
	public String getTenCoSoVatChat() {
		return tenCoSoVatChat;
	}
	public void setTenCoSoVatChat(String tenCoSoVatChat) {
		this.tenCoSoVatChat = tenCoSoVatChat;
	}
	public String getTenPhongBan() {
		return tenPhongBan;
	}
	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}
	public int getsoLuongMuon() {
		return soLuongMuon;
	}
	public void setsoLuongMuon(int soLuongMuon) {
		this.soLuongMuon = soLuongMuon;
	}
	public int getSoLuongHoanTra() {
		return soLuongHoanTra;
	}
	public void setSoLuongHoanTra(int soLuongHoanTra) {
		this.soLuongHoanTra = soLuongHoanTra;
	}
	public Timestamp getThoiGianTraReal() {
		return thoiGianTraReal;
	}
	public void setThoiGianTraReal(Timestamp thoiGianTraReal) {
		this.thoiGianTraReal = thoiGianTraReal;
	}
	
}
