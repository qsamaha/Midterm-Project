package co.grandcircus;

import java.util.ArrayList;

public class CashReceipt extends Receipt {

	double amountPaid;

	public CashReceipt(ArrayList<Product> receipt, double amountPaid) {
		super(receipt);
		this.amountPaid = amountPaid;
	}

	public CashReceipt(ArrayList<Product> receipt) {
		super(receipt);
	// TODO Auto-generated constructor stub
	}
	public double getChange(){
		double change = amountPaid - super.total(this.getSubTotal());
		return change;
	}

	@Override
	public void printReceipt () {
		super.printReceipt();
		System.out.print("Amount Paid: " + amountPaid + "\nChange: " + String.format("%.2f",getChange()));
	}
}
