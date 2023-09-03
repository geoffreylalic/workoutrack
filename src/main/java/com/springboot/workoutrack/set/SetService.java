package com.springboot.workoutrack.set;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
@Transactional
public class SetService {
    private final SetRepository setRepository;

    @Autowired
    public SetService(SetRepository setRepository) {
        this.setRepository = setRepository;
    }

    public List<Set> getSets() {
        List<Set> sets = setRepository.findAll();
        if (sets.isEmpty()) {
            return new ArrayList<Set>();
        }
        return sets;
    }

    public Set getSetById(Long id) {
        return setRepository.getById(id);
    }

    public Set createSet(Set set) {
        return setRepository.save(set);
    }

    public Boolean deleteById(Long id) {
        setRepository.deleteById(id);
        return TRUE;
    }

    public Set save(Set set) {
        return setRepository.save(set);
    }
}
