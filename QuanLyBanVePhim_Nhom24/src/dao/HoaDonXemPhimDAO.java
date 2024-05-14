package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.Ghe;
import entity.HoaDonXemPhim;
import entity.KhachHang;
import entity.NhanVien;
import entity.SuatChieu;
import entity.VeXemPhim;

public class HoaDonXemPhimDAO {
		private ResultSet resultSet;
		private ConnectDB dataBaseUtils;
		private static HoaDonXemPhimDAO instance;
		
		public HoaDonXemPhimDAO(){
	        super();
	        this.dataBaseUtils = new ConnectDB(); 
	    }
		public static HoaDonXemPhimDAO getInstance() {
	        if (instance == null) {
	            synchronized (KhachHang_DAO.class) {
	                if (null == instance) {
	                    instance = new HoaDonXemPhimDAO();
	                }
	            }
	        }
	        return instance;
	    }
		public boolean addHoaDonTong(HoaDonXemPhim hdXem) throws ClassNotFoundException {
			try (Connection con = dataBaseUtils.connect()) {
		    	PreparedStatement stmt = con.prepareStatement("insert into HoaDonXemPhim (maKhachHang, maNhanVien, maSuatChieu, thueVAT) "
						+ "values (?, ?, ?, 0.08)");
		    	stmt.setString(1, hdXem.getKhachHang() == null ? "NULL" : Integer.toString(hdXem.getKhachHang().getMaKhachHang()));
				stmt.setInt(2, hdXem.getNhanVien().getMaNV());
				stmt.setInt(3, hdXem.getSuatchieu().getMaSuatChieu());
				int n = stmt.executeUpdate();
		        return n > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		}
		 public int getLatestMaHoaDon() throws Exception {
			 dataBaseUtils.connect();
			 String sql = String.format("SELECT MAX(maHDXemPhim) AS max_ma_hoa_don FROM HoaDonXemPhim");
		     int maHoaDonTong = 0;
		        try {
		        	resultSet = dataBaseUtils.excuteQueryRead(sql);
		        	resultSet.next();
		            maHoaDonTong = resultSet.getInt("max_ma_hoa_don");
	        } catch (Exception e) {
		        throw new Exception("Không tìm thấy HD");
		    } finally {
		        if (resultSet != null) {
		            resultSet.close();
		        }
		        dataBaseUtils.disconnect();
		    }
		    return maHoaDonTong;
		 }
		 public ArrayList<HoaDonXemPhim> dsHDDaDat() throws Exception{
				ArrayList<HoaDonXemPhim> dsHD = new ArrayList<>();
				String sql = "SELECT * FROM HoaDonXemPhim";
				try {
		        	dataBaseUtils.connect();
		            resultSet = dataBaseUtils.excuteQueryRead(sql); 
		            while (resultSet.next()) {
		            	HoaDonXemPhim hd = null;
		            	int maHD = resultSet.getInt("maDHXemPhim");
		            	NhanVien nv = new NhanVien(resultSet.getInt("maNhanVien"));
		            	KhachHang kh = new KhachHang(resultSet.getInt("maKhachHang"));
		            	SuatChieu sc = new SuatChieu(resultSet.getInt("maSuatChieu"));
		                double thue = resultSet.getDouble("thueVAT");
		                hd = new HoaDonXemPhim(maHD, sc, nv, kh, thue);
		                dsHD.add(hd);
		            }
		        } catch (Exception e) {
		            throw new Exception("Lỗi lấy danh sách hóa đơn");
		        } finally {
		            if (resultSet != null) {
		                resultSet.close();
		            }
		        }
				return dsHD;
		 }
}
