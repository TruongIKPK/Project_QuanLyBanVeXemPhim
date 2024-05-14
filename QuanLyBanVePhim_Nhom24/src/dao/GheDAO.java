package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.Ghe;
import entity.PhongChieu;

public class GheDAO {
    private ConnectDB dataBaseUtils;
    private static GheDAO instance;

    private GheDAO() {
        super();
        this.dataBaseUtils = new ConnectDB();
    }

    public static synchronized GheDAO getInstance() {
        if (instance == null) {
            instance = new GheDAO();
        }
        return instance;
    }

    public ArrayList<Ghe> getGhes() throws Exception {
    	dataBaseUtils.connect();
        ArrayList<Ghe> ghes = new ArrayList<>();
        ResultSet resultSet = null;
        String sql = "SELECT * FROM Ghe";

        try {
            resultSet = dataBaseUtils.excuteQueryRead(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    PhongChieu phongChieu = new PhongChieu();
                    phongChieu.setMaPhong(resultSet.getInt("maPhong"));
                    Ghe ghe = new Ghe(
                        resultSet.getInt("maGhe"),
                        resultSet.getString("loaiGhe"),
                        resultSet.getInt("trangThai"),
                        phongChieu
                    );
                    ghes.add(ghe);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Lỗi lấy danh sách ghế: " + e.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ghes;
    }
}

