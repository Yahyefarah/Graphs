public class DrawGraph {

    public static void main(String[] args) {

        String s = "ANT CUN BOG AMA DC TOL SAN";

        String[] v = s.split(" ");
        int n = v.length;

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {

            int right = (i + (2*i + 1)) % n;

            int left = (i - (2*i + 2)) % n;
            if (left < 0) {
                left += n;
            }

            matrix[i][right] = 1;
            matrix[i][left] = 1;
        }

        
        for (int i = 0; i < n; i++) {
            System.out.print(v[i] + ": ");

            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}
