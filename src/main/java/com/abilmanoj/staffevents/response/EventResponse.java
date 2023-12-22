package com.abilmanoj.staffevents.response;

import com.abilmanoj.staffevents.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventResponse {
    private List<Event> events;
}
