public class Tamagotchi {
    public String name;
    public int energy = 10;
    public int dirtiness= 0;
    public int hungriness= 0;

    public Tamagotchi(String name) {
        this.name = name;
    }

    public void play(String usersChoiceOfAnimal, String activityForTamagotchi){
        System.out.println(this.name + " is playing!!!");
        Images.getImage(usersChoiceOfAnimal, activityForTamagotchi); //print specific animal's playing image
        setEnergy("-", 5);//play will reduce energy by 1
        setDirtiness("+", 5); //play will increase dirtiness by 1
        setHungriness("+", 9);//play will increase hungriness by 1
    }

    public void feed(String usersChoiceOfAnimal, String activityForTamagotchi){
        Images.getImage(usersChoiceOfAnimal, activityForTamagotchi); //print specific animal's feeding image
        setHungriness("-", 10); // feed will reduce hungriness value by 10
    }

    public void clean(String usersChoiceOfAnimal, String activityForTamagotchi){
        System.out.println(this.name + " is taking a hot shower!!!");
        Images.getImage(usersChoiceOfAnimal, activityForTamagotchi); //print specific animal's cleaning image
        setDirtiness("-", 10); //clean will reduce dirtiness value by 10

    }

    public void sleep(String usersChoiceOfAnimal, String activityForTamagotchi){
        System.out.println(this.name + " is sleeping zzzzzz. Do not disturb!");
        Images.getImage(usersChoiceOfAnimal, activityForTamagotchi); //print specific animal's sleeping  image
        setEnergy("+", 10); //sleep will increase energy value by 10
    }

    public void makeNoise(){
        System.out.println("meow...wuff....Neigh"); // make a general sound if specific animals sound is not defined
    }

    public void setHungriness(String plusOrMinus, int value){
        //method will increase or reduce hungriness based on user input
        if (plusOrMinus.equals("+")) {
            this.hungriness = this.hungriness + value;
            if (this.hungriness >10) { //make sure hungriness don't go over 10, as 10 is the highest value for hungriness
                this.hungriness = 10;
            }
        } else if (plusOrMinus.equals("-")) {
            this.hungriness = this.hungriness - value;
            if (hungriness < 0 ) { //make sure hungriness don't go below 0, as 0 is the lowest value for hungriness
                this.hungriness = 0;
            }
        }
    }

    public void setEnergy(String plusOrMinus, int value){
        // increase or decrease energy value based on user input
        if (plusOrMinus.equals("+")) {
            this.energy = this.energy + value;
            if (this.energy > 10) { //make sure energy level don't go over 10, as 10 is the highest value for energy
                this.energy = 10;
            }
        } else if (plusOrMinus.equals("-")) {
            this.energy = this.energy - value;
            if (this.energy < 0) { //make sure energy level don't go below 0, as 0 is the lowest value for energy
                this.energy = 0;
            }
        }
    }

    public void setDirtiness(String plusOrMinus, int value){
        //increase or decrease dirtiness value based on user input
        if (plusOrMinus.equals("+")) {
            this.dirtiness = this.dirtiness + value;
            if (this.dirtiness > 10) {//make sure dirtiness don't go over 10, as 10 is the highest value for dirtiness
                this.dirtiness = 10;
            }
        } else if (plusOrMinus.equals("-")) {
            this.dirtiness = this.dirtiness - value;
            if (this.dirtiness < 0) { //make sure dirtiness don't go below 0, as 0 is the lowest value for hungriness
                this.dirtiness = 0;
            }
        }
    }


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
