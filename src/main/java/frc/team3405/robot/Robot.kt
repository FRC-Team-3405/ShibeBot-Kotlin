package frc.team3405.robot

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.Talon
import edu.wpi.first.wpilibj.command.Scheduler
import frc.team3405.robot.subsystems.DriveTrain
import frc.team3405.robot.subsystems.Launcher
import frc.team3405.robot.subsystems.SmartDashboardSubsystem

class Robot : IterativeRobot() {
    companion object {
        val driveTrain = DriveTrain()
        val Launcher = Launcher()
        val SmartDashboard = SmartDashboardSubsystem()
        val joystick = XboxController(Joystick(0))
        var ArcadeDrive = true
        //motors
        val left1 = Talon(3)
        val right1 = Talon(1)
        val left2 = Talon(0)
        val right2 = Talon(2)
        val feeder = Talon(4)
        val leftLauncher = Talon(7)
        val rightLauncher = Talon(6)
        //inputs
        val switch1 = DigitalInput(0)
        val switch2 = DigitalInput(1)
        val switch3 = DigitalInput(2)
    }
    override fun robotInit() {}

    override fun disabledInit() {}

    override fun autonomousInit() {}

    override fun teleopInit() {
        ArcadeDrive = true
    }

    override fun testInit() {}

    override fun disabledPeriodic() {}

    override fun autonomousPeriodic() {
        Scheduler.getInstance().run()
    }

    override fun teleopPeriodic() {
        Scheduler.getInstance().run()
    }

    override fun testPeriodic() {}
}
