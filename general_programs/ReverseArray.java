package general_programs;

public class ReverseArray {

	public static void main(String[] args) {
		int validData [] = {1 , 2, 3, 4, 5};
		for(int i = validData.length-1; i >= 0; i--)
		{
			System.out.print(validData[i]+" ");
		}
	}
}
