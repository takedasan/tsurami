package jp.takeda.tsurami.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.takeda.tsurami.domain.model.Tsurami;

@Mapper
public interface TsuramiMapper {

	@Select("SELECT tsurami_id, input_date_time FROM tsurami WHERE tsurami_id = #{id}")
	Tsurami findOne(int id);

}
