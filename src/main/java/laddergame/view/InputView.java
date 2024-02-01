package laddergame.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

  public List<String> receiveNames() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

    Scanner scanner = new Scanner(System.in);
    String inputNames = scanner.nextLine();

    List<String> receivedNames = new ArrayList<>(List.of(inputNames.split(",")));
    return receivedNames;
  }

  public int receiveHeight() {
    System.out.println("최대 사다리 높이는 몇 개 인가요?");

    Scanner scanner = new Scanner(System.in);
    int inputHeight = Integer.parseInt(scanner.nextLine().trim());

    return inputHeight;
  }
}
