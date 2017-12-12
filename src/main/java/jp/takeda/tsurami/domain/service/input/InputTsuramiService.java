package jp.takeda.tsurami.domain.service.input;

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

}
