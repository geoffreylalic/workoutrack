package com.springboot.workoutrack.exercise;

import com.springboot.workoutrack.exceptions.ExerciseNotFoundException;
import com.springboot.workoutrack.set.Set;
import com.springboot.workoutrack.set.SetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.List;

@Service
public class ExerciseService {
    private ExerciseRepository exerciseRepository;
    private ExerciseDTOMapper exerciseDTOMapper;
    private SetRepository setRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository, ExerciseDTOMapper exerciseDTOMapper, SetRepository setRepository) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseDTOMapper = exerciseDTOMapper;
        this.setRepository = setRepository;
    }

    public List<ExerciseDTO> getExercises() {
        return exerciseRepository.findAll().stream().map(exerciseDTOMapper).toList();
    }

    public ExerciseDTO getExercise(Long id) {
        return exerciseRepository.findById(id).map(exerciseDTOMapper).orElseThrow(()-> new ExerciseNotFoundException("Exercise not found for this given id."));
    }

    public ExerciseDTO updateExercise(Long id, Exercise exercise){
        return exerciseRepository.findById(id).map(exerciseDTOMapper).orElseThrow(()-> new ExerciseNotFoundException("Exercise not found for this given id."));
    }

    @Transactional
    public ExerciseDTO createExercise(Exercise newExercise){
        Exercise exercise  = exerciseRepository.save(newExercise);
        for (Set set: newExercise.getSets()){
            set.setExercise(exercise);
            setRepository.save(set);
        }
        return exerciseDTOMapper.apply(exercise);
    }

    public Boolean deleteExercise(Long id){
        try{
            exerciseRepository.deleteById(id);
            return Boolean.TRUE;
        }
        catch (ExerciseNotFoundException ex){
            return Boolean.FALSE;
        }
    }

}
