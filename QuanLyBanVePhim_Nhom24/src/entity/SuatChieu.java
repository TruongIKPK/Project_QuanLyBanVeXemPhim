package entity;

import java.util.Objects;

public class SuatChieu {
	private int maSuatChieu;
	private String ngayChieu;
	private String gioChieu;
	private Phim phim;
	private PhongChieu phongChieu;
	public SuatChieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SuatChieu(int maSuatChieu) {
		super();
		this.maSuatChieu = maSuatChieu;
	}
	public SuatChieu(int maSuatChieu, String ngayChieu, String gioChieu, Phim phim, PhongChieu phongChieu) {
		super();
		this.maSuatChieu = maSuatChieu;
		this.ngayChieu = ngayChieu;
		this.gioChieu = gioChieu;
		this.phim = phim;
		this.phongChieu = phongChieu;
	}
	public int getMaSuatChieu() {
		return maSuatChieu;
	}
	public void setMaSuatChieu(int maSuatChieu) {
		this.maSuatChieu = maSuatChieu;
	}
	public String getNgayChieu() {
		return ngayChieu;
	}
	public void setNgayChieu(String ngayChieu) {
		this.ngayChieu = ngayChieu;
	}
	public String getGioChieu() {
		return gioChieu;
	}
	public void setGioChieu(String gioChieu) {
		this.gioChieu = gioChieu;
	}
	public Phim getPhim() {
		return phim;
	}
	public void setPhim(Phim phim) {
		this.phim = phim;
	}
	public PhongChieu getPhongChieu() {
		return phongChieu;
	}
	public void setPhongChieu(PhongChieu phongChieu) {
		this.phongChieu = phongChieu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSuatChieu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuatChieu other = (SuatChieu) obj;
		return maSuatChieu == other.maSuatChieu;
	}
	@Override
	public String toString() {
		return "SuatChieu [maSuatChieu=" + maSuatChieu + ", ngayChieu=" + ngayChieu + ", gioChieu=" + gioChieu
				+ ", phim=" + phim + ", phongChieu=" + phongChieu + "]";
	}
	
	
}
