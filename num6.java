package plate_6;
import java.util.*;

public class num6 {
	public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

        System.out.print("Enter amount of vertices: ");
        int vertices = scan.nextInt();

        int[][] adjacencyMatrix = new int[vertices][vertices];

        for (int i = 0 ; i < vertices ; i++){
            System.out.print("Edge "+(i+1)+": ");
            int u = scan.nextInt();
            int v = scan.nextInt();

            adjacencyList.putIfAbsent(u, new ArrayList<>());
            adjacencyList.putIfAbsent(v, new ArrayList<>());

            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        for (int i = 1; i <= vertices; i++) {
            for (int j : adjacencyList.get(i)) {
                adjacencyMatrix[i - 1][j - 1] = 1;
            }
        }

        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
