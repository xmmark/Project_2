/**
 * Di Luo, Xavier Markowitz
 * CS 321
 * Project 2
 * Postfix.java
 */

import java.io.*;
import java.util.ArrayList;

public class Postfix{
    // fields
    private LinkedStack<String> stack;
    private ArrayList<String> expr;

    // constructor
    public Postfix(){
        this.stack = new LinkedStack<String>();
        this.expr = new ArrayList<String>();
    }

    // functions
    // reads the contents of a infix expression file and reconstructs the fields of the WordCount object
    public void readFile( String filename ){
        try {
            FileReader a = new FileReader(filename);
            BufferedReader b = new BufferedReader(a);
            
            while(true){
                String line = b.readLine();
                if (line==null){
                    break;
                }
                String[] words = line.split(" ");
                for (int i=0; !words[i].equals(";"); i++){
                    if (words[i].equals(")")) {
                        String right = this.stack.pop();
                        String oper = this.stack.pop();
                        String left = this.stack.pop();
                        this.stack.push(left+" "+right+" "+oper);
                    }
                    else{
                        if (!words[i].equals("(")){
                            this.stack.push(words[i]);
                        } 
                    }
                }
                this.expr.add(this.stack.pop());
            }
            b.close();
        }
        catch(FileNotFoundException ex) {
          System.out.println("Postfix.readFile():: unable to open file " + filename );
        }
        catch(IOException ex) {
          System.out.println("Postfix.readFile():: error reading file " + filename);
        }
    }

    // writes the postfix expressions stored in expr to a file
    public void writeFile( String filename ){
        try {
            FileWriter a = new FileWriter(filename);
            for (int i=0; i<this.expr.size(); i++){
                a.write(this.expr.get(i)+"\n");
            }
            expr.clear();
            a.close();
        } 
        catch(IOException ex) {
            System.out.println("Postfix.writeFile():: error writing file " + filename);
        }
    }

    // tests reading and writing files
    public static void main(String[] args){
        if (args.length<1){
            System.out.println("Please input the filename.");
        }

        Postfix pf = new Postfix();

        pf.readFile(args[0]);
        if (args.length < 2){
            for (int i=0; i<pf.expr.size(); i++){
                System.out.println(pf.expr.get(i));
            }
        }
        else{
            pf.writeFile(args[1]);
        }
    }
}

