package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.DichVu;

public class DichVuDAO {
	private ConnectDB dataBaseUtils;
    private static DichVuDAO instance;

    private DichVuDAO() {
        super();
        this.dataBaseUtils = new ConnectDB();
    }

    public static synchronized DichVuDAO getInstance() {
        if (instance == null) {
            instance = new DichVuDAO();
        }
        return instance;
    }
    public ArrayList<DichVu> getDichVus() throws Exception {
    	dataBaseUtils.connect();
        ArrayList<DichVu> dichVus = new ArrayList<>();
        ResultSet resultSet = null;
        String sql = "SELECT * FROM DichVu";

        try {
            resultSet = dataBaseUtils.excuteQueryRead(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    DichVu dichVu = new DichVu(
                        resultSet.getInt("maDichVu"),
                        resultSet.getString("tenDichVu"),
                        resultSet.getDouble("giaBang"),
                        resultSet.getString("hinhAnh"),
                        resultSet.getString("moTa")
                    );
                    dichVus.add(dichVu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Lỗi lấy danh sách dịch vụ: " + e.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return dichVus;
    }
}
