import java.io.*;
import java.util.*;
public class NQueens {
	
	private int[] board;
	private int[] pos = new int[2];
	private int size;
	private int compares;
	private boolean all;
	private int solutions = 0;
	
	public NQueens(int n, boolean t) {
		size = n;
		board = new int[n];
		all = t;
		findBoard();
	}
	
	public int boardSize() {
		return size;
	}
	
	public void findBoard()
	{
		while(board[0] < size) {
			do {
		while(pos[0] < size && pos[1] < size){
			if(!isAttacking()) {
				placeQueen();
			}
			else {
			pos[1]++;
			}
		}
		if(pos[1] == size){
		if(pos[0] -1 != -1) {	
		backTrack();
		}
		else {
			return;
		} 
		}
		} while(pos[0] < size && pos[0] >= 0);
		solutions++;
		printBoard();
		backTrack();
		}
	}
	
	public boolean isAttacking() {
		boolean attacking = false;
		for(int c = 0; c< pos[0]; c++) {
		if(board[c] + c == pos[0] + pos[1] || board[c] == pos[1] || board[c] - c == (pos[1] - pos[0])) {
		attacking = true;
		}
		}
	return attacking;
	}
	
	public void placeQueen()
	{
		board[pos[0]] = pos[1];
		pos[1] = 0;
		pos[0]++;
	}
	
	public void backTrack()
	{
		pos[0]--;
		pos[1] = board[pos[0]] + 1;
	}
	
	public void printBoard()
	{
		System.out.println("Visual solution #"+solutions+" for a " + size  + " dimensional board is:");
		for(int c = 0; c< size; c++) {
		for(int x = 0; x< size; x++)
		{
			if(x==board[c]) {
				System.out.print(" Q ");
			}
			else
			System.out.print(" * ");
		}
		System.out.println();
		}
		System.out.println("Number of array entries performed " + compares);
	}
}
