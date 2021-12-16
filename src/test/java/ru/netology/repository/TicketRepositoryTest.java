package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    private Ticket ticket01 = new Ticket(1, 1400, "KEM", "NSB", 130);
    private Ticket ticket02 = new Ticket(2, 1700, "KEM", "SAM", 110);
    private Ticket ticket03 = new Ticket(3, 2100, "KEM", "NSB", 120);
    private Ticket ticket04 = new Ticket(4, 2600, "KEM", "KAZ", 125);
    private Ticket ticket05 = new Ticket(5, 3700, "KEM", "UZB", 150);
    private Ticket ticket06 = new Ticket(6, 3100, "KEM", "NSB", 135);

    @Test
    void mustSave() {
        repository.save(ticket01);
        Ticket[] expected = new Ticket[]{ticket01};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowEmpty() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowNotEmpty() {
        repository.save(ticket01);
        repository.save(ticket02);
        repository.save(ticket03);
        repository.save(ticket04);
        Ticket[] expected = new Ticket[]{ticket01, ticket02, ticket03, ticket04};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }


}