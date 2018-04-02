public class Bus {

    public int stationIndex;
    public boolean direction;
    public int capacity;
    public Q1 people;

    public Bus(int si, boolean dir, int size) {
        stationIndex = si;
        direction = dir;
        capacity = size;
        people = new Q1();
    }

    public void on(Passenger p) {       //Add passenger to the end of the list
        people.add(p);
    }

    public void off(int index) {        //TODO: Fix this function
        if (people.getFront() != null) {//Remove all Passengers that have an endIndex equal to the index passed
            if (((Passenger) people.getFront().getData()).endIndex == index) {
                people.remove();
            }
            N ph = people.getFront();
            for (int i = 0; i<people.length()-2;i++) {
                if (((Passenger) ph.getNext().getData()).endIndex == index) {
                    ph.setNext(ph.getNext().getNext());
                }
                ph = ph.getNext();
            }
        }
        else{

        }
    }
}