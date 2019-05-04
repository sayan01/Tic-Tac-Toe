package core;

import java.util.*;

public class TTT {
	
	private static Scanner sc;


	private static byte input(){
		System.out.print("\n1.  PvP or \n2.  PvC?\n");
		sc = new Scanner (System.in);
		byte ans;
		try{
			ans = sc.nextByte();
			if(ans !=1 && ans != 2){
				throw new Exception();

			}
		}catch (Exception e){
			System.out.println("Enter proper choice (1 or 2)");
			ans = input();
		}
		return ans;
		
	}

	public static void main(String[] args) {

		System.out.println("Welcome to Tic-Tac-Toe");
		int ans = input();
		switch(ans){
			case 1 : pvp();break;
			case 2 : //pvc();break;
			default : System.out.println("Internal Error");break;
		}

	}
	
	
	private static void pvp(){
		String [] el = new String [9];
		for (int i = 0;i<9;i++){
			el[i] = i+1+"";
		}

		sc = new Scanner (System.in);
		System.out.print("Enter player 1 name: ");
		String p1 = sc.next();
		sc.nextLine();
		System.out.print("Enter player 2 name: ");
		String p2 = sc.next();
		
		boolean p1t = true;
		boolean game = true;
		int c = 0;
		while(game){
			disp(el);
			c++;
			if(c>el.length){
				game = false;
				System.out.println("Draw!");
				break;
			}
			int choice = inp((p1t)?p1:p2);
			if (!Character.isDigit(el[choice-1].charAt(0))){
				System.out.println("Invalid Move");
				continue;
			}
			
			el[choice-1] = (p1t)?"X":"O";
			
			if(won(el)){
				
				game = false;
				disp(el);
				System.out.println("\n\n"+((p1t)?p1:p2)+" won the game!");
				break;
			}
			
			p1t = !p1t;
		}
		
	}

	private static boolean won(String[] el) {
	
		for(int i =0;i<3;i++){
			if(el[i].equals(el[i+3])&&el[i].equals(el[i+6])){
				return true;
			}
		}
		
		
		for(int i =0;i<9;i+=3){
			if(el[i].equals(el[i+1])&&el[i].equals(el[i+2])){
				return true;
			}
		}
		
		for(int i =0,b=4;i<3;i+=2,b-=2){
			if(el[i].equals(el[i+b])&&el[i].equals(el[i+b+b])){
				return true;
			}
		}
		
		
		return false;
		
		
	}

	private static int inp(String p) {
		
		sc = new Scanner (System.in);
		System.out.print("\n\n"+p+" enter your move: ");
		int choice;
		try{
			choice = sc.nextInt();
			if(choice>9||choice < 1) throw new Exception();
		}catch (Exception e){
			System.out.println("Invalid Input");
			choice = inp(p);
		}
		return choice;
		
		
	}
	
	

	private static void disp(String[] el) {
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		for(int i =0;i<el.length;i++){
			
			System.out.print(el[i]);
			
			if((i+1)%3==0){
				System.out.print("\n---------\n");
			}
			else{
				System.out.print(" | ");
			}
			
		}
		
	}
	
	

}
