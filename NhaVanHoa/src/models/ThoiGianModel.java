package models;

import java.sql.Timestamp;
import java.util.Date;

public class ThoiGianModel {
	private int id;
	private Timestamp thoiGianMuon;
	private Timestamp thoiGianTra;
	private Timestamp thoiGianTraThucTe;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getThoiGianMuon() {
		return thoiGianMuon;
	}
	public void setThoiGianMuon(Timestamp thoiGianMuon) {
		this.thoiGianMuon = thoiGianMuon;
	}
	public Timestamp getThoiGianTra() {
		return thoiGianTra;
	}
	public void setThoiGianTra(Timestamp thoiGianTra) {
		this.thoiGianTra = thoiGianTra;
	}
	public Timestamp getThoiGianTraThucTe() {
		return thoiGianTraThucTe;
	}
	public void setThoiGianTraThucTe(Timestamp thoiGianTraThucTe) {
		this.thoiGianTraThucTe = thoiGianTraThucTe;
	}
	public void setThoiGianMuon(String thoiGianMuonTimeStamp) {
		this.thoiGianMuon = Timestamp.valueOf(thoiGianMuonTimeStamp);
	}
	public void setThoiGianTra(String thoiGianTraTimeStamp) {
		this.thoiGianTra = Timestamp.valueOf(thoiGianTraTimeStamp);
	}
	public void setThoiGianTraThucTe(String thoiGianTraThucTeTimeStamp) {
		this.thoiGianTraThucTe = Timestamp.valueOf(thoiGianTraThucTeTimeStamp);
	}
}
