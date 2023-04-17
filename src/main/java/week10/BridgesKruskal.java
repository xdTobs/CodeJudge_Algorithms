package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BridgesKruskal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<DoubleEdge> edges = new ArrayList<>();
        for (int i = 0; i < nm[1]; i++) {
            int[] edgeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges.add(new DoubleEdge(edgeInfo[0],edgeInfo[1],edgeInfo[2]));

        }
        int mstWeight = kruskalMST(nm[0], edges,nm[2]);
        System.out.println(mstWeight);
    }

    public static int kruskalMST(int nodes, List<DoubleEdge> edges, int ferries) {
        List<Integer>weights = new ArrayList<>();
        Collections.sort(edges);
        UnionFind uf = new UnionFind(nodes + 1);

        int totalWeight = 0;
        for (DoubleEdge edge : edges) {
            if (uf.union(edge.from, edge.to)) {
                weights.add(edge.weight);
            }
        }
        Collections.sort(weights);
        for (int i = 0; i < weights.size() - ferries; i++) {
            totalWeight+=weights.get(i);
        }
        return totalWeight;
    }
}

class DoubleEdge implements Comparable<DoubleEdge> {
    int from, to, weight;

    public DoubleEdge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(DoubleEdge o) {
        return Integer.compare(this.weight, o.weight);
    }
}
class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false;
        }

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        return true;
    }
}




