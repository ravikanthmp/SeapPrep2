package leetcode.arrays.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q133 {

  public Node cloneGraph(Node node) {
    return cloneGraph(node, new HashMap<>(), null);
  }

  private Node cloneGraph(Node node, Map<Node, Node> visitedMap, Node parent) {

    Node clonedNode = new Node(node.val, new ArrayList<>());
    visitedMap.put(node, clonedNode);

    for (Node neighbor : node.neighbors) {
      if (neighbor == parent) {
        continue;
      }
      if (!visited(neighbor, visitedMap)) {
        // visit recursively
        clonedNode.neighbors.add(cloneGraph(neighbor, visitedMap, node));
      } else {
        Node clonedNeighbor = visitedMap.get(neighbor);
        clonedNode.neighbors.add(clonedNeighbor);
      }
    }

    return clonedNode;

  }

  private boolean visited(Node neighbor, Map<Node, Node> visitedMap) {
    return visitedMap.containsKey(neighbor);
  }

  class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }


}
