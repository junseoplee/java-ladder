package laddergame.model;

import java.util.HashMap;
import java.util.Map;
import laddergame.model.ladder.Ladder;
import laddergame.model.participant.Participant;
import laddergame.model.participant.Participants;
import laddergame.model.prize.Prize;
import laddergame.model.prize.Prizes;

public class ResultCalculator {

  private final Participants participants;
  private final Ladder ladder;
  private final Prizes prizes;

  public ResultCalculator(Participants participants, Ladder ladder, Prizes prizes) {
    this.participants = participants;
    this.ladder = ladder;
    this.prizes = prizes;
  }

  public Map<Participant, Prize> getResult() {
    Map<Participant, Prize> result = new HashMap<>();
    participants.getParticipants().forEach(
        participant -> result.put(participant, getPrizeFor(participant.getParticipantName()))
    );
    return result;
  }

  public Prize getPrizeFor(String selectedParticipant) {
    Participant participant = participants.findParticipant(selectedParticipant);
    int positionOfEntrance = participants.findPosition(participant);
    int positionOfExit = ladder.findExit(positionOfEntrance);
    return prizes.getPrize(positionOfExit);
  }
}
