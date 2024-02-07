package laddergame.model.ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import java.util.stream.Stream;
import laddergame.model.LadderGenerator;
import laddergame.model.RungCreateDecider.RungCreateDecider;
import laddergame.model.TestRungCreateDecider;
import laddergame.model.participant.Participant;
import laddergame.model.participant.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

  @Test
  @DisplayName("사다리_게임_결과_계산_테스트")
  void 사다리_게임_결과_계산_테스트() {
    // given
    Participants participants = new Participants(
        Stream.of("apple", "mango", "grape")
              .map(Participant::new)
              .toList()
    );
    Height height = new Height(2);
    List<Boolean> test = newArrayList(true, false, false, true);
    RungCreateDecider RungCreateDecider = new TestRungCreateDecider(test);
    LadderGenerator ladderGenerator = new LadderGenerator();

    // when
    Ladder ladder = ladderGenerator.generateLadder(participants, height, RungCreateDecider);

    //then
    assertThat(ladder.findExit(0)).isEqualTo(2);
    assertThat(ladder.findExit(1)).isEqualTo(0);
    assertThat(ladder.findExit(2)).isEqualTo(1);
  }
}
