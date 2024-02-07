package laddergame.model.prize;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import laddergame.model.participant.Participant;
import laddergame.model.participant.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {

  @Test
  @DisplayName("결과의_수와_참여자의_수가_일치하지_않는_경우_예외_처리한다")
  void 결과의_수와_참여자의_수가_일치하지_않는_경우_예외_처리한다() {
    //given
    Participants participants = new Participants(
        Stream.of("apple", "mango", "grape")
              .map(Participant::new)
              .toList()
    );
    List<Prize> prizes = Stream.of("5000", "꽝")
                               .map(Prize::new)
                               .toList();
    //when
    //then
    assertThatThrownBy(() -> new Prizes(prizes, participants))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
