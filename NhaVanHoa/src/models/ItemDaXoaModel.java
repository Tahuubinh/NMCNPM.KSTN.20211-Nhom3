package models;

public class ItemDaXoaModel {
	private int id;
	private int idItem;
	private String thoiGianXoa;
	private String liDoXoa;
	private int soLuong;
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
	public String getThoiGianXoa() {
		return thoiGianXoa;
	}
	public void setThoiGianXoa(String thoiGianXoa) {
		this.thoiGianXoa = thoiGianXoa;
	}
	public String getLiDoXoa() {
		return liDoXoa;
	}
	public void setLiDoXoa(String liDoXoa) {
		this.liDoXoa = liDoXoa;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
}
