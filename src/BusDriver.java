//Runs the main logic or the simulation
//TODO: Add functionality that will restrict buses from clumping
public class BusDriver {
    static PQ agenda = new PQ();        //Agenda will hold all of the created events
    static BusStop[] busStop;    //busStop will hold all of the BusStops in an array

    public static void main(String args[]) {
        busStop = new BusStop[10];         //10 Bus Stations for this simulation
        for (int i = 0; i < 10; i++) {
            busStop[i] = new BusStop(i);    //Creates all 10 Bus Stations with indexes
        }

        int totalTime = 5000;       //Total time that the simulation will run
        int interval = 2;           //Average passenger arrival time
        int[] largeBuses = {0,60};  //{Number of buses, Size of the bus}
        int[] smallBuses = {1,40};  //{Number of buses, Size of the bus}

        agenda.add(new PassengerEvent(interval), 1);
        for(int i = 0;i<largeBuses[0];i++) {
            agenda.add(new BusEvent(new Bus(0, false, largeBuses[1]), 0), 1);
        }
        for(int i = 0;i<smallBuses[0];i++) {
            agenda.add(new BusEvent(new Bus(0, false, smallBuses[1]), 0), 1);
        }

        while (agenda.getCurrentTime() <= totalTime) {   //Simulation time can be adjusted
            agenda.remove().run();                  //Run the element while removing it
        }
        //Display statistics at the end of the simulation
    }
}
