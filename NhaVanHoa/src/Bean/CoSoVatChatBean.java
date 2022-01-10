package Bean;

import models.CoSoVatChatModel;
import models.ItemDaXoaModel;
import models.NhaTaiTroModel;

public class CoSoVatChatBean {
	private CoSoVatChatModel coSoVatChatModel;
	private NhaTaiTroModel nhaTaiTroModel;
	private ItemDaXoaModel itemDaXoaModel;
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
	@Override
    public String toString() {
        String res ="";  
        return res;
    }
}
