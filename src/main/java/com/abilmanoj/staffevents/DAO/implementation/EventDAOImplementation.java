package com.abilmanoj.staffevents.DAO.implementation;

import com.abilmanoj.staffevents.DAO.EventDAO;
import com.abilmanoj.staffevents.entity.Event;
import com.abilmanoj.staffevents.entity.Teacher;
import com.abilmanoj.staffevents.repository.EventRepository;
import com.abilmanoj.staffevents.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Component
public class EventDAOImplementation implements EventDAO {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public List<Event> getUniversityEvents(String startDate, String email, String description, String location) {
        Optional<Teacher> teacherData = teacherRepository.findByTeacherEmail(email);       //finding teacher details by email
        if (teacherData.isPresent()) {

            Integer teacherId = teacherData.get().getTeacherId();       //extracting teacher id


            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inputDate = LocalDate.parse(startDate, inputFormatter);

            LocalDateTime dateTime = LocalDateTime.of(inputDate, LocalTime.MIDNIGHT);

            DateTimeFormatter fullDbFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
            String formattedDateTime = dateTime.format(fullDbFormatter);        //converts time from dd/mm/yyyy -> yyyy-MM-dd HH:mm:ss.SSSSSS format

            String[] dateTimeSplit = formattedDateTime.split(" ");          //splitting datetime based on space occurrence
            String updateFormattedDateTime = dateTimeSplit[0] + "T" + dateTimeSplit[1];     //converting datetime to ISO 8601 standard

            List<Event> events = eventRepository.searchEvents(updateFormattedDateTime, teacherId, description, location);
                                    //search for events in the event repository
            return events;
        }
        return null;
    }
}
