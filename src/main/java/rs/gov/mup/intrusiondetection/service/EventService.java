package rs.gov.mup.intrusiondetection.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.gov.mup.intrusiondetection.dto.EventDto;
import rs.gov.mup.intrusiondetection.model.Event;
import rs.gov.mup.intrusiondetection.model.Frame;
import rs.gov.mup.intrusiondetection.repository.EventRepository;
import rs.gov.mup.intrusiondetection.repository.FrameRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final FrameRepository frameRepository;

    @Autowired
    public EventService(EventRepository eventRepository, FrameRepository frameRepository) {
        this.eventRepository = eventRepository;
        this.frameRepository = frameRepository;
    }
    @Transactional(rollbackOn = Exception.class)
    public String insert(EventDto eventDto) {
        List<Frame> frameList = eventDto.getStack();
        Event event = new Event();
        event.setProcessIndex(eventDto.getProcessIndex());
        event.setTime_of_Day(eventDto.getTime_of_Day());
        event.setProcess_Name(eventDto.getProcess_Name());
        event.setPID(eventDto.getPID());
        event.setOperation(eventDto.getOperation());
        event.setPath(eventDto.getPath());
        event.setResult(eventDto.getResult());
        event.setDetail(eventDto.getDetail());
        Event savedEvent = eventRepository.save(event);
        for (Frame frame : frameList) {
            frame.setEvent(savedEvent);
            frameRepository.save(frame);
        }
        return "ok";
    }

    public String insertAll(List<EventDto> eventDtoList) {
        for (EventDto eventDto : eventDtoList) {
            insert(eventDto);
        }
        return "ok1";
    }
}
