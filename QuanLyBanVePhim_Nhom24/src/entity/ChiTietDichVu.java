package entity;

import java.util.Objects;

public class ChiTietDichVu {
	private int maDHChiTietDichVu;
	private int maDHDichVu;
	private int maDichVu;
	private int soLuong;
	public ChiTietDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietDichVu(int maDHChiTietDichVu, int maDHDichVu, int maDichVu, int soLuong) {
		super();
		this.maDHChiTietDichVu = maDHChiTietDichVu;
		this.maDHDichVu = maDHDichVu;
		this.maDichVu = maDichVu;
		this.soLuong = soLuong;
	}
	public ChiTietDichVu(int maDichVu, int soLuong) {
		super();
		this.maDichVu = maDichVu;
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "ChiTietDichVu [maDHChiTietDichVu=" + maDHChiTietDichVu + ", maDHDichVu=" + maDHDichVu + ", maDichVu="
				+ maDichVu + ", soLuong=" + soLuong + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDHChiTietDichVu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDichVu other = (ChiTietDichVu) obj;
		return maDHChiTietDichVu == other.maDHChiTietDichVu;
	}
	public int getMaDHChiTietDichVu() {
		return maDHChiTietDichVu;
	}
	public void setMaDHChiTietDichVu(int maDHChiTietDichVu) {
		this.maDHChiTietDichVu = maDHChiTietDichVu;
	}
	public int getMaDHDichVu() {
		return maDHDichVu;
	}
	public void setMaDHDichVu(int maDHDichVu) {
		this.maDHDichVu = maDHDichVu;
	}
	public int getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(int maDichVu) {
		this.maDichVu = maDichVu;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
}
