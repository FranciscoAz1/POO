package ep;

import dss.pec.AEvent;

public class Mutation extends AEvent {
    private Individual individual;

    public Mutation(double time, Individual individual) {
        //super(time);
        this.individual = individual;
    }

    @Override
    public void HandleEvent() {
        // Implementar a lógica de mutação
    }

    @Override
    public String toString() {
        return "Mutation Event{time=" + getActionInstant() + "}";
    }
}
