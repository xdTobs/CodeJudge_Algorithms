package week7;

import java.util.*;
import java.io.*;
public class main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = br.readLine().split(" ");

        int N = Integer.parseInt(numbers[0]); // antal bygninger (noder)
        int M = Integer.parseInt(numbers[1]); // antal stier (kanter)
        int a = Integer.parseInt(numbers[2]); // bygning a (startpunkt)
        int b = Integer.parseInt(numbers[3]); // bygning b (slutpunkt)

        // 1 <= N, M, a, b <= 1.000.000
        if (N >= 1 && N <= 1000000 && M >= 1 && M <= 1000000 && a >= 1 && a <= 1000000 && b >= 1 && b <= 1000000) {
        }

        // make adjacency List
        List<List<Integer>>adjList = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        // Read the path
        for (int i = 0; i < M; i++) {
            String[] kant = br.readLine().split(" ");
            int u = Integer.parseInt(kant[0]);
            int v = Integer.parseInt(kant[1]);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        //DFS algoritme:
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(a);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (visited.contains(current))
                continue;
            visited.add(current);
            if(current ==b){
                System.out.println("YES");
                break;
            }

            for(int i : adjList.get(current)){
                if(!visited.contains(i)){
                    stack.add(i);
                }
            }
        }
        //tjek om slutpunkt blev besøgt
        if (visited.contains(b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");

        }
        br.close();
    }
}