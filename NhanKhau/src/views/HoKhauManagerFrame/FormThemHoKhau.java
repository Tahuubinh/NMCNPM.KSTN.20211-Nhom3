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
import controllers.LoginController;
import controllers.NhanKhauManagerPanelController;
import controllers.HoKhauManagerController.ThemMoiController;
import controllers.NhanKhauManagerController.AddNewController;
import models.ChungMinhThuModel;
import models.NhanKhauModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

public class FormThemHoKhau extends JFrame {

	private JPanel contentPane;
	private JTextField hotenField;
	private NhanKhauBean chuHo = new NhanKhauBean();
	private JTextField maHKtextField;
	private HoKhauPanelController parentController;
    private JFrame parentJFrame;
    private NhanKhauBean nhanKhauBean;
    private ThemMoiController controller;
    private JTextField dia_chitextField;
    private JTextField id_chuho;
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
    public FormThemHoKhau(HoKhauPanelController parentController, JFrame parentJFrame) {
		setTitle("Thêm hộ khẩu");
        initComponents();
        this.parentJFrame = parentJFrame;
        this.parentController = parentController;
        this.controller = new ThemMoiController();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        parentJFrame.setEnabled(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                parentJFrame.setEnabled(true);
                close();
            }
            
        });
        setDataChuHo();
        //setDataThanhVien();
    }
    
    private void close() {
        this.parentJFrame.setEnabled(true);
        dispose();
        
    }
    
    public void setDataChuHo() {
        this.hotenField.setText(this.chuHo.getNhanKhauModel().getHoTen());
    }

//    public void setDataThanhVien() {
//        this.controller.setData(this.list, this.memTableJpn);
//    }

	/**
	 * Create the frame.
	 */
    private void initComponents() {
		setForeground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 158);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 428, 108);
		contentPane.add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		
		JLabel hotenLabel = new JLabel("Chủ hộ:");
		
		JLabel maHKLabel = new JLabel("Mã hộ khẩu:");
		
		JLabel dia_chiLabel = new JLabel("Địa chỉ:");
		
		hotenField = new JTextField();
		hotenField.setColumns(10);
		
		maHKtextField = new JTextField();
		maHKtextField.setColumns(10);
		
		id_chuho = new JTextField();
		dia_chitextField = new JTextField();
		dia_chitextField.setColumns(10);
		
		JButton selectBtn = new JButton();
		selectBtn.setText("Chọn...");
		selectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectBtnActionPerformed(evt);
            }
        });
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(maHKLabel)
								.addComponent(dia_chiLabel)
								.addComponent(hotenLabel))))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(selectBtn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(dia_chitextField, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
						.addComponent(hotenField, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
						.addComponent(maHKtextField, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(17)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(hotenLabel)
									.addComponent(hotenField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(maHKLabel)
								.addComponent(maHKtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(dia_chiLabel)
								.addComponent(dia_chitextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(selectBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JButton hoanthanhButton = new JButton("Hoàn thành");
		hoanthanhButton.setBorderPainted(false);
		hoanthanhButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		hoanthanhButton.setBackground(new Color(212,84,21));
		hoanthanhButton.setForeground(new Color(255,255,255));
		hoanthanhButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateBtnActionPerformed(e);
			}
		});
		hoanthanhButton.setBounds(467, 26, 114, 50);
		contentPane.add(hoanthanhButton);
	}
    
    private void selectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBtnActionPerformed
    	FormChonChuHo choosePeople = new FormChonChuHo(this.chuHo, this, this.hotenField, this.id_chuho);
        choosePeople.setLocationRelativeTo(null);
        choosePeople.setResizable(false);
        choosePeople.setVisible(true);
    }//GEN-LAST:event_selectBtnActionPerformed
    private void CreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateBtnActionPerformed
    	if (this.id_chuho.getText().equals("")) {
    		JOptionPane.showMessageDialog(null, "Hãy chọn một người làm chủ hộ trước",
  			      "Lỗi thiếu thông tin!", JOptionPane.ERROR_MESSAGE);;
    		return;
    	}
    	if (this.maHKtextField.getText().equals("")) {
    		JOptionPane.showMessageDialog(null, "Hãy nhập mã hộ khẩu trước",
  			      "Lỗi thiếu thông tin!", JOptionPane.ERROR_MESSAGE);;
    		return;
    	}
    	if (this.dia_chitextField.getText().equals("")) {
    		JOptionPane.showMessageDialog(null, "Hãy nhập địa chỉ trước",
  			      "Lỗi thiếu thông tin!", JOptionPane.ERROR_MESSAGE);;
    		return;
    	}
    	int tempid = Integer.parseInt(this.id_chuho.getText());
    	String maHKString = this.maHKtextField.getText();
    	String dia_chiString = this.dia_chitextField.getText();
    	HoKhauBean hoKhauBean = new HoKhauBean();
    	hoKhauBean.getChuHo().setID(tempid);
    	hoKhauBean.getHoKhauModel().setMaHoKhau(maHKString);
    	hoKhauBean.getHoKhauModel().setDiaChi(dia_chiString);
    	try {
            this.controller.addNew(hoKhauBean);
            JOptionPane.showMessageDialog(null, "Thêm thành công!!");
            parentController.refreshData();
            close();
            //parentJFrame.setEnabled(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    	
    }//GEN-LAST:event_CreateBtnActionPerformed
}






























