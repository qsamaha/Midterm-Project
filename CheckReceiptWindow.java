package co.grandcircus;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckReceiptWindow extends ReceiptWindow {
	String checkNum = "";
	
	public CheckReceiptWindow(HashMap<Product, Integer> custoMap, String checkNum) {
		super(custoMap);
		this.checkNum = checkNum;
		addCheckString();
		System.out.println("Receipt window thinks checkNum is: " + checkNum);
		
		// TODO Auto-generated constructor stub
	}
	
	public void addCheckString() {
		JPanel checkPanel = new JPanel();
		JLabel checkNumLabel = new JLabel("Check Number: " + checkNum);
		checkPanel.add(checkNumLabel);
		bigPanel.add(checkPanel);
	}
}
