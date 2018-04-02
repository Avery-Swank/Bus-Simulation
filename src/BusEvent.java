//A BusEvent is created for every arrival of a bus at a stop.
//When a bus arrives at a stop, the BusEvent causes the bus associated with it to look at its passenger
//list to see if there are passengers that wish to exit the bus. If there are, the bus removes those
//passengers. The BusEvent will then look at passengers at the Stop that want to go the direction
//the bus is going and put as many of them as possible on itself. Finally, the BusEvent will create
//a new BusEvent and schedule it (via the agenda) for the arrival at the next stop at a time in the
//future depending on the number of passengers that got off and got on. If the Bus has reached the
//last stop on either side, it will start going the other direction. For example, if an eastbound bus
//arrives at the Union Depot Stop, it will then leave the Union Depot Stop going westbound
//Order of events:
//Let passengers off
//Take Passengers on
//Reschedule BusEvent using calculated arrival time
public class BusEvent implements Event {
    public Bus bus;

    public BusEvent(Bus b, int stationIndex) {
        bus = b;
        bus.stationIndex = stationIndex;
    }

    public void run() {
        int iLength = bus.people.length();      //Keeps track of the traffic off as the bus is unloaded
        bus.off(bus.stationIndex);
        int fLength = bus.people.length();
        int peopleOn = 0;                       //Keeps track of the people who enter the bus
        while (BusDriver.busStop[bus.stationIndex].getQ(bus.direction).length() != 0 && bus.people.length() < bus.capacity) {
            bus.on((Passenger) BusDriver.busStop[bus.stationIndex].getQ(bus.direction).remove());
            peopleOn++;
        }

        //This turns the bus around if it reached the end. Otherwise moves it to the next station
        int a;
        if (bus.direction) {
            if (bus.stationIndex == 0) {
                bus.direction = false;
                a = 1;
            } else {
                a = -1;
            }
        } else {
            if (bus.stationIndex == 9) {
                bus.direction = true;
                a = -1;
            } else {
                a = 1;
            }
        }
        BusDriver.agenda.add(new BusEvent(bus, bus.stationIndex + a), BusDriver.agenda.getCurrentTime() + (180 + (peopleOn) + (iLength - fLength)));
        System.out.println("BusEvent: " + (BusDriver.agenda.getCurrentTime() + (3 * peopleOn) + (2 * iLength - bus.people.length()) + 180) + " On: " + peopleOn + " Off: " + (iLength - fLength) + " Station: " + bus.stationIndex + " Direction: " + bus.direction);
    }
}
