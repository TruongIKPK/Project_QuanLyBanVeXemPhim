package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.ChucVu;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;

public class KhachHang_DAO {
	private ResultSet resultSet;
	private ConnectDB dataBaseUtils;
	private static KhachHang_DAO instance;
	
	public KhachHang_DAO() {
        super();
        this.dataBaseUtils = new ConnectDB(); 
    }
	public static KhachHang_DAO getInstance() {
        if (instance == null) {
            synchronized (KhachHang_DAO.class) {
                if (null == instance) {
                    instance = new KhachHang_DAO();
                }
            }
        }
        return instance;
    }
	public boolean addKhachHang(KhachHang kh) throws ClassNotFoundException {
		try (Connection con = dataBaseUtils.connect()) {
	    	PreparedStatement stmt = con.prepareStatement("insert into KhachHang(tenKhachHang, phai, ngaySinh, sdt) "
					+ "values (?, ?, ?, ?)");
	    	stmt.setString(1, kh.getTenKhachHang());
			stmt.setBoolean(2, kh.isPhai());
			stmt.setString(3, kh.getNgaySinh());
			stmt.setString(4, kh.getSdt());
			int n = stmt.executeUpdate();
	        return n > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public boolean updateKhachHang(KhachHang kh) throws ClassNotFoundException {
	    try (Connection con = dataBaseUtils.connect()) {
	        String sql =  "update KhachHang set tenKhachHang = ?, phai = ?, ngaySinh = ?, sdt = ? where maKhachHang = ?";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, kh.getTenKhachHang());
	        stmt.setBoolean(2, kh.isPhai());
	        stmt.setString(3, kh.getNgaySinh());
	        stmt.setString(4, kh.getSdt());
	        stmt.setInt(5, kh.getMaKhachHang());
	        int n = stmt.executeUpdate();
	        return n > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }   
	}
	public boolean updateDiemKhachHang(KhachHang kh) throws ClassNotFoundException {
	    try (Connection con = dataBaseUtils.connect()) {
	        String sql =  "update KhachHang set diemTichLuy = ? where maKhachHang = ?";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setInt(1, kh.getDiemTichLuy());
	        stmt.setInt(2, kh.getMaKhachHang());
	        int n = stmt.executeUpdate();
	        return n > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }   
	}
	public ArrayList<KhachHang> timTenKHTheoSDT(String sdtKH) throws Exception {
		ArrayList<KhachHang> khachHangs = new ArrayList<>();
		String sql = String.format("SELECT * FROM KhachHang where sdt = ") + "'"+sdtKH+ "'";
        try {
        	dataBaseUtils.connect();
	        resultSet = dataBaseUtils.excuteQueryRead(sql);
            while (resultSet.next()) {
            	KhachHang khachHang = null;
            	int maKH = resultSet.getInt("maKhachHang");
                String tenKH = resultSet.getString("tenKhachHang");
                boolean phai = resultSet.getBoolean("phai");
                String ngaySinh = resultSet.getString("ngaySinh");
                String sdt = resultSet.getString("sdt");
                int diemTichLuy = resultSet.getInt("diemTichLuy");
                khachHang = new KhachHang(maKH, tenKH, phai, ngaySinh, sdt, diemTichLuy);
                khachHangs.add(khachHang);
            }
        } catch (Exception e) {
            throw new Exception("Lỗi lấy danh sách khách hàng");
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
		return khachHangs;
    }
	public ArrayList<KhachHang> timTenKHTheoHoTen(String hoTenKH) throws Exception {
		ArrayList<KhachHang> khachHangs = new ArrayList<>();
		String sql = "SELECT * FROM KhachHang WHERE tenKhachHang = "+ "N'" +hoTenKH + "'";
        try {
        	dataBaseUtils.connect();
            resultSet = dataBaseUtils.excuteQueryRead(sql); 
            while (resultSet.next()) {
            	KhachHang khachHang = null;
            	int maKH = resultSet.getInt("maKhachHang");
                String tenKH = resultSet.getString("tenKhachHang");
                boolean phai = resultSet.getBoolean("phai");
                String ngaySinh = resultSet.getString("ngaySinh");
                String sdt = resultSet.getString("sdt");
                int diemTichLuy = resultSet.getInt("diemTichLuy");
                khachHang = new KhachHang(maKH, tenKH, phai, ngaySinh, sdt, diemTichLuy);
                khachHangs.add(khachHang);
            }
        } catch (Exception e) {
            throw new Exception("Lỗi lấy danh sách khách hàng");
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
		return khachHangs;
    }
}
