
public class product {
	
	private double price;
	private String name;
	private int quantity = 0;
	private double total = 0;
	
	public product(double price, String name){
		this.price = price;
		this.name = name;
	}
	
	public void dropPrice(){
		price /= 2;
	}
	
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
		System.out.printf("SPECIAL DEAL! ALMOST %s OFF EVERYTHING! \nJUST $%.02f FOR A LIMITED TIME ONLY! HURRY! \n\n", percentage, returnPrice());
	}
	
	public void addToCart(){
		System.out.println("\nWould you like to buy this item? Enter 'Y' OR 'N'");
		String enterCart = global.input.nextLine();
		
		if(enterCart.equals("Y")){
			System.out.print("Please enter the quantity you want (1-10): ");
			int amountEntered = global.input.nextInt();
			
			quantity += amountEntered;
			total = price *= amountEntered;
			total();
			
		} else if (enterCart.equals("N")){
			System.out.println("Please check out the other items :)");
		}
	}
	/*
	public void userPickedItem(){
		
		System.out.print("Name of the product you want: ");
		String userPicked = global.input.nextLine();
		
		switch (userPicked){
		
		case "Keyboard":
		case "Monitor":
		case "Mouse":
		case "Headphone":
		case "Speakers":
		case "HardDrive":
		case "Laptop":
			showProduct();
			dropPrice();
			showProductSpecial();
			addToCart();
			break;
			
		default:
			System.out.println("Please enter the correct spelling with the first letter being uppercase.");
		}
	}
	
	*/
	
	public void total(){
		System.out.printf("\nCart\nQuantity: %d\nTotal: $%.02f", returnAmount(), total);
	}
	
	public void lookUpProduct(){
		
		if(name.equals("Keyboard") || name.equals("Monitor") || name.equals("Mouse") || name.equals("Headphone") || name.equals("Speakers") || name.equals("HardDrive") || name.equals("Laptop")){
			System.out.println("The product you entered is in store!");
		} else {
			System.out.println("\nWe are sorry, the product you entered is not available :(\nPlease try again.");
		}
	}
}
