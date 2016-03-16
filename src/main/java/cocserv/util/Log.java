package cocserv.util;

import org.apache.log4j.Logger;

import cocserv.openapi.CocOfficialAPIController;

public class Log {

	private static final Logger mLogger = Logger.getLogger(CocOfficialAPIController.class);

	public static void debug(String msg) {
		mLogger.debug(msg);
	}

	public static void error(String msg) {
		mLogger.error(msg);
	}
}
