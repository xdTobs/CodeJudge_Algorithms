package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class DTUWayFinder {
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

        String output = BFS(nm[2],nm[3],adjList);
        System.out.println(output);
    }

    static String BFS(int a, int b, List<List<Integer>> adjBuildings) {

        // Making a queue to control which building to visit next,
        // and a boolean array to control which buildings already visited
        Stack<Integer> searchQueue = new Stack<>();
        searchQueue.add(a);
        //Boolean[] visitedBuildings = new Boolean[N+1];
        HashSet<Integer> visitedBuildings = new HashSet<>();
        //Arrays.fill(visitedBuildings, false);

        // Search for a path as long as the search queue is not empty
        while (searchQueue.size() != 0) {

            int currentBuilding = searchQueue.pop();
            if(visitedBuildings.contains(currentBuilding))
                continue;
            visitedBuildings.add(currentBuilding);
            if (currentBuilding == b) {
                return "YES";
            }

            for(Integer neighbour : adjBuildings.get(currentBuilding)){
                if(!visitedBuildings.contains(neighbour)){
                    searchQueue.add(neighbour);
                }
            }
        }
        // Return "NO" if path is not found
        return "NO";
    }
}