package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TopologicalSort {
    Stack<Integer> sortingStack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < nm[0]; i++) {
            adjList.add(new ArrayList<>());
        }
        while (br.ready()) {
            List<Integer> edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toList();
            adjList.get(edge.get(0)).add(edge.get(1));
        }
        TopologicalSort main = new TopologicalSort();
        List<Integer> topoSort = main.topoSort(nm[0],nm[1],adjList);
        System.out.println(topoSort.stream().map(String::valueOf).collect(Collectors.joining(", ")));


    }

    public List<Integer> topoSort(int n, int m, List<List<Integer>> adjList){
        sortingStack = new Stack<>();
        HashSet<Integer> visited =new HashSet<>();
        int iterator =0;
        while(visited.size()!=n){
            if (!visited.contains(iterator)) {
                dfs(adjList, visited, iterator);
            }
            iterator++;
        }
        List<Integer> res = new ArrayList<>(sortingStack);
        Collections.reverse(res);
        return res;
    }

    public void dfs(List<List<Integer>> adjList, HashSet<Integer> visited, Integer node){
        if(visited.contains(node))
            return;
        for(Integer neighbour : adjList.get(node)){
            dfs(adjList, visited, neighbour);
        }
        visited.add(node);
        sortingStack.push(node);
    }
}
