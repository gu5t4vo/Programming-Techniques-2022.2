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
			ahead(getDistanceRemaining());
			turnGunLeft(90);
			back(getDistanceRemaining()/2);
		}

	}
	public void onScannedRobot(ScannedRobotEvent e) {
		
		for (int i = 0; i < 3; i++)
			fire(0.5);
	}
	
	public void onHitWall(HitWallEvent event) {
		turnLeft(90);
		back(90);
	}
	
	@Override
	public void onHitByBullet(HitByBulletEvent event) {
		// TODO Auto-generated method stub
		super.onHitByBullet(event);
		
		ahead(600);
	}
	
	@Override
	public void onHitRobot(HitRobotEvent event) {
		// TODO Auto-generated method stub
		super.onHitRobot(event);
		
		fire(3);
		
		back(200);
	}


}
