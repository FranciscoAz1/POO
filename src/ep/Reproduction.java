package ep;

import dss.pec.AEvent;

public class Reproduction extends AEvent {
    private Individual individual;

    public Reproduction(double time, Individual individual) {
        super(time);
        this.individual = individual;
    }

    @Override
    public void handleEvent() {
        // Implementar a lógica de reprodução
    }

    @Override
    public String toString() {
        return "Reproduction Event{time=" + getEventTime() + "}";
    }
}

