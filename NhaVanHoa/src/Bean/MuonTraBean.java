package Bean;


import models.PhongBanModel;

import java.util.ArrayList;
import java.util.List;

import models.CoSoVatChatModel;
import models.ListMuonTraDetailModel;
import models.MuonTraModel;
import models.NguoiMuonModel;
import models.ThoiGianModel;

/**
 *
 * @author Hai
 */
public class MuonTraBean {
    private MuonTraModel muonTraModel;
    private NguoiMuonModel nguoiMuonModel;
    private CoSoVatChatModel coSoVatChatModel;
    private PhongBanModel phongBanModel;
    private ThoiGianModel thoiGianModel;
    private List<CoSoVatChatModel> listCoSoVatChatModels = new ArrayList<>();
    private List<PhongBanModel> listPhongBanModels = new ArrayList<>();
    public MuonTraBean(MuonTraModel muonTraModel, NguoiMuonModel nguoiMuonModel, CoSoVatChatModel coSoVatChatModel, PhongBanModel phongBanModel, ThoiGianModel thoiGianModel) {
        this.muonTraModel = muonTraModel;
        this.nguoiMuonModel = nguoiMuonModel;
        this.coSoVatChatModel = coSoVatChatModel;
        this.phongBanModel = phongBanModel;
        this.thoiGianModel = thoiGianModel;
    }

    public MuonTraBean() {
        this.muonTraModel = new MuonTraModel();

    }
    
    public MuonTraModel getMuonTraModel() {
        return muonTraModel;
    }

    public void setmuonTraModel(MuonTraModel muonTraModel) {
        this.muonTraModel = muonTraModel;
    }

    
    public NguoiMuonModel getNguoiMuonModel() {
		return nguoiMuonModel;
	}

	public void setNguoiMuonModel(NguoiMuonModel nguoiMuonModel) {
		this.nguoiMuonModel = nguoiMuonModel;
	}

	public CoSoVatChatModel getCoSoVatChatModel() {
		return coSoVatChatModel;
	}

	public void setCoSoVatChatModel(CoSoVatChatModel coSoVatChatModel) {
		this.coSoVatChatModel = coSoVatChatModel;
	}

	public PhongBanModel getPhongBanModel() {
		return phongBanModel;
	}

	public void setPhongBanModel(PhongBanModel phongBanModel) {
		this.phongBanModel = phongBanModel;
	}

	public ThoiGianModel getThoiGianModel() {
		return thoiGianModel;
	}

	public void setThoiGianModel(ThoiGianModel thoiGianModel) {
		this.thoiGianModel = thoiGianModel;
	}

	public List<CoSoVatChatModel> getListCoSoVatChatModels() {
		return listCoSoVatChatModels;
	}

	public void setListCoSoVatChatModels(List<CoSoVatChatModel> listCoSoVatChatModels) {
		this.listCoSoVatChatModels = listCoSoVatChatModels;
	}

	public List<PhongBanModel> getListPhongBanModels() {
		return listPhongBanModels;
	}

	public void setListPhongBanModels(List<PhongBanModel> listPhongBanModels) {
		this.listPhongBanModels = listPhongBanModels;
	}



	@Override
    public String toString() {
        String res ="";  
        return res;
    }
}
