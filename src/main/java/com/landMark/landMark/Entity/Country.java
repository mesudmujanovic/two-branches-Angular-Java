package com.landMark.landMark.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameCountry;

    @OneToMany(mappedBy = "country", fetch =  FetchType.LAZY)
    private List<Municipality> municipalityList;
}
