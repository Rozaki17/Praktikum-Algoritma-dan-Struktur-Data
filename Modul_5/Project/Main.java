package Modul_5.Project;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        Graph graph = new Graph();
        Scanner keysScanner = new Scanner(System.in);
        Hashtable <Integer, String> hospitalList = new Hashtable<Integer, String>();

        hospitalList.put(1, "RS Metro Medica");
        hospitalList.put(2, "RS San Antonius");
        hospitalList.put(3, "RS Harapan Keluarga");
        hospitalList.put(4, "RSAD Wira Bhakti");
        hospitalList.put(5, "Siti Hajar Islamic Hospital");
        hospitalList.put(6, "RS Sentra Medica");
        hospitalList.put(7, "RS Ibu dan Anak");
        hospitalList.put(8, "Mataram Police Hospital");
        hospitalList.put(9, "RS Permata Hati");
        hospitalList.put(10, "RS Universitas Mataram");
        hospitalList.put(11, "Siloam Hospital");
        hospitalList.put(12, "Regional General Hospital");
        hospitalList.put(13, "Biomedika Hospital");
        hospitalList.put(14, "RSUD Provinsi NTB");

        graph.addVertex(0, hospitalList.get(1));
        graph.addVertex(1, hospitalList.get(2));
        graph.addVertex(2, hospitalList.get(3));
        graph.addVertex(3, hospitalList.get(4));
        graph.addVertex(4, hospitalList.get(5));
        graph.addVertex(5, hospitalList.get(6));
        graph.addVertex(6, hospitalList.get(7));
        graph.addVertex(7, hospitalList.get(8));
        graph.addVertex(8, hospitalList.get(9));
        graph.addVertex(9, hospitalList.get(10));
        graph.addVertex(10, hospitalList.get(11));
        graph.addVertex(11, hospitalList.get(12));
        graph.addVertex(12, hospitalList.get(13));
        graph.addVertex(13, hospitalList.get(14));

        graph.addEdge(hospitalList.get(1), hospitalList.get(2), 3.9);
        graph.addEdge(hospitalList.get(1), hospitalList.get(3), 4.6);
        graph.addEdge(hospitalList.get(1), hospitalList.get(4), 2.5);
        graph.addEdge(hospitalList.get(1), hospitalList.get(6), 3.8);
        graph.addEdge(hospitalList.get(1), hospitalList.get(8), 6.8);
        graph.addEdge(hospitalList.get(1), hospitalList.get(10), 6.2);

        graph.addEdge(hospitalList.get(2), hospitalList.get(1), 3.9);
        graph.addEdge(hospitalList.get(2), hospitalList.get(8), 1.4);

        graph.addEdge(hospitalList.get(3), hospitalList.get(1), 4.6);
        graph.addEdge(hospitalList.get(3), hospitalList.get(4), 4.7);
        graph.addEdge(hospitalList.get(3), hospitalList.get(6), 4.7);
        graph.addEdge(hospitalList.get(3), hospitalList.get(14), 5.8);

        graph.addEdge(hospitalList.get(4), hospitalList.get(1), 2.5);
        graph.addEdge(hospitalList.get(4), hospitalList.get(3), 4.7);
        graph.addEdge(hospitalList.get(4), hospitalList.get(5), 1.8);
        graph.addEdge(hospitalList.get(4), hospitalList.get(6), 1.9);
        graph.addEdge(hospitalList.get(4), hospitalList.get(7), 2.4);
        graph.addEdge(hospitalList.get(4), hospitalList.get(8), 3.0);
        graph.addEdge(hospitalList.get(4), hospitalList.get(9), 3.6);
        graph.addEdge(hospitalList.get(4), hospitalList.get(11), 2.6);
        graph.addEdge(hospitalList.get(4), hospitalList.get(12), 2.9);

        graph.addEdge(hospitalList.get(5), hospitalList.get(4), 1.8);
        graph.addEdge(hospitalList.get(5), hospitalList.get(6), 1.7);
        graph.addEdge(hospitalList.get(5), hospitalList.get(7), 2.5);
        graph.addEdge(hospitalList.get(5), hospitalList.get(11), 2.7);
        graph.addEdge(hospitalList.get(5), hospitalList.get(14), 5.1);

        graph.addEdge(hospitalList.get(6), hospitalList.get(1), 3.8);
        graph.addEdge(hospitalList.get(6), hospitalList.get(3), 4.7);
        graph.addEdge(hospitalList.get(6), hospitalList.get(4), 1.9);
        graph.addEdge(hospitalList.get(6), hospitalList.get(5), 1.7);
        graph.addEdge(hospitalList.get(6), hospitalList.get(7), 2.6);
        graph.addEdge(hospitalList.get(6), hospitalList.get(12), 3.0);
        graph.addEdge(hospitalList.get(6), hospitalList.get(14), 3.8);

        graph.addEdge(hospitalList.get(7), hospitalList.get(4), 2.4);
        graph.addEdge(hospitalList.get(7), hospitalList.get(5), 2.5);
        graph.addEdge(hospitalList.get(7), hospitalList.get(6), 2.6);
        graph.addEdge(hospitalList.get(7), hospitalList.get(11), 2.0);
        graph.addEdge(hospitalList.get(7), hospitalList.get(12), 1.1);
        graph.addEdge(hospitalList.get(7), hospitalList.get(14), 4.2);

        graph.addEdge(hospitalList.get(8), hospitalList.get(1), 6.8);
        graph.addEdge(hospitalList.get(8), hospitalList.get(2), 1.4);
        graph.addEdge(hospitalList.get(8), hospitalList.get(4), 3.0);
        graph.addEdge(hospitalList.get(8), hospitalList.get(9), 1.4);

        graph.addEdge(hospitalList.get(9), hospitalList.get(4), 3.6);
        graph.addEdge(hospitalList.get(9), hospitalList.get(8), 1.4);
        graph.addEdge(hospitalList.get(9), hospitalList.get(10), 1.1);

        graph.addEdge(hospitalList.get(10), hospitalList.get(1), 6.2);
        graph.addEdge(hospitalList.get(10), hospitalList.get(9), 1.1);
        graph.addEdge(hospitalList.get(10), hospitalList.get(11), 1.6);

        graph.addEdge(hospitalList.get(11), hospitalList.get(4), 2.6);
        graph.addEdge(hospitalList.get(11), hospitalList.get(5), 2.7);
        graph.addEdge(hospitalList.get(11), hospitalList.get(7), 2.0);
        graph.addEdge(hospitalList.get(11), hospitalList.get(10), 1.6);
        graph.addEdge(hospitalList.get(11), hospitalList.get(12), 2.4);

        graph.addEdge(hospitalList.get(12), hospitalList.get(4), 2.9);
        graph.addEdge(hospitalList.get(12), hospitalList.get(6), 3.0);
        graph.addEdge(hospitalList.get(12), hospitalList.get(7), 1.1);
        graph.addEdge(hospitalList.get(12), hospitalList.get(11), 2.0);
        graph.addEdge(hospitalList.get(12), hospitalList.get(13), 0.75);
        graph.addEdge(hospitalList.get(12), hospitalList.get(14), 4.0);

        graph.addEdge(hospitalList.get(13), hospitalList.get(12), 0.75);
        graph.addEdge(hospitalList.get(13), hospitalList.get(14), 4.5);

        graph.addEdge(hospitalList.get(14), hospitalList.get(3), 5.8);
        graph.addEdge(hospitalList.get(14), hospitalList.get(5), 5.1);
        graph.addEdge(hospitalList.get(14), hospitalList.get(6), 3.8);
        graph.addEdge(hospitalList.get(14), hospitalList.get(7), 4.2);
        graph.addEdge(hospitalList.get(14), hospitalList.get(12), 4.0);
        graph.addEdge(hospitalList.get(14), hospitalList.get(13), 4.5);
        
        String choice = "y";
        while (choice.equalsIgnoreCase("y")){
            System.out.println("=====================================================================");
            System.out.println("|  PROGRAM PENGHITUNG JARAK TERPENDEK ANTAR RUMAH SAKIT DI MATARAM  |");
            System.out.println("=====================================================================");
            System.out.print("\nMasukkan Nama Rumah Sakit Asal : ");
            String RSAsal = keysScanner.next();
            RSAsal += keysScanner.nextLine();
            System.out.print("\nMasukkan Nama Rumah Sakit Tujuan : ");
            String RSTujuan = keysScanner.next();
            RSTujuan += keysScanner.nextLine();
    
            double total = graph.djikstra(RSAsal, RSTujuan);
    
            System.out.println(", dengan total jarak tempuh " + total + " km\n");
            System.out.print("Lanjutkan?(y/n) : ");
            choice = keysScanner.next();
            if (choice.equalsIgnoreCase("y")) 
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("\n\n\t\t\tTerimakasih\n\n");

        keysScanner.close();
    }
}
