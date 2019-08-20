package co.grandcircus;

import java.util.ArrayList;

public class CheckReceipt extends Receipt {
	String checkNumber;

	public CheckReceipt(ArrayList<Product> receipt) {
		super(receipt);

	}

	public CheckReceipt(ArrayList<Product> receipt, String checkNumber) {
		super(receipt);
		this.checkNumber = checkNumber;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	@Override
	public void printReceipt() {
		super.printReceipt();
		System.out.println("Paid with Check: " + checkNumber);

	}

}
