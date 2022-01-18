package ControllersAddNewController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Bean.CoSoVatChatBean;
import Bean.MuonTraBean;
import Bean.PhongBanBean;
import models.CoSoVatChatModel;
import models.MuonTraModel;
import models.PhongBanModel;
import services.CoSoVatChatService;
import services.MuonTraService;
import services.PhongBanService;
import utility.ClassTableModel;

public class AddCoSoVatChatPhongBanController {
    private JPanel jpnView;
    private CoSoVatChatService coSoVatChatService;
    private PhongBanService phongBanService;
    private List<CoSoVatChatBean> listCoSoVatChatBeans;
    private List<PhongBanBean> listPhongBanBeans;
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"Cơ sở vật chất / phòng ban", "Số lượng"};
    private JFrame parentJFrame;

    public AddCoSoVatChatPhongBanController(JPanel jpnView) {
        this.jpnView = jpnView;

        classTableModel = new ClassTableModel();
        this.coSoVatChatService = new CoSoVatChatService();
        this.phongBanService = new PhongBanService();
        initAction();
    }

    public AddCoSoVatChatPhongBanController() {
    }
    
    //khi nhap hoten vs lien he se tu dong tim, khong can an filter
    public void initAction(){
        
    }
    //Khi an Filter, bien listMuonTraBeans se call muonTraService de thonn ke thon tin vua nhap
    //Chu y cac thong tin null
    public void setData(String tenNguoiMuon, String lienHe, Date tuNgay, Date denNgay){
      setDataTable();
    }
    
    public void setDataTable() {
        List<CoSoVatChatModel> listItemCoSoVatChat = new ArrayList<>();
        this.listCoSoVatChatBeans.forEach(coSoVatChat -> {
            listItemCoSoVatChat.add(coSoVatChat.getCoSoVatChatModel());
        });
        
        List<PhongBanModel> listItemPhongBan = new ArrayList<>();
        this.listPhongBanBeans.forEach(phongBan -> {
            listItemPhongBan.add(phongBan.getPhongBanModel());
        });
        DefaultTableModel model = classTableModel.setTableAddMuonTra(listItemCoSoVatChat, listItemPhongBan, COLUMNS);
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
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i = 0; i < 2; ++i) 
        	table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
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
        setDataTable();
    }
    public JPanel getJpnView() {
        return jpnView;
    }

    public void setJpnView(JPanel jpnView) {
        this.jpnView = jpnView;
    }

}
