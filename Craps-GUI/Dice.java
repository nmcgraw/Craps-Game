import javax.swing.*;
import java.awt.*;

public class Dice extends JPanel{

	public int position, number;
	
	public Dice(int x){
		number = x;
		setSize(300, 300);
		setBackground(Color.white);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (number == 1){
			g.fillOval(125, 125, 50, 50);
		} else if (number == 2){
			g.fillOval(50, 50, 50, 50);
			g.fillOval(200, 200, 50, 50);
		} else if (number == 3){
			g.fillOval(50, 50, 50, 50);
			g.fillOval(200, 200, 50, 50);
			g.fillOval(125, 125, 50, 50);
		} else if (number == 4){
			g.fillOval(50, 50, 50, 50);
			g.fillOval(200, 200, 50, 50);
			g.fillOval(200, 50, 50, 50);
			g.fillOval(50, 200, 50, 50);
		} else if (number == 5){
			g.fillOval(50, 50, 50, 50);
			g.fillOval(200, 200, 50, 50);
			g.fillOval(125, 125, 50, 50);
			g.fillOval(200, 50, 50, 50);
			g.fillOval(50, 200, 50, 50);
		} else{
			g.fillOval(50, 50, 50, 50);
			g.fillOval(200, 200, 50, 50);
			g.fillOval(200, 50, 50, 50);
			g.fillOval(50, 200, 50, 50);
			g.fillOval(125, 50, 50, 50);
			g.fillOval(125, 200, 50, 50);
		}
		for (int i = 0; i < 5; i++){
			g.drawLine(0, 0+i, 300, 0+i);
			g.drawLine(0, 300-i, 300, 300-i);
			g.drawLine(0+i, 0, 0+i, 300);
			g.drawLine(300-i, 0, 300-i, 300);
		}
	}
}
