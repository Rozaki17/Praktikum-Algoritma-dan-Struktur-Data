package Modul_5.Project;

import java.util.Arrays;

public class Graph {
    Vertex head;
    Vertex tail;
    int jumlah = 0;

/*
    Membuat method addVertex() yang memiliki parameter string data sehingga
    ketika pemanggilan method ini, maka kita dapat memasukkan isi dari vertex yang 
    pada soal jurnal bertipe string. 
    Pada awal pembuatan method, maka dibuat sebuah objek dengan nama "baru" dari kelas 
    Vertex yang ditandai dengan penggunaan kata "new". 
    Pada method ini dilakukan 2 pengecekan, yaitu:
    1.  Jika tidak ada vertex dalam graph yang dimana pengecekan memanfaatkan method
        isEmpty() yang sudah dibuat, maka vertex tersebut akan menjadi head dan tail.
        Pada pengecekan pertama ini, diberikan "return" sehingga ketika kondisi ini terpenuhi
        maka tidak perlu mengecek kondisi lainnya lagi atau dengan kata lain kita tidak
        perlu membuat kondisi "else".
    2.  Namun jika kondisi pertama tidak terpenuhi, maka pointer nextVertex pada tail kita
        arah ke baru dan pindahkan tail ke baru. Terakhir, melakukan increment pada variabel
        jumlah setiap ada penambahan vertex baru.
*/

    public void addVertex(String data){
        Vertex baru = new Vertex(data);
        if(isEmpty()){
            head = tail = baru;
            jumlah++;
            return;
        }
        tail.nextVertex = baru;
        tail = baru;
        jumlah++;
    }
    public void addVertex(int index,String data){
        Vertex baru = new Vertex(index, data);
        if(isEmpty()){
            head = tail = baru;
            jumlah++;
            return;
        }
        tail.nextVertex = baru;
        tail = baru;
        jumlah++;
    }

/*
    Membuat method getVertex yang memiliki parameter string data. Pembuatan method ini
    digunakan untuk mencari suatu vertex tertentu yang emmabantu saat pembuatan method
    addEdge. Pada method ini, karena kita akan menelusuri satu persatu vertex yang ada
    maka kita membuat sebuah pointer bantu dengan nama cur yang kita posisikan pada 
    head. Kemudian dilakukan pengecekan kondisi yaitu selama cur tidak sama dengan null, maka
    dilakukan pengecekan kembali sebagai berikut.
    1.  Ketika data yang ditunjuk oleh pointer bantu cur sama dengan vertex yang dicari, maka
        return cur tersebut. Penggunakan equalIgnoreCase adalah agar saat ekseskusi program tidak
        terpangaruh oleh huruf kapital atau huruf kecil.
    2.  Namun jika tidak memenuhi kondisi pengecekan pada point 1, maka pindahkan pointer cur ke 
        data selanjutnya. "return null", berguna ketika data tersebut tidak ditemukan.
*/

    public Vertex getVertex(String data){
        Vertex cur = head;
        while(cur!= null){

            if(cur.data.equalsIgnoreCase(data)){
                return cur;
            }
            cur = cur.nextVertex;
        }
        return null;
    }
    public Vertex getVertex(int data){
        Vertex cur = head;
        while(cur!= null){

            if(cur.index == data){
                return cur;
            }
            cur = cur.nextVertex;
        }
        return null;
    }

/*
    Pembuatan method addEdge yang memiliki dua parameter yaitu String src dan String dst
    yang diantara kedua vertex tersebut akan dibuatkan egde atau garis.

    Untuk mengetahui vertex asal yaitu kita manfaatkan method getVertex() dengan memasukkan 
    parameter "src" dan pada vertex tujuan juga memanfaatkan method getVertex() dengan memasukkan
    parameter "dst". 

    Ketika pemanggilan method ini di class Main, maka kita diharuskan untuk memasukkan dua vertex,
    yaitu pertama sebagai vertex awal dan kedua sebagai vertex tujuan untuk dihubungkan keduanya satu
    sama lain.

    Untuk menghubungkan kedua vertex (asal dan tujuan) kita gunakan method connect(), dimana 
    karena pada soal jurnal merupakan graph tidak berarah sehingga kedua vertex saling terhubung
    satu sama lain atau dengan kata lain vertex asal memiliki edge ke vertex tujuan begitu sebaliknya.
    Sehingga pada pada method addEgde ini menggunakan 2 kali method connect() yaitu:
    1.  connect(asal, tujuan) : untuk menghubungan vertex awal dengan vertex tujuan
    2.  connect(tujuan, asal) : untuk menghubungkan vertex tujuan dengan vertex awal

*/

    public void addEdge(String src, String dst){
        Vertex asal = getVertex(src);
        Vertex tujuan = getVertex(dst);
        connect(asal, tujuan);
        connect(tujuan, asal);
    }

    public void addEdge(String src, String dst, double weight){
        Vertex asal = getVertex(src);
        Vertex tujuan = getVertex(dst);
        connect(asal, tujuan, weight);
        connect(tujuan, asal, weight);
    }
    
    

/*
    Membuat method connect() yang digunakan untuk menghubungakn antara vertex tujuan dan asal
    oleh edge pada graph. Pada method ini kita menggunakan pointer bantuan dengan nama bantu dengan
    tipe Edge yang diposisikan pada vertex asal tepatnya headEdge dari vertex asal.
    
    Kemudian dilakukan pengecekan kondisi yaitu, jika asal.headEdge sama dengan null, maka
    dibuat sebuah objek yang ditandai dengan penggunakan "new" dengan parameter tujuan. Penggunaan
    "return" digunakan ketika kondisi ini terpenuhi maka tidak perlu mengecek kondisi lainnya lagi atau 
    dengan kata lain kita tidak perlu membuat kondisi "else".

    Selama bantu.nextEdge tidak sama dengan null, maka pindahkan pointer bantu ke data 
    selanjutnya.

*/

    public void connect(Vertex asal, Vertex tujuan){
        Edge bantu = asal.headEdge;
        if(asal.headEdge == null){
            asal.headEdge = new Edge(tujuan);
            return;
        }
        //sambungin di paling belakang edge
        while(bantu.nextEdge != null){
            bantu = bantu.nextEdge;
        }
        bantu.nextEdge = new Edge(tujuan);
    }

    public void connect(Vertex asal, Vertex tujuan, double weight){
        Edge bantu = asal.headEdge;
        if(asal.headEdge == null){
            asal.headEdge = new Edge(tujuan, weight);
            return;
        }
        //sambungin di paling belakang edge
        while(bantu.nextEdge != null){
            bantu = bantu.nextEdge;
        }
        bantu.nextEdge = new Edge(tujuan, weight);
    }

/*
    Pembuatan method adjList() yang digunakan untuk menampilkan siapa saja 
    tetangga dari suatu vertex tertentu. Pada method ini membutuhkan bantuan
    pointer bantu untuk meneluri vertex yang ada yang dimana pointer bantu 
    kita posisikan pada awalnya di head. Kemudian dilakukan pengecekan kondisi
    yaitu selama bantu tidak sama dengan null, maka kita tampilkan data yang
    ditunjuk oleh pointer data dengan systax "System.out.println". 
    
    Didalam kondisi tersebut, kita buat kondisi lagi untuk menampilkan tetangga dari vertex 
    yang sudah ditampilaknsebelumnya yaitu dengan menggunakan pointer bantu2 dan 
    diposisikan di bantu.headEdge. Kondisi yang dibuat yaitu selama bantu2 tidak sama
    dengan null, maka kita tampilkan data yang ditunjuk oleh pointer bantu2 pada vertex
    tujuan yang dimana yang ditampilakn hanya datanya saja. Kemudian pointer ini akan terus 
    berpindah dari satu data ke data yang lain dengan syntax " bantu2=bantu2.nextEdge;".

    Setelah kondisi kedua sudah tidak terpenuhi lagi, baru kondisi pertama yang dimana
    pointer bantu akan bergerak ke data selanjutya dengan syntax " bantu=bantu.nextVertex;"
    kemudian baru masuk lagi pada kondisi kedua. Begitu seterusnya sampai kedua kondisi sudah 
    tidak terpenuhi lagi
*/

    public void adjList(){
        Vertex bantu = head;
        while (bantu != null){
            System.out.print("Vertex : " + bantu.data + " -> ");
            Edge bantu2=bantu.headEdge;
            while (bantu2!=null){

                System.out.print(bantu2.tujuan.data + " ");

                bantu2=bantu2.nextEdge;
            }
            System.out.println();
            bantu=bantu.nextVertex;
        }
    }

/*
    Membuat method isEmpty() yang bertipe boolean sehingga hanya memiliki dua nilai
    yaitu true atau false. Method ini berfungsi untuk mengecek apakah terdapat vertex 
    pada suatu graph atau tidak. Jika head bernilai null maka graph tersebut tidak memiliki
    vertex di dalamnya.
*/

    public boolean isEmpty() {
        return head == null;
    }

    public double djikstra(String src, String tujuan) {
        double[] jarak = new double[jumlah];
        int[] prev = new int[jumlah];

        PriorityQueue helper = new PriorityQueue();
        LinkedList<Vertex> jalur = new LinkedList<Vertex>();
        boolean[] visited = new boolean[jumlah];
        Arrays.fill(jarak, Integer.MAX_VALUE);
        Vertex asal = getVertex(src);
        jarak[asal.index] = 0;
        prev[asal.index] = -1;
        double UkeV = 0; //jarak antar 2 Basic.node yang dicek (u - v)
        helper.enqueue(asal, jarak);
        while (!helper.isEmpty()) {
            Vertex cur = helper.dequeue();
            Edge bantu = cur.headEdge;
            while (bantu != null) {
                UkeV = jarak[cur.index] + bantu.weight;
                if (UkeV < jarak[bantu.tujuan.index]) {
                    jarak[bantu.tujuan.index] = UkeV;
                    prev[bantu.tujuan.index] = cur.index;
                }
                if (!visited[bantu.tujuan.index]) {
                    helper.enqueue(bantu.tujuan, jarak);

                }
                bantu = bantu.nextEdge;
            }
            visited[cur.index] = true;
        }
        
        Vertex dst = getVertex(tujuan);
        System.out.print("\n\nJalur tercepat dari " + asal.data + " ke " + dst.data + " adalah : ");
        int simpan = dst.index;
        while(simpan != -1){
            jalur.addFirst(getVertex(simpan));
            simpan = prev[simpan];
        }

        //print jalur

        for(Node<Vertex> cur = jalur.getHead(); cur != null; cur = cur.next){
            if (cur != jalur.getHead()){
                System.out.print(" --> ");
            }
            System.out.print(cur.data.data);
        }

        return jarak[dst.index];
    }
}