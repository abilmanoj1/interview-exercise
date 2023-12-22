package com.abilmanoj.staffevents.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "security")
public class SecurityKey {      //entity model for storing security key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    private String securityKey;
}
