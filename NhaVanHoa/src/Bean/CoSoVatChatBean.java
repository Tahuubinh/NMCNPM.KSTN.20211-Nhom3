package Bean;

import java.util.List;

import models.CoSoVatChatModel;
import models.ItemDaXoaModel;
import models.NguoiMuonModel;
import models.NhaTaiTroModel;
import models.ThoiGianModel;

public class CoSoVatChatBean {
	private CoSoVatChatModel coSoVatChatModel;
	private NhaTaiTroModel nhaTaiTroModel;
	private ItemDaXoaModel itemDaXoaModel;
	private List<NguoiMuonModel> listNguoiMuonModels;
	private List<ThoiGianModel> listThoiGianModels;
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
	

	public List<NguoiMuonModel> getListNguoiMuonModels() {
		return listNguoiMuonModels;
	}
	public void setListNguoiMuonModels(List<NguoiMuonModel> listNguoiMuonModels) {
		this.listNguoiMuonModels = listNguoiMuonModels;
	}
	public List<ThoiGianModel> getListThoiGianModels() {
		return listThoiGianModels;
	}
	public void setListThoiGianModels(List<ThoiGianModel> listThoiGianModels) {
		this.listThoiGianModels = listThoiGianModels;
	}
	@Override
    public String toString() {
        String res ="";  
        return res;
    }
}
