package laddergame.model.prize;

import laddergame.model.ErrorMessage;

public class Prize {

  private final String prize;

  public Prize(String inputPrize) {
    validatePrizeNameBlank(inputPrize);
    this.prize = inputPrize;
  }

  private void validatePrizeNameBlank(String inputPrize) {
    if (inputPrize.isBlank()) {
      throw new IllegalArgumentException(ErrorMessage.CONTAINS_SPACE_PRIZE.getMessage());
    }
  }

  public String getPrize() {
    return prize;
  }
}
