package co.grandcircus;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class CheckCheckoutWindow {
	
	//having access to the inventory will allow this class to find the amount due
	Inventory inv = new Inventory();
	
	JLabel totalLabel = new JLabel("Amount due: $");
	JLabel total = new JLabel();
	JFrame frame = new JFrame("Checkout");
	JPanel panel = new JPanel(new SpringLayout());
	JLabel checkLabel = new JLabel("Check number: ");
	JTextField checkField = new JTextField();
	JButton checkoutButton = new JButton("Checkout");
	JLabel emptyLabel = new JLabel();

	private HashMap<Product, Integer> custoMap;
	
public CheckCheckoutWindow(HashMap<Product, Integer> custoMap) {	
	//SpringUtilities.makeCompactGrid(panel, 3, 2, 6, 6, 6, 6);
	this.custoMap = custoMap;
	
	String totalString = String.format("%.2f", getTotal());
	total.setText(totalString);
	
	panel.add(totalLabel);
	panel.add(total);
	panel.add(checkLabel);
	panel.add(checkField);
	panel.add(emptyLabel);
	panel.add(checkoutButton);
	
	
	
	SpringUtilities.makeCompactGrid(panel,
            3, 2, //rows, cols
            6, 6,        //initX, initY
            6, 6);       //xPad, yPad
	
	frame.add(panel);
	frame.setPreferredSize(new Dimension(225,115));
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	
	checkoutButton.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
        	
        	if (!checkField.getText().matches("\\d{9}")) {
				JOptionPane.showMessageDialog(panel, "Check number must be 9 digits", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				String checkNum = checkField.getText();
				System.out.println(checkNum);
				new CheckReceiptWindow(custoMap, checkNum);
			}	
        }  
    });
}

public double getTotal() {
	double sum = 0;
	for (Product prod : custoMap.keySet()) {
		int quantity = custoMap.get(prod);
		double costOfItems = prod.getPrice() * quantity;
		sum += costOfItems;
	}
	return sum * 1.06; //accounting for tax, which will be shown in the receipt
}
}