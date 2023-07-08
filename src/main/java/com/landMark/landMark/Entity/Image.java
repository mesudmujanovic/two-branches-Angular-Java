package com.landMark.landMark.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.landMark.landMark.Enum.Importance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String latitude;

    private String longitude;

    @Lob
    private byte[] content;

    @Enumerated(EnumType.STRING)
    private Importance importance;

    @ManyToOne
    @JoinColumn(name = "municipalityId")
    @JsonIgnore
    private Municipality municipality;
}
