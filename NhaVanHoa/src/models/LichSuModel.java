package models;

import java.util.Date;

public class LichSuModel {
	private int stt;
	private String lyDo;
	private String dungCu;
	private int soLuong;
	private Date thoiGian;
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public String getLyDo() {
		return lyDo;
	}
	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	public String getDungCu() {
		return dungCu;
	}
	public void setDungCu(String dungCu) {
		this.dungCu = dungCu;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Date getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}
}
