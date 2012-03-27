import java.util.Scanner;
public class BullAndCowsTester {

	public static void main(String[] args) { //begin main method
			Scanner input = new Scanner(System.in);
			int again = 1; //serves as a numerical representation of whether the user wants to play again
			int totalTries = 0; 
			double mean=0; 
			int min=9999999; // set to a very high number so that user's first guess can be set as the initial min.
			int max=0; // set to 0 so that user's first guess can be set as the initial max
			
			while (again ==1) { //as long as the user wants to play the game
				System.out.println("Welcome to Bulls and Cows!");
				Game g = new Game();
				int score =  g.play(); // the counter that is returned is set to the user's score
				if (score>max) // if condition allows us to sift out the best performance after each turn
					max=score;
				if (score<min)// sifting out the worst performance
					min=score;
				mean=(mean*totalTries+score)/(totalTries+1); //calculates the average performance each time the user plays
				totalTries++; 
				System.out.println("Would you like to play again? (1 -yes/0-no)");
				again = input.nextInt(); // if again == 0, we will break out of the while loop
			}
			//printing the user's performance once he/she finishes playing
			System.out.println("Your best performance was " + min + " guesses");
			System.out.println("Your worst performance was " + max + " guesses");
			System.out.println("Your average performance is " + mean + " guesses");
			System.out.println("Thank you for playing Bulls and Cows!");
		}// end main method
			
		
			
		

	}


