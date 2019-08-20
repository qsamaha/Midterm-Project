package co.grandcircus;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CashReceiptWindow extends ReceiptWindow {
	String amtPaid = "";
	
	public CashReceiptWindow(HashMap<Product, Integer> custoMap, String amtPaid) {
		super(custoMap);
		this.amtPaid = amtPaid;
		addCashString();
	}
	
	public void addCashString() {
		
		JPanel cashInfoPanel = new JPanel();
		
		JPanel cashPanel = new JPanel();
		JLabel cashLabel = new JLabel("Amount tendered: " + amtPaid);
		cashPanel.add(cashLabel);
		double total = total(getSubTotal());
		double change = Double.parseDouble(amtPaid) - total;
		JLabel changeLabel = new JLabel("Change due: " + String.format("%.2f", change));
		cashPanel.add(changeLabel);
		
		cashInfoPanel.add(cashLabel);
		cashInfoPanel.add(changeLabel);
		bigPanel.add(cashInfoPanel);
		
	}
}
