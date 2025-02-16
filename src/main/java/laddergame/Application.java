package laddergame;

import laddergame.controller.LadderGameController;
import laddergame.model.LadderGenerator;
import laddergame.model.RungCreateDecider;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class Application {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RungCreateDecider rungCreateDecider = new RungCreateDecider();
    LadderGenerator ladderGenerator = new LadderGenerator();

    LadderGameController ladderGameController =
        new LadderGameController(inputView, outputView, rungCreateDecider, ladderGenerator);

    ladderGameController.runLadderGame();
  }
}
