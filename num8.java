package plate_6;
import java.util.*;

public class num8 {
	public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of vertices for Graph 1: ");
        int graphVert1 = scan.nextInt();
        int[][] graph1 = new int[graphVert1][graphVert1];

        System.out.print("Enter number of edges for Graph 1: ");
        int graphEdge1 = scan.nextInt();

        System.out.println("Enter edges for Graph 1 ");
        for (int i = 0 ; i < graphEdge1 ; i++){
            System.out.print("Enter edge "+ (i+1)+ " : ");
            int u = scan.nextInt() - 1;
            int v = scan.nextInt() - 1;

            graph1[u][v] = 1;
            graph1[v][u] = 1;
        }

        System.out.print("Enter number of vertices for Graph 2: ");
        int graphVert2 = scan.nextInt();
        int[][] graph2 = new int[graphVert2][graphVert2];

        System.out.print("Enter number of edges for Graph 2: ");
        int graph2Edge = scan.nextInt();

        System.out.println("Enter edges for Graph 2 ");
        for (int i = 0 ; i < graph2Edge ; i++){
            System.out.print("Enter edge "+ (i+1)+ " : ");
            int u = scan.nextInt() - 1;
            int v = scan.nextInt() - 1;

            graph2[u][v] = 1;
            graph2[v][u] = 1;
        }

        if (Isomorphic(graph1, graph2)){
            System.out.println("Graphs are isomorphic");
        } else {
            System.out.println("Graphs are not isomorphic");
        }

    }

    public static boolean Isomorphic(int[][] graph1, int[][] graph2){
        if (graph1.length != graph2.length) {
            return false;
        }

        int[] graph1Degree = degreeSet(graph1);
        int[] graph2Degree = degreeSet(graph2);

        Arrays.sort(graph1Degree);
        Arrays.sort(graph2Degree);

        return Arrays.equals(graph1Degree,graph2Degree);
    }

    private static int[] degreeSet(int graph[][]){
        int length = graph.length;
        int[] sequence = new int[length];

        for(int i = 0 ; i < length ; i++){
            int degree = 0;
            for (int j = 0 ; j < length ; j++){
                if (graph[i][j] == 1){
                    degree++;
                }
            }
            sequence[i] = degree;
        }
        return sequence;
    }
}

