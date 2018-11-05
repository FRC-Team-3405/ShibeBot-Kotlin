package frc.team3405.robot

import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.Joystick
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
