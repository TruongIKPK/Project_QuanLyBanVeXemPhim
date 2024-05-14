package entity;

public class Phim {
	private int maPhim;
	private String tenPhim;
	private String quocGia;
	private int thoiLuong;
	private String ngayKhoiChieu;
	private String ngayKetThuc;
	private int gioiHanTuoi;
	private int namSX;
	private String theLoai;
	private String hinhAnh;
	
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public Phim() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Phim(int maPhim) {
		super();
		this.maPhim = maPhim;
	}
	public Phim(String tenPhim, String quocGia, int thoiLuong, String ngayKhoiChieu, String ngayKetThuc,
			int gioiHanTuoi, int namSX, String theLoai, String hinhAnh) {
		super();
		this.tenPhim = tenPhim;
		this.quocGia = quocGia;
		this.thoiLuong = thoiLuong;
		this.ngayKhoiChieu = ngayKhoiChieu;
		this.ngayKetThuc = ngayKetThuc;
		this.gioiHanTuoi = gioiHanTuoi;
		this.namSX = namSX;
		this.theLoai = theLoai;
		this.hinhAnh = hinhAnh;
	}
	
	public Phim(int maPhim, String tenPhim, String quocGia, int thoiLuong, String ngayKhoiChieu, String ngayKetThuc,
			int gioiHanTuoi, int namSX, String theLoai, String hinhAnh) {
		super();
		this.maPhim = maPhim;
		this.tenPhim = tenPhim;
		this.quocGia = quocGia;
		this.thoiLuong = thoiLuong;
		this.ngayKhoiChieu = ngayKhoiChieu;
		this.ngayKetThuc = ngayKetThuc;
		this.gioiHanTuoi = gioiHanTuoi;
		this.namSX = namSX;
		this.theLoai = theLoai;
		this.hinhAnh = hinhAnh;
	}
	public int getMaPhim() {
		return maPhim;
	}
	public void setMaPhim(int maPhim) {
		this.maPhim = maPhim;
	}
	public String getTenPhim() {
		return tenPhim;
	}
	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}
	public String getQuocGia() {
		return quocGia;
	}
	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}
	public int getThoiLuong() {
		return thoiLuong;
	}
	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}
	public String getNgayKhoiChieu() {
		return ngayKhoiChieu;
	}
	public void setNgayKhoiChieu(String ngayKhoiChieu) {
		this.ngayKhoiChieu = ngayKhoiChieu;
	}
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public int getGioiHanTuoi() {
		return gioiHanTuoi;
	}
	public void setGioiHanTuoi(int gioiHanTuoi) {
		this.gioiHanTuoi = gioiHanTuoi;
	}
	public int getNamSX() {
		return namSX;
	}
	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maPhim;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phim other = (Phim) obj;
		if (maPhim != other.maPhim)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Phim [maPhim=" + maPhim + ", tenPhim=" + tenPhim + ", quocGia=" + quocGia + ", thoiLuong=" + thoiLuong
				+ ", ngayKhoiChieu=" + ngayKhoiChieu + ", ngayKetThuc=" + ngayKetThuc + ", gioiHanTuoi=" + gioiHanTuoi
				+ ", namSX=" + namSX + ", theLoai=" + theLoai + ", hinhAnh=" + hinhAnh + "]";
	}
	
}
