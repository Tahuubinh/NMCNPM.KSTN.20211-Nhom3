package services;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Bean.PhongBanBean;

public class PhongBanService {
	
	//lay ten co so vat chat thong qua id
	public PhongBanBean getPhongBan(String id) {
        PhongBanBean PhongBanBean = new PhongBanBean();  
        return PhongBanBean;
    }
    
     // lay danh sach co so vat chat
    public List<PhongBanBean> getListPhongBan() {
    	
        List<PhongBanBean> list = new ArrayList<>();
        return list;
    }
    
    //danh sach co so vat chat phuc vu viec thong ke
    public List<PhongBanBean> statisticPhongBan(String tenPhongBan) {
        List<PhongBanBean> list = new ArrayList<>();
        //viết truy vấn
        return list;
    }
    
    //danh sach co so vat chat phuc vu viec search
    public List<PhongBanBean> search(String tenPhongBan) {
        List<PhongBanBean> list = new ArrayList<>();
        //viết truy vấn
        return list;
    }
    
    /*
     * Ham sử lý ngoại lệ : thông báo ra lỗi nhận được
     */
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
