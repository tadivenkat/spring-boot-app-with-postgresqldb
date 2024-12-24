package dev.venkat.runners.run;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RunServiceImpl implements RunService {
    private final RunRepository runRepository;
    private final RunMapper runMapper;

    public RunServiceImpl(RunRepository runRepository, RunMapper runMapper) {
        this.runRepository = runRepository;
        this.runMapper = runMapper;
    }

    @Override
    public Run create(Run run) {
        return runMapper.map(runRepository.save(runMapper.map(run)));
    }

    @Override
    public Run findById(Integer id) {
        return runRepository.findById(id).map(runMapper::map).orElse(null);
    }
    
    @Override
    public List<Run> findAll() {
        return runRepository.findAll().stream().map(runMapper::map).toList();
    }

    @Override
    public Run update(Integer id, Run run) {
        RunDO existingRunDO = runRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Run not found"));
        if (run.title() != null) existingRunDO.setTitle(run.title());
        if (run.startedOn() != null) existingRunDO.setStartedOn(run.startedOn());
        if (run.completedOn() != null) existingRunDO.setCompletedOn(run.completedOn());
        if (run.miles() != null) existingRunDO.setMiles(run.miles());
        if (run.location() != null) existingRunDO.setLocation(run.location().name());
        return runMapper.map(runRepository.save(existingRunDO));
    }

    @Override
    public void delete(Integer id) {
        runRepository.deleteById(id);
    }
}
