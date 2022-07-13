package maze;

import java.util.ArrayList;

import misc.FileUtil;

public class MazeConverter {
	
	public static void convertMaze(String file) {
		
		ArrayList<String> lines = FileUtil.getFileData("/" + file + ".txt");
		
		ArrayList<String> replaced = new ArrayList<String>();
		
		for (String line : lines) {
			
			int index = 0, count = 0;
			
			ArrayList<String> bits = new ArrayList<String>();
			
			while (index < line.length()) {
				int start = index;
				if (count % 2 == 0) index++;
				else index += 3;
				count++;
				bits.add(line.substring(start, index));
			}
			
			String newLine = "";
			int lengthBefore = 0;
			for (String s : bits) {
				if (s.contains("X")) newLine += "1";
				if (s.contains(" ") || s.contains("*")) newLine += "0";
				lengthBefore += s.length();
			}
			System.out.println("Line was " + lengthBefore + ", but is now " + newLine.length());
			replaced.add(newLine);
			
		}
		
		FileUtil.writeFile("C:\\Users\\Garrett\\workspace - games\\AStarTest\\mazes", file, "txt", replaced);
		
		//System.exit(0);
	}
	
}