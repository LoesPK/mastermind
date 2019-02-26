import java.util.Random;
import java.util.Scanner;

public class MasterMind {
	public static void main(String[] args) {
		Code code = new Code();
		Game playMastermind = new Game();
		
		code.codeGenerator();//check of code werkt
		playMastermind.showPlayer();//check of player werkt
		playMastermind.play();

		
	}//end main
}//end class MasterMind


class Game{
	Player player1 = new Player("Henk");
	Code code = new Code();
	
	
	void showPlayer() {													//check of player werkt
		System.out.println(player1.amountOfTurns + " " + player1.name);	//check of player werkt
	}																	//check of player werkt
	
	void play() {
		player1.guessing();
	}
	
	
}

class Player{
	String name;
	int amountOfTurns;
	String guess= "";
	char [] guessChar = new char[4];
	
	Player(String n){
		name = n;
		amountOfTurns = 12;
	}//end constructor
	
	void guessing() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("u kunt nu gaan gokken (boven de 18).");
			while(amountOfTurns > 0) {
				System.out.println("Voer 4 letters in:");
				guess = scanner.nextLine().toUpperCase();
				amountOfTurns--;	
				guessChar = guess.toCharArray();
				check();
				//for(int i = 0; i <guess.length(); i++) {
				//	System.out.println(guess.charAt(i));
			//	}//end for loop

			}//end while loop
	}//end method guessing
	
	
	void check() {
		for(char letter : guessChar) {
			
			System.out.println("letter " + letter);
			
			for(int i = 0; i<Code.codeChar.length; i++) {
				System.out.println(Code.codeChar[i]);
				if(letter == Code.codeChar[i]) {
				System.out.println("van harte " + letter + " staat op de goede plek");	

			}
			}
			
		}
		
		
		
		/*for(int i = 0; i< Code.codeChar.length; i++) {
			System.out.println(i + "i");
			System.out.println(Code.codeChar[i] + "letter op plek i in code");
			System.out.println(guessChar[i] + "letter op plek i in guess");

			if(guessChar[i] == Code.codeChar[i]) {

				System.out.println("De letter " + guessChar[i] + " staat op de goede plek. (" + (i +1) + ").");
				i++;
			}


		*/
	}
	
/*	void checkGuess() {
		for(int i = 0; i <guess.length(); i++) {
			if(guess.charAt(i) == Code.code.charAt(i))
			System.out.println("De letter " + guess.charAt(i) + " staat op de goede plek. (" + (i +1) + ").");
			break;
			//else if(guess.charAt(i) == );
		//	System.out.println(guess.charAt(i) + " zit er wel in.");
		}//end for loop
	}
*/	
		
		

	
	
	
}//end class Player

class Code{
	String code = "";
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