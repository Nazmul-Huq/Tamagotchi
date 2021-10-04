public class Tamagotchi {
    public String name;
    public int energy = 10;
    public int dirtiness= 0;
    public int hungriness= 0;
    //public String[] images = new String[5];

    public Tamagotchi(String name) {
        this.name = name;
    }

    /*
    * play with your animal.
    * Everytime you play with animal it will reduce energy by 1, increase dirtiness and hungriness by 1
    */
    public void play(String usersChoiceOfAnimal, String activityForTamagotchi){
        System.out.println(this.name + " is playing!!!");
        Images.getImage(usersChoiceOfAnimal, activityForTamagotchi);
        //System.out.println(Images.dogImages.get(1));
        setEnergy("-", 5);
        setDirtiness("+", 5); //***** will need to change value to 1 before final submission
        setHungriness("+", 9);//***** will need to change value to 1 before final submission
    }

    public void feed(String usersChoiceOfAnimal, String activityForTamagotchi){
        Images.getImage(usersChoiceOfAnimal, activityForTamagotchi);
        setHungriness("-", 10);
    }

    public void clean(String usersChoiceOfAnimal, String activityForTamagotchi){
        System.out.println(this.name + " is taking a hot shower!!!");
        Images.getImage(usersChoiceOfAnimal, activityForTamagotchi);
        setDirtiness("-", 10);

    }

    public void sleep(String usersChoiceOfAnimal, String activityForTamagotchi){
        System.out.println(this.name + " is sleeping zzzzzz. Do not disturb!");
        Images.getImage(usersChoiceOfAnimal, activityForTamagotchi);
        setEnergy("+", 10);
    }

    public void setHungriness(String plusOrMinus, int value){
        if (plusOrMinus.equals("+")) {
            this.hungriness = this.hungriness + value;
            if (this.hungriness >10) {
                this.hungriness = 10;
            }
        } else if (plusOrMinus.equals("-")) {
            this.hungriness = this.hungriness - value;
            if (hungriness < 0 ) {
                this.hungriness = 0;
            }
        }
    }

    public void setEnergy(String plusOrMinus, int value){
        if (plusOrMinus.equals("+")) {
            this.energy = this.energy + value;
            if (this.energy > 10) {
                this.energy = 10;
            }
        } else if (plusOrMinus.equals("-")) {
            this.energy = this.energy - value;
            if (this.energy < 0) {
                this.energy = 0;
            }
        }
    }

    public void setDirtiness(String plusOrMinus, int value){
        if (plusOrMinus.equals("+")) {
            this.dirtiness = this.dirtiness + value;
            if (this.dirtiness > 10) {
                this.dirtiness = 10;
            }
        } else if (plusOrMinus.equals("-")) {
            this.dirtiness = this.dirtiness - value;
            if (this.dirtiness < 0) {
                this.dirtiness = 0;
            }
        }
    }

    /*
    public void printImage(){
        System.out.println(this.images);
    }
*/


    @Override
    public String toString() {
        return "Tamagotchi{" +
                "name='" + name + '\'' +
                ", energy=" + energy +
                ", dirtiness=" + dirtiness +
                ", hungriness=" + hungriness +
                '}';
    }
}
