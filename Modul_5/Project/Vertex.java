package Modul_5.Project;

/*  
    Membuat class dengan nama "Vertex" yang dimana class ini bertipe public sehingga class
    ini bisa dipanggil dari class manapun diluar kelas ini. Kelas vertex ini memiliki 3 atribut 
    yaitu atribut data yang bertipe data string untuk menyimpan isi dri vertext pada graph. 
    Kemudian terdapat pointer nextVertex yang digunakan sebagai pointer penunjuk ke vertex
    selanjutnya pada graph sehingga memiliki tipe data Vertex serta memiliki atribut headEgde yang
    bertipe data Edge karena merupakan pointer penunjuk juga.
*/

public class Vertex {
    int index;
    String data;
    Vertex nextVertex;
    Edge headEdge;
    
/*  
    Membuat sebuah constructor dari class Vertex yang dimana ini merupakan 
    method yang dipanggil pertama saat pembuatan objek nantinya. 
    Consturctor ini memiliki satu parameter yaitu String data.
*/
    public Vertex(int index, String data){
        this.index = index;
        this.data = data;

    }
    public Vertex(String data){
        this.data = data;
    }
}
