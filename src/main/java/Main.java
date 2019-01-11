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
        int max = matrix.length - 1;
        for (int i = 0; i <= max/2; i++) {
            for (int j = i; j < max - i; j++) {
                int coord1 = matrix[i][j];
                int coord2 = matrix[j][max - i];
                int coord3 = matrix[max - i][max - j];
                int coord4 = matrix[max - j][i];

                matrix[j][max - i] = coord1;
                matrix[max -i][max - j] = coord2;
                matrix[max - j][i] = coord3;
                matrix[i][j] = coord4;
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
