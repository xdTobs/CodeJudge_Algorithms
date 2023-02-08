package week1;

import java.util.Arrays;

public class Algorithm_2D {
    public int[] peak(int[][] grid){
        return dfs(grid,new int[]{0,0},new int[]{grid.length-1,grid.length-1});

    }
    public int[] dfs(int[][] grid,int[]tl,int[]br){
        int[]mid = new int[]{(tl[0]+br[0])/2,(tl[1]+br[1])/2};


         if(
                mid[0]== grid.length-1&&
                        mid[1]== grid.length-1&&
                        grid[mid[0]][mid[1]]>=grid[mid[0]-1][mid[1]]&&
                        grid[mid[0]][mid[1]]>=grid[mid[0]][mid[1]-1]
        )return mid;
       else if(
                mid[0]== grid.length-1&&
                        grid[mid[0]][mid[1]]>=grid[mid[0]-1][mid[1]]&&
                        grid[mid[0]][mid[1]]>=grid[mid[0]][mid[1]+1]&&
                        grid[mid[0]][mid[1]]>=grid[mid[0]][mid[1]-1]
        )return mid;
        if(
                mid[0]== 0&&
                        grid[mid[0]][mid[1]]>=grid[mid[0]+1][mid[1]]&&
                        grid[mid[0]][mid[1]]>=grid[mid[0]][mid[1]+1]&&
                        grid[mid[0]][mid[1]]>=grid[mid[0]][mid[1]-1]
        )return mid;





        else if(
                mid[0]!=grid.length-1&&mid[1]!=grid.length&&
                grid[mid[0]][mid[1]]>=grid[mid[0]+1][mid[1]]&&
                grid[mid[0]][mid[1]]>=grid[mid[0]-1][mid[1]]&&
                grid[mid[0]][mid[1]]>=grid[mid[0]][mid[1]+1]&&
                grid[mid[0]][mid[1]]>=grid[mid[0]][mid[1]-1]
        )return mid;

        else if(mid[0]!=grid.length-1 && grid[mid[0]][mid[1]]<grid[mid[0]+1][mid[1]]){
            tl[0] = mid[0]+1;
            return dfs(grid,tl,br);
        }
        else if(grid[mid[0]][mid[1]]<grid[mid[0]-1][mid[1]]){
            br[0] = mid[0]-1;
            return dfs(grid,tl,br);
        }
        else if(grid[mid[0]][mid[1]]<grid[mid[0]][mid[1]+1]){
            tl[1] = mid[1]+1;
            return dfs(grid,tl,br);
        }
        else if(grid[mid[0]][mid[1]]<grid[mid[0]+1][mid[1]-1]){
            br[1] = mid[1]-1;
            return dfs(grid,tl,br);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[]row1 = new int[]{1,2,3,4,5};
        int[]row2 = new int[]{2,3,4,5,6};
        int[]row3 = new int[]{3,4,5,6,7};
        int[]row4 = new int[]{4,5,6,7,8};
        int[]row5 = new int[]{5,6,7,8,9};
        int[][]testcase = new int[][]{row1,row2,row3,row4,row5};
        Algorithm_2D algo = new Algorithm_2D();
        System.out.println(Arrays.toString(algo.peak(testcase)));



        int[]roww1 = new int[]{5,6,7,8,9};
        int[]roww2 = new int[]{6,5,6,7,8};
        int[]roww3 = new int[]{7,6,5,6,7};
        int[]roww4 = new int[]{8,7,6,5,4};
        int[]roww5 = new int[]{9,8,7,4,3};
    }
}
