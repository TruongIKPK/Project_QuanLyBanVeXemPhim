
--drop database QLBanVe;
--sp_who
--KILL 58
create database QLBanVe;
use QLBanVe
create table ChucVu(
	maChucVu int,
	tenChucVu nvarchar(15),
	PRIMARY KEY (maChucVu)
)
create table TaiKhoan(
	maDangNhap int,
	tenDangNhap char(20) UNIQUE,
	matKhau char(20),
	trangThai bit,
	PRIMARY KEY (maDangNhap)
)
create table NhanVien(
	maNhanVien int,
	maDangNhap int,
	maChucVu int,
	tenNV nvarchar(30),
	ngaySinh date,
	phai bit,
	sdt char(10) UNIQUE,
	email char(50) UNIQUE,
	PRIMARY KEY (maNhanVien),
	FOREIGN KEY (maDangNhap) REFERENCES TaiKhoan(maDangNhap),
	FOREIGN KEY (maChucVu) REFERENCES ChucVu(maChucVu)
)
create table PhongChieu(
	maPhong int,
	tenPhong nvarchar(10),
	PRIMARY KEY (maPhong)
)
create table Ghe(
	maGhe int identity,
	maPhong int,
	loaiGhe nvarchar(10),
	trangThai int,
	PRIMARY KEY (maGhe),
	FOREIGN KEY (maPhong) REFERENCES PhongChieu(maPhong)
)
create table KhachHang(
	maKhachHang int identity,
	tenKhachHang nvarchar(50),
	phai bit,
	ngaySinh date,
	sdt char(10) UNIQUE,
	diemTichLuy int,
	PRIMARY KEY (maKhachHang)
)
create table Phim(
	maPhim int IDENTITY,
	tenPhim nvarchar(50),
	ngayKhoiChieu date,
	ngayKetThuc date,
	quocGia nvarchar(15),
	thoiLuong int,
	gioiHanTuoi int,
	namSX int,
	theLoai nvarchar(60),
	hinhAnh char(50)
	PRIMARY KEY (maPhim)
)

create table SuatChieu(
	maSuatChieu int identity,
	maPhongChieu int,
	maPhim int,
	ngayChieu date,
	gioChieu time
	PRIMARY KEY (maSuatChieu),
	FOREIGN KEY (maPhim) REFERENCES Phim(maPhim),
	FOREIGN KEY (maPhongChieu) REFERENCES PhongChieu(maPhong)
)
create table HoaDonXemPhim(
	maHDXemPhim int identity,
	maNhanVien int,
	maKhachHang int,
	maSuatChieu int,
	thueVAT float,
	PRIMARY KEY (maHDXemPhim),
	FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien),
	FOREIGN KEY (maKhachHang) REFERENCES KhachHang(maKhachHang),
	FOREIGN KEY (maSuatChieu) REFERENCES SuatChieu(maSuatChieu)
)

create table VeXemPhim(
	maVeXemPhim int identity,
	maGhe int,
	maHDXemPhim int,
	giaVe money,
	PRIMARY KEY (maHDXemPhim,maGhe,maVeXemPhim),
	FOREIGN KEY (maGhe) REFERENCES Ghe(maGhe),
	FOREIGN KEY (maHDXemPhim) REFERENCES HoaDonXemPhim(maHDXemPhim)
)

create table VoucherPhim(
	maVoucherPhim int,
	maCode char(20),
	mucGiam float,
	maHDXemPhim int,
	PRIMARY KEY (maVoucherPhim),
	FOREIGN KEY (maHDXemPhim) REFERENCES HoaDonXemPhim(maHDXemPhim)
)
create table DichVu(
	maDichVu int,
	tenDichVu nvarchar(50),
	giaBang money,
	hinhAnh char(50),
	moTa nvarchar(50)
	PRIMARY KEY (maDichVu)
)

create table HoaDonDichVu(
	maDHDichVu int,
	maKhachHang int,
	maNhanVien int,
	thueVAT float,
	PRIMARY KEY (maDHDichVu),
	FOREIGN KEY (maKhachHang) REFERENCES KhachHang(maKhachHang),
	FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien)
)
create table HoaDonChiTietDichVu(
	maDHChiTietDichVu int,
	maDHDichVu int,
	maDichVu int,
	soLuong int
	PRIMARY KEY (maDHChiTietDichVu,maDHDichVu,maDichVu),
	FOREIGN KEY (maDHDichVu) REFERENCES HoaDonDichVu(maDHDichVu),
	FOREIGN KEY (maDichVu) REFERENCES DichVu(maDichVu)
)
 
create table VoucherDichVu(
	maVoucherDichVu int,
	maCode char(20),
	mucGiam float,
	maDHDichVu int
	PRIMARY KEY (maVoucherDichVu),
	FOREIGN KEY (maDHDichVu) REFERENCES HoaDonDichVu(maDHDichVu)
)

--insert into  VoucherDichVu (maVoucherDichVu,maCode,mucGiam,maDHDichVu)
--values (1, 'HSSV2024', 0.3, )

insert into ChucVu(maChucVu, tenChucVu)
values (1, N'Quản lí');
insert into TaiKhoan (maDangNhap, matKhau, tenDangNhap, trangThai) 
values (1, '12345', 'QuanLy123', 1)
insert into NhanVien (maNhanVien, maDangNhap, maChucVu,  tenNV
, email, ngaySinh, phai, sdt) 
values (1, 1, 1, N'Lê Nguyễn Phi Trường', 'Truong@gmail.com', '2004-03-21', 1, '0987654321')

insert into ChucVu(maChucVu, tenChucVu)
values (2, N'Nhân Viên');
insert into TaiKhoan (maDangNhap, matKhau, tenDangNhap, trangThai) 
values (2, '12345', 'NhanVien123', 1)
insert into NhanVien (maNhanVien, maDangNhap, maChucVu,  tenNV
, email, ngaySinh, phai, sdt) 
values (2, 2, 2, N'Võ Chí Cường', 'Cuong@gmail.com', '2004-04-21', 1, '0982543211')

insert into TaiKhoan (maDangNhap, matKhau, tenDangNhap, trangThai) 
values (3, '12345', 'TaiKhoanDong', 0)
insert into NhanVien (maNhanVien, maDangNhap, maChucVu,  tenNV
, email, ngaySinh, phai, sdt) 
values (3, 3, 2, N'Võ Chí Cường', 'Cuong1@gmail.com', '2004-04-21', 1, '0982254321')

insert into PhongChieu(maPhong, tenPhong)
values (1, 'R1'),
(2, 'R2'),
(3, 'R3'),
(4, 'R4'),
(5, 'R5')

INSERT INTO Ghe (loaiGhe, maPhong, trangThai)
VALUES 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), 
(N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1), (N'Thường', 1, 1),
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), 
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), 
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), 
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), 
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), 
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), 
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), 
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), 
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), 
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), 
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), 
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), 
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), 
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), 
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), 
(N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1), (N'VIP', 1, 1),
(N'Đôi', 1, 1), (N'Đôi', 1, 1), (N'Đôi', 1, 1), (N'Đôi', 1, 1), 
(N'Đôi', 1, 1), (N'Đôi', 1, 1), (N'Đôi', 1, 1), (N'Đôi', 1, 1);

INSERT INTO Ghe (loaiGhe, maPhong, trangThai)
VALUES 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), 
(N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1), (N'Thường', 2, 1),
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), 
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), 
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), 
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), 
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), 
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), 
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), 
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), 
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), 
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), 
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), 
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), 
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), 
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), 
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), 
(N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1), (N'VIP', 2, 1),
(N'Đôi', 2, 1), (N'Đôi', 2, 1), (N'Đôi', 2, 1), (N'Đôi', 2, 1), 
(N'Đôi', 2, 1), (N'Đôi', 2, 1), (N'Đôi', 2, 1), (N'Đôi', 2, 1);

INSERT INTO Ghe (loaiGhe, maPhong, trangThai)
VALUES 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), 
(N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1), (N'Thường', 3, 1),
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), 
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), 
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), 
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), 
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), 
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), 
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), 
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), 
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), 
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), 
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), 
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), 
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), 
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), 
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), 
(N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1), (N'VIP', 3, 1),
(N'Đôi', 3, 1), (N'Đôi', 3, 1), (N'Đôi', 3, 1), (N'Đôi', 3, 1), 
(N'Đôi', 3, 1), (N'Đôi', 3, 1), (N'Đôi', 3, 1), (N'Đôi', 3, 1);

INSERT INTO Ghe (loaiGhe, maPhong, trangThai)
VALUES 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), 
(N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1), (N'Thường', 4, 1),
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), 
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), 
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), 
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), 
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), 
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), 
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), 
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), 
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), 
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), 
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), 
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), 
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), 
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), 
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), 
(N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1), (N'VIP', 4, 1),
(N'Đôi', 4, 1), (N'Đôi', 4, 1), (N'Đôi', 4, 1), (N'Đôi', 4, 1), 
(N'Đôi', 4, 1), (N'Đôi', 4, 1), (N'Đôi', 4, 1), (N'Đôi', 4, 1);

INSERT INTO Ghe (loaiGhe, maPhong, trangThai)
VALUES 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), 
(N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1), (N'Thường', 5, 1),
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), 
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), 
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), 
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), 
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), 
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), 
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), 
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), 
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), 
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), 
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), 
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), 
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), 
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), 
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), 
(N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1), (N'VIP', 5, 1),
(N'Đôi', 5, 1), (N'Đôi', 5, 1), (N'Đôi', 5, 1), (N'Đôi', 5, 1), 
(N'Đôi', 5, 1), (N'Đôi', 5, 1), (N'Đôi', 5, 1), (N'Đôi', 5, 1);

insert into DichVu (maDichVu, tenDichVu, giaBang, hinhAnh, moTa)
values 
(1, N'PEANUTS SINGLE COMBO', 19900000, '/images/dichvu1.png', N'01 ly nhân vật Peanuts (kèm nước)'),
(2, N'PEANUTS COUPLE COMBO', 379000, '/images/dichvu2.png', N'02 ly nhân vật Garfield (kèm nước)'),
(4, N'PEANUTS TRIPPLE COMBO', 539000, '/images/dichvu3.png', N'03 ly nhân vật Peanuts (kèm nước)'),
(5, N'GARFIELD TRIPPLE COMBO', 539000, '/images/dichvu4.png', N'03 ly nhân vật Peanuts (kèm nước)'),
(3, N'MY COMBO', 87000, '/images/dichvu5.png', N'1 bắp lớn + 1 nước siêu lớn.')



SELECT * FROM TaiKhoan join NhanVien
on TaiKhoan.maDangNhap = NhanVien.maDangNhap 
WHERE tenDangNhap = 'QuanLy123'

SELECT * FROM TaiKhoan WHERE tenDangNhap = 'Truong123'
SELECT * FROM ChucVu 
SELECT * FROM DichVu
select * from Phim
select * from SuatChieu
SELECT * FROM SuatChieu where ngayChieu = '2024-01-01'
ORDER BY SuatChieu.NgayChieu ASC, SuatChieu.GioChieu ASC
select * from KhachHang
select * from HoaDonXemPhim
select * from VeXemPhim
SELECT maVeXemPhim, maGhe, HoaDonXemPhim.maHDXemPhim, giaVe FROM VeXemPhim inner join HoaDonXemPhim on VeXemPhim.maHDXemPhim = HoaDonXemPhim.maHDXemPhim where maSuatChieu = 4
