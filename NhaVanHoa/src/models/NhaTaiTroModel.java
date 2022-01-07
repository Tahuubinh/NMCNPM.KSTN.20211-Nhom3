package models;

public class NhaTaiTroModel {
	private int id;
	private int idNhaTaiTro;
	private int idItem;
	private int soLuong;
	private String ngayTaiTro;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdNhaTaiTro() {
		return idNhaTaiTro;
	}
	public void setIdNhaTaiTro(int idNhaTaiTro) {
		this.idNhaTaiTro = idNhaTaiTro;
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
	public String getNgayTaiTro() {
		return ngayTaiTro;
	}
	public void setNgayTaiTro(String ngayTaiTro) {
		this.ngayTaiTro = ngayTaiTro;
	}
	
}
