package co.grandcircus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventHandling implements ActionListener {

	ArrayList<JButton> bList;
	ArrayList<Product> prodList;
	ArrayList<JTextField> fieldList;
	HashMap <Product, Integer> custoMap = new HashMap<>();
	
	public EventHandling(ArrayList<JButton> bList, ArrayList<Product> pList, ArrayList<JTextField> fieldList) {
		this.bList = bList;
		this.prodList = pList;
		this.fieldList = fieldList;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		getProduct(b);
		getQuan(b);
		custoMap.put(getProduct(b), getQuan(b));

	}
	
	public HashMap<Product, Integer> getCustoMap() {
		return custoMap;
	}

	public Product getProduct(JButton b) {
		int i = bList.indexOf(b);
		//System.out.println(prodList.get(i));
		return prodList.get(i);
	}
	
	public int getQuan(JButton b) {
		int i = bList.indexOf(b);
		JTextField correctField = fieldList.get(i);
		
		int quant;
		try {
			quant = Integer.parseInt(correctField.getText());
			System.out.println(quant);
			return quant;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JPanel(), "Please enter an integer value.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return 0; //THIS WILL PROBABLY BE THE SOURCE OF ANY PROBLEMS HERE
	}

}
