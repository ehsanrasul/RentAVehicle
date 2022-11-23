package BussinessLogic;

public class Discount {

	private double discountPercentage ;
	
	public Discount() {} 
	
	public Discount(double discountPercentage) {
		super();
		this.discountPercentage = discountPercentage;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
		
}
