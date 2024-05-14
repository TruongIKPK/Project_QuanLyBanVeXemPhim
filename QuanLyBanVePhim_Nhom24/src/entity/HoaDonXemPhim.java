package entity;

import java.util.ArrayList;
import java.util.Objects;

public class HoaDonXemPhim {
	private int maHDXemPhim;
	private SuatChieu suatchieu;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private double thue;
	
	public HoaDonXemPhim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDonXemPhim(int maHDXemPhim) {
		super();
		this.maHDXemPhim = maHDXemPhim;
	}
	
	public HoaDonXemPhim(KhachHang khachHang, NhanVien nhanVien, SuatChieu suatchieu) {
		super();
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.suatchieu = suatchieu;
	}
	
	public HoaDonXemPhim(int maHDXemPhim, SuatChieu suatchieu, NhanVien nhanVien, KhachHang khachHang, double thue) {
		super();
		this.maHDXemPhim = maHDXemPhim;
		this.suatchieu = suatchieu;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.thue = thue;
	}

	public int getMaHDXemPhim() {
		return maHDXemPhim;
	}

	public void setMaHDXemPhim(int maHDXemPhim) {
		this.maHDXemPhim = maHDXemPhim;
	}

	public SuatChieu getSuatchieu() {
		return suatchieu;
	}

	public void setSuatchieu(SuatChieu suatchieu) {
		this.suatchieu = suatchieu;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHDXemPhim);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonXemPhim other = (HoaDonXemPhim) obj;
		return maHDXemPhim == other.maHDXemPhim;
	}

	@Override
	public String toString() {
		return "HoaDonXemPhim [maHDXemPhim=" + maHDXemPhim + ", suatchieu=" + suatchieu + ", nhanVien=" + nhanVien
				+ ", khachHang=" + khachHang + ", thue=" + thue + "]";
	}
	public int soLuongHoaDon() {
		return 0;
	}
}
