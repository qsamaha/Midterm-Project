package co.grandcircus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;

public class CheckOutHandler implements ActionListener {
 
	HashMap<Product, Integer> custoMap;
	ButtonGroup bGroup;
	
	

	public CheckOutHandler(HashMap<Product, Integer> custoMap, ButtonGroup bGroup) {
		this.custoMap = custoMap;
		this.bGroup = bGroup;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		JRadioButton b = getButton();
		if (b.getText().equals("Card")) {
			new CardCheckoutWindow(custoMap);
		}
		else if(b.getText().equals("Cash")){
			new CashCheckoutWindow(custoMap);
		}
		else if(b.getText().equals("Check")) {
			new CheckCheckoutWindow(custoMap);
		}
			
		
		
	}
	
	public JRadioButton getButton() {
		Enumeration<AbstractButton> abstractButtons = bGroup.getElements();
	    JRadioButton radioButton = null;

	    while (abstractButtons.hasMoreElements()) {
	        radioButton = (JRadioButton) abstractButtons.nextElement();
	        if (radioButton.isSelected()) {
	            break;
	        }
	    }
	    return radioButton;
	}

}
