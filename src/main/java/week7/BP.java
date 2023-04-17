package week7;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BP {
    public static void main(String[] args) {

        int M = 3;
        int N = 5;
        int b = 3;
        int a = 1;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
        int endNode = b;

        adjList.get(1).add(2);
        adjList.get(2).add(1);
        /*adjList.get(2).add(4);
        adjList.get(4).add(2);*/
        adjList.get(4).add(3);
        adjList.get(3).add(4);

        //DFS
        Stack<Integer> nodes = new Stack<>();
        nodes.add(a);
        boolean[] visited = new boolean[N];
        while (!nodes.isEmpty()){
            int currNode = nodes.pop();
            if(visited[currNode])
                continue;
            visited[currNode] = true;
            //currNode = 1;
            for (Integer i : adjList.get(currNode)){
                if(!visited[i])
                    nodes.add(i);
            }
        }
        System.out.println(visited[endNode] ? "YES" : "NO");

        /*
        [0]
        [1]->[2]
        [2]->[1,4]
        [3]->[4]
        [4]->[2,3]
         */
    }

}
