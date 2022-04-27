import java.util.ArrayList;

public class Main {

	static void cobweb(Node root, Cell record) {

		if (root.isLeaf()) {
			Node l1 = new Node();
			Node l2 = new Node();
			l1.addCell(root.getCells().get(0));
			l2.addCell(record);

			root.addChild(l1);
			root.addChild(l2);
			root.addCell(record);
		} else {
			root.addCell(record);
			ArrayList<Node> clusters = new ArrayList<Node>();
			clusters.addAll(root.getChildren());

			for (Node node : clusters) {
				node.addCell(record);
				/* tornar o calculateCategoryUtility uma função que retorne o valor de categoria
				   de utilidade, mantendo ao fim do loop o maior.*/
				node.getCells().removeIf(cell -> cell == record);
			}
		}

	}

	public void calculateCategoryUtility() {

	}

	public static void main(String[] args) {
		Node root = new Node();
		root.addCell(new Cell(Cell.Colors.LIGHT, Cell.Tails.SINGLE));
		cobweb(root, new Cell(Cell.Colors.DARK, Cell.Tails.SINGLE));
		cobweb(root, new Cell(Cell.Colors.DARK, Cell.Tails.DOUBLE));
	}
}
