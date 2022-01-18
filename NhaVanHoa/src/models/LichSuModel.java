package models;

import java.sql.Timestamp;
import java.util.Date;

import services.TimeService;

public class LichSuModel {
	private int stt;
	private String lyDo;
	private String dungCu;
	private int soLuong;
	private Timestamp thoiGian;
	private TimeService timeService = new TimeService();
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
	public Timestamp getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(Timestamp thoiGian) {
		this.thoiGian = thoiGian;
	}
	public void setThoiGian(String thoiGianTimeStamp) {
		this.thoiGian = Timestamp.valueOf(thoiGianTimeStamp);
	}
	public void setThoiGian(java.sql.Date date) {
		// TODO Auto-generated method stub
		this.thoiGian = timeService.convertDatesqlToTimestamp(date);
	}
}
