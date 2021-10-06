import java.awt.*;
import java.time.Clock;
import java.time.Instant;
import java.util.Locale;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

public class Game {
    static final int ACTIVITY_TIME_IN_SECONDS = 1; //individual (play, feed, clean...) activity time in seconds
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        /*
        * all images are been copied from https://www.asciiart.eu/animals .Some may have been edited a little
        * User can create either Cat, Dog or Horse
        * once user start activities with animal (Cat, Dog or Horse) activities with that animal will continue until user type q
        * after each activity user will be asked to type c to continue or q to quit
        * each activity continues 10 seconds, which is defined in the final variable (ACTIVITY_TIME_IN_SECONDS)
        *
        * user can also create a new animal but after fist quitting play with current animal, then will be asked to create new animal or exit program
         */

        String userName = getUserName(); // player name
        System.out.println("Hi " + userName + ". Welcome to Tamagotchi!"); //print greeting message
        while (true){
            String usersChoiceOfAnimal = getUsersChoiceOfAnimal(userName); // ask and get what kind of animal user like to create (Dog/Cat/horse)
            System.out.println("Ah..You like to spend some time with a " + usersChoiceOfAnimal); //just a formal message
            System.out.println("Give yor " + usersChoiceOfAnimal + "  a name: "); // ask to give the animal a name
            String nameOfAnimal = getAnimalName(); // get the name for animal

            Tamagotchi animalCreatedByUser =  createAnimal(usersChoiceOfAnimal, nameOfAnimal);//create the animal based on users choice
            System.out.println("Okay, here is your " + animalCreatedByUser.name); // give a formal introduction with name of animal
            Images.getImage(usersChoiceOfAnimal, "tamagotchisStatus"); // show the image for newly created animal

            //ask for activity and starts activities. Different activities will continue until user type quit
            while (true){
                String activityForTamagotchi = getActivity(animalCreatedByUser, usersChoiceOfAnimal); //chose an activity for created Tamagotchi
                startActivityWithTamagotchi(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser); // start activity
                activityTimeCounter(ACTIVITY_TIME_IN_SECONDS); // start a countdown timer and print countdown
                System.out.println("Type \"c\" to continue or \"q\" to quit playing with your current animal");
                String quitOrPlay = scanner.nextLine();
                if (quitOrPlay.equals("q")) { // this will quit current activities with last created animal
                    break;
                }
            }

            System.out.println("Type \"create\" to create another animal or \"exit\" to quitting the game entirely");
            String quitOrPlay = scanner.nextLine();
            if (quitOrPlay.equals("exit")) { // this will exit the game
                break;
            }
        }

    } //end of main

    public static void startActivityWithTamagotchi(String nameOfAnimal, String usersChoiceOfAnimal, String activityForTamagotchi, Tamagotchi animalCreatedByUser){
        //switch loop will decide what method to call from Tamagotchi.java to start user's choice of activity
        // first 6 cases ar default for all animal
        switch (activityForTamagotchi){
            case "tamagotchisStatus":
                seeYourTamagotichisStatus(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                break;
            case "play":
                startPlaying(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                break;
            case"feed":
                startFeeding(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                break;
            case "clean":
                startCleaning(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                break;
            case "sleep":
                startSleeping(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                break;
            case "makeNoise":
                animalCreatedByUser.makeNoise();
                break;
            case "runWithDog": // this activity is only possible for dog
                ((Dog) animalCreatedByUser).runWithDog(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                break;
            case "playWithKittens": // this activity is only possible for cat
                ((Cat) animalCreatedByUser).playWithKittens(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                break;
            case "rideHorse": // this activity is only possible for horse
                ((Horse) animalCreatedByUser).rideHorse(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                break;
            default:break;
        }
    }


    public static void startPlaying(String nameOfAnimal, String usersChoiceOfAnimal, String activityForTamagotchi, Tamagotchi animalCreatedByUser){
        //for playing with Tamagotchi (animal) energy can't be 0 and dirtiness and hungriness can't be 10 out of 10
        // if everything ok, start play, else check what is missing
        if (animalCreatedByUser.hungriness != 10 && animalCreatedByUser.dirtiness  != 10 && animalCreatedByUser.energy != 0) {
            animalCreatedByUser.play(usersChoiceOfAnimal, activityForTamagotchi);
        } else {
                checkHungrinessAndRecommendFeeding(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                checkDirtinessAndRecommendCleaning(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                checkEnergyAndRecommendSleeping(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
        }
    }

    public static void checkEnergyAndRecommendSleeping(String nameOfAnimal, String usersChoiceOfAnimal, String activityForTamagotchi, Tamagotchi animalCreatedByUser) {
        // check if there is energy shortage to start an activity, if yes, ask if user like to put his animal in sleep
        if (animalCreatedByUser.energy == 0) {
            System.out.println("I am too tired, need to sleep first before play");
            System.out.println("Enter 5- sleep or 0 to do other activity");
            int choseRecommendedActivity = scanner.nextInt();
            scanner.nextLine();
            //below method is called to convert the user's choice from integer value to original activity name (fx, from 2 to play)
            activityForTamagotchi = getUsersOriginalChoice(choseRecommendedActivity, usersChoiceOfAnimal);
            if (activityForTamagotchi.equals("sleep")) {
                startSleeping(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
            }
        }

    }
    public static void checkDirtinessAndRecommendCleaning(String nameOfAnimal, String usersChoiceOfAnimal, String activityForTamagotchi, Tamagotchi animalCreatedByUser) {
        // check if animal is too dirty to start an activity, if yes, ask if user like to start cleaning
        if (animalCreatedByUser.dirtiness == 10) {
        System.out.println("I am too dirty, need to take a shower first before play");
        System.out.println("Enter 4- clean, or 0 to do other activity");
        int choseRecommendedActivity = scanner.nextInt();
        scanner.nextLine();
        //below method is called to convert the user's choice from integer value to original activity name (fx, from 2 to play)
        activityForTamagotchi = getUsersOriginalChoice(choseRecommendedActivity, usersChoiceOfAnimal);
        if (activityForTamagotchi.equals("clean")) {
            startCleaning(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
        }
    }
    }

    public static void checkHungrinessAndRecommendFeeding(String nameOfAnimal, String usersChoiceOfAnimal, String activityForTamagotchi, Tamagotchi animalCreatedByUser) {
        // check if animal is too hungry to start an activity, if yes, ask if user like to start feeding
        if (animalCreatedByUser.hungriness == 10) {
        System.out.println("I am too hungry. Need to eat first before play");
        System.out.println("Enter 3 - feed, or 0 to do other activity");
        int choseRecommendedActivity = scanner.nextInt();
        scanner.nextLine();
        //below method is called to convert the user's choice from integer value to original activity name (fx, from 2 to play)
        activityForTamagotchi = getUsersOriginalChoice(choseRecommendedActivity, usersChoiceOfAnimal);
        if (activityForTamagotchi.equals("feed")) {
            startFeeding(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
        }
    }
    }

    public static void startFeeding(String nameOfAnimal, String usersChoiceOfAnimal, String activityForTamagotchi, Tamagotchi animalCreatedByUser){
        //if animal is not hungry( hungriness level is 0) then print that feeding is not possible else start feeding by calling feed()
        if (animalCreatedByUser.hungriness == 0) {
            System.out.println("I am totally full. My current hungriness level is " + animalCreatedByUser.hungriness + " out of 10");
            System.out.println("You can choose other activity instead of \"Feeding\"");
        } else {
            animalCreatedByUser.feed(usersChoiceOfAnimal, activityForTamagotchi);
        }
    }

    public static void startCleaning(String nameOfAnimal, String usersChoiceOfAnimal, String activityForTamagotchi, Tamagotchi animalCreatedByUser) {
        //if animal is not dirty( dirtiness level is 0) then print that cleaning is not possible else start cleaning by calling clean()
        if (animalCreatedByUser.dirtiness == 0) {
            System.out.println("I am not dirty at all. My current dirtiness level is " + animalCreatedByUser.dirtiness + " out of 10");
            System.out.println("You can choose other activity instead of \"Cleaning\"");
        } else {
            animalCreatedByUser.clean(usersChoiceOfAnimal, activityForTamagotchi);
        }
    }

    public static void startSleeping(String nameOfAnimal, String usersChoiceOfAnimal, String activityForTamagotchi, Tamagotchi animalCreatedByUser) {
        //if animal is not tired( energy level is 10) then print that sleeping is not possible else start sleeping by calling sleep()
        if (animalCreatedByUser.energy == 10) {
            System.out.println("I can't sleep right now. My current energy level is " + animalCreatedByUser.energy + " out of 10");
            System.out.println("You can choose other activity instead of \"Sleeping\"");
        } else {
            animalCreatedByUser.sleep(usersChoiceOfAnimal, activityForTamagotchi);
        }
    }

    public static void seeYourTamagotichisStatus(String nameOfAnimal, String usersChoiceOfAnimal, String activityForTamagotchi, Tamagotchi animalCreatedByUser){
        // call this method to see the current status of the animal
        Images.getImage(usersChoiceOfAnimal, activityForTamagotchi);
        System.out.println("Current Energy Level: " + animalCreatedByUser.energy);
        System.out.println("Current Dirtiness Level: " + animalCreatedByUser.dirtiness);
        System.out.println("Current Hungriness Level: " + animalCreatedByUser.hungriness);
    }

    public static Tamagotchi createAnimal(String usersChoiceOfAnimal, String nameOfAnimal){
        //create the Tamagotchi (animal) based on user choice (dog, cat....) and return the created Tamagotchi
        Tamagotchi animalCreatedByUser = new Tamagotchi("no name");
        if (usersChoiceOfAnimal.equals("dog")) {
            animalCreatedByUser =  new Dog(nameOfAnimal);
        }else if (usersChoiceOfAnimal.equals("cat")) {
            animalCreatedByUser =  new Cat(nameOfAnimal);
        }else if (usersChoiceOfAnimal.equals("horse")) {
            animalCreatedByUser =  new Horse(nameOfAnimal);
        }
        return animalCreatedByUser;
    }

    public static String getAnimalName(){
        //ask to give Tamagotchi (animal) a beautiful name, validate user input and return the name
        System.out.println("Write a beautiful name (only english letter and number allowed)");
        String nameOfAnimal = "Teddy";
        Pattern pattern = Pattern.compile("[A-Za-z0-9]*");
        while (true){
            if(scanner.hasNext(pattern)){
                nameOfAnimal = scanner.next();
                break;
            } else {
                nameOfAnimal = scanner.next();
                System.out.println("You wrote " + nameOfAnimal + " but animal name can contain only english letter and number");
            }
        }
        return nameOfAnimal;
    }

    public static String  getActivity(Tamagotchi animalCreatedByUser, String usersChoiceOfAnimal){
        // ask user about what kind of activity he likes to do with Tamagotchi (animal), validated user input and return activity
        //***** missing input validation **********
       String  activityForTamagotchi = "";
        System.out.println("Choose an activity with " + animalCreatedByUser.name);
        System.out.print("1-See animal's status, 2-play, 3-feed, 4-clean, 5-put in sleep, 6-make noise");
        if (usersChoiceOfAnimal.equals("dog")) {
            System.out.println(", 7- run with dog\n");
        } else if (usersChoiceOfAnimal.equals("cat")) {
            System.out.println(", 7- play with kitten\n");
        } else if (usersChoiceOfAnimal.equals("horse")) {
            System.out.println(", 7- ride the horse\n");
        }
        int usersChoiceOfActivity = scanner.nextInt();
        scanner.nextLine();
        //below method is called to convert the user's choice from integer value to original activity name (fx, from 2 to play)
        activityForTamagotchi = getUsersOriginalChoice(usersChoiceOfActivity, usersChoiceOfAnimal);
        return activityForTamagotchi;

    }

    public static String getUsersOriginalChoice(int usersChoiceOfActivity, String usersChoiceOfAnimal){
        //this method convert the user's choice from integer value to original activity name (fx, from 2 to play)
        String usersOriginalChoice = "";
        if (usersChoiceOfActivity == 1) {
            usersOriginalChoice = "tamagotchisStatus";
        } else if (usersChoiceOfActivity == 2) {
            usersOriginalChoice = "play";
        } else if (usersChoiceOfActivity == 3) {
            usersOriginalChoice = "feed";
        } else if (usersChoiceOfActivity == 4) {
            usersOriginalChoice = "clean";
        } else if (usersChoiceOfActivity == 5) {
            usersOriginalChoice = "sleep";
        }else if (usersChoiceOfActivity == 6) {
            usersOriginalChoice = "makeNoise";
        } else if (usersChoiceOfActivity == 7) {
            if (usersChoiceOfAnimal.equals("dog")) {
                usersOriginalChoice = "runWithDog";
            } else if (usersChoiceOfAnimal.equals("cat")) {
                usersOriginalChoice = "playWithKittens";
            }else if (usersChoiceOfAnimal.equals("horse")) {
                usersOriginalChoice = "rideHorse";
            }
        }
        return usersOriginalChoice;
    }

    public static String getUserName(){
        // ask user for username, validate input and return the name
        System.out.println("Write your name (only english letter allowed)");
        String userName = "";
        Pattern pattern = Pattern.compile("[A-Za-z]*");
        while (true){
            if(scanner.hasNext(pattern)){
                userName = scanner.next();
                break;
            } else {
                userName = scanner.next();
                System.out.println("You wrote " + userName + " but player can name contain only english letter");
            }
        }
        return userName;
    }

    public static String getUsersChoiceOfAnimal(String userName){
        //ask user about what kind of animal he likes to make, validate input, return the choice
        System.out.println(userName + ": Would you like to create a Cat Dog or Horse (write Cat, Dog, Horse)");
        String usersChoiceOfAnimal = "";
        while (true){
            usersChoiceOfAnimal = scanner.nextLine(); //******** will need to check for bug*******
            usersChoiceOfAnimal = usersChoiceOfAnimal.toLowerCase(Locale.ROOT);
            if (  (usersChoiceOfAnimal).equals("cat") || (usersChoiceOfAnimal).equals("dog") || (usersChoiceOfAnimal).equals("horse") ){
                break;
            } else {
                System.out.println("you can write only Cat, Dog or Horse)");
            }
        }
        return usersChoiceOfAnimal;

    }

    public static void activityTimeCounter(int activityTimeInSeconds) {
        // start and print a countdown timer for each activity
        System.out.print("remaining time: ");
        for (int second=activityTimeInSeconds ; second >= 0 ; second--){
            if(second !=0){
                System.out.print(second + " ");
            } else {
                System.out.println(second);
            }
            try {
                Thread.sleep((long) (1 * 1000));
            } catch (InterruptedException e) {

            }

        }

    }
} //end of game class
