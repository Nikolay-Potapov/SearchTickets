package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {

    private TicketManager manager;
    private Ticket ticket01 = new Ticket(1, 1400, "KEM", "NSB", 130);
    private Ticket ticket02 = new Ticket(2, 1700, "KEM", "SAM", 110);
    private Ticket ticket03 = new Ticket(3, 2100, "KEM", "NSB", 120);
    private Ticket ticket04 = new Ticket(4, 2600, "KEM", "KAZ", 125);
    private Ticket ticket05 = new Ticket(5, 3700, "KEM", "UZB", 150);
    private Ticket ticket06 = new Ticket(6, 3100, "KEM", "NSB", 135);

    @BeforeEach
    public void setUp() {
        manager = new TicketManager(new TicketRepository());
        manager.add(ticket01);
        manager.add(ticket02);
        manager.add(ticket03);
        manager.add(ticket04);
        manager.add(ticket05);
        manager.add(ticket06);
    }

    @Test
    void mustShowOffers() {
        Ticket[] expected = new Ticket[]{ticket01, ticket02, ticket03, ticket04, ticket06, ticket05};
        assertArrayEquals(expected, manager.showOffers());
    }

    @Test
    void mustSearchIfExists() {
        Ticket[] expected = new Ticket[]{ticket01, ticket03, ticket06};
        assertArrayEquals(expected, manager.findAll("KEM", "NSB"));
    }

    @Test
    void mustSearchIfNotExists() {
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, manager.findAll("KEM", "MSC"));
    }
}