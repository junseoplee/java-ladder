package laddergame.model;

import java.util.stream.IntStream;
import laddergame.model.ladder.Height;
import laddergame.model.ladder.Ladder;
import laddergame.model.ladder.Rung;
import laddergame.model.ladder.RungCreateDecider;
import laddergame.model.participant.Participants;

public class LadderGenerator {

  public Ladder generateLadder(Participants participants, Height height, RungCreateDecider rungCreateDecider) {
    return new Ladder(
        IntStream.range(0, height.getHeight())
            .mapToObj(index -> new Rung(participants, rungCreateDecider))
            .toList()
    );
  }
}
