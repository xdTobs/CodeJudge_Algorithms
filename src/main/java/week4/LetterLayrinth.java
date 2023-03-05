package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LetterLayrinth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        char[][] map = new char[length][length];
        for (int i = 0; i < length; i++) {
            char[]row = br.readLine().toCharArray();
            map[i] = row;
        }

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[length][length];

        queue.addFirst(new int[]{0,0,1});

        while(!queue.isEmpty()){
            int[] coords = queue.pollLast();
            visited[coords[0]][coords[1]]=true;
            if(coords[0]==length-1&&coords[1]==length-1){
                System.out.println(coords[2]);
                break;
            }


            if(coords[0]+1!=length&&map[coords[0]+1][coords[1]]!=map[coords[0]][coords[1]]&&!visited[coords[0]+1][coords[1]])
                queue.addFirst(new int[]{coords[0]+1,coords[1],coords[2]+1});
            if(coords[0]-1!=-1&&map[coords[0]-1][coords[1]]!=map[coords[0]][coords[1]]&&!visited[coords[0]-1][coords[1]])
                queue.addFirst(new int[]{coords[0]-1,coords[1],coords[2]+1});
            if(coords[1]+1!=length&&map[coords[0]][coords[1]+1]!=map[coords[0]][coords[1]]&&!visited[coords[0]][coords[1]+1])
                queue.addFirst(new int[]{coords[0],coords[1]+1,coords[2]+1});
            if(coords[1]-1!=-1&&map[coords[0]][coords[1]-1]!=map[coords[0]][coords[1]]&&!visited[coords[0]][coords[1]-1])
                queue.addFirst(new int[]{coords[0],coords[1]-1,coords[2]+1});
        }

    }
}
