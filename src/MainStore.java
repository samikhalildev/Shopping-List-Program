

/**
 * 
 * @author sami
 * created 11/3/18
 *
 */

public class MainStore {

	public static void main(String[] args) {
				
		System.out.println("Welcome to DPSA online store!");
				
		System.out.println("We have items that you can choose from or you can search for yourself.\n\nEnter '1' to bring up a list of items.\nOR\nEnter '2' to search items yourself.");
		String userAnswer = global.input.nextLine();
		
		if(userAnswer.equals("1")){
			
			product product1 = new product (79.99, "Keyboard");
			product product2 = new product (199.00, "Monitor");			
			product product3 = new product (39.99, "Mouse");
			product product4 = new product (79.99, "Headphone");
			product product5 = new product (47.99, "Speakers");
			product product6 = new product (120.49, "HardDrive");	
			product product7 = new product (799.00, "Laptop");
			
			System.out.println("\nPlease pick an item from below:\n");
			System.out.println( product1.returnName() + "\n" + product2.returnName() + "\n" + product3.returnName() + "\n" + product4.returnName() + "\n" + product5.returnName() + "\n" + product6.returnName() + "\n" + product7.returnName() + "\n");
						
			/*
			product1.userPickedItem();
			product2.userPickedItem();
			product3.userPickedItem();
			product4.userPickedItem();
			product5.userPickedItem();
			product6.userPickedItem();
			product7.userPickedItem();
			*/
			
			System.out.print("Name of the product you want: ");
			String userPicked = global.input.nextLine();

			switch (userPicked){
			
			case "Keyboard":
				product1.showProduct();
				product1.dropPrice();
				product1.showProductSpecial();
				product1.addToCart();
				break;
				
			case "Monitor":
				product2.showProduct();
				product2.dropPrice();
				product2.showProductSpecial();
				product2.addToCart();
				break;
				
			case "Mouse":
				product3.showProduct();
				product3.dropPrice();
				product3.showProductSpecial();
				product3.addToCart();
				break;
				
			case "Headphone":
				product4.showProduct();
				product4.dropPrice();
				product4.showProductSpecial();
				product4.addToCart();
				break;

			case "Speakers":
				product5.showProduct();
				product5.dropPrice();
				product5.showProductSpecial();
				product5.addToCart();
				break;
				
			case "HardDrive":
				product6.showProduct();
				product6.dropPrice();
				product6.showProductSpecial();
				product6.addToCart();
				break;
				
			case "Laptop":
				product7.showProduct();
				product7.dropPrice();
				product7.showProductSpecial();
				product7.addToCart();
				break;
				
			default:
				System.out.println("Please enter the correct spelling with the first letter being uppercase.");
			}

		} else if (userAnswer.equals("2")) {
			System.out.print("Enter a product: ");
			String customName = global.input.nextLine();
			product custom = new product(0, customName);
			custom.lookUpProduct();
			
		} else {
			System.out.println("Would you like to search for a product? Type: 'Y' OR 'N'");
			String userAnswerOption2 = global.input.nextLine();
				
				// to determine if the user entered yes, the "lookUpProduct" method will check if that product is available in the store or not.	
				if(userAnswerOption2.equals("Y")){
					System.out.print("Enter a product: ");
					String customName = global.input.nextLine();
					product custom = new product(0, customName);
					custom.lookUpProduct();
					
				} else if (userAnswerOption2.equals("N")){
					System.out.println("Not a problem, you may look up these items.");
					
				} else {
					System.out.println("An error occured. Please enter 'Y' OR 'N' to proceed to the next step :)");
					
			}
		}	
	}
}
