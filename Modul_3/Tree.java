package Modul_3;

//Berikut merupakan class tree yang digunakan untuk membuat proses-proses seperti memasukkan data nama keluarga kedalam tree, mencari 
//hubungan keluarga dalam tree yang ada, dan sebagainya
public class Tree {
    //berikut merupakan deklarasi variabel root dengan tipe data node yang dimana node merupakan tipe data buatan yang berisi data 
    //asli berupa string
    node root;

    //berikut merupakan method yang digunakan untuk menambah node pada tree yang akan kita buat, dimana pada method ini menggunakan
    //tiga parameter yang ketiganya bertipe data string
    void addNode (String parent, String left, String right){
        //berikut merupakan kondisi pengecekan apakah nilai dari root kosong atau tidak, jika kosong maka akan diisi dengan 
        //node baru yang berisi data nama parent pada parameter pertama
        if (root == null) root = new node(parent);
        node nama = search(root, parent);
        nama.left = new node(left);
        nama.right = new node(right);
    }

    //berikut merupakan method yang digunakan untuk mencari parent dari nama yang akan menjadi child nya,
    //yang dimana method ini bertipe data node, maka method ini akan memiliki balikan nilai sebuah node juga
    node search (node root, String Parent){
        //berikut merupakan kondisi pengecekan jika root yang masuk dari parameter adalah null, jika iya maka dari rekursif yang
        //ada akan kembali dengan nilai null
        if (root == null) return null;

        //berikut merupakan kondisi untuk mengecek nilai nama dari root apakah sama dengan nama parent yang masuk ke method ini
        //baik disetiap rekursifnya
        if (root.nama == Parent) return root;

        //berikut merupakan syntax yang digunakan sebagai pemanggilan fungsi rekursifnya, yang dimana nilai balikannya disimpan pada 
        //variabel bantuan tmp yang tipenya node
        node tmp = search(root.left, Parent);

        //berikut merupakan kondisi untuk mengecek nilai dari tmp apakah tidak sama dengan null, jika iya maka artinya dia menunjuk
        //node selanjutnya yang tidak kosong atau memiliki nilai data nama orang
        if (tmp != null) return tmp;
        //berikut merupakan kondisi terakhir jika if atau else if yang diatasnya tidak terpenuhi, makan otomatis langsung masuk
        //kedalam kondisi else ini tanpa pengecekan dan pada else ini berisi rekursif juga yang nantinya mengembalikan nilai dari
        //method ini juga
        else return search(root.right, Parent);
    }

    //berikut merupakan method yang digunakan  untuk mencari hubungan keluarga antara dua orang, yang dimana method ini bertipe data void
    //maka method ini tidak perlu mengembalikan nilai yang masuk dan diolah pada method ini
    void cariHubungan (String nama1, String nama2){
        String tmp = null, tmp2 = null;
        int value1 = cekTingkat(root, nama1, 0);
        int value2 = cekTingkat(root, nama2, 0);
        int selisih = value1-value2;

        //berikut merupakan switch case yang digunakan untuk mengecek tingkatan dari seseorang yang ingin dicari tingkatannya dalam
        //silsilah, yang mana tingkatan ini akan mempermudah kita menentukan hubungan antara dua orang yang akan dicari hubungan 
        //keluarganya
        switch (selisih){
            //berikut merupakan case pertama yaitu jika si nilai selisih yang menjadi case dari switch nya bernilai 0, maka
            //artinya dua orang yang akan dicari hubungan keluarganya merupakan saudara atau saudara jauh tergantung dari
            //parent mereka berdua
            case 0:
                tmp = findParent(root, nama1, null);
                tmp2 = findParent(root, nama2, null);
                if (tmp.equalsIgnoreCase(tmp2)){
                    System.out.printf("%s adalah saudara dari %s\n", nama1, nama2);
                } else {
                    System.out.printf("%s adalah saudara jauh dari %s\n", nama1, nama2);
                }
                break;
            //berikut merupakan case kedua yaitu jika si nilai selisih yang menjadi case dari switch nya bernilai 1, maka
            //artinya dua orang yang akan dicari hubungan keluarganya merupakan ortu-anak atau paman/bibi-keponakan/keponakan jauh 
            //tergantung dari parent mereka berdua
            case 1:
                if (findParent(root, nama1, " ").equalsIgnoreCase(nama2)){
                    System.out.printf("%s adalah anak %s\n", nama1, nama2);
                } else {
                    tmp = findParent(root, nama1, null);
                    tmp = findParent(root, tmp, null);
                    if (tmp.equalsIgnoreCase(findParent(root, nama2, null))){
                        System.out.printf("%s adalah keponakan dari %s\n", nama1, nama2);
                    } else {
                        System.out.printf("%s adalah keponakan jauh dari %s\n", nama1, nama2);
                    }
                }
                break;
            //berikut merupakan case ketiga yaitu jika si nilai selisih yang menjadi case dari switch nya bernilai 2, maka
            //artinya dua orang yang akan dicari hubungan keluarganya merupakan kakek/nenek-cucu/cucu jauh tergantung dari
            //parent mereka berdua
            case 2:
                tmp = findParent(root, nama1, null);
                tmp = findParent(root, tmp, null);
                if (tmp.equalsIgnoreCase(nama2)){
                    System.out.printf("%s adalah cucu dari %s\n", nama1, nama2);
                } else {
                    System.out.printf("%s adalah cucu jauh dari %s\n", nama1, nama2);
                }
                break;
            //berikut merupakan case keempat yaitu jika si nilai selisih yang menjadi case dari switch nya bernilai 3, maka
            //artinya dua orang yang akan dicari hubungan keluarganya merupakan buyut-cicit
            case 3:
                System.out.printf("%s adalah cicit dari %s\n", nama1, nama2);
                break;
            //berikut merupakan case kelima yaitu jika si nilai selisih yang menjadi case dari switch nya bernilai -1, maka
            //artinya dua orang yang akan dicari hubungan keluarganya merupakan ortu-anak atau paman/bibi-keponakan/keponakan jauh 
            //tergantung dari parent mereka berdua
            case -1:
                if (findParent(root, nama2, " ").equalsIgnoreCase(nama1)){
                    System.out.printf("%s adalah anak %s\n", nama2, nama1);
                } else {
                    tmp = findParent(root, nama2, null);
                    tmp = findParent(root, tmp, null);
                    if (tmp.equalsIgnoreCase(findParent(root, nama1, null))){
                        System.out.printf("%s adalah keponakan dari %s\n", nama2, nama1);
                    } else {
                        System.out.printf("%s adalah keponakan jauh dari %s\n", nama2, nama1);
                    }
                }
                break;
            //berikut merupakan case keenam yaitu jika si nilai selisih yang menjadi case dari switch nya bernilai -2, maka
            //artinya dua orang yang akan dicari hubungan keluarganya merupakan kakek/nenek-cucu/cucu jauh tergantung dari
            //parent mereka berdua
            case -2:
                tmp = findParent(root, nama2, null);
                tmp = findParent(root, tmp, null);
                if (tmp.equalsIgnoreCase(nama1)){
                    System.out.printf("%s adalah cucu dari %s\n", nama2, nama1);
                } else {
                    System.out.printf("%s adalah cucu jauh dari %s\n", nama2, nama1);
                }
                break;
            //berikut merupakan case ketujuh yaitu jika si nilai selisih yang menjadi case dari switch nya bernilai -3, maka
            //artinya dua orang yang akan dicari hubungan keluarganya merupakan buyut-cicit
            case -3:
                System.out.printf("%s adalah cicit dari %s\n", nama2, nama1);
                break;
            //berikut merupakan case default atau case yang menjadi kondisi jika semua case yang lain tidak terpenuhi maka akan
            //masuk ke case default ini
            default:
                System.out.printf("%s dan %s tidak memiliki garis keturunan", nama1, nama2);
                break;
        }
    }

    //berikut merupakan method yang digunakan untuk mencari tingkatan antara dua buah orang yang akan dicari silsilah keluarganya
    //dimana method ini bertipe data int yang artinya method ini akan mengembalikan nilai yang bertipe int juga
    int cekTingkat (node node, String data, int level){
        //berikut merupakan kondisi pengecekan nilai dari node apakah null atau tidak, jika null maka akan mengembalikan nilai
        //nol kepada yang memanggil method ini
        if (node == null) return 0;
 
        //berikut ini merupakan kondisi pengecekan nilai dari nama node apakah sama dengan data, jika iya maka method ini akan
        //mengembalikan nilai dari level yang merupakan integer
        if (node.nama == data) return level;
 
        //berikut merupakan syntax rekursif yang digunakan pada method ini yang nilai balikannya disimpan ke dalam 
        //variabel bantuan downlevel yang bertipe integer
        int downlevel = cekTingkat (node.left, data, level + 1);
        //berikut merupakan pengecekan nilai dari downlevel apakah tidak sama dengan nol, jika iya maka akan mengembalikan nilai
        //downlevel ini
        if (downlevel != 0) return downlevel;
        //berikut merupakan kondisi terakhir jika if atau else if yang diatasnya tidak terpenuhi, makan otomatis langsung masuk
        //kedalam kondisi else ini tanpa pengecekan dan pada else ini berisi rekursif juga yang nantinya mengembalikan nilai dari
        //downlevel yang digunakan menyimpan nilai balikan dari rekursif yang dipanggil
        else{
            downlevel = cekTingkat (node.right, data, level + 1);
            return downlevel;
        }
    }

    //berikut merupakan method yang digunakan untuk mencari parent dari nama yang ingin dicari parentnya,
    //yang dimana method ini bertipe data string, maka method ini akan memiliki balikan nilai sebuah string juga 
    String findParent (node node, String val, String parent){
        //berikut merupakan kondisi pengecekan jika node yang masuk dari parameter adalah null, jika iya maka dari rekursif yang
        //ada akan kembali dengan nilai null
        if (node == null) return null;
        //berikut merupakan kondisi untuk mengecek nilai nama dari node apakah sama dengan nama val yang masuk ke method ini
        //baik disetiap rekursifnya
        if (node.nama == val) return parent;
        
        //berikut merupakan syntax yang digunakan sebagai pemanggilan fungsi rekursifnya, yang dimana nilai balikannya disimpan pada 
        //variabel bantuan tmp yang tipenya string
        String tmp = findParent(node.left, val, node.nama);

        //berikut merupakan kondisi untuk mengecek nilai dari tmp apakah tidak sama dengan null, jika iya maka method ini akan mengembalikan
        //nilai dari tmp dari
        if (tmp != null) return tmp;
        //berikut merupakan kondisi terakhir jika if atau else if yang diatasnya tidak terpenuhi, makan otomatis langsung masuk
        //kedalam kondisi else ini tanpa pengecekan dan pada else ini berisi rekursif juga yang nantinya mengembalikan nilai dari
        //method ini juga
        else return findParent(node.right, val, node.nama);
    }
}