package jp.takeda.tsurami.app.action.input;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.takeda.tsurami.domain.model.Tsurami;
import jp.takeda.tsurami.domain.service.input.InputTsuramiService;

@RestController
@RequestMapping("action/input")
public class TsuramiInputActionController {

	@Autowired
	InputTsuramiService inputTsuramiService;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<Integer> inputTsurami(Model model) {
		Tsurami dummyTsurami = new Tsurami();
		dummyTsurami.setInputDateTime(LocalDateTime.now());

		Integer oneDay = this.inputTsuramiService.countCurrentOneDay(dummyTsurami);
		model.addAttribute("currentOneDay", oneDay);

		return new ResponseEntity<>(oneDay, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<Integer> doTsurami(Model model) {
		// DB insert
		Tsurami insertTsurami = new Tsurami();
		insertTsurami.setInputDateTime(LocalDateTime.now());
		this.inputTsuramiService.insert(insertTsurami);

		// DB select
		Integer oneDay = this.inputTsuramiService.countCurrentOneDay(insertTsurami);
		model.addAttribute("currentOneDay", oneDay);

		return new ResponseEntity<>(oneDay, HttpStatus.OK);
	}
}
