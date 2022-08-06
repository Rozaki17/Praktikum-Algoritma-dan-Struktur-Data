package Modul_5.Project;

/*  
    Membuat class dengan nama "Edge" yang dimana class ini bertipe public sehingga class
    ini bisa dipanggil dari class manapun diluar kelas ini. Kelas Edge ini memiliki 2 atribut 
    yaitu Vertex tujuan yang merupakan vertex yang akan dihubungan oleh edge pada graph serta 
    memiliki satu pointer nextEdge bertipe data Egde.
*/

public class Edge {
    double weight;
    Vertex tujuan;
    Edge nextEdge;

/*  
    Membuat sebuah constructor dari class Edge yang dimana ini merupakan 
    method yang dipanggil pertama saat pembuatan objek nantinya. 
    Consturctor ini memiliki satu parameter yaitu Vertex tujuan.
*/

    public Edge(Vertex tujuan){
        this.tujuan = tujuan;
    }

    public Edge(Vertex tujuan, double weight){
        this.tujuan = tujuan;
        this.weight = weight;
    }
    
}