// -----------------------------------------------------
// Assignment 3
// Question: CellList and CellNode classes with the needed methods
// Written by: Omar Chabti 40262497
// -----------------------------------------------------
import java.util.NoSuchElementException;

public class CellList {
    //This is the CellList class with the necessary methods to add, remove and replace nodes amongst other things
    public class CellNode{
        //this is the inner class for the nodes with its setters and getters
        CellPhone c;
        CellNode next;

        public CellNode() {
            c = null;
            next = null;
            size++;
        }

        public CellNode(CellPhone c, CellList.CellNode next) {
            this.c = c;
            this.next = next;
            size++;
        }

        public CellNode(CellNode cn){
            this.c = cn.c.clone();
            next = cn.next;
            size++;
        }

        public CellPhone getC() {
            return c;
        }
        
        public CellNode getNext() {
            return next;
        }

        public void setC(CellPhone c) {
            this.c = c;
        }

        public void setNext(CellNode next) {
            this.next = next;
        }     
        
    }

    private CellNode head;
    private int size;
    
    public CellNode getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

     public void setHead(CellNode head) {
        this.head = head;
    }


    public CellList() {
        this.head = null;
        this.size = 0;
    }

    public CellList(CellList CL){
        if (CL == null) 
        throw new NullPointerException();
        else 
        head = copyList(CL.head);

    }

    private CellNode copyList(CellNode CL){
        CellNode temp = CL;
        CellNode newHead = new CellNode(temp.c.clone(), null);
        CellNode end = newHead;

        temp = temp.next;

        while (temp!= null){
            end.next = new CellNode(temp.c.clone(), null); 
            end = end.next;
            temp = temp.next;
        }
        return newHead; 
    }

    public void addToStart(CellPhone c){
        head = new CellNode(c,head);
    }

    public void insertAtIndex(CellPhone CP, int index){
       CellNode t = head;

        if (index<0 || index>(size-1)){
            throw new NoSuchElementException();
        }

        if(index == 0){
            addToStart(CP);
        }else{
       
        for (int i = 0; i <= index-2; i++){
            t=t.next;
        }
            t.next = new CellNode(CP, t.next);
        }
    }

    public void deleteFromIndex(int index){
       
        if (index<0 || index>(size-1)){
            throw new NoSuchElementException();
        }
        CellNode t = head;

        if(index ==0){
            deleteFromStart();
            return;
        }

        for (int i = 0; i <= index-2; i++){
            t=t.next;
        }
        t.next= t.next.next;

        size--;
    }

    public void deleteFromStart(){
        if(head == null)
        return;

        head = head.next;
        size--;
    }

    public void replaceAtIndex(CellPhone CP, int index){
        
        if (index<0 || index>(size-1)){
            throw new NoSuchElementException();
        }
        CellNode t = head;

        if(index == 0){
            head = new CellNode(CP, t.next);
            size--;
            return;
        }

        for (int i = 0; i <=  index-2; i++){
            t=t.next;
        }
            t.next= new CellNode(CP, t.next.next);
            size--;

    }
    
    public CellNode find(long sn){ // this method allows a privacy leak because it is a public method that anyone can use that returns the
                                    // adress of the node, which can be used to modify or delete the node or even the entire list.
                                    // one way to get around this is to make the find method private and only use it in cases like inside the
                                    // contains method for example. 
        if(head == null){
            return null;
        }

        CellNode t = head;
        int count=0;
        while(t.next != null &&  t.c.getSerialNum() != sn  ){
            t= t.next;
            count++;
        }

        if (t.c.getSerialNum() == sn){
            System.out.println("Finding serial number " + sn + " took " + count + " iterations");
            return t;
        }else{
            System.out.println("Serial number could not be found in the list.");
        return null;  
        }
       

    }

    public boolean contains(long sn){
        CellNode a = find(sn);
        
        if(a == null){
            return false;
        }else
        return true;
    }

    public void showContents(){
        if(head == null){
            System.out.println("List is empty");
        }

        CellNode t = head;
        int count =0;

        while(count<=size-1){
            System.out.print(t.c.toString()+" ");
            count++;

            if(count%3 == 0){
                System.out.println("");
            }
            t= t.next;
        }
        System.out.print("X");
    }

    public boolean equals(CellList CL){
        if(this.size != CL.size){
            return false;
        }

        CellNode t = this.head;
        CellNode other = CL.head;

        while(t != null){

            if(!t.c.equals(other.c)){
                return false;
            }
            t = t.next;
            other = other.next;
        }

        return true;


    }

    

    
}
