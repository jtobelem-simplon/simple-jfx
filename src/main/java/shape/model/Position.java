package shape.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Position {
	private IntegerProperty x;
	private IntegerProperty y;
	
	public Position(int x, int y) {
		this.x = new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
	}
	
	public IntegerProperty xProperty() {
		return x;
	}
	
	public IntegerProperty yProperty() {
		return y;
	}
	
	public int getX() {
		return x.get();
	}
	
	public void setX(int newVal) {
		this.x.set(newVal);
	}
	
	public int getY() {
		return y.get();
	}
	
	public void setY(int newVal) {
		this.y.set(newVal);
	}
}
