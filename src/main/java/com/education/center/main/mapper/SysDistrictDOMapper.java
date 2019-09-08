package com.education.center.main.mapper;


import com.education.center.main.entity.SysDistrictDO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysDistrictDOMapper extends Mapper<SysDistrictDO> {

//    String selectNameForPinYin( String name);

    int updateList(@Param("districts")List<SysDistrictDO> list);
}