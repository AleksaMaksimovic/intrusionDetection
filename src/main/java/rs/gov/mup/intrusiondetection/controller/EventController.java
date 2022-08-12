package rs.gov.mup.intrusiondetection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.gov.mup.intrusiondetection.dto.EventDto;
import rs.gov.mup.intrusiondetection.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(consumes = {MediaType.APPLICATION_XML_VALUE}, method = RequestMethod.POST)
    public ResponseEntity<String> insert(@RequestBody EventDto eventDto) {
        return ResponseEntity.ok(eventService.insert(eventDto));
    }

    @RequestMapping(consumes = {MediaType.APPLICATION_XML_VALUE}, method = RequestMethod.POST,path = "/insertAll")
    public ResponseEntity<String> insertAll(@RequestBody List<EventDto> eventDtoList) {
        return ResponseEntity.ok(eventService.insertAll(eventDtoList));
    }
}
