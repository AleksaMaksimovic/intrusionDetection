package rs.gov.mup.intrusiondetection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.gov.mup.intrusiondetection.dto.ProcessDto;
import rs.gov.mup.intrusiondetection.model.Process;
import rs.gov.mup.intrusiondetection.repository.ProcessRepository;

@Service
public class ProcessService {
    private final ProcessRepository processRepository;

    @Autowired
    public ProcessService(ProcessRepository processRepository) {
        this.processRepository = processRepository;
    }

    @Transactional
    public Process insert(Process process) {
        return processRepository.save(process);
    }

    public Iterable<Process> getAll() {
        return processRepository.findAll();
    }
}
