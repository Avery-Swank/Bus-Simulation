public class Passenger {
//    – Time they arrived at the stop
//    – Destination/stop they want to go to
//    – Direction of the stop they want to go to (eastbound or westbound)
    public double arrivalTime;
    public int startIndex;
    public int endIndex;
    public boolean direction;

    public Passenger(double arrTime, int index, int index2) {
        arrivalTime = arrTime;
        startIndex = index;
        endIndex = index2;
        if (index < index2) {
            direction = false;
        } else {
            direction = true;
        }
    }

    public String toString() {
        return ("Passenger:  Arrival time: " + arrivalTime + " StartIndex: " + startIndex + " EndIndex: " + endIndex + " Direction: " + direction);
    }
}
