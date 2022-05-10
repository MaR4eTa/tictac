
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class tictactoe {
	
	static char[] board = new char[10];
	static char[] letter = {'O','X'};
	
	static List<Integer> possiblemoves = new ArrayList<Integer>();
	static Random rand = new Random();
	static Scanner cin = new Scanner(System.in);
	private static void setboard() {
		for(int c = 0;c<board.length;c++) {
			board[c] =' ';
		}
	}
	private static void drawboard() {
		
		System.out.println(board[1]+"|"+board[2]+"|"+board[3]);
		System.out.println("-"+"+"+"-"+"+"+"-");
		System.out.println(board[4]+"|"+board[5]+"|"+board[6]);
		System.out.println("-"+"+"+"-"+"+"+"-");
		System.out.println(board[7]+"|"+board[8]+"|"+board[9]);
		
	
		
	}
	private static boolean checkwinner(char[] bo,char le) {
		if(bo[1]==le && bo[2]==le && bo[3]==le) {
			return true;
		} if(bo[4]==le && bo[5]==le && bo[6]==le) {
			return true;
		} if(bo[7]==le && bo[8]==le && bo[9]==le) {
			return true;
		} if(bo[1]==le && bo[4]==le && bo[7]==le) {
			return true;
		} if(bo[2]==le && bo[5]==le && bo[8]==le) {
			return true;
		} if(bo[3]==le && bo[6]==le && bo[9]==le) {
			return true;
		} if(bo[1]==le && bo[5]==le && bo[9]==le) {
			return true;
		} if(bo[3]==le && bo[5]==le && bo[7]==le) {
			return true;
		}
		
		return false;
	}
	private static void placemove(int pos ,char let) {
		board[pos] = let;
		
	}
	private static boolean isFree(int pos) {
		if(board[pos]!=' ') {
			return false;
		}
		return true;
	}
	private static void player() {
		int player_pos;
		boolean run = true;
		while(run) {
		System.out.println("Select a position to place X (1-9):");
		player_pos = cin.nextInt();
			
			
				if(player_pos > 0 && player_pos < 10) {
					if(isFree(player_pos)) {
					run = false;
					placemove(player_pos,'X');
					}else {
					System.out.println("Sorry the space is taken please select another one");
					}
				}
				else {
				System.out.println("Please enter a number within range");
				}
				
			}
		}
	
	private static int computer() {
		possiblemoves.clear();
		int k = 0;
		int compmove = 0;
		for(int c=1;c<board.length;c++) {
			if(board[c]==' ') {
				k=c;
				possiblemoves.add(k);
			}
		}
		
		for(char let : letter) {
		for(int i  : possiblemoves) {
			char[] boardcopy = board.clone();
			boardcopy[i] = let;
			if(checkwinner(boardcopy,let)) {
				System.out.println(checkwinner(boardcopy,let));
				compmove = i;
				return compmove;
			}
		}
		}
		List<Integer> corners = Arrays.asList(1,3,7,9);
		List<Integer> edges = Arrays.asList(2,4,6,8);
		List<Integer>  getcorners = new ArrayList<Integer>();
		List<Integer>  getedges = new ArrayList<Integer>();
			for(int a : corners) {
				if(possiblemoves.contains(a)) {
					getcorners.add(a);
				}
			}
			for (int a : edges ) {
				if(possiblemoves.contains(a)) {
					getedges.add(a);
				}
			}
			if(getcorners.size()>0) {
				compmove = getcorners.get(rand.nextInt(getcorners.size()));
				return compmove;
			}
			if(getedges.size()>0) {
				compmove = getedges.get(rand.nextInt(getedges.size()));
				return compmove;
			}
			if(possiblemoves.contains(5)) {
				compmove =5;
				return compmove;
			}
		return compmove;
	}
	private static boolean isBoardFull() {
		int found = 0;
		for(int c = 1;c<board.length;c++) {
			if(board[c]==' ') {
				found = 1;
			}
		}
		if(found == 1) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		setboard();
		drawboard();
		while(!isBoardFull()) {
		if(!checkwinner(board,'O')) {
			player();
			drawboard();
		}else {
			System.out.println("Computer Wins");
			break;
		}
		
		if(!checkwinner(board,'X')) {
			int move = computer();
			placemove(move,'O');
			System.out.println("Computer chose :" + move);
			drawboard();
		}else {
			System.out.println("Player Wins");
			break;
		}
		
		if(isBoardFull() && !checkwinner(board,'X') &&!checkwinner(board,'O') ) {
			System.out.println("Draw");
			break;
		}
		}
		
		drawboard();
	}

}
