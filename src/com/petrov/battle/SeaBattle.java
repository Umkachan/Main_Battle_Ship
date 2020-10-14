package com.petrov.battle;

import com.petrov.battle.map_generator.MapGenerator;
import com.petrov.battle.models.Ship;
import com.petrov.battle.ship_generator.ShipGenerator;

public class SeaBattle {

    public SeaBattle() {

        var shipPlant = new ShipGenerator();
        var mapGenerator = new MapGenerator(shipPlant);

        Ship[] result = mapGenerator.generateShipsArray(); //Генерация в случайной последовательности массива кораблей

        System.out.println(result);
    }

}
