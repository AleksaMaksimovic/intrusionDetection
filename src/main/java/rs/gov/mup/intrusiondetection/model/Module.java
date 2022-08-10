package rs.gov.mup.intrusiondetection.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@JacksonXmlRootElement(localName = "Module")
@Data
@Setter
@NoArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(isAttribute = true)
    private Long id;
    @JacksonXmlProperty(isAttribute = true)
    private Long Timestamp;
    @JacksonXmlProperty(isAttribute = true)
    private String BaseAddress;
    @JacksonXmlProperty(isAttribute = true)
    private String Size;
    @JacksonXmlProperty(isAttribute = true)
    private String Path;
    @JacksonXmlProperty(isAttribute = true)
    private String Version;
    @JacksonXmlProperty(isAttribute = true)
    private String Company;
    @JacksonXmlProperty(isAttribute = true)
    private String Description;

    @ManyToOne()
    private Process process;
}
