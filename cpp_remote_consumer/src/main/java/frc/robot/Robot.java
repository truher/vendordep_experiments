package frc.robot;

import org.team100.domain.Hello;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

    public Robot() {
    }

    @Override
    public void teleopPeriodic() {
        try {
            Hello hello = new Hello();
            System.out.println("call a method");
            int result = hello.add(1, 2);
            System.out.printf("show the result: %d\n", result);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
