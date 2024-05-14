package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.ChucVu;
import entity.NhanVien;
import entity.TaiKhoan;

public class NhanVienDAO {
	private ResultSet resultSet;
	private ConnectDB dataBaseUtils;
	private static NhanVienDAO instance;
	
	public NhanVienDAO() {
        super();
        this.dataBaseUtils = new ConnectDB(); 
    }
	public static boolean addNhanVien(NhanVien nv) {
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into nhanvien(maNhanVien, maDangNhap, maChucVu,  tenNV\r\n"
					+ ", email, ngaySinh, phai, sdt) \r\n"
					+ "values (0 , ?, 2, ?, ?, ?, ?, ?)");
			stmt.setString(1, nv.getTaiKhoan().getTenDangNhap());
			stmt.setString(2, nv.getTenNV());
			stmt.setString(3, nv.getEmail());
			stmt.setString(4, nv.getNgaySinh());
			stmt.setBoolean(5, nv.isPhai());
			stmt.setString(6, nv.getSdt());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return n > 0;
	}
	public static ArrayList<NhanVien> timMaNVTheoTen(String tenNV) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from NhanVien where tenNV = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tenNV);
			// Thực thi câu lệnh sql
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int maNV = rs.getInt(1);
//				int maDangNhap = rs.getInt(2);
//				int maChucVu = rs.getInt(3);
//				String tenNhanVien = rs.getString(4);
				String ngaySinh = rs.getString(5);
				boolean phai = rs.getBoolean(6);
				String sdt = rs.getString(7);
				String email = rs.getString(8);
				NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, phai, sdt, email, null, null);
				dsnv.add(nv);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dsnv;
	}
	public static boolean updateNhanVien(NhanVien nv) throws SQLException {
		Connection con = ConnectDB.getConnection();
		int n = 0;
		try {
			String sql = "update NhanVien set tenNV=?, email =?, ngaySinh =?, phai =?, sdt =? where maNhanVien =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nv.getTenNV());
			ps.setString(2, nv.getEmail());
			ps.setString(3, nv.getNgaySinh());
			ps.setBoolean(4, nv.isPhai());
			ps.setString(5, nv.getSdt());
			ps.setInt(6, nv.getMaNV());		
			
			n = ps.executeUpdate();
			ps.close();		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return n > 0;
	} 
	public NhanVien getNhanVien(int maNhanVien) throws Exception {
	    dataBaseUtils.connect();
	    NhanVien nhanVien = null; 
	    String sql = String.format("SELECT * FROM NhanVien\r\n"
	            + "WHERE maNhanVien = '%s'", maNhanVien);
	    try {
	        resultSet = dataBaseUtils.excuteQueryRead(sql);
	        resultSet.next();
	        nhanVien = new NhanVien();
	        nhanVien.setMaNV(resultSet.getInt("maNhanVien"));
	        
	        TaiKhoan taiKhoan = new TaiKhoan();
	        taiKhoan.setMaTaiKhoan((resultSet.getInt("maDangNhap")));
	        nhanVien.setTaiKhoan(taiKhoan);
	        
	        ChucVu chucVu = new ChucVu();
	        chucVu.setMaChucVu((resultSet.getInt("maChucVu")));
	        nhanVien.setChucVu(chucVu);
	        
	        nhanVien.setTenNV(resultSet.getString("tenNV"));
	        
	        nhanVien.setNgaySinh(resultSet.getString("ngaySinh"));
	        
	        nhanVien.setPhai(resultSet.getBoolean("phai"));
	        nhanVien.setSdt(resultSet.getString("sdt"));
	        nhanVien.setEmail(resultSet.getString("email"));
	        
	    } catch (Exception e) {
	        throw new Exception("Không tìm thấy tài khoản");
	    } finally {
	        if (resultSet != null) {
	            resultSet.close();
	        }
	        dataBaseUtils.disconnect();
	    }
	    return nhanVien;
	}
	public NhanVien getNhanVienDN(int maDangNhap) throws Exception {
	    dataBaseUtils.connect();
	    NhanVien nhanVien = null; 
	    String sql = String.format("SELECT * FROM NhanVien\r\n"
	            + "WHERE maDangNhap = '%s'", maDangNhap);
	    try {
	        resultSet = dataBaseUtils.excuteQueryRead(sql);
	        resultSet.next();
	        nhanVien = new NhanVien();
	        nhanVien.setMaNV(resultSet.getInt("maNhanVien"));
	        
	        TaiKhoan taiKhoan = new TaiKhoan();
	        taiKhoan.setMaTaiKhoan((resultSet.getInt("maDangNhap")));
	        nhanVien.setTaiKhoan(taiKhoan);
	        
	        ChucVu chucVu = new ChucVu();
	        chucVu.setMaChucVu((resultSet.getInt("maChucVu")));
	        nhanVien.setChucVu(chucVu);
	        
	        nhanVien.setTenNV(resultSet.getString("tenNV"));
	        
	        nhanVien.setNgaySinh(resultSet.getString("ngaySinh"));
	        
	        nhanVien.setPhai(resultSet.getBoolean("phai"));
	        nhanVien.setSdt(resultSet.getString("sdt"));
	        nhanVien.setEmail(resultSet.getString("email"));
	        
	    } catch (Exception e) {
	        throw new Exception("Không tìm thấy tài khoản");
	    } finally {
	        if (resultSet != null) {
	            resultSet.close();
	        }
	        dataBaseUtils.disconnect();
	    }
	    return nhanVien;
	}
	public ArrayList<NhanVien> getNhanViens() throws Exception {
        ArrayList<NhanVien> nhanViens = new ArrayList<>();
        String sql = String.format("SELECT * FROM NhanVien");

        try {
            resultSet = dataBaseUtils.excuteQueryRead(sql);
            
            while (resultSet.next()) {
                ChucVu chucVu = new ChucVu(resultSet.getInt("maChucVu"));
                TaiKhoan taiKhoan = new TaiKhoan(resultSet.getInt("maDangNhap"));
                
            	NhanVien nhanVien = new NhanVien(
            			resultSet.getInt("maNhanVien"),
                		resultSet.getString("tenNV"),
                		resultSet.getString("ngaySinh"),
                		resultSet.getBoolean("phai"),
                		resultSet.getString("sdt"),
                		resultSet.getString("email"),
                		chucVu,
                		taiKhoan   
            	);
                nhanViens.add(nhanVien);
            }
        } catch (Exception e) {
            throw new Exception("Lỗi lấy danh sách nhân viên");
        } finally {
            resultSet.close();
        }

        return nhanViens;
    }
	public static NhanVienDAO getInstance() {
        if (instance == null) {
            synchronized (NhanVienDAO.class) {
                if (null == instance) {
                    instance = new NhanVienDAO();
                }
            }
        }
        return instance;
    }
}
