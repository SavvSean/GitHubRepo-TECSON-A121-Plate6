package plate_6;
import java.util.*;

public class num2 {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = scan.nextInt();

        int[][] matrix = new int[vertices][vertices];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        Map<String, Integer> edgeCounter = new HashMap<>();

        String currentEdge = "";
        for(int i = 0 ; i < vertices ; i++) {
            for (int j = 0; j < vertices; j++) {
                if (matrix[i][j] != 0) {
                    String edge = "("+(i + 1) + "," + (j + 1)+")";
                    if(!edge.equals(currentEdge)){
                        if(!currentEdge.isEmpty()){
                            System.out.println("Edge " + currentEdge + " : " + " Appeared " + edgeCounter.get(currentEdge) + " time(s)");
                        }
                        currentEdge = edge;

                        edgeCounter.put(currentEdge,0);
                    }
                    edgeCounter.put(currentEdge, edgeCounter.get(currentEdge) + matrix[i][j]);
                }
            }
        }
        if (!currentEdge.isEmpty()) {
            System.out.println("Edge " + currentEdge + " : " + " Appeared " + edgeCounter.get(currentEdge) + " time(s)");
        }
    }
}

