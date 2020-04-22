public class Main {
    public static void main(String [] args) {
        Car car = new Car();
        /*car.pressingAcceleratorPedal();
        car.pressingBrakePedal();
        car.pressingAcceleratorPedal();
        car.pressingBrakePedal();
        car.pressingBrakePedal();*/
       /* for (int x = 0; x < 5; x++) {
            car.pressingAcceleratorPedal();
        }*/

        for (int x = 0; x < 5; x++) {
            car.fillingCar(15);
        }
        for (int x = 0; x < 5; x++) {
            car.pressingAcceleratorPedal();
        }
    }
}
