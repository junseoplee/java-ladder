package laddergame.model.ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeightTest {

  @Test
  @DisplayName("사다리의 높이가 2보다 작으면 예외 처리한다.")
  void createColumnByInvalidHeight() {
    assertThatThrownBy(() -> new Height(1))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
