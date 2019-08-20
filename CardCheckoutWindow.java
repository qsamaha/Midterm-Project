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

public class CardCheckoutWindow {

	JFrame frame = new JFrame("Checkout");
	JPanel panel = new JPanel(new SpringLayout());

	JLabel totalLabel = new JLabel("Amount due: $");
	JLabel total = new JLabel();
	JLabel cardNum = new JLabel("Card Number: ");
	JLabel cardExpire = new JLabel("Card Expiration Date: ");
	JLabel cardCVV = new JLabel("Enter card CVV: ");
	JTextField cardNumField = new JTextField();
	JLabel emptyLabel = new JLabel();
	JButton checkoutButton = new JButton("Checkout");
	JTextField cardExpireField = new JTextField();
	JTextField cardCVVField = new JTextField();
	private HashMap<Product, Integer> custoMap;

	public CardCheckoutWindow(HashMap<Product, Integer> custoMap) {
		// SpringUtilities.makeCompactGrid(panel, 3, 2, 6, 6, 6, 6);
		this.custoMap = custoMap;

		String totalString = String.format("%.2f", getTotal());
		total.setText(totalString);

		panel.add(totalLabel);
		panel.add(total);

		panel.add(cardNum);
		panel.add(cardNumField);
		panel.add(cardExpire);
		panel.add(cardExpireField);
		panel.add(cardCVV);
		panel.add(cardCVVField);
		panel.add(emptyLabel);
		panel.add(checkoutButton);

		checkoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!hasValidInput()) {
					JOptionPane.showMessageDialog(panel, "Card number must be 16 digits, exp date must be in MM/YY format, CVV must be 3 digits.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					String cardNum = cardNumField.getText();
					String expDate = cardExpireField.getText();
					String CVV = cardCVVField.getText();
					new CardReceiptWindow(custoMap, cardNum, expDate, CVV);
				}	
			}
		});

		SpringUtilities.makeCompactGrid(panel, 5, 2, // rows, cols
				6, 6, // initX, initY
				6, 6); // xPad, yPad

		frame.add(panel);
		frame.setPreferredSize(new Dimension(350, 200));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public double getTotal() {
		double sum = 0;
		for (Product prod : custoMap.keySet()) {
			int quantity = custoMap.get(prod);
			double costOfItems = prod.getPrice() * quantity;
			sum += costOfItems;
		}
		return sum * 1.06; // accounting for tax, which will be shown in the receipt
	}
	
	public boolean hasValidInput() {
		boolean mostlyValid;
		boolean validCardNum = cardNumField.getText().matches("\\d{16}");
		boolean validExpDate = cardExpireField.getText().matches("\\d{2}\\/\\d{2}");
		boolean validCVV = cardCVVField.getText().matches("\\d{3}");
		if (validCardNum && validCVV) {
			mostlyValid = true;
		}
		else {
			mostlyValid = true;
		}
		if(mostlyValid && validExpDate) {
			return true;
		}
		else {
			return false;
		}
	}
}
