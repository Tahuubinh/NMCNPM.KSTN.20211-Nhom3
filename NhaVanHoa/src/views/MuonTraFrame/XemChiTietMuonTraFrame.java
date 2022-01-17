package views.MuonTraFrame;

import Bean.MuonTraBean;
import ControllersAddNewController.AddCoSoVatChatPhongBanController;
import ControllersAddNewController.AddNewController;
import controllers.LoginController;
import controllers.MuonTraPanelController;
import controllers.CoSoVatChatController.XemChiTietCoSoVatChatCotroller;
import controllers.MuonTraController.XemChiTietMuonTraCotroller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.PhongBanModel;
import models.CoSoVatChatModel;
import models.NguoiMuonModel;
import models.ThoiGianModel;
import utility.ClassTableModel;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;

import java.awt.Rectangle;
import javax.swing.JComboBox;
import java.awt.Component;

/**
 *
 * @author Hai
 */
public class XemChiTietMuonTraFrame extends javax.swing.JFrame {


    /**
     * @wbp.parser.constructor
     */
    public XemChiTietMuonTraFrame(MuonTraPanelController parentController, JFrame parentJFrame, String tenNguoiDangKySuDungDetail, String idDetail, String lienHeDetail, String thoiGianDetail, String thoiGianTraDetail) {
    	setBackground(new Color(255, 228, 228));
    	this.parentController = parentController;
    	this.parentFrame = parentJFrame;
        this.parentFrame.setEnabled(true);
        initComponents();
        this.tenNguoiDangKyDetail.setText(tenNguoiDangKySuDungDetail);
        this.idDetail.setText(idDetail);
        this.lienHeDetail.setText(lienHeDetail);
        this.thoiGianMuonDetail.setText(thoiGianDetail);
        this.thoiGianTraDetail.setText(thoiGianDetail);
    	pack();
        controller = new XemChiTietMuonTraCotroller(tablePanel, this.tenNguoiDangKyDetail, this.popupMenu);
       
        listCoSoVatChat = controller.getListCoSoVatChat();
        listPhongBan = controller.getListPhongBan();
        
        GroupLayout gl_tablePanel = new GroupLayout(tablePanel);
        gl_tablePanel.setHorizontalGroup(
        	gl_tablePanel.createParallelGroup(Alignment.TRAILING)
        		.addGap(0, 566, Short.MAX_VALUE)
        );
        gl_tablePanel.setVerticalGroup(
        	gl_tablePanel.createParallelGroup(Alignment.TRAILING)
        		.addGap(0, 211, Short.MAX_VALUE)
        );
        tablePanel.setLayout(gl_tablePanel);
        controller.setDataTable();
    	setIconImage(Toolkit.getDefaultToolkit().getImage(XemChiTietMuonTraFrame.class.getResource("/Icons/house.png")));
    	setTitle("Xem chi tiết mượn trả");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }
            
        });
    }
    
    public XemChiTietMuonTraFrame(JFrame parentJFrame) {
        this.parentController = new MuonTraPanelController(){
            @Override
            public void refreshData() {
                // do nothing
            }

            @Override
            public void initAction() {
                // do nothing
            }
            
            
        };
        this.parentFrame = parentJFrame;
        this.parentFrame.setEnabled(false);
        this.muonTraBeann = new MuonTraBean();
        initComponents();
        setTitle("Xem chi tiết mượn trả");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        childController = new AddNewController();
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }
            
        });
    }
    
    void close() {
        this.parentFrame.setEnabled(true);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
    	DangKyCoSoVatChatPanel = new JPanel();
    	DangKyCoSoVatChatPanel.setBackground(new Color(255, 228, 228));
    	getContentPane().add(DangKyCoSoVatChatPanel, BorderLayout.CENTER);
    	
        popupMenu = new JPopupMenu();
        addPopup(tablePanel, popupMenu);
        
        chinhSua = new JMenuItem("Chỉnh sửa");
        popupMenu.add(chinhSua);
        chinhSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				chinhSuaActionPerformed(evt);
			}

		});

    	JLabel tenDangKyJlb = new JLabel("Tên người đăng ký:");
    	tenDangKyJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	JLabel idJlb = new JLabel("CCCD/TCC/HC:");
    	idJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	JLabel lienHeJlb = new JLabel("Liên hệ:");
    	lienHeJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	thoiGianMuonJlb = new JLabel("Thời gian mượn:");
    	thoiGianMuonJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	thoiGianTraJlb = new JLabel("Thời gian trả:");
    	thoiGianTraJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	tablePanel = new JPanel();
    	tablePanel.setBackground(new Color(255, 228, 228));
    	
    	DefaultComboBoxModel gioComboBoxModel = new DefaultComboBoxModel();
		for(int i = 0; i < 24; ++i) {
			if(i<10) gioComboBoxModel.addElement("0"+i);
			else gioComboBoxModel.addElement(i);
		}

    	DefaultComboBoxModel phutComboBoxModel = new DefaultComboBoxModel();
		for(int i = 0; i < 60; ++i) {
			if(i<10) phutComboBoxModel.addElement("0"+i);
			else phutComboBoxModel.addElement(i);
		}
    	
    	tenNguoiDangKyDetail = new JLabel("null");
    	tenNguoiDangKyDetail.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	idDetail = new JLabel("null");
    	idDetail.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	lienHeDetail = new JLabel("null");
    	lienHeDetail.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	thoiGianMuonDetail = new JLabel("null");
    	thoiGianMuonDetail.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	thoiGianTraDetail = new JLabel("null");
    	thoiGianTraDetail.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	GroupLayout gl_DangKyCoSoVatChatPanel = new GroupLayout(DangKyCoSoVatChatPanel);
    	gl_DangKyCoSoVatChatPanel.setHorizontalGroup(
    		gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    			.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    				.addContainerGap()
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    						.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    							.addComponent(idJlb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
    							.addComponent(tenDangKyJlb)
    							.addComponent(lienHeJlb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
    							.addComponent(thoiGianMuonJlb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
    						.addGap(13)
    						.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    							.addComponent(idDetail, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
    							.addComponent(tenNguoiDangKyDetail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    							.addComponent(lienHeDetail, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
    							.addComponent(thoiGianMuonDetail, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
    						.addContainerGap(17, Short.MAX_VALUE))
    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    						.addComponent(thoiGianTraJlb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
    						.addGap(18)
    						.addComponent(thoiGianTraDetail, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
    						.addContainerGap(18, Short.MAX_VALUE))
    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    						.addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
    						.addContainerGap(17, Short.MAX_VALUE))))
    	);
    	gl_DangKyCoSoVatChatPanel.setVerticalGroup(
    		gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    			.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    				.addContainerGap()
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.BASELINE)
    					.addComponent(tenDangKyJlb)
    					.addComponent(tenNguoiDangKyDetail))
    				.addGap(13)
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    					.addComponent(idDetail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    						.addComponent(idJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
    						.addPreferredGap(ComponentPlacement.UNRELATED)
    						.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.BASELINE)
    							.addComponent(lienHeJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
    							.addComponent(lienHeDetail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))))
    				.addPreferredGap(ComponentPlacement.UNRELATED)
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.BASELINE)
    					.addComponent(thoiGianMuonJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
    					.addComponent(thoiGianMuonDetail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
    				.addPreferredGap(ComponentPlacement.UNRELATED)
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    					.addComponent(thoiGianTraJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
    					.addComponent(thoiGianTraDetail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
    				.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
    				.addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
    				.addContainerGap())
    	);
    	DangKyCoSoVatChatPanel.setLayout(gl_DangKyCoSoVatChatPanel);
    }// </editor-fold>//GEN-END:initComponents
    
	private void chinhSuaActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		JTable xemChiTietTable = this.controller.getTable();
		int row = xemChiTietTable.getSelectedRow();
		if(row == -1) {
    		JOptionPane.showMessageDialog(null, "Hãy lựa chọn một hàng trước",
  			      "Lỗi không chọn hàng!", JOptionPane.ERROR_MESSAGE);
  		return;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");  
		try {
			Date ngayMuon = simpleDateFormat.parse(thoiGianMuonDetail.getText());
			Date now = new Date();
			if(now.compareTo(ngayMuon) > 0) {
	    		JOptionPane.showMessageDialog(null, "Đã quá lịch mượn, không thể chỉnh sửa",
	    			      "Lỗi không chọn hàng!", JOptionPane.ERROR_MESSAGE);
	    		return;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.print("Can't convert to timestamp");
			e.printStackTrace();
		}
		
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
    // check cac gia tri duoc nhap vao form
    private XemChiTietMuonTraCotroller controller;
	private MuonTraPanelController parentController;
    private JFrame parentFrame;
    private MuonTraBean muonTraBeann;
    private AddNewController childController;
    private List<PhongBanModel> listPhongBan;
    private List<CoSoVatChatModel> listCoSoVatChat;
    private JPanel DangKyCoSoVatChatPanel;
    private JLabel thoiGianMuonJlb;
    private JLabel thoiGianTraJlb;
    private ClassTableModel classTableModel = null;
    private JPanel tablePanel;
    private JLabel tenNguoiDangKyDetail;
    private JLabel idDetail;
    private JLabel lienHeDetail;
    private JLabel thoiGianMuonDetail;
    private JLabel thoiGianTraDetail;
    private JPopupMenu popupMenu;
    private JMenuItem chinhSua;
    private JMenuItem hoanTra;

	
}
