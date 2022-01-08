package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;

import models.CoSoVatChatModel;
import models.MuonTraModel;

/**
 *
 * @author Hai
 * class dinh nghia cac dang table co trong phan mem
 */
public class ClassTableModel {

	//table muon tra
    public DefaultTableModel setTableMuonTra(List<MuonTraModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Integer.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((MuonTraModel item) -> {
            obj[0] = item.getStt();
            obj[1] = item.getTenNguoiMuon();
            obj[2] = item.getid();
            obj[3] = item.getLienHe();
            obj[4] = item.getThoiGianMuon();
            obj[5] = item.getThoiGIanTra();
            obj[6] = item.getCoSoVatChat();
            obj[7] = item.getSoLuong();
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    // table cho co so vat chat
    public DefaultTableModel setTableCoSoVatChat(List<CoSoVatChatModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex != 1 ? Integer.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((CoSoVatChatModel item) -> {
            obj[0] = item.getId();
            obj[1] = item.getTenCoSoVatChat();
            obj[2] = item.getSoLuong();
            obj[3] = item.getSoLuongMuon();
            obj[4] = item.getSoLuongTrongKho();
            dtm.addRow(obj);
        });
        return dtm;
    }
}
