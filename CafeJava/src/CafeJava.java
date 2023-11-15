
public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 1.2;
        double dripLattePrice = 2.5;
        double cappucinoPrice =  3.0;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 ="Jimmy";
        String customer4 ="Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false; 
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        	 
        // Cindhuri placing an order
       if (isReadyOrder1)
    	   System.out.println(customer1 +" " + readyMessage);
        	else 
        	System.out.println(customer1 +" "+ pendingMessage);   
       // Noah ordered a cappucin
       if (isReadyOrder4)
    	   System.out.println(customer4 + " " + readyMessage);
        	else 
        	System.out.println(customer4 +" " + pendingMessage);  
       // Dam ordered 2 lattes
       double totalCustomer2 = 2 * dripLattePrice ;
       System.out.println(customer2+" " +  displayTotalMessage +" "+ totalCustomer2);
       if (!isReadyOrder2)
    	   System.out.println(customer4 +" "+ readyMessage);
        	else 
        	System.out.println(customer4 +" "+ pendingMessage);  
       // Jimmy realized ha was charged for a coffee but had ordered a latte
       double totalCustomer3 = dripCoffeePrice - dripLattePrice ;
       System.out.println(customer3+" " +  displayTotalMessage +" "+ totalCustomer3);
       
    }
}
