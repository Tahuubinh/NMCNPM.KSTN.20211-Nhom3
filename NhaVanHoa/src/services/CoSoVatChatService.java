package services;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Bean.CoSoVatChatBean;

public class CoSoVatChatService {
	
	//lay ten co so vat chat thong qua id
	public CoSoVatChatBean getCoSoVatChat(String id) {
        CoSoVatChatBean coSoVatChatBean = new CoSoVatChatBean();  
        return coSoVatChatBean;
    }
    
     // lay danh sach co so vat chat
    public List<CoSoVatChatBean> getListCoSoVatChat() {
    	
        List<CoSoVatChatBean> list = new ArrayList<>();
        return list;
    }
    
    //danh sach co so vat chat phuc vu viec thong ke
    public List<CoSoVatChatBean> statisticCoSoVatChat(String tenCoSoVatChat) {
        List<CoSoVatChatBean> list = new ArrayList<>();
        //viết truy vấn
        return list;
    }
    
    //danh sach co so vat chat phuc vu viec search
    public List<CoSoVatChatBean> search(String tenCoSoVatChat) {
        List<CoSoVatChatBean> list = new ArrayList<>();
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
