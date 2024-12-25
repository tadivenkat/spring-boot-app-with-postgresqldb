package dev.venkat.runners.run;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record RunDTO(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location,
        Integer version 
) {
        public RunDTO {
                if (completedOn != null && startedOn != null && !completedOn.isAfter(startedOn)) {
                        throw new IllegalArgumentException("completedOn must be after startedOn");
                }
        }
}
