// ******************************
// Game Class for Bulls and Cows
//
//
//*******************************
import java.util.Scanner;
public class Game { //blueprint for the game

        private Player p1;
        private Player p2;
        private Oracle o; // oracle generates the number
        private int counter; // counter keeps track of the num of guesses
        private boolean isHuman;
        
        public Game() {
        	System.out.println("Play Human? (y/n)");
        	Scanner read = new Scanner(System.in);
        	String response = read.next();
        	if (response.equals("y")) {
                p1 = new Player();
                isHuman = true;
        	}
        	else {
        		p2 = new Player();
        	}
             
        	o = new Oracle();
            counter = 0;
        }
        
        public int play() {
        	if (isHuman) {
        		playHuman();
        	}
        	
        	return counter;
        }

        public int playHuman() { // public int because we want the value of the counter to be accessed in the tester class
        	while(!p1.getGuess().equals(o.getTarget())) { // loop as long as the guess is not the oracle's number
                        p1.askGuess(); // ask the user for a guess
                        o.displayBulls(p1.getGuess());//tell the user his bulls based on his guess (parameter)
                        o.displayCows(p1.getGuess());// tell the user his cows based on his guess (parameter)
                        counter++; 

                }
                System.out.println("You took " + counter + " tries"); // inform the user of his performance once he finishes.
                
                return counter; // returns the value to the method so that it can be used in the tester class
                
                
        }
        
        
        
}


