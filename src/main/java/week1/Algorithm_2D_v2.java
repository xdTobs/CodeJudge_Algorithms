package week1;

import java.util.Arrays;

public class Algorithm_2D_v2 {
    public int[] peak(int[][]grid){

        return search(grid, grid.length/2, grid.length/2);
    }
    public int[] search(int[][]grid, int row,int col){
        if(isMax(grid,row,col))return new int[]{row,col};
        int[] dir =new int[]{0,-1,-1};
        if(col!=0 &&grid[row][col-1]>dir[0])dir = new int[]{grid[row][col-1],row,col-1};
        if(col!=grid.length-1 &&grid[row][col+1]>dir[0])dir = new int[]{grid[row][col+1],row,col+1};
        if(row!=0 &&grid[row-1][col]>dir[0])dir = new int[]{grid[row-1][col],row-1,col};
        if(row!=grid.length-1 &&grid[row+1][col]>dir[0])dir = new int[]{grid[row+1][col],row+1,col};
        return search(grid,dir[1],dir[2]);
    }

    private boolean isMax(int[][] grid, int row, int col) {
        if(col != 0&&col!=grid.length-1&&row!=0&&row!= grid.length&&
                grid[row][col]>=grid[row+1][col]&&
                grid[row][col]>=grid[row-1][col]&&
                grid[row][col]>=grid[row][col+1]&&
                grid[row][col]>=grid[row][row-1]) return true;
        else return false;

    }

    public static void main(String[] args) {
        int[] row1 = new int[]{1, 2, 3, 4, 5};
        int[] row2 = new int[]{2, 3, 4, 5, 6};
        int[] row3 = new int[]{3, 4, 5, 6, 7};
        int[] row4 = new int[]{4, 5, 6, 9, 8};
        int[] row5 = new int[]{5, 6, 7, 8, 7};
        int[][] testcase = new int[][]{row1, row2, row3, row4, row5};
        Algorithm_2D_v2 algo = new Algorithm_2D_v2();
        System.out.println(Arrays.toString(algo.peak(testcase)));
    }

}
