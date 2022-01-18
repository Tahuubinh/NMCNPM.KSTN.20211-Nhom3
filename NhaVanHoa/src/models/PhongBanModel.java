package models;

import java.sql.Timestamp;
import java.util.Date;

public class PhongBanModel {
	private int id;
	private String tenPhongBan;
	private String thoiGianSuDung;
	private String lyDo;
	private Timestamp thoiGianTraReal;
	private int soLuongDaTra = 0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenPhongBan() {
		return tenPhongBan;
	}
	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}
	public String getThoiGianSuDung() {
		return thoiGianSuDung;
	}
	public void setThoiGianSuDung(String thoiGianSuDung) {
		this.thoiGianSuDung = thoiGianSuDung;
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
