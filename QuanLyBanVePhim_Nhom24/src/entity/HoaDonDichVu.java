package entity;

import java.util.Objects;

public class HoaDonDichVu {
	private int maDHDichVu;
	private int maKhachHang;
	private int maNhanVien;
	private double thue;
	
	public HoaDonDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getThue() {
		return thue;
	}
	public void setThue(double thue) {
		this.thue = thue;
	}
	public HoaDonDichVu(int maDHDichVu, int maKhachHang, int maNhanVien, double thue) {
		super();
		this.maDHDichVu = maDHDichVu;
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
		this.thue = thue;
	}
	public HoaDonDichVu(int maDHDichVu, int maNhanVien, double thue) {
		super();
		this.maDHDichVu = maDHDichVu;
		this.maNhanVien = maNhanVien;
		this.thue = thue;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDHDichVu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonDichVu other = (HoaDonDichVu) obj;
		return maDHDichVu == other.maDHDichVu;
	}
	public int getMaDHDichVu() {
		return maDHDichVu;
	}
	public void setMaDHDichVu(int maDHDichVu) {
		this.maDHDichVu = maDHDichVu;
	}
	public int getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public int getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	
}
