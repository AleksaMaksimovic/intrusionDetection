package rs.gov.mup.intrusiondetection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rs.gov.mup.intrusiondetection.dto.ProcessDto;
import rs.gov.mup.intrusiondetection.model.Process;
import rs.gov.mup.intrusiondetection.service.ProcessService;

@Controller
@RequestMapping("/process")
public class ProcessController {
    private final ProcessService processService;

    @Autowired
    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @RequestMapping(consumes = {MediaType.APPLICATION_XML_VALUE}, method = RequestMethod.POST)
    public ResponseEntity<String> insert(@RequestBody ProcessDto processDto) {
        return ResponseEntity.ok(processService.insert(processDto));
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Iterable<Process>> getAll() {
        return ResponseEntity.ok(processService.getAll());
    }
}
