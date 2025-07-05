import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

public class SeminarVO {
    private String name;
    private int max;
    private StateOfSeminarVO state;
    private List<ParticipantVO> participants;

    public SeminarVO(String name, StateOfSeminarVO state, int max) {
        participants = new ArrayList<>();
        setMax(max);
        setName(name);
        setParticipants(participants);
        setState(state);
    }

    public void addParticipant(ParticipantVO participant) {
        participants.add(participant);
    }
    public void deleteParticipant(ParticipantVO participant) {
        participants.remove(participant);
    }

    public String toString() {
        String text = getName();

        if(participants != null) {
            for(ParticipantVO pati : participants) {
                text += " " + pati.toString();
            }
        }
        return text;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public StateOfSeminarVO getState() {
        return state;
    }

    public void setState(StateOfSeminarVO state) {
        this.state = state;
    }

    public List<ParticipantVO> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantVO> participants) {
        this.participants = participants;
    }
}
