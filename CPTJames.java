import arc.*;

public class CPTJames{
	public static void main(String[] args){
		Console con = new Console();
		
		int intNum;
		con.println("Give me a number");
		intNum = con.readInt();
		con.println(intNum);
		String strUName;
		con.println("What is your name?");
		strUName = con.readLine();
		TextInputFile themes = new TextInputFile("themes.txt");
		String strTheme;
		
		con.println("Choose your theme");
		while(themes.eof() == false){
			strTheme = themes.readLine();
			con.println(strTheme);
		}
		themes.close();
	}
}
