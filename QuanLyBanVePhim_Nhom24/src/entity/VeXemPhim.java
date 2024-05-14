package entity;

public class VeXemPhim {
	private int maVeXemPhim;
	private HoaDonXemPhim hdXemPhim;
	private double giaVe;
	private Ghe ghe;
	public VeXemPhim() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VeXemPhim(int maVeXemPhim, HoaDonXemPhim hdXemPhim, double giaVe, Ghe ghe) {
		super();
		this.maVeXemPhim = maVeXemPhim;
		this.hdXemPhim = hdXemPhim;
		this.giaVe = giaVe;
		this.ghe = ghe;
	}
	public VeXemPhim(int maVeXemPhim, HoaDonXemPhim hdXemPhim) {
		super();
		this.maVeXemPhim = maVeXemPhim;
		this.hdXemPhim = hdXemPhim;
	}
	
	public VeXemPhim(HoaDonXemPhim hdXemPhim, double giaVe, Ghe ghe) {
		super();
		this.hdXemPhim = hdXemPhim;
		this.giaVe = giaVe;
		this.ghe = ghe;
	}
	@Override
	public String toString() {
		return "VeXemPhim [maVeXemPhim=" + maVeXemPhim + ", hdXemPhim=" + hdXemPhim + ", giaVe=" + giaVe + ", ghe="
				+ ghe + "]";
	}
	public int getMaVeXemPhim() {
		return maVeXemPhim;
	}
	public void setMaVeXemPhim(int maVeXemPhim) {
		this.maVeXemPhim = maVeXemPhim;
	}
	public HoaDonXemPhim getHdXemPhim() {
		return hdXemPhim;
	}
	public void setHdXemPhim(HoaDonXemPhim hdXemPhim) {
		this.hdXemPhim = hdXemPhim;
	}
	public double getGiaVe() {
		return giaVe;
	}
	public void setGiaVe(double giaVe) {
		this.giaVe = giaVe;
	}
	public Ghe getGhe() {
		return ghe;
	}
	public void setGhe(Ghe ghe) {
		this.ghe = ghe;
	}
	public VeXemPhim(int maVeXemPhim) {
		super();
		this.maVeXemPhim = maVeXemPhim;
	}
	
	
	
}
