package laddergame.view;

import java.util.List;
import laddergame.model.ladder.Ladder;
import laddergame.model.participant.Participant;
import laddergame.model.participant.Participants;
import laddergame.model.prize.Prize;
import laddergame.model.prize.Prizes;

public class OutputView {

  public void printLadder(Participants participants, Ladder ladder, Prizes prizes) {
    System.out.println(System.lineSeparator());
    System.out.println("사다리 결과");
    System.out.println(System.lineSeparator());
    printParticipantsName(
        participants.getParticipants()
                    .stream()
                    .map(Participant::getParticipantName)
                    .toList()
    );
    ladder.getRungs().forEach(rung -> printRung(rung.getRungPoints()));
    printPrizes(
        prizes.getPrizes()
              .stream()
              .map(Prize::getPrize)
              .toList()
    );
  }

  public void printResult(Prize prize) {
    System.out.println(System.lineSeparator());
    System.out.println("실행 결과");
    System.out.print(prize.getPrize());
  }

  public void printResult(Participant participant, Prize prize) {
    System.out.println(participant.getParticipantName() + " : " + prize.getPrize());
  }

  public void printResultMessage() {
    System.out.println(System.lineSeparator());
    System.out.println("실행 결과");
  }

  private void printParticipantsName(List<String> participantNames) {
    participantNames.forEach(name -> System.out.printf("%-6s",name));
  }

  private void printRung(List<Boolean> rungPoints) {
    System.out.println();
    System.out.print(LadderStandard.SPACE_BEFORE_LADDER.getElement());
    System.out.print(LadderStandard.HEIGHT.getElement());
    for (boolean point : rungPoints) {
      System.out.print(point ? LadderStandard.RUNG_FULL.getElement() :
          LadderStandard.RUNG_EMPTY.getElement());
      System.out.print(LadderStandard.HEIGHT.getElement());
    }
  }

  private void printPrizes(List<String> prizes) {
    System.out.println();
    prizes.forEach(index -> System.out.printf("%-6s", index));
  }
}
