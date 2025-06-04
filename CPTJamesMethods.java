import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTJamesMethods{
	public static void main(String[] args){
			
	}
	
	public static void consoleSetup(Console con){
			BufferedImage imgHangman = con.loadImage("hangman.png.jpeg");
			con.setDrawColor(Color.WHITE);
			con.drawString("Hangman", 520, 200);
			con.drawString("Play Game [P]", 520, 300);
			con.drawString("View Leaderboard [L]", 520, 350);
			con.drawString("Add Theme [T]", 520, 400);
			con.drawString("Quit [Q]", 520, 500);
			con.drawString("Help [H]", 520, 450);
			con.drawString("Main Menu to select Game Option", 0, 0);
			con.drawImage(imgHangman, 500,10);
			con.setDrawColor(Color.BLACK);	
	}
}
