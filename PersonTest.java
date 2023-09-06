import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p1, p2, p3, p4, p5, p6;
    @BeforeEach
    void setUp()
    {
        p1 = new Person( "00000A", "Bob", "Tester1", 1955, "Mr.");
        p2 = new Person( "00000B", "Sally", "Tester2", 1975, "Mrs.");
        p1.setIDSeed(0);
        p3 = new Person( "000001", "Bob", "Tester3", 1960, "Mr.");
        p4 = new Person( "000002", "Sally", "Tester4", 1965, "Mrs.");
        p5 = new Person( "000003", "Fred", "Tester5", 1970, "Mr.");
        p6 = new Person( "000004", "Cindy", "Tester6", 1975, "Mrs.");
    }

    @Test
    void getIDSeed()
    {
        assertEquals(0, p1.getIDSeed());
    }

    @Test
    void setIDNum()
    {
        assertEquals("00000A", p1.getIDNum());
    }

    @Test
    void setFirstName()
    {
        assertEquals("Bob", p1.getFirstName());
    }

    @Test
    void setLastName()
    {
        assertEquals("Tester1", p1.getLastName());
    }

    @Test
    void setYOB()
    {
        assertEquals(1955, p1.getYOB());
    }

    @Test
    void setTitle()
    {
        assertEquals("Mr.", p1.getTitle());
    }
}