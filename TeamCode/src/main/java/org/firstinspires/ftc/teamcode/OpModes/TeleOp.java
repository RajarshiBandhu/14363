package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.arcrobotics.ftclib.gamepad.GamepadKeys.*;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.states.*;
import org.firstinspires.ftc.teamcode.SubSystems.*;
import org.firstinspires.ftc.teamcode.SubSystems.arm;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends OpMode
{
    private GamepadEx driver, operator;
    private Robot robot;
    private Mecanum driveTrain;


    private Servo leftArm, rightArm;
    Mecanum wheels;
    @Override
    public void init()
    {
        driver = new GamepadEx(gamepad1);
        operator = new GamepadEx(gamepad2);
        robot = new Robot(hardwareMap, telemetry);
    }
    @Override
    public void loop() {

        driver.readButtons();
        operator.readButtons();

        robot.drivetrain.fieldCentric(driver);


      if (gamepad2.dpad_right){
          //leftArm.setPosition(-1);
          robot.Arm.setPosition(armState.outtaking);
      }
      if (gamepad2.dpad_left){
          //leftArm.setPosition(1);

          robot.Arm.setPosition(armState.low);

      }
        if (gamepad2.dpad_up){
            //leftArm.setPosition(1);

            robot.Arm.setPosition(armState.medium);

        }
        if (gamepad2.right_bumper){
            //leftArm.setPosition(1);

            robot.Claw.setPosition(armState.intakingCLAW);

        }
        if (gamepad2.left_bumper){
            //leftArm.setPosition(1);

            robot.Claw.setPosition(armState.outtaking);

        }









    }
}