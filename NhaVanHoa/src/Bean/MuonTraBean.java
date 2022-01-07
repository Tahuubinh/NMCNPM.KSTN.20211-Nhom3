package Bean;

import java.util.ArrayList;
import java.util.List;
import models.CoSoHaTangModel;
import models.CoSoVatChatModel;
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
    private CoSoHaTangModel coSoHaTangModel;
    private ThoiGianModel thoiGianModel;
    
    public MuonTraBean(MuonTraModel muonTraModel, NguoiMuonModel nguoiMuonModel, CoSoVatChatModel coSoVatChatModel, CoSoHaTangModel coSoHaTangModel, ThoiGianModel thoiGianModel) {
        this.muonTraModel = muonTraModel;
        this.nguoiMuonModel = nguoiMuonModel;
        this.coSoVatChatModel = coSoVatChatModel;
        this.coSoHaTangModel = coSoHaTangModel;
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

	public CoSoHaTangModel getCoSoHaTangModel() {
		return coSoHaTangModel;
	}

	public void setCoSoHaTangModel(CoSoHaTangModel coSoHaTangModel) {
		this.coSoHaTangModel = coSoHaTangModel;
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
