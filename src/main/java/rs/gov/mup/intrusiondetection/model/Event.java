package rs.gov.mup.intrusiondetection.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@JacksonXmlRootElement(localName = "Process")
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(isAttribute = true)
    private Long id;
    @JacksonXmlProperty(isAttribute = true)
    private Long ProcessIndex;
    @JacksonXmlProperty(isAttribute = true)
    private String Time_of_Day;
    @JacksonXmlProperty(isAttribute = true)
    private String Process_Name;
    @JacksonXmlProperty(isAttribute = true)
    private Long PID;
    @JacksonXmlProperty(isAttribute = true)
    private String Operation;
    @JacksonXmlProperty(isAttribute = true)
    private String Path;
    @JacksonXmlProperty(isAttribute = true)
    private String Result;
    @JacksonXmlProperty(isAttribute = true)
    private String Detail;
    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Frame> stack;
}
