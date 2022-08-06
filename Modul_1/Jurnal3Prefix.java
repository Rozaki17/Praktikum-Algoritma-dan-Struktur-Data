package Modul_1;

/*
Syntax berikut merupakan syntax yang digunakan untuk mengimport atau memasukkan library scanner kedalam
program kita sehingga kita bisa memasukkan data secara dinamis
*/
import java.util.Scanner;
/*
Class untuk membuat node, yaitu elemen yang ada dalam sebuah linked list yang berisi data dengan tipe data char, 
pointer yang menunjuk/mengarahkan kepada node selanjutnya dan juga sebelumnya dan terdapat sebuah konstraktor yang berguna
sebagai pengisi dari data pada node, yang prinsip kerjanya setiap kali membuat objek node maka data akan dimasukkan ke dalam
konstraktor sehingga data baru bisa terisi kedalam node.
*/
class Nodes {
	 /* 
    string data adalah data pada node yang bertipe string, yang berfungsi untuk menyimpan data yang berupa kata atau
    kalimat
    */
    char data;
	/*
    Node next adalah penunjuk yang berguna menunjuk kepada node selanjutnya dari posisi saat ini
    */
    Nodes next;
	 /*
    Method in merupakan konstraktor dari class Node ini, yang berguna mengisi data baru setelah membuat objek Node kedalam variabel
    data dari Node itu sendiri
    */
    Nodes(char Data){
        data = Data;
    }
}
/*
class berikut digunakan untuk membuat stack untuk menyelesaikan persoalan notasi infix yang akan diubah kedalam
bentuk notasi prefix
*/
class StackPrefix {
	/*
    Node head adalah penunjuk yang berguna menandai data pertama atau teratas dari linked list yang dibuat dan current adalah 
    penunjuk bantuan yang berguna untuk mengakses semua node yang ada pada linked list yang dibuat secara satu persatu
    */
    Nodes head, current;
	/*
	method berikut digunakan untuk mengevaluasi nilai char yang dibawa kedalam method lalu menembalikan nilai nya kepada
	class/method/dll yang memanggil method ini
	*/
    static boolean isOperand (char c){
        return (!(c >= 'A' && c <= 'Z'));
    }
	/*
	method ini merupakan method yang digunakan untuk mengevaluasi nilai dari char yang dimasukan kedalam method ini
	lalu mengembalikan nilai int sebagai bentuk feedback dari method ini setelah dipanggi oleh si pemanggil method
	*/
    int getPriority(char C){
        if (C == '-' || C == '+')
            return 1;
        else if (C == '*' || C == '/')
            return 2;
        return 0;
    }
	/*
	method berikut digunakan untuk mengevaluasi nilai char yang dibawa kedalam method lalu menembalikan nilai nya kepada
	class/method/dll yang memanggil method ini
	*/
    static boolean isOperator (char c){
        return (!(c >= 'A' && c <= 'Z'));
    }
	/*
    Method ini merupakan method yang digunakan untuk memasukkan data kedalam linked list yang dibuat
    */
    void push (char data){
		/*
        Akan dicek apakah head kosong atau tidak, jika kosong maka data baru yang masuk akan menjadi head itu sendiri
        */
        if (head == null){
            head = new Nodes(data);
		/*
        Jika tidak maka, akan dibuat objek baru yang diisi dengan data baru tadi lalu akan dihubungkan dengan node lain 
        yang sudah ada pada linked list yang dibuat sebelumnya dan memindahkan head dari linked list kepada node baru
        yang ada
        */
        }else {
            Nodes tmp = new Nodes(data);
            tmp.next = head;
            head = tmp;
        }
    }
	/*
    Method in merupakan method yang digunakan untuk mengambil nilai teratas dari linked list yang ada dengan menggunakan
    fungsi return
    */
    char peek (){
        return head.data;
    }
	/*
    Method ini merupakan method yang digunakan untuk menghapus data paling atas atau terbaru dari linked list yang
    sudah dibuat dengan memindahkan head ke node selanjutnya
    */
    void pop (){
        head = head.next;
    }
	/*
    Method ini merupakan method yang digunakan untuk mengecek apakah linked list yang ada kosong atau tidak dengan cukup
    hanya mengecek head nya, jika headnya kosong maka akan direturn true, jika tidak maka direturn false
    */
    boolean empty (){
        if (head == null){
            return true;
        }
        return false;
    }
	/*
	method ini merupakan method utama tempat proses perubahan dari notasi infin ke notasi prefix
	*/
    String Prefix (String notation){
		/*
        Syntax ini merupakan proses membuat objek baru dari class StackPrefix yang diberi nama operator
        yang berguna untuk menyimpan linked list untuk sementara
        */
        StackPrefix operator = new StackPrefix();
		/*
        Syntax ini merupakan proses membuat objek baru dari class SingleLinkedList yang diberi nama operand
        yang berguna untuk menyimpan linked list untuk sementara
        */
        SingleLinkedList operand = new SingleLinkedList();
		/*
		melakukan looping dari i = 0 dimana i < dari ukuran panjang karakter variabel notation dengan menggunakan
		for looping
		*/
        for (int i = 0; i < notation.length(); i++){

		/* 
		jika karakter saat ini adalah buka kurung, maka masukka kedalam linked list sementara yaitu operator
		*/
		if (notation.charAt(i) == '('){
			operator.push(notation.charAt(i));
		}

		/*
		Jika karakter saat ini adalah kurung penutup, maka keluarkan dari kedua linked list dan masukkan hasil di 
		linked list operand hingga kurung pembuka yang cocok tidak ditemukan.
		*/
		else if (notation.charAt(i) == ')'){
			while (!operator.empty() && operator.peek() != '('){

				// operand 1
				String op1 = operand.peek();
				operand.pop();

				// operand 2
				String op2 = operand.peek();
				operand.pop();

				// operator
				char op = operator.peek();
				operator.pop();

				/* 
				Tambah oprand dan operator dari bentuk operator + operand1 + operand2
				*/
				String tmp = op + op2 + op1;
				operand.push(tmp);
			}

			/* 
			hapus buka kurung dari linked list
			*/
			operator.pop();
		}

		/* 
		Jika karakter saat ini adalah operand, masukkan ke linked list operand.
		*/
		else if (!isOperand(notation.charAt(i))){
			operand.push(notation.charAt(i) + "");
		}

		/*
		Jika karakter saat ini adalah operator, maka masukkan ke linked list operator setelah muncul
		operator prioritas tinggi dari linked list operator dan memasukkan menghasilkan linked list operan.
		*/
		else{
			while (!operator.empty() && getPriority(notation.charAt(i)) <= getPriority(operator.peek())){

				String op1 = operand.peek();
				operand.pop();

				String op2 = operand.peek();
				operand.pop();

				char op = operator.peek();
				operator.pop();

				String tmp = op + op2 + op1;
				operand.push(tmp);
			    }
			    operator.push(notation.charAt(i));
		    }
	    }
    /*
	hapus operator dari linked list operator sampai kosong dan operasikan hasil penjumlahan dari setiap linked list operand hapusan.
	*/
	while (!operator.empty()){
		String op1 = operand.peek();
		operand.pop();

		String op2 = operand.peek();
		operand.pop();

		char op = operator.peek();
		operator.pop();

		String tmp = op + op2 + op1;
		operand.push(tmp);
	}
	/*
	Hasil akhir dari notasi prefix ada di linked list operand
	*/
	return operand.peek();
    }
}
/*
Class berikut merupakan class dari file yang ada yang bernama Jurnal3Prefix yang berguna untuk mewadahi class main
*/
public class Jurnal3Prefix {
	/*
    class berikut merupakan class main yang dimana class yang berisi segala sesuatu yang akan dieksekusi oleh
    program ketika program dijalankan        
    */
    public static void main(String[] args) {
		/*
        syntx berikut merupakan syntax yang digunakan untuk deklarasi secanner yang digunakan agar bisa menginput data
        berdasarkan kehendak user  
        */
        Scanner keyScanner = new Scanner(System.in);
		/*
        berikut merupakan deklarasi pembuatan objek class StackPrefix dalam class main ini agar class StackPrefix ini
        method-methodnya dapat digunakan dalam fungsi main ini
        */
        StackPrefix prefix = new StackPrefix();
        /*
        Syntax berikut digunakan untuk menampilkan di console instruksi memasukkan notasi infix yang ingin dicari,
		sehingga user bisa lebih terarah dalam memasukkan data yang dibutuhkan
        */
        System.out.print("Masukkan Notasi Infixnya : ");
        String Notation = keyScanner.next();
		/*
        Syntax berikut digunakan untuk menampilkan di console hasil akhir dari notasi prefix yang dicari
        */
        String Prefix = prefix.Prefix(Notation);
        System.out.print("Notasi Prefixnya : " + Prefix);
		/*
        Syntax berikut digunakan untuk menutup scanner yang telah kita deklarasikan dan gunakan sebelumnya agar tidak
        source leak
        */
        keyScanner.close();
    }
}