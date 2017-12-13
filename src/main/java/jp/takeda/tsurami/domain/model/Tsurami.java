package jp.takeda.tsurami.domain.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Tsurami {

	private int tsuramiId;
	private LocalDateTime inputDateTime;
}
