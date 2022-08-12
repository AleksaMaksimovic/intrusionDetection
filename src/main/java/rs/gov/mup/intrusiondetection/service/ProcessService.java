package rs.gov.mup.intrusiondetection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.gov.mup.intrusiondetection.dto.ProcessDto;
import rs.gov.mup.intrusiondetection.model.Module;
import rs.gov.mup.intrusiondetection.model.Process;
import rs.gov.mup.intrusiondetection.repository.ModuleRepository;
import rs.gov.mup.intrusiondetection.repository.ProcessRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProcessService {
    private final ProcessRepository processRepository;
    private final ModuleRepository moduleRepository;

    @Autowired
    public ProcessService(ProcessRepository processRepository, ModuleRepository moduleRepository) {
        this.processRepository = processRepository;
        this.moduleRepository = moduleRepository;
    }

    @Transactional(rollbackOn = Exception.class)
    public String insert(ProcessDto processDto) {
        List<Module> lista = processDto.getModulelist();
        Process process = new Process();
        process.setProcessIndex(processDto.getProcessId());
        process.setProcessId(processDto.getProcessId());
        process.setParentProcessId(processDto.getParentProcessId());
        process.setParentProcessIndex(processDto.getParentProcessIndex());
        process.setAuthenticationId(processDto.getAuthenticationId());
        process.setCreateTime(processDto.getCreateTime());
        process.setFinishTime(processDto.getFinishTime());
        process.setIsVirtualized(processDto.getIsVirtualized());
        process.setIs64bit(processDto.getIs64bit());
        process.setIntegrity(processDto.getIntegrity());
        process.setOwner(processDto.getOwner());
        process.setProcessName(processDto.getProcessName());
        process.setImagePath(processDto.getImagePath());
        process.setCommandLine(processDto.getCommandLine());
        process.setVersion(processDto.getVersion());
        process.setDescription(processDto.getDescription());
        Process savedProcess = processRepository.save(process);
        for (Module module : lista) {
            module.setProcess(savedProcess);
            moduleRepository.save(module);
        }
        return "ok";
    }

    public Iterable<Process> getAll() {
        return processRepository.findAll();
    }

    public String insertAll(List<ProcessDto> processDtoList) {
        for (ProcessDto processDto : processDtoList) {
            insert(processDto);
        }
        return "ok1";
    }
}
