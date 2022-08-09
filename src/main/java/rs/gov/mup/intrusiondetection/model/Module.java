package rs.gov.mup.intrusiondetection.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@Setter
@NoArgsConstructor
public class Module {
    @Id
    private Long id;
    private Long timestamp;
    private String baseAddress;
    private String size;
    private String path;
    private String version;
    private String company;
    private String description;

    @ManyToOne()
    private Process process;
}
