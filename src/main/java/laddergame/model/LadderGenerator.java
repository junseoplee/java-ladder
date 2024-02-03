package laddergame.model;

import java.util.ArrayList;
import java.util.List;
import laddergame.model.RungCreateDecider.RungCreateDecider;
import laddergame.model.ladder.Height;
import laddergame.model.ladder.Ladder;
import laddergame.model.ladder.Rung;
import laddergame.model.participant.Participants;

public class LadderGenerator {

  public Ladder generateLadder(Participants participants, Height height, RungCreateDecider rungCreateDecider) {
    List<Rung> rungs = new ArrayList<>();

    for (int index = 0; index < height.getHeight(); index++) {
      rungs.add(new Rung(participants, rungCreateDecider));
    }

    return new Ladder(rungs);
  }
}
