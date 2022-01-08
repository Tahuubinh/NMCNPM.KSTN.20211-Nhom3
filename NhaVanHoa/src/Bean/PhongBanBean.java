package Bean;

import models.PhongBanModel;

public class PhongBanBean {
	private PhongBanModel PhongBanModel;
	
    public PhongBanBean(PhongBanModel PhongBanModel) {
    	this.setPhongBanModel(PhongBanModel);
    }
    public PhongBanBean() {
    	this.PhongBanModel = new PhongBanModel();
    }
	public PhongBanModel getPhongBanModel() {
		return PhongBanModel;
	}
	public void setPhongBanModel(PhongBanModel PhongBanModel) {
		this.PhongBanModel = PhongBanModel;
	}
	@Override
    public String toString() {
        String res ="";  
        return res;
    }
}
