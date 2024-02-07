package laddergame.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import java.util.stream.Stream;
import laddergame.model.RungCreateDecider.RungCreateDecider;
import laddergame.model.ladder.Height;
import laddergame.model.ladder.Ladder;
import laddergame.model.participant.Participant;
import laddergame.model.participant.Participants;
import laddergame.model.prize.Prize;
import laddergame.model.prize.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultCalculatorTest {

  @Test
  @DisplayName("실행_결과가_올바르게_계산되는지_테스트")
  void 실행_결과가_올바르게_계산되는지_테스트() {
    Participants participants = new Participants(
        Stream.of("apple", "mango", "grape")
              .map(Participant::new)
              .toList()
    );
    Height height = new Height(2);
    List<Boolean> test = newArrayList(true, false, false, true);
    RungCreateDecider rungCreateDecider = new TestRungCreateDecider(test);
    LadderGenerator ladderGenerator = new LadderGenerator();
    Ladder ladder = ladderGenerator.generateLadder(participants, height, rungCreateDecider);

    Prizes prizes = new Prizes(Stream.of("꽝", "2000", "3000")
                                     .map(Prize::new)
                                     .toList(), participants);
    /*
    apple mango grape
        |-----|     |
        |     |-----|
    꽝    2000  3000
     */
    ResultCalculator resultCalculator = new ResultCalculator(participants, ladder, prizes);
    assertThat(resultCalculator.getPrizeFor("apple")
                               .getPrize()).isEqualTo("3000");
    assertThat(resultCalculator.getPrizeFor("mango")
                               .getPrize()).isEqualTo("꽝");
    assertThat(resultCalculator.getPrizeFor("grape")
                               .getPrize()).isEqualTo("2000");
  }
}
