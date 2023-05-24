import java.util.LinkedList;

public class MyGraph {
    private int numOfVertices;
    private LinkedList<Integer>[] adgList;
    public MyGraph(int numOfVertices){
        this.numOfVertices = numOfVertices;
        adgList = new LinkedList[numOfVertices];
        for(int i = 0; i < numOfVertices; i++){
            adgList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int source, int destination){
        validateVertex(source);
        validateVertex(destination);
        adgList[source].add(destination);
        adgList[destination].add(source);
    }
    private void validateVertex(int index){
        if(index < 0 || index > numOfVertices){
            throw new IllegalArgumentException("Vertex "+ index + " is out of range");
        }
    }

}
