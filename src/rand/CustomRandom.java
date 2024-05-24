package rand;

import java.util.Random;

public class CustomRandom {
  private Random random;

  public CustomRandom() {
    random = new Random();
  }

  // Método para gerar números exponenciais
  public double nextExponential(double mean) {
    return -mean * Math.log(random.nextDouble());
  }

  // Outros métodos personalizados podem ser adicionados aqui
}
