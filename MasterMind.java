import java.util.Random;
import java.util.Scanner;

public class MasterMind {
	public static void main(String[] args) {

		Game playMastermind = new Game();
	//	playMastermind.showPlayer();//check of player werkt
		playMastermind.play();
		System.out.println("bedankt voor het spelen");

		
	}//end main
}//end class MasterMind


class Game{
	Player player1 = new Player();
	Scanner scanner = new Scanner(System.in);
	boolean codeCorrect = false;
	Prompter prompter = new Prompter();
	String normalizedGuess = "";
	char[] normalizedGuessChar = new char[4]; 
	int inIt = 0;
	int correctLetters = 0;
	
	
	void play() {
		prompter.welcomeMessage();
		while(true) {
			System.out.println("Klaar voor? we gaan MasterMind spelen. (druk s om te starten). Als je toch niet durft, mag je nu nog terug (q)");
			String input = scanner.nextLine();
			switch(input) {
			case "s": 
				Code.codeGenerator();
				System.out.println("Ik heb een code in mijn hoofd met 4 letters. De letters ABCDEF kunnen in de code zitten.");
				System.out.println("Letters mogen vaker voorkomen. Je hebt 12 keer om de code te kraken.");
				System.out.println("Veel succes!");
				guessing();
				break;
			case "q": System.out.println("bangerik! ");
				System.exit(0);;
			default: System.out.println("maak een keuze"); 
			}//end switch
//			guessing();
		}//end while
	}//end method play
	
	
	void guessing() {
			while(true) {
				
				while(player1.turn < 12 && codeCorrect == false) {
					System.out.println("Voer 4 letters in:");
					player1.guess = scanner.nextLine();
					player1.guessChar = player1.guess.toCharArray();
					normalizedGuess = player1.normalizeInput();
					System.out.println(normalizedGuess);//check of normalizedguess goed gaat
					normalizedGuessChar = normalizedGuess.toCharArray();
					inIt = 0;
					correctLetters = 0;
					player1.turn++;	
					
					//System.out.println(player1.turn);//checken hoeveelste beurt
					

					for(int i = 0; i< normalizedGuess.length(); i++) {
						System.out.println("in controle");//checken of hij in controle van letters komt
						letterCheck(normalizedGuess.charAt(i), Code.code.charAt(i), i);
						
					}//end for loop
					
					System.out.println("er zitten er " + inIt + " in, maar op de verkeerde plek");
					System.out.println("Er staan er " + correctLetters + " op de goede plek");
					
					//player1.AllreadyGuessed = "";
					codeCorrect = codeCompleted(player1.guess, Code.code);
					break;
				}//end while loop
				while(player1.turn >= 12 && player1.guess != Code.code) {
					System.out.println("Jammer joh, je beurten zijn op en je hebt de code niet gekraakt");
					System.out.println(Code.code + " was de goede code");
					break;
				}
				while(normalizedGuess.equals(Code.code) ) {
					System.out.println("Leuk man, je hebt de code gekraakt");
					break;
				}
				continue;
			}//end while
	}//end method guessing
	
	
	void letterCheck(char g, char c, int i) {		////staat een letter op de goede plek
		if(g == c) {
			correctLetters++;
			System.out.println(g);
			normalizedGuessChar[g] = 'H';
			Code.codeChar[c] = 'I';
			System.out.println(normalizedGuess);
		}//end if statement
		for(int j = 0; j< Code.codeChar.length ; j++) { 
			if(normalizedGuess.charAt(i) == Code.code.charAt(j) //check of ergens er in
			&& normalizedGuess.charAt(j) != Code.code.charAt(j) //check of exact zelfde plek 
			)
			{
				System.out.println(normalizedGuess + " " + Code.code);
				normalizedGuessChar[i] = 'H';
				Code.codeChar[j] = 'I';
				inIt++;	
			}//end if statement
		}//end for loop
	}//end method letterCheck

	
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
	
	
	int reset(int i) {
		return 0;
	}
	
}//end class Game




class Player{
	Scanner scanner = new Scanner(System.in);
	int turn;
	String guess= "";
	char [] guessChar = new char[1000];
	
	char[] guessCharNormalized = new char[4];
	String AllreadyGuessed = "";
	Player(){
		turn = 1;
	}
	
	
	String normalizeInput() { //normalizen van de input van de speler
		System.out.println("in normalized");
//		int digitInIt = 0;
		String g = guess;
		System.out.println(guess);
		while(true) {
			System.out.println("hallo?");
//			out:
//			for(char C : guessChar) {//controle voor digit doet deze controle maar 1 keer, dus als iemand 2 keer achter elkaar cifers in voert controleert hij niet meer.
//				while(Character.isDigit(C)) {
//					digitInIt++;
//				}
//				while(digitInIt>0) {//normalize digit
//					System.out.println("U heeft getallen ingevoerd ipv letters. Voer een nieuwe code in");
//					g = scanner.nextLine();
//					guessChar = g.toCharArray();
//					break out;
//				}//end while digit	
//				while(digitInIt ==0) {
//					continue;
//				}
//			}//end forloop												//////////////   !!werkt niet !!
//			System.out.println(digitInIt); //checken of digitinit werkt
				
			System.out.println("problemen?");
			out:
			while(guess.length()> 4 && g.length()>4)  { //trimmen van code als langer dan 4 letters
				g = guess.substring(0, 4);
				System.out.println("Je hebt meer dan 4 letters getypt, ik gebruik alleen de eerste 4 letters.");
				System.out.println(g);
				if(g.length() != 4) {
					break out;
				}
				else {
					continue;
				}
			}//end while length
			out:
			while(guess.length()<4 && g.length()<4) { // aangeven als te korte code
				System.out.println("Je hebt te weinig letters getypt, voer 4 letters in");
				g = scanner.nextLine();
				if(g.length() != 4) {
					break out;
				}else {
					continue;
				}
			}//end while te kort
			System.out.println("problemen?");
			return g.toUpperCase();
		}
		
	}//end normalizing
	
}//end class Player
	
	

class Code{
	static String code = "";
	static char [] codeChar = new char [4];
	static Random random = new Random();
	static void codeGenerator() {
		for( int i = 0; i < 4 ; i++) {
			char letter = (char)(random.nextInt(6) + 65);//hoofdletter tussen de A en F
			code += letter;
		}//end for loop
		codeChar = code.toCharArray();
		System.out.println(code);//checken of code werkt en wat code is
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