package models;

import java.sql.Timestamp;

public class CoSoVatChatModel {
	private int id;
	private String tenCoSoVatChat;
	private int soLuong;
	private String donVi;
	private int soLuongMuon;
	private int soLuongTrongKho;
	private int soLuongDaTra = 0;
	private String lyDo;
	private Timestamp thoiGianTraReal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenCoSoVatChat() {
		return tenCoSoVatChat;
	}
	public void setTenCoSoVatChat(String tenCoSoVatChat) {
		this.tenCoSoVatChat = tenCoSoVatChat;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	public int getSoLuongMuon() {
		return soLuongMuon;
	}
	public void setSoLuongMuon(int soLuongMuon) {
		this.soLuongMuon = soLuongMuon;
	}
	public int getSoLuongTrongKho() {
		return soLuongTrongKho;
	}
	public void setSoLuongTrongKho(int soLuongTrongKho) {
		this.soLuongTrongKho = soLuongTrongKho;
	}
	public String getLyDo() {
		return lyDo;
	}
	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	public Timestamp getThoiGianTraReal() {
		return thoiGianTraReal;
	}
	public void setThoiGianTraReal(Timestamp thoiGianTraReal) {
		this.thoiGianTraReal = thoiGianTraReal;
	}
	public int getSoLuongDaTra() {
		return soLuongDaTra;
	}
	public void setSoLuongDaTra(int soLuongDaTra) {
		this.soLuongDaTra = soLuongDaTra;
	}
	public void setThoiGianTraReal(String thoiGianTraRealTimeStamp) {
		this.thoiGianTraReal = Timestamp.valueOf(thoiGianTraRealTimeStamp);
	}
	
}
