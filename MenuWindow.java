package co.grandcircus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;

public class MenuWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Inventory inv = new Inventory();
		ArrayList<Product> prodList = inv.readFromFile();
		ArrayList<Product> custoList = new ArrayList<>();
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuWindow frame = new MenuWindow(inv,prodList);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuWindow(Inventory inv, ArrayList<Product> prodList) {

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel [] prodStrings = new JLabel[prodList.size()];
		
		for (int i = 0; i < prodStrings.length; i++) {
			JLabel str = new JLabel(prodList.get(i).getName() + " " + prodList.get(i).getDescription() + " " + prodList.get(i).getPrice());
		}
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblPleaseSelectA = new JLabel("Please select a menu item: ");
		panel.add(lblPleaseSelectA);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JComboBox comboBox = new JComboBox();
		for(JLabel str : prodStrings) {
			comboBox.add(str);
		}
		panel_1.add(comboBox);
	}

}
