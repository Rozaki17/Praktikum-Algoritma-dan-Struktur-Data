package Modul_5.Jurnal_No2;

import java.util.*;

public class Graph {
    ArrayList<Vertices> verticesList = new ArrayList<Vertices>();

    void addEdge (String from, String dest, int weight){
        Vertices tmp1 = search(from);
        Vertices tmp2 = search(dest);
        tmp1.edge.add(new Edge(tmp2, weight));
        tmp2.edge.add(new Edge(tmp1, weight));
    }

    Vertices search (String source){
        for (int a = 0; a < verticesList.size(); ++a){
            if (source.equalsIgnoreCase(verticesList.get(a).namaDaerah)){
                return verticesList.get(a);
            }
        }
        Vertices currentVertex = new Vertices(source);
        verticesList.add(currentVertex);
        return currentVertex;
    }

    int findIndex (Vertices find){
        for (int a = 0; a < verticesList.size(); ++a){
            if (find == verticesList.get(a)){
                return a;
            }
        }
        return -1;
    }

    Vertices findVertices (String find){
        for (int a = 0; a < verticesList.size(); ++a){
            String cek = verticesList.get(a).namaDaerah;
            if (find.equalsIgnoreCase(cek)){
                Vertices found = verticesList.get(a);
                return found;
            }
        }
        return null;
    }

    Vertices findVertices (int find){
        for (int a = 0; a < verticesList.size(); ++a){
            int cek = findIndex(verticesList.get(a));
            if (find == cek){
                Vertices found = verticesList.get(a);
                return found;
            }
        }
        return null;
    }
    
    int djikstra (String from, String destination){
        PriorityQueue pq = new PriorityQueue();

        int[] track = new int[verticesList.size()];
        boolean[] cekVisited = new boolean[verticesList.size()];

        int[] jarak = new int[verticesList.size()];
        Arrays.fill(jarak, Integer.MAX_VALUE);

        Vertices source = findVertices(from);
        pq.add(source, 0);
        jarak[findIndex(source)] = 0;
        track[findIndex(source)] = -1;

        while (!pq.isEmpty()){
            Vertices currentVertex = pq.poll();
            int tmp1 = findIndex(currentVertex);
            cekVisited[tmp1] = true;
            for (int a = 0; a < currentVertex.edge.size(); ++a){
                Vertices dest = currentVertex.edge.get(a).vertex;
                int weight = jarak[tmp1] + currentVertex.edge.get(a).weight;
                int tmp2 = findIndex(dest);

                if (weight < jarak[tmp2]){
                    jarak[tmp2] = weight;
                    track[tmp2] = tmp1;
                }

                if (!cekVisited[tmp2]){
                    pq.add(dest, jarak[tmp2]);
                }
            }
        }

        System.out.printf("Jalur Tercepat dari %s ke %s adalah : ", source.namaDaerah, destination);
        Stack shortestPath = new Stack();
        Vertices verticesDest = findVertices(destination);
        int simpan = findIndex(verticesDest);
        while (simpan != -1){
            shortestPath.insertStack(findVertices(simpan));
            simpan = track[simpan];
        }

        for(Node current = shortestPath.getHead(); current != null; current = current.next){
            if (current != shortestPath.getHead()){
                System.out.print(" --> ");
            }
            System.out.print(current.dest.namaDaerah);
        }

        return jarak[findIndex(verticesDest)];
    }

    void print (){
        for (int a = 0; a < verticesList.size(); ++a){
            System.out.printf("Vertex %d : %s --> ", (a+1),verticesList.get(a).namaDaerah);
            for (int b = 0; b < verticesList.get(a).edge.size(); ++b){
                if (verticesList.get(a).namaDaerah.equalsIgnoreCase(verticesList.get(a).namaDaerah)){
                    System.out.printf("%s(%d) ", verticesList.get(a).edge.get(b).vertex.namaDaerah, verticesList.get(a).edge.get(b).weight);
                }
            }
            System.out.println();
        }
    }
}
