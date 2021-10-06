public class Horse extends Tamagotchi{

    String horseSound = "neif....neif....neif";

    public Horse(String name) {
        super(name);
    }

    public void rideHorse(String nameOfAnimal, String usersChoiceOfAnimal, String activityForTamagotchi, Tamagotchi animalCreatedByUser){
        //for riding with horse energy can't be 0 and dirtiness and hungriness can't be 10 out of 10
        // if everything ok, start riding, else check what is missing
        if (animalCreatedByUser.hungriness != 10 && animalCreatedByUser.dirtiness  != 10 && animalCreatedByUser.energy != 0) {
            System.out.println(Images.horseImages.get(activityForTamagotchi));
            setEnergy("-", 8);
            setHungriness("+", 8);
            setDirtiness("+", 8);
            System.out.println(animalCreatedByUser);
        } else {
            Game.checkHungrinessAndRecommendFeeding(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
            Game.checkDirtinessAndRecommendCleaning(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
            Game.checkEnergyAndRecommendSleeping(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
        }
    }

    @Override
    public void makeNoise() {
        //make specific cat sound
        System.out.println(this.horseSound);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "horseSound='" + horseSound + '\'' +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", dirtiness=" + dirtiness +
                ", hungriness=" + hungriness +
                '}';
    }
}
