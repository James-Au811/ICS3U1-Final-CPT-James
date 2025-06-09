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
		intRow = 0;
		String strChosenWord;
		strChosenWord = "";
		
		if(intChosenTheme == 1){
			TextInputFile food = new TextInputFile("foods.txt");
			strGameWord = new String [10][2];
			String strFood;
			while(food.eof()==false){
				intRand = (int)(Math.random()*100+1);
				strGameWord[intRow][0] = food.readLine();
				strGameWord [intRow][1] = intRand + "";
				intRow = intRow + 1;	
			}
			food.close();
			for(intCount = 0; intCount < 10-1; intCount++){
				for(intCount = 0; intCount < 10-1; intCount++){
					if(Integer.parseInt(strGameWord[intCount][1]) > Integer.parseInt(strGameWord[intCount+1][1])){
						strChosenWord = strGameWord[intCount][0]; 
					}
				}
			}
		}else if(intChosenTheme == 2){
			TextInputFile sport = new TextInputFile("sports.txt");
			strGameWord = new String [10][2];
			String strSport;
			while(sport.eof()==false){
				strSport = sport.readLine();
				intRand = (int)(Math.random()*100+1);
				strGameWord[intRow][0] = strSport;
				strGameWord [intRow][1] = intRand + "";
				intRow = intRow + 1;
			}	
			sport.close();
	
		}else if(intChosenTheme == 3){
			TextInputFile job = new TextInputFile("jobs.txt");
			strGameWord = new String [10][2];
			String strJob;
			while(job.eof()==false){
				strJob = job.readLine();
				intRand = (int)(Math.random()*100+1);
				strGameWord[intRow][0] = strJob;
				strGameWord [intRow][1] = intRand + "";
				intRow = intRow + 1;	
			}
			job.close();
		}else{
			con.println("Invalid Choice");
			con.closeConsole();
		}
	}
	//Putting User into leaderboard
		/*String strLeaderboard[][];
		int intUScore;
		intCount = 0;
		intUScore = 0; 
		strLeaderboard = new String[100000][2];
		strLeaderboard[intCount][intUScore] = strUName;
		intCount = intCount + 1;
		con.clear();
		con.repaint();
	}*/

	public static void highscore(Console con){
		
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.clear();
	}
	
	public static void addtheme(Console con){
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.clear();
		//Getting Name for new theme
		String strThemeName;
		con.println("Name your theme");
		strThemeName = con.readLine();
	public static void help(Console con){
		//Redraw Background for Game
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.setDrawColor(Color.WHITE);
		con.drawString("Rules", 600, 200);
		con.drawString("After choosing your game theme,", 430, 250);
		con.drawString("Start by guessing a letter in the missing word", 330, 300);
		con.drawString("- If you guess incorrectly, a piece of the hangman will be added", 280, 350);
		con.drawString("- If you guess incorrrectly 6 times, you LOSE the game", 330, 400);
		con.drawString("However, if you manage to guess the word before the hangman is complete,", 280, 450);
		con.drawString("Then you WIN", 570, 500);
	}
}	
