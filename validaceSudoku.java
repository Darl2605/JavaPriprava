/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Zkouska;

import java.util.Scanner;

/**
 *
 * @author Dany
 */
public class zadani_jedna {
    public static final int[] nums = {1,2,3,4,5,6,7,8,9};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] sudoku = new int[9][9];
        String option = ""; 
        while(true)
        {
            System.out.println("Pokracovat? a/n");
            option = sc.next();
            if (option.equalsIgnoreCase(("a"))) {
                for (int i = 0; i < sudoku.length; i++) {
                    for (int j = 0; j < sudoku.length; j++) {
                        sudoku[i][j] = sc.nextInt();
                    }
                }
                /*for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        subarray(sudoku, i, j);
                    }
                }*/
                vypis(sudoku);
                //int[][] bd = {{9,2,7},{1,8,6},{4,3,5}};
                //int[] b = {9,2,3,4,5,6,7,8,9};
                if(checksudoku(sudoku))
                {System.out.println("ok");}
            }
            else
                break;
        }
    }
    
    static void vypis(int[][] pole)
    {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                System.out.printf(" %d",pole[i][j]);
            }
            System.out.println("");
        }
    }
    static int[][] subarray(int[][] pole, int subIdxRow, int subIdxCol)
    {
        if(subIdxRow > 3 )
            subIdxRow = 0;
        if(subIdxCol > 3 )
            subIdxCol = 0;
        int[][] subArr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                subArr[i][j] = pole[i+subIdxRow*3][j+subIdxCol*3];
            }
        }
        return subArr;
    }
    static boolean row(int[][] pole, int RowIDX)
    {
        int[] row = new int[9];
        for (int i = 0; i < row.length; i++) {
            row[i] = pole[i][RowIDX];
        }
        return checks(row);
    }
    static boolean col(int[][] pole, int ColIDX)
    {
        int[] col = new int[9];
        for (int i = 0; i < col.length; i++) {
            col[i] = pole[i][ColIDX];
        }
        return checks(col);
    }
    static boolean checksudoku(int[][] sudoku)
    { boolean sudokuJe = true;
        for (int i = 0; i < 9; i++) {
            sudokuJe &= row(sudoku, i);
            sudokuJe &= col(sudoku, i);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sudokuJe &= subArrCheck(subarray(sudoku, i, j));
            }
        }
        return sudokuJe;
    }
    static boolean checks(int[] poleNacheck)
    {
        boolean check = true;
        boolean found = true;
          for (int i = 0; i < 9; i++) {
            if(check){
            for (int j = 0; j < 9; j++) {
                if((nums[i] == poleNacheck[j]))
                {
                    check = true;
                    break;
                }
                else
                    check = false;
            }       
            }
            else
                break;
        }
          return check;
    }
    static boolean subArrCheck(int[][] sub)
    {
        boolean check = true;
        boolean found = true;
        for (int i = 0; i < 9; i++) {
            if(check && found){
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(nums[i] == sub[j][k]){
                        check = true;
                        break;
                    }
                    else
                        check = false;
                }
                if(check){break;}
            }
            }
        }
        return check;
    }
}
