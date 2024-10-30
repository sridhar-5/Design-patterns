package com.design_patterns.SERVICES;

import com.design_patterns.DTO.Ticket;
import com.design_patterns.DTO.User;
import com.design_patterns.ENUMS.TicketStatus;
import com.design_patterns.STATE.CodeReview;
import com.design_patterns.STATE.Done;
import com.design_patterns.STATE.Inprogress;
import com.design_patterns.STATE.TODO;

import java.util.concurrent.locks.ReentrantLock;

public class TicketService {

    public Ticket createTicket(String title, String description, User createdBy){
        return new Ticket(title, description, createdBy);
    }

//    public void changeTicketState(Ticket ticket, TicketStatus newState){
//        TicketStatus oldTicketState = ticket.getTicketStatus();
//
//        if (oldTicketState.equals(TicketStatus.TO_DO)) {
//            if (newState.equals(TicketStatus.IN_PROGRESS)) {
//                System.out.println("Ticket" + ticket.getTitle() + "moved to in progress");
//            } else if (newState.equals(TicketStatus.CODE_REVIEW)) {
//                System.out.println("Ticket " + ticket.getTitle() + "moved to code review from " + oldTicketState);
//            } else if (newState.equals(TicketStatus.DONE)) {
//                System.out.println("Ticket " + ticket.getTitle() + "moved to done from " + oldTicketState);
//            } else if(newState.equals(TicketStatus.TO_DO)){
//                System.out.println("What is this transition?");
//            }
//        } else if (oldTicketState.equals(TicketStatus.IN_PROGRESS)) {
//            if (newState.equals(TicketStatus.IN_PROGRESS)) {
//                System.out.println("What is this transition?");
//            } else if (newState.equals(TicketStatus.CODE_REVIEW)) {
//                System.out.println("Ticket " + ticket.getTitle() + "moved to code review from " + oldTicketState);
//            } else if (newState.equals(TicketStatus.DONE)) {
//                System.out.println("Ticket " + ticket.getTitle() + "moved to done from " + oldTicketState);
//            } else if(newState.equals(TicketStatus.TO_DO)){
//                System.out.println("Ticket" + ticket.getTitle() + "moved to in progress");
//            }
//        } else if (oldTicketState.equals(TicketStatus.CODE_REVIEW)) {
//            if (newState.equals(TicketStatus.IN_PROGRESS)) {
//                System.out.println("Ticket " + ticket.getTitle() + "moved to code review from " + oldTicketState);
//            } else if (newState.equals(TicketStatus.CODE_REVIEW)) {
//                System.out.println("What is this transition?");
//            } else if (newState.equals(TicketStatus.DONE)) {
//                System.out.println("Ticket " + ticket.getTitle() + "moved to done from " + oldTicketState);
//            } else if(newState.equals(TicketStatus.TO_DO)){
//                System.out.println("Ticket" + ticket.getTitle() + "moved to in progress");
//            }
//        } else if (oldTicketState.equals(TicketStatus.DONE)) {
//            if (newState.equals(TicketStatus.IN_PROGRESS)) {
//                System.out.println("Ticket " + ticket.getTitle() + "moved to code review from " + oldTicketState);
//            } else if (newState.equals(TicketStatus.CODE_REVIEW)) {
//                System.out.println("Ticket " + ticket.getTitle() + "moved to done from " + oldTicketState);
//            } else if (newState.equals(TicketStatus.DONE)) {
//                System.out.println("What is this transition?");
//            } else if(newState.equals(TicketStatus.TO_DO)){
//                System.out.println("Ticket" + ticket.getTitle() + "moved to in progress");
//            }
//        }
//    }

    /**
     * Refactor this using the state design pattern
     */

    public void startTODO(Ticket ticket, User user){
        boolean isFeasible= ticket.getTicketStatus().startTODO(ticket, user);
        if(isFeasible){
            ticket.setTicketStatus(new TODO());
        }
    }

    public void startInprogress(Ticket ticket, User user){
        boolean isFeasible= ticket.getTicketStatus().startInprogress(ticket, user);
        if(isFeasible){
            ticket.setTicketStatus(new Inprogress());
        }
    }

    public void startCodeReview(Ticket ticket, User user){
        boolean isFeasible= ticket.getTicketStatus().startCodeReview(ticket, user);
        if(isFeasible){
            ticket.setTicketStatus(new CodeReview());
        }
    }

    public void startDone(Ticket ticket, User user){
        boolean isFeasible= ticket.getTicketStatus().startDone(ticket, user);
        if(isFeasible){
            ticket.setTicketStatus(new Done());
        }
    }


}
