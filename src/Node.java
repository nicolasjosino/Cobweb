import java.util.ArrayList;
import java.util.List;

public class Node {
	private List<Cell> cells = new ArrayList<Cell>();
	private Node parent;
	private ArrayList<Node> children = new ArrayList<Node>();

	public Node() {}

	public List<Cell> getCells() {
		return cells;
	}

	public Node getParent() {
		return this.parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public ArrayList<Node> getChildren() {
		return this.children;
	}

	public void addChild(Node newNode) {
		this.children.add(newNode);
		newNode.parent = this;
	}
	
	public void addCell(Cell cell) {
		this.cells.add(cell);
	}

	public boolean isLeaf() {
		return this.children.isEmpty();
	}

}
