package co.grandcircus;

import java.util.ArrayList;

import java.util.Scanner;

public class Tester2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		System.out.println("Thanks for choosing KQT Catering, Here we aim to please!");
		System.out.println("Choose from the menu below");
		System.out.println(" ");
		System.out.println(" ");

		ArrayList<Product> CustoList = new ArrayList<>();
		String condition = "Yes";
		do {
			Inventory inv = new Inventory();
			ArrayList<Product> prodList = new ArrayList<>();
			prodList = inv.readFromFile();
			int i = 1;
			for (Product prod : prodList) {
				System.out.print(i + ". ");
				System.out.println(prod);
				i++;
			}
			// scan.next();

			int prodItem = scan.nextInt();
			scan.nextLine(); // garbage line
			Product prodLocation = prodList.get(prodItem - 1);
			CustoList.add(prodLocation);
			
			System.out.println("Would you like to continue shopping? Enter Yes/No");
			condition = scan.next();
		} while (condition.equalsIgnoreCase("Yes"));

		System.out.println("What is your method of payment? \n1. Card \n2. Check \n3. Cash");
		String choice = scan.next();
		boolean keepGoing = true;
		do {
		if (choice.equalsIgnoreCase("Card")) {
			double sum = 0;
			double tax;

			for (Product prod : CustoList) {
				sum += prod.getPrice();
			}
			tax = sum * 0.06;
			sum = sum + tax;
			System.out.printf("Total: " + "%.2f", sum);
			System.out.println("");

			String cNum = Validator.getStringMatchingRegex(scan, "Enter Valid Card Number: ", "\\d{16}");

			System.out.println("Enter expiration date!");
			String cDate = Validator.getStringMatchingRegex(scan, "Enter Valid Expiration Date: (xx\\xx)",
					"\\d{2}\\/\\d{2}");

			System.out.println("Enter your card CW!");
			String CVV = Validator.getStringMatchingRegex(scan, "Enter CVV Number:", "\\d{3}");

			Receipt receipt = new CardReciept(CustoList, cNum, cDate, CVV);
			receipt.printReceipt();
		} else if (choice.equalsIgnoreCase("Check")) {
			double sum = 0;
			double tax;

			for (Product prod : CustoList) {
				sum += prod.getPrice();
			}
			tax = sum * 0.06;
			sum = sum + tax;
			System.out.printf("Total: " + "%.2f", sum);
			System.out.println("");

			String chkNum = Validator.getStringMatchingRegex(scan, "Enter Check Number: ", "\\d{9}");

			Receipt receipt = new CheckReceipt(CustoList, chkNum);
			receipt.printReceipt();

		} else if (choice.equalsIgnoreCase("Cash")) {
			double sum = 0;
			double tax;

			for (Product prod : CustoList) {
				sum += prod.getPrice();
			}
			tax = sum * 0.06;
			sum = sum + tax;
			System.out.printf("Total: " + "%.2f", sum);
			System.out.println("");

			double cash = Validator.getDouble(scan, "How much money are you paying?");

			Receipt receipt = new CashReceipt(CustoList, cash);
			receipt.printReceipt();

		} else {
			System.out.println("Response unrecognizable, Enter either Cash, Card or Check!!!");
		}
		} while (keepGoing != false);
			
		
		
	}

}
