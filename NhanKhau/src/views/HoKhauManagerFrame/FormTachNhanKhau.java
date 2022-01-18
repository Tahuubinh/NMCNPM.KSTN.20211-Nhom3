package views.HoKhauManagerFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import controllers.HoKhauPanelController;
import controllers.HoKhauManagerController.QuanLyThanhVienController;
import services.HoKhauService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormTachNhanKhau extends JFrame {

	private JPanel contentPane;
	private HoKhauPanelController parentController;
	private JFrame parentJFrame;
	private JTable parenTable;
	private int id_ho_khau;
	private int id_ho_khau_moi;
	private QuanLyThanhVienController quan_lycontroller;
	private JPanel thanh_vien_tablepanel;
	
	public FormTachNhanKhau(HoKhauPanelController parentController, JFrame parentJFrame, JTable parenTable, int id_ho_khau_moi) {
    	this.parentController = parentController;
        this.parenTable = parenTable;
        //this.parentController = parentController;
        this.parentJFrame = parentJFrame;
        this.id_ho_khau_moi = id_ho_khau_moi;
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        parentJFrame.setEnabled(false);
        this.id_ho_khau = (int)this.parenTable.getModel().getValueAt(parenTable.getSelectedRow(),3);
        quan_lycontroller = new QuanLyThanhVienController(this.thanh_vien_tablepanel, this.id_ho_khau);
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
	
	private void initComponents(){
		setTitle("Tách nhân khẩu sang hộ mới");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		thanh_vien_tablepanel = new JPanel();
		thanh_vien_tablepanel.setBounds(10, 41, 356, 307);
		contentPane.add(thanh_vien_tablepanel);
		
		JButton hoanthanhButton = new JButton("Hoàn thành");
		hoanthanhButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tachNhanKhauBtnActionPerformed(e);
			}
		});
		hoanthanhButton.setForeground(Color.WHITE);
		hoanthanhButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		hoanthanhButton.setBorderPainted(false);
		hoanthanhButton.setBackground(new Color(212, 84, 21));
		hoanthanhButton.setBounds(376, 11, 114, 50);
		contentPane.add(hoanthanhButton);
		
		JLabel lblNewLabel = new JLabel("Chọn nhân khẩu cho hộ mới tách:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 243, 22);
		contentPane.add(lblNewLabel);
		
		JTextArea ghi_chutextArea = new JTextArea();
		ghi_chutextArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		ghi_chutextArea.setForeground(new Color(212, 84, 21));
		ghi_chutextArea.setWrapStyleWord(true);
		ghi_chutextArea.setText("Nhấn Ctrl + chuột trái để chọn nhiều hàng cùng lúc");
		ghi_chutextArea.setLineWrap(true);
		ghi_chutextArea.setBounds(376, 292, 123, 56);
		contentPane.add(ghi_chutextArea);
	}
	
	private void tachNhanKhauBtnActionPerformed(java.awt.event.ActionEvent evt) {
		JTable tempJTable = quan_lycontroller.getNhankhauTable();
		int[] selections = tempJTable.getSelectedRows();
		if (selections.length == 0) {
			JOptionPane.showMessageDialog(null, "Hãy lựa chọn một hàng trước",
    			      "Lỗi không chọn hàng!", JOptionPane.ERROR_MESSAGE);
    		return;
		}
		int id_ho_khau = (int)this.parenTable.getModel().getValueAt(parenTable.getSelectedRow(),3);
		for (int row: selections) {
			int id_nhan_khau = (int)tempJTable.getModel().getValueAt(row, 0);
			try {
				new HoKhauService().addThanhVien(id_nhan_khau, this.id_ho_khau_moi);
				new HoKhauService().subThanhVien(id_nhan_khau, id_ho_khau);
				parentController.refreshData();
		        quan_lycontroller.refreshData();
		        close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "Thêm thành công!!");
	}
}
















