package com.springboot.workoutrack.set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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

    public Set createSet(Set set) {
        return setRepository.save(set);
    }
}
