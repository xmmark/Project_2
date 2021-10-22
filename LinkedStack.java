/**
 * Di Luo, Xavier Markowitz
 * CS 321
 * Project 2
 * LinkedStack.java
 */

public class LinkedStack<T>{  

    // child class Node
    public class Node<T>{
        // fields
        public T data;
        public Node<T> next;
        
        // constructor
        public Node(T value){
            this.data = value;
            this.next = null;
        }
    }

    // fields
    private Node<T> head;
    private int size = 0;

    // inserts data on the top of stack
    public void push(T data){
        if(size == 0){
            Node<T> newNode = new Node<T>(data);
            head = newNode;
            size++;
        }else{
            Node<T> newNode = new Node<T>(data);
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    // helper empty function for pop()
    public boolean empty(){

        return size == 0;
    }

    // pops value on the top of stack
    public T pop(){
        if(empty()){
            return null;
        }else{
            T popped = head.data;
            head = head.next;
            size--;
            return popped;
        }
    }

    // tests the functionalities of the stack
    public static void main(String[] args){
        LinkedStack<String> stringStack = new LinkedStack<>();
        //LinkedStack<String>.Node<String> stringNode = new LinkedStack<String>.Node<String>();
        System.out.println("Testing string stack:");
        System.out.println(stringStack.empty());
        System.out.println(stringStack.pop());
        stringStack.push("A");
        stringStack.push("B");
        System.out.println(stringStack.head.data);
        System.out.println(stringStack.head.next.data);
        System.out.println(stringStack.pop());
        System.out.println(stringStack.head.data);
        System.out.println(stringStack.head.next);

        LinkedStack<Integer> intStack = new LinkedStack<>();
        //LinkedStack<String>.Node<String> stringNode = new LinkedStack<String>.Node<String>();
        System.out.println("Testing int stack:");
        System.out.println(intStack.empty());
        System.out.println(intStack.pop());
        intStack.push(1);
        intStack.push(2);
        System.out.println(intStack.head.data);
        System.out.println(intStack.head.next.data);
        System.out.println(intStack.pop());
    }

}