package views.HoKhauManagerFrame;

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
import javax.swing.BoxLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;

import Bean.HoKhauBean;
import Bean.NhanKhauBean;
import controllers.HoKhauPanelController;
import controllers.NhanKhauManagerPanelController;
import controllers.HoKhauManagerController.QuanLyThanhVienController;
import controllers.NhanKhauManagerController.XoaNhanKhauController;
import services.HoKhauService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class FormTachHoKhau extends JFrame {

	private JPanel contentPane;
    private JFrame parentJFrame = null;
    private JTable parenTable;
    private HoKhauPanelController parentController;
    private QuanLyThanhVienController quan_lycontroller;
    private int row;
    private JTextField chu_ho_textField;
    private JTextField maHK_textField;
    private JTextField dia_chi_textField;
    private JPanel thanh_vien_tablepanel;
    private int id_ho_khau;
    
    public FormTachHoKhau(HoKhauPanelController parentController, JFrame parentJFrame, JTable parenTable) {
    	this.parentController = parentController;
        this.parenTable = parenTable;
        initComponents();
        //this.parentController = parentController;
        this.parentJFrame = parentJFrame;
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        parentJFrame.setEnabled(false);
        this.id_ho_khau = (int)this.parenTable.getModel().getValueAt(parenTable.getSelectedRow(),3);
        quan_lycontroller = new QuanLyThanhVienController(this.thanh_vien_tablepanel, this.id_ho_khau);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	closeWithoutChange();
            }
            
        });
    }
    
    void close() {
        this.parentJFrame.setEnabled(false);
        dispose();
    }
    
    void closeWithoutChange() {
    	this.parentJFrame.setEnabled(true);
        dispose();
    }

	/**
	 * Create the frame.
	 */
    private void initComponents() {
		setForeground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 26, 428, 412);
		contentPane.add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		
		JLabel chu_ho_cuLabel = new JLabel("Chủ hộ:");
		
		JLabel thanh_vien_cuLabel = new JLabel("Chọn chủ hộ mới từ các thành viên:");
		
		chu_ho_textField = new JTextField();
		chu_ho_textField.setEditable(false);
		chu_ho_textField.setColumns(10);
		String ten_chu_hoString = (String)this.parenTable.getModel().getValueAt(parenTable.getSelectedRow(),0);
		chu_ho_textField.setText(ten_chu_hoString);
		
		thanh_vien_tablepanel = new JPanel();
        javax.swing.GroupLayout gl_thanh_vien_tablepanel = new javax.swing.GroupLayout(thanh_vien_tablepanel);
        thanh_vien_tablepanel.setLayout(gl_thanh_vien_tablepanel);
        gl_thanh_vien_tablepanel.setHorizontalGroup(
        		gl_thanh_vien_tablepanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        gl_thanh_vien_tablepanel.setVerticalGroup(
        		gl_thanh_vien_tablepanel.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );
		
		JLabel maHKLabel = new JLabel("Mã hộ khẩu:");
		
		JLabel dia_chiLabel = new JLabel("Địa chỉ:");
		
		maHK_textField = new JTextField();
		maHK_textField.setColumns(10);
		
		dia_chi_textField = new JTextField();
		dia_chi_textField.setColumns(10);
		dia_chi_textField.setText((String)this.parenTable.getModel().getValueAt(parenTable.getSelectedRow(),2));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(chu_ho_cuLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
							.addComponent(chu_ho_textField, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED, 428, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(thanh_vien_cuLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(maHKLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
							.addComponent(maHK_textField, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(dia_chiLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
							.addComponent(dia_chi_textField, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(thanh_vien_tablepanel, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(chu_ho_cuLabel)
							.addComponent(chu_ho_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(thanh_vien_cuLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(thanh_vien_tablepanel, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(maHKLabel)
						.addComponent(maHK_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(dia_chiLabel)
						.addComponent(dia_chi_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		thanh_vien_tablepanel.setLayout(null);
		panel.setLayout(gl_panel);
		
		JButton hoanthanhButton = new JButton("Hoàn thành");
		hoanthanhButton.setBorderPainted(false);
		hoanthanhButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		hoanthanhButton.setBackground(new Color(212,84,21));
		hoanthanhButton.setForeground(new Color(255,255,255));
		hoanthanhButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tachHoKhauBtnActionPerformed(e);
			}
		});
		hoanthanhButton.setBounds(467, 26, 114, 50);
		contentPane.add(hoanthanhButton);
		
		JLabel HKCuLabel = new JLabel("Hộ khẩu cũ:");
		HKCuLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		HKCuLabel.setBounds(10, 0, 123, 25);
		contentPane.add(HKCuLabel);
	}
    private void tachHoKhauBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateBtnActionPerformed
    	JTable tempJTable = quan_lycontroller.getNhankhauTable();
    	int row = tempJTable.getSelectedRow();
    	if (row == -1) {
    		JOptionPane.showMessageDialog(null, "Hãy lựa chọn một hàng trước",
    			      "Lỗi không chọn hàng!", JOptionPane.ERROR_MESSAGE);
    		return;
    	}
    	if (this.maHK_textField.getText().equals("")) {
    		JOptionPane.showMessageDialog(null, "Hãy nhập mã hộ khẩu trước",
  			      "Lỗi thiếu thông tin!", JOptionPane.ERROR_MESSAGE);;
    		return;
    	}
    	if (this.dia_chi_textField.getText().equals("")) {
    		JOptionPane.showMessageDialog(null, "Hãy nhập địa chỉ trước",
  			      "Lỗi thiếu thông tin!", JOptionPane.ERROR_MESSAGE);;
    		return;
    	}
    	int id_nhan_khau = (int)tempJTable.getModel().getValueAt(tempJTable.getSelectedRow(),0);
    	id_ho_khau = (int)this.parenTable.getModel().getValueAt(parenTable.getSelectedRow(),3);
    	String maHKString = this.maHK_textField.getText();
    	String dia_chiString = this.dia_chi_textField.getText();
    	HoKhauBean hoKhauBean = new HoKhauBean();
    	hoKhauBean.getChuHo().setID(id_nhan_khau);
    	hoKhauBean.getHoKhauModel().setMaHoKhau(maHKString);
    	hoKhauBean.getHoKhauModel().setDiaChi(dia_chiString);
        try {
			new HoKhauService().subThanhVien(id_nhan_khau, id_ho_khau);
			int id_ho_khau_moi = new HoKhauService().addHoKhau(hoKhauBean);
			JOptionPane.showMessageDialog(null, "Tách hộ khẩu thành công!!");
	        parentController.refreshData();
	        quan_lycontroller.refreshData();
	        FormTachNhanKhau tachNhanKhau = new FormTachNhanKhau(this.parentController, this.parentJFrame, this.parenTable, id_ho_khau_moi);
	        tachNhanKhau.setLocationRelativeTo(null);
	        tachNhanKhau.setResizable(false);
	        tachNhanKhau.setVisible(true);
	        close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }//GEN-LAST:event_CreateBtnActionPerformed 
}









