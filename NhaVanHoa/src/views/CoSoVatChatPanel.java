package views;

import controllers.CoSoVatChatPanelController;
import controllers.MuonTraPanelController;
import services.StringService;

import javax.swing.JFrame;

import views.CoSoVatChatFrame.ThemCoSoVatChatFrame;
import views.CoSoVatChatFrame.ThemSoLuongCoSoVatChatFrame;
import views.CoSoVatChatFrame.XemChiTietCoSoVatChatFrame;
import views.CoSoVatChatFrame.XoaCoSoVatChatFrame;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Hai
 */
public class CoSoVatChatPanel extends javax.swing.JPanel {

    /**
     * Creates new form NhanKhauManagePanel
     */
    private CoSoVatChatPanelController controller = null;
    private JFrame parentJFrame;
    
    public CoSoVatChatPanel(JFrame parentFrame) {
        this.parentJFrame = parentFrame;
        initComponents();
        controller = new CoSoVatChatPanelController(tablePanel, searchJtf, popupMenu);
        GroupLayout gl_tablePanel = new GroupLayout(tablePanel);
        gl_tablePanel.setHorizontalGroup(
        	gl_tablePanel.createParallelGroup(Alignment.TRAILING)
        		.addGap(0, 626, Short.MAX_VALUE)
        );
        gl_tablePanel.setVerticalGroup(
        	gl_tablePanel.createParallelGroup(Alignment.TRAILING)
        		.addGap(0, 211, Short.MAX_VALUE)
        );
        tablePanel.setLayout(gl_tablePanel);
        controller.setParentJFrame(parentJFrame);
        controller.setDataTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        tablePanel = new javax.swing.JPanel();
        
        popupMenu = new JPopupMenu();
        addPopup(tablePanel, popupMenu);
        
        xemChiTietCoSoVatChat = new JMenuItem("Xem chi tiết");
        popupMenu.add(xemChiTietCoSoVatChat);
        xemChiTietCoSoVatChat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				xemChiTietCoSoVatChatActionPerformed(evt);
			}
		});
        
        themSoLuong = new JMenuItem("Thêm số lượng");
        popupMenu.add(themSoLuong);
        themSoLuong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				themSoLuongActionPerformed(evt);
			}


		});
        xoaCoSoVatChat = new JMenuItem("Xóa cơ sở vật chất");
        popupMenu.add(xoaCoSoVatChat);
        xoaCoSoVatChat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				xoaCoSoVatChatActionPerformed(evt);
			}

		});
        addNewBtn = new javax.swing.JButton();
        addNewBtn.setDisabledIcon(new ImageIcon(CoSoVatChatPanel.class.getResource("/Icons/add.png")));
        addNewBtn.setBorder(null);
        addNewBtn.setIcon(new ImageIcon(CoSoVatChatPanel.class.getResource("/Icons/add.png")));

        setBackground(new java.awt.Color(255, 255, 255));

        addNewBtn.setBackground(new java.awt.Color(255, 255, 255));
        addNewBtn.setFont(new Font("Arial", Font.BOLD, 10));
        addNewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewBtnActionPerformed(evt);
            }
        });
        
        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(UIManager.getBorder("TextField.border"));
        searchPanel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchPanel.setBackground(Color.WHITE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(tablePanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(searchPanel, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
        					.addComponent(addNewBtn, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(51)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(addNewBtn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        					.addGap(27))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(searchPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(23)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        searchJtf = new JTextField();
        searchJtf.setBorder(null);
        searchJtf.setColumns(10);
        
        JButton searchJbutton = new JButton("");
        searchJbutton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		jtfSearchActionPerformed(evt);
        	}
        });
        searchJbutton.setBorder(null);
        searchJbutton.setIcon(new ImageIcon(CoSoVatChatPanel.class.getResource("/Icons/search.png")));
        searchJbutton.setBackground(Color.WHITE);
        GroupLayout gl_searchPanel = new GroupLayout(searchPanel);
        gl_searchPanel.setHorizontalGroup(
        	gl_searchPanel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_searchPanel.createSequentialGroup()
        			.addComponent(searchJtf, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
        			.addGap(48)
        			.addComponent(searchJbutton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
        );
        gl_searchPanel.setVerticalGroup(
        	gl_searchPanel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_searchPanel.createParallelGroup(Alignment.BASELINE)
        			.addComponent(searchJtf, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        			.addComponent(searchJbutton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
        );
        searchPanel.setLayout(gl_searchPanel);
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

    
    private void addNewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBtnActionPerformed
    	ThemCoSoVatChatFrame ThemCoSoVatChatFrame = new ThemCoSoVatChatFrame(this.controller, this.parentJFrame);
    	ThemCoSoVatChatFrame.setLocationRelativeTo(null);
    	ThemCoSoVatChatFrame.setResizable(false);
    	ThemCoSoVatChatFrame.setVisible(true);
    }//GEN-LAST:event_addNewBtnActionPerformed

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
    	String tenCoSoVatChat = StringService.covertToString(searchJtf.getText());
    	controller.setData(tenCoSoVatChat);
    }//GEN-LAST:event_jtfSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	private void xemChiTietCoSoVatChatActionPerformed(ActionEvent evt) {
		JTable xemChiTietTable = this.controller.getTable();
		int row = xemChiTietTable.getSelectedRow();
		if(row == -1) {
    		JOptionPane.showMessageDialog(null, "Hãy lựa chọn một hàng trước",
  			      "Lỗi không chọn hàng!", JOptionPane.ERROR_MESSAGE);
  		return;
		}
		
		String tenCoSoVatChatDetail = xemChiTietTable.getModel().getValueAt(row, 1).toString();
//		System.out.println(tenCoSoVatChatDetail);
		String tongSoLuong = xemChiTietTable.getModel().getValueAt(row, 2).toString();
		String soLuongMuon = xemChiTietTable.getModel().getValueAt(row, 3).toString();
		String soLuongTrongKho = xemChiTietTable.getModel().getValueAt(row, 4).toString();
		XemChiTietCoSoVatChatFrame xemChiTietCoSoVatChatFrame = new XemChiTietCoSoVatChatFrame(this.controller, this.parentJFrame, tenCoSoVatChatDetail, tongSoLuong, soLuongMuon, soLuongTrongKho);
        xemChiTietCoSoVatChatFrame.setLocationRelativeTo(null);
        xemChiTietCoSoVatChatFrame.setResizable(false);
        xemChiTietCoSoVatChatFrame.setVisible(true);
	}
	
	private void themSoLuongActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		JTable xemChiTietTable = this.controller.getTable();
		int row = xemChiTietTable.getSelectedRow();
		if(row == -1) {
    		JOptionPane.showMessageDialog(null, "Hãy lựa chọn một hàng trước",
  			      "Lỗi không chọn hàng!", JOptionPane.ERROR_MESSAGE);
  		return;
		}
		String tenCoSoVatChatDetail = xemChiTietTable.getModel().getValueAt(row, 1).toString();
		String tongSoLuong = xemChiTietTable.getModel().getValueAt(row, 2).toString();
		String soLuongMuon = xemChiTietTable.getModel().getValueAt(row, 3).toString();
		String soLuongTrongKho = xemChiTietTable.getModel().getValueAt(row, 4).toString();
		ThemSoLuongCoSoVatChatFrame themSoLuongCoSoVatChatFrame = new ThemSoLuongCoSoVatChatFrame(this.controller, this.parentJFrame, tenCoSoVatChatDetail, tongSoLuong, soLuongMuon, soLuongTrongKho);
		themSoLuongCoSoVatChatFrame.setLocationRelativeTo(null);
		themSoLuongCoSoVatChatFrame.setResizable(false);
		themSoLuongCoSoVatChatFrame.setVisible(true);
	}
	
	private void xoaCoSoVatChatActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		JTable xemChiTietTable = this.controller.getTable();
		int row = xemChiTietTable.getSelectedRow();
		if(row == -1) {
    		JOptionPane.showMessageDialog(null, "Hãy lựa chọn một hàng trước",
  			      "Lỗi không chọn hàng!", JOptionPane.ERROR_MESSAGE);
  		return;
		}
		String tenCoSoVatChatDetail = xemChiTietTable.getModel().getValueAt(row, 1).toString();
		String tongSoLuong = xemChiTietTable.getModel().getValueAt(row, 2).toString();
		String soLuongMuon = xemChiTietTable.getModel().getValueAt(row, 3).toString();
		String soLuongTrongKho = xemChiTietTable.getModel().getValueAt(row, 4).toString();
		XoaCoSoVatChatFrame xoaCoSoVatChatFrame = new XoaCoSoVatChatFrame(this.controller, this.parentJFrame, tenCoSoVatChatDetail, tongSoLuong, soLuongMuon, soLuongTrongKho);
		xoaCoSoVatChatFrame.setLocationRelativeTo(null);
		xoaCoSoVatChatFrame.setResizable(false);
		xoaCoSoVatChatFrame.setVisible(true);
	}
    private javax.swing.JButton addNewBtn;
    private javax.swing.JPanel tablePanel;
    private JTextField searchJtf;
    private JPopupMenu popupMenu;
    private JMenuItem xemChiTietCoSoVatChat;
    private JMenuItem themSoLuong;
    private JMenuItem xoaCoSoVatChat;
}
