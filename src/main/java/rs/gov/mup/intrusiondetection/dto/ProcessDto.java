package rs.gov.mup.intrusiondetection.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.gov.mup.intrusiondetection.model.Module;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProcessDto {
    private Long ProcessIndex;
    private Long ProcessId;
    private Long ParentProcessId;
    private Long ParentProcessIndex;
    private String AuthenticationId;
    private Long CreateTime;
    private Long FinishTime;
    private Long IsVirtualized;
    private String Is64bit;
    private String Integrity;
    private String Owner;
    private String ProcessName;
    private String ImagePath;
    private String CommandLine;
    private String CompanyName;
    private String Version;
    private String Description;
    private List<Module> modulelist;
}
