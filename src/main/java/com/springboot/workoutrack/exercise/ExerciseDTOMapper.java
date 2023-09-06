package com.springboot.workoutrack.exercise;

import com.springboot.workoutrack.set.SetDTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class ExerciseDTOMapper implements Function<Exercise, ExerciseDTO> {
    private SetDTOMapper setDTOMapper;

    public ExerciseDTOMapper(SetDTOMapper setDTOMapper) {
        this.setDTOMapper = setDTOMapper;
    }

    @Override
    public ExerciseDTO apply(Exercise exercise) {
        return new ExerciseDTO(exercise.getId(), exercise.getName(), exercise.getTarget_muscle(), exercise.getSets().stream().map(setDTOMapper).toList());
    }
}
