import java.util.*;

public class Booking implements IBooking {

    SeminarVO currentSeminar;

    public Booking()  {}

    public SeminarVO startNewSeminar(String name, int max) {
        currentSeminar = new SeminarVO(name, StateOfSeminarVO.AVAILABLE, max);
        return currentSeminar;
    }

    public void addParticipant(ParticipantVO obj) throws NullPointerException, NoSeminarException, IllegalStateException {
        Objects.requireNonNull(obj,"obj must not be null.");
        if(currentSeminar == null) { throw new NoSeminarException("There is no seminar."); }

        if(currentSeminar.getState() == StateOfSeminarVO.AVAILABLE && currentSeminar.getParticipants().size() < currentSeminar.getMax()) {
            currentSeminar.addParticipant(obj);
            if(currentSeminar.getParticipants().size() == currentSeminar.getMax()) {
                currentSeminar.setState(StateOfSeminarVO.FULL);
            }
        } else if (currentSeminar.getState() == StateOfSeminarVO.FULL) {
            throw new IllegalStateException("The seminar is full.");
        }else if(currentSeminar.getState()== StateOfSeminarVO.FINISHED) {
            throw new IllegalStateException("The seminar is finished.");
        }
    }

    public void deleteParticipant(ParticipantVO obj) throws NullPointerException, NoSeminarException, IllegalStateException {
        Objects.requireNonNull(obj,"obj must not be null.");
        if(currentSeminar == null) { throw new NoSeminarException("There is no seminar."); }

        if(currentSeminar.getState() == StateOfSeminarVO.AVAILABLE || currentSeminar.getState() == StateOfSeminarVO.FULL) {
            currentSeminar.deleteParticipant(obj);
        }
        if(currentSeminar.getState() == StateOfSeminarVO.FINISHED) {
            throw new IllegalStateException("The seminar is finished.");
        }
    }

    public void finishSeminar() throws NoSeminarException {
        if(currentSeminar == null) { throw new NoSeminarException("There is no seminar.");
        } else {currentSeminar.setState(StateOfSeminarVO.FINISHED);}
    }

    public List<ParticipantVO> sort() throws NoParticipantsException, NoSeminarException {
        if(currentSeminar == null) { throw new NoSeminarException("There is no seminar."); }
        if(currentSeminar.getParticipants().isEmpty()) { throw new NoParticipantsException("There are no participants."); }

        List<ParticipantVO> sorted = new ArrayList<ParticipantVO>(currentSeminar.getParticipants());
        Collections.sort(sorted);
        return sorted;
    }

    //Getter und Setter

   public void setCurrentSeminar(SeminarVO currentSeminar) {
       this.currentSeminar = currentSeminar;
   }
   public SeminarVO getCurrentSeminar() {
       return currentSeminar;
   }
}
