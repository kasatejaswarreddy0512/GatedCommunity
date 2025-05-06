package com.jsp.GatedCommunity.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Complaint {

    @Id
    private Long id;
    private String title;
    private String description;
    private String Status;

    @ManyToOne
    private User user;
}
