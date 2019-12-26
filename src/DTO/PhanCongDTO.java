package DTO;

import java.util.Date;

public class PhanCongDTO {
    String maLop;
    String tenMonHoc;
    Date ngayThi;
    int caThi;
    String phongThi;
    int soSV;
    int soCBCT;

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public Date getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(Date ngayThi) {
        this.ngayThi = ngayThi;
    }

    public int getCaThi() {
        return caThi;
    }

    public void setCaThi(int caThi) {
        this.caThi = caThi;
    }

    public String getPhongThi() {
        return phongThi;
    }

    public void setPhongThi(String phongThi) {
        this.phongThi = phongThi;
    }

    public int getSoSV() {
        return soSV;
    }

    public void setSoSV(int soSV) {
        this.soSV = soSV;
    }

    public int getSoCBCT() {
        return soCBCT;
    }

    public void setSoCBCT(int soCBCT) {
        this.soCBCT = soCBCT;
    }
}
