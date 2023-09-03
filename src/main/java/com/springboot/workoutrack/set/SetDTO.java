package com.springboot.workoutrack.set;

import java.time.Duration;

public record SetDTO(
        Long id,
        Integer repetition,
        Float weight,
        Duration rest) {

}


