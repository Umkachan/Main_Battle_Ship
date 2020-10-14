package com.petrov.battle.ship_generator;

import com.petrov.battle.models.Ship;

public interface ShipPlant {

   Ship createShip(ShipsType shipType);

}
