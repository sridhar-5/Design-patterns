package com.design_patterns.STATE;

import com.design_patterns.DTO.*;

public interface State {
    public boolean startTODO(Ticket ticket, User user);
    public boolean startInprogress(Ticket ticket, User user);
    public boolean startCodeReview(Ticket ticket, User user);
    public boolean startDone(Ticket ticket, User user);
}
