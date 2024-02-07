package laddergame.model;

public enum ErrorMessage {
  NOT_IN_RANGE_PARTICIPANT_NAME("[ERROR] 참여자의 이름은 5글자 이하여야 합니다."),
  CONTAINS_SPACE_PARTICIPANT_NAME("[ERROR] 참여자의 이름에는 공백이 포함될 수 없습니다."),
  CONTAINS_ALL_PARTICIPANT_NAME("[ERROR] 참여자의 이름에는 'all' 이 포함될 수 없습니다."),
  LESS_THAN_TWO_PARTICIPANTS("[ERROR] 참여자는 2명 이상이어야 합니다."),
  DUPLICATE_PARTICIPANTS("[ERROR] 중복된 참여자가 있습니다."),
  NOT_A_NUMBER("[ERROR] 높이는 숫자여야 합니다."),
  NOT_IN_RANGE_HEIGHT("[ERROR] 사다리의 높이는 2 이상이어야 합니다."),
  NOT_IN_RANGE_PRIZE("[ERROR] 결과(상금)의 길이는 5 이하여야 합니다."),
  CONTAINS_SPACE_PRIZE("[ERROR] 결과(상금)에는 공백이 포함될 수 없습니다."),
  CONTAINS_ALL_PRIZE("[ERROR] 결과(상금)에는 'all' 이 포함될 수 없습니다."),
  MISMATCH_COUNT("[ERROR] 참여자의 수와 결과(상금)의 수가 일치해야 합니다."),
  MISMATCH_PARTICIPANT("[ERROR] 결과를 보고 싶은 사람은 참여자 목록에 존재해야 합니다.");

  private final String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
