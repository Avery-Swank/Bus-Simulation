//PassengerEvent will reschedule itself (using the agenda),
// create a Passenger:
//      decide where they want to start on the route,
//      decide where they want to end on the route,
// place the Passenger in the appropriate queue at the current stop.

//TODO:
//Downtown stops (listed below) are more popular than others, therefore, at these stops passengers
//should arrive 50 percent more frequently than at normal stops. They are also *two* times as likely
//to be a destination for a passenger than another stop.
//
// Of the 10 stops, there are 3 downtown stops (Cedar Street and 5th Street, Minnesota Street and
// 4th Street, and Union Depot), and 7 normal stops (those not listed in the downtown category). If
// we sum the weight (likelihood) of each stop, we get 13 (2 × 3 + 1 × 7). This means each downtown
// stop has a 2/13 chance of being chosen, and each other stop has a 1/13 chance of being chosen

public class PassengerEvent implements Event {

    public int interval;
    public int totalStations;

    public PassengerEvent(int interval) {
        this.interval = interval;
    }

    public int timeInterval(int min, int max) {     //TODO: The time intervals seem to double
        return (int) Math.floor((max - min) * Math.random() + min + 0.5);
    }

    public int[] stationNum(int numStations) {      //TODO: Fix to make 3 stations 2/13 and 7 stations 1/13 (done?)
        int[] coor = new int[2];
        while (coor[0] == coor[1]) {
            coor[0] = (int) Math.floor((numStations + 3) * Math.random() + 0.5);
            coor[1] = (int) Math.floor((numStations + 3) * Math.random() + 0.5);
            for (int i = 0; i < 2; i++) {
                if (coor[i] > 6) {
                    switch (coor[i]) {
                        case 7:
                        case 8:
                            coor[i] = 7;
                            break;
                        case 9:
                        case 10:
                            coor[i] = 8;
                            break;
                        case 11:
                        case 12:
                            coor[i] = 9;
                            break;
                        default:
                            System.out.println("This should never happen");
                    }
                }
            }
        }
        return coor;
    }


    public void run() {
        int[] coor = stationNum(9);
        int time = (int) (BusDriver.agenda.getCurrentTime() + timeInterval(0, interval));
        Passenger p = new Passenger(time, coor[0], coor[1]);    //Create a new passenger
        System.out.println("***" + p);              //Print out the passenger using the toString method
        BusDriver.busStop[p.startIndex].add(p);     //Add the passenger to the station queue
        BusDriver.agenda.add(new PassengerEvent(interval), time);   //Reschedule the event in the agenda queue
    }
}
