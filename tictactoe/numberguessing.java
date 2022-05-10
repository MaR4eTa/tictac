import java.util.*;
import java.io.*;



public class numberguessing{ 

	static int playernum = 0;
	static int compnum = 0;
	static int maxscore = 0;
	static int playerscore = 0;
	static int computerscore = 0;

	static char state = 0 ;
	static void sleep(int mil){
		try{
			Thread.sleep(mil);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	static void player(){

		System.out.println("Enter a number (1-9) :");
		Scanner cin = new Scanner(System.in);
		int num_p = cin.nextInt();
		playernum = num_p;

	}

	static void design() {
		for (int i=0;i<22;i++){
			
			System.out.print("-");
			
			sleep(50);
		
		       
		}

		System.out.print("\n");
		
		
	}

	static void scoretable(){
		sleep(100);
		System.out.println("    SCORE TABLE");
		System.out.println("----------------------");
		System.out.print("| Player |");
		System.out.print(" Computer |\n");
		System.out.print("|    " + playerscore + "   |");
		System.out.print("    " +computerscore + "     |\n");
		System.out.println("----------------------");
		sleep(100);
		System.out.println("Press Enter to continue...");
		Scanner n = new Scanner(System.in);
		n.nextLine();
	}
		

	static void computer(){
	         Random rand = new Random();

		int[] num_arr = {1,2,3,4,5,6,7,8,9};
		int num_c = rand.nextInt(num_arr.length);

		compnum = num_arr[num_c]; 
	}

	static void game(){
		computerscore=0;
		playerscore=0;
		System.out.print("\033\143");
                System.out.println("Enter the max score to play(1-9) :");
		Scanner cin = new Scanner(System.in);
		maxscore = cin.nextInt();


		while(true){
		System.out.print("\033\143");


		
		design();
		player();
		computer();
		design();
		System.out.println("Number by player :" + playernum);
		System.out.println("Number by computer :" + compnum);
		design();
		if(playernum == compnum){
			playerscore++;
			System.out.println("Player gets 1 point ");
			
		}

		else if(playernum != compnum){
			computerscore++;
			System.out.println("Computer gets 1 point ");
		}

		design();
		scoretable();
		if(playerscore == maxscore){
			System.out.println("Congrats you win !!");
			break;
		}
		else if(computerscore == maxscore){
			System.out.println("Computer wins !! , Better luck next time !!");
			break;

		}
		}

	}


	public static void main(String[] args){
		System.out.println("NUMBER GUESSING GAME !! ");
		System.out.println("Enter p to play or q to quit");
		Scanner cin = new Scanner(System.in);
		state = cin.next().charAt(0);
		while(state !='q'){

		if(state == 'q'){
			break;
		}
			game();
		System.out.println("Enter p to play again or q to quit");
		state = cin.next().charAt(0);

		}
		System.out.println("Thanks for playing !!");
	}
}
