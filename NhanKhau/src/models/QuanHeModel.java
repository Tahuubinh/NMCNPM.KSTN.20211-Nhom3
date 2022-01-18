package models;
import java.util.Date;

public class QuanHeModel {
    private int ID;
    private String hoTen;
    private Date namSinh;
    private String gioiTinh;
    private String tccString;
    private String lienheString;
    private String quanheString;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public String getHoTen() {
        return hoTen;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

	public String getTccString() {
		return tccString;
	}

	public void setTccString(String tccString) {
		this.tccString = tccString;
	}

	public String getLienheString() {
		return lienheString;
	}

	public void setLienheString(String lienheString) {
		this.lienheString = lienheString;
	}
	
	public String getQuanHeString() {
		return quanheString;
	}

	public void setQuanHeString(String quanheString) {
		this.quanheString = quanheString;
	}
    
}
