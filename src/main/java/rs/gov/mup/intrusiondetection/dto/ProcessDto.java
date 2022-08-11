package rs.gov.mup.intrusiondetection.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.gov.mup.intrusiondetection.model.Module;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProcessDto {
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
    @JacksonXmlProperty(isAttribute = true)
    private List<Module> modulelist;
}
