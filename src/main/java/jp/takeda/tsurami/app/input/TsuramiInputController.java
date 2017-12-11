package jp.takeda.tsurami.app.input;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("input")
public class TsuramiInputController {

	@RequestMapping(method = RequestMethod.GET)
	String inputTsurami(Model model) {
		model.addAttribute("tsurami", "つらみ");

		return "input/inputTsurami";
	}

	@RequestMapping(method = RequestMethod.POST)
	String doTsurami(Model model) {	
		return "redirect:/input";
	}

}
