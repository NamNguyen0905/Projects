import java.util.*;
public class WeightedGraph{
    private String name;
    private ArrayList<Node> weightedGraph = new ArrayList<Node>();
    private ArrayList<String> labelList = new ArrayList<String>();
    private ArrayList<Path> pathList = new ArrayList<Path>();

    public void createNode(String label, ArrayList<String> edges, ArrayList<Double> weights){
      Node node = new Node(label, edges, weights);
      weightedGraph.add(node);
      nodesList.add(label);
    }
    public ArrayList<Node> getWeightGraph(){
      return weightedGraph;
    }
    public ArrayList<String> getlabelList(){
      return labelList;
    }

    public void createPath(ArrayList<Node> list){
      Path path = new Path(list);
      pathList.add(path);
    }
    public ArrayList<Path> getPathList(){
      return pathList;
    }
    public Path getMinimumPath(){
      return ...
    }
    pulic Node getLastPointOfPath(){
      return...
    }

    class Node{
      private String label;
      private ArrayList<Edge> listOfEdges = new ArrayList<Edge>();

      public Node(String label, ArrayList<String> edges, ArrayList<Double> weights){
        this.label = label;
        for(int i=0;i<edges.size(); i++){
          Edge edge = new Edge(label, edges.get(i), weights.get(i));
          listOfEdges.add(edge);
        }
      }
      public ArrayList<Edge> getListOfEdges(){
        return listOfEdges;
      }
      public String getLabel(){
        return label;
      }
      public double getWeight(Node destination){
        for(Edge x:listOfEdges) {
          if(x.getDestination()== destination.getLabel()){
            return x.getWeight();
          }
        }
        return -1;
      }
  }

  class Edge{
    private String startingPoint;
    private String destination;
    private Double weight;

    public Edge(String startPoint, String destination, Double weight){
      startingPoint = startPoint;
      this.destination = destination;
      this.weight = weight;
    }
    public String getStartingPoint(){
      return startingPoint;
    }
    public String getDestination(){
      return destination;
    }
    public Double getWeight(){
      return weight;
    }
  }

  class Path{
    private ArrayList<Node> listOfNodes = new ArrayList<Node>();
    private ArrayList<String> listOfNames = new ArrayList<String>();
    private double totalWeight = 0;

    public Path(ArrayList<Node> nodes){
      listOfNodes = nodes;
      for(int x=0; x<nodes.size()-1; x++){
        listOfNames.add((nodes.get(x)).getLabel());
        totalWeight += (nodes.get(x)).getWeight(nodes.get(x+1));
      }
    }
    public double getTotalWeight(){
      return totalWeight;
    }
    public String toString(){
      String str = listOfNames.get(0);
      for(int i=1; i<listOfNames.size(); i++){
        str += (" -> " + listOfNames.get(i));
      }
      str += "\n Total Weight: " + totalWeight;
      return str;
    }
  }

}
