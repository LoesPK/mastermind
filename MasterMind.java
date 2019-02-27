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
				
				for(int i = 0; i< guessChar.length; i++) {
					letterRightPlace(guess.charAt(i), Code.code.charAt(i));
					letterInIt(i);
				}
				
				//checkIfRightPlace();
			//	int inside = checkIfIsIn();
			//	if(inside >0) {
			//		System.out.println(inside + " letter(s) zitten er wel in, maar niet op de goede plek");
			//	}
				//for(int i = 0; i <guess.length(); i++) {
				//	System.out.println(guess.charAt(i));
			//	}//end for loop

			}//end while loop
	}//end method guessing
	
	
	
	
	void letterRightPlace(char g, char c) {
		if(g == c) {
			System.out.println(g + " staat op de goede plek");
		}else {
			System.out.println(g + " niet");
		}
	}
	
	void letterInIt(int i) {
		int zitErIn = 0;
		for(int j = 0; j< Code.codeChar.length ; j++) {
			if(guess.charAt(i) == Code.code.charAt(j)
					&&
					guess.charAt(j) != Code.code.charAt(j)
					//&&
				
				) {
				System.out.println(guess.charAt(i) + " zit er in");
			}
				
		}
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
		System.out.println(code);//checken of code werkt en wat code is
	}//end codeGenerator
}//end class Code