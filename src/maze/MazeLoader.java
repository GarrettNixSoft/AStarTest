package maze;

import java.util.ArrayList;

import misc.FileUtil;

public class MazeLoader {
	
	public static byte[][] getMaze(String file) {
		
		//MazeConverter.convertMaze(file);
		
		ArrayList<String> lines = null;
		try {
//			lines = FileUtil.getFileData("/" + file + ".txt");
			lines = FileUtil.getFileData(file);
		} catch (Exception e) {
			System.exit(-1);
		}
		
		byte[][] maze = new byte[lines.size()][];
		
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			maze[i] = new byte[line.length()];
			for (int j = 0; j < maze[i].length; j++) {
				maze[i][j] = Byte.parseByte("" + line.charAt(j));
			}
		}
		
		return maze;
	}
	
}