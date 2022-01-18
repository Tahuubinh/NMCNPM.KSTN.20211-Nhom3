package views.MuonTraFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Bean.CoSoVatChatBean;
import Bean.MuonTraBean;
import Bean.PhongBanBean;
import ControllersAddNewController.AddCoSoVatChatPhongBanController;
import ControllersAddNewController.AddNewController;
import controllers.MuonTraPanelController;
import models.CoSoVatChatModel;
import models.NguoiMuonModel;
import models.PhongBanModel;
import models.ThoiGianModel;
import services.CoSoVatChatService;
import services.PhongBanService;
import utility.ClassTableModel;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class MuonCoSoVatChatPhongBanFrame extends javax.swing.JFrame {

	 /**
	  * @wbp.parser.constructor
	  */
	 public MuonCoSoVatChatPhongBanFrame(JPanel jpnView, JFrame parentJFrame) {
	    	this.parentJFrame = parentJFrame;
	        this.parentJFrame.setEnabled(false);
	        this.jpnView = jpnView;
	        coSoVatChatService = new CoSoVatChatService();
	        phongBanService = new PhongBanService();
	        listCoSoVatChatBeans = coSoVatChatService.getListCoSoVatChat();
	        listPhongBanBeans = phongBanService.getListPhongBan();
	        listCoSoVatChat = new ArrayList<>();
	        listPhongBan = new ArrayList<>();
	        this.listCoSoVatChatBeans.forEach(coSoVatChat -> {
	            listCoSoVatChat.add(coSoVatChat.getCoSoVatChatModel());
	        });
	        listPhongBanBeans = phongBanService.getListPhongBan();
	        this.listPhongBanBeans.forEach(phongBan -> {
	        	listPhongBan.add(phongBan.getPhongBanModel());
	        });
	        
	        classTableModel = new ClassTableModel();
	        listCoSoVatChatMuon = new ArrayList<>();
		    listPhongBanMuon = new ArrayList<>();
		    itemComboBoxModel = new DefaultComboBoxModel();
			itemComboBoxModel.addElement("");
		    if(listCoSoVatChat.size()  > 0) {
		    	listCoSoVatChat.forEach(coSoVatChat -> {
		    	itemComboBoxModel.addElement(coSoVatChat.getTenCoSoVatChat());
		    	}); 
		    };
		    if(listCoSoVatChat.size() > 0) {
		    	listPhongBan.forEach(phongBan -> {
		    	itemComboBoxModel.addElement(phongBan.getTenPhongBan());
		    	});
		    };

	 }
	 public void initAction(){
		 tenCoSoVatChatPhongBanJcb.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent ke) {
					LinkedList<String> filterNode = new LinkedList<String>();
					for(int i = 0; i < itemComboBoxModel.getSize(); ++i) {
						if((itemComboBoxModel.getElementAt(i)+"").contains(itemJtf.getText())) {
							filterNode.add(itemComboBoxModel.getElementAt(i)+"");
						}
					}
					if(filterNode.size() >0) {
						tenCoSoVatChatPhongBanJcb.setModel(new DefaultComboBoxModel(filterNode.toArray()));
						tenCoSoVatChatPhongBanJcb.setSelectedItem(itemJtf.getText());
						tenCoSoVatChatPhongBanJcb.showPopup();
					} else {
						tenCoSoVatChatPhongBanJcb.hidePopup();
					}
				}
		});
	 }
	    //Khi an Filter, bien listMuonTraBeans se call muonTraService de thonn ke thon tin vua nhap
	    //Chu y cac thong tin null
	 public void setData(){
	      setDataTable();
	 }
	    
	 public void setDataTable() {
	        DefaultTableModel model = classTableModel.setTableAddMuonTra(listCoSoVatChatMuon, listPhongBanMuon, COLUMNS);
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
	        table.setRowHeight(30);
	        table.validate();
	        table.repaint();
	        table.setFont(new Font("Arial", Font.PLAIN, 14));
	        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	        table.getColumnModel().getColumn(1).setMaxWidth(80);
	        table.getColumnModel().getColumn(1).setMinWidth(80);
	        table.getColumnModel().getColumn(1).setPreferredWidth(80);
	        table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );

	        JScrollPane scroll = new JScrollPane();
	        scroll.getViewport().add(table);
	        scroll.setPreferredSize(new Dimension(1350, 400));
	        jpnView.removeAll();
	        jpnView.setLayout(new BorderLayout());
	        jpnView.add(scroll, BorderLayout.CENTER);
	        jpnView.validate();
	        jpnView.repaint();
	    }


	 public void setMuonCoSoVatChatPhongBanFrame() {
	 		setBackground(new Color(255, 228, 228));
	        initComponents();
	        initAction();
	    	setIconImage(Toolkit.getDefaultToolkit().getImage(DangKySuDungFrame.class.getResource("/Icons/house.png")));
	    	setTitle("Mượn cơ sở vật chất / phòng ban");
	        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        checkCoSoVatChat = false;
	        checkPhongBan = false;
	        this.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
	                    close();
	                }
	            }
	            
	        });
	 	}
	    
	    public MuonCoSoVatChatPhongBanFrame(JFrame parentJFrame) {
//	        this.parentController = new AddNewController(){
////	            @Override
////	            public void refreshData() {
////	                // do nothing
////	            }
////
////	            @Override
////	            public void initAction() {
////	                // do nothing
////	            }
//	            
//	            
//	        };
	        this.parentJFrame = parentJFrame;
	        this.parentJFrame.setEnabled(false);
	        initComponents();
	        setTitle("Mượn cơ sở vật chất / phòng ban");
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
	    
	    void close() {
	        this.parentJFrame.setEnabled(true);
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
	    	
	    	JLabel tenCoSoVatChatPhongBanJlb = new JLabel("Cơ sở vật chất / phòng ban");
	    	tenCoSoVatChatPhongBanJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    	
	    	JLabel soLuongJlb = new JLabel("Số lượng");
	    	soLuongJlb.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    	
	    	soLuongJtf = new JTextField();
	    	soLuongJtf.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    	soLuongJtf.setColumns(10);
	    	
	    	okButton = new JButton("OK");
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
	    			addCoSoVatChatPhongBanMuonActionPerformed(evt);
	    		}
	    		
	    	});
	    	okButton.setBackground(new Color(212, 84, 21));
	    	tenCoSoVatChatPhongBanJcb = new JComboBox(itemComboBoxModel);
	    	tenCoSoVatChatPhongBanJcb.setBorder(UIManager.getBorder("TextField.border"));
	    	tenCoSoVatChatPhongBanJcb.setEditable(true);
	    	tenCoSoVatChatPhongBanJcb.setFont(new Font("Tahoma", Font.PLAIN, 14));
			itemJtf = (JTextField) tenCoSoVatChatPhongBanJcb.getEditor().getEditorComponent();
	    	GroupLayout gl_DangKyCoSoVatChatPanel = new GroupLayout(DangKyCoSoVatChatPanel);
	    	gl_DangKyCoSoVatChatPanel.setHorizontalGroup(
	    		gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
	    			.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
	    				.addContainerGap()
	    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
	    					.addComponent(soLuongJlb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	    					.addComponent(tenCoSoVatChatPhongBanJlb))
	    				.addGap(3)
	    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING, false)
	    					.addComponent(tenCoSoVatChatPhongBanJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    					.addComponent(soLuongJtf, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
	    				.addPreferredGap(ComponentPlacement.UNRELATED)
	    				.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
	    				.addContainerGap(20, Short.MAX_VALUE))
	    	);
	    	gl_DangKyCoSoVatChatPanel.setVerticalGroup(
	    		gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.LEADING)
	    			.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
	    				.addGap(112)
	    				.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.TRAILING)
	    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
	    						.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.BASELINE)
	    							.addComponent(tenCoSoVatChatPhongBanJlb)
	    							.addComponent(tenCoSoVatChatPhongBanJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    						.addPreferredGap(ComponentPlacement.UNRELATED)
	    						.addGroup(gl_DangKyCoSoVatChatPanel.createParallelGroup(Alignment.BASELINE, false)
	    							.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
	    								.addGap(6)
	    								.addComponent(soLuongJlb, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
	    							.addComponent(soLuongJtf, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
	    					.addGroup(gl_DangKyCoSoVatChatPanel.createSequentialGroup()
	    						.addGap(7)
	    						.addComponent(okButton, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
	    						.addGap(13)))
	    				.addGap(152))
	    	);
	    	DangKyCoSoVatChatPanel.setLayout(gl_DangKyCoSoVatChatPanel);
	    	pack();
	    }// </editor-fold>//GEN-END:initComponents
	    private void addCoSoVatChatPhongBanMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBtnActionPerformed
	    	if(validateValueInForm()) {
	    		if(checkCoSoVatChat) {
	    			CoSoVatChatModel coSoVatChat = new CoSoVatChatModel();
	    			coSoVatChat.setTenCoSoVatChat(tenCoSoVatChatPhongBanJcb.getSelectedItem()+"");
	    			coSoVatChat.setSoLuong(Integer.parseInt(soLuongJtf.getText()));
	    			listCoSoVatChatMuon.add(coSoVatChat);
	    		} 
	    		if(checkPhongBan) {
	    			PhongBanModel phongBan = new PhongBanModel();
	    			phongBan.setTenPhongBan((String) tenCoSoVatChatPhongBanJcb.getSelectedItem());
	    			listPhongBanMuon.add(phongBan);
	    		}
	    		setDataTable();
	    	}
	    }
	    // check cac gia tri duoc nhap vao form
	    private boolean validateValueInForm() {
	        // check null

	    	if(((String) tenCoSoVatChatPhongBanJcb.getSelectedItem()).compareTo("") == 0
	    			|| soLuongJtf.getText().trim().isEmpty()) {
	            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
	            return false;
	    	}
	    	for(int i = 0; i < listCoSoVatChatMuon.size(); ++i) {
	    		if(listCoSoVatChat.get(i).getTenCoSoVatChat().compareTo((String) tenCoSoVatChatPhongBanJcb.getSelectedItem()) == 0) {
		            JOptionPane.showMessageDialog(rootPane, "Bạn đã mượn" +  tenCoSoVatChatPhongBanJcb.getSelectedItem(), "Warning", JOptionPane.WARNING_MESSAGE);
		            return false;
	    		}
	    	}
	    	
	    	for(int i = 0; i < listPhongBanMuon.size(); ++i) {
	    		if(listPhongBanMuon.get(i).getTenPhongBan().compareTo((String) tenCoSoVatChatPhongBanJcb.getSelectedItem()) == 0) {
		            JOptionPane.showMessageDialog(rootPane, "Bạn đã mượn" +  tenCoSoVatChatPhongBanJcb.getSelectedItem(), "Warning", JOptionPane.WARNING_MESSAGE);
		            return false;
	    		}
	    	}
	    	
	    	for(int i = 0; i < listCoSoVatChat.size(); ++i) {
	    		if(listCoSoVatChat.get(i).getTenCoSoVatChat().compareTo((String) tenCoSoVatChatPhongBanJcb.getSelectedItem()) == 0) {
	    			checkCoSoVatChat = true;
	    			break;
	    		}
	    	}

	    	if(!checkCoSoVatChat) {
		    	for(int i = 0; i < listPhongBan.size(); ++i) {
		    		if(listPhongBan.get(i).getTenPhongBan().compareTo((String) tenCoSoVatChatPhongBanJcb.getSelectedItem()) == 0) {
		    			checkPhongBan = true;
		    			break;
		    		}
		    	}
	    	}
	    	
	    	if(!checkCoSoVatChat && !checkPhongBan) {
	            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng tên cơ sở vật chất cần mượn", "Warning", JOptionPane.WARNING_MESSAGE);
	    	}
	    	try {
	            Integer.parseInt(soLuongJtf.getText());
	    	} catch (NumberFormatException e) {
				// TODO: handle exception
	            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng định dạng số cho số lượng", "Warning", JOptionPane.WARNING_MESSAGE);
	            return false;
			}
	    	if(checkCoSoVatChat) {
	    		int soLuong=0;
				try {
					soLuong = coSoVatChatService.getSoLuongConLai((String) tenCoSoVatChatPhongBanJcb.getSelectedItem());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra", "Warning", JOptionPane.WARNING_MESSAGE);
		            return false;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra", "Warning", JOptionPane.WARNING_MESSAGE);
		            return false;
				}
	            JOptionPane.showMessageDialog(rootPane, "Số lượng " + tenCoSoVatChatPhongBanJcb.getSelectedItem() + "còn lại tối đa là: " + soLuong, "Warning", JOptionPane.WARNING_MESSAGE);
	            soLuongJtf.setText(Integer.toString(soLuong));
	            return false;
	    	}
	    	if(checkPhongBan && Integer.parseInt(soLuongJtf.getText()) > 1) {
	            JOptionPane.showMessageDialog(rootPane, "Số lượng phòng ban phải là 1", "Warning", JOptionPane.INFORMATION_MESSAGE);
	            soLuongJtf.setText("1");
	            return false;
	    	}
	        return true;
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
	    
	    public List<CoSoVatChatModel> getCoSoVatChatMuon() {
	    	return listCoSoVatChat;
	    }
	    
	    public List<PhongBanModel> getPhongBanMuon() {
	    	return listPhongBan;
	    }
	    
	    private JFrame parentJFrame;
	    private MuonTraBean muonTraBeann;
	    private JPanel jpnView;
	    private String[] COLUMNS = {"Cơ sở vật chất", "Số lượng"};
	    private ClassTableModel classTableModel = null;
	    private CoSoVatChatService coSoVatChatService;
	    private PhongBanService phongBanService;
	    private List<CoSoVatChatBean> listCoSoVatChatBeans;
	    private List<PhongBanBean> listPhongBanBeans;
	    private List<CoSoVatChatModel> listCoSoVatChat;
	    private List<PhongBanModel> listPhongBan;
	    private List<CoSoVatChatModel> listCoSoVatChatMuon;
	    private List<PhongBanModel> listPhongBanMuon;
	    private JPanel DangKyCoSoVatChatPanel;
	    private JTextField soLuongJtf;
	    private DefaultTableModel model;
	    private JTable table;
	    private DefaultComboBoxModel itemComboBoxModel;
	    private JComboBox tenCoSoVatChatPhongBanJcb;
	    private JTextField itemJtf;
	    private JButton okButton;
	    private boolean checkCoSoVatChat;
	    private boolean checkPhongBan;
}
