package practice;

import java.util.*;

/**
 * 
 * @author sami
 * created 11/3/18
 *
 */

public class MainStore {
	
	//Stores objects in an ArrayList, instance of class product
	static List <product> item = new ArrayList<>();	
	
	public static void main(String[] args) {
		   
		item.add(new product (79.99, "Keyboard"));		//0
		item.add(new product (199.00, "Monitor"));		//1
		item.add(new product (39.99, "Mouse"));			//2
		item.add(new product (74.99, "Headphone"));		//3
		item.add(new product (47.99, "Speaker"));		//4
		item.add(new product (120.49, "HardDrive"));	        //5
		item.add(new product (799.00, "Laptop"));		//6
		
		
		System.out.println("Welcome to eTech!");
		System.out.println("We have items that you can choose from or you can search for yourself."
			+ "\n\nEnter '1' to select an item by their ID number.\nOR\nEnter '2' to search items yourself.");
		
		//Saves user input into a variable of type string
		String userAnswer = global.INPUTSTRING.nextLine();
		
		/* 
		 * The below control statements checks if the user wants to select an item by ID/index
		 * Or by searching for a specific item.
		 */
		if(userAnswer.equals("1")){
			userPick();
			
		} else if (userAnswer.equals("2")) {
			userSearch();
	    		
			/* 
			 * The below statements:
			 * Otherwise if the user did not enter '1' or '2' or made a mistake
			 * Ask if they want to search for an item or if they want to look up these items.
			 */
		} else {
			System.out.println("Would you like to search for a product? Type: 'Y' OR 'N'");
			String userAnswerOption2 = global.INPUTSTRING.nextLine();
				
			/* 
			 * if the user entered yes, the "userSearch" method will get called
			 */ 
			if (userAnswerOption2.equals("Y")){
				userSearch();
				
			} else if (userAnswerOption2.equals("N")){
				System.out.println("You may want to look up these items.\nEnter anything to proceed");
				String proceed = global.INPUTSTRING.nextLine();
				userPick();	
			} 
		}
	}
	
	//This method gets called when the user wants to select an item
	public static void userPick(){
		
		while(true){
			
		   /* This will loop through every item in the arraylist to display the output
			* and their index number so that the user can select an item
			*/
			for(int i = 0; i<item.size(); i++){
				System.out.println();
				System.out.println(i + ": " + item.get(i).returnName());
			}
			
			/*
			 * When a user enters an ID based on the index of the arraylist
			 * it will get stored into a variable called "userPicked"
			 * it then gets passed into 4 methods.
			 * 
			 * The if statement checks if the entered number is between the index of the list
			 * if it is, it will pass that number into the item to display the product that the user wanted.
			 * 
			 * For example:
			 * The user entered 4
			 * 4 will get stored into "userPicked"
			 * Then inside the body of the if statement it will pass that number to the index
			 * item.get(userPicked) which is 4, so it will display the "Speaker" product in the list.
			 */
			System.out.print("\n\nSelect an item by their ID: ");
			int userPicked = global.INPUTINT.nextInt();
				
			if(userPicked > 0 && userPicked < item.size()){
				item.get(userPicked).showProduct();
				item.get(userPicked).dropPrice();
				item.get(userPicked).showProductSpecial();
				item.get(userPicked).addToCart();
			}
		}
	}
	
	/* 
	 * This method will check if the product entered by the user is available
	 * by passing the user input into another method called "lookUpProduct"
	 */
	public static void userSearch(){
		System.out.print("Enter a product: ");
		String customName = global.INPUTSTRING.nextLine();
		lookUpProduct(customName);
	}
	
	/*
	 * This method checks to see if the entered product is available in the list of items.
	 */
	public static void lookUpProduct(String name){

		/*
		 * Using an enhanced for-loop to look through the list and to see if the entered product is available
		 * if the product name matches, it will display that product.
		 * 
		 * For example:
		 * The user entered "Mouse"
		 * It gets passed into this method to check if the String matches
		 * If it does, (i) will be 2 because the user entered Mouse which is in index 2 of the arraylist
		 */
		for(product i: item){
			
	        if(name.equals((i).returnName())){
	        	System.out.printf("\n%s is available in-store!! ", (i).returnName());
				System.out.println("\nEnter anything to proceed\n\n");
				String proceed = global.INPUTSTRING.nextLine();
				
				(i).showProduct();
				(i).dropPrice();
				(i).showProductSpecial();
				(i).addToCart(); 
	        }
		
		} 
		
		for(product j: item){
			
		//If the entered product is not available in the list of items
		if (!name.equals((j).returnName())) {
	        	System.out.println("We are sorry, the product you entered is not available :(\n");
			System.out.println("Would you like to see what is available? Enter anything to proceed");
				
			String proceed = global.INPUTSTRING.nextLine();
				
			//This will list all the products available in the list and tell the user to search again
			for(int i = 0; i<item.size(); i++){
				System.out.print(item.get(i).returnName() + ", ");
			}
				
			System.out.println("\n");
			userSearch();
	        }
			
		}
	}
}
