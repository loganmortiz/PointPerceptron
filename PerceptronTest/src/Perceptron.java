import java.util.*;

public class Perceptron {
	
	double[] multiples = new double[2];
	private double learningRate = 0.005;
	
	public Perceptron() {
		
		Random rng = new Random();
		for (int i = 0;i < multiples.length;i++) {
			int ranInt = rng.nextInt();
			if (ranInt >= 0)
				ranInt = 1;
			else
				ranInt = -1;
			multiples[i] = ranInt;
		}
	}
	
	public int guess(double[] inputs) {
		
		float sum = 0;
		
		
		for(int i = 0;i < multiples.length;i++)
			sum += inputs[i]*multiples[i];
		
		int output;
		
		//activation function
		if (sum >= 0)
			output = 1;
		else
			output = -1;
		
		
		return output;
	}
	
	public void train(double[] inputs, int target) {
		int guess = guess(inputs);
		int error = target - guess;
		
		for (int i = 0; i < multiples.length; i++) {
			multiples[i] += error*inputs[i]*learningRate;
		}
	}
}
