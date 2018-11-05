package frc.team3405.robot.subsystems

import frc.team3405.robot.commands.SmartDashboardCommand
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team3405.robot.Robot
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj.Talon
import edu.wpi.first.wpilibj.PowerDistributionPanel

class SmartDashboardSubsystem : Subsystem() {
    private val Left1 = Talon(0)
    private val Right1 = Talon(1)
    private val Left2 = Talon(2)
    private val Right2 = Talon(3)
    private val feeder = Talon(4)
    private val leftLauncher = Talon(7)
    private val rightLauncher = Talon(6)
    private val pdp = PowerDistributionPanel()
    override fun initDefaultCommand(){
        defaultCommand = SmartDashboardCommand()
    }

    fun run() {

        //joy sticks
        SmartDashboard.putNumber("leftx",Robot.joystick.leftX)
        SmartDashboard.putNumber("lefty",Robot.joystick.leftY)
        SmartDashboard.putNumber("rightx",Robot.joystick.rightX)
        SmartDashboard.putNumber("righty",Robot.joystick.rightY)
        //drive motors
        SmartDashboard.putNumber("LeftPrimary", Left1.get())
        SmartDashboard.putNumber("RightPrimary", Right1.get())
        SmartDashboard.putNumber("LeftSecondary", Left2.get())
        SmartDashboard.putNumber("RightSecondary", Right2.get())
        //launcher motors
        SmartDashboard.putNumber("FeederMotor", feeder.get())
        SmartDashboard.putNumber("LeftLauncherMotor", leftLauncher.get())
        SmartDashboard.putNumber("RightLauncherMotor", rightLauncher.get())
        //Power Distro Totals
        SmartDashboard.putNumber("Power Distro Temperature", pdp.temperature)
        SmartDashboard.putNumber("Power Distro Total Current", pdp.totalCurrent)
        SmartDashboard.putNumber("Power Distro Total Power", pdp.totalPower)
        SmartDashboard.putNumber("Power Distro Total Voltage", pdp.voltage)
        //Power Distro Port Current Draw
        SmartDashboard.putNumber("Power Distro Port 0 Draw", pdp.getCurrent(0))
        SmartDashboard.putNumber("Power Distro Port 1 Draw", pdp.getCurrent(1))
        SmartDashboard.putNumber("Power Distro Port 2 Draw", pdp.getCurrent(2))
        SmartDashboard.putNumber("Power Distro Port 3 Draw", pdp.getCurrent(3))
        SmartDashboard.putNumber("Power Distro Port 14 Draw", pdp.getCurrent(14))
        SmartDashboard.putNumber("Power Distro Port 15 Draw", pdp.getCurrent(15))
        SmartDashboard.putNumber("Power Distro Port 16 Draw", pdp.getCurrent(16))


    }
}