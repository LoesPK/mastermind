import java.util.Random;
import java.util.Scanner;

public class MasterMind {
	public static void main(String[] args) {
		Code code = new Code();
		Game playMastermind = new Game();
		
		code.codeGenerator();//check of code werkt
	//	playMastermind.showPlayer();//check of player werkt
		playMastermind.play();

		
	}//end main
}//end class MasterMind


class Game{
	Player player1 = new Player("Hen");
	Code code = new Code();
	Scanner scanner = new Scanner(System.in);

//	void showPlayer() {													//check of player werkt
//		System.out.println(player1.amountOfTurns + " " + player1.name);	//check of player werkt
//	}																	//check of player werkt
	
	void play() {
	//	System.out.println("Joepie, we gaan mastermind spelen");
	//	System.out.println("-- \t -- \t -- \t -- \t");
	//	System.out.println("Ik wil wel weten tegen wie ik speel, dus wat is je naam?");
	//	String playerName = scanner.nextLine();
	//	System.out.println("Hallo " + playerName + " ben jij wel oud genoeg?");
	//	int playerAge = scanner.nextInt();
	//	if(playerAge < 18) {
	//		System.out.println("Dat mag eigenlijk niet he? ");
	//		System.out.println("... \n \n \n");
	//		System.out.println("Maarja, was teveel gedoe om te coden, dus succes! (niet aan je mama vertellen hoor)");
	//	}else {
	//		System.out.println("welkom ouwe lul");
	//	}//end if else
		System.out.println("Klaar voor? we gaan MasterMind spelen. (druk s om te starten). Als je toch niet durft, mag je nu nog terug (q)");
		String input = scanner.nextLine();
		switch(input) {
		case "s": player1.guessing();
			break;
		case "q": System.out.println("bangerik! ");
		return;
		}
		player1.guessing();
	}
	
	
}

class Player{
	String name;
	int amountOfTurns;
	String guess= "";
	char [] guessChar = new char[4];
	String AllreadyGuessed = "";
	Player(String n){
		name = n;
		amountOfTurns = 12;
	}//end constructor class Player
	
	void guessing() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ik heb een code in mijn hoofd met 4 letters. De letters ABCDEF kunnen in de code zitten.");
		System.out.println("Letters mogen vaker voorkomen. Je hebt " + amountOfTurns + " keer om de code te kraken.");
		System.out.println("Veel succes!");
			while(amountOfTurns > 0) {
				System.out.println("Voer 4 letters in:");
				guess = scanner.nextLine().toUpperCase();
				amountOfTurns--;	
				guessChar = guess.toCharArray();
				
				for(int i = 0; i< guessChar.length; i++) {
					letterRightPlace(guess.charAt(i), Code.code.charAt(i));
					letterInIt(i);
				}//end for loop
			}//end while loop
	}//end method guessing

	void letterRightPlace(char g, char c) {		////staat een letter op de goede plek
		if(g == c) {
			System.out.println("Er staat er 1 op de goede plek");
		}//end if statement
	}//end method letterRightPlace
	
	void letterInIt(int i) {			////zit letter er uberhaupt in?
		int inIt = 0;
		for(int j = 0; j< Code.codeChar.length ; j++) {

			if(guess.charAt(i) == Code.code.charAt(j)
					&&
					guess.charAt(j) != Code.code.charAt(j)
					&&
					!contains(guess.charAt(i), AllreadyGuessed)
				) {
				inIt++;
				
				AllreadyGuessed += guess.charAt(i);
			}//end if statement
			
		}//end for loop
		if(inIt > 0) {
			System.out.println("er zitten er in " + inIt + " in, maar op de verkeerde plek");
		}
	}//end method letterInIt
	
			
	boolean contains(char c, String s) {         ///// zit letter in een string - returns trua als dat zo is
		boolean contains = false;
		//System.out.println(s); // check of string goed doorkomt
		for(int i = 0; i < s.length(); i++) {
			if(c == s.charAt(i)) {
				contains = true;
			}//end if statement
		}//end forloop
		//System.out.println(contains);// check of boolean klopt
		return contains;
	}//end method contains
			
		

}//end class Player
	
	
	
		
		
	


	
	
	


class Code{
	static String code = "";
	static char [] codeChar = new char [4];
	Random random = new Random();
	void codeGenerator() {
		for( int i = 0; i < 4 ; i++) {
			char letter = (char)(random.nextInt(6) + 65);//hoofdletter tussen de A en F
			code += letter;
		}//end for loop
		codeChar = code.toCharArray();
		System.out.println(code);//checken of code werkt en wat code is
	}//end codeGenerator
}//end class Code