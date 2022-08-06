package Modul_4;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge("Mataram", "Gerung");
        graph.addEdge("Mataram", "Selong");
        graph.addEdge("Mataram", "Praya");
        graph.addEdge("Selong", "Masbagik");
        graph.addEdge("Selong", "Sembalun");
        graph.addEdge("Gerung", "Kopang");
        graph.addEdge("Praya", "Kopang");
        graph.addEdge("Masbagik", "Sembalun");
        graph.addEdge("Masbagik", "Kopang"); 

        System.out.println("Adjecency List : ");
        graph.print();

        System.out.println("===BFS===");
        graph.BFS(graph.list.get(0));
        System.out.println("\n===DFS===");
        graph.DFS(graph.list.get(0));
    }
}