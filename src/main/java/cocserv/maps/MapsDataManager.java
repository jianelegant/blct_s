package cocserv.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cocserv.Constants;
import cocserv.maps.bean.CMap;

public enum MapsDataManager {
	instance;

	private final Map<String, List<CMap>> mMapCache = new HashMap<String, List<CMap>>();

	public void init() {
		initTh8Maps();
	}

	private void initTh8Maps() {
		// farm
		String key = generateKey(Constants.LEVEL_8, Constants.TYPE_FARM);
		List<CMap> list = new ArrayList<CMap>();
		CMap map = null;

		map = new CMap();
		map.setLevel(Constants.LEVEL_8);
		map.setType(Constants.TYPE_FARM);
		map.setUrl_small(Constants.MAP_URL_TH8_FARMING_1_THUMB);
		map.setUrl_standard(Constants.MAP_URL_TH8_FARMING_1);
		list.add(map);

		map = new CMap();
		map.setLevel(Constants.LEVEL_8);
		map.setType(Constants.TYPE_FARM);
		map.setUrl_small(Constants.MAP_URL_TH8_FARMING_2_THUMB);
		map.setUrl_standard(Constants.MAP_URL_TH8_FARMING_2);
		list.add(map);

		mMapCache.put(key, list);
	}

	public String generateKey(int level, int type) {
		return String.valueOf(level) + "_" + String.valueOf(type);
	}

	public List<CMap> getMapsList(int level, int type) {
		String key = generateKey(level, type);
		if (mMapCache.containsKey(key)) {
			return mMapCache.get(key);
		}
		return null;
	}
}
