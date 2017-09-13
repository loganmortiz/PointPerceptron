import java.util.Scanner;
import javax.swing.*;

public class PerceptronTest {
	
	static Perceptron p = new Perceptron();

	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Size of Field: ");

		int width = in.nextInt();
		int height = width;
				
		System.out.println("Enter Number of Points");
		int pointSize = in.nextInt();
		
		JFrame frame = new JFrame("Click to Train");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Point[] points = new Point[pointSize];
		
		PanelPaint panel = new PanelPaint(points,width,height);
		
		for(int i = 0;i < points.length;i++) {
			points[i] = new Point(width, height);
		}
		
		//panel.paintComponent();
		
		frame.add(panel);
		
		double[] inputs = {-1, 0.5};
		int guess = p.guess(inputs);
		System.out.println(guess);
		
		
		
		frame.setVisible(true);
		
	}
}
