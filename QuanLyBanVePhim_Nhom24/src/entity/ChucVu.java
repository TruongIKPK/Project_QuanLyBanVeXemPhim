package entity;

import java.util.Objects;

public class ChucVu {
	private int maChucVu;
	private String tenChucVu;
	public ChucVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChucVu(int maChucVu) {
		super();
		this.maChucVu = maChucVu;
	}
	public ChucVu(int maChucVu, String tenChucVu) {
		super();
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
	}
	public int getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(int maChucVu) {
		this.maChucVu = maChucVu;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maChucVu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChucVu other = (ChucVu) obj;
		return maChucVu == other.maChucVu;
	}
	@Override
	public String toString() {
		return "ChucVu [maChucVu=" + maChucVu + ", tenChucVu=" + tenChucVu + "]";
	}
	
	
}
