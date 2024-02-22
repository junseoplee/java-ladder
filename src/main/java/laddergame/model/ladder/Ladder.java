package laddergame.model.ladder;

import java.util.List;

public class Ladder {

  private final List<Rung> rungs;

  public Ladder(List<Rung> rungs) {
    this.rungs = rungs;
  }

  public int findExit(int entrance) {
    int position = entrance;
    for (Rung rung : rungs) {
      position = findNextColumn(rung, position);
    }
    return position;
  }

  private int findNextColumn(Rung rung, int position) {
    if (canGoLeft(rung, position)) {
      position--;
      return position;
    }
    if (canGoRight(rung, position)) {
      position++;
      return position;
    }
    return position;
  }

  private boolean canGoLeft(Rung rung, int position) {
    return rung.isLeftPointHasRung(position);
  }

  private boolean canGoRight(Rung rung, int position) {
    if (position == rung.getRungPoints().size()) {
      return false;
    }
    return rung.isCurrentPointHasRung(position);
  }

  public List<Rung> getRungs() {
    return rungs;
  }
}
