package com.abilmanoj.staffevents.service.implementation;

import com.abilmanoj.staffevents.DAO.implementation.EventDAOImplementation;
import com.abilmanoj.staffevents.entity.Event;
import com.abilmanoj.staffevents.entity.Teacher;
import com.abilmanoj.staffevents.repository.EventRepository;
import com.abilmanoj.staffevents.repository.TeacherRepository;
import com.abilmanoj.staffevents.response.EventResponse;
import com.abilmanoj.staffevents.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImplementation implements EventService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImplementation.class);

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private EventDAOImplementation eventDAOImplementation;

    @Override
    public EventResponse searchStaffEvents(String startDate, String email, String description, String location) throws ParseException {
        List<Event> eventList = eventDAOImplementation.getUniversityEvents(startDate,email,description,location);
                //get list of events based on parameters
        if(eventList!=null){
            //add the received event list to a response class and return the response object
            EventResponse eventResponse = new EventResponse();
            eventResponse.setEvents(eventList);
            return eventResponse;
        }
        return null;
    }

    @Override
    public Event addStaffEvents(Event event) {
        eventRepository.save(event);        //save staff event details to repository
        Integer teacherId = event.getTeacher().getTeacherId();
        Teacher teacherObj = new Teacher();     //creating a teacher object
        Optional<Teacher> teacherData = teacherRepository.findById(teacherId);      //find teacher details by id
        teacherObj.setTeacherId(teacherId);     //set teacher id
        if(teacherData.isPresent()){
            teacherObj.setTeacherName(teacherData.get().getTeacherName());      //set teacher name
            teacherObj.setTeacherEmail(teacherData.get().getTeacherEmail());    //set teacher email
        }
        event.setTeacher(teacherObj);
        return event;                   //return the updated event object
    }

    @Override
    public Event deleteStaffEvents(Integer eventId) {
        try{
            Optional<Event> findEvent = eventRepository.findById(eventId);
            if(findEvent.isPresent()){
                eventRepository.deleteById(eventId);
                return findEvent.get();
            }
            else{
                throw new Exception("Event not found");
            }
        }
        catch (Exception e){
            LOGGER.error("ERROR: "+e.getMessage());
            return null;
        }
    }
}
