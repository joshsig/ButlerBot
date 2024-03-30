package jp.vstone.sotasample;

import jp.co.nttit.speechrec.Nbest;
import jp.vstone.RobotLib.CPlayWave;
import jp.vstone.RobotLib.CRobotUtil;
import jp.vstone.sotatalk.SpeechRecog;
import jp.vstone.sotatalk.TextToSpeechSota;

public class TextToSpeechSample {
	static final String TAG = "SpeechRecSample";

	public static void main(String[] args) {
		CPlayWave.PlayWave(TextToSpeechSota.getTTS("Hello World!"), true);
		CPlayWave.PlayWave(TextToSpeechSota.getTTS("Hello World!"), true);
		byte[] data = TextToSpeechSota.getTTS("Hello World!");
		if (data == null) {
			CRobotUtil.Log(TAG, "ERROR");
		}
		CPlayWave.PlayWave(data, true);

		CPlayWave.PlayWave(TextToSpeechSota.getTTS("Hello World! Hello World! Hello World! Hi IM BUTLER BOT!"), true);
	}
}
