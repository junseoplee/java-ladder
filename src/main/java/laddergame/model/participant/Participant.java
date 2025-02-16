package laddergame.model.participant;

import laddergame.model.ErrorMessage;

public class Participant {

  private static final int MAX_NAME_LENGTH = 5;
  private final String participantName;

  public Participant(String inputName) {
    validateParticipantNameBlank(inputName);
    validateParticipantNameLength(inputName);
    this.participantName = inputName;
  }

  private void validateParticipantNameLength(String inputName) {
    if (inputName.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE_PARTICIPANT_NAME.getMessage());
    }
  }

  private void validateParticipantNameBlank(String inputName) {
    if (inputName.isBlank()) {
      throw new IllegalArgumentException(ErrorMessage.CONTAINS_SPACE_PARTICIPANT_NAME.getMessage());
    }
  }

  public String getParticipantName() {
    return participantName;
  }
}
