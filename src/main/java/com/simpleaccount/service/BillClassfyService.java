package com.simpleaccount.service;

import com.simpleaccount.entry.BillClassfyTree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/21 12:48
 * @Version: 1.0
 */
public interface BillClassfyService {
    /**
     * 查询所有二级分类
     * @return
     */
    List<BillClassfyTree> queryAllBillClassfy(Integer userId,Integer classifyType);
//
//    /**
//     * 查询所有一级分类
//     * @return
//     */
//    List<Integer> queryBigBillClassfy();
}
