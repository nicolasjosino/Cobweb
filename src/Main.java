import java.util.ArrayList;
import java.util.List;

import Cell.Colors;

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

	public void calculateCategoryUtility(ArrayList<Node> clusters) {
		Double qLight = 0.0;
		Double qDark = 0.0;
		Double qSingleTail = 0.0;
		Double qDoubleTail = 0.0;
		ArrayList<Double> probs = new ArrayList<Double>();

		for (Node node : clusters) {
			for (Cell cell : node.getCells()) {
				if (cell.getColor() == Cell.Colors.LIGHT) {
					qLight++;
				} else {
					qDark++;
				}

				if (cell.getTails() == Cell.Tails.SINGLE) {
					qSingleTail++;
				} else {
					qDoubleTail++;
				}
			}
			Double e = Math.pow(qLight, 2) + Math.pow(qDark, 2) + Math.pow(qSingleTail, 2) + Math.pow(qDoubleTail, 2);
			probs.add(e);
		}
	}

	public static void main(String[] args) {
		Node root = new Node();
		root.addCell(new Cell(Cell.Colors.LIGHT, Cell.Tails.SINGLE));
		cobweb(root, new Cell(Cell.Colors.DARK, Cell.Tails.SINGLE));
		cobweb(root, new Cell(Cell.Colors.DARK, Cell.Tails.DOUBLE));
	}
}
