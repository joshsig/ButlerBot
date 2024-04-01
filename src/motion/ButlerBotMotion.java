package motion;

import java.awt.Color;
import java.util.Scanner;

import jp.vstone.RobotLib.*;
import jp.vstone.camera.CRoboCamera;
import jp.vstone.camera.FaceDetectLib;
import jp.vstone.sotatalk.MotionAsSotaWish;
import jp.vstone.sotatalk.TextToSpeechSota;

public class ButlerBotMotion {
    public static void main(String[] args) {

        CRobotMem mem = new CRobotMem();
        CSotaMotion motion = new CSotaMotion(mem);
        MotionAsSotaWish freeMotion = new MotionAsSotaWish(motion);
        Scanner scanner = new Scanner(System.in);

        if (!mem.Connect()) {
            System.out.println("Error connecting to robot's memory");
        }

        // INIT motion
        motion.InitRobot_Sota();
        motion.ServoOn();

        // CRoboCamera cam = new CRoboCamera("/dev/video0", motion);
        // cam.StartFaceTraking();

        CRobotPose pose = CSotaMotion.getInitPose();
        pose.setLED_Sota(Color.BLUE, Color.BLUE, 0, Color.GREEN);
        motion.play(pose, 1000);
        motion.waitEndinterpAll();
        // CPlayWave.PlayWave("../src/sound/cursor10.wav");

        boolean exit = false;

        while (scanner.hasNextLine() && !exit) {

            String input = scanner.nextLine();
            String command = input.split(" ")[0];

            switch (command) {
                case "e":
                    exit = true;
                    break;
                case "init":
                    // init pose
                    pose = CSotaMotion.getInitPose();
                    pose.setLED_Sota(Color.BLUE, Color.BLUE, 0, Color.WHITE);
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;
                case "gm":

                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 }, new Short[] { 0, -900, 0, -700, 250, 0, 0, 0 });
                    pose.setLED_Sota(Color.BLUE, Color.BLUE, 0, Color.GREEN);
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/gm_pitched.wav");
                    motion.waitEndinterpAll();

                    // return to init pose
                    pose = CSotaMotion.getInitPose();
                    pose.setLED_Sota(Color.BLUE, Color.BLUE, 0, Color.WHITE);
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;
                case "meeting":

                    // arms gesticulating
                    pose.SetPose(
                            new Byte[] { CSotaMotion.SV_L_ELBOW, CSotaMotion.SV_L_SHOULDER },
                            new Short[] { 320, 600 });
                    pose.setLED_Sota(Color.BLUE, Color.BLUE, 0, Color.GREEN);
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/meeting_with_boss.wav");
                    motion.waitEndinterpAll();

                    // return to init pose
                    pose = CSotaMotion.getInitPose();
                    pose.setLED_Sota(Color.BLUE, Color.BLUE, 0, Color.WHITE);
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;
                case "qu":
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 43, 124, -866, 847, 548, 41, -125, -289 });
                    pose.setLED_Sota(Color.BLUE, Color.BLUE, 0, Color.GREEN);
                    motion.play(pose, 1000);
                case "git":
                    Short[] rdpos = motion.getReadpos();
                    String fuck = "";
                    for (int i = 0; i < rdpos.length; i++) {
                        fuck += rdpos[i] + ", ";
                    }
                    CRobotUtil.Log("TAG", fuck);
                    break;
                default:
                    break;
            }

        }

        System.out.println("Exiting…");
        scanner.close();
        // cam.StopFaceTraking();
        motion.ServoOff();
    }
}