package week1;

public class Algorithm_2D_v4 {

    public static void main(String[] args) {
        int[] row1 = new int[]{1, 2, 3, 4, 5};
        int[] row2 = new int[]{2, 3, 4, 5, 6};
        int[] row3 = new int[]{3, 4, 5, 6, 7};
        int[] row4 = new int[]{4, 5, 6, 9, 8};
        int[] row5 = new int[]{5, 6, 7, 8, 1};
        int[][] testcase = new int[][]{row1, row2, row3, row4, row5};
        Algorithm_2D_v4 algo = new Algorithm_2D_v4();
        System.out.println(algo.findPeak(testcase));
    }

    public int findPeak(int[][]grid){
        return splitRow(grid,0,grid.length-1,0,grid.length-1);
    }
    public int splitRow(int[][]grid,int loCol,int hiCol,int loRow,int hiRow){

        boolean centralMax = true;
        boolean upperMax = false;
        boolean lowerMax = false;

        int midRow = (loRow+hiRow)/2;
        int max = grid[midRow][loCol];

        for(int col=loCol; col<=hiCol; col++){
            max = Math.max(max, grid[midRow][col]);
        }

        if(midRow-1>=0){
            for(int col=loCol; col<=hiCol; col++){
                if(grid[midRow-1][col] > max){
                    max = grid[midRow-1][col];
                    upperMax = true;
                    centralMax = false;
                }
            }
        }

        if(midRow+1<grid.length){
            for(int col=loCol; col<=hiCol; col++){
                if(grid[midRow+1][col] > max){
                    max = grid[midRow+1][col];
                    lowerMax = true;
                    centralMax = false;
                    upperMax   = false;
                }
            }
        }

        if(centralMax) return max;
        if(lowerMax)   return splitCol(grid, loCol, hiCol, midRow+1, hiRow);
        if(upperMax)   return splitCol(grid, loCol, hiCol, loRow, midRow-1);
        return -1;
    }
    public int splitCol(int[][]grid,int loCol,int hiCol,int loRow,int hiRow){
            int midCol = (loCol+hiCol)/2;
            int max = grid[loRow][loCol];
            for(int row=loRow; row<=hiRow; row++){
                max = Math.max(max, grid[row][midCol]);
            }
            boolean centralMax = true;
            boolean rightMax = false;
            boolean leftMax  = false;

            if(midCol-1 >= 0){
                for(int row = loRow; row<=hiRow; row++){
                    if(grid[row][midCol-1] > max){
                        max = grid[row][midCol-1];
                        centralMax = false;
                        leftMax = true;
                    }
                }
            }

            if(midCol+1 < grid.length){
                for(int row=loRow; row<=hiRow; row++){
                    if(grid[row][midCol+1] > max){
                        max = grid[row][midCol+1];
                        centralMax = false;
                        leftMax = false;
                        rightMax = true;
                    }
                }
            }

            if(centralMax) return max;
            if(rightMax)  return splitRow(grid, midCol+1, hiCol, loRow, hiRow);
            if(leftMax)   return splitRow(grid, loCol, midCol-1, loRow, hiRow);
            return -1;

    }
}
