package com.springboot.workoutrack.workout;

import com.springboot.workoutrack.exercise.ExerciseDTO;

import java.time.LocalDateTime;
import java.util.List;

public record WorkoutDTO(Long id,
                         String name,
                         String createdBy,
                         LocalDateTime createdAt,
                         List<ExerciseDTO> exercises) {
}
