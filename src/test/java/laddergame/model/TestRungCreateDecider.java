package laddergame.model;

import java.util.List;
import laddergame.model.RungCreateDecider.RungCreateDecider;

public class TestRungCreateDecider implements RungCreateDecider {

  private final List<Boolean> isCreated;

  public TestRungCreateDecider(List<Boolean> isCreated) {
    this.isCreated = isCreated;
  }

  @Override
  public boolean decide() {
    return isCreated.remove(0);
  }
}
