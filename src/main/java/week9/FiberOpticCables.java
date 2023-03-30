package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FiberOpticCables {
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
        int sum =0;
        HashSet<Integer>inTree = new HashSet<>();
        pq.add(new Edge(0,1));
        while(inTree.size()<nm[0]){
            Edge curr = pq.poll();
            assert curr != null;
            if(inTree.contains(curr.to))
                continue;
            sum+=curr.weight;

            inTree.add(curr.to);
            for(Edge edge : adjList.get(curr.to)){
                pq.add(edge);
            }
        }
        System.out.println(sum);
    }
}
class Edge implements Comparable{
    public int weight;
    public int to;

    public Edge(int weight, int node) {
        this.weight = weight;
        this.to = node;
    }

    @Override
    public int compareTo(Object o) {
        assert o!=null;
        Edge edge = (Edge)o;
        return Integer.compare(this.weight, edge.weight);
    }
}
