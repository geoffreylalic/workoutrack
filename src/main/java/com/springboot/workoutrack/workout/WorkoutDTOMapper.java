package com.springboot.workoutrack.workout;

import com.springboot.workoutrack.exercise.ExerciseDTO;
import com.springboot.workoutrack.exercise.ExerciseDTOMapper;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class WorkoutDTOMapper implements Function<Workout, WorkoutDTO> {

    private ExerciseDTOMapper exerciseDTOMapper;

    public WorkoutDTOMapper(ExerciseDTOMapper exerciseDTOMapper) {
        this.exerciseDTOMapper = exerciseDTOMapper;
    }

    @Override
    public WorkoutDTO apply(Workout workout) {
        return new WorkoutDTO(workout.getId(), workout.getName(), workout.getCreatedBy(), workout.getCreatedAt(), workout.getExercises().stream().map(exerciseDTOMapper).toList());
    }
}
