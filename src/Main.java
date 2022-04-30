import java.util.HashMap;

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
			HashMap<Integer, Double> CategoryUtilities = new HashMap<>();
			Double bestScore = 0.0;
			int key = 0;
			root.addCell(record);

			for (Node node : root.getChildren()) {
				node.addCell(record);
				CategoryUtilities.put(root.getChildren().indexOf(node), getCategoryUtility(root));
				node.getCells().removeIf(cell -> cell == record);
			}

			for (int k = 0; k < CategoryUtilities.size(); k++) {
				if (bestScore < CategoryUtilities.get(k)) {
					key = k;
					bestScore = CategoryUtilities.get(k);
				}
			}

			Node newChild = new Node();
			newChild.addCell(record);
			root.addChild(newChild);
			
			if (bestScore > getCategoryUtility(root) ) {
				cobweb(root.getChildren().get(key), record);	
			} else {
				root.getChildren().remove(newChild);
			}

		}

	}

	public static double getCategoryUtility(Node root) {
		Node n = new Node();
		Double clusterScores = 0.0;

		for (int i = 0; i < root.getChildren().size(); i++) {
			n = root.getChildren().get(i);
			clusterScores = clusterScores
					+ (n.getCells().size() / root.getCells().size() * nodeProbabilites(n) - nodeProbabilites(root));
		}

		return clusterScores / root.getChildren().size();
	}

	static Double nodeProbabilites(Node cluster) {
		int qLight = 0;
		int qDark = 0;
		int qSingleTail = 0;
		int qDoubleTail = 0;
		int listSize = cluster.getCells().size();

		for (Cell cell : cluster.getCells()) {
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
		return Math.pow(qLight / listSize, 2) + Math.pow(qDark / listSize, 2) +
				Math.pow(qSingleTail / listSize, 2) + Math.pow(qDoubleTail / listSize, 2);
	}

	public static void main(String[] args) {
		Node root = new Node();
		root.addCell(new Cell(Cell.Colors.LIGHT, Cell.Tails.SINGLE));
		cobweb(root, new Cell(Cell.Colors.DARK, Cell.Tails.SINGLE));
		cobweb(root, new Cell(Cell.Colors.DARK, Cell.Tails.DOUBLE));
	}
}
