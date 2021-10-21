 public class LinkedStack<T>{  

    public class Node<T>{
        public T data;
        public Node<T> next;
        
        public Node(T value){
            this.data = value;
            this.next = null;
        }
    }

    private Node<T> head;
    private int size = 0;

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

    public boolean empty(){

        return size == 0;
    }

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

    public static void main(String[] args){

    LinkedStack<String> stringStack = new LinkedStack<>();
    //LinkedStack<String>.Node<String> stringNode = new LinkedStack<String>.Node<String>();
    System.out.println(stringStack.empty());
    System.out.println(stringStack.pop());
    stringStack.push("A");
    stringStack.push("B");
    System.out.println(stringStack.head.data);
    System.out.println(stringStack.head.next.data);
    System.out.println(stringStack.pop());

    LinkedStack<Integer> intStack = new LinkedStack<>();
    //LinkedStack<String>.Node<String> stringNode = new LinkedStack<String>.Node<String>();
    System.out.println(intStack.empty());
    System.out.println(intStack.pop());
    intStack.push(1);
    intStack.push(2);
    System.out.println(intStack.head.data);
    System.out.println(intStack.head.next.data);
    System.out.println(intStack.pop());
    }

}