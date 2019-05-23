package avenger.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author zhangjingqi
 * @date 2019年5月23日下午5:38:47
 *
 **/
@RestController
public class AvengerController {

	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "index";
	}
}
