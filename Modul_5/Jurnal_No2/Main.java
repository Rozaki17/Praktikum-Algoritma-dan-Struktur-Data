package Modul_5.Jurnal_No2;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge("Fukuoka", "Osaka", 10);
        graph.addEdge("Fukuoka", "Nigata", 8);
        graph.addEdge("Osaka", "Nagano", 12);
        graph.addEdge("Osaka", "Saitama", 10);
        graph.addEdge("Osaka", "Shiga", 5);
        graph.addEdge("Osaka", "Hyogo", 6);
        graph.addEdge("Nigata", "Shiga", 20);
        graph.addEdge("Nigata", "Miyagi", 15);
        graph.addEdge("Nagano", "Gunma", 8);
        graph.addEdge("Nagano", "Saitama", 6);
        graph.addEdge("Saitama", "Miyagawa", 9);
        graph.addEdge("Saitama", "Fukushima", 12);
        graph.addEdge("Shiga", "Chiba", 15);
        graph.addEdge("Shiga", "Kyoto", 7);
        graph.addEdge("Hyogo", "Kyoto", 5);
        graph.addEdge("Gunma", "Miyagawa", 10);
        graph.addEdge("Miyagawa", "Fukushima", 3);
        graph.addEdge("Chiba", "Miyagi", 4);
        graph.addEdge("Fukushima", "Miyagi", 25);

        graph.print();
        int totalTempuh = graph.djikstra("Osaka", "Miyagi");

        System.out.printf("\nDengan total jarak tempuh %d km", totalTempuh);
    }
}
