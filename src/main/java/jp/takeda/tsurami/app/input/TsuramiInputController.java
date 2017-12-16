package jp.takeda.tsurami.app.input;

import java.time.LocalDateTime;

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
		Tsurami dummyTsurami = new Tsurami();
		dummyTsurami.setInputDateTime(LocalDateTime.now());

		// DB select
		Integer oneHour = this.inputTsuramiService.countCurrentOneHour(dummyTsurami);
		model.addAttribute("currentOneHour", oneHour);

		Integer oneDay = this.inputTsuramiService.countCurrentOneDay(dummyTsurami);
		model.addAttribute("currentOneDay", oneDay);

		return "input/inputTsurami";
	}

	@RequestMapping(method = RequestMethod.POST)
	String doTsurami(Model model) {
		// DB insert
		Tsurami insertTsurami = new Tsurami();
		insertTsurami.setInputDateTime(LocalDateTime.now());
		this.inputTsuramiService.insert(insertTsurami);

		// DB select
		Integer oneHour = this.inputTsuramiService.countCurrentOneHour(insertTsurami);
		model.addAttribute("currentOneHour", oneHour);

		Integer oneDay = this.inputTsuramiService.countCurrentOneDay(insertTsurami);
		model.addAttribute("currentOneDay", oneDay);

		return "input/inputTsurami";
	}

}
