package controllers;

import Bean.NhanKhauBean;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.lang.model.element.Element;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.NhanKhauModel;
import services.NhanKhauService;
import services.StringService;
import utility.ClassTableModel;


/**
 *
 * @author Hai
 */
public class ThongKePanelController {
    private JComboBox GenderJcb;
    private JComboBox StatusJcb;
    private JTextField tuTuoiJtf;
    private JTextField denTuoiJtf;
    private JTextField tuNamJtf;
    private JTextField denNamJtf;
    private JPanel jpnView;
    private JPopupMenu popupMenu;
    private NhanKhauService nhanKhauService;
    private List<NhanKhauBean> listNhanKhauBeans;
    private JTable table;
    private ClassTableModel classTableModel;
    private final String[] COLUMNS = {"ID", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ hiện nay"};
    private final String[] COLUMNS_DELETE = {"ID", "Họ tên", "Giới tính", "Ngày sinh", "Ngày xóa"};
    private final String[] COLUMNS_TAM = {"ID", "Họ tên", "Ngày sinh", "Ngày bắt đầu", "Ngày kết thúc"};

    public ThongKePanelController(JComboBox genderJcb, JComboBox statusJcb, JTextField tuTuoiJtf, JTextField denTuoiJtf, JTextField tuNamJtf, JTextField denNamJtf, JPanel jpnView, JPopupMenu popupMenu) {
        this.GenderJcb = genderJcb;
        this.StatusJcb = statusJcb;
        this.tuTuoiJtf = tuTuoiJtf;
        this.denTuoiJtf = denTuoiJtf;
        this.tuNamJtf = tuNamJtf;
        this.denNamJtf = denNamJtf;
        this.jpnView = jpnView;
        this.popupMenu = popupMenu;
        this.nhanKhauService = new NhanKhauService();
        this.listNhanKhauBeans = new ArrayList<>();
        this.listNhanKhauBeans = this.nhanKhauService.getListNhanKhau();
        this.classTableModel = new ClassTableModel();
    }
    
    public JPanel getJpnView() {
        return jpnView;
    }

    public void setJpnView(JPanel jpnView) {
        this.jpnView = jpnView;
    }
    
    public JTable getNhankhauTable() {
		return this.table;
	}

    public void setData() {
        int tuTuoi = -1;
        int denTuoi = 200;
        int tuNam = 0;
        int denNam = 2100;
        String gender = (String)this.GenderJcb.getSelectedItem();
        String status = (String)this.StatusJcb.getSelectedItem();

        try {
            if (!this.tuTuoiJtf.getText().trim().isEmpty()) {
                tuTuoi = Integer.parseInt(this.tuTuoiJtf.getText().trim());
            } else {
                tuTuoi = -1;
            }
            if (!this.denTuoiJtf.getText().trim().isEmpty()) {
                denTuoi = Integer.parseInt(this.denTuoiJtf.getText().trim());
            } else {
                denTuoi = 200;
            }
            if (!this.tuNamJtf.getText().trim().isEmpty()) {
                tuNam = Integer.parseInt(this.tuNamJtf.getText().trim());
            }
            if (!this.denNamJtf.getText().trim().isEmpty()) {
                denNam = Integer.parseInt(this.denNamJtf.getText().trim());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(denTuoiJtf, "Vui lòng nhập đúng kiểu dữ liệu!!", "Warring", JOptionPane.ERROR_MESSAGE);
        }
        if (status.equals("Tạm vắng")) {
        	this.listNhanKhauBeans = this.nhanKhauService.statisticTamVang(tuTuoi, denTuoi, gender, status, tuNam, denNam);
        	setTableTamvang();
        } 
        else if (status.equals("Tạm trú")) {
        	this.listNhanKhauBeans = this.nhanKhauService.statisticTamTru(tuTuoi, denTuoi, gender, status, tuNam, denNam);
        	setTableTamTru();
        }
        else if (status.equals("Chuyển đi")) {
        	this.listNhanKhauBeans = this.nhanKhauService.statisticNhanKhauXoa(tuTuoi, denTuoi, gender, status, tuNam, denNam);
        	setTableChuyenDi();
        }
        else if (status.equals("Khai tử")) {
        	this.listNhanKhauBeans = this.nhanKhauService.statisticNhanKhauXoa(tuTuoi, denTuoi, gender, status, tuNam, denNam);
        	setTableKhaiTu();
        }
        else {
	        this.listNhanKhauBeans = this.nhanKhauService.statisticNhanKhau(tuTuoi, denTuoi, gender, status, tuNam, denNam);
	        setTableNhanKhau();
        }
    }
    
    public void setTableNhanKhau() {
    	List<NhanKhauModel> listItem = new ArrayList<>();
        this.listNhanKhauBeans.forEach(nhankhau -> {
            listItem.add(nhankhau.getNhanKhauModel());
        });
        DefaultTableModel model = classTableModel.setTableNhanKhau(listItem, COLUMNS);
        table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        table.setComponentPopupMenu(new JPopupMenu());
        setDataTable();
    }
    
    public void setTableTamTru() {
    	List<NhanKhauModel> listItem = new ArrayList<>();
        this.listNhanKhauBeans.forEach(nhankhau -> {
            listItem.add(nhankhau.getNhanKhauModel());
        });
        DefaultTableModel model = classTableModel.setTableTam(listItem, COLUMNS_TAM);
        table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        table.setComponentPopupMenu(popupMenu);
        setDataTable();
    }
    
    public void setTableChuyenDi() {
    	List<NhanKhauModel> listItem = new ArrayList<>();
        this.listNhanKhauBeans.forEach(nhankhau -> {
            listItem.add(nhankhau.getNhanKhauModel());
        });
        DefaultTableModel model = classTableModel.setTableNhanKhauXoa(listItem, COLUMNS_DELETE);
        table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        table.setComponentPopupMenu(new JPopupMenu());
        setDataTable();
    }
    
    public void setTableKhaiTu() {
    	List<NhanKhauModel> listItem = new ArrayList<>();
        this.listNhanKhauBeans.forEach(nhankhau -> {
            listItem.add(nhankhau.getNhanKhauModel());
        });
        DefaultTableModel model = classTableModel.setTableNhanKhauXoa(listItem, COLUMNS_DELETE);
        table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        table.setComponentPopupMenu(new JPopupMenu());
        setDataTable();
    }
    
    public void setTableTamvang() {
    	List<NhanKhauModel> listItem = new ArrayList<>();
        this.listNhanKhauBeans.forEach(nhankhau -> {
            listItem.add(nhankhau.getNhanKhauModel());
        });
        DefaultTableModel model = classTableModel.setTableTam(listItem, COLUMNS_TAM);
        table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        table.setComponentPopupMenu(new JPopupMenu());
        setDataTable();
    }
    
    public void setDataTable() {
        
        // thiet ke bang
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.removeColumn(table.getColumnModel().getColumn(0));
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public JComboBox getGenderJcb() {
        return GenderJcb;
    }

    public void setGenderJcb(JComboBox GenderJcb) {
        this.GenderJcb = GenderJcb;
    }

    public JComboBox getStatusJcb() {
        return StatusJcb;
    }

    public void setStatusJcb(JComboBox StatusJcb) {
        this.StatusJcb = StatusJcb;
    }

    public JTextField getTuTuoiJtf() {
        return tuTuoiJtf;
    }

    public void setTuTuoiJtf(JTextField tuTuoiJtf) {
        this.tuTuoiJtf = tuTuoiJtf;
    }

    public JTextField getDenTuoiJtf() {
        return denTuoiJtf;
    }

    public void setDenTuoiJtf(JTextField denTuoiJtf) {
        this.denTuoiJtf = denTuoiJtf;
    }

    public JTextField getTuNamJtf() {
        return tuNamJtf;
    }

    public void setTuNamJtf(JTextField tuNamJtf) {
        this.tuNamJtf = tuNamJtf;
    }

    public JTextField getDenNamJtf() {
        return denNamJtf;
    }

    public void setDenNamJtf(JTextField denNamJtf) {
        this.denNamJtf = denNamJtf;
    }
    
    
}
