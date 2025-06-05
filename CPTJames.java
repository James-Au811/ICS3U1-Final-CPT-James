import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTJames{
	public static void main(String[] args){
		

			
			Console con = new Console("Hangman", 1280, 720);
			CPTJamesMethods.consoleSetup(con);
			con.repaint();
			
			//User Menu Selection Choice
			char charChoice;
			charChoice = con.getChar();
			System.out.println("Entered character: "+charChoice);
		
			//User Choice Result If Statement
			if(Character.toUpperCase(charChoice) == 'P'){
				play(con);
			}else if(Character.toUpperCase(charChoice) == 'L'){
				highscore(con);
			}else if(Character.toUpperCase(charChoice) == 'T'){
				addtheme(con);
			}else if(Character.toUpperCase(charChoice) == 'Q'){
				con.closeConsole();
			}else if(Character.toUpperCase(charChoice) == 'H'){
				help(con);
			}else if(Character.toUpperCase(charChoice) == 'J'){
				jokes(con);
			}
		}		
		
		
	public static void play(Console con){	

		//Redraw Background for Game
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.clear();
		//Getting User Name
		String strUName;
		con.println("What is your name?");
		strUName = con.readLine();
		
		//Choosing Theme
		TextInputFile themes = new TextInputFile("themes.txt");
		String strTheme;
		int intChosenTheme;
		con.println("Choose your theme by picking the corresponding number: ");
		int intCount;
		intCount = 1;
		while(themes.eof()==false){
			strTheme = themes.readLine();
			con.println(strTheme + " - " + intCount);
			intCount = intCount + 1;
		}
		intChosenTheme = con.readInt();
		themes.close();
		con.clear();
		
		//If Statement for Theme Choice
		
		String strGameWord[][];
		int intRand;
		String strWord;
		int intRow;
		int intColumn;
		intRow = 0;
		intColumn = 0;
		
		if(intChosenTheme == 1){
			TextInputFile food = new TextInputFile("foods.txt");
			strGameWord = new String [intRow][intColumn];
			String strFood;
			while(food.eof()==false){
				strFood = food.readLine();
				intRand = (int)(Math.random()*100+1);
				strGameWord[intRow][intColumn] = strFood;
				intColumn = intColumn + 1;
				strGameWord [intRow][intColumn] = intRand + "";
				intRow = intRow + 1;	
			}
			food.close();
			gamescreen(con);
		}else if(intChosenTheme == 2){
			TextInputFile sport = new TextInputFile("sports.txt");
			strGameWord = new String [intRow][intColumn];
			String strSport;
			while(sport.eof()==false){
				strSport = sport.readLine();
				intRand = (int)(Math.random()*100+1);
				strGameWord[intRow][intColumn] = strSport;
				intColumn = intColumn + 1;
				strGameWord [intRow][intColumn] = intRand + "";
				intRow = intRow + 1;
			}	
			sport.close();
			gamescreen(con);					
		}else if(intChosenTheme == 3){
			TextInputFile job = new TextInputFile("jobs.txt");
			strGameWord = new String [intRow][intColumn];
			String strJob;
			while(job.eof()==false){
				strJob = job.readLine();
				intRand = (int)(Math.random()*100+1);
				strGameWord[intRow][intColumn] = strJob;
				intColumn = intColumn + 1;
				strGameWord [intRow][intColumn] = intRand + "";
				intRow = intRow + 1;	
			}
			job.close();
			gamescreen(con);
		}else{
			con.println("Invalid Choice");
			con.closeConsole();
		}
		
			
		//Putting User into leaderboard
		String strLeaderboard[][];
		int intUScore;
		intCount = 0;
		intUScore = 0; 
		strLeaderboard = new String[100000][2];
		strLeaderboard[intCount][intUScore] = strUName;
		intCount = intCount + 1;
		
		
		con.clear();
		con.repaint();
		
	}
	
	public static void gamescreen(Console con){
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.clear();
	}
	public static void highscore(Console con){
		
		//Redraw Background for Game
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.clear();
	}
	
	public static void addtheme(Console con){
		//Redraw Background for Game
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.clear();
	}
	
	public static void help(Console con){
		//Redraw Background for Game
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.drawString("Rules", 520, 200);
	}
	
	public static void jokes(Console con){
		
		//Redraw Background for Game
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.clear();
	}
}	



