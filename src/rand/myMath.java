package rand;

public class myMath {

    private CustomRandom customRandom = new CustomRandom();

    // Exemplo de método para a lei de morte
    public double deathRate(double confort, double mu) {
        return customRandom.nextExponential((1 - Math.log(1 - confort)) * mu);
    }

    // Exemplo de método para a lei de reprodução
    public double reproductionRate(double confort, double rho) {
        return customRandom.nextExponential((1 - Math.log(confort)) * rho);
    }

    // Exemplo de método para a lei de mutação
    public double mutationRate(double confort, double delta) {
        return customRandom.nextExponential((1 - Math.log(confort)) * delta);
    }
}
