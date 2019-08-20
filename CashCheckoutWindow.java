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

public class CashCheckoutWindow {

	JFrame frame = new JFrame("Checkout");
	JPanel panel = new JPanel(new SpringLayout());
	JLabel cashLabel = new JLabel("Cash amount: ");
	JTextField cashField = new JTextField();
	JLabel total = new JLabel();
	JLabel totalLabel = new JLabel("Amount due: $");
	JButton checkoutButton = new JButton("Checkout");
	JLabel emptyLabel = new JLabel();

	private HashMap<Product, Integer> custoMap;

	public CashCheckoutWindow(HashMap<Product, Integer> custoMap) {
		// SpringUtilities.makeCompactGrid(panel, 3, 2, 6, 6, 6, 6);
		this.custoMap = custoMap;

		String totalString = String.format("%.2f", getTotal());
		total.setText(totalString);

		panel.add(totalLabel);
		panel.add(total);
		panel.add(cashLabel);
		panel.add(cashField);
		panel.add(emptyLabel);
		panel.add(checkoutButton);

		checkoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!isValidPayment()) {
					JOptionPane.showMessageDialog(panel, "Please give more cash than you owe.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					new CashReceiptWindow(custoMap, cashField.getText());
				}
			}
		});

		SpringUtilities.makeCompactGrid(panel, 3, 2, // rows, cols
				6, 6, // initX, initY
				6, 6); // xPad, yPad

		frame.add(panel);
		frame.setPreferredSize(new Dimension(210, 115));
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

	public boolean isValidPayment() {
		boolean isEnoughMoney;
		boolean isNumeric;
		if (cashField.getText().contains("[a-zA-Z]+")) {
			isNumeric = false;
		}
		else {
			isNumeric = true;
		}
		double payment = 0;
		try {
			payment = Double.parseDouble(cashField.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(panel, "Please enter a numeric value.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		if (payment >= getTotal()) {
			isEnoughMoney = true;
		} else {
			isEnoughMoney = false;
		}
		return (isEnoughMoney);
	}
}