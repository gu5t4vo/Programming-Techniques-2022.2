package tecProg;

import java.awt.Color;
import java.util.Iterator;

import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

public class RoboDoGustavo extends AdvancedRobot {

	
	public void run() {
		setColors(Color.black, Color.black, Color.black);
		
		
		while (true) {
			
			ahead(100);
			turnLeft(50);
			
		}

	}
	public void onScannedRobot(ScannedRobotEvent e) {
		
		fire(2);
		
	}
	
	public void onHitWall(HitWallEvent event) {
		
		turnLeft(90);
	}
	
	@Override
	public void onHitByBullet(HitByBulletEvent event) {
		// TODO Auto-generated method stub
		super.onHitByBullet(event);
		
		ahead(300);
	}
	
	@Override
	public void onHitRobot(HitRobotEvent event) {
		// TODO Auto-generated method stub
		super.onHitRobot(event);
		
		
		for (int i = 0; i < 6; i++)
			fire(3);
		
		turnLeft(90);
	}


}
