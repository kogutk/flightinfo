package pl.kkogut.flightinfo.models;

import lombok.Getter;
import lombok.Setter;

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

    public Flight(Airline airline, FlightPart arrival, FlightPart departure, FlightNumbers flight, String status, String type, Codeshared codeshared){
        this.airline = airline;
        this.arrival = arrival;
        this.departure = departure;
        this.flight = flight;
        this.status = status;
        this.type = type;
        this.codeshared = codeshared;
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
        private String icaoCode;
        private String name;

        public Airline(String iataCode, String icaoCode, String name){
            this.iataCode = iataCode;
            this.icaoCode = icaoCode;
            this.name = name;
        }
        public Airline(String iataCode, String name){
            this.iataCode = iataCode;
            this.name = name;
            this.icaoCode = null;
        }

        @Override
        public String toString() {
            return String.format("Name: %s, IATA Code: %s\n",name, iataCode );
        }
    }
    @Getter
    @Setter
    public static class FlightPart {
        private String actualRunway;
        private String actualTime;
        private String baggage;
        private String delay;
        private String estimatedRunway;
        private String estimatedTime;
        private String gate;
        private String iataCode;
        private String icaoCode;
        private String scheduledTime;
        private String terminal;

        public FlightPart(String actualRunway, String actualTime, String baggage, String delay, String estimatedRunway, String estimatedTime, String gate, String iataCode, String icaoCode, String scheduledTime, String terminal){
            this.actualRunway = actualRunway;
            this.actualTime = actualTime;
            this.baggage = baggage;
            this.delay = delay;
            this.estimatedRunway = estimatedRunway;
            this.estimatedTime = estimatedTime;
            this.gate = gate;
            this.iataCode = iataCode;
            this.icaoCode = icaoCode;
            this.scheduledTime = scheduledTime;
            this.terminal = terminal;
        }

        @Override
        public String toString() {
            return String.format("actualRunway   : %s,\n" +
                                "actualTime      : %s,\n" +
                                "baggage         : %s,\n" +
                                "delay           : %s,\n" +
                                "estimatedRunway : %s,\n" +
                                "estimatedTime   : %s,\n" +
                                "gate            : %s,\n" +
                                "iataCode        : %s,\n" +
                                "icaoCode        : %s,\n" +
                                "scheduledTime   : %s,\n" +
                                "terminal        : %s,",
                                        actualRunway,
                                        actualTime,
                                        baggage,
                                        delay,
                                        estimatedRunway,
                                        estimatedTime,
                                        gate,
                                        iataCode,
                                        icaoCode,
                                        scheduledTime,
                                        terminal);
        }
    }
    @Getter
    @Setter
    public static class FlightNumbers {
        private String iataNumber;
        private String icaoNumber;
        private String number;

        public FlightNumbers(String iataNumber, String icaoNumber, String number) {
            this.iataNumber = iataNumber;
            this.icaoNumber = icaoNumber;
            this.number = number;
        }

        public FlightNumbers(String iataNumber, String number) {
            this.iataNumber = iataNumber;
            this.number = number;
            this.icaoNumber = null;
        }
        @Override
        public String toString() {
            return String.format("Number: %s, IATA Number: %s, ICOA Number: %s\n",number, iataNumber, icaoNumber );
        }
    }
    public static class Codeshared {
        private Airline airline;
        private FlightNumbers flight;

        public Codeshared(Airline airline, FlightNumbers flight){
            this.airline = airline;
            this.flight = flight;
        }
    }


}