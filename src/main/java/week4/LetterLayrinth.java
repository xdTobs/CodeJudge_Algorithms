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

        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[length][length];

        queue.add(new Point(0,0,map[0][0],1));

        while(!queue.isEmpty()){
            Point p = queue.remove();
            visited[p.x][p.y]=true;
            if(p.x==length-1&&p.y==length-1){
                System.out.println(p.step);
                break;
            }


            if (p.x + 1 != length && map[p.x + 1][p.y] != map[p.x][p.y] && !visited[p.x + 1][p.y]) {
                queue.add(new Point(p.x + 1, p.y, map[p.x + 1][p.y], p.step + 1));
                visited[p.x + 1][p.y] = true;
            }
            if (p.x - 1 != -1 && map[p.x - 1][p.y] != map[p.x][p.y] && !visited[p.x - 1][p.y]) {
                queue.add(new Point(p.x - 1, p.y, map[p.x - 1][p.y], p.step + 1));
                visited[p.x - 1][p.y] = true;
            }
            if (p.y + 1 != length && map[p.x][p.y + 1] != map[p.x][p.y] && !visited[p.x][p.y + 1]) {
                queue.add(new Point(p.x, p.y + 1, map[p.x][p.y + 1], p.step + 1));
                visited[p.x][p.y + 1] = true;
            }
            if (p.y - 1 != -1 && map[p.x][p.y - 1] != map[p.x][p.y] && !visited[p.x][p.y - 1]) {
                queue.add(new Point(p.x, p.y - 1, map[p.x][p.y - 1], p.step + 1));
                visited[p.x][p.y - 1] = true;
            }
        }

    }
    static class Point{
        int x;
        int y;
        char c;
        int step;

        public Point(int x, int y, char c, int step) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.step = step;
        }
    }
}
