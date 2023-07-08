package com.landMark.landMark.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Municipality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameMunicipality;

    @OneToMany(mappedBy = "municipality", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Image> imageList;

    @ManyToOne()
    @JoinColumn(name="countryId")
    private Country country;

}
