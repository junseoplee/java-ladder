package laddergame.model.participant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import laddergame.model.ErrorMessage;

public class Participants {

  private final List<Participant> participants;

  public Participants(List<Participant> participants) {
    validateParticipants(participants);
    this.participants = new ArrayList<>(participants);
  }

  private void validateParticipants(List<Participant> participants) {
    Set<String> uniqueNames = new HashSet<>();
    if (participants.stream().map(Participant::getParticipantName)
        .anyMatch(name -> !uniqueNames.add(name))) {
      throw new IllegalArgumentException(ErrorMessage.DUPLICATE_PARTICIPANTS.getMessage());
    }

    if (participants.size() < 2) {
      throw new IllegalArgumentException(ErrorMessage.LESS_THAN_TWO_PARTICIPANTS.getMessage());
    }
  }

  public List<Participant> getParticipants() {
    return new ArrayList<>(participants);
  }
}
