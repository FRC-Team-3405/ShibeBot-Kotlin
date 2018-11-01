package frc.team3405.robot.subsystems

import edu.wpi.first.wpilibj.Talon
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team3405.robot.Robot
import frc.team3405.robot.Xbox
import frc.team3405.robot.commands.ShootCommand

class Launcher : Subsystem() {
    private val feeder = Talon(4)
    private val leftLauncher = Talon(7)
    private val rightLauncher = Talon(6)

    override fun initDefaultCommand() {
        defaultCommand = ShootCommand()
    }

    fun arcadeDrive() {
        val x = Robot.joystick.rightX
        val y = Robot.joystick.rightY
        val maxOutput = .5
        val feederSpeed = 1.0
        val left: Double = (y - x) * maxOutput
        val right: Double = (y + x) * maxOutput
        rightLauncher.set(-right)
        leftLauncher.set(left)
        if(Robot.joystick.joystick.getRawButton(Xbox.RightLowerBumper)) {
            println("Feed me!")
            feeder.set(feederSpeed)
        } else {
            feeder.set(0.0)
        }
    }

    //For Eastmond
    fun tankDrive() {
        print("Tank drive")
        val maxOutput = .5
        val feederSpeed = .2
        if(Robot.joystick.joystick.getRawButton(Xbox.LeftLowerBumper)) {
            rightLauncher.set(maxOutput)
            leftLauncher.set(maxOutput)
        } else {
            rightLauncher.set(0.0)
            leftLauncher.set(0.0)
        }
        if(Robot.joystick.joystick.getRawButton(Xbox.RightLowerBumper)) {
            feeder.set(feederSpeed)
        } else {
            feeder.set(0.0)
        }
    }
}

