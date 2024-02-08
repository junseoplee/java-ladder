package laddergame.model.ladder;

import java.util.ArrayList;
import java.util.List;
import laddergame.model.RungCreateDecider.RungCreateDecider;
import laddergame.model.participant.Participants;

public class Rung {

  private static final int FIRST_POINT_INDEX = 0;

  private final List<Boolean> hasRungAtPoints = new ArrayList<>();

  public Rung(Participants participants, RungCreateDecider rungCreateDecider) {
    int pointCount = participants.getParticipants().size() - 1;

    for (int pointIndex = 0; pointIndex < pointCount; pointIndex++) {
      createRungAtPoint(pointIndex, rungCreateDecider.decide());
    }
  }

  private void createRungAtPoint(int pointIndex, boolean decided) {
    boolean isLeftPointHasRung = isLeftPointHasRung(pointIndex);
    hasRungAtPoints.add(!isLeftPointHasRung && decided);
  }

  public boolean isLeftPointHasRung(int pointIndex) {
    return pointIndex != FIRST_POINT_INDEX && hasRungAtPoints.get(pointIndex - 1);
  }

  public List<Boolean> getRungPoints() {
    return List.copyOf(hasRungAtPoints);
  }

  public boolean isCurrentPointHasRung(int point) {
    return hasRungAtPoints.get(point);
  }
}
