package Modul_2.Respon;

import java.util.ArrayList;

public class Perpustakaan {
    Node head, tail, current;

    void insert (Buku data){
        if (head == null){
            head = tail = new Node(data);
        } else{
            current = head;

            while (current != null){
                current = current.next;
            }
            Node tmp = new Node(data);
            tail.next = tmp;
            tail = tmp;
        }
    }

    void showAllbook (){
        boolean cekTukar = true;
        current = head;

        while (cekTukar){
            current = head;
            cekTukar = false;
            while (current != tail){
                String tmp1 = current.data.judul;
                String tmp2 = current.next.data.judul;
                if (tmp1.compareTo(tmp2) > 0){
                    Buku tmp = current.data;
                    current.data = current.next.data;
                    current.next.data = tmp;
                    cekTukar = true;
                }
                current = current.next;
            }
        }
        print();
    }

    void findBook (String find){
        ArrayList<String> partial = new ArrayList<String>();
        ArrayList<Buku> findbookList = new ArrayList<Buku>();
        boolean cekAda = false;
        current = head;
        
        System.out.println("Hasil yang mungkin : ");
        while (current != null){
            
            String word = current.data.judul;
            String tmpword = "";
            int size = current.data.judul.length();
            
            for (int a = 0; a < size; ++a){
                Character tmp = word.charAt(a);
                if (tmp == ' ' || a == (size-1)){
                    if (a == (size-1)){
                        tmpword = tmpword + tmp;
                    }
                    partial.add(tmpword);
                    tmpword = "";
                    continue;
                }
                tmpword = tmpword + tmp;
            }

            for (int b = 0; b < partial.size(); ++b){
                String checkEqual = partial.get(b);
                if (checkEqual.equalsIgnoreCase(find)){
                    findbookList.add(current.data);
                    cekAda = true;
                }
            }
            partial.clear();
            current = current.next;
        }
        
        if (!cekAda){
            System.out.printf("\nTidak ada Hasil untuk Keyword '%s'\n", find);
        } else {
            printFindBook(findbookList);
        }
    }

    void printFindBook (ArrayList<Buku> findbookList){
        System.out.println("=========================================================================================");
        System.out.printf("|%-12s|%-40s|%-25s|%-7s|\n", "Book Code", "Book Tittle", "Writer", "Stok");
        System.out.println("=========================================================================================");
        int i = 0;
        while (i < findbookList.size()){
            System.out.printf("|%-12s|%-40s|%-25s|%-7d|\n", findbookList.get(i).kode, findbookList.get(i).judul, 
            findbookList.get(i).pengarang, findbookList.get(i).stok);
            i++;
        }
        System.out.println("=========================================================================================");
    }

    void print (){
        current = head;

        System.out.println("=========================================================================================");
        System.out.printf("|%-12s|%-40s|%-25s|%-7s|\n", "Book Code", "Book Tittle", "Writer", "Stok");
        System.out.println("=========================================================================================");
        while (current != null){
            System.out.printf("|%-12s|%-40s|%-25s|%-7d|\n", current.data.kode, current.data.judul, 
            current.data.pengarang, current.data.stok);
            current = current.next;
        }
        System.out.println("=========================================================================================");
    }
}
