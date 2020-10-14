package com.petrov.battle.map_generator;

import com.petrov.battle.models.Ship;
import com.petrov.battle.ship_generator.ShipPlant;
import com.petrov.battle.ship_generator.ShipsType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapGenerator implements MapCreator {

    private ShipPlant shipPlant;
    private Map<ShipsType, Integer> shipsCounter;
    public int totalShipCount;
    private Ship[] array;

    public MapGenerator(ShipPlant _plant) {

        shipPlant = _plant;
        inint();
    }

    public void inint() {

        fillShipsCounter();
        totalShipCount = checkShipCounterIsEmpty();
        array = new Ship[totalShipCount];
    }

    private void fillShipsCounter() {

        shipsCounter = new HashMap<>();
        shipsCounter.put(ShipsType.Small, 4);
        shipsCounter.put(ShipsType.Middle, 3);
        shipsCounter.put(ShipsType.Large, 2);
        shipsCounter.put(ShipsType.ExtraLarge, 1);
    }

    public void reset() {

        inint();
    }

    public Ship[] generateShipsArray() {

        var isDo = true;

        while (isDo) {

            for (int i = 0; i < array.length; i++) {
                var shipType = selectShip();

                if (totalShipCount == -1) {
                    isDo = false;
                    break;
                }

                if (shipType != ShipsType.None) {

                    array[i] = shipPlant.createShip(shipType);
                }
            }
        }
        return array;
    }

    private ShipsType selectShip() {

        int shipTypeCount = ShipsType.values().length;
        var minCount = 0;
        var diff = shipTypeCount - minCount;

        var random = new Random();
        int randomNumber = random.nextInt(diff + 1);

        ShipsType shipType = selectShipType(randomNumber);

        return shipType;
    }

    private ShipsType selectShipType(int randomNumber) {

        var shipType = ShipsType.None;

        int availableToCreate = checkShipCounterIsEmpty();
        int noShips = -1;

        if (availableToCreate == noShips) {

            totalShipCount = availableToCreate;
            return shipType;
        }

        for (var type : ShipsType.values()) {

            if (type.getShipNumber == randomNumber) {

                boolean isSearching = checkAvilable(type);

                if (!isSearching) {

                    shipType = type;
                    int currentValue = shipsCounter.get(shipType);
                    currentValue = --currentValue;
                    shipsCounter.put(shipType, currentValue);
                    return shipType;
                }
            }
        }
        shipType = selectAnyShip();

        return shipType;
    }

    private ShipsType selectAnyShip() {

        for (Map.Entry<ShipsType, Integer> element : shipsCounter.entrySet()) {

            var internalType = element.getKey();
            int value = element.getValue();

            if (value != 0) {

                value = --value;
                shipsCounter.put(internalType, value);
                return internalType;
            }
        }
        return ShipsType.None;
    }

    private int checkShipCounterIsEmpty() {

        int shipCount = 0;

        for (var element : shipsCounter.values()) {

            shipCount += element;
        }

        if (shipCount == 0) {

            return ShipsType.None.getShipNumber;
        }

        return shipCount;
    }

    private boolean checkAvilable(ShipsType shipType) {

        int countResult = shipsCounter.get(shipType);

        if (countResult == 0) {
            return true;
        }
        return false;
    }
}
