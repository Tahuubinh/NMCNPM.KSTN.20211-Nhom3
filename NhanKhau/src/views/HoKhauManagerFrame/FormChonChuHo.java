package views.HoKhauManagerFrame;

import Bean.NhanKhauBean;
import controllers.HoKhauManagerController.ChoosePeopleController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Hai
 */
public class FormChonChuHo extends javax.swing.JFrame {

    private NhanKhauBean nhanKhauBean;
    private NhanKhauBean nhanKhauBeanTemp;
    private JFrame parentJFrame;
    //private final ChoosePeopleController controller;
    
    /**
     * Creates new form ChoosePeople
     * @param nhanKhauBean nhan khau duoc truyen vao tu frame cha
     * @param parentJframe frame cha de disable
     */
    public FormChonChuHo(NhanKhauBean nhanKhauBean, JFrame parentJframe) {
    	setTitle("Chọn chủ hộ");
        initComponents();
        this.nhanKhauBean = nhanKhauBean;
        this.parentJFrame = parentJframe;
        this.nhanKhauBeanTemp = new NhanKhauBean();
        parentJframe.setEnabled(false);
        //controller = new ChoosePeopleController(this.nhanKhauBeanTemp, searchJtf, selectedJtf, tableJpn);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                parentJframe.setEnabled(true);
                Close();
            }
            
        });
    }
    
    public void Close() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            this.parentJFrame.setEnabled(true);
            dispose();
        }
    }

    public NhanKhauBean getNhanKhauBean() {
        return nhanKhauBean;
    }

    public void setNhanKhauBean(NhanKhauBean nhanKhauBean) {
        this.nhanKhauBean = nhanKhauBean;
    }

    public JFrame getParentJFrame() {
        return parentJFrame;
    }

    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tableJpn = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tableJpnLayout = new javax.swing.GroupLayout(tableJpn);
        tableJpn.setLayout(tableJpnLayout);
        tableJpnLayout.setHorizontalGroup(
            tableJpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tableJpnLayout.setVerticalGroup(
            tableJpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );
        
        hoanthanhButton = new JButton("Hoàn thành");
        hoanthanhButton.setForeground(Color.WHITE);
        hoanthanhButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        hoanthanhButton.setBorderPainted(false);
        hoanthanhButton.setBackground(new Color(212, 84, 21));
        
        ho_tenLable = new JLabel("Họ tên:");
        ho_tenLable.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        ho_tentextField = new JTextField();
        ho_tentextField.setFont(new Font("Arial", Font.PLAIN, 14));
        
        locButton = new JButton("Lọc");
        locButton.setForeground(Color.WHITE);
        locButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        locButton.setBorderPainted(false);
        locButton.setBackground(new Color(0, 160, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(ho_tenLable, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(ho_tentextField))
        				.addComponent(tableJpn, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(hoanthanhButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(30)
        					.addComponent(locButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(12)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(ho_tenLable, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(ho_tentextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        					.addComponent(locButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
        			.addGap(31)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(hoanthanhButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        				.addComponent(tableJpn, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel tableJpn;
    private JButton hoanthanhButton;
    private JLabel ho_tenLable;
    private JTextField ho_tentextField;
    private JButton locButton;
    // End of variables declaration//GEN-END:variables
}
