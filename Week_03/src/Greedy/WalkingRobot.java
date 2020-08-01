package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WalkingRobot {
	public int robotSim(int[] commands, int[][] obstacles) {
		HashSet<List<Integer>> block = new HashSet<>();
		for (int[] ob :obstacles){
			block.add(Arrays.stream(ob).boxed().collect(Collectors.toList()));
		}
		int x = 0 ; int y = 0;
		Direction drict = Direction.U;	
		for (int i = 0 ; i< commands.length;++i){
			if (commands[i]<0) {
				drict =  changeDirection(commands[i],drict);
			}
			else {
				for (int j = 0; j <commands[i];++j) {
					if (drict==Direction.U){
						if (!block.contains(new ArrayList<>(Arrays.asList(x,y+1))))
							y++;
						else break;
					}
					if (drict==Direction.D){
						if (!block.contains(new ArrayList<>(Arrays.asList(x,y-1))))
							y--;
						else break;
					}
					if (drict==Direction.L){
						if (!block.contains(new ArrayList<>(Arrays.asList(x-1,y))))
							x--;
						else break;
					}
					if (drict==Direction.U){
						if (!block.contains(new ArrayList<>(Arrays.asList(x+1,y))))
							x++;
						else break;
					}
				}
			}
		}
		return x*x+y*y;
	}

	private Direction changeDirection(int command, Direction drict) {
		if (drict==Direction.U){
			if (command==-1)
				return Direction.R;
			else return Direction.L;
		}
		else if (drict==Direction.D){
			if (command==-1)
				return Direction.L;
			else return Direction.R;
		}
		else if (drict==Direction.L){
			if (command==-1)
				return Direction.U;
			else return Direction.D;
		}
		else {
			if (command==-1)
				return Direction.D;
			else return Direction.U;
		}
	}


	enum Direction{
		U,D,L,R;
	}
}
