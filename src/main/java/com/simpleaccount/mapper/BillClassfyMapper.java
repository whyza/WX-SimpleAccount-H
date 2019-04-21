package com.simpleaccount.mapper;

import com.simpleaccount.entry.BillClassfyTree;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.URL;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/21 12:22
 * @Version: 1.0
 */
public interface BillClassfyMapper {
    /**
     * 查询所有一级分类
     * @return
     */
    List<BillClassfyTree>  queryAllBillClassfy();
}
