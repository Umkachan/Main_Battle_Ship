package com.petrov.battle.ship_generator;

public enum ShipsType {
    None(-1),
    Small(1),
    Middle(2),
    Large(3),
    ExtraLarge(4);

    public int getShipNumber;

     ShipsType(int getShipNumber)
    {
      this.getShipNumber = getShipNumber;
    }
}
