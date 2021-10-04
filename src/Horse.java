public class Horse extends Tamagotchi{

    public Horse(String name) {
        super(name);
    }

    public void rideHorse(String nameOfAnimal, String usersChoiceOfAnimal, String activityForTamagotchi, Tamagotchi animalCreatedByUser){
        if (animalCreatedByUser.hungriness != 10 && animalCreatedByUser.dirtiness  != 10 && animalCreatedByUser.energy != 0) {
            System.out.println(Images.horseImages.get(activityForTamagotchi));
            setEnergy("-", 8);
            setHungriness("+", 8);
            setDirtiness("+", 8);
            System.out.println(animalCreatedByUser);
        } else {
            Game.checkAndRecommendActivityBeforePlay(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
        }
    }
}
