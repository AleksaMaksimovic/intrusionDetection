package rs.gov.mup.intrusiondetection.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JacksonXmlRootElement(localName = "Process")
@Getter
@Setter
public class Process implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(isAttribute = true)
    private Long id;
    @JacksonXmlProperty(isAttribute = true)
    private Long ProcessIndex;
    @JacksonXmlProperty(isAttribute = true)
    private Long ProcessId;
    @JacksonXmlProperty(isAttribute = true)
    private Long ParentProcessId;
    @JacksonXmlProperty(isAttribute = true)
    private Long ParentProcessIndex;
    @JacksonXmlProperty(isAttribute = true)
    private String AuthenticationId;
    @JacksonXmlProperty(isAttribute = true)
    private Long CreateTime;
    @JacksonXmlProperty(isAttribute = true)
    private Long FinishTime;
    @JacksonXmlProperty(isAttribute = true)
    private Long IsVirtualized;
    @JacksonXmlProperty(isAttribute = true)
    private String Is64bit;
    @JacksonXmlProperty(isAttribute = true)
    private String Integrity;
    @JacksonXmlProperty(isAttribute = true)
    private String Owner;
    @JacksonXmlProperty(isAttribute = true)
    private String ProcessName;
    @JacksonXmlProperty(isAttribute = true)
    private String ImagePath;
    @JacksonXmlProperty(isAttribute = true)
    private String CommandLine;
    @JacksonXmlProperty(isAttribute = true)
    private String CompanyName;
    @JacksonXmlProperty(isAttribute = true)
    private String Version;
    @JacksonXmlProperty(isAttribute = true)
    private String Description;
    @OneToMany(mappedBy = "process", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Module> modulelist;
}
