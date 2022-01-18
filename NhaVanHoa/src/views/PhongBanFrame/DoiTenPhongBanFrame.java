package views.PhongBanFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controllers.CoSoVatChatPanelController;
import controllers.PhongBanPanelController;
import controllers.CoSoVatChatController.XemChiTietCoSoVatChatCotroller;
import services.CoSoVatChatService;
import services.PhongBanService;
import views.MuonTraFrame.DangKySuDungFrame;
import views.MuonTraFrame.MuonCoSoVatChatPhongBanFrame;
import models.CoSoVatChatModel;
import models.NhaTaiTroModel;
import models.PhongBanModel;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Bean.CoSoVatChatBean;
import Bean.PhongBanBean;
import ControllersAddNewController.AddNewController;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.ComponentOrientation;

public class DoiTenPhongBanFrame extends javax.swing.JFrame {
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
    public DoiTenPhongBanFrame(PhongBanPanelController parentController, JFrame parentJFrame, String tenPhongBanDetail) {
    	setTitle("Đổi tên phòng ban");
    	setBackground(new Color(255, 228, 228));
    	this.parentController = parentController;
    	this.parentFrame = parentJFrame;
        this.parentFrame.setEnabled(false);
        initComponents();
        this.tenPhongBanDetail.setText(tenPhongBanDetail);
        this.tenPhongBanCu = tenPhongBanDetail;
    	pack();
    	setIconImage(Toolkit.getDefaultToolkit().getImage(ThemPhongBanFrame.class.getResource("/Icons/house.png")));
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
    
    public DoiTenPhongBanFrame(JFrame parentJFrame) {
        this.parentController = new PhongBanPanelController(){
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
        this.phongBanBean = new PhongBanBean();
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
    	
    	DangKyPhongBanPanel = new JPanel();
    	DangKyPhongBanPanel.setBackground(new Color(255, 228, 228));
    	getContentPane().add(DangKyPhongBanPanel, BorderLayout.CENTER);
    	
    	JLabel tenPhongBanMoiJlb = new JLabel("Tên phòng ban mới:");
    	tenPhongBanMoiJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
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
    			doiTenPhongBanActionPerformed(evt);
    		}
    		
    	});
    	okButton.setBackground(new Color(212, 84, 21));
    	
    	tenPhongBanJtf = new JTextField();
    	tenPhongBanJtf.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	tenPhongBanJtf.setColumns(10);
    	
    	tenPhongBanJlb = new JLabel("Tên phòng ban:");
    	tenPhongBanJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	tenPhongBanDetail = new JLabel("null");
    	tenPhongBanDetail.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	GroupLayout gl_DangKyPhongBanPanel = new GroupLayout(DangKyPhongBanPanel);
    	gl_DangKyPhongBanPanel.setHorizontalGroup(
    		gl_DangKyPhongBanPanel.createParallelGroup(Alignment.LEADING)
    			.addGroup(gl_DangKyPhongBanPanel.createSequentialGroup()
    				.addContainerGap()
    				.addGroup(gl_DangKyPhongBanPanel.createParallelGroup(Alignment.LEADING)
    					.addComponent(tenPhongBanMoiJlb)
    					.addComponent(lyDoJlb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
    					.addComponent(tenPhongBanJlb, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
    				.addPreferredGap(ComponentPlacement.RELATED)
    				.addGroup(gl_DangKyPhongBanPanel.createParallelGroup(Alignment.LEADING, false)
    					.addComponent(tenPhongBanDetail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    					.addComponent(lyDoJtf)
    					.addComponent(tenPhongBanJtf, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
    				.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
    				.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
    				.addContainerGap())
    	);
    	gl_DangKyPhongBanPanel.setVerticalGroup(
    		gl_DangKyPhongBanPanel.createParallelGroup(Alignment.LEADING)
    			.addGroup(gl_DangKyPhongBanPanel.createSequentialGroup()
    				.addGroup(gl_DangKyPhongBanPanel.createParallelGroup(Alignment.LEADING)
    					.addGroup(gl_DangKyPhongBanPanel.createSequentialGroup()
    						.addGap(41)
    						.addGroup(gl_DangKyPhongBanPanel.createParallelGroup(Alignment.LEADING)
    							.addComponent(tenPhongBanJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
    							.addComponent(tenPhongBanDetail))
    						.addGap(18)
    						.addGroup(gl_DangKyPhongBanPanel.createParallelGroup(Alignment.BASELINE)
    							.addComponent(tenPhongBanMoiJlb)
    							.addComponent(tenPhongBanJtf, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
    						.addGroup(gl_DangKyPhongBanPanel.createParallelGroup(Alignment.LEADING)
    							.addGroup(gl_DangKyPhongBanPanel.createSequentialGroup()
    								.addGap(22)
    								.addComponent(lyDoJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
    							.addGroup(gl_DangKyPhongBanPanel.createSequentialGroup()
    								.addGap(19)
    								.addComponent(lyDoJtf, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
    					.addGroup(gl_DangKyPhongBanPanel.createSequentialGroup()
    						.addGap(83)
    						.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
    				.addContainerGap(82, Short.MAX_VALUE))
    	);
    	
    	DangKyPhongBanPanel.setLayout(gl_DangKyPhongBanPanel);
    }// </editor-fold>//GEN-END:initComponents
    private void doiTenPhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBtnActionPerformed
    	if(validateValueInForm()) {
    		PhongBanModel phongBanModel = this.phongBanBean.getPhongBanModel();
    		phongBanModel.setTenPhongBan(tenPhongBanJtf.getText());
    		phongBanModel.setLyDo(lyDoJtf.getText());
    		this.phongBanBean.setPhongBanModel(phongBanModel);
            try {
            	PhongBanService phongBanService = new PhongBanService();
            	phongBanService.doiTenPhongBan(tenPhongBanCu, tenPhongBanJtf.getText());
            	parentController.refreshData();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
    	}
    }
    // check cac gia tri duoc nhap vao form
    private boolean validateValueInForm() {
        // check null
    	if(tenPhongBanJtf.getText().trim().isEmpty() 
    			) {
            return false;
    	}

        return true;
    }
	private PhongBanPanelController parentController;
    private JFrame parentFrame;
    private PhongBanBean phongBanBean;
    private AddNewController controller;
    private JPanel DangKyPhongBanPanel;
    private JTextField lyDoJtf;
    private JTextField tenPhongBanJtf;
    private JLabel tenPhongBanJlb;
    private String tenPhongBanCu;
    private JLabel tenPhongBanDetail;
}
