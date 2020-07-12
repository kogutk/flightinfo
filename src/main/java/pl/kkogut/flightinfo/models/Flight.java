package pl.kkogut.flightinfo.models;

import lombok.Getter;
import lombok.Setter;
import pl.kkogut.flightinfo.services.FlightService;

@Getter
@Setter
public class Flight {
    private Airline airline;
    private FlightPart arrival;
    private FlightPart departure;
    private Airport arrAirport;
    private Weather arrWeather;
    private FlightNumbers flight;
    private String status;
    private String type;
    private Codeshared codeshared;
    private String newStatus;

    public Flight(Airline airline, FlightPart arrival, FlightPart departure, FlightNumbers flight, String status, String type, Codeshared codeshared){
        this.airline = airline;
        this.arrival = arrival;
        this.departure = departure;
        this.flight = flight;
        this.status = status;
        this.type = type;
        this.codeshared = codeshared;
        this.newStatus = FlightService.getNewStatus(status, departure.delay);
    }

    @Override
    public String toString() {
        return String.format("Flight: Status: %s, Type: %s\nDetails: \n%s\n"+
                        "Airline:\n%s\n"+
                        "Departure details:\n%s\n"+
                        "Arrival details:\n%s\n",
                        status, type, flight.toString(),
                        airline.toString(),
                        departure.toString(),
                        arrival.toString());
    }
    @Getter
    @Setter
    public static class Airline {
        private String iataCode;
        private String name;

        public Airline(String iataCode, String name){
            this.iataCode = iataCode;
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("Name: %s, IATA Code: %s\n",name, iataCode );
        }
    }
    @Getter
    @Setter
    public static class FlightPart {
        private String delay;
        private String gate;
        private String iataCode;
        private String estimatedTime;
        private String scheduledTime;
        private String terminal;

        public FlightPart(String delay, String gate, String iataCode, String estimatedTime, String scheduledTime, String terminal){
            this.delay = delay;
            this.gate = gate;
            this.iataCode = iataCode;
            this.estimatedTime=estimatedTime;
            this.scheduledTime = scheduledTime;
            this.terminal = terminal;
        }

        @Override
        public String toString() {
            return String.format("delay           : %s,\n" +
                                "gate            : %s,\n" +
                                "iataCode        : %s,\n" +
                                "estimatedTime   : %s,\n" +
                                "scheduledTime   : %s,\n" +
                                "terminal        : %s,",
                                        delay,
                                        gate,
                                        iataCode,
                                        estimatedTime,
                                        scheduledTime,
                                        terminal);
        }
    }
    @Getter
    @Setter
    public static class FlightNumbers {
        private String iataNumber;

        public FlightNumbers(String iataNumber) {
            this.iataNumber = iataNumber;
        }

        @Override
        public String toString() {
            return String.format("IATA Number: %s\n",iataNumber);
        }
    }
    public static class Codeshared {
        private FlightNumbers flight;

        public Codeshared(FlightNumbers flight){
            this.flight = flight;
        }
    }



}