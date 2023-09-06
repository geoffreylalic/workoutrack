package com.springboot.workoutrack.exercise;

import com.springboot.workoutrack.set.SetDTO;

import java.util.List;

public record ExerciseDTO(
        Long id,
        String name,
        String target_muscle,
        List<SetDTO> sets) {

}
