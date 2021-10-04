import java.util.HashMap;

public class Cat extends Tamagotchi{
    public int catNailSize = 0;



    public Cat(String name){
        super(name);
    }

    public void playOutsideWithCat(int activityForTamagotchi){
        System.out.println(Images.catImages.get(activityForTamagotchi));
    }


    @Override
    public String toString() {
        return "Cat{" +
                "catNailSize=" + catNailSize +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", dirtiness=" + dirtiness +
                ", hungriness=" + hungriness +
                '}';
    }
}
