import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTJames{
	public static void main(String[] args){
		
		boolean blnGame = true;
		while(true){
			
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
		String strChosenTheme;
		con.println("Choose your theme: ");
		while(themes.eof()==false){
			strTheme = themes.readLine();
			con.println(strTheme);
		}
		strChosenTheme = con.readLine();
		
		//If Statement for Theme Choice
		String strF;
		strF = "Food";
		String strS;
		strS = "Sports";
		String strJ;
		strJ = "Jobs";
		
		String strGameWord[][];
		int intRand;
		String strWord;
		int intRow;
		int intColumn;
		intRow = 0;
		intColumn = 0;
		if(strChosenTheme.equals(strF)){
			TextInputFile food = new TextInputFile("foods.txt");
			strGameWord = new String [intRow][intColumn];
			String strFood;
			while(food.eof()==false){
				strFood = food.readLine();
				intRand = (int)(Math.random()*100+1);
				strGameWord[intRow][intColumn] = strFood;
				intColumn = intColumn + 1;
				con.println(strGameWord[intRow][intColumn]);
				strGameWord [intRow][intColumn] = intRand + "";
				intRow = intRow + 1;
				con.println(strGameWord[intRow][intColumn]);
			
			}
			
		}
			
		//Putting User into leaderboard
		String strLeaderboard[][];
		int intCount;
		int intUScore;
		intCount = 0;
		intUScore = 0; 
		strLeaderboard = new String[100000][2];
		strLeaderboard[intCount][intUScore] = strUName;
		intCount = intCount + 1;
		
		
		con.clear();
		con.fillRect(0,0,1280,720);
		
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
		con.clear();
	}
	
	public static void jokes(Console con){
		
		//Redraw Background for Game
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.clear();
	}
}	
		//TextInputFile themes = new TextInputFile("themes.txt");
		//String strTheme;
		
		//con.println("Choose your theme");
		//while(themes.eof() == false){
			//strTheme = themes.readLine();
			//con.println(strTheme);
		//}
		//themes.close();
		//String strChosenTheme;
		//strChosenTheme = con.readLine();
		
		//String strFoods;
		//String strSports;
		//String strJobs;
		//strFoods = "Foods";
		//strSports = "Sports";
		//strJobs = "Jobs";
		
		//if(strChosenTheme.equals(strFoods)){
			//TextInputFile food = new TextInputFile("foods.txt");
			//String strWords[][];
			//strWords = new String [10][2]
			//int int
		//}else if(strChosenTheme.equals(strSports)){
			//TextInputFile sports = new TextInputFile("sports.txt");
			//sports.close();
		//}else if(strChosenTheme.equals(strJobs)){
			//TextInputFile jobs = new TextInputFile("jobs.txt");
			//jobs.close();
		//}else{
			//con.println("Invalid Theme");
		//}


