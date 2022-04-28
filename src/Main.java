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
			//TODO: checar necessidade de criar um ArrayList cópia dos filhos e percorrer o mesmo
			ArrayList<Node> clusters = new ArrayList<Node>();
			clusters.addAll(root.getChildren());
			clusters.add(root);
			for (Node node : clusters) {
				node.addCell(record);
				//TODO: checar qual node escolher e simular adição de novo nó
				calculateNodeProbabilites(node);
				node.getCells().removeIf(cell -> cell == record);
			}
		}

	}

	public void calculateNodeProbabilites(Node cluster) {
		Integer qLight = 0.0;
		Integer qDark = 0.0;
		Integer qSingleTail = 0.0;
		Integer qDoubleTail = 0.0;
		ArrayList<Double> probs = new ArrayList<Double>();
	
		for (Cell cell : cluster.getCells()) {
			int listSize = cluster.getCells().size;
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
		Double e = Math.pow(qLight/listSize, 2) + 
					Math.pow(qDarkt/listSize, 2) +
					Math.pow(qSingleTailt/listSize, 2) +
					Math.pow(qDoubleTailt/listSize, 2);
		probs.add(e);
	}

	public static void main(String[] args) {
		Node root = new Node();
		root.addCell(new Cell(Cell.Colors.LIGHT, Cell.Tails.SINGLE));
		cobweb(root, new Cell(Cell.Colors.DARK, Cell.Tails.SINGLE));
		cobweb(root, new Cell(Cell.Colors.DARK, Cell.Tails.DOUBLE));
	}
}
