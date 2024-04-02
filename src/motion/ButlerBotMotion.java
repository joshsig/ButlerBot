package motion;

import java.awt.Color;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
        CPlayWave.PlayWave("../src/audio/bb_init.wav");

        boolean exit = false;

        System.out.println("------ Enter commands: -------");

        while (scanner.hasNextLine() && !exit) {

            String input = scanner.nextLine();
            String command = input.split(" ")[0];

            switch (command) {
                case "e":
                    exit = true;
                    break;
                case "init":
                    // init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    pose.setLED_Sota(Color.BLUE, Color.BLUE, 0, Color.WHITE);
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;
                case "m0":

                    /*
                     * ButlerBot: "Good morning! Would you like to review your
                     * schedule for the day or make a new calendar event?"
                     */

                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 }, new Short[] { 0, -900, 0, -700, 250, 0, 0, 0 });
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/gm_pitched.wav");
                    wait(1000);
                    CPlayWave.PlayWave("../src/audio/schedule_or_event.wav");
                    motion.waitEndinterpAll();

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;
                case "m1":

                    // ButlerBot: "You have a "meeting with the boss" at 11 this morning.
                    // Would you like to hear your next event or like me to repeat the previous
                    // event?"

                    // arms gesticulating
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 1, -524, -172, 318, 40, -124, 11 });
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/meeting_with_boss.wav");

                    wait(4000);

                    CPlayWave.PlayWave("../src/audio/next_or_prev.wav");
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 124, -866, 847, 548, 41, -125, -289 });
                    motion.play(pose, 1000);

                    wait(2000);

                    motion.waitEndinterpAll();

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;
                case "m2":

                    /*
                     * "You have a "doctor's appointment" at 2 this afternoon. Would you
                     * like to hear your next event or like me to repeat the previous event?"
                     */

                    // arms gesticulating
                    CPlayWave.PlayWave("../src/audio/drs.wav");
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 1, -524, -172, 318, 40, -124, 11 });
                    motion.play(pose, 1000);

                    wait(3000);

                    CPlayWave.PlayWave("../src/audio/next_or_prev.wav");
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 482, -348, 1091, 320, -806, -94, -264 });
                    motion.play(pose, 1000);

                    wait(2000);

                    motion.waitEndinterpAll();

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;

                case "m3":

                    /*
                     * ButlerBot: "You have a "doctor's appointment" at 2 this afternoon Would you
                     * like to hear your next event or like me to repeat the previous event?"
                     */

                    // arms gesticulating
                    CPlayWave.PlayWave("../src/audio/drs.wav");
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 1, -524, -172, 318, 40, -124, 11 });
                    motion.play(pose, 1000);

                    wait(3000);

                    CPlayWave.PlayWave("../src/audio/next_or_prev.wav");
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 124, -866, 847, 548, 41, -125, -289 });
                    motion.play(pose, 1000);

                    wait(2000);

                    motion.waitEndinterpAll();

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;

                case "m4":

                    /*
                     * ButlerBot: "You have no more events scheduled for today. Would you
                     * like me to repeat the previous event or make a new calendar entry?"
                     */

                    // arms gesticulating
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 1, -524, -172, 318, 40, -124, 11 });
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/no_more_events.wav");

                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 482, -348, 1091, 320, -806, -94, -264 });

                    wait(6000);
                    motion.waitEndinterpAll();

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;

                case "m5":

                    /*
                     * ButlerBot: Alright. Have a great day!
                     */

                    // wave goodbye
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -941, -36, -506, 236, 42, -125, 12 });
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/alr_have_gd.wav");
                    motion.waitEndinterpAll();

                    wait(5000);

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;

                case "a0":

                    /*
                     * ButlerBot:
                     * "Hello! Would you like to review your schedule for the day or make a new calendar entry?"
                     */

                    // wave hello
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -941, -36, -506, 236, 42, -125, 12 });
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/hello.wav");

                    wait(1000);

                    CPlayWave.PlayWave("../src/audio/schedule_or_event.wav");

                    motion.waitEndinterpAll();

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;

                case "a1":

                    /*
                     * ButlerBot: "What is the title of the event?"
                     */

                    // arms gesticulating
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 482, -348, 1091, 320, -806, -94, -264 });
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/title_event.wav");

                    wait(3000);

                    motion.waitEndinterpAll();

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;

                case "a2":

                    /*
                     * ButlerBot: "When is the event?"
                     */

                    // listening arms
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 482, -348, 1091, 320, -806, -94, -264 });
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/when_event.wav");

                    wait(3000);

                    motion.waitEndinterpAll();

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;

                case "a3":

                    /*
                     * ButlerBot: "Got it! I have added "Dinner with
                     * friends" to your calendar for today at 7 pm. Would you like to review your schedule for the day or make another calendar entry?"
                     */

                    // arms gesticulating
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 1, -524, -172, 318, 40, -124, 11 });
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/dinner_w_friends.wav");

                    wait(6000);

                    CPlayWave.PlayWave("../src/audio/schedule_or_event.wav");

                    motion.waitEndinterpAll();

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;

                case "a4":

                    /*
                     * ButlerBot: Alright. Have a great day!
                     */

                    // wave goodbye
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -941, -36, -506, 236, 42, -125, 12 });
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/alr_have_gd.wav");
                    motion.waitEndinterpAll();

                    wait(5000);

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;

                case "e0":

                    /*
                     * ButlerBot: "Good evening! Would you like to review your day?"
                     */

                    // wave hello
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -941, -36, -506, 236, 42, -125, 12 });
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/good_evening.wav");

                    wait(1000);

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;
                case "e1":

                    /*
                     * ButlerBot: "You had a "meeting with the
                     * boss" at 11 this morning. Did you accomplish that or would you like me to repeat?"
                     */

                    // arms gesticulating
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 1, -524, -172, 318, 40, -124, 11 });
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/had_meeting.wav");

                    wait(3000);

                    CPlayWave.PlayWave("../src/audio/did_u_accomplish.wav");
                    motion.waitEndinterpAll();

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;

                case "e2":

                    /*
                     * ButlerBot: "Great! I'm very proud of you. You had a "doctor's
                     * appointment" at 2 this afternoon. Did you accomplish that or would you like me to repeat?"
                     */

                    // proud pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 438, -182, -441, 185, 39, -312, 3
                            });
                    pose.setLED_Sota(Color.YELLOW, Color.YELLOW, 0, Color.BLUE);
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/praise_f.wav");

                    wait(3000);

                    // arms gesticulating
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 1, -524, -172, 318, 40, -124, 11 });
                    pose.setLED_Sota(Color.BLUE, Color.BLUE, 0, Color.BLUE);
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/had_doctors.wav");

                    wait(3000);

                    // question
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 124, -866, 847, 548, 41, -125, -289 });
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/did_u_accomplish.wav");

                    wait(3000);

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;

                case "e3":

                    /*
                     * ButlerBot: "Oh no. That is very disappointing. You had a "Dinner with
                     * friends" at 7 pm. Did you accomplish that or would you like me repeat?"
                     */

                    // sad pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 339, -553, -567, 422, -127, -6, 30 });
                    pose.setLED_Sota(Color.RED, Color.RED, 0, Color.BLUE);
                    motion.play(pose, 1000);

                    CPlayWave.PlayWave("../src/audio/disapoint_f.wav");

                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -867, -442, 856, 466, -300, 102, -211 });
                    motion.play(pose, 1000);

                    wait(3000);

                    // question
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 124, -866, 847, 548, 41, -125, -289 });
                    pose.setLED_Sota(Color.BLUE, Color.BLUE, 0, Color.BLUE);
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/had_dinner.wav");

                    wait(2000);

                    // listening arms
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 482, -348, 1091, 320, -806, -94, -264 });
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/did_u_accomplish.wav");

                    wait(2000);
                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;

                case "e4":

                    /*
                     * ButlerBot:
                     * "Great! I'm very proud of you. That is all your events from today. You accomplished 2 out of 3 events. You can do better tomorrow. Would you like to review your schedule for tomorrow or make a new calendar entry"
                     */

                    // proud pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 438, -182, -441, 185, 39, -312, 3 });
                    pose.setLED_Sota(Color.YELLOW, Color.YELLOW, 0, Color.BLUE);
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/praise_f.wav");

                    wait(2500);

                    // arms gesticulating
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 1, -524, -172, 318, 40, -124, 11 });
                    pose.setLED_Sota(Color.BLUE, Color.BLUE, 0, Color.BLUE);
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/end_of_review_2_3.wav");

                    wait(7000);

                    // listening arms
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, 482, -348, 1091, 320, -806, -94, -264 });
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/schedule_or_event.wav");

                    wait(2000);

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    motion.waitEndinterpAll();
                    break;

                case "e5":

                    /*
                     * ButlerBot: "Goodnight! Have a great night!"
                     */

                    // wave goodbye
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -941, -36, -506, 236, 42, -125, 12 });
                    motion.play(pose, 1000);
                    CPlayWave.PlayWave("../src/audio/gn.wav");
                    motion.waitEndinterpAll();

                    wait(5000);

                    // return to init pose
                    pose.SetPose(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                            new Short[] { 0, -539, -913, 477, 936, 46, -140, -6 });
                    motion.play(pose, 1000);
                    pose.setLED_Sota(Color.BLACK, Color.BLACK, 0, Color.BLACK);
                    motion.waitEndinterpAll();
                    break;
            }

        }

        pose = CSotaMotion.getInitPose();
        pose.setLED_Sota(Color.RED, Color.RED, 0, Color.RED);
        motion.play(pose, 1000);

        System.out.println("Exiting…");
        scanner.close();
        // cam.StopFaceTraking();
        motion.ServoOff();
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}