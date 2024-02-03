package laddergame.model.ladder;

import java.util.List;

public class Ladder {

  private final List<Rung> rungs;

  public Ladder(List<Rung> rungs) {
    this.rungs = rungs;
  }

  public List<Rung> getRungs() {
    return rungs;
  }
}
