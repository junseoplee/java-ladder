package laddergame.model;

import java.util.Random;

public class RungCreateDecider {

  private static final int MAX_RANDOM_RANGE = 2;
  private static final Random random = new Random();

  public boolean decide() {
    int number = random.nextInt(MAX_RANDOM_RANGE);
    return number >= MAX_RANDOM_RANGE / 2;
  }
}
