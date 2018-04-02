//• University Ave and 27th Street SE
//• Raymond Ave Station
//• University Ave and Fairview Ave
//• University Ave and Snelling Ave
//• University Ave and Lexington Parkway
//• University Ave and Dale Street
//• University Ave and Marion Street
//• Cedar Street and 5th Street**
//• Minnesota Street and 4th Street**
//• Union Depot**
//(**Downdown stops)
public class BusStop {
    private Q1 goingWest;  //Holds the west bound passengers at the bus stop
    private Q1 goingEast;  //Holds the east bound passengers at the bus stop
    private int index;     //Index of this station

    public BusStop(int n) {
        index = n;
        goingWest = new Q1();  // the queue for this Bus Stop's waiting Passengers
        goingEast = new Q1();  // the queue for this Bus stop's waiting Passengers
    }

    public Q1 getQ(boolean dir) {   //Returns the Queue given the direction
        if (dir) {
            return goingWest;
        } else {
            return goingEast;
        }
    }

    public void add(Passenger c) {      //Adds the passenger to the right queue based on their direction
        if (c.direction) {
            goingWest.add(c);
        } else {
            goingEast.add(c);
        }
    }

    public int getQLength(boolean direction) {
        if (direction) {
            return goingWest.length();
        } else {
            return goingEast.length();
        }
    }
}
