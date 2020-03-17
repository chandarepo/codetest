package com.finco.squarehouse;

import java.util.HashSet;
import java.util.Set;

public class SquareHouse implements Solution {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 1, 1, 1, 1},
                {1 ,1 ,1 ,1 ,1},
                {1 ,1, 1 ,1 ,1},
                {1 ,1 ,1 ,1, 0}
        };
        int[][] matrix2 = {
                {0,	0,	3	,3,	0},
                {0	,1,	3	,3,	0},
                {1,	3	,3,	3,	0},
                {0,	0,	2,	1,	0}
        };
        int[][] matrix3 = {
                {0,3,3,3,0},
                {0,3,3,3,0},
                {1,3,3,3,0},
                {0,0,2,1,0}
        };

        SquareHouse test = new SquareHouse();
        int size = test.maximalSquare(matrix3);
        System.out.println(size);

        size = test.maximalSquare(matrix2);
        System.out.println(size);

        size = test.maximalSquare(matrix1);
        System.out.println(size);
    }
    public int  maximalSquare( int[][] matrix){
        if(matrix ==null ) return 0;

        Set<Integer> setOfHeight = new HashSet<>();

        int iMax = matrix.length;
        int jMax = matrix[0].length;

        for(int i =0; i< iMax; i++) {
            for (int j = 0; j < jMax; j++) {
                if(matrix[i][j]!=0) {
                    setOfHeight.add(matrix[i][j]);
                }
            }
        }

        int maxSquare = 0;

        for(int i : setOfHeight){
            int _maxSquare = maximalSquare(matrix, i);
            if(maxSquare < _maxSquare){
                maxSquare = _maxSquare;
            }
        }
        return maxSquare;
    }

}
