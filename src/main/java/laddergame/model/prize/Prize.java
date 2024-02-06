package laddergame.model.prize;

import laddergame.model.ErrorMessage;

public class Prize {

  private static final int MAX_PRIZE_LENGTH = 5;
  private final String prize;

  public Prize(String inputPrize) {
    validatePrizeBlank(inputPrize);
    validatePrizeLength(inputPrize);
    validatePrizeContains(inputPrize);
    this.prize = inputPrize;
  }

  private void validatePrizeContains(String inputPrize) {
    if (inputPrize.contains("all")) {
      throw new IllegalArgumentException(ErrorMessage.CONTAINS_ALL_PRIZE.getMessage());
    }
  }

  private void validatePrizeLength(String inputPrize) {
    if (inputPrize.length() > MAX_PRIZE_LENGTH) {
      throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE_PRIZE.getMessage());
    }
  }

  private void validatePrizeBlank(String inputPrize) {
    if (inputPrize.isBlank()) {
      throw new IllegalArgumentException(ErrorMessage.CONTAINS_SPACE_PRIZE.getMessage());
    }
  }

  public String getPrize() {
    return prize;
  }
}
