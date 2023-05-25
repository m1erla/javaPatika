package WeekTwo.TranspozeMatrix;

public class Main {
    public static void main(String[] args) {
        // Defined Array
        int[][] matrix = {
                        {1,2,3},
                        {4,5,6}
                          };
        System.out.println("Matrix : ");
        printArray(matrix);
        System.out.println("Transpoze : ");
        Change(matrix);
    }
    // Created New Actions
    public static void Change (int[][] matrix) {

        int [][] newMatrix = new int [matrix[0].length][matrix.length];

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int col = 0; col < matrix[0].length; col++) {
                newMatrix[col][rows] = matrix [rows][col];
            }
        }
        printArray(newMatrix); // For You Can See On The Screen To Output
    }
    public static void printArray(int[][] matrix) {
        // Using for Loop and  Print Output
        for (int [] rows : matrix) {
            for (int col : rows) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
