package HomeWork;

import java.util.HashSet;

public class WalkingRobotSimulator {
	public int robotSim(int[] commands, int[][] obstacles) {
		HashSet<String> block = new HashSet<>();
		for (int[] obs :obstacles){
			block.add(obs[0]+"."+obs[1]);
		}
		int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
		int direction=0,x=0,y=0,maxmium=0;
		for (int t:commands) {
			if (t==-2) {
				direction=direction==0?3:direction-1;
			}if (t==-1) {
				direction=direction==3?0:direction+1;
			}else{
				while (t-->0&&!block.contains((x+dir[direction][0])+"."+(y+dir[direction][1]))){
					x+=dir[direction][0];
					y+=dir[direction][1];
				}
			}
			maxmium = Math.max(maxmium,x*x+y*y);
		}
		return maxmium;
	}
}
