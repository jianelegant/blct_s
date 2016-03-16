package cocserv.maps;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cocserv.maps.bean.RequestParam;

@Controller
public class CocMapsController {

	@RequestMapping(value = "/maps", method = RequestMethod.POST)
	@ResponseBody
	public CResponseBean getMaps(@RequestBody RequestParam param) {
		CResponseBean bean = new CResponseBean();
		bean.setData(MapsDataManager.instance.getMapsList(param.getLevel(), param.getType()));
		return bean;
	}
}
