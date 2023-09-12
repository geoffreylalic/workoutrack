package com.springboot.workoutrack.exercise;

import com.springboot.workoutrack.exceptions.ExerciseNotFoundException;
import com.springboot.workoutrack.set.Set;
import com.springboot.workoutrack.set.SetRepository;
import com.springboot.workoutrack.set.SetService;
import com.springboot.workoutrack.workout.Workout;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ExerciseService {
    private ExerciseRepository exerciseRepository;
    private ExerciseDTOMapper exerciseDTOMapper;
    private SetRepository setRepository;
    private SetService setService;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository, ExerciseDTOMapper exerciseDTOMapper, SetRepository setRepository, SetService setService) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseDTOMapper = exerciseDTOMapper;
        this.setRepository = setRepository;
        this.setService = setService;
    }

    public List<ExerciseDTO> getExercises() {
        return exerciseRepository.findAll().stream().map(exerciseDTOMapper).toList();
    }

    public ExerciseDTO getExercise(Long id) {
        return exerciseRepository.findById(id).map(exerciseDTOMapper).orElseThrow(() -> new ExerciseNotFoundException("Exercise not found for this given id."));
    }

    public ExerciseDTO updateExercise(Long id, Exercise exercise) {
        Exercise foundExercise = exerciseRepository.findById(id).orElseThrow(() -> new ExerciseNotFoundException("Exercise not found for this given id."));
        if (exercise.getWorkout() != null) {
            foundExercise.setWorkout(exercise.getWorkout());
        }if (exercise.getName() != null) {
            foundExercise.setName(exercise.getName());
        }if (exercise.getTargetMuscle() != null) {
            foundExercise.setTargetMuscle(exercise.getTargetMuscle());
        }if (exercise.getSets() != null) {
            for (Set set : exercise.getSets()){
                setService.updateSetById(set.getId(), set);
            }
        }
        try {
            return exerciseDTOMapper.apply(exerciseRepository.save(foundExercise));
        } catch (ExerciseNotFoundException ex){
            throw ex;
        }
    }

    public ExerciseDTO createExercise(Exercise newExercise) {
        Exercise exercise = exerciseRepository.save(newExercise);
        for (Set set : newExercise.getSets()) {
            set.setExercise(exercise);
            setService.createSet(set);
        }
        return exerciseDTOMapper.apply(exercise);
    }

    public ExerciseDTO createExerciseWorkout(Exercise newExercise, Workout workout) {
        newExercise.setWorkout(workout);
        Exercise exercise = exerciseRepository.save(newExercise);
        for (Set set : newExercise.getSets()) {
            set.setExercise(exercise);
            setService.updateSetById(set.getId(), set);
        }
        return exerciseDTOMapper.apply(exercise);
    }

    public Boolean deleteExercise(Long id) {
        try {
            exerciseRepository.deleteById(id);
            return Boolean.TRUE;
        } catch (ExerciseNotFoundException ex) {
            return Boolean.FALSE;
        }
    }

}
