package laddergame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import java.util.stream.Stream;
import laddergame.model.RungCreateDecider.RungCreateDecider;
import laddergame.model.ladder.Height;
import laddergame.model.ladder.Ladder;
import laddergame.model.participant.Participant;
import laddergame.model.participant.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGeneratorTest {

  @Test
  @DisplayName("사다리를 생성하는지 테스트한다.")
  void createLadder() {
    // given
    Participants participants = new Participants(
        Stream.of("apple", "mango", "grape")
            .map(Participant::new)
            .toList()
    );
    Height height = new Height(2);
    List<Boolean> test = newArrayList(true, false, false, true);
    RungCreateDecider rungCreateDecider = new TestRungCreateDecider(test);
    LadderGenerator ladderGenerator = new LadderGenerator();
    // when
    Ladder ladder = ladderGenerator.generateLadder(participants, height, rungCreateDecider);
    // then
    assertThat(ladder.getRungs().get(0).getRungPoints()).containsExactly(true, false);
    assertThat(ladder.getRungs().get(1).getRungPoints()).containsExactly(false, true);
  }
}
