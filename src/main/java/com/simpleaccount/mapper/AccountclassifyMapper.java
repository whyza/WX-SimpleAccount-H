package com.simpleaccount.mapper;

import com.simpleaccount.entry.Accountclassify;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/25 7:46
 * @Version: 1.0
 */
public interface AccountclassifyMapper {
    /**
     * 根据id查询账户信息
     * @param fAccountclassifyId
     * @return
     */
    List<Accountclassify> queryAllAccClassifyInfoByfId(@Param(value="fAccountclassifyId")Integer fAccountclassifyId, @Param(value = "userId") Integer userId);
}
