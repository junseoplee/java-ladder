package laddergame.view;

public enum LadderStandard {
  SPACE_BEFORE_LADDER("    "),
  RUNG_EMPTY("     "),
  RUNG_FULL("-----"),
  HEIGHT("|");
  private final String element;

  LadderStandard(String element) {
    this.element = element;
  }

  public String getElement() {
    return element;
  }
}
