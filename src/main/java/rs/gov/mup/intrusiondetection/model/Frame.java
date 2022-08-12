package rs.gov.mup.intrusiondetection.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@JacksonXmlRootElement(localName = "Frame")
@Getter
@Setter
public class Frame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(isAttribute = true)
    private Long id;
    private Long depth;
    private String address;
    private String path;
    private String location;

    @ManyToOne()
    @JsonIgnore
    private Event event;
}
