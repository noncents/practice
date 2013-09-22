package plt;

public class Logger {

	private boolean doLog = false;

	public Logger(boolean doLog) {

		this.doLog = doLog;
	}

	public <T> void log(T object) {

		log(object + "");
	}

	public void log(String message) {

		if (doLog) {
			System.out.println(message);
		}
	}
}
