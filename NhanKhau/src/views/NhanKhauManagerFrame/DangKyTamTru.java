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
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Bean.NhanKhauBean;
import controllers.LoginController;
import controllers.NhanKhauManagerPanelController;
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
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

public class DangKyTamTru extends JFrame {

	private JPanel contentPane;
	private JTextField hotenField;
	private JTextField tcctextField;
	//private JTextField ngaysinhtextField;
	private JTextField tongiaotextField;
	private JTextField textField;
	JRadioButton namRadioButton;
	JRadioButton nuRadioButton;
	private NhanKhauManagerPanelController parentController;
    private JFrame parentFrame;
    private NhanKhauBean nhanKhauBean;
    private AddNewController controller;
    private com.toedter.calendar.JDateChooser ngaysinhtextField;
    private JTextField textField_1;
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
    public DangKyTamTru(NhanKhauManagerPanelController parentController, JFrame parentJFrame) {
        this.parentController = parentController;
        this.parentFrame = parentJFrame;
        this.parentFrame.setEnabled(false);
        this.nhanKhauBean = new NhanKhauBean();
        initComponents();
        setTitle("Đăng ký tạm trú");
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
	 * Create the frame.
	 */
    private void initComponents() {
		setForeground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 428, 268);
		contentPane.add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		
		JLabel hotenLabel = new JLabel("Họ và tên:");
		
		JLabel tccLabel = new JLabel("Số CMND/TCC:");
		
		JLabel ngaysinhNewLabel = new JLabel("Ngày sinh:");
		
		hotenField = new JTextField();
		hotenField.setColumns(10);
		
		tcctextField = new JTextField();
		tcctextField.setColumns(10);
		
		ngaysinhtextField = new com.toedter.calendar.JDateChooser();
		//ngaysinhtextField.setColumns(10);
		
		JLabel gioitinhLabel = new JLabel("Giới tính:");
		
		JPanel panel_1 = new JPanel();
		
		JLabel tongiaoLabel = new JLabel("Tôn giáo:");
		
		tongiaotextField = new JTextField();
		tongiaotextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Liên hệ");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel dia_chiLabel = new JLabel("Địa chỉ tạm vắng:");
		
		JLabel bat_dauLabel = new JLabel("Ngày bắt đầu:");
		
		JLabel ket_thucLabel = new JLabel("Ngày kết thúc:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JDateChooser bat_dautextField = new JDateChooser();
		
		JDateChooser bat_dautextField_1 = new JDateChooser();
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
								.addComponent(lblNewLabel)
								.addComponent(bat_dauLabel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(ket_thucLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(dia_chiLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
							.addGap(72)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(tongiaotextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(hotenField, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(ngaysinhtextField, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(tcctextField, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(bat_dautextField, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(bat_dautextField_1, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))))
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
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(dia_chiLabel)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(bat_dauLabel)
						.addComponent(bat_dautextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(ket_thucLabel)
						.addComponent(bat_dautextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		panel_1.setLayout(null);
		
		namRadioButton = new JRadioButton("Nam");
		nuRadioButton = new JRadioButton("Nữ");
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
    private void CreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateBtnActionPerformed
            // tao moi 1 doi tuong nhan khau
            
    }//GEN-LAST:event_CreateBtnActionPerformed
}





























