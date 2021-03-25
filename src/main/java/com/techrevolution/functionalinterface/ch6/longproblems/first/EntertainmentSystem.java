package com.techrevolution.functionalinterface.ch6.longproblems.first;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
class EntertainmentSystem {
    private final List<Dvd> dvdList;
    private final List<AudioFiles> audioFilesList;
    private final List<EBooks> eBooksList;
}
