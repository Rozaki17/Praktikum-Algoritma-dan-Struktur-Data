package Modul_2.Respon;

import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        Perpustakaan perpus = new Perpustakaan();
        Scanner keyScanner = new Scanner(System.in);
        Buku[] book = new Buku[30];
        char exit ='n';
        int choice;
        boolean cek = true;        
        
        book[0] = new Buku("7 Keajaiban Rezeki", "Ippho Santosa", "7KRIS", 10);
        book[1] = new Buku("10 Wasiat Terlarang", "Ippho Santosa", "10WTIS", 7);
        book[2] = new Buku("Filosofi Teras", "", "7KRIS", 10);
        book[3] = new Buku("Harry Potter and The Sorcerer's Stone", "J. K. Rowling", "HPTSSJKR", 15);
        book[4] = new Buku("A Tale of Two Cities", "Charlie Dickens", "ATTCCD", 9);
        book[5] = new Buku("The Lord of The Rings", "J. R. R. Tolkien", "TLTRJRRT", 13);
        book[6] = new Buku("The Hobbit", "J. R. R. Tolkien", "THJRRT", 21);
        book[7] = new Buku("Perahu Kertas", "Maudy Ayunda", "PKMA", 23);
        book[8] = new Buku("Bumi Manusia", "Pramoedya Ananta Toer", "BMPAT", 30);
        book[9] = new Buku("Negeri 5 Menara", "Ahmad Fuadi", "N5MAF", 3);
        book[10] = new Buku("Laskar Pelangi", "Andrea Hirata", "LPAH", 21);
        book[11] = new Buku("Sang Pemimpi", "Andrea Hirata", "SPAH", 15);
        book[12] = new Buku("Tenggelamnya Kapal Van Der Wick", "Hamka", "TKVDWH", 50);
        book[13] = new Buku("Off The Record 3", "Ria SW", "OTRRSW", 13);
        book[14] = new Buku("Rapijali", "Dee Lestari", "RDL", 22);
        book[15] = new Buku("Laut Bercinta", "Leila S. Chudori", "LBLSC", 32);
        book[16] = new Buku("Bukan Buku Nikah", "Ria Ricis", "BBNRR", 11);
        book[17] = new Buku("Pulang-Pergi", "Tere Liye", "PPTL", 29);
        book[18] = new Buku("Wingit", "Sara Wijayanto", "WSW", 5);
        book[19] = new Buku("Selamat TInggal", "Tere Liye", "STTL", 32);
        book[20] = new Buku("The Star and I", "Ilana Tan", "TSIIT", 18);
        book[21] = new Buku("Lumpu", "Tere Liye", "LTL", 10);
        book[22] = new Buku("Si Putih", "Tere Liye", "SPTL", 16);
        book[23] = new Buku("Ten Years Challenge", "Mutiarini", "TYCM", 10);
        book[24] = new Buku("Kisah Tanah Jawa", "@kisahtanahjawa", "KTJ@", 14);
        book[25] = new Buku("Taipan : The Winner Takes it All", "William Narmada", "T:TTWTIAWN", 1);
        book[26] = new Buku("5 CM", "Donny Dirgantoro", "5CDD", 3);
        book[27] = new Buku("Ayat-ayat Cinta", "Habiburrahman El-Shirazy", "AACHES", 14);
        book[28] = new Buku("Cinta itu Luka", "Eka Kurniawan", "CILEK", 2);
        book[29] = new Buku("Lelaki Harimau", "Eka Kurniawan", "LHEK", 3);
        for (int a = 0; a < 30; ++a){
            perpus.insert(book[a]);}

        start:
        do {
            System.out.println("===============================================");
            System.out.println("|             Welcome to Library              |");
            System.out.println("===============================================");
            System.out.println("\t1. Find a Book");
            System.out.println("\t2. Show All Book");
            System.out.println("\t3. Send us Feedback");

            System.out.print("\nEnter your choice : ");
            choice = keyScanner.nextInt();

            if (choice == 1){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.print("Please Enter the Keyword : "); 
                String find = keyScanner.nextLine();
                find += keyScanner.nextLine();
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                perpus.findBook(find);

            } else if(choice == 2){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                perpus.showAllbook();

            } else if(choice == 3){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.print("Saran dan Kritik : ");
                String comment = keyScanner.nextLine();
                comment += keyScanner.nextLine();
                if (comment != null){
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("Thanks for Your Feedback");
                }
            }

            System.out.print("\nContinue? (y/n) : ");
            exit = keyScanner.next().charAt(0);
            if (exit == 'y'){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                continue start;
            }else{
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("=============");
                System.out.println("| Thank You |");
                System.out.println("=============\n");
                break;
            }
        }while (cek);

        keyScanner.close();
    }
}
