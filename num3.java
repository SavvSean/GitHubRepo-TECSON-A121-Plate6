package plate_6;
import java.util.*;

public class num3 {

	
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        List<List<Integer>> connectedEdges = new ArrayList<>();
	        List<Integer> currentEdge = new ArrayList<>();

	        System.out.print("Enter number of edges: ");
	        int pairs = scan.nextInt();

	        int previousVertex = -1;

	        for (int i = 0; i < pairs; i++) {
	            System.out.print("Edge " + (i + 1) + ": ");
	            int u = scan.nextInt();
	            int v = scan.nextInt();

	            if (previousVertex == -1 || previousVertex == u || previousVertex == v) {
	                currentEdge.add(u);
	                currentEdge.add(v);
	            } else {
	                connectedEdges.add(currentEdge);
	                currentEdge = new ArrayList<>();
	                currentEdge.add(u);
	                currentEdge.add(v);
	            }
	            previousVertex = v;
	        }

	        if (!currentEdge.isEmpty()) {
	            connectedEdges.add(currentEdge);
	        }

	        if(hasCycle(connectedEdges)){
	            System.out.println("Has Cycle");
	        } else {
	            System.out.println("Does not have cycle.");
	        }
	    }
	    
	    public static boolean hasCycle(List<List<Integer>> connectedEdges) {
	        for (List<Integer> edges : connectedEdges) {
	            if (!edges.isEmpty() && edges.get(0).equals(connectedEdges.size() - 1)) {
	                return true;
	            }
	        }
	        return false;
	    }

	}
