import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelPaint extends JPanel{
	Point[] points;
	int w;
	int h;
	
	public PanelPaint(Point[] points1,int width, int height) {
		w = width;
		h = height;
		setPreferredSize(new Dimension(width,height));
		points = points1;
		this.addMouseListener(new MouseClick());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		for(int i = 0;i<points.length;i++) {
			if (points[i].TypeVisible())
				g.fillOval(points[i].getx(), points[i].gety(), 8, 8);
			else
				g.drawOval(points[i].getx(), points[i].gety(), 8, 8);
			
			double[] inputs = {points[i].getx(),points[i].gety()};
			int target = points[i].getType();
			int guess = PerceptronTest.p.guess(inputs);
			
			if (guess == target) {
				g.setColor(Color.GREEN);
				g.fillOval(points[i].getx(), points[i].gety(), 4, 4);
			}else {
				g.setColor(Color.RED);
				g.fillOval(points[i].getx(), points[i].gety(), 4, 4);
			}
			g.setColor(Color.BLACK);
		}
		g.drawLine(0, 0, w, h);
	}
	
	private class MouseClick implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0;i < points.length;i++) {
				double[] inputs = {points[i].getx(),points[i].gety()};
				PerceptronTest.p.train(inputs,points[i].getType());
			}
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
