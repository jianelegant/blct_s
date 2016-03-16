package cocserv;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import cocserv.maps.MapsDataManager;
import cocserv.util.Log;

public class InitializeManager implements InitializingBean, DisposableBean {

	public void destroy() throws Exception {
		Log.debug("destroy");
	}

	public void afterPropertiesSet() throws Exception {
		Log.debug("afterPropertiesSet");
		init();
	}

	private void init() {
		MapsDataManager.instance.init();
	}

}
