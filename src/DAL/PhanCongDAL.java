package DAL;

import DTO.PhanCongDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhanCongDAL {
    static Statement statement = null;
    static ResultSet resultSet = null;
    static PhanCongDTO phanCongDTO;
    static List<PhanCongDTO> lsPhanCong;

    // to set DTO to result set
    public static void setPhanCongDTO(ResultSet rs, PhanCongDTO phanCongDTO) throws SQLException {
        phanCongDTO.setMaLop(rs.getString("maLop"));
        phanCongDTO.setTenMonHoc(rs.getString("tenMonHoc"));
        phanCongDTO.setNgayThi(rs.getDate("ngayThi"));
        phanCongDTO.setCaThi(rs.getInt("caThi"));
        phanCongDTO.setPhongThi(rs.getString("phongThi"));
        phanCongDTO.setSoSV(rs.getInt("soSV"));
        phanCongDTO.setSoCBCT(rs.getInt("soCBCT"));
    }

    public List<PhanCongDTO> getData() {
        InitConnection connection = new InitConnection();
        Connection cnt = connection.InitConnection();
        lsPhanCong = new ArrayList<>();
        try {
            statement = cnt.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM PHANCONG");
            while (resultSet.next()) {
                phanCongDTO = new PhanCongDTO();
                setPhanCongDTO(resultSet, phanCongDTO);
                lsPhanCong.add(phanCongDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lsPhanCong;
    }

    // to delete record from db
    public boolean isDel(int ct, String pt) {
        InitConnection connection = new InitConnection();
        Connection cnt = connection.InitConnection();

        try {
            statement = cnt.createStatement();
            statement.executeUpdate("DELETE FROM PHANCONG WHERE caThi = " + ct + " AND phongThi = '" + pt + "'");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // to add record from db
//    public boolean isAdd(PhanCongDTO phanCongDTO) {
//        InitConnection connection = new InitConnection();
//        Connection cnt = connection.InitConnection();
//
//        try {
//            statement = cnt.createStatement();
//            statement.executeUpdate("DELETE FROM PHANCONG WHERE caThi = " + ct + " AND phongThi = '" + pt + "'");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
}
