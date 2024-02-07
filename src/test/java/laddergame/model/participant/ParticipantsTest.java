package laddergame.model.participant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

  @Test
  @DisplayName("참여자의 이름에 중복이 포함되면 예외 처리한다.")
  void createParticipantsByDuplicatedParticipant() {
    List<Participant> duplicateParticipants = Stream.of("apple", "mango", "grape", "mango")
        .map(Participant::new)
        .toList();

    assertThatThrownBy(() -> new Participants(duplicateParticipants))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("참여자가 두 명 미만일 경우 예외 처리한다.")
  void createParticipantsByLessThanTwoParticipants() {
    List<Participant> oneParticipant = List.of(new Participant("apple"));

    assertThatThrownBy(() -> new Participants(oneParticipant))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("결과를_보고_싶은_사람이_일치하지_않는_경우_예외_처리한다")
  void 결과를_보고_싶은_사람이_일치하지_않는_경우_예외_처리한다() {
    Participants participants = new Participants(
        Stream.of("apple", "mango", "grape")
              .map(Participant::new)
              .toList()
    );
    assertThatThrownBy(() -> participants.findParticipant("peach"))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
