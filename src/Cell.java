public class Cell {
	public Colors color;
	public Tails tails;
	public Integer core;

	public enum Colors {
		DARK, LIGHT;
	}
	
	public enum Tails{
		SINGLE, DOUBLE;
	}	

	public Cell() {
	}

	public Cell(Colors color, Tails tails, Integer core) {
		this.color = color;
		this.tails = tails;
		this.core = core;
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

	public Integer getCore() {
		return this.core;
	}

	public void setCore(Integer core) {
		this.core = core;
	}

}