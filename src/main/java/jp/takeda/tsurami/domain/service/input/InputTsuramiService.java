package jp.takeda.tsurami.domain.service.input;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.takeda.tsurami.domain.mapper.TsuramiMapper;
import jp.takeda.tsurami.domain.model.Tsurami;

@Service
@Transactional
public class InputTsuramiService {

	@Autowired
	TsuramiMapper tsuramiMapper;

	public Tsurami find(Tsurami tsurami) {
		return this.tsuramiMapper.findOne(tsurami.getTsuramiId());
	}

	public Integer countCurrentOneHour(Tsurami tsurami) {
		LocalDateTime to = tsurami.getInputDateTime();
		LocalDateTime from = to.minusHours(1);

		return this.tsuramiMapper.countTsurami(from, to);
	}

	public Integer countCurrentOneDay(Tsurami tsurami) {
		LocalDateTime to = tsurami.getInputDateTime();
		LocalDateTime from = to.minusDays(1);

		return this.tsuramiMapper.countTsurami(from, to);
	}

	public void insert(Tsurami tsurami) {
		this.tsuramiMapper.insert(tsurami.getInputDateTime());
	}

}
