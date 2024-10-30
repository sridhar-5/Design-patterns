import com.design_patterns.DTO.*;
import com.design_patterns.SERVICES.TicketService;

public class Main {
    public static void main(String[] args) {
        User u1= new User("Test");
        Ticket ticket= new Ticket("first ticket", "Title of the ticket", u1);

        TicketService ticketService= new TicketService();

        /**
         *   ticketService.changeTicketState(ticket, TicketState.REVIEW, u1);
         *   ticketService.changeTicketState(ticket, TicketState.ANALYSIS, u1);
         */
        ticketService.startTODO(ticket, u1);
        ticketService.startCodeReview(ticket, u1);
    }
}