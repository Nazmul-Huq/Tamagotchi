import java.awt.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

public class Game {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        String userName = getUserName(); // player name
        System.out.println("Hi " + userName + ". Welcome to Tamagotchi!"); //print greeting message
        String usersChoiceOfAnimal = "dog";
        //String usersChoiceOfAnimal = getUsersChoiceOfAnimal(userName);
        System.out.println("Ah..You like to spend some time with a " + usersChoiceOfAnimal);
        System.out.println("Give yor " + usersChoiceOfAnimal + "  a name: ");
        String nameOfAnimal = getAnimalName(); /* need to check the functionality later*/

        //create the animal based on users choice
        Tamagotchi animalCreatedByUser =  createAnimal(usersChoiceOfAnimal, nameOfAnimal);
        //Tamagotchi animalCreatedByUser =  new Dog(nameOfAnimal);
        System.out.println("Okay, here is your dog " + animalCreatedByUser.name);
        Images.getImage(usersChoiceOfAnimal, 1);

        boolean isContinueToPlay = true;
        while (isContinueToPlay){
            //int activityForTamagotchi = 2;
            int activityForTamagotchi = getActivity(animalCreatedByUser);

            //check if chosen activity is possible or not. fx, do animal have enough energy to play? is hungry or not before start feeding? etc.
            switch (activityForTamagotchi){
                case 1:
                    Images.getImage(usersChoiceOfAnimal, 1);
                    break;
                case 2: //play with animal
                    startPlaying(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                    break;
                case 3://feed
                    startFeeding(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                    break;
                case 4://clean
                    startCleaning(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                    break;
                case 5: //sleep
                    startSleeping(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                    break;
                case 6:
                    //startAnimalSpecialActivity(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);


                    //((Dog) animalCreatedByUser).runOutsideWithDog(activityForTamagotchi);
                    //((Cat) animalCreatedByUser).playOutsideWithCat(activityForTamagotchi);
                    ((Horse) animalCreatedByUser).goForRideWithHorse(activityForTamagotchi);
                default:break;
            }
            int activityTime = 1; //individual (play, feed, clean...) activity time in seconds
            activityTimeCounter(activityTime); // start a countdown timer and print countdown
            System.out.println("Type \"c\" to continue or \"q\" to quit the play");
            String quitOrPlay = scanner.nextLine();
            if(quitOrPlay.equals("c")){
                isContinueToPlay = true;
            } else if (quitOrPlay.equals("q")) {
                isContinueToPlay = false;
            }

        } // end of while "isContinueToPlay"
    } //end of main


    public static void startPlaying(String nameOfAnimal, String usersChoiceOfAnimal, int activityForTamagotchi, Tamagotchi animalCreatedByUser){
        //for playing with Tamagotchi (animal) energy can't be less than 2 and dirtiness and hungriness can't be more than 8 out of 10
        if (animalCreatedByUser.hungriness != 10 && animalCreatedByUser.dirtiness  != 10 && animalCreatedByUser.energy != 0) {
            animalCreatedByUser.play(usersChoiceOfAnimal, activityForTamagotchi);
        } else {
            checkAndRecommendActivityBeforePlay(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
        }
    }


    public static void checkAndRecommendActivityBeforePlay(String nameOfAnimal, String usersChoiceOfAnimal, int activityForTamagotchi, Tamagotchi animalCreatedByUser) {
            if (animalCreatedByUser.hungriness == 10) {
                System.out.println("I am too hungry. Need to eat first before play");
                System.out.println("Enter 3 - feed, or 0 to do other activity");
                activityForTamagotchi = scanner.nextInt();
                scanner.nextLine();
                if (activityForTamagotchi == 3) {
                    startFeeding(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                }
            } else if (animalCreatedByUser.dirtiness == 10) {
                System.out.println("I am too dirty, need to take a shower first before play");
                System.out.println("Enter 4- clean, or 0 to do other activity");
                activityForTamagotchi = scanner.nextInt();
                scanner.nextLine();
                if (activityForTamagotchi == 4) {
                    startCleaning(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                }else if(activityForTamagotchi == 0){
                    //break;
                }
            } else if (animalCreatedByUser.energy == 0) {
                System.out.println("I am too tired, need to sleep first before play");
                System.out.println("Enter 5- sleep or 0 to do other activity");
                activityForTamagotchi = scanner.nextInt();
                scanner.nextLine();
                if (activityForTamagotchi == 5) {
                    startSleeping(nameOfAnimal, usersChoiceOfAnimal, activityForTamagotchi, animalCreatedByUser);
                }
            } else if(activityForTamagotchi == 0){
            }
       // }
    }


    public static void startFeeding(String nameOfAnimal, String usersChoiceOfAnimal, int activityForTamagotchi, Tamagotchi animalCreatedByUser){
        //if animal is not hungry( hungriness level is 0) then print that feeding is not possible else start feeding by calling feed()
        if (animalCreatedByUser.hungriness == 0) {
            System.out.println("I am totally full. My current hungriness level is " + animalCreatedByUser.hungriness + " out of 10");
            System.out.println("You can choose other activity instead of \"Feeding\"");
        } else {
            animalCreatedByUser.feed(usersChoiceOfAnimal, activityForTamagotchi);
        }
    }

    public static void startCleaning(String nameOfAnimal, String usersChoiceOfAnimal, int activityForTamagotchi, Tamagotchi animalCreatedByUser) {
        //if animal is not dirty( dirtiness level is 0) then print that cleaning is not possible else start cleaning by calling clean()
        if (animalCreatedByUser.dirtiness == 0) {
            System.out.println("I am not dirty at all. My current dirtiness level is " + animalCreatedByUser.dirtiness + " out of 10");
            System.out.println("You can choose other activity instead of \"Cleaning\"");
        } else {
            animalCreatedByUser.clean(usersChoiceOfAnimal, activityForTamagotchi);
        }
    }

    public static void startSleeping(String nameOfAnimal, String usersChoiceOfAnimal, int activityForTamagotchi, Tamagotchi animalCreatedByUser) {
        //if animal is not tired( energy level is 10) then print that sleeping is not possible else start sleeping by calling sleep()
        if (animalCreatedByUser.energy == 10) {
            System.out.println("I can't sleep right now. My current energy level is " + animalCreatedByUser.energy + " out of 10");
            System.out.println("You can choose other activity instead of \"Sleeping\"");
        } else {
            animalCreatedByUser.sleep(usersChoiceOfAnimal, activityForTamagotchi);
        }
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
        /*
        Pattern pattern = Pattern.compile("[A-Za-z0-9]*");
        while (true){
            if(scanner.hasNext(pattern)){
                nameOfAnimal = scanner.next();
                break;
            } else {
                nameOfAnimal = scanner.next();
                System.out.println("You wrote " + nameOfAnimal + " but player name contains only english letter and number");
            }
        }

         */
        return nameOfAnimal;
    }

    public static int getActivity(Tamagotchi animalCreatedByUser){
        // ask user about what kind of activity he likes to do with Tamagotchi (animal), validated user input and return activity
       int activityForTamagotchi = 0;
        System.out.println("Choose an activity with " + animalCreatedByUser.name);
        System.out.println("1 - See your Tamagotchi ,2 - play, 3 - feed, 4 - clean, 5 - put in sleep");
        activityForTamagotchi = scanner.nextInt();
        scanner.nextLine();
        //activityForTamagotchi = 1;
       return activityForTamagotchi;

    }

    public static String getUserName(){
        // ask user for username, validate input and return the name
        System.out.println("Write your name (only english letter allowed)");
        String userName = "Nazmul";
        /*
        Pattern pattern = Pattern.compile("[A-Za-z]*");

        while (true){
            if(scanner.hasNext(pattern)){
                userName = scanner.next();
                break;
            } else {
                userName = scanner.next();
                System.out.println("You wrote " + userName + " but player name contains only english letter");
            }
        }
        */
        return userName;
    }

    public static String getUsersChoiceOfAnimal(String userName){
        System.out.println(userName + ": Would you like to create a Cat or Dog (write c for cat / d for dog");
        String usersChoiceOfAnimal = "cat";
        /*
        Pattern pattern = Pattern.compile("[cdCD]*");
        while (true){
            if(scanner.hasNext(pattern)){
                usersChoiceOfAnimal = scanner.next().toLowerCase(Locale.ROOT);
                break;
            } else {
                usersChoiceOfAnimal = scanner.next();
                System.out.println("You wrote " + usersChoiceOfAnimal + " but only c/d allowed");
            }
        }
        */
        return usersChoiceOfAnimal;
    }

    public static void activityTimeCounter(int activityTimeInSeconds) {
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
