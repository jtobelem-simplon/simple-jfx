package shape.model;

import java.util.Random;

public class ShapeModel {
	
	private final Random rnd = new Random();
	
	private Position position;
	
	private int xMax = 15;
	private int yMax = 12;
	
	public ShapeModel(int xMax, int yMax) {
		position = new Position(0, 0);
		this.xMax = xMax;
		this.yMax = yMax;
	}
	
	public void move() {
		position.setX(Math.abs((position.getX()+randomPosNeg())%xMax));
		position.setY(Math.abs((position.getY()+randomPosNeg())%yMax));
	}
	
	private int randomPosNeg() {
		return rnd.nextInt(3)-1;
	}
	
	public Position getPosition() {
		return position;
	}
	

}
