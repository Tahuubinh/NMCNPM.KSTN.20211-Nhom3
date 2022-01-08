package models;

import java.util.Date;

public class ThoiGianModel {
	private int id;
	private Date thoiGianMuon;
	private Date thoiGianTra;
	private Date thoiGianTraThucTe;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getThoiGianMuon() {
		return thoiGianMuon;
	}
	public void setThoiGianMuon(Date thoiGianMuon) {
		this.thoiGianMuon = thoiGianMuon;
	}
	public Date getThoiGianTra() {
		return thoiGianTra;
	}
	public void setThoiGianTra(Date thoiGianTra) {
		this.thoiGianTra = thoiGianTra;
	}
	public Date getThoiGianTraThucTe() {
		return thoiGianTraThucTe;
	}
	public void setThoiGianTraThucTe(Date thoiGianTraThucTe) {
		this.thoiGianTraThucTe = thoiGianTraThucTe;
	}
}
