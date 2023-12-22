package com.abilmanoj.staffevents.DAO;

import com.abilmanoj.staffevents.entity.Event;

import java.util.List;


public interface EventDAO {
    List<Event> getUniversityEvents(String startDate, String email, String description, String location);
}
