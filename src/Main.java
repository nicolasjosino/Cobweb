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
			root.addCell(record);
			Node n = new Node();
			HashMap<Integer, Double> UCs = new HashMap<>();
			Double clusterScores = 0.0;
			Double bestScore = 0.0;
			int key = 0;

			for (Node node : root.getChildren()) {
				node.addCell(record);
				
				for (int i = 0; i < root.getChildren().size(); i++) {
					n = root.getChildren().get(i);
					clusterScores = clusterScores + (n.getCells().size() / root.getCells().size() * nodeProbabilites(n) - nodeProbabilites(root));
				}
				UCs.put(root.getChildren().indexOf(node), clusterScores / root.getChildren().size());

				node.getCells().removeIf(cell -> cell == record);
			}

			for (int k = 0; k < UCs.size(); k++) {
				if (bestScore < UCs.get(k)){
					key = k;
					bestScore = UCs.get(k);
				}
			}

			cobweb(root.getChildren().get(key), record);

		}

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
