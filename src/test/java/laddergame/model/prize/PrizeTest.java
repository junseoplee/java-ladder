package laddergame.model.prize;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
  @Test
  @DisplayName("결과에_공백이_포함되면_예외_처리한다")
  void 결과에_공백이_포함되면_예외_처리한다() {
    assertThatThrownBy(() -> new Prize(" "))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("결과가_5글자를_초과하면_예외_처리한다")
  void 결과가_5글자를_초과하면_예외_처리한다() {
    assertThatThrownBy(() -> new Prize("banana"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("결과에_all_이_포함되는_경우_예외_처리한다")
  void 결과에_all_이_포함되는_경우_예외_처리한다() {
    assertThatThrownBy(() -> new Prize("all"))
      .isInstanceOf(IllegalArgumentException.class);
  }
}
