import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Input");
        printMatrix(matrix);

        System.out.println("Output");
        printMatrix(rotateMatrix90Degrees(matrix));
    }

    private static int[][] rotateMatrix90Degrees(int[][] matrix) {

        for (int i = 0; i < matrix[0].length; i++) {
            int k = matrix[0].length - 1;
            for (int j = 0; j < k; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[k][i];
                matrix[k][i] = tmp;
                k--;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        String line = "----";
        System.out.println("-" + String.join("", Collections.nCopies(matrix.length, line)));
        int currPrints = 1;
        for (int[] row : matrix) {
            for (int col : row) {
                if (currPrints == row.length) {
                    System.out.println(col + " |");
                    currPrints = 0;
                } else {
                    System.out.print((currPrints == 1 ? "| " : "") + col + " | ");
                }
                currPrints++;
            }
        }
        System.out.println("-" + String.join("", Collections.nCopies(matrix.length, line)));
    }
}
