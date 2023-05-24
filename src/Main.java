public class Main {
    public static void main(String[] args) {

        MyGraph myGraph = new MyGraph(8);
        myGraph.addEdge(0, 1);
        myGraph.addEdge(2, 3);
        myGraph.addEdge(4, 5);
        myGraph.addEdge(6, 7);
        myGraph.printEdge();
        System.out.println(myGraph.HaveEdge(2,3));
        System.out.println(myGraph.getNeighbor(2));
    }
}