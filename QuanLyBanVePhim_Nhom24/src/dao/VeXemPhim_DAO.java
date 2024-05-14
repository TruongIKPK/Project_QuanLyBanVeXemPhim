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
import entity.VeXemPhim;

public class VeXemPhim_DAO {
	private ResultSet resultSet;
	private ConnectDB dataBaseUtils;
	private static VeXemPhim_DAO instance;
	
	public VeXemPhim_DAO(){
        super();
        this.dataBaseUtils = new ConnectDB(); 
    }
	public static VeXemPhim_DAO getInstance() {
        if (instance == null) {
            synchronized (VeXemPhim_DAO.class) {
                if (null == instance) {
                    instance = new VeXemPhim_DAO();
                }
            }
        }
        return instance;
    }
	public boolean addVeXemPhim(VeXemPhim vexemPhim) throws ClassNotFoundException {
		try (Connection con = dataBaseUtils.connect()) {
	    	PreparedStatement stmt = con.prepareStatement("insert into VeXemPhim (maGhe, maHDXemPhim, giaVe) "
					+ "values (? ,? , ?)"); 	
			stmt.setInt(1, vexemPhim.getGhe().getMaGhe());
			stmt.setInt(2, vexemPhim.getHdXemPhim().getMaHDXemPhim());
			stmt.setDouble(3, vexemPhim.getGiaVe());
			int n = stmt.executeUpdate();
	        return n > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public ArrayList<VeXemPhim> dsVeDaDat(int maSuatChieu) throws Exception{
		ArrayList<VeXemPhim> dsVe = new ArrayList<>();
		String sql = "SELECT maVeXemPhim, maGhe, HoaDonXemPhim.maHDXemPhim, giaVe FROM VeXemPhim "
				+ "inner join HoaDonXemPhim on VeXemPhim.maHDXemPhim = HoaDonXemPhim.maHDXemPhim where maSuatChieu = " + maSuatChieu;
		try {
        	dataBaseUtils.connect();
            resultSet = dataBaseUtils.excuteQueryRead(sql); 
            while (resultSet.next()) {
            	VeXemPhim vePhim = null;
            	int maVP = resultSet.getInt("maVeXemPhim");
            	Ghe ghe = new Ghe(resultSet.getInt("maGhe"));
            	HoaDonXemPhim hdPhim = new HoaDonXemPhim(resultSet.getInt("maHDXemPhim"));
                double giaVe = resultSet.getDouble("giaVe");
                vePhim = new VeXemPhim(maVP, hdPhim, giaVe, ghe);
                dsVe.add(vePhim);
            }
        } catch (Exception e) {
            throw new Exception("Lỗi lấy danh sách vé");
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
		return dsVe;
	}
}
