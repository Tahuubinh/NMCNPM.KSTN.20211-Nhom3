package views.NhanKhauManagerFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

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

import controllers.NhanKhauManagerPanelController;
import controllers.ThongKePanelController;
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
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class XoaThongKe extends JFrame {

	private JPanel contentPane;
	private com.toedter.calendar.JDateChooser ngaytextField;
    private JFrame parentJFrame = null;
    private JTable table;
    private ThongKePanelController parentController;
    private int row;
    private JComboBox lydocomboBox;
    private JTextField soGiaytextField;
    
    public XoaThongKe(ThongKePanelController parentController, JFrame parentJFrame, JTable table, int row) {
        this.parentController = parentController;
        this.parentJFrame = parentJFrame;
        this.table = table;
        this.row = row;
        initComponents();
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
		setBounds(100, 100, 617, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 428, 99);
		contentPane.add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		
		JLabel lydoLabel = new JLabel("L?? do x??a:");
		
		JLabel ngayLabel = new JLabel("Ng??y:");
		
		ngaytextField = new JDateChooser();
		
		lydocomboBox = new JComboBox();
		lydocomboBox.setModel(new DefaultComboBoxModel(new String[] {"Chuy???n ??i n??i kh??c", "Khai t???"}));
		
		JLabel soGiayLabel = new JLabel("S??? gi???y:");
		
		soGiaytextField = new JTextField();
		soGiaytextField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(ngayLabel)
								.addComponent(lydoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(lblNewLabel_3)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(soGiayLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(95)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(ngaytextField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addComponent(lydocomboBox, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
						.addComponent(soGiaytextField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_3)
							.addComponent(lydoLabel))
						.addComponent(lydocomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(ngayLabel)
						.addComponent(ngaytextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(soGiaytextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(soGiayLabel))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JButton hoanthanhButton = new JButton("Ho??n th??nh");
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
				hoanThanhActionPerform(e);
			}
		});
		hoanthanhButton.setBounds(467, 26, 114, 50);
		contentPane.add(hoanthanhButton);
	}
    
    public void hoanThanhActionPerform(java.awt.event.ActionEvent evt) {
    	int confirm = JOptionPane.showConfirmDialog(null, "???? ch???c ch???n?", "X??a", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			XoaNhanKhauController controller = new XoaNhanKhauController();
			try {
				int id = 0;
				//System.err.println(table.getSelectedRow());
				id = (int) this.table.getModel().getValueAt(table.getSelectedRow(),0);
				System.err.println((int) this.table.getModel().getValueAt(table.getSelectedRow(),0));
				String lydoString = (String)this.lydocomboBox.getSelectedItem();
				java.sql.Date ngayMatDate = new java.sql.Date(ngaytextField.getDate().getTime());
				String soGiayString = (String)this.soGiaytextField.getText();
                if (controller.XoaNhanKhau(id, lydoString, ngayMatDate, soGiayString)) {
                	close();
                    parentController.setData();
                }
            } catch (Exception err) {
                System.out.println(err.getMessage());
                JOptionPane.showMessageDialog(null, "C?? l???i x???y ra. Vui long ki???m tra l???i!!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
		}
    }
}










