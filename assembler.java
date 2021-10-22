/**
 * Di Luo, Xavier Markowitz
 * CS 321
 * Project 2
 * assembler.java
 */

import java.io.*;
import java.util.ArrayList;

public class assembler{
    // fields
    private LinkedStack<String> stack;
    private ArrayList<String> as;
    private Postfix pf;
    private int index;

    // constructor
    public assembler(){
        this.stack = new LinkedStack<String>();
        this.as = new ArrayList<String>();
        this.pf = new Postfix();
        this.index = 1;
    }

    // transforms operand1 left, operand2 right and operator t into the assembly string and return
    public String[] evaluate(String left, String t, String right){
        String load = "   LD    " + left + "\n";
        
        String operator = "";
        // can use dictionary to replace if/else statements below
        if (t.equals("+")){
            operator = "AD";
        }
        else if (t.equals("-")){
            operator = "SB";
        }
        else if (t.equals("*")){
            operator = "ML";
        }
        else if (t.equals("/")){
            operator = "DV";
        }
        else{
            System.out.println("assembler.evaluate(): Prameter t is not an operator!");
        }
        String operation = "   " + operator + "    " + right + "\n";

        String TMP_Var = "TMP" + index;
        String store = "   ST    " + TMP_Var + "\n";
        index++;

        String assembly = load + operation + store;

        String[] r = new String[2];
        r[0] = TMP_Var;
        r[1] = assembly;
        return r;
    }

    public void assembly(Postfix p){
        for (int i = 0; i < p.getExpr().size(); i++){
            String temp_assembly = new String();
            String[] words = p.getExpr().get(i).split(" ");
            int j = 0;
            while (j < words.length){
                String t = words[j];
                if (!t.equals("+") && !t.equals("-") && !t.equals("*") && !t.equals("/")){
                    this.stack.push(t);
                }
                else{
                    String right = this.stack.pop();
                    String left = this.stack.pop();
                    String[] temp = evaluate(left, t, right);
                    this.stack.push(temp[0]);
                    temp_assembly += temp[1];
                }
                j++;
            }
            this.as.add(temp_assembly);
            index = 1;
        }
    }

    // writes the assembly stored in ArrayList as to a file
    public void writeFile( String filename ){
        try {
            FileWriter a = new FileWriter(filename);
            for (int i=0; i<this.as.size(); i++){
                a.write("Infix Expression: " + this.pf.getInfix().get(i).replace(";","") + "\n");
                a.write("Postfix Expression: " + this.pf.getExpr().get(i) + "\n\n");
                a.write(this.as.get(i) + "\n\n");
            }
            as.clear();
            a.close();
        } 
        catch(IOException ex) {
            System.out.println("assembler.writeFile():: error writing file " + filename);
        }
    }

    public static void main(String[] args){
        if (args.length<1){
            System.out.println("Please input the filename of infix expressions.");
        }

        assembler a = new assembler();

        a.pf.readFile(args[0]);
        a.assembly(a.pf);
        if (args.length < 2){
            for (int i=0; i<a.as.size(); i++){
                System.out.println("Infix Expression: " + a.pf.getInfix().get(i).replace(";",""));
                System.out.println("Postfix Expression: " + a.pf.getExpr().get(i) + "\n");
                System.out.println(a.as.get(i)+"\n");
            }
        }
        else{
            a.writeFile(args[1]);
        }
        
    }
}