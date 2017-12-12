DROP TABLE IF EXISTS tsurami CASCADE;

CREATE TABLE IF NOT EXISTS tsurami (
	tsurami_id	SERIAL NOT NULL,
	input_date_time TIMESTAMP NOT NULL,
	PRIMARY KEY (tsurami_id)
);
