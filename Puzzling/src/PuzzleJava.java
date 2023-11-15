
import java.util.Random;
import java.util.Arrays;

public class PuzzleJava {
	/*
	* Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive.
	*/ 
	int[] getTenRolls() {
		int[] myRandomArray = new int[10];	    
		// To use methods from the Random library you will need to create an instance of Random
		Random randMachine = new Random();
		// populate myArray with random int Value from 0 to 20
		for (int i = 0; i < myRandomArray.length ; i++) {
			myRandomArray[i] = randMachine.nextInt(10);
		}
		return myRandomArray;
	}

	void printIntRandomArray () {
		int[] randomArray = getTenRolls();
		for (int i = 0 ; i < randomArray.length ; i++) {
			System.out.printf("%d%n",randomArray[i]);
		}
	}

	/*
	 * Write a method that will:
	 * Create an array within the method that contains all 26 letters of the alphabet (this array must have 26 values).
	 * Generate a random index between 0-25 and use it to pull a random letter out of the array.
	 * Return the random letter.
	*/
	char [] getRandomLetter() {
		char[] randomLetters = new char[26];
		// ASCII alphabet : a - b  ( 97 - 122 ) // A - B ( 65 - 90)
		Random randMachine = new Random();
		for (int i = 0; i < randomLetters.length ; i++) {			
			randomLetters[i] = (char) (65 + randMachine.nextInt(25)) ;
		}
		return randomLetters ;
	}
	void printCharRandomArray () {
		char[] randomArray = getRandomLetter();
		for (int i = 0 ; i < randomArray.length ; i++) {
			System.out.printf("%c%n",randomArray[i]);
		}
	}
	
	/*
	 * Write a method that uses the previous method to create a random string of eight characters and return that string.
	*/
	String generatePassword () {
		String Password ="" ;
		// invoke the random int array
		int[] intRand = getTenRolls();
		// invoke the random char array
		char[] charRand = getRandomLetter();
		// MyPassword contains numCharacter
		int numCharacter = 8 ;
		// Create a RandMachine
		Random randMachine = new Random();
		// Concstruct my RandomPassword
		int count = 0 ; 
		while(count <numCharacter) {
			// Construct the password character by character
			if(randMachine.nextBoolean()) {
				int select = intRand[randMachine.nextInt(9)];
				Password += select ;
			}else {
				char select = charRand[randMachine.nextInt(25)];
				Password += select ;
			}
			// next character
			count ++;
			//System.out.printf("numCharacter : %d - password length : %d - %s%n",numCharacter,Password.length(), Password);
		}
		/*
		for (int i = 0; i<numCharacter; i++) {
			if(randMachine.nextBoolean()) {
				int select = intRand[randMachine.nextInt(10)];
				Password += select ;
			}else {
				char select = charRand[randMachine.nextInt(25)];
				Password += select ;
			}			
		}
		*/
		//System.out.printf("numCharacter : %d - password length : %d - %s%n",numCharacter,Password.length(), Password);
		return Password ;
	}	
	/*
	 * Write a method that takes an int length as an argument and creates an array of random eight-character words. The array should be the length passed in as an int. Return the array of passwords.
	*/
	String[] getNewPasswordSet (int length){
		String[] Passwords = new String[length]; 
		for (int i = 0; i<Passwords.length; i++) {
			Passwords[i] =  generatePassword ();
		}
		return Passwords ;
	}
	
	void printNewPasswordSet (int length) {
		String[] PasswordSet = getNewPasswordSet(length);
		for (int i = 0 ; i < PasswordSet.length ; i++) {
			System.out.printf("%s%n",PasswordSet[i]);
		}
	}
	
	/*
	 * SENSEI BONUS:
	 * Write a method that takes an array and mixes up all the values in a pseudo-random way. Hint: use random indexes within the array, and swap values repeatedly.
	*/
	//shuffleArray


}
