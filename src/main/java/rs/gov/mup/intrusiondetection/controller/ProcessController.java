package rs.gov.mup.intrusiondetection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<Process> insert(@RequestBody Process process) {
        return ResponseEntity.ok(processService.insert(process));
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Iterable<Process>> getAll() {
        return ResponseEntity.ok(processService.getAll());
    }
}
