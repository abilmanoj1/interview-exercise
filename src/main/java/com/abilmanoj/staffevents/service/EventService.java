package com.abilmanoj.staffevents.service;

import com.abilmanoj.staffevents.entity.Event;
import com.abilmanoj.staffevents.response.EventResponse;

import java.text.ParseException;
import java.util.Date;

public interface EventService {         //service interface for different event related operations
    EventResponse searchStaffEvents(String startDate, String email, String description, String location) throws ParseException;
    Event addStaffEvents(Event event);

    Event deleteStaffEvents(Integer eventId);
}
