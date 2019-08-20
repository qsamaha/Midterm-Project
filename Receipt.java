package co.grandcircus;

import java.util.ArrayList;

public class Receipt {
	ArrayList<Product> receipt = new ArrayList<>();

	public Receipt(ArrayList<Product> receipt) {
		
		this.receipt = receipt;
	}
	
	public double getSubTotal() {
		double sum = 0;
		for (Product prod : receipt) {
			sum += prod.getPrice();	
		}
		return sum;
	}
	
	public double getTax (double subTotal) {
		double tax = subTotal * 0.06;
		return tax;
	
	}
	
	public double total (double subTotal) {
	    double tax = getTax(subTotal);
		return subTotal + tax;
	}

	public void printReceipt() {
		for (Product prod : receipt) {
			System.out.printf("%-30s", prod.getName());
			System.out.printf(prod.getPrice() + "\n");	
		}
		System.out.println("======================================");
		System.out.printf("%-30s", "Subtotal: ");
		System.out.printf("%-30s\n", getSubTotal());
		System.out.printf("%-30s", "Tax: ");
		System.out.printf("%.2f\n", getTax(getSubTotal()));
		System.out.printf("%-30s", "Total: ");
		System.out.printf("%.2f\n", total(getSubTotal()));
		
	}
	@Override
	public String toString() {
		
		return "Subtotal: " + getSubTotal() + "Total: " + total(getSubTotal());
	}
	
}
