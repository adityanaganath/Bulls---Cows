//*******************************
// Player Class in Bull and Cows
//
//
//******************************

import java.util.Scanner;
import java.util.ArrayList;

public class Player { //This class handles the interaction with the user

        private Scanner input;
        private String userInput; //Instance variable. The users input will be treated as a string
        private ArrayList<String> guessPossibilites = new ArrayList<String> ();
        private Oracle c;
        
        
        public Player() {
        		
        			input = new Scanner(System.in); //The scanner is initialized
        			userInput = ""; // user's input is initially initializes to a empty string
        			
        		
        }
        
       
        
        public void askGuess() { //method asking the user to guess
                System.out.println("Please enter your guess");
                userInput = input.next();
        }

        public String getGuess() { //method that acquires the user's guess
                return userInput;
        }
        
        private String generateGuess() {
        	String str = "";
        	String newDigit;
        	
     
        	for (int i=0; i<4; i++) { //loop until we get four digits
                 newDigit = ""+(int)(Math.random()*9.999);// digit generated from 0 to 9 randomly. Using 9.999 so that distribution is equal.
                 while (str.contains(newDigit)) { // oracle generates another digit if the original digit is already in str
                             newDigit = ""+(int)(Math.random()*9.999);
                     }
                     str=str.concat(newDigit);
                    
        			}
        		return str;

        	  }
        
        public void guessOptions() {
        	
        	
        	String g;
        	for (int i = 0; i<3024; i++) {
        		g = generateGuess();
        		for (int j = 0; j<guessPossibilites.size(); j++) {
        			String z = guessPossibilites.get(j);
        			while((z.contains(g))) {
        				g =  generateGuess();
        	}
        			
        			guessPossibilites.add(g);
        		}
        		
        
        }
        
        
    
        	}
        
        public String compGetGuess() {
        	String guess = guessPossibilites.get(0);
        	return guess;
        }
        
        public void removeOtherOptions(int bull, int cow) {
        	c = new Oracle();
        	
        	for (int j = 1; j<guessPossibilites.size();j++) {
        		int y = c.calculateBulls(guessPossibilites.get(j));
        		int z = c.calculateCows(guessPossibilites.get(j));
        		
        		if (y!= bull && z!= cow) {
        			guessPossibilites.remove(j);
        		}
        	}
        	
        	guessPossibilites.remove(0);
        }
     
        
        
 }
        



