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

import Bean.NhanKhauBean;
import controllers.NhanKhauManagerPanelController;
import controllers.NhanKhauManagerController.XoaNhanKhauController;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class FormTachHoKhau extends JFrame {

	private JPanel contentPane;
    private JFrame parentJFrame = null;
    private JTable table;
    private NhanKhauManagerPanelController parentController;
    private int row;
    private JTextField textField;
    private JTextField textField_1;
    
    public FormTachHoKhau(JFrame parentJFrame, JTable table, int row) {
        initComponents();
        //this.parentController = parentController;
        this.parentJFrame = parentJFrame;
        this.table = table;
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        parentJFrame.setEnabled(false);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
            
        });
    }
    
    void close() {
        this.parentJFrame.setEnabled(true);
        dispose();
    }

	/**
	 * Create the frame.
	 */
    private void initComponents() {
		setForeground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 26, 428, 177);
		contentPane.add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		
		JLabel chu_ho_cuLabel = new JLabel("Chủ hộ:");
		
		JLabel thanh_vien_cuLabel = new JLabel("Thành viên:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(chu_ho_cuLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(thanh_vien_cuLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)))
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
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(thanh_vien_cuLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(null);
		panel.setLayout(gl_panel);
		
		JButton hoanthanhButton = new JButton("Hoàn thành");
		hoanthanhButton.setBorderPainted(false);
		hoanthanhButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		hoanthanhButton.setBackground(new Color(212,84,21));
		hoanthanhButton.setForeground(new Color(255,255,255));
		hoanthanhButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Đã chắc chắn?");
				if (confirm == JOptionPane.YES_OPTION) {
					XoaNhanKhauController controller = new XoaNhanKhauController();
					try {
						int id;
						//System.err.println(table.getModel().getValueAt(table.getSelectedRow(),0));
						id = (int) table.getModel().getValueAt(table.getSelectedRow(),0);
		                if (controller.XoaNhanKhau(id)) {
		                	close();
		                    parentController.refreshData();
		                }
		            } catch (Exception err) {
		                System.out.println(err.getMessage());
		                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
		            }
				}
			}
		});
		hoanthanhButton.setBounds(467, 26, 114, 50);
		contentPane.add(hoanthanhButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 226, 428, 182);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel chu_ho_moiLabel = new JLabel("Chủ hộ:");
		chu_ho_moiLabel.setBounds(10, 24, 38, 14);
		panel_1.add(chu_ho_moiLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(143, 21, 285, 20);
		panel_1.add(textField_1);
		
		JLabel thanh_vien_moiLabel_1 = new JLabel("Thành viên:");
		thanh_vien_moiLabel_1.setBounds(10, 49, 57, 14);
		panel_1.add(thanh_vien_moiLabel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(10, 69, 418, 107);
		panel_1.add(panel_2_1);
		
		JButton select_chu_hoBtn = new JButton();
		select_chu_hoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectChuHoBtnActionPerformed(e);
			}
		});
		select_chu_hoBtn.setText("Chọn...");
		select_chu_hoBtn.setBounds(58, 21, 69, 20);
		panel_1.add(select_chu_hoBtn);
		
		JButton select_thanh_vienBtn = new JButton();
		select_thanh_vienBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectThanhVienBtnActionPerformed(e);
			}
		});
		select_thanh_vienBtn.setText("Chọn...");
		select_thanh_vienBtn.setBounds(77, 45, 69, 20);
		panel_1.add(select_thanh_vienBtn);
		
		JLabel HKCuLabel = new JLabel("Hộ khẩu cũ:");
		HKCuLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		HKCuLabel.setBounds(10, 0, 123, 25);
		contentPane.add(HKCuLabel);
		
		JLabel lblHKhuMi = new JLabel("Hộ khẩu mới:");
		lblHKhuMi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHKhuMi.setBounds(10, 203, 103, 25);
		contentPane.add(lblHKhuMi);
	}
    
    private void selectChuHoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBtnActionPerformed
    	FormChonChuHoMoi choosePeople = new FormChonChuHoMoi(new NhanKhauBean(), this);
        choosePeople.setLocationRelativeTo(null);
        choosePeople.setResizable(false);
        choosePeople.setVisible(true);
    }//GEN-LAST:event_selectBtnActionPerformed
    private void selectThanhVienBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBtnActionPerformed
    	FormChonThanhVienMoi choosePeople = new FormChonThanhVienMoi(new NhanKhauBean(), this);
        choosePeople.setLocationRelativeTo(null);
        choosePeople.setResizable(false);
        choosePeople.setVisible(true);
    }//GEN-LAST:event_selectBtnActionPerformed
}

