package jp.takeda.tsurami.app.input;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.takeda.tsurami.domain.model.Tsurami;
import jp.takeda.tsurami.domain.service.input.InputTsuramiService;

@Controller
@RequestMapping("input")
public class TsuramiInputController {

	@Autowired
	InputTsuramiService inputTsuramiService;

	@RequestMapping(method = RequestMethod.GET)
	String inputTsurami(Model model) {
		return "input/inputTsurami";
	}

	@RequestMapping(method = RequestMethod.POST)
	String doTsurami(Model model) {
		Tsurami dummyTsurami = new Tsurami();
		dummyTsurami.setTsuramiId(1);
		Tsurami tsurami = this.inputTsuramiService.find(dummyTsurami);

		model.addAttribute("tsurami", tsurami.toString());

		// return "redirect:/input";
		return "input/inputTsurami";
	}

}
