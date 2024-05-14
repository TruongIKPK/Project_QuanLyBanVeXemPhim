package entity;

import java.util.Objects;

public class Voucher {
	private int maVoucher;
	private double mucGiam;
	public Voucher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Voucher(int maVoucher, double mucGiam) {
		super();
		this.maVoucher = maVoucher;
		this.mucGiam = mucGiam;
	}
	public Voucher(int maVoucher) {
		super();
		this.maVoucher = maVoucher;
	}
	public int getMaVoucher() {
		return maVoucher;
	}
	public void setMaVoucher(int maVoucher) {
		this.maVoucher = maVoucher;
	}
	public double getMucGiam() {
		return mucGiam;
	}
	public void setMucGiam(double mucGiam) {
		this.mucGiam = mucGiam;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maVoucher);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voucher other = (Voucher) obj;
		return maVoucher == other.maVoucher;
	}
	@Override
	public String toString() {
		return "Voucher [maVoucher=" + maVoucher + ", mucGiam=" + mucGiam + "]";
	}
	
	
}
