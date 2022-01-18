package models;

import java.sql.Timestamp;

public class NhaTaiTroModel {
	private int id;
	private int idItem;
	private int soLuong;
	private Timestamp ngayTaiTro;
	private String lyDo;
	public String getLyDo() {
		return lyDo;
	}
	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Timestamp getNgayTaiTro() {
		return ngayTaiTro;
	}
	public void setNgayTaiTro(Timestamp ngayTaiTro) {
		this.ngayTaiTro = ngayTaiTro;
	}
	public void setNgayTaiTro(String ngayTaiTroTimeStamp) {
		this.ngayTaiTro = Timestamp.valueOf(ngayTaiTroTimeStamp);
	}
}
