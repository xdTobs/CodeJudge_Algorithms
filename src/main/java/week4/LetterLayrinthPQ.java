package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LetterLayrinthPQ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        char[][] map = new char[length][length];
        for (int i = 0; i < length; i++) {
            char[]row = br.readLine().toCharArray();
            map[i] = row;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt((int[] a) -> a[2])));


        boolean[][] visited = new boolean[length][length];

        pq.offer(new int[]{0,0,1});


        while(!pq.isEmpty()){
            int[] coords = pq.poll();
            visited[coords[0]][coords[1]]=true;
            if(coords[0]==length-1&&coords[1]==length-1){
                System.out.println(coords[2]);
                break;
            }


            if(coords[0]+1!=length&&map[coords[0]+1][coords[1]]!=map[coords[0]][coords[1]]&&!visited[coords[0]+1][coords[1]])
                pq.offer(new int[]{coords[0]+1,coords[1],coords[2]+1});
            if(coords[0]-1!=-1&&map[coords[0]-1][coords[1]]!=map[coords[0]][coords[1]]&&!visited[coords[0]-1][coords[1]])
                pq.offer(new int[]{coords[0]-1,coords[1],coords[2]+1});
            if(coords[1]+1!=length&&map[coords[0]][coords[1]+1]!=map[coords[0]][coords[1]]&&!visited[coords[0]][coords[1]+1])
                pq.offer(new int[]{coords[0],coords[1]+1,coords[2]+1});
            if(coords[1]-1!=-1&&map[coords[0]][coords[1]-1]!=map[coords[0]][coords[1]]&&!visited[coords[0]][coords[1]-1])
                pq.offer(new int[]{coords[0],coords[1]-1,coords[2]+1});
        }

    }
}
