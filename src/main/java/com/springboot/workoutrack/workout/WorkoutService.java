package com.springboot.workoutrack.workout;

import com.springboot.workoutrack.exceptions.ExerciseNotFoundException;
import com.springboot.workoutrack.exceptions.WorkoutNotFoundException;
import com.springboot.workoutrack.exercise.*;
import com.springboot.workoutrack.set.Set;
import com.springboot.workoutrack.set.SetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class WorkoutService {
    private WorkoutRepository workoutRepository;
    private WorkoutDTOMapper workoutDTOMapper;
    private ExerciseRepository exerciseRepository;
    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository, WorkoutDTOMapper workoutDTOMapper, ExerciseRepository exerciseRepository) {
        this.workoutRepository = workoutRepository;
        this.workoutDTOMapper = workoutDTOMapper;
        this.exerciseRepository = exerciseRepository;
    }

    public List<WorkoutDTO> getWorkouts() {
        return workoutRepository.findAll().stream().map(workoutDTOMapper).toList();
    }

    public WorkoutDTO getWorkout(Long id) {
        return workoutRepository.findById(id).map(workoutDTOMapper).orElseThrow(()-> new WorkoutNotFoundException("Workout not found for this given id."));
    }

    public WorkoutDTO updateWorkout(Long id, Workout exercise){
        return workoutRepository.findById(id).map(workoutDTOMapper).orElseThrow(()-> new WorkoutNotFoundException("Workout not found for this given id."));
    }

    public WorkoutDTO createWorkout(Workout newWorkout){
        Workout workout  = workoutRepository.save(newWorkout);
        for (Exercise exercise: newWorkout.getExercises()){
            exercise.setWorkout(workout);
            exerciseRepository.save(exercise);
        }
        return workoutDTOMapper.apply(workout);
    }

    public Boolean deleteWorkout(Long id){
        try{
            workoutRepository.deleteById(id);
            return Boolean.TRUE;
        }
        catch (WorkoutNotFoundException ex){
            return Boolean.FALSE;
        }
    }
}
