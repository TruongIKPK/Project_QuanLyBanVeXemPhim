package entity;

import java.util.Objects;

public class TaiKhoan {
	private int maTaiKhoan;
	private String tenDangNhap;
	private String matKhau;
	private boolean kichHoat;
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(int maTaiKhoan) {
		super();
		this.maTaiKhoan = maTaiKhoan;
	}

	public TaiKhoan(int maTaiKhoan, String tenDangNhap, String matKhau, boolean kichHoat) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.kichHoat = kichHoat;
	}
	public int getMaTaiKhoan() {
		return maTaiKhoan;
	}
	public void setMaTaiKhoan(int maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public boolean isKichHoat() {
		return kichHoat;
	}
	public void setKichHoat(boolean kichHoat) {
		this.kichHoat = kichHoat;
	}
	@Override
	public String toString() {
		return "TaiKhoan [tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", kichHoat=" + kichHoat + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maTaiKhoan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return maTaiKhoan == other.maTaiKhoan;
	}
	
}
