package avenger.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 
 * @author zhangjingqi
 * @date 2019年5月23日下午5:15:26
 *
 **/
@Data
@TableName("avenger")
public class AvengerEntity {

	private Long id;

	private String name;

	private String age;

}
