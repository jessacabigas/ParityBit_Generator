/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jessa
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Parity_Generator {

    static ArrayList<Character> codeword;

    public static void main(String[] args) {
        codeword = new ArrayList();
        System.out.println("Enter word: ");
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        Parity_Generator pg = new Parity_Generator();
        pg.toCodeWord(word);
        System.out.println("Parity: 1. Odd 2. Even");
        int choice = scan.nextInt();
        pg.createPB(choice);
        pg.display();
    }

    private void toCodeWord(String word) {
        int m = word.length();
        int r = 0;
        while ((Math.pow(2, r)) < (m + r)) {
            r++;
        }
        for (int i = 0; i < (m + r); i++) {
            codeword.add('-');
        }
        for (int i = 0, two = 1, j = 0; i < codeword.size(); i++) {
            if (i == two - 1) {
                codeword.set(i, '_');
                two *= 2;
            } else {
                codeword.set(i, word.charAt(j));
                if (j >= codeword.size()) {
                    break;
                }
                j++;
            }
        }
        display();
    }

    private void createPB(int par) {
        for (int i = 0; i < codeword.size(); i++) {
            char x = ' ';
            if (codeword.get(i) == '_') {
                int ctr = 0;
                int k = i + 1;
                int tmp = k;
                for (int j = k - 1; j < codeword.size();) {
                    if (tmp != 0) {
                        if (codeword.get(j) == '1') {
                            ctr++;
                        }
                        j++;
                        tmp--;
                    } else {
                        tmp += k;
                        j += k;
                    }
                }
                if (par == 1) {
                    x = ctr % 2 == 0 ? '1' : '0';
                } else {
                    x = ctr % 2 == 0 ? '0' : '1';
                }
                codeword.set(i, x);
            }
        }
    }

    private void display() {
        for (int i = 0; i < codeword.size(); i++) {
            System.out.print(codeword.get(i));
        }
        System.out.println("");
    }
}
