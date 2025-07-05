Die Klassen/Interfaces IBooking und ParticipantVO sind gegeben.

Erweitern Sie die Klasse ParticipantVO.

Programmieren Sie die fünf Klassen/Enumerations Booking, NoSeminarException, NoParticipantsException, SeminarVO und StateOfSeminarVO.

![img.png](img.png)
Abbildung: Klassendiagramm ohne Verwaltungsmethoden

Die Klassen NoSeminarException und NoParticipantsException sind checked

StateOfSeminarVO ist ein Aufzählungsdatentyp mit den Konstanten:

    AVAILABLE
    FULL
    FINISHED

Die Klasse ParticipantVO implementiert das Interface java.lang.Comparable.

Die Klasse SeminarVO dient der Objektverwaltung und hat die Instanzattribute:

    name vom Datentyp String
    max vom Datentyp int
    Das Attribut legt die maximal Anzahl von Objekten in participants fest.
    state vom Datentyp StateOfSeminarVO;
    participants vom Datentyp java.util.List
    Hier werden die Objekte von ParticipantVO typsicher in einer java.util.LinkedList verwaltet.

Die Klasse SeminarVO setzt das Geheimnisprinzip um. Sie hat einen Initialisierungskonstruktor mit drei Parametern und initialisiert alle Attribute. Sie hat nur die Java-Standard-Operation toString.

    String toString()
    gibt einen String zurück, der name und - falls vorhanden - alle participants jeweils als String enthält.
    void addParticipant(ParticipantVO obj)
    fügt eine Objekt von ParticipantVO der Liste hinzu
    boolean deleteParticipant(ParticipantVO obj)
    löscht das erste Element in der Liste, das für obj und sich mit equals true ergibt. Es wird true zurückgegeben, falls ein Element gefunden und gelöscht wurde, sonst false.

(Tipp: Setzen Sie für die Implementierung von add und delete geeignete Methoden des Collection-Frameworks ein.)

Die Klasse Booking implementiert das Interface IBooking.

Die Klasse hat eine Instanzvariable

    currentSeminar vom Datentyp SeminarVO.

Die Klasse Booking setzt das Geheimnisprinzip um. Sie hat einen Standardkonstruktor. Sie hat KEINE Java-Standard-Operationen.

Sie implementiert die Methoden des Interface IBooking. Falls nicht anderes angegeben wird und der Parameter einer Methode null ist, sollte die NullPointerException zugelassen werden. Die Fehlermeldung lautet "obj must not be null.".

    public SeminarVO startNewSeminar(String name, int max)
    Es wird ein neues Objekt von SeminarVO mit name, state ist AVAILABLE und max erzeugt und zurückgeben.
    (Es findet keine Fehlerbehandlung für die Parameter statt.)
    public void addParticipant(ParticipantVO obj) throws NullPointerException, NoSeminarException, IllegalStateException
    Die Methode fügt das Objekt obj participants von currentSeminar hinzu, wenn state von currentSeminar AVAILABLE ist und solange max von currentSeminar nicht erreicht ist. Wird max erreicht, wird zusätzlich state von currentSeminar auf FUll gesetzt.
    Ist state von currentSeminar FUll oder FINISHED erfolgt mit der passenden Exception die Fehlermeldung "The seminar is full." oder "The seminar is finished."
    Ist currentSeminar null erfolgt mit der passenden Exception die Fehlermeldung "There is no seminar."

    public void deleteParticipant(ParticipantVO obj)) throws NullPointerException, NoSeminarException, IllegalStateException
    Die Methode löscht das Objekt obj aus participants von currentSeminar, wenn state AVAILABLE ist. Die Methode löscht das Objekt obj aus participants von currentSeminar auch, wenn state FULL ist. Falls dabei das Löschen erfolgreich war, wird state von currentSeminar auf AVAILABLE gesetzt.
    Ist state von currentSeminar FINISHED erfolgt mit der passenden Exception die Fehlermeldung "The seminar is finished."
    Ist currentSeminar null erfolgt mit der passenden Exception die Fehlermeldung "There is no seminar."

    public void finishSeminar() throws NoSeminarException
    Ist currentSeminar null erfolgt mit der passenden Exception die Fehlermeldung "There is no seminar." Sonst wird state von currentSeminar auf FINISHED gesetzt.

    public List<ParticipantVO> sort() throws NoParticipantsException, NoSeminarException
    Ist currentSeminar null erfolgt mit der passenden Exception die Fehlermeldung "There is no seminar." Hat currentSeminar keine participants erfolgt mit der passenden Exception die Fehlermeldung "There are no participants.". Sonst wird participants von currentSeminar nach der natürlichen Ordnung sortiert und zurückgeben.
