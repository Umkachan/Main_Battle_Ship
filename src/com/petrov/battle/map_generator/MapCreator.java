package com.petrov.battle.map_generator;


import com.petrov.battle.models.Ship;

public interface MapCreator {

    void inint();
    void reset();
    Ship[] generateShipsArray();

}
