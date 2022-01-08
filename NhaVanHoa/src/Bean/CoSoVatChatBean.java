package Bean;

import models.CoSoVatChatModel;

public class CoSoVatChatBean {
	private CoSoVatChatModel coSoVatChatModel;
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

	@Override
    public String toString() {
        String res ="";  
        return res;
    }
}
