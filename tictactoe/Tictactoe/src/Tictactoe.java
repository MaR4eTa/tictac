import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Tictactoe {

	
	static char[][] board = {{' ','|',' ','|',' '},
			 {'-','+','-','+','-'},	
			 {' ','|',' ','|',' '},
			 {'-','+','-','+','-'},
			 {' ','|',' ','|',' '},

	};
	
	private static Scanner cin;
	
	static void Board() {
	
	for(char[] row : board) {
		for(char c : row) {
			System.out.print(c);
		}
		System.out.println();
	}
	
	}
	static void winmoves() {
		List toprow =  Arrays.asList(1, 2, 3);
		List midrow =  Arrays.asList(4, 5, 6);
		List botrow =  Arrays.asList(7, 8, 9);
		List leftcol =  Arrays.asList(1, 4, 7);
		List rightcol = Arrays.asList(3, 6, 9);
		List midcol =  Arrays.asList(2, 5, 8);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 =  Arrays.asList(3, 5, 7);
		
	    List<List> winmoves = new ArrayList<List>();
		winmoves.add(toprow);
		winmoves.add(midrow);
		winmoves.add(botrow);
		winmoves.add(leftcol);
		winmoves.add(rightcol);
		winmoves.add(midcol);
		winmoves.add(cross1);
		winmoves.add(cross2);
	}
	
	static void computer() {
		Random rand = new Random();
		int compmove = rand.nextInt(10);
		switch(compmove) {
		case 1:
			board[0][0] = 'O';
			break;
		case 2:
			board[0][2] = 'O';
			break;
		case 3:
			board[0][4] = 'O';
			break;
		case 4:
			board[2][0] = 'O';
			break;
		case 5:
			board[2][2] = 'O';
			break;
		case 6:
			board[2][4] = 'O';
			break;
		case 7:
			board[4][0] = 'O';
			break;
		case 8:
			board[4][2] = 'O';
			break;
		case 9:
			board[4][4] = 'O';
			break;
		}
		
	}
	static void player() {
		System.out.println("Enter a number to place : ");
		cin = new Scanner(System.in);
		
		int playerpos = cin.nextInt();
		cin.nextLine();
		switch(playerpos) {
		case 1:
			board[0][0] = 'X';
			break;
		case 2:
			board[0][2] = 'X';
			break;
		case 3:
			board[0][4] = 'X';
			break;
		case 4:
			board[2][0] = 'X';
			break;
		case 5:
			board[2][2] = 'X';
			break;
		case 6:
			board[2][4] = 'X';
			break;
		case 7:
			board[4][0] = 'X';
			break;
		case 8:
			board[4][2] = 'X';
			break;
		case 9:
			board[4][4] = 'X';
			break;
		}
	}
	static boolean gameover() {
		int found = 0;
		for(char[] row : board) {
			for(char c : row) {
				if(c==' ') {
					found = 1;
				}
				
			}
		}
		if(found==0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		while(gameover()) {
			Board();
			player();
			
			
		}
		Board();
		System.out.println("Game over");
		
	}
}
