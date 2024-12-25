package dev.venkat.runners.run;

import java.util.List;

public interface RunService {
    RunDTO findById(Integer id);
    List<RunDTO> findAll();
    RunDTO create(RunDTO run);
    RunDTO update(Integer id, RunDTO run);
    void delete(Integer id);
}
