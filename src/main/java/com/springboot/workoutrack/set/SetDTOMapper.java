package com.springboot.workoutrack.set;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class SetDTOMapper implements Function<Set, SetDTO> {
    @Override
    public SetDTO apply(Set set) {
        return new SetDTO(set.getId(),
                set.getRepetition(),
                set.getWeight(),
                set.getRest());
    }
}
