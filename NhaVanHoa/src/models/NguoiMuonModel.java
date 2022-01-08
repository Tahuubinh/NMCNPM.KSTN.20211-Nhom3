package models;

public class NguoiMuonModel {
	private String id;
	private String tenNguoiMuon;
	private String diaChi;
	private String lienHe;
	private int phiDangKi;
	private String cccd;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTenNguoiMuon() {
		return tenNguoiMuon;
	}
	public void setTenNguoiMuon(String tenNguoiMuon) {
		this.tenNguoiMuon = tenNguoiMuon;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getLienHe() {
		return lienHe;
	}
	public void setLienHe(String lienHe) {
		this.lienHe = lienHe;
	}
	public int getPhiDangKi() {
		return phiDangKi;
	}
	public void setPhiDangKi(int phiDangKi) {
		this.phiDangKi = phiDangKi;
	}
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
}
