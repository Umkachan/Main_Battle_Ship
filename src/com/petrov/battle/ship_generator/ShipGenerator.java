package com.petrov.battle.ship_generator;

import com.petrov.battle.models.*;

public class ShipGenerator implements ShipPlant {

    public Ship createShip(ShipsType shipType) {

        Ship ship = null;

        switch (shipType)
        {
            case Small: ship =  new SmallShip(); break;
            case Middle: ship = new MiddleShip(); break;
            case Large: ship = new LargeShip(); break;
            case ExtraLarge: ship = new ExtraLargeShip(); break;
        }
        return ship;
    }



}
