package pl.kkogut.flightinfo.models;

import java.time.LocalDateTime;

public class FlightPart {
    private LocalDateTime time;
    private int delay;
    private LocalDateTime estimatedTime;
    private String gate;
    private Airport airport;
    private String scheduledTime;
    private String terminal;
}
