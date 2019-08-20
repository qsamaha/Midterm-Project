package co.grandcircus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Inventory {
	ArrayList<Product> inventory;
	
	public ArrayList<Product> readFromFile(){
		ArrayList<Product> productList = new ArrayList<Product>();
		
		String fileName = "menu.txt";
		Path path = Paths.get("res", fileName);
		
		File file = path.toFile();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String menuString = br.readLine();
			
			while (menuString != null) {
				String [] productInfo = menuString.split(",");
				String name = productInfo[0];
				String category = productInfo[1];
				String desc = productInfo[2];
				double price = Double.parseDouble(productInfo[3]);
				Product product = new Product(name,category,desc,price);
				productList.add(product);
				
				menuString = br.readLine();
			}
			br.close();
			return productList;
			
		} catch (FileNotFoundException e) {
			System.out.println("Something happened with the file...");
		} catch (IOException e) {
			System.out.println("Something happened when attempting to read from the file...");
		}
		return null;
	}
}
