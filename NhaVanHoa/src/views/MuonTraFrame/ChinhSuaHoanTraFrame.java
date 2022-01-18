package views.MuonTraFrame;

import Bean.CoSoVatChatBean;
import Bean.MuonTraBean;
import ControllersAddNewController.AddNewController;
import controllers.CoSoVatChatPanelController;
import controllers.LoginController;
import controllers.MuonTraPanelController;
import controllers.MuonTraController.XemChiTietMuonTraCotroller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.util.Date;
import java.util.EventObject;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.PhongBanModel;
import models.CoSoVatChatModel;
import models.NguoiMuonModel;
import models.NhaTaiTroModel;
import models.ThoiGianModel;
import services.MuonTraService;
import services.TimeService;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
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

/**
 *
 * @author Hai
 */
public class ChinhSuaHoanTraFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddNewPeopleJFrame
     */



//    public AddNewPeopleJFrame() {
//        initComponents();
//        setTitle("Thêm mới nhân khẩu");
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        controller = new AddNewController();
//    }

    /**
     * @wbp.parser.constructor
     */
    public ChinhSuaHoanTraFrame(XemChiTietMuonTraCotroller parentController, JFrame parentJFrame, String tenNguoiHoanTra, String cccdNguoiMuon, String thoiGianMuon, String tenCoSoVatChatPhongBan, int soLuongDaHoanTra, int isCoSoVatChat) {
    	setBackground(new Color(255, 228, 228));
    	this.parentController = parentController;
    	this.parentFrame = parentJFrame;
        this.parentFrame.setEnabled(false);
        this.muonTraBean = new MuonTraBean();
        initComponents();
        this.tenCoSoVatChatPhongBanDetailJlb.setText(tenCoSoVatChatPhongBan);
        this.soLuongDaHoanTraDetailJlb.setText(soLuongDaHoanTra+"");
        this.soLuongHoanTraJtf.setText(soLuongDaHoanTra+"");
        this.soLuongDaHoanTraNow = soLuongDaHoanTra;
        this.cccdNguoiMuon = cccdNguoiMuon;
        this.thoiGianMuon = thoiGianMuon;
    	setIconImage(Toolkit.getDefaultToolkit().getImage(ChinhSuaHoanTraFrame.class.getResource("/Icons/house.png")));
    	setTitle("Chỉnh sửa cơ sở vật chất / phòng ban đã mượn");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }
            
        });
        controller = new AddNewController();
    }
    
    public ChinhSuaHoanTraFrame(JFrame parentJFrame) {
        this.parentController = new XemChiTietMuonTraCotroller(){
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
        this.muonTraBean = new MuonTraBean();
        initComponents();
        setTitle("Thêm mới cơ sở vật chất");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        controller = new AddNewController();
        
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
    	
    	JLabel tenCoSoVatChatPhongBanJlb = new JLabel("Tên cơ sở vật chất / phòng ban:");
    	tenCoSoVatChatPhongBanJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	JLabel soLuongDaHoanTraJlb = new JLabel("Số lượng đã hoàn trả :");
    	soLuongDaHoanTraJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	soLuongHoanTraJtf = new JTextField();
    	soLuongHoanTraJtf.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	soLuongHoanTraJtf.setColumns(10);
    	
    	JButton okButton = new JButton("OK");
    	okButton.addMouseListener(new MouseAdapter() {
    		
    		@Override
        	public void mouseEntered(MouseEvent e) {
                okButton.setBackground(new Color(195, 66, 2));
        	}
    		@Override
        	public void mousePressed(MouseEvent e) {
            	okButton.setBackground(new Color(212, 84, 21));
        	}
    		@Override
        	public void mouseReleased(MouseEvent e) {
                okButton.setBackground(new Color(195, 66, 2));
        	}
    		@Override
        	public void mouseExited(MouseEvent e) {
            	okButton.setBackground(new Color(212, 84, 21));
        	}
    	});
    	okButton.setBorder(null);
    	okButton.setForeground(Color.WHITE);
    	okButton.setFont(new Font("Tahoma", Font.BOLD, 16));
    	okButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent evt) {
    			addThongTinDangKyCoSoVatChatActionPerformed(evt);
    		}
    	});
    	okButton.setBackground(new Color(212, 84, 21));
    	
    	tenCoSoVatChatPhongBanDetailJlb = new JLabel("null");
    	tenCoSoVatChatPhongBanDetailJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	changeSoLuongHoanTraJlb = new JLabel("Số lượng hoàn trả thay đổi :");
    	changeSoLuongHoanTraJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	soLuongDaHoanTraDetailJlb = new JLabel("0");
    	soLuongDaHoanTraDetailJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	GroupLayout gl_DangKyCoSoVatChatPanel = new GroupLayout(DangKyCoSoVatChatPanel);
    	gl_DangKyCoSoVatChatPanel.setHorizontalGroup(
    		gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    			.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    				.addContainerGap()
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    					.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING, false)
    						.addComponent(soLuongDaHoanTraJlb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    						.addComponent(tenCoSoVatChatPhongBanJlb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    					.addComponent(changeSoLuongHoanTraJlb, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
    				.addPreferredGap(ComponentPlacement.UNRELATED)
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING, false)
    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    						.addComponent(tenCoSoVatChatPhongBanDetailJlb)
    						.addGap(140))
    					.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.TRAILING, false)
    						.addComponent(soLuongDaHoanTraDetailJlb, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
    						.addComponent(soLuongHoanTraJtf, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
    				.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
    				.addContainerGap())
    	);
    	gl_DangKyCoSoVatChatPanel.setVerticalGroup(
    		gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.TRAILING)
    			.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    				.addGap(84)
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.BASELINE)
    					.addComponent(tenCoSoVatChatPhongBanJlb)
    					.addComponent(tenCoSoVatChatPhongBanDetailJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
    				.addGap(18)
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.BASELINE)
    					.addComponent(soLuongDaHoanTraJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
    					.addComponent(soLuongDaHoanTraDetailJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
    				.addGap(13)
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.BASELINE)
    					.addComponent(soLuongHoanTraJtf, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
    					.addComponent(changeSoLuongHoanTraJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
    				.addContainerGap(60, Short.MAX_VALUE))
    			.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    				.addContainerGap(94, Short.MAX_VALUE)
    				.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
    				.addGap(91))
    	);
    	
    	DangKyCoSoVatChatPanel.setLayout(gl_DangKyCoSoVatChatPanel);
    	pack();
    }// </editor-fold>//GEN-END:initComponents
    private void addThongTinDangKyCoSoVatChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBtnActionPerformed
    	if(validateValueInForm()) {
    		MuonTraService muonTraService = new MuonTraService();
    		TimeService timeService = new TimeService();
    		int soLuong = Integer.parseInt(soLuongHoanTraJtf.getText());
    		int soLuongDaTraBanDau = Integer.parseInt(soLuongDaHoanTraDetailJlb.getText());
    		String tenCoSoVatChatPhongBan = tenCoSoVatChatPhongBanDetailJlb.getText();
    		Timestamp thoiGianMuonTS = timeService.convertDatetableToTimestamp(this.thoiGianMuon);
    		String thoiGianMuon = timeService.convertToDate(thoiGianMuonTS);
    		if(soLuong == this.soLuongDaHoanTraNow) {
    			return;
    		}
    		if(isCoSoVatChat > 0) {
    			CoSoVatChatModel coSoVatChatModel = muonTraBean.getCoSoVatChatModel();
    			coSoVatChatModel.setTenCoSoVatChat(tenCoSoVatChatPhongBan);
    			coSoVatChatModel.setSoLuongDaTra(soLuong);
    			try {
    					if(JOptionPane.showConfirmDialog(null,   " Thay đổi hoàn trả thành " + soLuong + " cái " + tenCoSoVatChatPhongBan , "Question",JOptionPane.YES_NO_OPTION) == 0) {
                    		if(muonTraService.chinhSuaHoanTraCoSoVatChat(this.cccdNguoiMuon, coSoVatChatModel, thoiGianMuon))
                                {
                    				JOptionPane.showMessageDialog(null, "Chỉnh sửa hoàn trả thành công!!");
                                    close();
                                    parentController.refreshData();
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Số lượng hoàn trả lớn hơn số lượng mượn!!", "Warning", JOptionPane.WARNING_MESSAGE);
                                }
                    	}
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
    		} else {
    			try {
    					if(JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn không mượn  "+ tenCoSoVatChatPhongBan +" ?", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    		if(muonTraService.chinhSuaHoanTraPhongBan(this.cccdNguoiMuon, tenCoSoVatChatPhongBan, thoiGianMuon))
                            {
                				JOptionPane.showMessageDialog(null, "Xóa thành công!!");
                                close();
                                parentController.refreshData();
                            }
                    	}
    					return;
        
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
    		}
            
    	}
    }
    // check cac gia tri duoc nhap vao form
    private boolean validateValueInForm() {
        // check null
    	if(soLuongHoanTraJtf.getText().trim().isEmpty()
    			) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
    	}
    	try {
    		int soLuong = Integer.parseInt(soLuongHoanTraJtf.getText());
    		if(soLuong < 0) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng định dạng số lượng", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
    		}
    		if(soLuong == Integer.parseInt(soLuongDaHoanTraDetailJlb.getText())) {
    			return false;
    		}
    	} catch (Exception e) {
			// TODO: handle exception
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng định dạng số lượng", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
		}
        return true;
    }
	private XemChiTietMuonTraCotroller parentController;
    private JFrame parentFrame;
    private MuonTraBean muonTraBean;
    private AddNewController controller;
    private JPanel DangKyCoSoVatChatPanel;
    private JTextField soLuongHoanTraJtf;
    private JLabel tenCoSoVatChatPhongBanDetailJlb;
    private String cccdNguoiMuon;
    private String thoiGianMuon;
    private String tenNguoiHoanTra;
    private int isCoSoVatChat;
    private int soLuongDaHoanTraNow;
    private JLabel changeSoLuongHoanTraJlb;
    private JLabel soLuongDaHoanTraDetailJlb;
}
