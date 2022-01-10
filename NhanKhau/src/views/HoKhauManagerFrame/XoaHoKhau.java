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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

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

public class XoaHoKhau extends JFrame {

	private JPanel contentPane;
	private JTextField ngaytextField;
    private JFrame parentJFrame = null;
    private JTable table;
    private NhanKhauManagerPanelController parentController;
    private int row;
    
    public XoaHoKhau(JFrame parentJFrame, JTable table, int row) {
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
		setBounds(100, 100, 617, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 428, 140);
		contentPane.add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		
		JLabel lydoLabel = new JLabel("Lý do xóa:");
		
		JLabel ngayLabel = new JLabel("Ngày:");
		
		ngaytextField = new JTextField();
		ngaytextField.setColumns(10);
		
		JTextArea ly_dotextArea = new JTextArea();
		ly_dotextArea.setLineWrap(true);
		ly_dotextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(ngayLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lydoLabel))
						.addComponent(lblNewLabel_3))
					.addGap(73)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(ly_dotextArea, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
						.addComponent(ngaytextField, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lydoLabel)
							.addComponent(ly_dotextArea, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(ngayLabel)
						.addComponent(ngaytextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28))
		);
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
	}
}

