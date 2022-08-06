package Modul_1;

import java.util.Scanner;
/*
class berikut digunakan untuk membuat linked list untuk menyelesaikan persoalan notasi infix yang akan diubah kedalam
bentuk notasi postfi
*/
class StackPostfix {
    /*
    class berikut digunakan untuk mengecek tingkat prioritas simbol operasi yang ada pada notasi infix yang dimasukkan user
    */
    int Prec (char ch){
        switch (ch){
            case '+':
            case '_':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    String infixtoPostfix(String notation){
        String result = "";

        StackPrefix StackPostfix = new StackPrefix();

        for (int a = 0; a < notation.length(); ++a){
            char c = notation.charAt(a);

            if (Character.isLetterOrDigit(c))
                result += c;
            else if (c == '(')
                StackPostfix.push(c);
            else if (c == ')'){
                while (!StackPostfix.empty() && StackPostfix.peek() != '('){
                    result += StackPostfix.peek();
                    StackPostfix.pop();
                }
                while(!StackPostfix.empty() && StackPostfix.peek() == '('){
                    StackPostfix.pop();
                }
            }else{
                while (!StackPostfix.empty() && Prec(c) <= Prec(StackPostfix.peek())){
                    result += StackPostfix.peek();
                    StackPostfix.pop();
                }
                StackPostfix.push(c);
            }
        }
        while (!StackPostfix.empty()){
            // if (StackPostfix.peek() == '(')
            //     return "Invalid Expression";
                result += StackPostfix.peek();
                StackPostfix.pop();
        }
        return result;
    }
}

public class Jurnal3Postfix {
    public static void main(String[] args) {
        StackPostfix postfix = new StackPostfix();
        Scanner keyScanner = new Scanner(System.in);

        System.out.print("Masukkan Notasi Infixnya : ");
        String Notation = keyScanner.next();

        String Postfix = postfix.infixtoPostfix(Notation);
        System.out.print("Notasi Postfixnya : " + Postfix);

        keyScanner.close();
    }
}