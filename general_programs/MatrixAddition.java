package general_programs;

public class MatrixAddition {
	public static void main(String[] args) {
		
		int i,j;
		int add[][] = new int [2][2];
		
		int a[][] = {{1,2},{1,2}};
		int b[][] = {{1,2},{1,2}};
		
		for(i = 0;i<2;i++){
			for(j=0;j<2;j++){
				add[i][j] = a[i][j]*b[i][j];
				System.out.print(add[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
