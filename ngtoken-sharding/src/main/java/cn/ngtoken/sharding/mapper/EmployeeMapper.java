package cn.ngtoken.sharding.mapper;

import cn.ngtoken.sharding.entity.EmployeeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<EmployeeEntity> {
}