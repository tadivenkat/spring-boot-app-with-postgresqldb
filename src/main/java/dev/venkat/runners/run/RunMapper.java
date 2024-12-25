package dev.venkat.runners.run;

import org.springframework.stereotype.Component;

@Component
public class RunMapper {
    public RunDTO map(RunDO runDO) {
        RunDTO run = new RunDTO(
                            runDO.getId(), 
                            runDO.getTitle(), 
                            runDO.getStartedOn(), 
                            runDO.getCompletedOn(), 
                            runDO.getMiles(), 
                            Location.valueOf(runDO.getLocation()), 
                            runDO.getVersion());
        return run;
    }

    public RunDO map(RunDTO run) {
        RunDO runDO = new RunDO();
        runDO.setId(run.id());
        runDO.setTitle(run.title());
        runDO.setStartedOn(run.startedOn());
        runDO.setCompletedOn(run.completedOn());
        runDO.setMiles(run.miles());
        runDO.setLocation(run.location().name());
        runDO.setVersion(run.version());
        return runDO;
    }
}
