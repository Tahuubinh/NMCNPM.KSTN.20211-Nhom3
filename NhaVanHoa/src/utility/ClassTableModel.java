package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.MuonTraModel;

/**
 *
 * @author Hai
 * class dinh nghia cac dang table co trong phan mem
 */
public class ClassTableModel {

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
    
    public DefaultTableModel setTableDangKySuDungCoSoVatChat(List<MuonTraModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 1 ? Integer.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((MuonTraModel item) -> {
            obj[0] = item.getCoSoVatChat();
            obj[1] = item.getSoLuong();
            dtm.addRow(obj);
        });
        return dtm;
    }
    // table cho tieusu
    
}
