package Modul_4;

import java.util.*;

public class Graph {
    ArrayList<Vertex> list = new ArrayList<Vertex>();
    
    void addEdge (String from, String dest){
        Vertex tmp1 = search(from);
        Vertex tmp2 = search(dest);
        tmp1.edge.add(new Edge(tmp2));
        tmp2.edge.add(new Edge(tmp1));
    }
    
    Vertex search (String source){
        for (int a = 0; a < list.size(); ++a){
            if (source.equalsIgnoreCase(list.get(a).data)){
                return list.get(a);
            }
        }
        Vertex vertex = new Vertex(source);
        list.add(vertex);
        return vertex;
    }
    
    void print (){
        for (int a = 0; a < list.size(); ++a){
            System.out.printf("Vertex %d : %s --> ", (a+1),list.get(a).data);
            for (int b = 0; b < list.get(a).edge.size(); ++b){
                if (list.get(a).data.equalsIgnoreCase(list.get(a).data)){
                    System.out.printf("%s ", list.get(a).edge.get(b).dest.data);
                }
            }
            System.out.println();
        }
    }
    
    int findIndex (Vertex find){
        for (int a = 0; a < list.size(); ++a){
            if (find == list.get(a)){
                return a;
            }
        }
        return -1;
    }
    
    void BFS (Vertex start){
        Boolean[] cekVisited = new Boolean[list.size()];
        Arrays.fill(cekVisited, false);
        Queue queue = new Queue();
        queue.add(start);
        
        while (!queue.isEmpty()){
            Vertex tmp = queue.poll();
            cekVisited[findIndex(tmp)] = true;
            System.out.print(tmp.data + " ");
            
            for (int a = 0; a < tmp.edge.size(); ++a){
                Vertex edge = tmp.edge.get(a).dest;
                int index = findIndex(edge);
                if (!cekVisited[index]){
                    queue.add(edge);
                    cekVisited[findIndex(edge)] = true;
                }
            }
        }
    }

    void DFSProcess (Vertex cek, Boolean visited[]){
        visited[findIndex(cek)] = true;
        System.out.print(cek.data + " ");

        for (int a = 0; a < cek.edge.size(); ++a){
            int index = findIndex(cek.edge.get(a).dest);
            Vertex tmp = cek.edge.get(a).dest;
            if (!visited[index]){
                DFSProcess(tmp, visited);
            }
        }
    }

    void DFS (Vertex start){
        Boolean[] cekVisited = new Boolean[list.size()];
        Arrays.fill(cekVisited, false);

        DFSProcess(start, cekVisited);
    }
}
