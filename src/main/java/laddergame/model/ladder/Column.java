package laddergame.model.ladder;

import laddergame.model.ErrorMessage;

public class Column {

  private static final int MIN_HEIGHT = 2;

  private final int column;
  public Column(int receivedColumn) {
    validateColumn(receivedColumn);
    this.column = receivedColumn;
  }

  private void validateColumn(int receivedColumn) {
    if (receivedColumn < MIN_HEIGHT) {
      throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE_COLUMN.getMessage());
    }
  }

  public int getColumn() {
    return column;
  }
}
