package co.grandcircus;

import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardReceiptWindow extends ReceiptWindow {
	String cardNum = "";
	String expDate = "";
	String CVV = "";
	
	public CardReceiptWindow(HashMap<Product, Integer> custoMap, String cardNum, String expDate, String CVV) {
		super(custoMap);
		this.cardNum = cardNum;
		this.expDate = expDate;
		this.CVV = CVV;
		addCardString();
		
		// TODO Auto-generated constructor stub
	}
	
	public void addCardString() {
		JPanel cardPanel = new JPanel();
		JLabel cardNumLabel = new JLabel("Card Number: " + cardNum);
		JPanel cardNumPanel = new JPanel();
		cardNumPanel.add(cardNumLabel);
		bigPanel.add(cardNumPanel);
		JLabel expDateLabel = new JLabel("Expires: " + expDate + "   ");
		cardPanel.add(expDateLabel);
		JLabel CVVLabel = new JLabel("CVV: " + CVV);
		cardPanel.add(CVVLabel);
		bigPanel.add(cardPanel);
	}
}
