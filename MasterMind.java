import java.util.Random;
import java.util.Scanner;

public class MasterMind {
	public static void main(String[] args) {
		Code code = new Code();
		Game playMastermind = new Game();
		
		code.codeGenerator();//check of code werkt
	//	playMastermind.showPlayer();//check of player werkt
		playMastermind.play();
		System.out.println("bedankt voor het spelen");

		
	}//end main
}//end class MasterMind


class Game{
	Player player1 = new Player();
	Code code = new Code();
	Scanner scanner = new Scanner(System.in);
	boolean codeCorrect = false;
	Prompter prompter = new Prompter();
	
	
	void play() {
		prompter.welcomeMessage();
		while(true) {
			System.out.println("Klaar voor? we gaan MasterMind spelen. (druk s om te starten). Als je toch niet durft, mag je nu nog terug (q)");
			String input = scanner.nextLine();
			switch(input) {
			case "s": 
				System.out.println("Ik heb een code in mijn hoofd met 4 letters. De letters ABCDEF kunnen in de code zitten.");
				System.out.println("Letters mogen vaker voorkomen. Je hebt 12 keer om de code te kraken.");
				System.out.println("Veel succes!");
				guessing();
				break;
			case "q": System.out.println("bangerik! ");
				return;
			default: System.out.println("maak een keuze"); 
			}//end switch
//			guessing();
		}//end while
	}//end method play
	
	
	void guessing() {
		Scanner scanner = new Scanner(System.in);
			while(true) {
			//	System.out.println(player1.guess + " hallo"); // check of code geraden goed wordt opgeslagen
				
			//	System.out.println(codeCorrect); // check of codeCorrect is goede waarde
				player1.guess = scanner.nextLine().toUpperCase();
				while(player1.turn < 12 && codeCorrect == false) {
					System.out.println("Voer 4 letters in:");
					player1.guessChar = player1.guess.toCharArray();
					player1.turn++;	
					
					for(int i = 0; i< player1.guessChar.length; i++) {
						letterRightPlace(player1.guess.charAt(i), Code.code.charAt(i));
						letterInIt(i);
					}//end for loop
					
					
					codeCorrect = codeCompleted(player1.guess, Code.code);
					break;
				}//end while loop
				while(player1.turn >= 12 && player1.guess != Code.code) {
					System.out.println("Jammer joh, je beurten zijn op en je hebt de code niet gekraakt");
					System.out.println(code.code + " was de goede code");
					break;
				}
				while(player1.guess.equals(Code.code) ) {
					System.out.println("Leuk man, je hebt de code gekraakt");
					break;
				}
				continue;
			}//end while
	}//end method guessing
	
	
	void letterRightPlace(char g, char c) {		////staat een letter op de goede plek
		if(g == c) {
			System.out.println("Er staat er 1 op de goede plek");
		}//end if statement
	}//end method letterRightPlace
	
	void letterInIt(int i) {			////zit letter er uberhaupt in?
		int inIt = 0;
		int allesFout = 0;
		for(int j = 0; j< Code.codeChar.length ; j++) {

			if(player1.guess.charAt(i) == Code.code.charAt(j)
			&& player1.guess.charAt(j) != Code.code.charAt(j)
			&& !contains(player1.guess.charAt(i), player1.AllreadyGuessed)) 
			{
				inIt++;
				player1.AllreadyGuessed += player1.guess.charAt(i);
				System.out.println("er zit er " + inIt + " in, maar op de verkeerde plek");
			}//end if statement
		}//end for loop
//		if(inIt > 0) {
//			System.out.println("er zit er " + inIt + " in, maar op de verkeerde plek");
//		}//end if

	}//end method letterInIt
	
	boolean codeCompleted(String g, String c) {
		boolean codeGuessed = false;
	//	System.out.println(g);//check g
	//	System.out.println(c);//check c
		if(g.equals(c)) {
			codeGuessed = true;
		}
		return codeGuessed;
	}

	
			
	boolean contains(char c, String s) {         ///// zit letter in een string - returns true als dat zo is
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
}//end class Game




class Player{
	int turn;
	String guess= "";
	char [] guessChar = new char[4];
	String AllreadyGuessed = "";
	Player(){
		turn = 1;
	}
	
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
	//	System.out.println(code);//checken of code werkt en wat code is
	}//end codeGenerator
}//end class Code


class Prompter {
	Scanner scanner = new Scanner(System.in);
	void welcomeMessage() {
		System.out.println("Joepie, we gaan mastermind spelen");
		System.out.println("-- \t --- \t ---- \t ----- \t ---- \t --- \t --");
		System.out.println("Ik wil wel weten tegen wie ik speel, dus wat is je naam?");
		String playerName = scanner.nextLine();
		System.out.println("Hallo " + playerName + " ben jij wel oud genoeg? Voer je leeftijd in");
		int playerAge = scanner.nextInt();
		if(playerAge < 18) {
			System.out.println("Dat mag eigenlijk niet he? ");
			System.out.println("... \n...");
			System.out.println("Maarja, was teveel gedoe om te coden, dus succes! (niet aan je mama vertellen hoor)");
		}else {
			System.out.println("welkom ouwe lul");
		}//end if else
	}
}//end class prompter