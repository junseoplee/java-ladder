package laddergame.model;

public enum ErrorMessage {
  NOT_IN_RANGE_PARTICIPANT_NAME("[ERROR] 참여자의 이름은 5글자 이하여야 합니다."),
  CONTAINS_SPACE_PARTICIPANT_NAME("[ERROR] 참여자의 이름에는 공백이 포함될 수 없습니다."),
  LESS_THAN_TWO_PARTICIPANTS("[ERROR] 참여자는 2명 이상이어야 합니다."),
  DUPLICATE_PARTICIPANTS("[ERROR] 중복된 참여자가 있습니다."),
  NOT_A_NUMBER("[ERROR] 높이는 숫자여야 합니다."),
  NOT_IN_RANGE_HEIGHT("[ERROR] 사다리의 높이는 2 이상이어야 합니다.");

  private final String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
