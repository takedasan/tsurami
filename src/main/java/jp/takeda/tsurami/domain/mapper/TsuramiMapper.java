package jp.takeda.tsurami.domain.mapper;

import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.takeda.tsurami.domain.model.Tsurami;

@Mapper
public interface TsuramiMapper {

	@Select("SELECT tsurami_id, input_date_time FROM tsurami WHERE tsurami_id = #{id}")
	Tsurami findOne(int id);

	@Insert("INSERT INTO tsurami (input_date_time) VALUES (#{dateTime})")
	void insert(LocalDateTime dateTime);

}
