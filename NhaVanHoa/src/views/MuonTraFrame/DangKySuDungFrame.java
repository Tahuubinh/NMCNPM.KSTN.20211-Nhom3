package views.MuonTraFrame;

import Bean.MuonTraBean;
import ControllersAddNewController.AddCoSoVatChatPhongBanController;
import ControllersAddNewController.AddNewController;
import controllers.LoginController;
import controllers.MuonTraPanelController;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.util.Date;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.PhongBanModel;
import models.CoSoVatChatModel;
import models.NguoiMuonModel;
import models.ThoiGianModel;
import services.TimeService;
import utility.ClassTableModel;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;

import java.awt.Rectangle;
import javax.swing.JComboBox;

/**
 *
 * @author Hai
 */
public class DangKySuDungFrame extends javax.swing.JFrame {


    /**
     * @wbp.parser.constructor
     */
    public DangKySuDungFrame(MuonTraPanelController parentController, JFrame parentJFrame) {
    	setBackground(new Color(255, 228, 228));
    	this.parentController = parentController;
    	this.parentFrame = parentJFrame;
        this.parentFrame.setEnabled(true);
        
	    gioDjcb = new DefaultComboBoxModel();
	    for(int i = 0; i < 24; ++i) {
	    	if(i< 10) gioDjcb.addElement("0"+i);
	    	else gioDjcb.addElement(i+"");
	    }
	    
	    phutDjcb = new DefaultComboBoxModel();
	    for(int i = 0; i < 60; ++i) {
	    	if(i< 10) phutDjcb.addElement("0"+i);
	    	else phutDjcb.addElement(i+"");
	    }
	    
        initComponents();
        controller = new MuonCoSoVatChatPhongBanFrame(tablePanel, this.parentFrame);
        timeService = new TimeService();
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
        initAction();
    	setIconImage(Toolkit.getDefaultToolkit().getImage(DangKySuDungFrame.class.getResource("/Icons/house.png")));
    	setTitle("Đăng ký sử dụng cơ sở vật chất / phòng ban");
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

    public void initAction(){
		 gioMuonJcb.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent ke) {
					LinkedList<String> filterNode = new LinkedList<String>();
					for(int i = 0; i < gioDjcb.getSize(); ++i) {
						if((gioDjcb.getElementAt(i)+"").contains(gioMuonJtf.getText())) {
							filterNode.add(gioDjcb.getElementAt(i)+"");
						}
					}
					if(filterNode.size() >0) {
						gioMuonJcb.setModel(new DefaultComboBoxModel(filterNode.toArray()));
						gioMuonJcb.setSelectedItem(gioMuonJtf.getText());
						gioMuonJcb.showPopup();
					} else {
						gioMuonJcb.hidePopup();
					}
				}
		});
		 
		 phutMuonJcb.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent ke) {
					LinkedList<String> filterNode = new LinkedList<String>();
					for(int i = 0; i < gioDjcb.getSize(); ++i) {
						if((phutDjcb.getElementAt(i)+"").contains(phutMuonJtf.getText())) {
							filterNode.add(gioDjcb.getElementAt(i)+"");
						}
					}
					if(filterNode.size() >0) {
						phutMuonJcb.setModel(new DefaultComboBoxModel(filterNode.toArray()));
						phutMuonJcb.setSelectedItem(phutMuonJtf.getText());
						phutMuonJcb.showPopup();
					} else {
						phutMuonJcb.hidePopup();
					}
				}
		});
		 
		 gioTraJcb.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent ke) {
					LinkedList<String> filterNode = new LinkedList<String>();
					for(int i = 0; i < gioDjcb.getSize(); ++i) {
						if((gioDjcb.getElementAt(i)+"").contains(gioTraJtf.getText())) {
							filterNode.add(gioDjcb.getElementAt(i)+"");
						}
					}
					if(filterNode.size() >0) {
						gioTraJcb.setModel(new DefaultComboBoxModel(filterNode.toArray()));
						gioTraJcb.setSelectedItem(gioTraJtf.getText());
						gioTraJcb.showPopup();
					} else {
						gioTraJcb.hidePopup();
					}
				}
		});
		 
		 phutTraJcb.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent ke) {
					LinkedList<String> filterNode = new LinkedList<String>();
					for(int i = 0; i < phutDjcb.getSize(); ++i) {
						if((phutDjcb.getElementAt(i)+"").contains(phutTraJtf.getText())) {
							filterNode.add(phutDjcb.getElementAt(i)+"");
						}
					}
					if(filterNode.size() >0) {
						phutTraJcb.setModel(new DefaultComboBoxModel(filterNode.toArray()));
						phutTraJcb.setSelectedItem(phutTraJtf.getText());
						phutTraJcb.showPopup();
					} else {
						phutTraJcb.hidePopup();
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
    	
    	JLabel tenDangKyJlb = new JLabel("Tên người đăng ký:");
    	tenDangKyJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	tenNguoiMuonJtf = new JTextField();
    	tenNguoiMuonJtf.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	tenNguoiMuonJtf.setColumns(10);
    	
    	JLabel idJlb = new JLabel("CCCD/TCC/HC:");
    	idJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	idJtf = new JTextField();
    	idJtf.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	idJtf.setColumns(10);
    	
    	JLabel lienHeJlb = new JLabel("Liên hệ:");
    	lienHeJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	lienHeJtf = new JTextField();
    	lienHeJtf.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	lienHeJtf.setColumns(10);
    	
    	lblNewLabel_1_2 = new JLabel("Thời gian mượn:");
    	lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	lblNewLabel_1_3 = new JLabel("Thời gian trả:");
    	lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	JButton okButton = new JButton("OK");
    	okButton.setBorder(null);
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
    	okButton.setForeground(Color.WHITE);
    	okButton.setFont(new Font("Tahoma", Font.BOLD, 16));
    	okButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent evt) {
    			addThongTinDangKyCoSoVatChatActionPerformed(evt);
    		}
    		
    	});
    	okButton.setBackground(new Color(212, 84, 21));
    	
    	tablePanel = new JPanel();
    	tablePanel.setBackground(new Color(255, 228, 228));
    	
    	muonButton = new JButton("Mượn");
    	muonButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	muonButton.setBackground(new Color(0, 255, 0));
    	muonButton.setBorder(null);
    	muonButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent evt) {
    			muonActionPerformed(evt);
    		}
    	});
    	muonButton.setIcon(null);
    	
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
    	ngayMuonJdc = new JDateChooser();
    	ngayMuonJdc.getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	ngayTraJdc = new JDateChooser();
    	ngayTraJdc.getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	gioMuonJcb = new JComboBox(gioDjcb);
    	gioMuonJcb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	gioMuonJlb = new JLabel("Giờ");
    	gioMuonJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gioMuonJtf = (JTextField) gioMuonJcb.getEditor().getEditorComponent();

    	phutMuonJcb = new JComboBox(phutDjcb);
    	phutMuonJcb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	phuMuonJlb = new JLabel("Phút");
    	phuMuonJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phutMuonJtf = (JTextField) phutMuonJcb.getEditor().getEditorComponent();

    	gioTraJcb = new JComboBox(gioDjcb);
    	gioTraJcb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	giaTraJlb = new JLabel("Giờ");
    	giaTraJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gioTraJtf = (JTextField) gioTraJcb.getEditor().getEditorComponent();

    	phutTraJcb = new JComboBox(phutDjcb);
    	phutTraJcb.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	
    	phutTraJlb = new JLabel("Phút");
    	phutTraJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phutTraJtf = (JTextField) phutTraJcb.getEditor().getEditorComponent();

    	GroupLayout gl_DangKyCoSoVatChatPanel = new GroupLayout(DangKyCoSoVatChatPanel);
    	gl_DangKyCoSoVatChatPanel.setHorizontalGroup(
    		gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    			.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    				.addContainerGap()
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    					.addComponent(lienHeJlb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
    					.addComponent(idJlb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
    					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
    					.addComponent(tenDangKyJlb)
    					.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.TRAILING)
    						.addComponent(muonButton, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
    						.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
    				.addGap(13)
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    						.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.TRAILING)
    							.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    								.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.TRAILING)
    									.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    										.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.TRAILING)
    											.addComponent(idJtf, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
    											.addComponent(lienHeJtf, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
    										.addGap(20))
    									.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    										.addComponent(tenNguoiMuonJtf, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
    										.addGap(18)))
    								.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
    							.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    								.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.TRAILING)
    									.addComponent(ngayTraJdc, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
    									.addComponent(ngayMuonJdc, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
    								.addPreferredGap(ComponentPlacement.UNRELATED)
    								.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING, false)
    									.addComponent(gioTraJcb, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    									.addComponent(gioMuonJcb, Alignment.TRAILING, 0, 44, Short.MAX_VALUE))
    								.addPreferredGap(ComponentPlacement.RELATED)
    								.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.TRAILING)
    									.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    										.addComponent(gioMuonJlb)
    										.addPreferredGap(ComponentPlacement.UNRELATED)
    										.addComponent(phutMuonJcb, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
    										.addPreferredGap(ComponentPlacement.RELATED)
    										.addComponent(phuMuonJlb, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
    									.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    										.addComponent(giaTraJlb, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
    										.addPreferredGap(ComponentPlacement.UNRELATED)
    										.addComponent(phutTraJcb, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
    										.addPreferredGap(ComponentPlacement.RELATED)
    										.addComponent(phutTraJlb, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
    								.addGap(77)))
    						.addGap(17))
    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    						.addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
    						.addContainerGap())))
    	);
    	gl_DangKyCoSoVatChatPanel.setVerticalGroup(
    		gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    			.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    						.addContainerGap()
    						.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.BASELINE)
    							.addComponent(tenDangKyJlb)
    							.addComponent(tenNguoiMuonJtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    						.addGap(13)
    						.addComponent(idJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
    						.addGap(20)
    						.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.BASELINE)
    							.addComponent(lienHeJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
    							.addComponent(lienHeJtf, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    						.addGap(31)
    						.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.BASELINE)
    							.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
    							.addComponent(idJtf, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
    				.addGap(9)
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.TRAILING)
    					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
    					.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.BASELINE)
    						.addComponent(phutMuonJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    						.addComponent(phuMuonJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
    						.addComponent(gioMuonJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    						.addComponent(gioMuonJlb))
    					.addComponent(ngayMuonJdc, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
    				.addGap(16)
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    					.addComponent(ngayTraJdc, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
    					.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
    					.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.BASELINE)
    						.addComponent(gioTraJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    						.addComponent(giaTraJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
    						.addComponent(phutTraJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    						.addComponent(phutTraJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    						.addGap(68)
    						.addComponent(muonButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
    						.addPreferredGap(ComponentPlacement.UNRELATED)
    						.addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
    				.addContainerGap())
    	);
    	DangKyCoSoVatChatPanel.setLayout(gl_DangKyCoSoVatChatPanel);
    	pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void muonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBtnActionPerformed
    	controller.setMuonCoSoVatChatPhongBanFrame();
    	controller.setLocationRelativeTo(null);
    	controller.setResizable(false);
    	controller.setVisible(true);
    }
    private void addThongTinDangKyCoSoVatChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBtnActionPerformed
    	if(validateValueInForm()) {
    		NguoiMuonModel nguoiMuonModel = this.muonTraBeann.getNguoiMuonModel();
    		ThoiGianModel thoiGianModel = this.muonTraBeann.getThoiGianModel();
    		List<CoSoVatChatModel> listCoSoVatChatModels = this.controller.getCoSoVatChatMuon();
    		List<PhongBanModel> listPhongBanModels = this.controller.getPhongBanMuon();
    		nguoiMuonModel.setTenNguoiMuon(tenNguoiMuonJtf.getText());
    		nguoiMuonModel.setCccd(idJtf.getText());
    		nguoiMuonModel.setLienHe(lienHeJtf.getText());
    		thoiGianModel.setThoiGianMuon(this.timeService.convertDateToTimestamp(ngayMuonJdc.getDate(), gioMuonJcb.getSelectedItem()+"", gioTraJcb.getSelectedItem()+""));
    		thoiGianModel.setThoiGianTra(this.timeService.convertDateToTimestamp(ngayTraJdc.getDate(), gioMuonJcb.getSelectedItem()+"", gioTraJcb.getSelectedItem()+""));
    		this.muonTraBeann.setListCoSoVatChatModels(listCoSoVatChatModels);
    		this.muonTraBeann.setListPhongBanModels(listPhongBanModels);
    		this.muonTraBeann.setNguoiMuonModel(nguoiMuonModel);
    		this.muonTraBeann.setThoiGianModel(thoiGianModel);
    		
            try {
                if(this.childController.addNewNguoiMuon(muonTraBeann)) {
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
    	if(tenNguoiMuonJtf.getText().trim().isEmpty()
    			|| lienHeJtf.getText().trim().isEmpty()
    			) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
    	}
        if (idJtf.getText().length() != 9 && idJtf.getText().length() != 12) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng định dạng CCCD/CC/HC", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        Date now = new Date();
        if(now.compareTo(ngayMuonJdc.getDate()) > 0) {
            JOptionPane.showMessageDialog(rootPane, "Ngày mượn phải được mượn hiện tại hoặc tương lai!", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(ngayMuonJdc.getDate().compareTo(ngayMuonJdc.getDate()) > 0) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng ngày trả", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    private TimeService timeService;
    private MuonCoSoVatChatPhongBanFrame controller;
	private MuonTraPanelController parentController;
    private JFrame parentFrame;
    private MuonTraBean muonTraBeann;
    private AddNewController childController;
    private JPanel DangKyCoSoVatChatPanel;
    private JTextField tenNguoiMuonJtf;
    private JTextField idJtf;
    private JTextField lienHeJtf;
    private JLabel lblNewLabel_1_2;
    private JLabel lblNewLabel_1_3;
    private JButton muonButton;
    private JDateChooser ngayMuonJdc;
    private JDateChooser ngayTraJdc;
    private ClassTableModel classTableModel = null;
    private JPanel tablePanel;
    private JComboBox gioMuonJcb;
    private JLabel gioMuonJlb;
    private JComboBox phutMuonJcb;
    private JLabel phuMuonJlb;
    private JComboBox gioTraJcb;
    private JLabel giaTraJlb;
    private JComboBox phutTraJcb;
    private JLabel phutTraJlb;
    private DefaultComboBoxModel gioDjcb;
    private DefaultComboBoxModel phutDjcb;
    private JTextField gioMuonJtf;
    private JTextField phutMuonJtf;
    private JTextField gioTraJtf;
    private JTextField phutTraJtf;
}
