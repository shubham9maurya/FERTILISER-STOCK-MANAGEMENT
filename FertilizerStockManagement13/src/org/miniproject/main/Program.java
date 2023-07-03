package org.miniproject.main;
import java.util.Scanner;
import java.util.ArrayList;

import org.miniproject.Exception.IncorrectLogInDetailsException;
import org.miniprojract.domain.*;

public class Program {
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String RESET = "\033[0m";
    
    private static int RetailerId=180910;
    private static int Password=12345;
    
	private static Scanner sc = new Scanner(System.in);
	private static Fertilizer[] getArray() {
		Fertilizer[] arr = new Fertilizer[ 10 ];
		arr[ 0 ] = new Fertilizer("UJWALA", "RCF", "Urea-46", 266.50, 150, 1100, 45);
		arr[ 1 ] = new Fertilizer("UTTAM VEER", "CHAMBAL", "Urea-46", 266.50, 150, 1100, 45);
		arr[ 2 ] = new Fertilizer("SMARTEK", "MAHADHAN", "NPK-10:26:26", 1470, 200, 1918, 50);
		arr[ 3 ] = new Fertilizer("SAMARTH", "JAI KISAN", "NPK-10:26:26", 1400.00, 100, 1918, 50);
		arr[ 4 ] = new Fertilizer("SAMRAT", "JAI KISAN", "DAP-18:46:00", 1350.00, 150, 2501, 50);
		arr[ 5 ] = new Fertilizer("GODAVARI", "COROMANDEL", "DAP-18:46:00", 1300.00, 110, 2501, 50);
		arr[ 6 ] = new Fertilizer("SURAKSHA", "JAI KISAN", "MOP-60", 1700.00, 100, 759, 50);
		arr[ 7 ] = new Fertilizer("GROSMART", "COROMANDEL", "NPKS-24:24:0:8", 1450.00, 100, 1200, 50);
		arr[ 8 ] = new Fertilizer("GROSHAKTI", "COROMANDEL", "NPK-14:35:14", 1500.00, 140, 1300, 50);
		arr[ 9 ] = new Fertilizer("AMMONIUM SULPHATE", "SARDAR", "NS-20.5:23", 1000, 50, 1100, 50);
		return arr;
		}
	private static int menuList() {
		System.out.println("0.Exit");
		System.out.println("1.Add Fertilizer");
		System.out.println("2.View Stock");
		System.out.println("3.Buy Fertilizer");
		System.out.println("4.Sell to Farmer");
        System.out.println("5.View sell history");
		System.out.println("6.View purchase history");
		System.out.println("Enter your choice  :  ");
		return sc.nextInt();
	}
    public static ArrayList<Fertilizer> getSingleFertilizer() {
    	ArrayList<Fertilizer> singlelist=new ArrayList<>();
    	sc.nextLine();
	   System.out.println("Enter Fertilizer Name:");
	    String name = sc.nextLine();
	    System.out.println("Enter Company Name:");
	    String companyname = sc.nextLine();
	    System.out.println("Enter Fertilizer Grade:");
	    String grade = sc.nextLine();
	    System.out.println("Enter Price Per Bag:");
	    double price_per_Bag = sc.nextDouble();
	    System.out.println("Enter Quantity:");
	    int quantity = sc.nextInt();
	    System.out.println("Enter Subsidy:");
	    double subsidy = sc.nextDouble();
	    System.out.println("Enter Weight:");
	    int weight = sc.nextInt();
	    
	    Fertilizer newFertilizer = new Fertilizer(name, companyname, grade, price_per_Bag, quantity, subsidy, weight);
	    singlelist.add(newFertilizer);
	    return singlelist;
   }

	public static void main(String[] args) {
		
			System.out.println("Enter Retailer ID");
			int id=sc.nextInt();
			System.out.println("Enter Password");
			int password=sc.nextInt();
			try {
			if( id == RetailerId && password == Password) {
			System.out.println(BLACK_BOLD+"Logged in Successfully!!!"+RESET);
			int choice;
			FertilizerTest frt = new FertilizerTest();
			
			while((choice = Program.menuList()) != 0) {
				switch (choice) {

			    case 1:
			    	Fertilizer[] arr = Program.getArray();
			    	
			        frt.addFertilizer(arr);
			        break;
                case 2:
			        frt.printStock();
			        break;
			    case 3:
			    	if(!FertilizerTest.fertilizerList.isEmpty()) {
			    	ArrayList<Fertilizer> singlelist=Program.getSingleFertilizer();
			        frt.buyFertilizer(singlelist);
			    	}else {
			    		System.out.println("Please add Fertilizers from Warehouse");
			    	}
			        break;
			    case 4:
			        frt.sellFertilizer();
			        break;

			    case 5:
			        frt.sellHistory();
			        break;
			    case 6:
			        frt.purchaseHistory();
			        break;
			    default:
			        System.out.println("Invalid choice. Please try again.");
			        break;
			}
			}
       }else {
    	   throw new IncorrectLogInDetailsException();
		
}
		} catch (IncorrectLogInDetailsException cause) {
			System.err.print(cause.getMessage());
			System.exit(0);
		}
	}
}
