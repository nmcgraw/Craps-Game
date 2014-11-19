import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.Random;

public class Game {

	public static int dollars, maxDollars, bet, dice1, dice2, point = 0;
	public static final int INITIAL_DOLLARS = 50;
	public static Random generator = new Random();
	public static int richTurns = 0;
	public static int turns = 0;
	public static boolean score = true;
	public static String good[] = new String[5];
	public static String bad[] = new String[5];
	public static final JLabel messageLabel = new JLabel("");
	
	public static void main(String[] args){
		JFrame theGUI = new JFrame("Craps");
		JLabel instructions = new JLabel("To start the game, place a bet and click Start:");
		final JTextField investmentField = new JTextField(4);
		final JButton startButton = new JButton("Start");
		final JButton rollButton = new JButton("Roll Dice");
		final JButton endGameButton = new JButton("End Game");
		rollButton.setEnabled(false);
		endGameButton.setEnabled(false);
		Container pane = theGUI.getContentPane();
		pane.setLayout(new GridLayout(3, 2));
		pane.add(instructions);
		pane.add(investmentField);
		pane.add(startButton);
		pane.add(rollButton);
		pane.add(messageLabel);
		pane.add(endGameButton);
		theGUI.setSize(700, 200);
		theGUI.setVisible(true);
		good[0] = "Hmm...not too shabby, thickskull.";
		good[1] = "Heh. A few Washingtons won't hurt.";
		good[2] = "I'll get those four dollars back in the next four turns.";
		good[3] = "Eh, I have to let you win SOME of the time, right?";
		good[4] = "Go on. Take it. It will do you SO much good in life.";
		bad[0] = "Hit me up please.";
		bad[1] = "Account transfer: your wallet to mine.";
		bad[2] = "So you're gonna just keep giving me free money?";
		bad[3] = "I roll 'em you fold 'em.";
		bad[4] = "What's that? Someone has lunch money?";
		startButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if (e.getButton() == MouseEvent.BUTTON1){
					if (Integer.parseInt(investmentField.getText()) > 0){
						investmentField.setEnabled(false);
						bet = Integer.parseInt(investmentField.getText());
						dollars = INITIAL_DOLLARS;
						maxDollars = dollars;
						investmentField.setText("Bet: $" + bet);
						startButton.setEnabled(false);
						rollButton.setEnabled(true);
						endGameButton.setEnabled(true);
						turns = 0;
						richTurns = 0;
					} else{
						JOptionPane.showMessageDialog(null, "ERROR: Please enter a natural-number pot value.");
					}
				}
			}
		});
		endGameButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if (e.getButton() == MouseEvent.BUTTON1){
					if (dollars >= maxDollars){
						int difference = dollars - INITIAL_DOLLARS;
						String diffStr = Integer.toString(difference);
						String dollarStr = Integer.toString(dollars);
						if (difference == 0){
							JOptionPane.showMessageDialog(null, "You earned nothing after " + turns + " turns. You might as well have" + "\nnot played this game to begin with.");
						} else{
							JOptionPane.showMessageDialog(null, "Congratulations! After " + turns + " turns you escaped with $" + dollarStr + "," + "\na net profit of $" + diffStr + "!");
						}
					} else{
						int difference = INITIAL_DOLLARS - dollars;
						String diffStr = Integer.toString(difference);
						String dollarStr = Integer.toString(dollars);
						JOptionPane.showMessageDialog(null, "After " + turns + " turns you left with $" + dollarStr + ", a net loss of" + "\n$" + diffStr + ". You let the system beat you out" + "\nof your money! You should have" + "\nleft after " + richTurns + " turns when you had $" + maxDollars + ".");
					}
					investmentField.setText("");
					investmentField.setEnabled(true);
					endGameButton.setEnabled(false);
					startButton.setEnabled(true);
					rollButton.setEnabled(false);
					messageLabel.setText("");
				}
			}
		});
		rollButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if (e.getButton() == MouseEvent.BUTTON1){
					int die1 = generator.nextInt(6) + 1;
					int die2 = generator.nextInt(6) + 1;
					if (score == false){
						pointRoll(point);
					} else {
						if (die1 + die2 == 7 || die1 + die2 == 11){
							dollars += bet;
							messageLabel.setText(good[generator.nextInt(5)]);
						} else if (die1 + die2 == 2 || die1 + die2 == 3 || die1 + die2 == 12){
							dollars -= bet;
							messageLabel.setText(bad[generator.nextInt(5)]);
						} else {
							messageLabel.setText("Roll again. Your point is " + (die1 + die2) + ".");
							score = false;
							point = die1 + die2;
						}
						JFrame diceFrame = new JFrame("Dice Roll");
						Dice dice1 = new Dice(die1);
						Dice dice2 = new Dice(die2);
						diceFrame.setSize(620, 350);
						Container pane1 = diceFrame.getContentPane();
						pane1.setLayout(new GridLayout(1, 2));
						pane1.add(dice1);
						pane1.add(dice2);
						diceFrame.setVisible(true);
					}
					turns++;
					if (dollars > maxDollars){
						maxDollars = dollars;
						richTurns = turns;
					}
				}
			}
		});
	}
	
	public static void pointRoll(int pt){
		dice1 = generator.nextInt(6) + 1;
		dice2 = generator.nextInt(6) + 1;
		int roll = dice1 + dice2;
		JFrame diceFrame = new JFrame("Dice Roll");
		Dice dice1panel = new Dice(dice1);
		Dice dice2panel = new Dice(dice2);
		diceFrame.setSize(620, 350);
		Container pane1 = diceFrame.getContentPane();
		pane1.setLayout(new GridLayout(1, 2));
		pane1.add(dice1panel);
		pane1.add(dice2panel);
		diceFrame.setVisible(true);
		if (roll == pt){
			dollars += bet;
			score = true;
			messageLabel.setText(good[generator.nextInt(5)]);
		} else if (roll == 7){
			dollars -= bet;
			score = true;
			messageLabel.setText(bad[generator.nextInt(5)]);
		}
	}
}
