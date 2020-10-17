package com.company;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Match {

    List<Integer> guestPoints = Arrays.asList(new Integer[240]);
    List<Integer> hostPoints = Arrays.asList(new Integer[240]);
    List<String> date = Arrays.asList(new String[240]);

}
