import arc.*;

public class bubblesorttest{
	public static void main(String[] args){
		Console con = new Console();
			String strGameWord;
			int intRand;
			int intRow;
			int intColumn;
			intRow = 0;
			intColumn = 0;
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
	}
}
