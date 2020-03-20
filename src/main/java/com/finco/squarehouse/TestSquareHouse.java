package com.finco.squarehouse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSquareHouse {

    @Test
    public void MaximalSquare_Test01_OK(){
        int[][] matrix = {
                {0,	0,	3	,3,	0},
                {0	,1,	3	,3,	0},
                {1,	3	,3,	3,	0},
                {0,	0,	2,	1,	0}
        };
        Solution squareHouse = new SquareHouse();
        int result = squareHouse.maximalSquare(matrix);
        Assertions.assertEquals(4,result);
    }
    @Test
    public void MaximalSquare_Test02_OK(){
        int[][] matrix = {
                {0,3,3,3,0},
                {0,3,3,3,0},
                {1,3,3,3,0},
                {0,0,2,1,0}
        };
        Solution squareHouse = new SquareHouse();
        int result = squareHouse.maximalSquare(matrix);
        Assertions.assertEquals(9,result);
    }
    @Test
    public void MaximalSquare_ALL0OR1_Test03_OK(){
        int[][] matrix = {
                {1, 1, 1, 1, 1},
                {1 ,1 ,1 ,1 ,1},
                {1 ,1, 1 ,1 ,1},
                {1 ,1 ,1 ,1, 0}
        };
        Solution squareHouse = new SquareHouse();
        int result = squareHouse.maximalSquare(matrix);
        Assertions.assertEquals(16,result);
    }
}
