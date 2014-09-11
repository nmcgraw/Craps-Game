/**
 * 
 * @author Nick McGraw
 *
 */
import java.util.*;

public class Craps {

	private static Scanner scanner = new Scanner(System.in);
	private static int money = 50, bet, dice1, dice2, roll;
	private static Random random = new Random();
	
	public static void main(String[] args){
		System.out.print("Your initial amount is $50." + "\n" + "Enter your bet: $");
		bet = scanner.nextInt();
		roll();
	}
	
	public static void roll(){
		dice1 = random.nextInt(6) + 1;
		dice2 = random.nextInt(6) + 1;
		roll = dice1 + dice2;
		System.out.println("Your first roll is a " + roll + ".");
		if (roll == 7 || roll == 11){
			money += bet;
			System.out.println("That's a winning score. You now have $" + money + ".");
		} else if (roll == 2 || roll == 3 || roll == 12){
			money -= bet;
			System.out.println("That's a losing score. You now have $" + money + ".");
		} else {
			pointRoll(roll);
		}
		if (money > 0){
			options();
		} else {
			System.out.println("You are now broke. Thank you for investing your money with us.");
		}
	}
	
	public static void pointRoll(int point){
		dice1 = random.nextInt(6) + 1;
		dice2 = random.nextInt(6) + 1;
		roll = dice1 + dice2;
		System.out.println("You rolled a " + roll + ".");
		if (roll == point){
			money += bet;
			System.out.println("You won by re-rolling a point of " + point + " before rolling a 7. You now have $" + money + ".");
		} else if (roll == 7){
			money -= bet;
			System.out.println("You lost by rolling a 7 before re-rolling a point of " + point + ". You now have $" + money + ".");
		} else {
			pointRoll(point);
		}
	}
	
	public static void options(){
		System.out.print("Do you wish to roll again? (1) Yes or (2) No: ");
		int choice = scanner.nextInt();
		switch (choice){
		case 1:
			roll();
			break;
		case 2:
			System.out.print("You left the game with $" + money + ".");
			break;
		default:
			System.out.println("C'mon, enter 1 or 2.");
			options();
			break;
		}
	}
}
