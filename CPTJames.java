import arc.*;

public class CPTJames{
	public static void main(String[] args){
		Console con = new Console();
		
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
		String strChosenTheme;
		strChosenTheme = con.readLine();
		if(strChosenTheme == "Food"){
		String strFoods;
		String strSports;
		String strJobs;
		strFoods = "Foods";
		strSports = "Sports";
		strJobs = "Jobs";
		
		if(strChosenTheme.equals(strFoods)){
			TextInputFile food = new TextInputFile("foods.txt");
		}else if(strChosenTheme == "Sports"){
			foods.close();
		}else if(strChosenTheme.equals(strSports)){
			TextInputFile sports = new TextInputFile("sports.txt");
		}else if(strChosenTheme == "Jobs"){
			sports.close();
		}else if(strChosenTheme.equals(strJobs)){
			TextInputFile jobs = new TextInputFile("jobs.txt");
			jobs.close();
		}else{
			con.println("Invalid Theme");
		}
	}
}
