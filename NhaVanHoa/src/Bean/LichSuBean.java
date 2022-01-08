package Bean;

import models.CoSoVatChatModel;
import models.ItemDaXoaModel;
import models.LichSuModel;
import models.NguoiMuonModel;
import models.NhaTaiTroModel;
import models.PhongBanModel;
import models.ThoiGianModel;

@SuppressWarnings("unused")
public class LichSuBean {
    private LichSuModel lichSuModel;
    private NhaTaiTroModel nhaTaiTroModel;
    private ItemDaXoaModel itemDaXoaModel;
    
    public LichSuBean(LichSuModel lichSuModel, NhaTaiTroModel nhaTaiTroModel, ItemDaXoaModel itemDaXoaModel) {
        this.lichSuModel = lichSuModel;
        this.nhaTaiTroModel = nhaTaiTroModel;
        this.itemDaXoaModel = itemDaXoaModel;
    }

    public LichSuBean() {
        this.lichSuModel = new LichSuModel();

    }
	public LichSuModel getLichSuModel() {
		return lichSuModel;
	}

	public void setLichSuModel(LichSuModel lichSuModel) {
		this.lichSuModel = lichSuModel;
	}

	public NhaTaiTroModel getNhaTaiTroModel() {
		return nhaTaiTroModel;
	}

	public void setNhaTaiTroModel(NhaTaiTroModel nhaTaiTroModel) {
		this.nhaTaiTroModel = nhaTaiTroModel;
	}

	public ItemDaXoaModel getItemDaXoaModel() {
		return itemDaXoaModel;
	}

	public void setItemDaXoaModel(ItemDaXoaModel itemDaXoaModel) {
		this.itemDaXoaModel = itemDaXoaModel;
	}

	@Override
    public String toString() {
        String res ="";  
        return res;
    }
}
