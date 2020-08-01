package DFSandBFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
	public int numIslands(char[][] grid) {
		int count = 0 ;
		Queue<IndexInfo> q = new LinkedList<>();
		for (int i = 0 ; i < grid.length ; ++i){
			for (int j = 0 ; j < grid[0].length;++j){
				if (grid[i][j]=='1'){
					count++;
					q.offer(new IndexInfo(i,j));
					while (!q.isEmpty()){
						for (int size = q.size();size>0;size--){
							IndexInfo info = q.poll();

							if (info.row-1>0&&grid[info.row-1][info.col]=='1'){
								grid[info.row-1][info.col]='0';
								q.add(new IndexInfo(info.row-1,info.col));
							}
							if (info.row+1<grid.length&&grid[info.row+1][info.col]=='1'){
								grid[info.row+1][info.col]='0';
								q.add(new IndexInfo(info.row+1,info.col));
							}
							if (info.col-1>0&&grid[info.row][info.col-1]=='1'){
								grid[info.row][info.col-1]='0';
								q.add(new IndexInfo(info.row,info.col-1));
							}
							if (info.col+1<grid[0].length&&grid[info.row][info.col+1]=='1'){
								grid[info.row][info.col+1]='0';
								q.add(new IndexInfo(info.row+1,info.col+1));
							}
						}
					}
				}
			}
		}
		return count;
	}
	private class IndexInfo {
		int row,col;
		public IndexInfo(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
