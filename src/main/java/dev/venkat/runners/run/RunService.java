package dev.venkat.runners.run;

import java.util.List;

public interface RunService {
    Run findById(Integer id);
    List<Run> findAll();
    Run create(Run run);
    Run update(Integer id, Run run);
    void delete(Integer id);
}
