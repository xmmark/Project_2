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

    //public T pop(){

    //}

    public static void main(String[] args){

    LinkedStack<String> stringStack = new LinkedStack<>();
    //LinkedStack<String>.Node<String> stringNode = new LinkedStack<String>.Node<String>();
    System.out.println(stringStack.empty());
    stringStack.push("A");
    stringStack.push("B");
    System.out.println(stringStack.head.data);
    System.out.println(stringStack.head.next.data);
    }

}