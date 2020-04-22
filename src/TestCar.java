import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCar {

    //Создать класс  описывающий работу автомобилей.
    //	Характеристики автомобиля:
    //Максимальная скорость.
    //Текущая скорость
    //Объем топливного бака
    //Текущее количество топлива
    //Автомобиль начинает набирает скорость при нажатии педали газа, каждое нажатие педали газа тратит топливо из бака равное текущей скорости.
    //Скорость не может быть больше максимальной. При максимальной скорости топливо при нажатии педали тратится, но скорость не увеличивается.
    //При нажатии педали тормоза, скорость автомобиля уменьшается на 1.  При тормажении топливо не тратится. Скорость не может быть меньше 0.
    //Должна быть возможность заправить машину.
    //Если топливо закончилось, скорость машины становится 0.
    //Протестировть с помощью JUnit

    @Test
    public void testSpeedZeroPressingBrakePedal(){
        Car car = new Car();
        car.setCurrentFuelQuantity(20);
        car.setCurrentSpeedCar(0);

        car.pressingBrakePedal();
        int result = car.getCurrentSpeedCar();
        assertEquals(0, result);
    }

    @Test
    public void testSpeedPressingBrakePedal(){
        Car car = new Car();
        car.setCurrentFuelQuantity(20);
        car.setCurrentSpeedCar(20);

        car.pressingBrakePedal();
        int result = car.getCurrentSpeedCar();
        assertEquals(19, result);
    }

    //Автомобиль начинает набирает скорость при нажатии педали газа, каждое нажатие педали газа тратит топливо из бака равное текущей скорости.
    @Test
    public void testStartDriveSpeed(){
        Car car = new Car();
        car.setCurrentFuelQuantity(100);
        car.setCurrentSpeedCar(20);

        car.pressingAcceleratorPedal();
        int result = car.getCurrentFuelQuantity();
        assertEquals(80, result);
    }

    @Test
    public void testStartDriveFluent(){
        Car car = new Car();
        car.setCurrentFuelQuantity(100);
        car.setCurrentSpeedCar(20);

        car.pressingAcceleratorPedal();
        int result = car.getCurrentSpeedCar();
        assertEquals(21, result);
    }

    //Если топливо закончилось, скорость машины становится 0.
    @Test
    public void testDriveEndFluent(){
        Car car = new Car();
        car.setCurrentFuelQuantity(5);
        car.setCurrentSpeedCar(20);

        car.pressingAcceleratorPedal();
        int result = car.getCurrentSpeedCar();
        assertEquals(0, result);
    }

    @Test
    public void testDriveEndFluent1(){
        Car car = new Car();
        car.setCurrentFuelQuantity(20);
        car.setCurrentSpeedCar(20);

        car.pressingAcceleratorPedal();
        int result = car.getCurrentSpeedCar();
        assertEquals(21, result);
    }

    @Test
    public void testDriveEndFluent2(){
        Car car = new Car();
        car.setCurrentFuelQuantity(20);
        car.setCurrentSpeedCar(20);

        car.pressingAcceleratorPedal();
        int result = car.getCurrentFuelQuantity();
        assertEquals(0, result);
    }

    //Должна быть возможность заправить машину.
    @Test
    public void testFueling(){
        Car car = new Car();
        car.setCurrentFuelQuantity(100);
        car.setCurrentSpeedCar(20);

        car.fillingCar(5);
        int result = car.getCurrentFuelQuantity();
        assertEquals(105, result);
    }

    @Test
    public void testFuelingMax(){
        Car car = new Car();
        car.setCurrentFuelQuantity(195);
        car.setCurrentSpeedCar(20);

        car.fillingCar(10);
        int result = car.getCurrentFuelQuantity();
        assertEquals(200, result);
    }
}
