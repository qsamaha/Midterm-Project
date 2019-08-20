package co.grandcircus;

import java.util.ArrayList;

public class WindowTester {

	public static void main(String[] args) {
		Inventory inv = new Inventory();
		ArrayList<Product> prodList = inv.readFromFile();
		OrderWindow window = new OrderWindow(inv, prodList);

	}

}
