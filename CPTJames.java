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
		String strName;
		con.println("What is your name?");
		strName = con.readLine();
		
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
			//Putting words from chosen theme file into 2d array
			while(food.eof()==false){
				intRand = (int)(Math.random()*100+1);
				strGameWord[intRow][0] = food.readLine();
				strGameWord [intRow][1] = intRand + "";
				intRow = intRow + 1;	
			}
			food.close();
			//Bubble Sort for Chosen Game Word 
			for(intCount = 0; intCount < 10-1; intCount++){
				for(intCount = 0; intCount < 10-1; intCount++){
					if(Integer.parseInt(strGameWord[intCount][1]) > Integer.parseInt(strGameWord[intCount+1][1])){
						strChosenWord = strGameWord[intCount][0]; 
					}
				}
			}
			con.clear();
			//Basic Setup for Game Screen
			int intLives;
			intLives = 6;
			con.setDrawColor(Color.WHITE);
			BufferedImage imgbase = con.loadImage("base.png");
			con.drawImage(imgbase, 900, 10);
			//Variables for Guessing System
			boolean blnFinish;
			blnFinish = false;
			String strLetter;
			String strGuess; 
			String strRevealWord;
			String strPrevReveal;
			strPrevReveal = "";
			strRevealWord = "";
			int intWordLength = strChosenWord.length();
			boolean blnCorrect = false;
			
			// Creates a string array and fills it with underscores
			String[] strGuessWord = new String[intWordLength];
			for (intCount = 0; intCount < intWordLength; intCount++) {
				strGuessWord[intCount] = "_";
			}
			
			
			//Letter Guessing System for Game
			while(blnFinish == false){
				con.println("Guess a letter (In LOWERCASE)");
				strGuess = con.readLine();
				blnCorrect = false;
				
				// Loops through each letter in the word and checks if its correct
				for(intCount = 0; intCount < intWordLength; intCount++){
					strLetter = strChosenWord.substring(intCount, intCount + 1);
					if(strGuess.equals(strLetter)){
						strGuessWord[intCount] = strGuess;
						blnCorrect = true;
					}
				}
				
				// Print out the reveal word with the missing and correct letters
				strRevealWord = "";
				for(intCount = 0; intCount < intWordLength; intCount++){
					strRevealWord += strGuessWord[intCount];
				}
				con.println(strRevealWord);
				//Images for amount of lives user has left
				if(!blnCorrect){
					intLives = intLives - 1;
					if(intLives == 5){
						BufferedImage imghead = con.loadImage("head.png");
						con.drawImage(imghead, 900, 10);
					}else if(intLives == 4){
						BufferedImage imgbody = con.loadImage("body.png");
						con.drawImage(imgbody, 900, 10);
					}else if(intLives == 3){
						BufferedImage imglarm = con.loadImage("larm.png");
						con.drawImage(imglarm, 900, 10);		
					}else if(intLives == 2){
						BufferedImage imgrarm = con.loadImage("rarm.png");
						con.drawImage(imgrarm, 900, 10);	
					}else{
						BufferedImage imgLleg = con.loadImage("Lleg.png");
						con.drawImage(imgLleg, 900, 10);
					}
				}
				// Check if player won
				if(strRevealWord.equals(strChosenWord)){
					blnFinish = true;
					win(con, strName, intLives);
				}
				// Check if player lost
				if(intLives == 0){
					blnFinish = true;
					lose(con, strName, intLives);
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
			//Putting words from chosen theme file into 2d array
			while(sport.eof()==false){
				intRand = (int)(Math.random()*100+1);
				strGameWord[intRow][0] = sport.readLine();
				strGameWord [intRow][1] = intRand + "";
				intRow = intRow + 1;	
			}
			sport.close();
			//Bubble Sort for Chosen Game Word 
			for(intCount = 0; intCount < 10-1; intCount++){
				for(intCount = 0; intCount < 10-1; intCount++){
					if(Integer.parseInt(strGameWord[intCount][1]) > Integer.parseInt(strGameWord[intCount+1][1])){
						strChosenWord = strGameWord[intCount][0]; 
					}
				}
			}
			con.clear();
			//Basic Setup for Game Screen
			int intLives;
			intLives = 6;
			con.setDrawColor(Color.WHITE);
			BufferedImage imgbase = con.loadImage("base.png");
			con.drawImage(imgbase, 900, 10);
			//Variables for Guessing System
			boolean blnFinish;
			blnFinish = false;
			String strLetter;
			String strGuess; 
			String strRevealWord;
			String strPrevReveal;
			strPrevReveal = "";
			strRevealWord = "";
			int intWordLength = strChosenWord.length();
			boolean blnCorrect = false;
			
			// Creates a string array and fills it with underscores
			String[] strGuessWord = new String[intWordLength];
			for (intCount = 0; intCount < intWordLength; intCount++) {
				strGuessWord[intCount] = "_";
			}
			
			
			//Letter Guessing System for Game
			while(blnFinish == false){
				con.println("Guess a letter (In LOWERCASE)");
				strGuess = con.readLine();
				con.clear();
				blnCorrect = false;
				
				// Loops through each letter in the word and checks if its correct
				for(intCount = 0; intCount < intWordLength; intCount++){
					strLetter = strChosenWord.substring(intCount, intCount + 1);
					if(strGuess.equals(strLetter)){
						strGuessWord[intCount] = strGuess;
						blnCorrect = true;
					}
				}
				
				// Print out the reveal word with the missing and correct letters
				strRevealWord = "";
				for(intCount = 0; intCount < intWordLength; intCount++){
					strRevealWord += strGuessWord[intCount];
				}
				con.println(strRevealWord);
				//Images for amount of lives user has left
				if(!blnCorrect){
					intLives = intLives - 1;
					if(intLives == 5){
						BufferedImage imghead = con.loadImage("head.png");
						con.drawImage(imghead, 900, 10);
					}else if(intLives == 4){
						BufferedImage imgbody = con.loadImage("body.png");
						con.drawImage(imgbody, 900, 10);
					}else if(intLives == 3){
						BufferedImage imglarm = con.loadImage("larm.png");
						con.drawImage(imglarm, 900, 10);		
					}else if(intLives == 2){
						BufferedImage imgrarm = con.loadImage("rarm.png");
						con.drawImage(imgrarm, 900, 10);	
					}else{
						BufferedImage imgLleg = con.loadImage("Lleg.png");
						con.drawImage(imgLleg, 900, 10);
					}
				}
				// Check if player won
				if(strRevealWord.equals(strChosenWord)){
					blnFinish = true;
					win(con, strName, intLives);
				}
				// Check if player lost
				if(intLives == 0){
					blnFinish = true;
					lose(con, strName, intLives);
				}
			}
	
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
			//Putting words from chosen theme file into 2d array
			while(job.eof()==false){
				intRand = (int)(Math.random()*100+1);
				strGameWord[intRow][0] = job.readLine();
				strGameWord [intRow][1] = intRand + "";
				intRow = intRow + 1;	
			}
			job.close();
			//Bubble Sort for Chosen Game Word 
			for(intCount = 0; intCount < 10-1; intCount++){
				for(intCount = 0; intCount < 10-1; intCount++){
					if(Integer.parseInt(strGameWord[intCount][1]) > Integer.parseInt(strGameWord[intCount+1][1])){
						strChosenWord = strGameWord[intCount][0]; 
					}
				}
			}
			con.clear();
			//Basic Setup for Game Screen
			int intLives;
			intLives = 6;
			con.setDrawColor(Color.WHITE);
			BufferedImage imgbase = con.loadImage("base.png");
			con.drawImage(imgbase, 900, 10);
			//Variables for Guessing System
			boolean blnFinish;
			blnFinish = false;
			String strLetter;
			String strGuess; 
			String strRevealWord;
			String strPrevReveal;
			strPrevReveal = "";
			strRevealWord = "";
			int intWordLength = strChosenWord.length();
			boolean blnCorrect = false;
			
			// Creates a string array and fills it with underscores
			String[] strGuessWord = new String[intWordLength];
			for (intCount = 0; intCount < intWordLength; intCount++) {
				strGuessWord[intCount] = "_";
			}
			
			
			//Letter Guessing System for Game
			while(blnFinish == false){
				con.println("Guess a letter (In LOWERCASE)");
				strGuess = con.readLine();
				blnCorrect = false;
				
				// Loops through each letter in the word and checks if its correct
				for(intCount = 0; intCount < intWordLength; intCount++){
					strLetter = strChosenWord.substring(intCount, intCount + 1);
					if(strGuess.equals(strLetter)){
						strGuessWord[intCount] = strGuess;
						blnCorrect = true;
					}
				}
				
				// Print out the reveal word with the missing and correct letters
				strRevealWord = "";
				for(intCount = 0; intCount < intWordLength; intCount++){
					strRevealWord += strGuessWord[intCount];
				}
				con.println(strRevealWord);
				//Images for amount of lives user has left
				if(!blnCorrect){
					intLives = intLives - 1;
					if(intLives == 5){
						BufferedImage imghead = con.loadImage("head.png");
						con.drawImage(imghead, 900, 10);
					}else if(intLives == 4){
						BufferedImage imgbody = con.loadImage("body.png");
						con.drawImage(imgbody, 900, 10);
					}else if(intLives == 3){
						BufferedImage imglarm = con.loadImage("larm.png");
						con.drawImage(imglarm, 900, 10);		
					}else if(intLives == 2){
						BufferedImage imgrarm = con.loadImage("rarm.png");
						con.drawImage(imgrarm, 900, 10);	
					}else{
						BufferedImage imgLleg = con.loadImage("Lleg.png");
						con.drawImage(imgLleg, 900, 10);
					}
				}
				// Check if player won
				if(strRevealWord.equals(strChosenWord)){
					blnFinish = true;
					win(con, strName, intLives);
				}
				// Check if player lost
				if(intLives == 0){
					blnFinish = true;
					lose(con, strName, intLives);
				}
			}
		}else{
			con.println("Invalid Choice");
			con.closeConsole();
		}
	}
	
	public static void win(Console con, String strName, int intLives){
		
		//Redraw Background for win screen
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.clear();
		con.setDrawColor(Color.WHITE);
		con.drawString("YOU WIN", 640, 30);
		BufferedImage imgWin = con.loadImage("win.png");
		con.drawImage(imgWin, 500, 250);
		//logscore;
	}
	
	public static void lose(Console con, String strName, int intLives){
		
		//Redraw Background for lose screen
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.clear();
		con.setDrawColor(Color.WHITE);
		con.drawString("YOU LOSE", 640, 30);
		BufferedImage imgLose = con.loadImage("lose.png");
		con.drawImage(imgLose, 500, 250);
		
	}
	
	public static void logscore(String strName, int intLives){
		//Defining Variables for sorting high scores
		int intCount2;
		int intCount1;
		String[][] strTemp = new String[1][2];
		int intRow = 0;
		
		//Putting Username and score into leaderboard and bubble sorting it
		String[][] strLog = new String[100][2];
		strLog[intRow][0] = strName;
		strLog[intRow][1] = intLives + "";
		intRow = intRow + 1;
		
		//Add logs from leaderboard.txt
		TextInputFile leaderboardInput = new TextInputFile("leaderboard.txt");
		while (leaderboardInput.eof() == false) {
			strLog[intRow][0] = leaderboardInput.readLine();
			strLog[intRow][1] = leaderboardInput.readLine();
			intRow = intRow + 1;
		}
		leaderboardInput.close();
		
		//Bubble sort strLog array
		for(intCount2 = 0; intCount2 < 10-1; intCount2++){
			for(intCount1 = 0; intCount1 < 10-1; intCount1++){
				if(Integer.parseInt(strLog[intCount2][1]) > Integer.parseInt(strLog[intCount2+1][1])){
						strTemp[0] = strLog[intCount2];
						strLog[intCount2] = strLog[intCount2+1];
						strLog[intCount2+1] = strTemp[0];
				}
			}
		}
		
		TextOutputFile leaderboardOutput = new TextOutputFile("leaderboard.txt");
		for(int intE = 0; intE <= intRow; intE++){
			leaderboardOutput.println(strLog[intRow][0]);
			leaderboardOutput.println(strLog[intRow][1]);
		}
		leaderboardOutput.close();
	}
	public static void highscore(Console con){
		
		//Redraw Background for High score screen
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.clear();
		con.drawString("Name", 400, 10);
		con.drawString("Lives", 800, 10);
		TextInputFile leaderboard = new TextInputFile("leaderboard.txt");
		int intElement = 1;
		while(leaderboard.eof() == false && intElement < 10){
			con.println(intElement + "." +leaderboard.readLine() + " - " + leaderboard.readLine());
			intElement = intElement + 1;
		}
		
	}
	
	public static void addtheme(Console con){
		//Redraw Background for Add Theme screen
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		con.clear();
		//Getting Name for new theme
		String strThemeName;
		con.println("Name your theme: ");
		strThemeName = con.readLine();
		//Adding new theme to theme file
		TextOutputFile addtheme = new TextOutputFile("themes.txt", true);
		addtheme.println(strThemeName);
		addtheme.close();
		TextOutputFile newtheme = new TextOutputFile(strThemeName+".txt", true);
		int intDone;
		intDone = 0;
		String strAddWord;
		strAddWord = "";
		boolean blndone;
		blndone = false;
		char charInput;
		int intCount;
		intCount = 0;
		int intleng;
		intleng = 0;
		
		
		while(blndone == false){
			for(intCount = 0; intCount <= 10; intCount++){
				con.println("Add a word (minimum 7 letters): ");
				strAddWord = con.readLine();
				intleng = strAddWord.length();
				if(intleng < 7){
					con.println("Invalid word");
				}else{
					newtheme.println(strAddWord);	
				}
			}
			con.println("Are you done writing words Yes[y] No[n]");
			charInput = con.getChar();
			System.out.println("Entered character: " + charInput);
			if(charInput == 'y'){
				blndone = true;
				main(con);
			}
		}
		newtheme.close();
	}


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
