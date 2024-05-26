package ep;

import dss.pec.AEvent;

public class Death extends AEvent {
    private Individual individual;

    public Death(double time, Individual individual) {
        super(time);
        this.individual = individual;
    }

    @Override
    public void handleEvent() {
        // Implementar a lógica de morte
    }

    @Override
    public String toString() {
        return "Death Event{time=" + getEventTime() + "}";
    }
}
