package views.CoSoVatChatFrame;

import Bean.CoSoVatChatBean;
import Bean.MuonTraBean;
import controllers.CoSoVatChatPanelController;
import controllers.LoginController;
import controllers.MuonTraPanelController;
import controllersAddNewController.AddNewController;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.EventObject;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.PhongBanModel;
import models.CoSoVatChatModel;
import models.NguoiMuonModel;
import models.ThoiGianModel;

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
public class ThemCoSoVatChatFrame extends javax.swing.JFrame {

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
    public ThemCoSoVatChatFrame(CoSoVatChatPanelController parentController, JFrame parentJFrame) {
    	setBackground(new Color(255, 228, 228));
    	this.parentController = parentController;
    	this.parentFrame = parentJFrame;
        this.parentFrame.setEnabled(false);
        initComponents();
    	setIconImage(Toolkit.getDefaultToolkit().getImage(ThemCoSoVatChatFrame.class.getResource("/Icons/house.png")));
    	setTitle("Thêm cơ sở vật chất");
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
    
    public ThemCoSoVatChatFrame(JFrame parentJFrame) {
        this.parentController = new CoSoVatChatPanelController(){
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
        this.coSoVatChatBean = new CoSoVatChatBean();
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
    	
    	JLabel tenCoSoVatChatJlb = new JLabel("Tên cơ sở vật chất:");
    	tenCoSoVatChatJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	JLabel soLuongJlb = new JLabel("Số lượng:");
    	soLuongJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	soLuongJtf = new JTextField();
    	soLuongJtf.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	soLuongJtf.setColumns(10);
    	
    	JLabel lyDoJlb = new JLabel("Lý do:");
    	lyDoJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	lyDoJtf = new JTextField();
    	lyDoJtf.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	lyDoJtf.setColumns(10);
    	
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
    	
    	tenCoSoVatChatJtf = new JTextField();
    	tenCoSoVatChatJtf.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	tenCoSoVatChatJtf.setColumns(10);
    	GroupLayout gl_DangKyCoSoVatChatPanel = new GroupLayout(DangKyCoSoVatChatPanel);
    	gl_DangKyCoSoVatChatPanel.setHorizontalGroup(
    		gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    			.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    				.addContainerGap()
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    						.addComponent(lyDoJlb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
    						.addPreferredGap(ComponentPlacement.UNRELATED)
    						.addComponent(lyDoJtf, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
    						.addContainerGap())
    					.addGroup(Alignment.TRAILING, gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    						.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    							.addComponent(soLuongJlb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
    							.addComponent(tenCoSoVatChatJlb))
    						.addPreferredGap(ComponentPlacement.UNRELATED)
    						.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    							.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    								.addComponent(soLuongJtf, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
    								.addGap(18)
    								.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
    							.addComponent(tenCoSoVatChatJtf, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
    						.addContainerGap())))
    	);
    	gl_DangKyCoSoVatChatPanel.setVerticalGroup(
    		gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    			.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    						.addGap(52)
    						.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.BASELINE)
    							.addComponent(tenCoSoVatChatJlb)
    							.addComponent(tenCoSoVatChatJtf, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
    						.addGap(18)
    						.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.BASELINE)
    							.addComponent(soLuongJtf, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
    							.addComponent(soLuongJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
    						.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    							.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    								.addGap(21)
    								.addComponent(lyDoJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
    							.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    								.addGap(18)
    								.addComponent(lyDoJtf, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    						.addGap(73)
    						.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
    				.addContainerGap(84, Short.MAX_VALUE))
    	);
    	
    	DangKyCoSoVatChatPanel.setLayout(gl_DangKyCoSoVatChatPanel);
    	pack();
    }// </editor-fold>//GEN-END:initComponents
    private void addThongTinDangKyCoSoVatChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBtnActionPerformed
    	if(validateValueInForm()) {
    		CoSoVatChatModel coSoVatChatModel = this.coSoVatChatBean.getCoSoVatChatModel();
    		coSoVatChatModel.setTenCoSoVatChat(tenCoSoVatChatJtf.getText());
    		coSoVatChatModel.setSoLuong(Integer.parseInt(soLuongJtf.getText()));
    		coSoVatChatModel.setLyDo(lyDoJtf.getText());
            try {
            	if(this.controller.addNewCoSoVatChat(coSoVatChatBean)) {
                    JOptionPane.showMessageDialog(null, "Thêm thành công!!");
                    close();
                    parentController.refreshData();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
    	}
    }
    // check cac gia tri duoc nhap vao form
    private boolean validateValueInForm() {
        // check null
    	if(tenCoSoVatChatJtf.getText().trim().isEmpty() 
    			|| soLuongJtf.getText().trim().isEmpty()
    			) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
    	}
    	try {
    		int soLuong = Integer.parseInt(soLuongJtf.getText());
    		if(soLuong <= 0) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng định dạng số lượng", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
    		}
    	} catch (Exception e) {
			// TODO: handle exception
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng định dạng số lượng", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
		}
        return true;
    }
	private CoSoVatChatPanelController parentController;
    private JFrame parentFrame;
    private CoSoVatChatBean coSoVatChatBean;
    private AddNewController controller;
    private JPanel DangKyCoSoVatChatPanel;
    private JTextField soLuongJtf;
    private JTextField lyDoJtf;
    private JTextField tenCoSoVatChatJtf;
}
