package controllers;

import Bean.LichSuBean;
import Bean.LichSuBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import models.LichSuModel;
import services.LichSuService;
import services.LichSuService;
import services.StringService;
import utility.ClassTableModel;

/**
 *
 * @author Hai
 */
public class LichSuPanelController {
    
    private JPanel jpnView;
    private JDateChooser thoiGianJdc;
    private JComboBox<String> status;
    private LichSuService lichSuService;
    private List<LichSuBean> listLichSuBeans;
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"STT", "Lý do", "Dụng cụ", "Số lượng", "Thời gian"};
    private JFrame parentJFrame;

    public LichSuPanelController(JPanel jpnView, JDateChooser thoiGianJdc, JComboBox<String> status) {
        this.jpnView = jpnView;
        this.thoiGianJdc = thoiGianJdc;
        this.status = status;
        classTableModel = new ClassTableModel();
        this.lichSuService = new LichSuService();
        this.listLichSuBeans = new ArrayList<>();
        this.listLichSuBeans = this.lichSuService.getListLichSu();
    }

    public LichSuPanelController() {
    }
    
    //khi nhap hoten vs lien he se tu dong tim, khong can an filter
    
    //Khi an Filter, bien listLichSuBeans se call LichSuService de thonn ke thon tin vua nhap
    //Chu y cac thong tin null
    public void setData(Timestamp thoiGian, String status){
      this.listLichSuBeans = this.lichSuService.search(thoiGian, status);
      setDataTable();
    }
    
    public void setDataTable() {
        List<LichSuModel> listItem = new ArrayList<>();
        this.listLichSuBeans.forEach(LichSu -> {
            listItem.add(LichSu.getLichSuModel());
        });
        DefaultTableModel model = classTableModel.setTableLichSu(listItem, COLUMNS);
        JTable table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        
        // thiet ke bang

        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setMaxWidth(280);
        table.getColumnModel().getColumn(1).setMinWidth(280);
        table.getColumnModel().getColumn(1).setPreferredWidth(280);
        table.getColumnModel().getColumn(4).setMaxWidth(150);
        table.getColumnModel().getColumn(4).setMinWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i = 0; i < 5; ++i) 
        	table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
                if (e.getClickCount() > 1) {

                }
            }
            
        });
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 330));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll, BorderLayout.CENTER);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }
    
    public void refreshData() {
        this.listLichSuBeans = this.lichSuService.getListLichSu();
        setDataTable();
    }
    public JPanel getJpnView() {
        return jpnView;
    }

    public void setJpnView(JPanel jpnView) {
        this.jpnView = jpnView;
    }

	public JDateChooser getthoiGianJdc() {
		return thoiGianJdc;
	}

	public void setthoiGianJdc(JDateChooser thoiGianJdc) {
		this.thoiGianJdc = thoiGianJdc;
	}


	public JComboBox<String> getStatus() {
		return status;
	}

	public void setStatus(JComboBox<String> status) {
		this.status = status;
	}

   
    
}
