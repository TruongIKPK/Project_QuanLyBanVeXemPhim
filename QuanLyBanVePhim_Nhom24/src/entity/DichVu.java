package entity;

import java.util.Objects;

public class DichVu {
	private int maDichVu;
	private String tenDichVu;
	private double giaBan;
	private String hinhAnh;
	private String moTa;
	
	public DichVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DichVu(int maDichVu) {
		super();
		this.maDichVu = maDichVu;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public DichVu(int maDichVu, String tenDichVu, double giaBan, String hinhAnh, String moTa) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.giaBan = giaBan;
		this.hinhAnh = hinhAnh;
		this.moTa = moTa;
	}
	public int getMaDichVu() {
		return maDichVu;
	}
	
	public void setMaDichVu(int maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDichVu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return maDichVu == other.maDichVu;
	}
	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", giaBan=" + giaBan + "]";
	}

	
	
}
