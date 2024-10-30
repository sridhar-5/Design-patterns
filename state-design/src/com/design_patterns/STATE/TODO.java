package com.design_patterns.STATE;

import com.design_patterns.DTO.Ticket;
import com.design_patterns.DTO.User;

public class TODO implements State {
    @Override
    public boolean startTODO(Ticket ticket, User user) {
        System.out.println("This is a weird transitions");
        return false;
    }

    @Override
    public boolean startInprogress(Ticket ticket, User user) {
        System.out.println(ticket.getTitle() + "Moved to In progress by " + user.getName());
        return true;
    }

    @Override
    public boolean startCodeReview(Ticket ticket, User user) {
        System.out.println(ticket.getTitle() + "Moved to Code Review by " + user.getName());
        return true;
    }

    @Override
    public boolean startDone(Ticket ticket, User user) {
        System.out.println(ticket.getTitle() + "Moved to Done by " + user.getName());
        return true;
    }
}
