package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BuildingPaths {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < nm[0] + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        while (br.ready()) {
            List<Integer> edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            adjList.get(edge.get(0)).add(edge.get(1));
            adjList.get(edge.get(1)).add(edge.get(0));
        }
        BuildingPaths bp = new BuildingPaths();

        String output = bp.dfs(adjList, new HashSet<Integer>(), nm[2], nm[3]) ? "YES" : "NO";
        System.out.println(output);
    }

    public boolean dfs(List<List<Integer>> adjList, HashSet<Integer> visited, int curr, int goal) {
        if(visited.contains(curr))
            return false;
        visited.add(curr);
        if (curr == goal) return true;
        for (Integer i : adjList.get(curr)) {
                if (!visited.contains(i)&&dfs(adjList, visited, i, goal)) return true;
        }
        return false;
    }
}
