package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Bridges {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        List<List<Edge>> adjList = new ArrayList<>();
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < nm[0] + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < nm[1]; i++) {
            int[]edgeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adjList.get(edgeInfo[0]).add(new Edge(edgeInfo[2],edgeInfo[1]));
            adjList.get(edgeInfo[1]).add(new Edge(edgeInfo[2],edgeInfo[0]));
        }
        List<Integer>weights =new ArrayList<>();
        boolean[]visited = new boolean[adjList.size()];
        int visitedCount = 0;
        pq.add(new Edge(0,1));
        while(visitedCount<nm[0]){
            Edge curr = pq.poll();
            assert curr != null;
            if(visited[curr.to])
                continue;
            weights.add(curr.weight);

            if(!visited[curr.to])visitedCount++;
            visited[curr.to]=true;

            pq.addAll(adjList.get(curr.to));
        }
        int sum =0;
        Collections.sort(weights);
        for (int i = 0; i < weights.size()-nm[2]; i++) {
            sum+=weights.get(i);
        }
        System.out.println(sum);
    }
}
class Edge implements Comparable<Edge>{
    public int weight;
    public int to;

    public Edge(int weight, int node) {
        this.weight = weight;
        this.to = node;
    }

    @Override
    public int compareTo(Edge o) {
        assert o!=null;
        return Integer.compare(this.weight, o.weight);
    }


}
