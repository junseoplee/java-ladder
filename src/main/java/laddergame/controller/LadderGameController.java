package laddergame.controller;

import java.util.List;
import laddergame.model.ErrorMessage;
import laddergame.model.LadderGenerator;
import laddergame.model.ResultCalculator;
import laddergame.model.ladder.Height;
import laddergame.model.ladder.Ladder;
import laddergame.model.RungCreateDecider.RungCreateDecider;
import laddergame.model.participant.Participant;
import laddergame.model.participant.Participants;
import laddergame.model.prize.Prize;
import laddergame.model.prize.Prizes;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {

  private final InputView inputView;
  private final OutputView outputView;
  private final RungCreateDecider rungCreateDecider;
  private final LadderGenerator ladderGenerator;

  public LadderGameController(
      InputView inputView, OutputView outputView,
      RungCreateDecider rungCreateDecider, LadderGenerator ladderGenerator
  ) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.rungCreateDecider = rungCreateDecider;
    this.ladderGenerator = ladderGenerator;
  }

  public void runLadderGame() {
    Participants participants = receiveParticipants();
    Prizes prizes = receivePrizes(participants);
    Height height = receiveHeight();
    Ladder ladder = ladderGenerator.generateLadder(participants, height, rungCreateDecider);

    outputView.printLadder(participants, ladder, prizes);

    ResultCalculator resultCalculator = new ResultCalculator(participants, ladder, prizes);
    showResultsForParticipants(resultCalculator, participants);
  }

  private Participants receiveParticipants() {
    try {
      List<String> receivedNames = inputView.receiveNames();
      return new Participants(
          receivedNames.stream()
                       .map(Participant::new)
                       .toList()
      );
    } catch (IllegalArgumentException exception) {
      System.out.println(exception.getMessage());
      return receiveParticipants();
    }
  }

  private Height receiveHeight() {
    try {
      int receivedColumn = inputView.receiveHeight();
      return new Height(receivedColumn);
    } catch (NumberFormatException exception) {
      System.out.println(ErrorMessage.NOT_A_NUMBER.getMessage());
      return receiveHeight();
    } catch (IllegalArgumentException exception) {
      System.out.println(exception.getMessage());
      return receiveHeight();
    }
  }

  private Prizes receivePrizes(Participants participants) {
    try {
      List<String> receivedPrizes = inputView.receivePrizes();
      return new Prizes(
          receivedPrizes.stream()
                        .map(Prize::new)
                        .toList(), participants
      );
    } catch (IllegalArgumentException exception) {
      System.out.println(exception.getMessage());
      return receivePrizes(participants);
    }
  }

  private void showResultsForParticipants(ResultCalculator resultCalculator, Participants participants) {
    boolean continueShowingResults = true;
    while (continueShowingResults) {
      String targetParticipant = inputView.receiveTargetParticipant();
      if (targetParticipant.equalsIgnoreCase("all")) {
        showResultsForAllParticipants(resultCalculator, participants);
        continueShowingResults = false;
      } else {
        showResultForTargetParticipant(targetParticipant, resultCalculator);
      }
    }
  }

  private void showResultsForAllParticipants(ResultCalculator resultCalculator, Participants participants) {
    outputView.printResultMessage();
    for (Participant participant : participants.getParticipants()) {
      Prize prize = resultCalculator.getPrizeFor(participant.getParticipantName());
      outputView.printResult(participant, prize);
    }
  }


  private void showResultForTargetParticipant(String selectedParticipant, ResultCalculator resultCalculator) {
    Prize prize;
    try {
      prize = resultCalculator.getPrizeFor(selectedParticipant);
      outputView.printResult(prize);
    } catch (IllegalArgumentException exception) {
      System.out.println(exception.getMessage());
    }
  }
}
