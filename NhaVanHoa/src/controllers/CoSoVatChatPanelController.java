package controllers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Bean.CoSoVatChatBean;
import models.CoSoVatChatModel;
import services.CoSoVatChatService;
import utility.ClassTableModel;

public class CoSoVatChatPanelController {
	 private JPanel jpnView;
	    private JTextField searchJtf;
	    private CoSoVatChatService coSoVatChatService;
	    private List<CoSoVatChatBean> listCoSoVatChatBeans;
	    private ClassTableModel classTableModel = null;
	    private final String[] COLUMNS = {"STT", "Dụng cụ", "Tổng số", "Số lượng mượn", "Số lượng trong kho"};
	    private JFrame parentJFrame;
	    private JPopupMenu popupMenu;
	    private JTable table;
	    
	    public CoSoVatChatPanelController(JPanel jpnView, JTextField searchJtf, JPopupMenu popup) {
	        this.jpnView = jpnView;
	        this.searchJtf  = searchJtf;
	        this.popupMenu = popup;
	        classTableModel = new ClassTableModel();
	        this.coSoVatChatService = new CoSoVatChatService();
	        this.listCoSoVatChatBeans = this.coSoVatChatService.getListCoSoVatChat();
	        initAction();
	    }

	    public CoSoVatChatPanelController() {
	    }
	    
	    
	    //khi nhap hoten vs lien he se tu dong tim, khong can an filter
	    public void initAction(){
	        this.searchJtf.getDocument().addDocumentListener(new DocumentListener() {
	            @Override
	            public void insertUpdate(DocumentEvent e) {
	                String key = searchJtf.getText();
	                listCoSoVatChatBeans = coSoVatChatService.search(key.trim());
	                setDataTable();
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	                String key = searchJtf.getText();
	                listCoSoVatChatBeans = coSoVatChatService.search(key.trim());
	                setDataTable();
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	                String key = searchJtf.getText();
	                listCoSoVatChatBeans = coSoVatChatService.search(key.trim());
	                setDataTable();

	            }
	        });
	        
	    }
	    //Khi an Filter, bien listMuonTraBeans se call muonTraService de thonn ke thon tin vua nhap
	    //Chu y cac thong tin null
	    public void setData(String tenCoSoVatChat){
	      this.listCoSoVatChatBeans = this.coSoVatChatService.search(tenCoSoVatChat);
	      setDataTable();
	    }
	    
	    public void setDataTable() {
	        List<CoSoVatChatModel> listItem = new ArrayList<>();
	        this.listCoSoVatChatBeans.forEach(coSoVatChat -> {
	            listItem.add(coSoVatChat.getCoSoVatChatModel());
	        });
	        DefaultTableModel model = classTableModel.setTableCoSoVatChat(listItem, COLUMNS);
	        table = new JTable(model) {
	            @Override
	            public boolean editCellAt(int row, int column, EventObject e) {
	                return false;
	            }
	            
	        };
	        table.setComponentPopupMenu(popupMenu);
	        // thiet ke bang
	        
	        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
	        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
	        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
	        .setHorizontalAlignment(JLabel.CENTER);
	        table.setRowHeight(50);
	        table.validate();
	        table.repaint();
	        table.setFont(new Font("Arial", Font.PLAIN, 14));
	        table.getColumnModel().getColumn(0).setMaxWidth(80);
	        table.getColumnModel().getColumn(0).setMinWidth(80);
	        table.getColumnModel().getColumn(0).setPreferredWidth(80);
	        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	        for(int i = 0; i < 5; ++i) 
	        	table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
	        table.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
//	                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
	                if (e.getClickCount() > 1) {

	                }
	            }
	            
	        });
	        
	        JScrollPane scroll = new JScrollPane();
	        scroll.getViewport().add(table);
	        scroll.setPreferredSize(new Dimension(1350, 400));
	        jpnView.removeAll();
	        jpnView.setLayout(new BorderLayout());
	        jpnView.add(scroll, BorderLayout.CENTER);
	        jpnView.validate();
	        jpnView.repaint();
	    }

	    public void setParentJFrame(JFrame parentJFrame) {
	        this.parentJFrame = parentJFrame;
	    }
	    
	    public void refreshData() {
	        this.listCoSoVatChatBeans = this.coSoVatChatService.getListCoSoVatChat();
	        setDataTable();
	    }
	    public JPanel getJpnView() {
	        return jpnView;
	    }

	    public void setJpnView(JPanel jpnView) {
	        this.jpnView = jpnView;
	    }

		public JTextField getSearchJtf() {
			return searchJtf;
		}

		public void setSearchJtf(JTextField searchJtf) {
			this.searchJtf = searchJtf;
		}

		public JTable getTable() {
			return table;
		}

		public void setTable(JTable table) {
			this.table = table;
		}




}
