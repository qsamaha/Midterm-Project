package co.grandcircus;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class ReceiptWindow {

	private HashMap<Product, Integer> custoMap;
	JFrame frame;
	JPanel bigPanel; //if it doesn't work, look here first
	
	public ReceiptWindow(HashMap<Product, Integer> custoMap) {
		super();
		FlowLayout layout = new FlowLayout();
		this.custoMap = custoMap;
		this.frame = new JFrame("Receipt");
		this.bigPanel = new JPanel();
		bigPanel.setLayout(layout);
		ArrayList<JPanel> panelList = buildString();
		for (JPanel panel : panelList) {
			
			bigPanel.add(panel);
		}
		//JLabel receiptLabel = new JLabel(receipt);
		//panel.add(receiptLabel);
		frame.add(bigPanel);
		frame.setPreferredSize(new Dimension(300,500));
		frame.pack();
		frame.show();
	}
	
	public ArrayList<JPanel> buildString() {
		ArrayList<JPanel> panelList = new ArrayList<>();
		
		for (Product key : custoMap.keySet()) {
			JPanel newPanel1 = new JPanel();
			JPanel newPanel2 = new JPanel();
			newPanel1.add(new JLabel(String.format("%-30s", key.getName())));
			newPanel1.add(new JLabel((Double.toString(key.getPrice()))));
			newPanel2.add(new JLabel(Integer.toString(custoMap.get(key)) + "\n")); //print quantity
			double itemSubtotal = custoMap.get(key) * key.getPrice();
			newPanel2.add(new JLabel(String.format("%.2f", itemSubtotal)));
			panelList.add(newPanel1);
			newPanel2.setLayout(new FlowLayout(FlowLayout.TRAILING));
			panelList.add(newPanel2);
		}
		JPanel dividerPanel = new JPanel();
		JPanel subtotalPanel = new JPanel();
		JPanel taxPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		
		dividerPanel.add(new JLabel("========================================================================================================\n"));
		subtotalPanel.add(new JLabel(String.format("%-30s", "Subtotal: ") + String.format("%.2f", getSubTotal())));
		//bottomPanel.add(new JLabel (String.format("%-30s\n", )));
		taxPanel.add(new JLabel (String.format("%-30s", "Tax: " ) + String.format("%.2f", getTax(getSubTotal()))));
		//bottomPanel.add(new JLabel (String.format("%.2f\n", ))));
		bottomPanel.add(new JLabel (String.format("%-30s", "Total: " + String.format("%.2f", total(getSubTotal())))));
		//bottomPanel.add(new JLabel (String.format("%.2f\n", ))));
		panelList.add(dividerPanel);
		panelList.add(subtotalPanel);
		panelList.add(taxPanel);
		panelList.add(bottomPanel);

		return panelList;
	}
	
	public double getSubTotal() {
		double sum = 0;
		for (Product key : custoMap.keySet()) {
			sum += (key.getPrice() * custoMap.get(key));
		}
		return sum;
	}
	
	public double getTax(double subTotal) {
		return subTotal * 0.06;
	}
	
	public double total(double subTotal) {
		return subTotal * 1.06;
	}
	
}
