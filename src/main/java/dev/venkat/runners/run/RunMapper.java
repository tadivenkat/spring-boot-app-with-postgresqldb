package dev.venkat.runners.run;

import org.springframework.stereotype.Component;

@Component
public class RunMapper {
    public Run map(RunDO runDO) {
        Run run = new Run(runDO.getId(), runDO.getTitle(), runDO.getStartedOn(), runDO.getCompletedOn(), runDO.getMiles(), Location.valueOf(runDO.getLocation()));
        return run;
    }

    public RunDO map(Run run) {
        RunDO runDO = new RunDO();
        runDO.setId(run.id());
        runDO.setTitle(run.title());
        runDO.setStartedOn(run.startedOn());
        runDO.setCompletedOn(run.completedOn());
        runDO.setMiles(run.miles());
        runDO.setLocation(run.location().name());
        return runDO;
    }
}
