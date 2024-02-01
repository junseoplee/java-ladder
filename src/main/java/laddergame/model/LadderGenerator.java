package laddergame.model;

import java.util.stream.IntStream;
import laddergame.model.ladder.Height;
import laddergame.model.ladder.Ladder;
import laddergame.model.ladder.Rung;
import laddergame.model.ladder.RungCreateDecider;
import laddergame.model.participant.Participants;

public class LadderGenerator {

  private final RungCreateDecider rungCreateDecider;

  public LadderGenerator(RungCreateDecider rungCreateDecider) {
    this.rungCreateDecider = rungCreateDecider;
  }

  public Ladder generateLadder(Participants participants, Height height) {
    return new Ladder(
        IntStream.range(0, height.getHeight())
            .mapToObj(index -> new Rung(participants, rungCreateDecider))
            .toList()
    );
  }
}
