package BUS;

import DAL.PhanCongDAL;
import DTO.PhanCongDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhanCongBUS {
    static PhanCongDAL phanCongDAL = new PhanCongDAL();


    //get data from db
    public List<PhanCongDTO> getData() {
        List<PhanCongDTO> lsPhanCong = new ArrayList<>();
        lsPhanCong = phanCongDAL.getData();
        return lsPhanCong;
    }
    //to check record is delete
    public boolean isDel ( int ct, String pt){
        return phanCongDAL.isDel(ct, pt);
    }
    public boolean isAdd(PhanCongDTO phanCongDTO){
        return phanCongDAL.isAdd(phanCongDTO);
    }
}
