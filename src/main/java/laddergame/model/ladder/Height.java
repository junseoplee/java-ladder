package laddergame.model.ladder;

import laddergame.model.ErrorMessage;

public class Height {

  private static final int MIN_HEIGHT = 2;

  private final int height;
  public Height(int receivedHeight) {
    validateHeight(receivedHeight);
    this.height = receivedHeight;
  }

  private void validateHeight(int receivedHeight) {
    if (receivedHeight < MIN_HEIGHT) {
      throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE_HEIGHT.getMessage());
    }
  }

  public int getHeight() {
    return height;
  }
}
