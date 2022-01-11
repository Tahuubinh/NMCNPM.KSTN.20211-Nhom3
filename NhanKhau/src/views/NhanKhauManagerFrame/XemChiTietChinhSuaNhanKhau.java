package views.NhanKhauManagerFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

import javax.sql.rowset.JoinRowSet;
import javax.swing.BoxLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;

import Bean.NhanKhauBean;
import controllers.NhanKhauManagerPanelController;
import controllers.NhanKhauManagerController.AddNewController;
import controllers.NhanKhauManagerController.ChinhSuaController;
import models.NhanKhauModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class XemChiTietChinhSuaNhanKhau extends JFrame {

	private JPanel contentPane;
	private JTextField hotenField;
	private JTextField tcctextField;
	//private JTextField ngaysinhtextField;
	private JTextField tongiaotextField;
	private JTextField lien_hetextField;
	private NhanKhauManagerPanelController parentController;
    private JFrame parentFrame;
    private NhanKhauBean nhanKhauBean;
    private ChinhSuaController controller;
    private NhanKhauModel nhanKhauModel;
    private com.toedter.calendar.JDateChooser ngaysinhtextField;
    private JRadioButton namRadioButton;
    private JRadioButton nuRadioButton;
	private JTable table;
	private int row;
	private JTextArea ghi_chutextArea;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ThemMoiNhanKhau frame = new ThemMoiNhanKhau();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
    public XemChiTietChinhSuaNhanKhau(NhanKhauManagerPanelController parentController, JFrame parentJFrame, NhanKhauModel nhanKhauModel, JTable table, int row) {
        this.parentController = parentController;
        this.parentFrame = parentJFrame;
        this.parentFrame.setEnabled(false);
        this.nhanKhauBean = new NhanKhauBean();
        this.nhanKhauModel = nhanKhauModel;
        this.table = table;
        this.row = row;
        initComponents();
        setTitle("Chỉnh sửa thông tin nhân khẩu");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        controller = new ChinhSuaController();
        
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
	 * Create the frame.
	 */
    private void initComponents() {
		setForeground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 428, 285);
		contentPane.add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		
		JLabel hotenLabel = new JLabel("Họ và tên:");
		
		JLabel tccLabel = new JLabel("Số CMND/TCC:");
		
		JLabel ngaysinhNewLabel = new JLabel("Ngày sinh:");
		
		hotenField = new JTextField();
		hotenField.setColumns(10);
		hotenField.setText(nhanKhauModel.getHoTen());
		
		tcctextField = new JTextField();
		tcctextField.setColumns(10);
		tcctextField.setText(nhanKhauModel.getTccString());
		
		ngaysinhtextField = new com.toedter.calendar.JDateChooser();
		if (nhanKhauModel.getNamSinh() != null) {
			ngaysinhtextField.setDate(nhanKhauModel.getNamSinh());
		}
		//ngaysinhtextField.setColumns(10);
		
		JLabel gioitinhLabel = new JLabel("Giới tính:");
		
		JPanel panel_1 = new JPanel();
		
		JLabel tongiaoLabel = new JLabel("Tôn giáo:");
		
		tongiaotextField = new JTextField();
		tongiaotextField.setColumns(10);
		tongiaotextField.setText(nhanKhauModel.getTonGiao());
		
		JLabel lien_heLabel = new JLabel("Liên hệ");
		
		lien_hetextField = new JTextField();
		lien_hetextField.setColumns(10);
		lien_hetextField.setText(nhanKhauModel.getLienheString());
		
		JLabel ghi_chuLabel = new JLabel("Ghi chú:");
		
		ghi_chutextArea = new JTextArea();
		ghi_chutextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		ghi_chutextArea.setLineWrap(true);
		ghi_chutextArea.setText(nhanKhauModel.getGhiChu());
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED, 428, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(tongiaoLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(tccLabel)
								.addComponent(ngaysinhNewLabel)
								.addComponent(hotenLabel)
								.addComponent(gioitinhLabel)
								.addComponent(lien_heLabel)
								.addComponent(ghi_chuLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addGap(95)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(ghi_chutextArea, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
								.addComponent(tongiaotextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(hotenField, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(ngaysinhtextField, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(tcctextField, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(lien_hetextField, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(hotenLabel)
							.addComponent(hotenField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(tccLabel)
						.addComponent(tcctextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(ngaysinhNewLabel)
						.addComponent(ngaysinhtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(gioitinhLabel)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(tongiaoLabel)
						.addComponent(tongiaotextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lien_heLabel)
						.addComponent(lien_hetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ghi_chuLabel)
						.addComponent(ghi_chutextArea, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(98, Short.MAX_VALUE))
		);
		panel_1.setLayout(null);
		
		namRadioButton = new JRadioButton("Nam");
		nuRadioButton = new JRadioButton("Nữ");
		if (nhanKhauModel.getGioiTinh().equals("Nam")) {
			namRadioButton.setSelected(true);
		} else if (nhanKhauModel.getGioiTinh().equals("Nữ")) {
			nuRadioButton.setSelected(true);
		}
		namRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (namRadioButton.isSelected()) {
					nuRadioButton.setSelected(false);
				}
			}
		});
		nuRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nuRadioButton.isSelected()) {
					namRadioButton.setSelected(false);
				}
			}
		});
		namRadioButton.setBounds(29, 0, 109, 23);
		panel_1.add(namRadioButton);
		
		nuRadioButton.setBounds(140, 0, 109, 23);
		panel_1.add(nuRadioButton);
		panel.setLayout(gl_panel);
		
		JButton hoanthanhButton = new JButton("Hoàn thành");
		hoanthanhButton.addMouseListener(new MouseAdapter() {
    		@Override
        	public void mouseEntered(MouseEvent e) {
                hoanthanhButton.setBackground(new Color(195, 66, 2));
        	}
    		@Override
        	public void mousePressed(MouseEvent e) {
            	hoanthanhButton.setBackground(new Color(212, 84, 21));
        	}
    		@Override
        	public void mouseReleased(MouseEvent e) {
                hoanthanhButton.setBackground(new Color(195, 66, 2));
        	}
    		@Override
        	public void mouseExited(MouseEvent e) {
            	hoanthanhButton.setBackground(new Color(212, 84, 21));
        	}
		});
		hoanthanhButton.setBorderPainted(false);
		hoanthanhButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		hoanthanhButton.setBackground(new Color(212,84,21));
		hoanthanhButton.setForeground(new Color(255,255,255));
		hoanthanhButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateBtnActionPerformed(e);
			}
		});
		hoanthanhButton.setBounds(467, 26, 114, 50);
		contentPane.add(hoanthanhButton);
	}
    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateBtnActionPerformed
        // tao moi 1 doi tuong nhan khau
    	int confirm = JOptionPane.showConfirmDialog(null, "Đã chắc chắn?", "Chỉnh sửa", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
	        NhanKhauModel temp = this.nhanKhauBean.getNhanKhauModel();
	        if (this.hotenField.getText().trim().equals("")) {
            	JOptionPane.showMessageDialog(null, "Cần nhập tên!");
            	return;
            }
	        temp.setHoTen(this.hotenField.getText());
            temp.setTccString(this.tcctextField.getText());
	        if (this.namRadioButton.isSelected()) {
	        	temp.setGioiTinh("Nam");
	        }
	        else if (this.nuRadioButton.isSelected()) {
	        	temp.setGioiTinh("Nữ");
	        } else {
	        	temp.setGioiTinh("");
	        }
	        temp.setNamSinh(ngaysinhtextField.getDate());
	        //System.err.println(temp.getNamSinh());
	        temp.setTonGiao(tongiaotextField.getText());
            temp.setLienheString(lien_hetextField.getText());
            temp.setGhiChu(ghi_chutextArea.getText());
	        try {
	        	int id = (int) table.getModel().getValueAt(table.getSelectedRow(),0);
	            if (this.controller.UpdatePeople(this.nhanKhauBean, id)) {
	                JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!!");
	                close();
	                parentController.refreshData();
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
	        }
		}
    }//GEN-LAST:event_CreateBtnActionPerformed
}























