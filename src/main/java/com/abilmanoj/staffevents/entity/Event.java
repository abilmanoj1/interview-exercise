package com.abilmanoj.staffevents.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event {       //setting up entity class for event record

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @Column(name = "event_ref",unique = true)
    private String eventRef;

    @Column
    private String desc1;

    @Column
    private String desc2;

    @Column
    private String  desc3;

    @Column
    private String start;

    @Column
    private String end;

    @Column(name = "meeting_url")
    private String meetingURL;

    @Column
    private Boolean isMeetingOnline = Boolean.FALSE;

//    @Column(name = "teacher_name")
//    private String teacherName;
//
//    @Column(name = "teacher_email")
//    private String teacherEmail;

    @ManyToOne
    @JoinColumn(name = "teacher_id") // Name of the foreign key column
    private Teacher teacher;

    @Column(name = "loc_code")
    private String locCode;

    @Column(name = "loc_add1")
    private String locAdd1;

    @Column(name = "loc_add2")
    private String locAdd2;
}

