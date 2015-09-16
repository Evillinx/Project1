import java.io.*;
import java.util.*;
/*
 * Purpose: Design and Analysis of Algorithms Assignment 1 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/03/2015
 * Submitted:  02/04/2015
 * Comment: test suite and sample run attached
 * @author: James Ortiz
 * @version: 2015.02.04
 */
public class NQueensFlip {
	
	private int[] board; //array for the board
	private int position = 0; // a place holder to represent row
	private int size; // holds size of board (n)
	private int compares = 0; // keeps track of number of entries
	private boolean all; // used for 1 solution or all solutions
	private int solutions = 0; // keeps track of the number of solutions
	
	/**
	 * Constructor for N Queens 
	 * @param n - The number of queens to place on an nxn board.
	 * @param t - Lets us know if user wants 1 or all solutions.
	 */
	public NQueensFlip(int n, boolean t) {
		if(n <  1) {
			System.out.println("Number must be greater than 0, cannot make a 0x0 or less board!");
		}
		else {
		size = n;
		board = new int[n];
		all = t;
	    if(n == 1) {
			baseCase();
		}
		else if(all == false){
		findBoard();
		}
		else {
			all();
		}
		System.out.println("A total of " + solutions + " solution(s) have been found!");
		System.out.println("Number of array entries performed: " + compares +"\n");
		}
	}
	
	/**
	 * 
	 * @return - n.
	 */
	public int boardSize() {
		return size;
	}
	
	/**
	 * Considers our base case of 1.
	 */
	public void baseCase() {
		printBoard();
		solutions++;
	}
	
	/**
	 * Method used to loop for all solutions.
	 */
	public void all()
	{
		while(board[0] <= (size-1)/2) {
			findBoard();
		}
	}
	
	/**
	 * Method used to find one solution.(This method gets looped via all() if all solutions needed.
	 */
	public void findBoard()
	{
		while(board[0] <= (size-1)/2 && position < size) {
			while(position < size && board[position] < size){
				if(!isAttacking()) {
					placeQueen();
				}
				else {
					board[position]++;
				}
			}
			if(position != size){
				backTrack();
			}
		} 
		if(board[0] <= (size-1)/2){
			solutions++;
			printBoard();
			if(board[0] < (size)/2 && all) {
				flipBoard();
				solutions++; 
				printBoard();
				flipBoard();
			}
			backTrack();
		}
	}
	
	/**
	 * Tests the other queens on the board to see if thier are conflicts. 
	 * @return - a true/false value letting us know if there is a conflict where the queen is placed.
	 */
	public boolean isAttacking() {
		boolean attacking = false;
		for(int c = 0; c< position; c++) {
			if(board[c] + c == position + board[position] || board[c] == board[position] || board[c] - c == (board[position] - position)) {
				attacking = true;
				c = position;
			}
			compares++;
			}
		return attacking;
	}
	
	/**
	 * "Places" the queen in the spot then jumps to next row.
	 */
	public void placeQueen(){
		position++;
		compares++;
	}
	
	/**
	 * Backtracks by going to the previous row after setting current row to 0 (no queen).
	 */
	public void backTrack(){
		if(position >= size){
			position--;
		}
		board[position--] = 0;
		board[position] = board[position] + 1;
		compares++;
	}
	
	/**
	 * Used to flip the nxn board to solve problem more efficently.
	 */
	public void flipBoard() {
		for(int c = 0; c < size;c++) {
			board[c] = size - (board[c] +1);
		}
	}
	
	/**
	 * Prints out a nxn representation of the board with the queens placed on it.
	 */
	public void printBoard()
	{
		System.out.println("Visual solution #"+solutions+" for a " + size  + " dimensional board is:");
		for(int c = 0; c< size; c++) {
			for(int x = 0; x< size; x++){
				if(x==board[c]) {
					System.out.print(" Q ");
				}
				else
					System.out.print(" * ");
			}
			System.out.println();
		}
	}
}
