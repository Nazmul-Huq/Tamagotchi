import java.util.HashMap;

public class Dog extends Tamagotchi{
    public int dogHairSize = 0; //

    //constructor to create dog only with name
    public Dog(String name) {
        super(name);
    }


    // in this game only dog go for run, therefore this method do not exist in Tamagotchi.java
    public void runWithDog(String nameOfAnimal, String usersChoiceOfAnimal, String activityForTamagotchi, Tamagotchi animalCreatedByUser){
        if (animalCreatedByUser.hungriness != 10 && animalCreatedByUser.dirtiness  != 10 && animalCreatedByUser.energy != 0) {
            System.out.println(Images.dogImages.get(activityForTamagotchi));
            setEnergy("-", 5);
            setHungriness("+", 5);
            setDirtiness("+", 5);
            System.out.println(animalCreatedByUser);
        } else {
            Game.checkAndRecommendActivityBeforePlay(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
        }
    }


    @Override
    public String toString() {
        return "Dog{" +
                "dogHairSize=" + dogHairSize +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", dirtiness=" + dirtiness +
                ", hungriness=" + hungriness +
                '}';
    }
}
