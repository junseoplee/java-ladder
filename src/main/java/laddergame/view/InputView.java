package laddergame.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {

  public List<String> receiveNames() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

    Scanner scanner = new Scanner(System.in);
    String inputNames = scanner.nextLine();

    return Stream.of(inputNames.split(","))
                 .map(String::trim)
                 .toList();
  }

  public int receiveHeight() {
    System.out.println(System.lineSeparator());
    System.out.println("최대 사다리 높이는 몇 개 인가요?");

    Scanner scanner = new Scanner(System.in);

    return Integer.parseInt(scanner.nextLine().trim());
  }

  public List<String> receivePrizes() {
    System.out.println(System.lineSeparator());
    System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

    Scanner scanner = new Scanner(System.in);
    String inputPrizes = scanner.nextLine();

    return Stream.of(inputPrizes.split(","))
                 .map(String::trim)
                 .toList();
  }

  public String receiveTargetParticipant() {
    System.out.println(System.lineSeparator());
    System.out.println(System.lineSeparator());
    System.out.println("결과를 보고 싶은 사람은?");

    Scanner scanner = new Scanner(System.in);

    return scanner.nextLine().trim();
  }
}
