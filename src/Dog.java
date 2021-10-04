import java.util.HashMap;

public class Dog extends Tamagotchi{
    public int dogHairSize = 0; //

    //constructor to create dog only with name
    public Dog(String name) {
        super(name);
    }


    // in this game only dog go for run, therefore this method do not exist in Tamagotchi.java
    public void runOutsideWithDog(int activityForTamagotchi){
        System.out.println(Images.dogImages.get(activityForTamagotchi));
        setEnergy("-", 10);
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
