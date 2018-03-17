package practice;

public class product {
	
	private double price;
	private String name;
	private int quantity = 0;
	private double total = 0;
	
	//Constructor
	public product(double price, String name){
		this.price = price;
		this.name = name;
	}
	
	public void dropPrice(){
		price /= 2;
	}
	
	/*
	 * Below are some getters and setters
	 */
	
	public double returnPrice(){
		return price;
	}
	
	public String returnName(){
		return name;
	}
	
	public int returnAmount(){
		return quantity;
	}
	
	public void showProduct(){
		System.out.printf("\nThe price of a %s is $%.02f\n\n", returnName(), returnPrice());
	}
	
	public void showProductSpecial(){
		String percentage = "50%";
		System.out.printf("SPECIAL DEAL! ALMOST %s OFF EVERYTHING!\n%s is now for $%.02f\n\n", percentage, returnName(), returnPrice());
	}
	
	/*
	 * This method allows the user to add an item to their cart
	 * it takes the amount entered, multiples it by the price and displays the total
	 */
	
	public void addToCart(){
		System.out.println("\nWould you like to buy this item? Enter 'Y' OR 'N'");
		String enterCart = global.INPUTSTRING.nextLine();
		
		if(enterCart.equals("Y")){
			System.out.print("Please enter the quantity you want (1-10): ");
			int amountEntered = global.INPUTINT.nextInt();
			
			quantity += amountEntered;
			total = price * amountEntered;
			total();
			userPurchased();
			userRestart();

		} else {
			userRestart();
		} 
	}
	
	// Displays the product bought
	public void total(){
		System.out.printf("\n\nCart\nProduct: %s\nQuantity: %d\nTotal: $%.02f", returnName(), returnAmount(), total);
	}
	
	// This will ask the user if they want to buy another product before proceeding
	public void userRestart(){
		System.out.println("\n\nWould you like to buy another item? Enter anything to proceed.");
		String restart = global.INPUTSTRING.nextLine();
	}
	
	//Once the user buys an item they will get a thank you message and the item will be sold out.
	public void userPurchased(){
		System.out.println("\n\nThank you for your purchase! :)");
		name += " -> SOLD OUT";
		price = 0;
		quantity = 0;
	}
}
