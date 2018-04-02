// Queue implementation using a linked list of nodes (see N.java)
// Posted previously, but used for simulation

//Taken from Moodle herbs070

public class Q1 implements Q {

    // constructor

    public Q1() {
    }

    // selectors

    public void add(Object o) {

        if (size == 0) {
            front = new N(o, null);
            rear = front;
        } else {
            rear.setNext(new N(o, null));
            rear = rear.getNext();
        }
        size++;
    }

    public Object remove() {
        Object answer;
        if (size == 0)
            return null;

        answer = front.getData();
        front = front.getNext();
        size--;
        if (size == 0)
            rear = null;
        return answer;
    }

    public int length() {
        return size;
    }

    public N getFront() {return front;}
    public N getRear() {return rear;}

    public void setFront(N front) {this.front = front;}

    private int size;
    private N front;
    private N rear;

}  // Q1 class

