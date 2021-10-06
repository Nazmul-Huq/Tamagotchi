import java.util.HashMap;

public class Dog extends Tamagotchi{
    public int dogHairSize = 0; //
    String dogSound = "wuff.......wuff.....wuff";

    //constructor to create dog only with name
    public Dog(String name) {
        super(name);
    }


    // in this game only dog go for run, therefore this method do not exist in Tamagotchi.java
    public void runWithDog(String nameOfAnimal, String usersChoiceOfAnimal, String activityForTamagotchi, Tamagotchi animalCreatedByUser){
        //for running with dog energy can't be 0 and dirtiness and hungriness can't be 10 out of 10
        // if everything ok, start running, else check what is missing
        if (animalCreatedByUser.hungriness != 10 && animalCreatedByUser.dirtiness  != 10 && animalCreatedByUser.energy != 0) {
            System.out.println(Images.dogImages.get(activityForTamagotchi));
            setEnergy("-", 5);
            setHungriness("+", 5);
            setDirtiness("+", 5);
            System.out.println(animalCreatedByUser);
        } else {
            // check what was missing to start playing and ask if player want to do that particular activity
            Game.checkHungrinessAndRecommendFeeding(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
            Game.checkDirtinessAndRecommendCleaning(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
            Game.checkEnergyAndRecommendSleeping(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
        }
    }


    @Override
    public void makeNoise() {
        //make specific dog sound
        System.out.println(this.dogSound);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogHairSize=" + dogHairSize +
                ", dogSound='" + dogSound + '\'' +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", dirtiness=" + dirtiness +
                ", hungriness=" + hungriness +
                '}';
    }
}
