import java.io.*;
import java.util.*;
public class ShortestPath{
  public static void main(String[] args){
    String label = "??";
    ArrayList<String> edges = new ArrayList<String>();
    ArrayList<Double> weights = new ArrayList<Double>();
    WeightedGraph wg = new WeightedGraph();
    Scanner sc;
    try{
      sc = new Scanner(new FileInputStream("D:\\JAVA\\shortestPath.txt"));
      while(sc.hasNext()){ // hasNext() does not move the scanner
        label = sc.next();
        while(!(sc.hasNextInt())){
          if(sc.hasNext(",") || sc.hasNext("\\{") || sc.hasNext("\\}")){ // "{" and "}" are reserved keyword, so need "\\{"
            sc.next(); // move the scanner to the next position
          } else{
            edges.add(sc.next());
          }
        }
        while(!(sc.hasNext("\\}"))){
          if(sc.hasNextDouble()){
            weights.add(sc.nextDouble());
          } else{
            sc.next();
          }
        }
        sc.next();
        wg.createNode(label, edges, weights);
        edges.clear();
        weights.clear();
      }
      sc.close();
    } catch(FileNotFoundException fnfe){
      System.out.println("File not found or cannot be opened.");
    }

    ArrayList<Node> weightedGraph = wg.getWeightGraph();
    ArrayList<String> labelList = wg.getlabelList();

    System.out.println("Starting point: ");
    String startPoint = IO.readString();
    Node startNode;
    for(int i=0; i< labelList.size(); i++){
      if (labelList.get(i) == startPoint){
        startNode = weightedGraph.get(i);
        break;
      }
    }
    System.out.println("Ending point: ");
    String endPoint = IO.readString();
    Node endNode;
    for(int i=0; i< labelList.size(); i++){
      if (labelList.get(i) == endPoint){
        endNode = weightedGraph.get(i);
        break;
      }
    }
    System.out.println(shortestPathAlgorithm(startNode, endNode, wg));
  }

  public static String shortestPathAlgorithm(Node start, Node end, WeightedGraph obj){
    Node pointer = start;
    ArrayList<Node> pathInfo = new ArrayList<Node>();
    pathInfo.add(pointer);
    obj.cretePath(pathInfo);
    while(minNode != end || minNode != smallestElement){
        for(int i=0; i < (pointer.getListOfEdges()).size(); i++){
          pathInfo =
          obj.createPath();
        }
      }
    }
  }
}
