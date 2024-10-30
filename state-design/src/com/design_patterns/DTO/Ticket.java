package com.design_patterns.DTO;

import com.design_patterns.STATE.State;
import com.design_patterns.STATE.TODO;

public class Ticket {

    private String title;
    private String description;
    private User createdBy;
    private State ticketStatus;

    public Ticket(String description, String title, User createdBy) {
        this.description = description;
        this.title = title;
        this.createdBy = createdBy;
        this.ticketStatus = new TODO(); // you want the initial state of the ticket to be TODO
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public State getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(State ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}


