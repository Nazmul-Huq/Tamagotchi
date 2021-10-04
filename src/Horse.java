public class Horse extends Tamagotchi{

    public Horse(String name) {
        super(name);
    }

    public void goForRideWithHorse(int activityForTamagotchi){
        System.out.println(Images.horseImages.get(activityForTamagotchi));
        setEnergy("-", 10);
    }
}
