package general_programs;

public class Test {
    public static void main(String[] args) {
        int[] A = {100, -100, 100, -100, 100};
        System.out.println(solution(A));
    }

        public static int solution(int[] A) {
            int N = A.length;

            // Step 1: Create leftMax and rightMax arrays
            int[] leftMax = new int[N];
            int[] rightMax = new int[N];

            // Step 2: Fill leftMax array
            leftMax[0] = A[0];
            for (int i = 1; i < N; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], A[i]);
            }

            // Step 3: Fill rightMax array
            rightMax[N - 1] = A[N - 1];
            for (int i = N - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], A[i]);
            }

            // Step 4: Find the maximum difference between leftMax[K] and rightMax[K + 1]
            int maxDifference = 0;
            for (int K = 0; K < N - 1; K++) {
                int difference = Math.abs(leftMax[K] - rightMax[K + 1]);
                maxDifference = Math.max(maxDifference, difference);
            }

            return maxDifference;
        }

}
