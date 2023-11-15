import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
    	String message = String.format("Hello, %s. Lovely to see you.",name);
        return message ;
        		
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
    	Date date = new Date();
    	String message = String.format("It is currently %s.", date.toString());
        return message;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if (conversation.contains("Alexis"))
        	return "Right away, sir. She certainly isn't sophisticated enough for that.";
        else if (conversation.contains("Alfred"))
        	return "At your service. As you wish, naturally." ;
        else         	
        	return "Right. And with that I shall retire.";
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
    public String guestGreeting(String name, String day) {
        // YOUR CODE HERE
    	Date date = new Date();
    	String message = String.format("Hello, %s. Lovely to see you. It's currently %s",name, date.toString());
        return message ;        		
    }
    //SENSEI VERSION
    public String guestGreeting() {
        // YOUR CODE HERE
    	Date date = new Date();
    	String variable;
    	if(date.getHours() > 12)
    		variable = "morning";
    	else if(date.getHours() > 20)
    		variable = "afternoon";
    	else variable = "evening";
    	String message = String.format("Good %s , Lovely to see.",variable);
        return message ;        		
    }
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
    public String checkPoliteConversation (String conversation) {
    	if(conversation.contains("stupid"))
    		return "Hello! I am Yelling ! you made me angry !!!";
    	else 
    		return "Very polite, thank you";
    }
    
}

