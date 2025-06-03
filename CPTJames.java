import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTJames{
	public static void main(String[] args){
		Console con = new Console("Hangman", 700, 700);
		BufferedImage imgHangman = con.loadImage("hangman.png.jpeg");
		con.setDrawColor(Color.WHITE);
		con.drawString("Hangman", 300, 200);
		con.drawString("Play Game [1]", 300, 300);
		con.drawString("View Leaderboard [2]", 300, 350);
		con.drawString("Add Theme [3]", 300, 400);
		con.drawString("Quit [4]", 300, 450);
		con.drawImage(imgHangman, 200,10);
		con.setDrawColor(Color.BLACK);	
		//User Menu Selection Choice
		int intChoice;
		intChoice = con.readInt();
		
		//If User picks Play Game
		if(intChoice == 1){
			//Redraw Background for Game
			con.setDrawColor(Color.BLACK);
			con.fillRect(0,0,700,700);
		}
		//String strUName;
		//con.println("What is your name?");
		//strUName = con.readLine();
		
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

	}
}
