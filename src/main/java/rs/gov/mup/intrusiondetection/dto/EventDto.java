package rs.gov.mup.intrusiondetection.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.gov.mup.intrusiondetection.model.Frame;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EventDto {
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
