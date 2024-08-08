package com.study.mysite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/study")
	public String index() {
		return "킴쌤 클래스에 오신것을 환영합니다!!";
	}
}
