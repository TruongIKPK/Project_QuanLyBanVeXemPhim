package dao;

import java.sql.ResultSet;

import connect.ConnectDB;
import entity.Phim;
import entity.PhongChieu;

	public class PhongChieuDAO {
		private static PhongChieuDAO instance;
		private ResultSet resultSet;
		private ConnectDB dataBaseUtils;
		
		public PhongChieuDAO() {
			super();
			this.dataBaseUtils = new ConnectDB(); 
		}
		public PhongChieu timPhong(int maPhongChieu) throws Exception {
		    String sql = "SELECT * FROM PhongChieu where maPhong = "+ maPhongChieu;
		    PhongChieu phongChieu = null;
		    try {
		        dataBaseUtils.connect();
		        resultSet = dataBaseUtils.excuteQueryRead(sql);
		        while (resultSet.next()) {
		        	 phongChieu = new PhongChieu(
		                resultSet.getInt("maPhong"),
		                resultSet.getString("tenPhong")
		            );
		        }
		    } catch (Exception e) {
		        throw new Exception("Lỗi lấy phòng chiếu", e); 
		    } finally {
		        if (resultSet != null) {
		            resultSet.close();
		        }
		        dataBaseUtils.disconnect();
		    }
		    return phongChieu;
		}
		public static PhongChieuDAO getInstance() {
	        if (instance == null) {
	            synchronized (PhongChieuDAO.class) {
	                if (null == instance) {
	                    instance = new PhongChieuDAO();
	                }
	            }
	        }
	        return instance;
	    }
}
