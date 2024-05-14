package entity;

import java.util.Objects;

public class KhachHang {
	private int maKhachHang;
	private String tenKhachHang;
	private boolean phai;
	private String ngaySinh;
	private String sdt;
	private int diemTichLuy;
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(int maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}
	
	public KhachHang(int maKhachHang, int diemTichLuy) {
		super();
		this.maKhachHang = maKhachHang;
		this.diemTichLuy = diemTichLuy;
	}
	public KhachHang(int maKhachHang, String tenKhachHang, boolean phai, String ngaySinh, String sdt, int diemTichLuy) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.phai = phai;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.diemTichLuy = diemTichLuy;
	}
	
	public KhachHang(String tenKhachHang, boolean phai, String ngaySinh, String sdt) {
		super();
		this.tenKhachHang = tenKhachHang;
		this.phai = phai;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
	}
	public int getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public boolean isPhai() {
		return phai;
	}
	public void setPhai(boolean phai) {
		this.phai = phai;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public int getDiemTichLuy() {
		return diemTichLuy;
	}
	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return maKhachHang == other.maKhachHang;
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", phai=" + phai
				+ ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + ", diemTichLuy=" + diemTichLuy + "]";
	}
	
	
}	
