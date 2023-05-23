package WeekTwo.TryAgain;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    // Defined Attributes
    int rowValue;
    int colValue;
    String[][] selectRow;
    String[][] selectCol;
    int mineNumber;
    int inputRow;
    int inputColumn;
    int counter;
    boolean isTrue = true;
    // Created Actions For The Game

    // Main Action Method Defined Attributes
    public MineSweeper(int row, int col){
        this.rowValue = row;
        this.colValue = col;
        this.selectRow = new String[row][col];
        this.selectCol = new String[row][col];
        this.mineNumber = (col * row) / 4;
    }

    // Set Mine Field
    public void setMineMap(){
        for (int i = 0; i < rowValue; i ++){
            for (int k = 0; k < colValue; k++){
                selectRow[i][k] = "-";
                selectCol[i][k] = "-";
            }
        }
    }
    public void  minePlacement(){
        Random passing = new Random();
        for (int i = 0; i < mineNumber; i++){
            int randomMine = passing.nextInt(this.rowValue);
            int passingMine = passing.nextInt(this.colValue);
            if (!this.selectRow[randomMine][passingMine].equals("*")){
                this.selectRow[randomMine][passingMine] = "*";
            }
        }
    }

    // You Can See Where Mines Are
   public void locationMine(){
       System.out.println("Location of Mines ");
       minePlacement();
       for (int i = 0; i < rowValue; i++){
           for (int k = 0; k < colValue; k++){
               if (!this.selectRow[i][k].equals("*")){
                   this.selectRow[i][k] = "-";
               }
               System.out.print(selectRow[i][k] + " ");
           }
           System.out.println();
       }
       System.out.println();
       System.out.println("-_-_-_-_--_-_-_-_--_-_-_-_-");
       System.out.println("Welcome To The MineField");
   }

   public void printGameField(){
       System.out.println("Location of Mines ");
        for (int i = 0; i < rowValue; i++){
            for (int k = 0; k < colValue; k++){
                if (!this.selectRow[i][k].equals("*")){
                    this.selectRow[i][k] = "-";
                }
                System.out.print(selectRow[i][k] + " ");
            }
            System.out.println();
        }
   }
   // Get Value From User To Start The Game
   public void inputIndex(){
       Scanner scan = new Scanner(System.in);
       isTrue = false;
       while (!isTrue){
           System.out.print("Enter Row : ");
           inputRow = scan.nextInt();
           System.out.print("Enter Column : ");
           inputColumn = scan.nextInt();
           // We Can Check User Enter Correctly Value or Not
           if (inputRow >= rowValue || inputColumn >= colValue){
               System.out.println("You entered an invalid coordinate! Please enter again!");
               continue;
           }
           if (selectRow[inputRow][inputColumn].equals("*")){
               System.out.println("Sorry You Lost! Game Over!");
               break;
           }
         checkIn();
           if (isWin()){
               System.out.println("Congrats You Won! ");
               break;
           }

       }
   }
   // This Method Control The MineField is Correctly Working
    public void checkIn() {
        counter = 0;
        for (int i = (inputRow - 1); i <= (inputRow + 1); i++) {
            for (int j = (inputColumn - 1); j <= (inputColumn + 1); j++) {
                if (i < 0 || j < 0 || i >= this.rowValue || j >= this.colValue) {
                    continue;
                }
                if (this.selectRow[i][j].equals("*")) {
                    counter++;
                }
            }
        } this.selectCol[inputRow][inputColumn] = String.valueOf(counter);
        this.selectRow[inputRow][inputColumn] = String.valueOf(counter);
        for (int i = 0; i < this.rowValue; i++) {
            for (int j = 0; j < this.colValue; j++) {
                System.out.print(this.selectCol[i][j] + " ");
            }
            System.out.println("");
        }
    }
    // This Method Control The User Win and Return Value.
    public boolean isWin(){
        for (int i = 0; i < rowValue; i++){
            for (int k = 0; k < colValue; k++){
                if (this.selectRow[i][k].equals("-")){
                    return false;
                }
            }
        }
        return true;
    }

   public void output(){
        setMineMap();
        minePlacement();
        inputIndex();
        printGameField();
   }
}
