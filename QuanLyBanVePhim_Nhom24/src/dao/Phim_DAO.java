package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connect.ConnectDB;
import entity.Phim;

public class Phim_DAO {
	
	private static Phim_DAO instance;
	private ResultSet resultSet;
	private ConnectDB dataBaseUtils;
	
	public Phim_DAO() {
		super();
		this.dataBaseUtils = new ConnectDB(); 
	}
	public ArrayList<Phim> dsPhim() throws Exception {
	    ArrayList<Phim> phims = new ArrayList<Phim>();
	    String sql = "SELECT * FROM Phim";

	    try {
	        // Mở kết nối cơ sở dữ liệu
	        dataBaseUtils.connect();

	        // Thực hiện truy vấn
	        resultSet = dataBaseUtils.excuteQueryRead(sql);
	        
	        // Lặp qua các hàng kết quả và thêm vào danh sách phim
	        while (resultSet.next()) {
	            Phim phim = new Phim(
	                resultSet.getInt("maPhim"),
	                resultSet.getString("tenPhim"),
	                resultSet.getString("quocGia"),
	                resultSet.getInt("thoiLuong"),
	                resultSet.getString("ngayKhoiChieu"),
	                resultSet.getString("ngayKetThuc"),
	                resultSet.getInt("gioiHanTuoi"),
	                resultSet.getInt("namSX"),
	                resultSet.getString("theLoai"),
	                resultSet.getString("hinhAnh")
	            );
	            phims.add(phim);
	        }
	    } catch (Exception e) {
	        throw new Exception("Lỗi lấy danh sách phim", e); // Bạn cần chuyển Exception gốc để bảo toàn thông tin gốc của nó.
	    } finally {
	        // Đóng ResultSet và kết nối cơ sở dữ liệu
	        if (resultSet != null) {
	            resultSet.close();
	        }
	        dataBaseUtils.disconnect();
	    }
	    return phims;
	}
	public Phim timPhim(int maPhim) throws Exception {
	    String sql = "SELECT * FROM Phim where maPhim = "+ maPhim;
	    Phim phim = null;
	    try {
	        dataBaseUtils.connect();
	        resultSet = dataBaseUtils.excuteQueryRead(sql);
	        while (resultSet.next()) {
	            phim = new Phim(
	                resultSet.getInt("maPhim"),
	                resultSet.getString("tenPhim"),
	                resultSet.getString("quocGia"),
	                resultSet.getInt("thoiLuong"),
	                resultSet.getString("ngayKhoiChieu"),
	                resultSet.getString("ngayKetThuc"),
	                resultSet.getInt("gioiHanTuoi"),
	                resultSet.getInt("namSX"),
	                resultSet.getString("theLoai"),
	                resultSet.getString("hinhAnh")
	            );
	        }
	    } catch (Exception e) {
	        throw new Exception("Lỗi lấy phim", e); 
	    } finally {
	        if (resultSet != null) {
	            resultSet.close();
	        }
	        dataBaseUtils.disconnect();
	    }
	    return phim;
	}
	public boolean addPhim(Phim phim) throws ClassNotFoundException, SQLException {
	    try (Connection con = dataBaseUtils.connect()) {
	        PreparedStatement stmt = con.prepareStatement("INSERT INTO Phim(tenPhim, ngayKhoiChieu, ngayKetThuc, quocGia, thoiLuong, gioiHanTuoi, namSX, theLoai, hinhAnh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
	        stmt.setString(1, phim.getTenPhim());
	        stmt.setString(2, phim.getNgayKhoiChieu());
	        stmt.setString(3, phim.getNgayKetThuc());
	        stmt.setString(4, phim.getQuocGia());
	        stmt.setInt(5, phim.getThoiLuong());
	        stmt.setInt(6, phim.getGioiHanTuoi());
	        stmt.setInt(7, phim.getNamSX());
	        stmt.setString(8, phim.getTheLoai());
	        stmt.setString(9, phim.getHinhAnh());
	        int n = stmt.executeUpdate();
	        return n > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public boolean updatePhim(Phim phim) throws ClassNotFoundException, SQLException {
	    try (Connection con = dataBaseUtils.connect()) {
	        String sql =  "UPDATE Phim SET tenPhim = ?, quocGia = ?, thoiLuong = ?, ngayKhoiChieu = ?, ngayKetThuc = ?, gioiHanTuoi = ?, namSX = ?, theLoai = ?, hinhAnh = ? WHERE maPhim = ?";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, phim.getTenPhim());
	        stmt.setString(2, phim.getQuocGia());
	        stmt.setInt(3, phim.getThoiLuong());
	        stmt.setString(4, phim.getNgayKhoiChieu());
	        stmt.setString(5, phim.getNgayKetThuc());
	        stmt.setInt(6, phim.getGioiHanTuoi());
	        stmt.setInt(7, phim.getNamSX());
	        stmt.setString(8, phim.getTheLoai());
	        stmt.setString(9, phim.getHinhAnh());
	        stmt.setInt(10, phim.getMaPhim());
	        int n = stmt.executeUpdate();
	        return n > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public static Phim_DAO getInstance() {
        if (instance == null) {
            synchronized (Phim_DAO.class) {
                if (null == instance) {
                    instance = new Phim_DAO();
                }
            }
        }
        return instance;
    }
}
