package com.springboot.workoutrack.set;

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
        Set set = setRepository.getReferenceById(id);
        return this.setDTOMapper.apply(set);
    }

    public SetDTO createSet(Set set) {
        return this.setDTOMapper.apply(setRepository.save(set));
    }

    public Boolean deleteById(Long id) {
        setRepository.deleteById(id);
        return TRUE;
    }

    public SetDTO updateSetById(Long id, Set newSet){
        Set set = setRepository.getReferenceById(id);
        set.setRepetition(newSet.getRepetition());
        set.setRest(newSet.getRest());
        set.setWeight(newSet.getWeight());
        return this.setDTOMapper.apply(setRepository.save(set));
    }

}
