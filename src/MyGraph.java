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
    public void removeEdge(int source, int destination){
        validateVertex(source);
        validateVertex(destination);
        adgList[source].remove(destination);
        adgList[destination].remove(source);
    }
    public boolean HaveEdge(int source, int destination){
        validateVertex(source);
        validateVertex(destination);
        return adgList[source].contains(destination);
    }
    public LinkedList<Integer> getNeighbor(int vertex){
        validateVertex(vertex);
        return adgList[vertex];
    }
    public void DFS(int startVertex){
        validateVertex(startVertex);
        boolean[] visited = new boolean[numOfVertices];
        DFSHelper(startVertex, visited);
    }
    private void DFSHelper(int vertex, boolean[] visited){
        visited[vertex] = true;
        System.out.println(vertex + " ");
        for(int neighbor : adgList[vertex]){
            if(!visited[vertex]){
                DFSHelper(neighbor, visited);
            }
        }
    }
    public void printEdge(){
        for(int i = 0; i < numOfVertices; i++){
            System.out.println("Vertex " + i +" connected to: ");
            for(int neighbor : adgList[i]){
                System.out.println(neighbor + " ");
            }
            System.out.println();
        }
    }

    private void validateVertex(int index){
        if(index < 0 || index > numOfVertices){
            throw new IllegalArgumentException("Vertex "+ index + " is out of range");
        }
    }

}
