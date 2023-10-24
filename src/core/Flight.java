package core;

import java.time.Instant;

import structures.graph.Colorable;

public class Flight extends Colorable<Flight, Instant> {
    private final String destiny;
    private final int runway;
    private Instant takeoffDateTime;

    public Flight(final String destiny, final int runway, final Instant takeoffDateTime) {
        this.destiny = destiny;
        this.runway = runway;
        this.takeoffDateTime = takeoffDateTime;
    }

    @Override
    public boolean mayConflictWith(final Flight other) {
        return runway == other.runway;
    }

    @Override
    public boolean hasConflictWith(final Flight other) {
        if (mayConflictWith(other)) {
            long difference = Math.abs(takeoffDateTime.toEpochMilli() - other.takeoffDateTime.toEpochMilli())
                    / 60000;
            return difference <= 15;
        }
        return false;
    }

    @Override
    public String identify() {
        // return "Voo nº " + number + " com destino a " + destiny;
        return destiny;
    }

    @Override
    public Instant getColorInfo() {
        return takeoffDateTime;
    }

    @Override
    public void setColorInfo(final Instant info) {
        takeoffDateTime = info;
    }
}
