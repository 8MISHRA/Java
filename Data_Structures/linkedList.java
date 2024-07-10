// import java.util.LinkedList;

public class linkedList {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("I'm going to create a linked List");
        System.out.println();
        LinkedList myList = new LinkedList();
        myList.deleteFirst();
        myList.addFirst(4);
        myList.addFirst(1);
        myList.addLast(3);
        myList.addFirst(8);
        myList.addFirst(12);
        myList.addFirst(10);
        myList.addLast(11);
        myList.addLast(45);
        System.out.println();

        myList.show();

        myList.deleteFirst();
        myList.show();

        System.out.println("Size of the list is: "+myList.getSize());

    }
}

class LinkedList{
    Node head;
    int size = 0;

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    void addFirst(int data){
        size ++;
        Node newNode = new Node(data);
        System.out.println("Adding node at first: "+newNode.data);
        if (head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }

    void show(){
        if(head == null){
            System.out.println("List is empty");

        }else{
            Node tempNode = head;
            System.out.println("List is as follows: ");
            while (tempNode != null){
                System.out.print(tempNode.data + " --> ");
                tempNode = tempNode.next;
            }
            System.out.println(tempNode);
            System.out.println();
        }
    }

    int getSize(){
        return size;
    }

    void addLast(int data){
        Node newNode = new Node(data);
        System.out.println("Adding  node at last: "+data);
        if (head == null){
            addFirst(data);
        }else{
            Node tempNode = head;
            while(tempNode.next != null){
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
            
        }
        size ++;
    }

    void deleteFirst(){
        if (head ==null){
            System.out.println("List is empty, can't delete");
        }else{
            head = head.next;
        }
        size --;
    }

    void deleteLast(){
        if(head == null){
            System.out.println("List is empty, can't delete");
        }else{
            if(head.next != null){
                head = head.next;
            }
            else{
                Node curNode = head;
                while(curNode.next.next != null){
                    curNode = curNode.next;
                }
            }
            size --;
        }
    }

    // Implement this code ASAP

    void addPos(int data, int pos){
        if (pos > size) {
            System.out.println("Position is out of range");            
        }else{
            Node newNode = new Node(data);
            System.out.println("Adding  node at last: "+data);
            if (head == null){
                addFirst(data);
            }else{
                Node tempNode = head;
                int count=1;
                while(pos < count){
                    count++;
                    tempNode = tempNode.next;
                }
                tempNode.next = newNode;
                
            }
            size ++;
        }
    }
}