package rand;

public class myMath {

    private CustomRandom customRandom = new CustomRandom();

    // Exemplo de método para a lei de morte
    public double deathRate(double comfort, double mu) {
        return customRandom.nextExponential((1 - Math.log(1 - comfort)) * mu);
    }

    // Exemplo de método para a lei de reprodução
    public double reproductionRate(double comfort, double rho) {
        return customRandom.nextExponential((1 - Math.log(comfort)) * rho);
    }

    // Exemplo de método para a lei de mutação
    public double mutationRate(double comfort, double delta) {
        return customRandom.nextExponential((1 - Math.log(comfort)) * delta);
    }
}
