import java.util.*;

public class BookingTest {

    public static void main(String[] args) {

        Booking booking = new Booking();

        // Test: startNewSeminar
        SeminarVO seminar = booking.startNewSeminar("Java Basics", 2);
        assert seminar.getState() == StateOfSeminarVO.AVAILABLE;
        assert seminar.getMax() == 2;

        // Teilnehmer vorbereiten
        ParticipantVO p1 = new ParticipantVO("Alice");
        ParticipantVO p2 = new ParticipantVO("Bob");
        ParticipantVO p3 = new ParticipantVO("Charlie");

        // Test: Teilnehmer hinzufügen
        try {
            booking.addParticipant(p1);
            booking.addParticipant(p2);
        } catch (Exception e) {
            System.out.println("Fehler beim Hinzufügen: " + e.getMessage());
        }

        // Test: Seminar sollte jetzt "FULL" sein
        assert seminar.getState() == StateOfSeminarVO.FULL;

        // Test: Hinzufügen wenn voll
        try {
            booking.addParticipant(p3);
        } catch (IllegalStateException e) {
            System.out.println("Erwarteter Fehler: " + e.getMessage());
        } catch (NoSeminarException e) {
            throw new RuntimeException(e);
        }

        // Test: Teilnehmer löschen
        try {
            booking.deleteParticipant(p1);
            assert seminar.getParticipants().size() == 1;
        } catch (Exception e) {
            System.out.println("Fehler beim Löschen: " + e.getMessage());
        }

        // Test: Seminar abschließen
        try {
            booking.finishSeminar();
            assert seminar.getState() == StateOfSeminarVO.FINISHED;
        } catch (NoSeminarException e) {
            System.out.println("Fehler beim Abschließen: " + e.getMessage());
        }

        // Test: Kein Teilnehmer hinzufügen möglich nach Abschluss
        try {
            booking.addParticipant(p3);
        } catch (IllegalStateException e) {
            System.out.println("Erwarteter Fehler (FINISHED): " + e.getMessage());
        } catch (NoSeminarException e) {
            throw new RuntimeException(e);
        }

        // Test: Teilnehmer sortieren
        booking.setCurrentSeminar(booking.startNewSeminar("SortierTest", 3));
        try {
            booking.addParticipant(new ParticipantVO("Zoe"));
            booking.addParticipant(new ParticipantVO("Adam"));
            booking.addParticipant(new ParticipantVO("Mia"));

            List<ParticipantVO> sorted = booking.sort();
            System.out.println("Sortierte Teilnehmer:");
            for (ParticipantVO p : sorted) {
                System.out.println(p.getName());
            }
        } catch (Exception e) {
            System.out.println("Fehler beim Sortieren: " + e.getMessage());
        }

        // Test: Seminar null
        booking.setCurrentSeminar(null);
        try {
            booking.addParticipant(p1);
        } catch (NoSeminarException e) {
            System.out.println("Erwarteter Fehler (kein Seminar): " + e.getMessage());
        }

        // Test: sort mit leerer Teilnehmerliste
        booking.setCurrentSeminar(booking.startNewSeminar("Leer", 2));
        try {
            booking.sort();
        } catch (NoParticipantsException | NoSeminarException e) {
            System.out.println("Erwarteter Fehler (keine Teilnehmer): " + e.getMessage());
        }

        System.out.println("Alle Tests abgeschlossen.");
    }
}
