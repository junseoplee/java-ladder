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

  public Participant findParticipant(String selectedParticipant) {
    return participants.stream()
                       .filter(participant -> participant.getParticipantName().equals(selectedParticipant))
                       .findAny()
                       .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.MISMATCH_PARTICIPANT.getMessage()));
  }

  public List<Participant> getParticipants() {
    return new ArrayList<>(participants);
  }

  public int findPosition(Participant participant) {
    return participants.indexOf(participant);
  }
}
