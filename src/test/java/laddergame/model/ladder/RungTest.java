package laddergame.model.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import java.util.stream.Stream;
import laddergame.model.TestRungCreateDecider;
import laddergame.model.participant.Participant;
import laddergame.model.participant.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RungTest {

  @Test
  @DisplayName("왼쪽 포인트에 가로 줄이 없을 때 각 지점마다 가로 줄을 생성하는지 테스트한다.")
  void createRungTest() {
    //given
    List<Participant> participants = Stream.of("apple", "mango", "grape", "pear", "plum")
        .map(Participant::new)
        .toList();
    List<Boolean> test = newArrayList(true, false, false, true);

    //when
    Rung rung = new Rung(new Participants(participants), new TestRungCreateDecider(test));

    //then
    assertThat(rung.getRungPoints()).containsExactly(true, false, false, true);
  }

  @Test
  @DisplayName("왼쪽 포인트에 가로 줄이 있을 때 해당 지점은 가로 줄을 생성하지 않는지 테스트한다.")
  void skipRungCreationWhenLeftHasRung() {
    //given
    List<Participant> participants = Stream.of("apple", "mango", "grape", "pear", "plum")
        .map(Participant::new)
        .toList();
    List<Boolean> test = newArrayList(true, true, false, true);

    //when
    Rung rung = new Rung(new Participants(participants), new TestRungCreateDecider(test));

    //then
    assertThat(rung.getRungPoints()).containsExactly(true, false, false, true);
  }
}
