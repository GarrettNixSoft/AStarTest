package astar;

import java.io.File;
import java.util.PriorityQueue;

import javax.swing.*;

import maze.MazeLoader;

public class AStarTest {
	
	public static void main(String[] args) {
		new AStarTest();
	}
	
	public AStarTest() {
		String[] options = {
			"maze1", "maze2", "maze3", "maze4",
			"maze5", "maze6", "maze7", "maze8",
			"maze9", "maze10", "maze11", "maze12",
			"maze13", "maze14", "maze15", "maze16",
				"maze_file"
		};
		System.out.println("Using: priority queues");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		fileChooser.showDialog(null, "Open");

		File file = fileChooser.getSelectedFile();
		String choice = file.getPath();

//		String choice = (String) JOptionPane.showInputDialog(null, "Choose a maze to solve:", "Choose Maze", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//		boolean match = false;
//		for (String s : options) {
//			if (s.equals(choice)) {
//				match = true;
//				break;
//			}
//		}
//		if (!match) {
//			JOptionPane.showMessageDialog(null, "Invalid input. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
//		}
		byte[][] map = MazeLoader.getMaze(choice);
		//System.exit(0);
		printMap(map);
		
		AStar pathfinder = new AStar(map);
		PriorityQueue<Node> path = pathfinder.pathfind();
		if (path != null) printPath(path);
		while (true) pathfinder.repaint();
	}
	
	private void printMap(byte[][] map) {
		
		int w = map[0].length;
		int h = map.length;
		
		String top = "+";
		for (int i = 0; i < w; i++) top += "--";
		top += "-+";
		
		System.out.println(top);
		
		for (int r = 0; r < h; r++) {
			System.out.print("| ");
			for (int c = 0; c < w; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println("|");
		}
		
		System.out.println(top);
	}
	
	private void printPath(PriorityQueue<Node> nodes) {
		System.out.println("Path found! Route:");
		Object[] path = nodes.toArray();
		for (int i = 0; i < path.length; i++) {
			Node n = (Node) path[i];
			System.out.print("["+n.x+","+n.y+"]");
			if (i < nodes.size() - 1) System.out.print(" > ");
		}
		System.out.println();
	}
	
}
