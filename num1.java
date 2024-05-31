package plate_6;
import java.util.*;


public class num1 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter the number of edges: ");
    int numEdges = scan.nextInt();

    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < numEdges; i++) {
      System.out.println("Enter source and destination for edge " + (i + 1) + ": ");
      int source = scan.nextInt();
      int destination = scan.nextInt();
      edges.add(new Edge(source, destination));
    }

    if (isConnected(edges)) {
      System.out.println("The graph is connected.");
    } else {
      System.out.println("The graph is not connected.");
      int numComponents = countConnectedComponents(edges);
      System.out.println("Number of connected components: " + numComponents);
    }

    scan.close();
  }

  static class Edge {
    int source;
    int destination;

    public Edge(int source, int destination) {
      this.source = source;
      this.destination = destination;
    }
  }

  public static boolean isConnected(List<Edge> edges) {
    Set<Integer> vertices = new HashSet<>();
    for (Edge edge : edges) {
      vertices.add(edge.source);
      vertices.add(edge.destination);
    }

    int startingNode = vertices.iterator().next();
    Set<Integer> visited = new HashSet<>();
    dfs(edges, startingNode, visited);

    return visited.size() == vertices.size();
  }

  private static void dfs(List<Edge> edges, int node, Set<Integer> visited) {
    visited.add(node);
    for (Edge edge : edges) {
      if (edge.source == node && !visited.contains(edge.destination)) {
        dfs(edges, edge.destination, visited);
      }
    }
  }

  public static int countConnectedComponents(List<Edge> edges) {
    Set<Integer> vertices = new HashSet<>();
    for (Edge edge : edges) {
      vertices.add(edge.source);vertices.add(edge.destination);
    }

    Set<Integer> visited = new HashSet<>();
    int count = 0;
    for (int vertex : vertices) {
      if (!visited.contains(vertex)) {
        dfs(edges, vertex, visited);
        count++;
      }
    }
    return count;
  }
}
