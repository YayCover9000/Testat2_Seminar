
import java.util.List;


public interface IBooking {
	
	public SeminarVO startNewSeminar(String name, int max);
	
	public void addParticipant(ParticipantVO obj) throws NullPointerException, NoSeminarException, IllegalStateException ;
	
	public void deleteParticipant(ParticipantVO obj) throws NullPointerException, NoSeminarException, IllegalStateException ;
	
	public void finishSeminar() throws NoSeminarException;
	
	public List<ParticipantVO> sort() throws NoParticipantsException, NoSeminarException;
	

}
