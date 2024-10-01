package com.sustav.ALGORITHM.pattern.creational.prototype.vehicle;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class VehicleRegistry {
    private static Map<String, Vehicle> vehicleMap = new HashMap<>();
    static {
        vehicleMap.put("TwoWheel", new TwoWheelVehicle("e", "m", BigDecimal.ONE, true));
        vehicleMap.put("FourWheel", new FourWheelVehicle("e", "m", BigDecimal.ONE, true, true));
    }

    public Vehicle getVehicle(String type) throws CloneNotSupportedException {
        return vehicleMap.get(type).clone();
    }
}
