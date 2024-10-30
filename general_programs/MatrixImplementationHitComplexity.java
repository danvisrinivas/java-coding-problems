package general_programs;

public class MatrixImplementationHitComplexity {

	public static void main(String[] args) {
		int n = 3;
		int arr[][] = { 
						{ 1, 2, 3 },
						{ 1, 2, 3 }, 
						{ 1, 2, 3 }
					  };
		System.out.print(difference(arr, n));
	}
	public static int difference(int arr[][], int n) {
		// Initialize sums of diagonals
		int d1 = 0, d2 = 0;
		for (int i = 0; i < n; i++) {
			d1 = d1 + arr[i][i];
			d2 = d2 + arr[n - i - 1][i];
		}
		return d1+d2;
	}
}
