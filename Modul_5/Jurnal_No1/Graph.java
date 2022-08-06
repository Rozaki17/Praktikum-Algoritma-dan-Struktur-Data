package Modul_5.Jurnal_No1;

import java.util.*;

public class Graph {
    ArrayList<Vertices> verticesList =  new ArrayList<Vertices>();

    void addEdge (String from, String dest){
        Vertices tmp1 = search(from);
        Vertices tmp2 = search(dest);
        tmp1.edge.add(new Edge(tmp2));
        tmp2.edge.add(new Edge(tmp1));
    }
    
    Vertices search (String source){
        for (int a = 0; a < verticesList.size(); ++a){
            if (source.equalsIgnoreCase(verticesList.get(a).data)){
                return verticesList.get(a);
            }
        }
        Vertices vertex = new Vertices(source);
        verticesList.add(vertex);
        return vertex;
    }

    int findIndex (Vertices find){
        for (int a = 0; a < verticesList.size(); ++a){
            if (find == verticesList.get(a)){
                return a;
            }
        }
        return -1;
    }

    void printGraph (){
        for (int a = 0; a < verticesList.size(); ++a){
            System.out.printf("%s --> ", verticesList.get(a).data);
            for (int b = 0; b < verticesList.get(a).edge.size(); ++b){
                if (verticesList.get(a).data.equalsIgnoreCase(verticesList.get(a).data)){
                    System.out.printf("%s ", verticesList.get(a).edge.get(b).vertex.data);
                }
            }
            System.out.println();
        }
    }

    int getMaxChromatic (int cekMax[]){
        int max = cekMax[0];
        for (int a = 1; a < cekMax.length; ++a){
            if (cekMax[a] > max){
                max = cekMax[a];
            }
        }
        return max;
    }

    void graphColoring (){
        int colorResult[] = new int[verticesList.size()];
        Arrays.fill(colorResult, -1);
        colorResult[0] = 0;

        boolean isColored[] = new boolean[verticesList.size()];
        Arrays.fill(isColored, true);

        for (int a = 1; a < verticesList.size(); ++a){
            for (int b = 0; b < verticesList.get(a).edge.size(); ++b){
                Vertices tmp = verticesList.get(a).edge.get(b).vertex;
                int index = findIndex(tmp);
                if (colorResult[index] != -1){
                    isColored[colorResult[index]] = false;
                }
            }

            int c;
            for (c = 0; c < verticesList.size(); ++c){
                if (isColored[c]) break;
            }

            colorResult[a] = c;

            Arrays.fill(isColored, true);
        }

        for (int u = 0; u < verticesList.size(); u++)
            System.out.println("Vertex " + verticesList.get(u).data + " --->  Color " + colorResult[u]);

        int maxChromatic = getMaxChromatic(colorResult);
        for (int x = 0; x <= maxChromatic; ++x){
            System.out.printf("Tanki %d : ", colorResult[x]+1);
            for (int y = 0; y < verticesList.size(); ++y){
                int tmp = findIndex(verticesList.get(y));
                if (colorResult[x] == colorResult[tmp]) System.out.printf("%s ", verticesList.get(tmp).data);
            }
            System.out.println();
        }
    }
}
