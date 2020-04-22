import java.util.Objects;

public class Car implements ServiceCar{
    private final int MAX_SPEED = 180;
    private final int MIN_SPEED = 0;
    private final int FUEL_VOLUME_TANK = 200;
    private int currentSpeedCar = 0;
    private int currentFuelQuantity = 200;

    public int getMAX_SPEED() {
        return MAX_SPEED;
    }

    public int getMIN_SPEED() {
        return MIN_SPEED;
    }

    public int getFUEL_VOLUME_TANK() {
        return FUEL_VOLUME_TANK;
    }

    public int getCurrentSpeedCar() {
        return currentSpeedCar;
    }

    public void setCurrentSpeedCar(int currentSpeedCar) {
        this.currentSpeedCar = currentSpeedCar;
    }

    public int getCurrentFuelQuantity() {
        return currentFuelQuantity;
    }

    public void setCurrentFuelQuantity(int currentFuelQuantity) {
        this.currentFuelQuantity = currentFuelQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return MAX_SPEED == car.MAX_SPEED &&
                MIN_SPEED == car.MIN_SPEED &&
                FUEL_VOLUME_TANK == car.FUEL_VOLUME_TANK &&
                currentSpeedCar == car.currentSpeedCar &&
                currentFuelQuantity == car.currentFuelQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(MAX_SPEED, MIN_SPEED, FUEL_VOLUME_TANK, currentSpeedCar, currentFuelQuantity);
    }

    @Override
    public String toString() {
        return "Car{" +
                "MAX_SPEED=" + MAX_SPEED +
                ", MIN_SPEED=" + MIN_SPEED +
                ", FUEL_VOLUME_TANK=" + FUEL_VOLUME_TANK +
                ", currentSpeedCar=" + currentSpeedCar +
                ", currentFuelQuantity=" + currentFuelQuantity +
                '}';
    }

    @Override
    public Car pressingAcceleratorPedal() {
        int currentSpeed = getCurrentSpeedCar();
        int currentFuel = getCurrentFuelQuantity();
        boolean flag = true;

        while (flag){
            if(currentFuel>0) {
                if (currentSpeed >= getMAX_SPEED()) {
                    currentFuel = currentFuel - currentSpeed;
                    setCurrentFuelQuantity(currentFuel);
                    if (currentFuel >= 0) {
                        currentSpeed = getMAX_SPEED();
                        setCurrentSpeedCar(currentSpeed);
                        flag = false;
                        break;
                    } else {
                        setCurrentFuelQuantity(0);
                        setCurrentSpeedCar(0);
                        flag = false;
                        break;
                    }
                } else {
                    currentFuel = currentFuel - currentSpeed;
                    setCurrentFuelQuantity(currentFuel);
                    if (currentFuel >= 0) {
                        currentSpeed = currentSpeed + 1;
                        setCurrentSpeedCar(currentSpeed);
                        flag = false;
                        break;
                    } else {
                        setCurrentFuelQuantity(0);
                        setCurrentSpeedCar(0);
                        flag = false;
                        break;
                    }
                }
            }

        }
        if (currentFuel < 0) {
            setCurrentSpeedCar(0);
            setCurrentFuelQuantity(0);
            currentSpeed = getCurrentSpeedCar();
            currentFuel = getCurrentFuelQuantity();
            System.out.println("Сan't go, fuel is over. Current speed: " + getCurrentSpeedCar() + " Current fuel: " + getCurrentFuelQuantity());
            return this;
        }

        System.out.println("Go, Current speed: " + getCurrentSpeedCar() + " Current fuel: " + getCurrentFuelQuantity());
        return this;
    }

    @Override
    public Car fillingCar(int fuelQuantity) {
        if(getCurrentFuelQuantity()<200){
            setCurrentFuelQuantity(getCurrentFuelQuantity() + fuelQuantity);
                if(getCurrentFuelQuantity()<200){
                }else{
                    int fuelOverMax = getCurrentFuelQuantity() - getFUEL_VOLUME_TANK();
                    this.setCurrentFuelQuantity(getFUEL_VOLUME_TANK());
                    System.out.println("Stop! Tank full " + " overflow on: " + fuelOverMax);
                }
        }else{
            int fuelOverMax = getCurrentFuelQuantity() - getFUEL_VOLUME_TANK();
            System.out.println("Stop! Tank full " + " overflow on: " + fuelQuantity);
            setCurrentFuelQuantity(getFUEL_VOLUME_TANK());
        }
        return this;
    }

    @Override
    public Car pressingBrakePedal() {
        int currentSpeed = getCurrentSpeedCar();
        if(currentSpeed == 0){
            setCurrentSpeedCar(0);
        }else {
            setCurrentSpeedCar(currentSpeed - 1);
        }
        System.out.println("Stop, Current speed: " + getCurrentSpeedCar() + " Current fuel: " + getCurrentFuelQuantity());
        return this;
    }
}
