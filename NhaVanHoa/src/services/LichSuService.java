package services;

import Bean.LichSuBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import models.LichSuModel;

/**
 *
 * @author Hai
 */
public class LichSuService {
    
    /* 
     * Ham lay ra 1 nguoi muon trong database thong qua id
     * 
     */
    public LichSuBean getLichSu(String id) {
        LichSuBean LichSuBean = new LichSuBean();  
        String query1 = "SELECT m.money_id, concat('Ông/Bà', r.user_name, 'tặng nhà văn hoá') as reason FROM money m JOIN registers r ON m.user_id = r.user_id";
        return LichSuBean;
    }
    
     // lay danh sach nguoi muon
    public List<LichSuBean> getListLichSu() {
    	
        List<LichSuBean> list = new ArrayList<>();
        return list;
    }
    
    //danh sach nguoi muon, phuc vu cho viec search
    public List<LichSuBean> statisticLichSu(Date thoiGian, String status) {
        List<LichSuBean> list = new ArrayList<>();
        //viết truy vấn
        return list;
    }
    
    /*
     * ham tim kiem nhan khau theo ten, lien he, tu ngay, den ngay
     */
    public List<LichSuBean> search(Date thoiGian, String status) {
        List<LichSuBean> list = new  ArrayList<>();
        return list;
    }
    
    /*
     * Ham sử lý ngoại lệ : thông báo ra lỗi nhận được
     */
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }


}
