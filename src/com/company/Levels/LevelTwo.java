package com.company.Levels;

import com.company.Assets.Brute;
import com.company.Assets.Ally;
import com.company.Assets.Knight;
import com.company.Assets.Player;
import com.company.KeyFunctions.SleepFunction;

import java.util.Scanner;


// At present this is just a placeholder
public class LevelTwo
{
    private final Player player1 = Introduction.player1;
    private final Ally garth = LevelOne.garth;
    private final String constantChoices = LevelOne.constantChoices;
    private boolean undecided = true;

    private void stayOnRoad(){
        SleepFunction.sleep();
        System.out.printf("%s and %s stay on the road when suddenly you are confronted by a dark knight!!\n", player1.character, garth.character);
        Knight darkKnight = new Knight(80, 1);
        SleepFunction.sleep();
        System.out.printf("%s: 'I have finally found you %s, and your brother too, prepare to die, for the kingdom.'\n",
                darkKnight.nameChoices.get(0), player1.character);
        SleepFunction.sleep();
        System.out.println("You know that this is going to be a hard fight, good luck!\n");
        SleepFunction.sleep();
        darkKnight.fight();
        player1.weapons.put("Greatsword (SW)", 10);
        player1.removeItemFromHashMap("Broken Sword (SW)", player1.weapons);
    }

    private void intoWoods(){
        return;
    }

    private void deathValley(){
        System.out.println("The road that you are on is very gloomy and all around an ominous presence makes itself known...\n");
        SleepFunction.sleep();
        System.out.printf("%s: 'I'm not sure that this is the way to the wizards cove you know %s, I feel as though we\n" +
                "may be in trouble if we don't get off the road soon.'\n\n", garth.character, player1.genderSiblingStatus);
        SleepFunction.sleep();
        System.out.printf("What do you do?\n%s\nS - stay on the road\nW - Go into the woods\n", constantChoices);
        Scanner choice2 = new Scanner(System.in);
        String decision2 = choice2.nextLine();
        undecided = true;
        while (undecided) {
            switch (decision2) {
                case "U":
                    player1.useItem();
                    return;
                case "C":
                    player1.checkStatus();
                    return;
                case "S":
                    undecided = false;
                    stayOnRoad();
                    break;
                case "W":
                    undecided = false;
                    intoWoods();
                    break;
                default:
                    System.out.println("Enter a valid option.");
            }
        }
    }

    private void wizardsCove(){
        System.out.println("Congratulations! You won the game!!!");
        System.exit(0);
    }

    public void startGame()
    {
        /*
        System.out.printf("%s: '%s, luckily for you i want to help you!', %s winks at you\n", garth.character, player1.character, garth.character);
        SleepFunction.sleep();
        Brute barBrute = new Brute(40, 1);
        System.out.printf("%s: 'Oi you two! I heard your conversation, get ready to get battered!'\n", barBrute.nameChoices.get(0));
        SleepFunction.sleep();
        System.out.printf("%s: 'I'll help you %s!'\n", garth.character, player1.character);
        // barBrute.fight();
        System.out.printf("%s: 'Well fought, %s! Look, i know you want to assassinate king Hammond the wise,\n" +
                "and it has been our duty ever since the death of our father, Cameroono Baggis\n" +
                "but you know that you will never defeat him on your own!'\n", garth.character, player1.genderSiblingStatus);
        player1.isSober = true;
        SleepFunction.levelEnd();
        System.out.printf("%s: 'Look, lets get out of Bagbottom for now, we're still going to\n" +
                "need some help, we should seek out a friend of mine, called Grimbo Reeves\n" +
                "a powerful wizard, who will certainly help us on our quest!'\n\n", garth.character);
        SleepFunction.levelEnd();
        System.out.printf("You and %s flee glarbog, on the road together you reach a fork in the road...\n", garth.character);
        SleepFunction.sleep();
        */
        System.out.printf("A signpost offers 2 directions, going west is a sign denoting 'wizards \n" +
                "cove' and to the east is 'death valley'\n" +
                "\nWhat do you do?\n%s\nW - Head to wizards cove\nD - Head to death valley\n", constantChoices);
        SleepFunction.sleep();
        Scanner choice1 = new Scanner(System.in);
        String decision1 = choice1.nextLine();
        String direction = decision1.equals("D") ? "wizards cove!\n" : "death valley!\n";
        String tricked = "Unbeknownst to you and Garth, an evil phorlag has flipped the signpost leading you in the opposite\n" +
                "direction to where was intended! You're now going to ";
        SleepFunction.sleep();
        while (undecided) {
            switch (decision1) {
                case "U":
                    player1.useItem();
                    break;
                case "C":
                    player1.checkStatus();
                    break;
                case "D":
                    undecided = false;
                    System.out.println(tricked + direction);
                    wizardsCove();
                    break;
                case "W":
                    undecided = false;
                    System.out.println(tricked + direction);
                    deathValley();
                    break;
                default:
                    System.out.println("Enter a valid option.");
                    return;
            }
        }

        SleepFunction.sleep();
    }
}
