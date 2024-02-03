package laddergame.view;

import java.util.List;
import laddergame.model.ladder.Ladder;
import laddergame.model.participant.Participant;
import laddergame.model.participant.Participants;

public class OutputView {

  public void printResult(Participants participants, Ladder ladder) {
    System.out.println("\n실행결과\n");
    printParticipantsName(participants.getParticipants().stream()
        .map(Participant::getParticipantName)
        .toList());

    ladder.getRungs().forEach(rung -> printRung(rung.getRungPoints()));
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
}
