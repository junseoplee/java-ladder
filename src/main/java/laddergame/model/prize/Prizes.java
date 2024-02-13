package laddergame.model.prize;

import java.util.ArrayList;
import java.util.List;
import laddergame.model.ErrorMessage;
import laddergame.model.participant.Participants;

public class Prizes {

  private final List<Prize> prizes;

  public Prizes(List<Prize> prizes, Participants participants) {
    validateDuplicate(prizes, participants);
    this.prizes = prizes;
  }

  private void validateDuplicate(List<Prize> prizes, Participants participants) {
    if (participants.getParticipants().size() != prizes.size()) {
      throw new IllegalArgumentException(ErrorMessage.MISMATCH_COUNT.getMessage());
    }
  }

  public Prize getPrize(int position) {
    return prizes.get(position);
  }

  public List<Prize> getPrizes() {
    return new ArrayList<>(prizes);
  }
}
