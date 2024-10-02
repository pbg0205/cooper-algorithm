package solved_problem.programmers.level01._동영상_재생기;

class Solution {

	private static final int HOUR_DIVIDE_NUMBER = 60;
	private static final String TIME_DELIMITER = ":";
	private static final String NEXT_COMMAND = "next";
	private static final String PREV_COMMAND = "prev";

	public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		int videoSeconds = convertSeconds(video_len);
		int posSeconds = convertSeconds(pos);
		final int opStartSeconds = convertSeconds(op_start);
		final int opEndSeconds = convertSeconds(op_end);


		for (String command : commands) {
			if (isOpeningRange(posSeconds, opStartSeconds, opEndSeconds)) {
				posSeconds = opEndSeconds;
			}

			if (command.equals(NEXT_COMMAND)) {
				posSeconds = actNextCommand(posSeconds, videoSeconds);
			}

			if (command.equals(PREV_COMMAND)) {
				posSeconds = actPrevCommand(posSeconds);
			}

		}

		if (isOpeningRange(posSeconds, opStartSeconds, opEndSeconds)) {
			posSeconds = opEndSeconds;
		}

		return convertTime(posSeconds);
	}

	private boolean isOpeningRange(final int posSeconds, final int opStartSeconds, final int opEndSeconds) {
		return (posSeconds >= opStartSeconds) && (posSeconds < opEndSeconds);
	}

	private int actNextCommand(final int posSeconds, final int videoSeconds) {
		return Math.min(posSeconds + 10, videoSeconds);
	}

	private int actPrevCommand(final int posSeconds) {
		return Math.max(posSeconds - 10, 0);
	}

	public int convertSeconds(String time) {
		final String[] split = time.split(":");
		final int  hour = Integer.parseInt(split[0]);
		final int  minutes = Integer.parseInt(split[1]);

		return hour * HOUR_DIVIDE_NUMBER + minutes;
	}

	public String convertTime(int seconds) {
		String hour = String.valueOf(seconds / 60);
		String minutes = String.valueOf(seconds % 60);

		if (hour.length() == 1) {
			hour = "0" + hour;
		}

		if (minutes.length() == 1) {
			minutes = "0" + minutes;
		}

		return hour + TIME_DELIMITER + minutes;
	}
}
