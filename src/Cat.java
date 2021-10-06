import java.util.HashMap;

public class Cat extends Tamagotchi{
    public int catNailSize = 0;
    String catSound = "meow.....meow.....meow";



    public Cat(String name){
        super(name);
    }

    public void playWithKittens(String nameOfAnimal, String usersChoiceOfAnimal, String activityForTamagotchi, Tamagotchi animalCreatedByUser){
        //for playing with kitten energy can't be 0 and dirtiness and hungriness can't be 10 out of 10
        // if everything ok, start playing with kitten, and adjust energy, hungriness and dirtiness by 1
        // else check what is missing
        System.out.println(Images.catImages.get(activityForTamagotchi));
        if (animalCreatedByUser.hungriness != 10 && animalCreatedByUser.dirtiness  != 10 && animalCreatedByUser.energy != 0) {
            System.out.println(Images.catImages.get(activityForTamagotchi));
            setEnergy("-", 2);
            setHungriness("+", 2);
            setDirtiness("+", 2);
            System.out.println(animalCreatedByUser);
        } else {
            Game.checkHungrinessAndRecommendFeeding(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser); //check hungriness
            Game.checkDirtinessAndRecommendCleaning(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser); //check dirtiness
            Game.checkEnergyAndRecommendSleeping(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser); // check energy
        }
    }

    @Override
    public void makeNoise() {
        //make specific cat sound
        System.out.println(this.catSound);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catNailSize=" + catNailSize +
                ", catSound='" + catSound + '\'' +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", dirtiness=" + dirtiness +
                ", hungriness=" + hungriness +
                '}';
    }
}
