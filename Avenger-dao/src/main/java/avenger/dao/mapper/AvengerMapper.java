package avenger.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import avenger.dao.entity.AvengerEntity;

/**
 * 
 * @author zhangjingqi
 * @date 2019年5月23日下午5:15:48
 *
 **/
@Mapper
public interface AvengerMapper<T extends AvengerEntity> extends BaseMapper<AvengerEntity> {

}
