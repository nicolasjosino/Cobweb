public class Cell {
	public Colors color;
	public Tails tails;

	public enum Colors {
		DARK, LIGHT;
	}
	
	public enum Tails{
		SINGLE, DOUBLE;
	}

	public Cell() {
	}

	public Cell(Colors color, Tails tails) {
		this.color = color;
		this.tails = tails;
	}

	public Colors getColor() {
		return this.color;
	}

	public void setColor(Colors color) {
		this.color = color;
	}

	public Tails getTails() {
		return tails;
	}

	public void setTails(Tails tails) {
		this.tails = tails;
	}

}