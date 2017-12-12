package jp.takeda.tsurami.domain.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Tsurami {

	private int tsuramiId;
	private Timestamp inputDateTime;
}
