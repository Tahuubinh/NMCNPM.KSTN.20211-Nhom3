package Bean;

import java.util.List;

import models.CoSoVatChatModel;
import models.ItemDaXoaModel;
import models.ListNguoiMuonCoSoVatChatDetailModel;
import models.NguoiMuonModel;
import models.NhaTaiTroModel;
import models.ThoiGianModel;

public class CoSoVatChatBean {
	private CoSoVatChatModel coSoVatChatModel = new CoSoVatChatModel();
	private NhaTaiTroModel nhaTaiTroModel = new NhaTaiTroModel();
	private ItemDaXoaModel itemDaXoaModel = new ItemDaXoaModel();
	private List<ListNguoiMuonCoSoVatChatDetailModel> listNguoiMuonCoSoVatChatDetailModels;
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
	
	public List<ListNguoiMuonCoSoVatChatDetailModel> getListNguoiMuonCoSoVatChatDetailModels() {
		return listNguoiMuonCoSoVatChatDetailModels;
	}
	public void setListNguoiMuonCoSoVatChatDetailModels(
			List<ListNguoiMuonCoSoVatChatDetailModel> listNguoiMuonCoSoVatChatDetailModels) {
		this.listNguoiMuonCoSoVatChatDetailModels = listNguoiMuonCoSoVatChatDetailModels;
	}
	@Override
    public String toString() {
        String res ="";  
        return res;
    }
}
