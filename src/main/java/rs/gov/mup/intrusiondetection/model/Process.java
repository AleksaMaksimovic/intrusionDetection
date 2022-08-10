package rs.gov.mup.intrusiondetection.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Process {

    @Id
    private Long id;
    private Long processIndex;
    private Long processId;
    private Long parentProcessId;
    private Long parentProcessIndex;
    private String authenticationId;
    private Long createTime;
    private Long finishTime;
    private Long isVirtualized;
    private Boolean is64bit;
    private String integrity;
    private String owner;
    private String processName;
    private String imagePath;
    private String commandLine;
    private String companyName;
    private String version;
    private String description;
    @OneToMany(mappedBy = "process", fetch = FetchType.EAGER)
    private List<Module> modules;
}
