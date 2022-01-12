package Bean;

import models.CoSoVatChatModel;
import models.ItemDaXoaModel;
import models.NguoiMuonModel;
import models.NhaTaiTroModel;
import models.ThoiGianModel;

public class CoSoVatChatBean {
	private CoSoVatChatModel coSoVatChatModel;
	private NhaTaiTroModel nhaTaiTroModel;
	private ItemDaXoaModel itemDaXoaModel;
	private NguoiMuonModel nguoiMuonModel;
	private ThoiGianModel thoiGianModel;
    public CoSoVatChatBean(CoSoVatChatModel coSoVatChatModel) {
    	this.setCoSoVatChatModel(coSoVatChatModel);
    }
    public CoSoVatChatBean() {
    	this.coSoVatChatModel = new CoSoVatChatModel();
    }
	public CoSoVatChatModel getCoSoVatChatModel() {
		return coSoVatChatModel;
	}
	public void setCoSoVatChatModel(CoSoVatChatModel coSoVatChatModel) {
		this.coSoVatChatModel = coSoVatChatModel;
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
	
	public NguoiMuonModel getNguoiMuonModel() {
		return nguoiMuonModel;
	}
	public void setNguoiMuonModel(NguoiMuonModel nguoiMuonModel) {
		this.nguoiMuonModel = nguoiMuonModel;
	}
	public ThoiGianModel getThoiGianModel() {
		return thoiGianModel;
	}
	public void setThoiGianModel(ThoiGianModel thoiGianModel) {
		this.thoiGianModel = thoiGianModel;
	}
	@Override
    public String toString() {
        String res ="";  
        return res;
    }
}
