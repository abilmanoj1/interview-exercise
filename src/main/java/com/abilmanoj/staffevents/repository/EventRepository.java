package com.abilmanoj.staffevents.repository;

import com.abilmanoj.staffevents.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {
    @Query("SELECT e FROM Event e JOIN e.teacher t WHERE " +
            "(:startDate IS NULL OR e.start < :startDate) AND " +
            "(:description IS NULL OR e.desc1 = :description) AND " +
            "(:location IS NULL OR e.locAdd1 = :location OR e.locAdd2 = :location) AND " +
            "(:teacherId IS NULL OR t.teacherId = :teacherId)")

    //query that joins the event and teacher tables where the provided start date is greater than start date of event
    //and all other parameters are equal
    List<Event> searchEvents(
            @Param("startDate") String startDate,
            @Param("teacherId") Integer teacherId,
            @Param("description") String description,
            @Param("location") String location);
}
