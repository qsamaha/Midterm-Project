package co.grandcircus;

import java.util.ArrayList;

public class CardReciept extends Receipt {
	String cardNum;
	String cardExpire;
	String cardCVV;

	public CardReciept(ArrayList<Product> receipt, String cardNum, String cardExpire, String cardCVV) {
		super(receipt);
		this.cardNum = cardNum;
		this.cardExpire = cardExpire;
		this.cardCVV = cardCVV;
	}

	public CardReciept(ArrayList<Product> receipt) {
		super(receipt);
		// TODO Auto-generated constructor stub
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardExpire() {
		return cardExpire;
	}

	public void setCardExpire(String cardExpire) {
		this.cardExpire = cardExpire;
	}

	public String getCardCVV() {
		return cardCVV;
	}

	public void setCardCVV(String cardCVV) {
		this.cardCVV = cardCVV;
	}

	@Override
	public void printReceipt() {
		super.printReceipt();
		System.out.println("Paid with Card: \n" + (cardNum) + "  " + (cardExpire) + "  " + (cardCVV));
	}

}
