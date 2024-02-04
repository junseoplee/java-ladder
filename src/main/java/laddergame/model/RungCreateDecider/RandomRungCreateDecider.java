package laddergame.model.RungCreateDecider;

import java.util.Random;

public class RandomRungCreateDecider implements RungCreateDecider {

  private static final int MAX_RANDOM_RANGE = 2;
  private static final Random random = new Random();

  @Override
  public boolean decide () {
      int number = random.nextInt(MAX_RANDOM_RANGE);
      return number == 0;
  }
}
