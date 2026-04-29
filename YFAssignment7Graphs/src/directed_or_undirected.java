import java.util.Scanner;

public class directed_or_undirected {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();


        boolean[][] connected = new boolean[n][n];


        System.out.println("Enter the matrix rows (like 0100):");

        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                if (row.charAt(j) == '1') {

                    // I Set both directions to true to ignore the arrowheads
                    connected[i][j] = true;
                    connected[j][i] = true;
                }
            }
            connected[i][i] = true;
        }


        // This spreads the connectivity so if A connects to B and B to C, then A connects to C

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (connected[i][k] && connected[k][j]) {
                        connected[i][j] = true;
                    }
                }
            }
        }


        boolean isWeaklyConnected = true;
        for (int j = 0; j < n; j++) {
            if (!connected[0][j]) {
                isWeaklyConnected = false;
                break;
            }
        }


        if (isWeaklyConnected) {
            System.out.println("The graph is weakly connected.");
        } else {
            System.out.println("The graph is NOT weakly connected.");
        }

        sc.close();
    }
}
