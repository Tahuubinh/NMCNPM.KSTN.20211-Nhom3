package controllers;

import Bean.MuonTraBean;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import models.MuonTraModel;
import services.MuonTraService;
import services.StringService;
import services.TimeService;
import utility.ClassTableModel;

/**
 *
 * @author Hai
 */
public class MuonTraPanelController {
    
    private JPanel jpnView;
    private JTextField nguoiMuonJtfSearch;
    private JTextField lienheJtfSearch;
    private JDateChooser tuNgayJdc;
    private JDateChooser denNgayJdc;
    private MuonTraService muonTraService;
    private List<MuonTraBean> listMuonTraBeans;
    private ClassTableModel classTableModel = null;
    private JTable table;
    private JPopupMenu popupMenu;
    private final String[] COLUMNS = {"STT", "Tên người mượn", "CMND/TCC/HC", "Liên hệ", "Thời gian mượn", "Thời gian trả", "Cơ sở vật chất/Phòng ban", "Số lượng"};
    private JFrame parentJFrame;
    private TimeService timeService;
    public MuonTraPanelController(JPanel jpnView, JTextField nguoiMuonJtfSearch, JTextField lienheJtfSearch, JDateChooser tuNgayJdc, JDateChooser denNgayJdc, JPopupMenu popupMenu) {
        this.jpnView = jpnView;
        this.nguoiMuonJtfSearch = nguoiMuonJtfSearch;
        this.lienheJtfSearch = lienheJtfSearch;
        this.timeService = new TimeService();
        this.tuNgayJdc = tuNgayJdc;
        this.denNgayJdc = denNgayJdc;
        this.popupMenu = popupMenu;
        classTableModel = new ClassTableModel();
        this.muonTraService = new MuonTraService();
        this.listMuonTraBeans = this.muonTraService.getListMuonTra();
        initAction();
    }

    public MuonTraPanelController() {
    }
    
    //khi nhap hoten vs lien he se tu dong tim, khong can an filter
    public void initAction(){
        this.nguoiMuonJtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = nguoiMuonJtfSearch.getText();
                listMuonTraBeans = muonTraService.search(key.trim(), lienheJtfSearch.getText(), timeService.convertDateToTimestamp(tuNgayJdc.getDate()) , timeService.convertDateToTimestamp(denNgayJdc.getDate()));
                setDataTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = nguoiMuonJtfSearch.getText();
                listMuonTraBeans = muonTraService.search(key.trim(), lienheJtfSearch.getText(), timeService.convertDateToTimestamp(tuNgayJdc.getDate()) , timeService.convertDateToTimestamp(denNgayJdc.getDate()));
                setDataTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = nguoiMuonJtfSearch.getText();
                listMuonTraBeans = muonTraService.search(key.trim(), lienheJtfSearch.getText(), timeService.convertDateToTimestamp(tuNgayJdc.getDate()) , timeService.convertDateToTimestamp(denNgayJdc.getDate()));
                setDataTable();
            }
        });
        
        this.lienheJtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = lienheJtfSearch.getText();
                listMuonTraBeans = muonTraService.search(nguoiMuonJtfSearch.getText(), key.trim(), timeService.convertDateToTimestamp(tuNgayJdc.getDate()) , timeService.convertDateToTimestamp(denNgayJdc.getDate()));
                setDataTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = lienheJtfSearch.getText();
                listMuonTraBeans = muonTraService.search(nguoiMuonJtfSearch.getText(), key.trim(), timeService.convertDateToTimestamp(tuNgayJdc.getDate()) , timeService.convertDateToTimestamp(denNgayJdc.getDate()));
                setDataTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = lienheJtfSearch.getText();
                listMuonTraBeans = muonTraService.search(nguoiMuonJtfSearch.getText(), key.trim(), timeService.convertDateToTimestamp(tuNgayJdc.getDate()) , timeService.convertDateToTimestamp(denNgayJdc.getDate()));
                setDataTable();
            }
        });
    }
    //Khi an Filter, bien listMuonTraBeans se call muonTraService de thonn ke thon tin vua nhap
    //Chu y cac thong tin null
    public void setData(String tenNguoiMuon, String lienHe, Timestamp tuNgay, Timestamp denNgay){
      this.listMuonTraBeans = this.muonTraService.search(tenNguoiMuon, lienHe, tuNgay, denNgay);
      setDataTable();
    }
    
    public void setDataTable() {
        List<MuonTraModel> listItem = new ArrayList<>();
        this.listMuonTraBeans.forEach(MuonTra -> {
            listItem.add(MuonTra.getMuonTraModel());
        });
        DefaultTableModel model = classTableModel.setTableMuonTra(listItem, COLUMNS);
        table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        
        // thiet ke bang

        table.setComponentPopupMenu(popupMenu);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);
        table.setRowHeight(50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(1).setMaxWidth(150);
        table.getColumnModel().getColumn(1).setMinWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(2).setMaxWidth(150);
        table.getColumnModel().getColumn(2).setMinWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(3).setMaxWidth(100);
        table.getColumnModel().getColumn(3).setMinWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(4).setMaxWidth(150);
        table.getColumnModel().getColumn(4).setMinWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(5).setMaxWidth(150);
        table.getColumnModel().getColumn(5).setMinWidth(150);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(6).setMaxWidth(150);
        table.getColumnModel().getColumn(6).setMinWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(7).setMaxWidth(80);
        table.getColumnModel().getColumn(7).setMinWidth(80);
        table.getColumnModel().getColumn(7).setPreferredWidth(80);
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 350));
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
        this.listMuonTraBeans = this.muonTraService.getListMuonTra();
        setDataTable();
    }
    public JPanel getJpnView() {
        return jpnView;
    }

    public void setJpnView(JPanel jpnView) {
        this.jpnView = jpnView;
    }

    public JTextField getnguoiMuonJtfSearch() {
        return nguoiMuonJtfSearch;
    }

    public void setnguoiMuonJtfSearch(JTextField nguoiMuonJtfSearch) {
        this.nguoiMuonJtfSearch = nguoiMuonJtfSearch;
    }

	public JTextField getLienheJtfSearch() {
		return lienheJtfSearch;
	}

	public void setLienheJtfSearch(JTextField lienheJtfSearch) {
		this.lienheJtfSearch = lienheJtfSearch;
	}

	public JDateChooser gettuNgayJdc() {
		return tuNgayJdc;
	}

	public void settuNgayJdc(JDateChooser tuNgayJdc) {
		this.tuNgayJdc = tuNgayJdc;
	}

	public JDateChooser getdenNgayJdc() {
		return denNgayJdc;
	}

	public void setdenNgayJdc(JDateChooser denNgayJdc) {
		this.denNgayJdc = denNgayJdc;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
    
    
}
