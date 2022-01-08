package services;

import Bean.MuonTraBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import models.MuonTraModel;

/**
 *
 * @author Hai
 */
public class MuonTraService {
    
    /* 
     * Ham lay ra 1 nguoi muon trong database thong qua id
     * id la cccd, tcc, hc
     * 
     */
    public MuonTraBean getMuonTra(String id) {
        MuonTraBean MuonTraBean = new MuonTraBean();  
        return MuonTraBean;
    }
    
     // lay danh sach nguoi muon
    public List<MuonTraBean> getListMuonTra() {
    	
        List<MuonTraBean> list = new ArrayList<>();
        return list;
    }
    
    //danh sach nguoi muon, phuc vu cho viec search
    public List<MuonTraBean> statisticMuonTra(String tenNguoiMuon, String lienHe, Date tuNgay, Date denNgay) {
        List<MuonTraBean> list = new ArrayList<>();
        //viết truy vấn
        return list;
    }
    
    /*
     * ham tim kiem nhan khau theo ten, lien he, tu ngay, den ngay
     */
    public List<MuonTraBean> search(String tenNguoiMuon, String lienHe, Date tuNgay, Date denNgay) {
        List<MuonTraBean> list = new  ArrayList<>();
        return list;
    }
    
    /*
     * Ham sử lý ngoại lệ : thông báo ra lỗi nhận được
     */
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
