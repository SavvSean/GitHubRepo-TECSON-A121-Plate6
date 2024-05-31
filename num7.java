package plate_6;
import java.util.*;

public class num7 {
	 public static void main(String[] args){
	        Scanner scan = new Scanner(System.in);

	        System.out.print("Enter number of vertices: ");
	        int vertices = scan.nextInt();

	        System.out.print("Enter number of edges: ");
	        int edges = scan.nextInt();

	        int[][] incidenceMatrix = new int[vertices][edges];


	        for (int i = 0; i < edges; i++) {
	            System.out.print("Enter edge " + (i + 1) + ": ");
	            int u = scan.nextInt();
	            int v = scan.nextInt();

	            incidenceMatrix[u - 1][i] = 1;
	            incidenceMatrix[v - 1][i] = 1;
	        }

	        for (int i = 0 ; i < vertices ; i++){
	            for (int j = 0 ; j < edges ; j++){
	                System.out.print(incidenceMatrix[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
	}
