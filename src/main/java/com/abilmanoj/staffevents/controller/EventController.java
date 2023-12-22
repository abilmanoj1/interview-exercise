package com.abilmanoj.staffevents.controller;

import com.abilmanoj.staffevents.entity.Event;
import com.abilmanoj.staffevents.entity.SecurityKey;
import com.abilmanoj.staffevents.repository.SecurityRepository;
import com.abilmanoj.staffevents.response.EventResponse;
import com.abilmanoj.staffevents.service.EventService;
import com.abilmanoj.staffevents.service.implementation.EventServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class EventController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
    @Autowired
    private EventService eventService;

    @Autowired
    private SecurityRepository securityRepository;

    @GetMapping("/eventsapi")           //API to search for staff events
    public EventResponse getEvents(@RequestHeader("security-key") String securityKey,@RequestParam("startDate") String startDate,
                                   @RequestParam("email") String email,
                                   @RequestParam("desc") String description,
                                   @RequestParam("loc") String location) throws Exception {
        try{
            Optional<SecurityKey> securityKeysData = securityRepository.findBySecurityKey(securityKey);
            if(securityKeysData.isPresent()){
                return eventService.searchStaffEvents(startDate, email, description, location);
            }
            else{
                throw new Exception("User not authenticated");
            }
        }
        catch(Exception e){
            LOGGER.error("ERROR: "+e.getMessage());
            return null;
        }

    }

    @PostMapping("/addevent")           //API to add an event
    public Event addEvents(@RequestBody Event event){
        return eventService.addStaffEvents(event);
    }

    @DeleteMapping("/delete-event/{id}")
    public Event deleteEvent(@PathVariable Integer id){
        return eventService.deleteStaffEvents(id);
    }
}
