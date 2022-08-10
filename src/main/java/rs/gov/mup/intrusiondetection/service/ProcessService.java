package rs.gov.mup.intrusiondetection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.gov.mup.intrusiondetection.dto.ProcessDto;
import rs.gov.mup.intrusiondetection.model.Module;
import rs.gov.mup.intrusiondetection.model.Process;
import rs.gov.mup.intrusiondetection.repository.ModuleRepository;
import rs.gov.mup.intrusiondetection.repository.ProcessRepository;

@Service
public class ProcessService {
    private final ProcessRepository processRepository;
    private final ModuleRepository moduleRepository;

    @Autowired
    public ProcessService(ProcessRepository processRepository, ModuleRepository moduleRepository) {
        this.processRepository = processRepository;
        this.moduleRepository = moduleRepository;
    }

    @Transactional
    public Process insert(ProcessDto processDto) {
        Process process = new Process();
        process.setProcessIndex(processDto.getProcessId());
        process.setProcessId(processDto.getProcessId());
        process.setParentProcessId(process.getParentProcessId());
        process.setParentProcessIndex(processDto.getParentProcessIndex());
        process.setAuthenticationId(processDto.getAuthenticationId());
        process.setCreateTime(processDto.getCreateTime());
        process.setFinishTime(processDto.getFinishTime());
        process.setIsVirtualized(processDto.getIsVirtualized());
        process.setIs64bit(processDto.getIs64bit());
        process.setIntegrity(processDto.getIntegrity());
        process.setOwner(processDto.getOwner());
        process.setProcessName(processDto.getProcessName());
        process.setImagePath(process.getImagePath());
        process.setCommandLine(processDto.getCommandLine());
        process.setVersion(processDto.getVersion());
        process.setDescription(processDto.getDescription());
        Process savedProcess = processRepository.save(process);
        for (Module module : processDto.getModulelist()) {
            module.setProcess(savedProcess);
            moduleRepository.save(module);
        }
        return savedProcess;
    }

    public Iterable<Process> getAll() {
        return processRepository.findAll();
    }
}
