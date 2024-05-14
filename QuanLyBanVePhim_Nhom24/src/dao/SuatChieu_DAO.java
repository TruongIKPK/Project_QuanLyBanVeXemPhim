package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.Ghe;
import entity.Phim;
import entity.PhongChieu;
import entity.SuatChieu;

public class SuatChieu_DAO {
	
	private static SuatChieu_DAO instance;
	private ResultSet resultSet;
	private ConnectDB dataBaseUtils;
	
	public SuatChieu_DAO(){
		super();
		this.dataBaseUtils = new ConnectDB(); 
	}

	public boolean addSuatChieu(SuatChieu suatChieu) throws ClassNotFoundException, SQLException {
	    try (Connection con = dataBaseUtils.connect()) {
	    	PreparedStatement stmt = con.prepareStatement("insert into SuatChieu (maPhongChieu, maPhim, ngayChieu, gioChieu)\r\n"
	    	        + "values (?, ?, ?, ?)");

	        stmt.setInt(1, suatChieu.getPhongChieu().getMaPhong());
	        stmt.setInt(2, suatChieu.getPhim().getMaPhim());
	        stmt.setString(3, suatChieu.getNgayChieu());
	        stmt.setString(4, suatChieu.getGioChieu());
	        int n = stmt.executeUpdate();
	        return n > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public ArrayList<SuatChieu> getSuatChieus() throws Exception {
    	dataBaseUtils.connect();
        ArrayList<SuatChieu> suatChieus = new ArrayList<>();
        ResultSet resultSet = null;
        String sql = "SELECT * FROM SuatChieu ORDER BY SuatChieu.NgayChieu ASC, SuatChieu.GioChieu ASC";

        try {
            resultSet = dataBaseUtils.excuteQueryRead(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                	SuatChieu suatChieu = new SuatChieu();
                	Phim phim = new Phim(resultSet.getInt("maPhim"));
                	PhongChieu phongChieu = new PhongChieu(resultSet.getInt("maPhongChieu"));
                	suatChieu.setMaSuatChieu(resultSet.getInt("maSuatChieu"));
                	suatChieu.setPhim(phim);
                	suatChieu.setPhongChieu(phongChieu);
                	suatChieu.setNgayChieu(resultSet.getString("ngayChieu"));
                	suatChieu.setGioChieu(resultSet.getString("gioChieu"));
                	suatChieus.add(suatChieu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Lỗi lấy danh sách suất chiếu: " + e.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return suatChieus;
    }
	public ArrayList<SuatChieu> getSuatChieuTheoNgay(String ngay) throws Exception {
    	dataBaseUtils.connect();
        ArrayList<SuatChieu> suatChieus = new ArrayList<>();
        ResultSet resultSet = null;
        String sql = "SELECT * FROM SuatChieu where ngayChieu = '"+ ngay +"' ORDER BY SuatChieu.NgayChieu ASC, SuatChieu.GioChieu ASC";

        try {
            resultSet = dataBaseUtils.excuteQueryRead(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                	SuatChieu suatChieu = new SuatChieu();
                	Phim phim = new Phim(resultSet.getInt("maPhim"));
                	PhongChieu phongChieu = new PhongChieu(resultSet.getInt("maPhongChieu"));
                	suatChieu.setMaSuatChieu(resultSet.getInt("maSuatChieu"));
                	suatChieu.setPhim(phim);
                	suatChieu.setPhongChieu(phongChieu);
                	suatChieu.setNgayChieu(resultSet.getString("ngayChieu"));
                	suatChieu.setGioChieu(resultSet.getString("gioChieu"));
                	suatChieus.add(suatChieu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Lỗi lấy danh sách suất chiếu: " + e.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return suatChieus;
    }
	public static SuatChieu_DAO getInstance() {
        if (instance == null) {
            synchronized (SuatChieu_DAO.class) {
                if (null == instance) {
                    instance = new SuatChieu_DAO();
                }
            }
        }
        return instance;
    }
}
