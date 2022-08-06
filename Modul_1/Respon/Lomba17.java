package Modul_1.Respon;

class Nod {
    String name;
    int height, power;
    Nod next, prev;

    Nod (String nama, int tinggi, int kuat){
        name = nama;
        height = tinggi;
        power = kuat;
    }
}

class doubleLinkedlist {
    Nod head, tail, current;

    void insertHeight (String nama, int tinggi, int kuat){
        if (head == null){
            head = tail = new Nod(nama, tinggi, kuat);
        }else{
            Nod tmp = new Nod(nama, tinggi, kuat);
            
            if (head.height >= tinggi){
                tmp.next = head;
                head = tmp;
            }else if (tail.height <= tinggi){
                tail.next = tmp;
                tail = tmp;
            }else{
                current = head;

                while(current.height <= tinggi){
                    if (current.next.height >= tinggi){
                        break;
                    }
                    current = current.next;
                }
                tmp.next = current.next;
                current.next = tmp;
            }
        }
    }

    void insertPower (String nama, int tinggi, int kuat){
        if (head == null){
            head = tail = new Nod(nama, tinggi, kuat);
        }else{
            Nod tmp = new Nod(nama, tinggi, kuat);
            
            if (head.power >= kuat){
                tmp.next = head;
                head = tmp;
            }else if (tail.power <= kuat){
                tail.next = tmp;
                tail = tmp;
            }else{
                current = head;

                while(current.power <= kuat){
                    if (current.next.power >= kuat){
                        break;
                    }
                    current = current.next;
                }
                tmp.next = current.next;
                current.next = tmp;
            }
        }
    }

    void deletePlayer (String nama){
        current = head;

        if (head.name == nama){
            head = head.next;
        }else {
            while (current.next.name != nama){
                current = current.next;
            }
            current.next = current.next.next;
            current = current.next;
            current.prev = current.prev;
        }
    }

    void showRound(String based){
        current = head;

        if (based == "Tinggi"){
            while (current != null){
                if (current != head){
                    System.out.print(" <- ");
                }
                System.out.printf("%s (%dcm)", current.name, current.height);
                current = current.next;
            }
        }else if (based == "Power"){
            while (current != null){
                if (current != head){
                    System.out.print(" <- ");
                }
                System.out.printf("%s (%dp)", current.name, current.power);
                current = current.next;
            }
        }
    }
}

public class Lomba17 {
    public static void main(String[] args) {
        doubleLinkedlist dllheight = new doubleLinkedlist();
        doubleLinkedlist dllpower = new doubleLinkedlist();
        Nod oka = new Nod("Oka", 150, 57);
        Nod Dimas = new Nod("Dimas", 154, 42);

        System.out.println("---------------");
        System.out.println("    Ronde 1    ");
        System.out.println("---------------");
        System.out.println("Berdasarkan TInggi Badan :");

        dllheight.insertHeight("Kiki", 158, 35);
        dllheight.insertHeight("Dika", 179, 45);
        dllheight.insertHeight("Kaka", 155, 33);
        dllheight.insertHeight("Anto", 176, 48);
        dllheight.insertHeight("Mukhlis", 180, 50);
        dllheight.insertHeight("Joko", 162, 39);
        dllheight.insertHeight("Faris", 167, 41);
        dllheight.insertHeight("Brian", 185, 20);
        dllheight.showRound("Tinggi");

        System.out.println("\n");

        System.out.println("---------------");
        System.out.println("Ronde 1 Selesai");
        System.out.println("---------------");
        System.out.println("Joko Kram setelah Ronde 1 selesai :");

        dllheight.deletePlayer("Joko");
        dllheight.showRound("Tinggi");

        System.out.println("\n");

        System.out.println("---------------");
        System.out.println("    Ronde 2    ");
        System.out.println("---------------");
        System.out.println("Berdasarkan Kekuatan :");

        System.out.println("Dimas Masuk :");
        dllheight.current = dllheight.head;
        while (dllheight.current != null){
            dllpower.insertPower(dllheight.current.name, dllheight.current.height, dllheight.current.power);
            dllheight.current = dllheight.current.next;
        }
        dllpower.insertPower(Dimas.name, Dimas.height, Dimas.power);
        dllpower.showRound("Power");

        System.out.println("\nBrian Keluar :");
        dllpower.deletePlayer("Brian");
        dllpower.showRound("Power");

        System.out.println("\nOka Masuk :");
        dllpower.insertPower(oka.name, oka.height, oka.power);
        dllpower.showRound("Power");
    }
}
