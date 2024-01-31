package laddergame.model;

public enum ErrorMessage {
  NOT_IN_RANGE("[ERROR] 참여자의 이름은 5글자 이하여야 합니다."),
  CONTAINS_SPACE("[ERROR] 이름에는 공백이 포함될 수 없습니다.");

  private final String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
