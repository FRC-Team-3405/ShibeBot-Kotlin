package frc.team3405.robot.subsystems

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team3405.robot.Robot
import frc.team3405.robot.Xbox
import frc.team3405.robot.commands.ShootCommand

class Launcher : Subsystem() {
    private val Feeder: TalonSRX = TalonSRX(4)
    private val LeftLauncher: TalonSRX = TalonSRX(5)
    private val RightLauncher: TalonSRX = TalonSRX(6)

    override fun initDefaultCommand() {
        defaultCommand = ShootCommand()
    }

    fun arcadeDrive() {
        val x = Robot.joystick.leftX
        val y = Robot.joystick.leftY
        val maxOutput = .5
        val feederSpeed = .2
        val left: Double = (y - x) * maxOutput
        val right: Double = (y + x) * maxOutput
        RightLauncher.set(ControlMode.PercentOutput, -right)
        LeftLauncher.set(ControlMode.PercentOutput, left)
        if(Robot.joystick.joystick.getRawButton(Xbox.RightLowerBumper)) {
            Feeder.set(ControlMode.PercentOutput, feederSpeed)
        } else {
            Feeder.set(ControlMode.PercentOutput, 0.0)
        }
    }

    //For Eastmond
    fun tankDrive() {
        val maxOutput = .5
        val feederSpeed = .2
        if(Robot.joystick.joystick.getRawButton(Xbox.LeftLowerBumper)) {
            RightLauncher.set(ControlMode.PercentOutput, maxOutput)
            LeftLauncher.set(ControlMode.PercentOutput, maxOutput)
        } else {
            RightLauncher.set(ControlMode.PercentOutput, 0.0)
            LeftLauncher.set(ControlMode.PercentOutput, 0.0)
        }
        if(Robot.joystick.joystick.getRawButton(Xbox.RightLowerBumper)) {
            Feeder.set(ControlMode.PercentOutput, feederSpeed)
        } else {
            Feeder.set(ControlMode.PercentOutput, 0.0)
        }
    }
}

