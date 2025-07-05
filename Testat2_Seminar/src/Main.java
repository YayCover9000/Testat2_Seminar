public class Main {
    public static void main(String[] args) {
        Booking booking1 = new Booking();
        int size = 5;
        SeminarVO semi1 = booking1.startNewSeminar("Seminar1:",size);
        for(int i = 1; i <= size; i++){
            semi1.addParticipant(new ParticipantVO("Participant" + i));
        }
        System.out.println(semi1);
    }
}
