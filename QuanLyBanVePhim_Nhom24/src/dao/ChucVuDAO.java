package dao;

import java.sql.ResultSet;

import connect.ConnectDB;
import entity.ChucVu;

public class ChucVuDAO {

	private ResultSet resultSet;
	private ConnectDB dataBaseUtils;
	private static ChucVuDAO instance;
	
	public ChucVuDAO() {
        super();
        this.dataBaseUtils = new ConnectDB(); 
    }

	public ChucVu getChucVu(int maChucVu) throws Exception {
	    dataBaseUtils.connect();
	    ChucVu chucVu = null;
	    String sql = String.format("SELECT * FROM ChucVu\r\n"
	            + "WHERE maChucVu = '%s'", maChucVu);
		try {
	        resultSet = dataBaseUtils.excuteQueryRead(sql);
	        resultSet.next();
	        chucVu = new ChucVu();
	        chucVu.setMaChucVu(resultSet.getInt("maChucVu"));
	        chucVu.setTenChucVu(resultSet.getString("tenChucVu"));  
	    } catch (Exception e) {
	        throw new Exception("Không tìm thấy tài khoản");
	    } finally {
	        if (resultSet != null) {
	            resultSet.close();
	        }
	        dataBaseUtils.disconnect();
	    }
	    return chucVu;
	}
	
	public static ChucVuDAO getInstance() {
        if (instance == null) {
            synchronized (ChucVuDAO.class) {
                if (null == instance) {
                    instance = new ChucVuDAO();
                }
            }
        }
        return instance;
    }
	
}
