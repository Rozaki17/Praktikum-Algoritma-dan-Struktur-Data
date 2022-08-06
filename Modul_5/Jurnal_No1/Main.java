package Modul_5.Jurnal_No1;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge("Alpha", "Betas");
        graph.addEdge("Alpha", "Certas");
        graph.addEdge("Betas", "Certas");
        graph.addEdge("Certas", "Deltas");
        graph.addEdge("Betas", "Epsas");
        graph.addEdge("Certas", "Epsas");
        graph.addEdge("Deltas", "Fetas");
        graph.addEdge("Epsas", "Fetas");

        graph.printGraph();

        graph.graphColoring();
    }
}