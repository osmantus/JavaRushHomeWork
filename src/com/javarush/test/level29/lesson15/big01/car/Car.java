package com.javarush.test.level29.lesson15.big01.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers)
    {
        Car createdCar = null;
        if (type == TRUCK)
            createdCar = new Truck(numberOfPassengers);
        else if (type == SEDAN)
            createdCar = new Sedan(numberOfPassengers);
        else if (type == CABRIOLET)
            createdCar = new Cabriolet(numberOfPassengers);
        return createdCar;
    }

    public void fill(double numberOfLiters) throws Exception
    {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd)
    {
        double consumption = 0;
        if (isSummer(date, SummerStart, SummerEnd))
            consumption = getSummerConsumption(length);
        else
            consumption = getWinterConsumption(length);
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;

        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0)
            fastenPassengersBelts();
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public boolean isSummer(Date date, Date summerStart, Date summerEnd)
    {
        if (date.before(summerStart) || date.after(summerEnd))
            return false;
        else
            return true;
    }

    public double getWinterConsumption(int length)
    {
        double consumption = length * winterFuelConsumption + winterWarmingUp;
        return consumption;
    }

    public double getSummerConsumption(int length)
    {
        double consumption = length * summerFuelConsumption;
        return consumption;
    }

    private boolean canPassengersBeTransferred()
    {
        if (isDriverAvailable() && fuel > 0)
            return true;
        else
            return false;
    }
}
