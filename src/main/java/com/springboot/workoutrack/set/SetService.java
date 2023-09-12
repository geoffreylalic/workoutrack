package com.springboot.workoutrack.set;

import com.springboot.workoutrack.exceptions.SetNotFoundException;
import com.springboot.workoutrack.exercise.Exercise;
import com.springboot.workoutrack.exercise.ExerciseDTO;
import com.springboot.workoutrack.workout.Workout;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Boolean.TRUE;

@Service
@Transactional
public class SetService {
    private final SetRepository setRepository;
    private final SetDTOMapper setDTOMapper;

    @Autowired
    public SetService(SetRepository setRepository, SetDTOMapper setDTOMapper) {
        this.setRepository = setRepository;
        this.setDTOMapper = setDTOMapper;
    }

    public List<SetDTO> getSets() {
        return setRepository.findAll().stream().map(setDTOMapper).toList();
    }

    public SetDTO getSetById(Long id) {
        return setRepository.findById(id).map(setDTOMapper).orElseThrow(()-> new SetNotFoundException("Set not found with this given id."));
    }

    public SetDTO createSet(Set set) {
        return this.setDTOMapper.apply(setRepository.save(set));
    }

    public Boolean deleteById(Long id) {
        setRepository.deleteById(id);
        return TRUE;
    }

    public SetDTO updateSetById(Long id, Set newSet) {
        Set set = setRepository.findById(id).orElseThrow(() -> new SetNotFoundException("Set not found"));
        if (newSet.getRepetition() != null){
            set.setRepetition(newSet.getRepetition());
        }if (newSet.getRest() != null){
            set.setRest(newSet.getRest());
        }if(newSet.getWeight() != null){
            set.setWeight(newSet.getWeight());
        }
        return this.setDTOMapper.apply(setRepository.save(set));
    }

}
