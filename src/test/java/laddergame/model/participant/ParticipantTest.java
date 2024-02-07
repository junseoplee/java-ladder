package laddergame.model.participant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantTest {
  @Test
  @DisplayName("참여자의 이름이 5글자를 초과하면 예외 처리한다")
  void createParticipantByInvalidLength() {
    assertThatThrownBy(() -> new Participant("banana"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("참여자의 이름에 공백이 포함되면 예외 처리한다.")
  void createParticipantByBlank() {
    assertThatThrownBy(() -> new Participant(" "))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
