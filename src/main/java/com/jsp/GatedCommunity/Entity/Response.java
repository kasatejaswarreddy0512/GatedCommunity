package com.jsp.GatedCommunity.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    @Id
    private Long id;
    private String message;
    private LocalDateTime localDateTime;

    @ManyToOne
    private Complaint complaint;

    @ManyToOne
    private  User user;
}
