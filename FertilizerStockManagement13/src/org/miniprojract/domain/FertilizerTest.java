package org.miniprojract.domain;
import java.util.ArrayList;
import java.util.Scanner;

import org.miniproject.Exception.InsufficientStockException;

public class FertilizerTest {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String RESET = "\033[0m";

	private double totalAmount=0;
	private double subsidy=0;
    public  static ArrayList<Fertilizer> fertilizerList;
    private ArrayList<Fertilizer> sellhistory;
    private ArrayList<Fertilizer> purchasehistory;
    Fertilizer frt=new Fertilizer();
    private Scanner sc;

    public FertilizerTest() {
        fertilizerList = new ArrayList<Fertilizer>();
        sellhistory = new ArrayList<Fertilizer>();
        purchasehistory= new ArrayList<Fertilizer>();
        sc = new Scanner(System.in);
    }

    public void addFertilizer(Fertilizer[] arr) {
		if(arr != null) {
			if(fertilizerList.isEmpty()) {
			for(Fertilizer fertilizer: arr)
				this.fertilizerList.add(fertilizer);
			}
		}
		System.out.println(BLACK_BOLD+"Fertilizer added successfully from Warehouse."+RESET);
        
    }

   public void buyFertilizer(ArrayList<Fertilizer> singlelist) {
			this.fertilizerList.addAll(singlelist);
			purchasehistory.addAll(singlelist);
			System.out.println(BLACK_BOLD+"Fertilizer purchased successfully."+RESET);
	}
    
   public void sellFertilizer(){
	   if(!this.fertilizerList.isEmpty()) {
	    double totalAmount = 0;
	    double subsidy = 0;
	    Fertilizer fertilizerToSell = null;
	    ArrayList<Fertilizer> bill=new ArrayList<Fertilizer>();
	    System.out.println("Enter the name of the Farmer:");
	    String farmername = sc.next();

	    while (true) {
	        String fertilizerName;
	        double Amount=0;
	        String grade;
	        int quantity;
	        double pricePerBag;
	        String choice="";
   	       while(fertilizerToSell == null) {
	        System.out.println("Enter the name of the Fertilizer to sell:");
	        String inputFertilizerName = sc.next();
	       

	        for (Fertilizer fertilizer : fertilizerList) {
	            if (fertilizer.getName().equalsIgnoreCase(inputFertilizerName)) {
	                fertilizerToSell = fertilizer;
	                break;
	            }
	        }

	        if (fertilizerToSell == null) {
	            System.out.println("Sorry " + farmername + " currently " + inputFertilizerName + " is not available");
	           
		        System.out.println("Do you want to add other fertilizers? (Y/N)");
		        choice = sc.next();
		        if (choice.equalsIgnoreCase("N")) {
		            break;
		        }
		        continue;
	        }
	      
   	       }
	        if (choice.equalsIgnoreCase("N")) {
	            break;
	        }
	        System.out.println("Enter the quantity to sell:");
	        quantity = sc.nextInt();

	        try {
				if (fertilizerToSell.getQuantity() >= quantity) {
				    pricePerBag = fertilizerToSell.getPricePerBag();
				    Amount=quantity * pricePerBag;
				    totalAmount += Amount; 
				    subsidy += quantity * fertilizerToSell.getSubsidy();
				    fertilizerToSell.setSell_quantity(quantity);
				    fertilizerToSell.setQuantity(fertilizerToSell.getQuantity() - quantity);
				    bill.add(fertilizerToSell);
				    sellhistory.add(fertilizerToSell);
				} else {
					throw new InsufficientStockException();

				}
			} catch (InsufficientStockException cause) {
	            System.err.print(cause.getMessage());
	            continue;
	        }
	        fertilizerToSell = null;
	        System.out.println("Do you want to sell more fertilizers? (Y/N)");
	        String answer = sc.next();
	        if (answer.equalsIgnoreCase("N")) {
	            break;
	        }

	    }

	    System.out.println(ANSI_YELLOW_BACKGROUND+"================================="+RED_BOLD+"Team 16 Agro"+RESET+ANSI_YELLOW_BACKGROUND+"==============================");
	    System.out.println(BLACK_BOLD+"Farmer Name :"+ RESET+ANSI_YELLOW_BACKGROUND +farmername);
	    System.out.println(BLACK_BOLD+"Date :" + RESET+ANSI_YELLOW_BACKGROUND + TodayDate.getDate());
	    System.out.println("---------------------------------------------------------------------------");
	    System.out.printf(RED_BOLD+"%-20s%-15s%-13s%-17s%-10s\n", "FertilizerName", "Grade", "Quantity", "Price/Bag(Rs)","Amount(Rs)"+RESET+ANSI_YELLOW_BACKGROUND);
	    System.out.println("---------------------------------------------------------------------------");
	    for(Fertilizer fertilizer:bill) {
	    	System.out.println(fertilizer.toString1());
	    }
	    System.out.printf(BLACK_BOLD+"Total Amount :"+ RESET+ANSI_YELLOW_BACKGROUND);     
	    System.out.printf("%.2fRs\n", totalAmount);  
	    System.out.println("===========================================================================");
	    System.out.printf(BLACK_BOLD+"Subsidy to be borne by the Govt. on behalf of farmer  : %.2fRs       \n"+ RESET+ANSI_YELLOW_BACKGROUND, subsidy);
	    System.out.println(BLACK_BOLD+"                    !!!Thanks for visiting our store!!!                    "+ RESET+ANSI_YELLOW_BACKGROUND);
	    System.out.println("==========================================================================="+ANSI_RESET);
   
   }else {
	   System.out.println("Please add fertilizers from Warehouse");
   }
} 
   public void sellHistory() {
	   System.out.println(ANSI_CYAN_BACKGROUND+"===========================================================================");
	   System.out.printf(BLACK_BOLD+"%-20s%-15s%-13s%-17s%-10s\n", "FertilizerName", "Grade", "Quantity", "Price/Bag(Rs)","Amount"+RESET+ANSI_CYAN_BACKGROUND);
       System.out.println("===========================================================================");
		if(this.sellhistory != null) {
			for (Fertilizer fertilizer : sellhistory) {
				System.out.println(fertilizer.toString1());
			}	
		}
		System.out.println("==========================================================================="+ANSI_RESET);
   }
   public void purchaseHistory() {
    
       System.out.println(ANSI_CYAN_BACKGROUND+"=======================================================================================================");
       System.out.printf(BLACK_BOLD+"%-20s%-15s%-16s%-12s%-16s%-13s%-8s\n","FertilizerName", "CompanyName","Grade","Quantity","Price/Bag(Rs)","Subsidy(Rs)","Weight(Kg)"+RESET+ANSI_CYAN_BACKGROUND);
       System.out.println("=======================================================================================================");
		if(this.purchasehistory != null) {
			for (Fertilizer fertilizer : purchasehistory) {
				System.out.println(fertilizer.toString());
			}	
			System.out.println("======================================================================================================="+ANSI_RESET);
		} 
		 
   }
    public void printStock() {
        System.out.println("Current Fertilizer Stock:");
        System.out.println(ANSI_CYAN_BACKGROUND+"=======================================================================================================");
        System.out.printf(BLACK_BOLD+"%-20s%-15s%-16s%-12s%-16s%-13s%-8s\n","FertilizerName", "CompanyName","Grade","Quantity","Price/Bag(Rs)","Subsidy(Rs)","Weight(Kg)"+RESET+ANSI_CYAN_BACKGROUND);
        System.out.println("=======================================================================================================");
		if(this.fertilizerList != null) {
			for (Fertilizer fertilizer : fertilizerList) {
				System.out.println(fertilizer.toString());
			}	
			System.out.println("======================================================================================================="+ANSI_RESET);
		} 
		 
    }
}
