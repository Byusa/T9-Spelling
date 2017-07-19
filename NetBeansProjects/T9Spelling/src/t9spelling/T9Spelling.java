/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t9spelling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author serge
 */
public class T9Spelling {

    /**
     * @param args the command line arguments
     */
    // each character representation
    public static int charRepresentation(char c) {

        if (c == 'a') {
            return 2;
        }
        if (c == 'b') {
            return 22;
        }
        if (c == 'c') {
            return 222;
        }
        if (c == 'd') {
            return 3;
        }
        if (c == 'e') {
            return 33;
        }
        if (c == 'f') {
            return 333;
        }
        if (c == 'g') {
            return 4;
        }
        if (c == 'h') {
            return 44;
        }
        if (c == 'i') {
            return 444;
        }
        if (c == 'j') {
            return 5;
        }
        if (c == 'k') {
            return 55;
        }
        if (c == 'l') {
            return 555;
        }
        if (c == 'm') {
            return 6;
        }
        if (c == 'n') {
            return 66;
        }
        if (c == 'o') {
            return 666;
        }
        if (c == 'p') {
            return 7;
        }
        if (c == 'q') {
            return 77;
        }
        if (c == 'r') {
            return 777;
        }
        if (c == 's') {
            return 7777;
        }
        if (c == 't') {
            return 8;
        }
        if (c == 'u') {
            return 88;
        }
        if (c == 'v') {
            return 888;
        }
        if (c == 'w') {
            return 9;
        }
        if (c == 'x') {
            return 99;
        }
        if (c == 'y') {
            return 999;
        }
        if (c == 'z') {
            return 9999;
        } else {
            return 0;
        }

    }

    public static void main(String args[]) throws IOException {
        char current;
        int i = 0, j = 1, l = i + 1;
        BufferedReader br = null;
        BufferedWriter bw = null;
        FileInputStream fis = null;
        int k;

        try {
            File in = new File("/home/serge/NetBeansProjects/T9Spelling/src/t9spelling/in.txt");
            File out = new File("/home/serge/NetBeansProjects/T9Spelling/src/t9spelling/out1.txt");
            br = new BufferedReader(new FileReader(in));
            bw = new BufferedWriter(new FileWriter(out));
            fis = new FileInputStream(in);
            String readLine = " ";
            int digit[] = new int[200000];//I have to change the size
            int number[] = new int[200000];//I have to change the size
            String rd = br.readLine();	 //read the first line and turn it into integer
            k = Integer.parseInt(rd);

            // System.out.print("this is K = "+k+"\n");
            if (!in.exists()) {
                System.out.print("The File Do not exist");
            }

            while ((fis.available() > 0)) {
                current = (char) fis.read();
                digit[i] = charRepresentation(current);

                if (i == 0) {//"To not just print 0";
                    String nothing = "To not just print 0";
                } else//getting the number representation of a character till the new line
                 if (current != '\n') {
                        if (i != 1) {

                            //System.out.println("l=" + l + "=" + current + " " + "number[i]" + number[l]);
                            //System.out.println("i=" + i + "=" + current + " " + "digit[i]" + digit[i] + "\n");
                            //System.out.println("l="+l+"="+current+" "+digit[3]);
                            //if the previous is the same as the next one print space( The space character ' ' should be printed to indicate a pause. )
                            if ((number[l] == digit[i]) || (number[l] * 11 == digit[i]) || (number[l] * 111 == digit[i]) || (number[l] * 1111 == digit[i])) {
                                bw.write(" " + digit[i]);
                            } else if ((number[l] == digit[i] * 11) || (number[l] * 11 == digit[i] * 11) || (number[l] * 111 == digit[i] * 11) || (number[l] * 1111 == digit[i] * 11)) {
                                bw.write(" " + digit[i]);
                            } else if ((number[l] == digit[i] * 111) || (number[l] * 11 == digit[i] * 111) || (number[l] * 111 == digit[i] * 111) || (number[l] * 1111 == digit[i] * 111)) {
                                bw.write(" " + digit[i]);
                            } else if ((number[l] == digit[i] * 1111) || (number[l] * 11 == digit[i] * 1111) || (number[l] * 111 == digit[i] * 1111) || (number[l] * 1111 == digit[i] * 1111)) {
                                bw.write(" " + digit[i]);
                            } //} //if the character is space put 0 too else put the number representation
                            else if (current == ' ') {//the other part does nothing
                                digit[i] = 0;
                                //System.out.println("i="+i);
                                bw.write("" + digit[i]);
                                //System.out.print(digit[i]);
                            } else {
                                bw.write("" + digit[i]);
                                //System.out.print(""+digit[i]);						
                            }
                        } //if it is at the end of the line (the ascii value of new line is 10)
                    } else {
                        if (j == 1) {
                            bw.write("Case #" + j + ": ");
                        } else if (j < k + 1) {//for not printing th extra j
                            bw.write("\nCase #" + j + ": ");
                        }
                        j++;
                    }

                i++;
                l++;
                number[l] = charRepresentation(current);

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print(e);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }
}
