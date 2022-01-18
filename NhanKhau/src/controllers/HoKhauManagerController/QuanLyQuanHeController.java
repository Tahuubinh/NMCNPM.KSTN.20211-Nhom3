package controllers.HoKhauManagerController;

import Bean.NhanKhauBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import models.NhanKhauModel;
import models.QuanHeModel;
import services.HoKhauService;
import services.NhanKhauService;
import utility.ClassTableModel;
import utility.TableModelHoKhau;
import views.infoViews.InfoJframe;

/**
 *
 * @author Hai
 */
public class QuanLyQuanHeController {
    
    private JPanel jpnView;
    private JPopupMenu tablepopupMenu;
    private JTextField jtfSearch;
    private JTextField diachiSearchtextField;
    private JButton locButton;
    private NhanKhauService nhanKhauService;
    private List<QuanHeModel> listNhanKhauBeans;
    private TableModelHoKhau classTableModel = null;
    private final String[] COLUMNS = {"ID", "Họ tên", "Ngày sinh", "Giới tính", "Quan hệ với chủ hộ"};
    private JFrame parentJFrame;
    private JTable table;
    private int id_ho_khau;

    public QuanLyQuanHeController(JPanel jpnView, JTextField jtfSearch, JButton locButton, int id_ho_khau) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        this.locButton = locButton;
        classTableModel = new TableModelHoKhau();
        this.nhanKhauService = new NhanKhauService();
        this.id_ho_khau = id_ho_khau;
        this.listNhanKhauBeans = this.nhanKhauService.getListKhongPhaiChuHo(this.id_ho_khau);
//        locButton.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//            	String key = jtfSearch.getText();
//            	//String keyDiachiString = diachiSearchtextField.getText();
//                listNhanKhauBeans = nhanKhauService.searchThanhVienCuaHo(key.trim(), "");
//                setDataTable();
//            }
//        });
        refreshData();
    }

    public QuanLyQuanHeController() {
    }
    
    
    public JTable getNhankhauTable() {
		return table;
	}

	public void setNhankhauTable(JTable nhankhauTable) {
		this.table = nhankhauTable;
	}

	//
    public void initAction(){
//        this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                String key = jtfSearch.getText();
//                listNhanKhauBeans = nhanKhauService.search(key.trim());
//                setDataTable();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                String key = jtfSearch.getText();
//                listNhanKhauBeans = nhanKhauService.search(key.trim());
//                setDataTable();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                String key = jtfSearch.getText();
//                listNhanKhauBeans = nhanKhauService.search(key.trim());
//                setDataTable();
//            }
//        });
    	String key = jtfSearch.getText();
    	String keyDiachiString = diachiSearchtextField.getText();
        //listNhanKhauBeans = nhanKhauService.search(key.trim(), keyDiachiString.trim());
        setDataTable();
    }
    
    public void setDataTable() {
        List<QuanHeModel> listItem = new ArrayList<>();
        this.listNhanKhauBeans.forEach(nhankhau -> {
            listItem.add(nhankhau);
        });
        //System.err.println(listItem);
        DefaultTableModel model = classTableModel.setTableQuanHe(listNhanKhauBeans, COLUMNS);
        table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        table.removeColumn(table.getColumnModel().getColumn(0));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
                if (e.getClickCount() > 1) {
                	String quanheString = JOptionPane.showInputDialog("Quan hệ với chủ hộ?");
                	int id = (int) table.getModel().getValueAt(table.getSelectedRow(),0);
                	new HoKhauService().updateQuanHe(id, quanheString);
                	refreshData();
                }
            }
            
        });

        table.setComponentPopupMenu(tablepopupMenu);
        
        // thiet ke bang
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
//        table.getColumnModel().getColumn(0).setMaxWidth(80);
//        table.getColumnModel().getColumn(0).setMinWidth(80);
//        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
//                if (e.getClickCount() > 1) {
//                    NhanKhauBean temp = listNhanKhauBeans.get(table.getSelectedRow());
//                    NhanKhauBean info = nhanKhauService.getNhanKhau(temp.getChungMinhThuModel().getSoCMT());
//                    InfoJframe infoJframe = new InfoJframe(info.toString(), parentJFrame);
//                    infoJframe.setLocationRelativeTo(null);
//                    infoJframe.setVisible(true);
//                }
            }
            
        });
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }
    
    public void refreshData() {
//    	String key = jtfSearch.getText();
    	//String keyDiachiString = diachiSearchtextField.getText();
        listNhanKhauBeans = nhanKhauService.getListKhongPhaiChuHo(this.id_ho_khau);
        setDataTable();
    }
    public JPanel getJpnView() {
        return jpnView;
    }

    public void setJpnView(JPanel jpnView) {
        this.jpnView = jpnView;
    }

    public JTextField getJtfSearch() {
        return jtfSearch;
    }

    public void setJtfSearch(JTextField jtfSearch) {
        this.jtfSearch = jtfSearch;
    }
    
    
}
