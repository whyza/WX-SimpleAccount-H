package com.simpleaccount.service;

import com.simpleaccount.entry.BillClassfyTree;
import com.simpleaccount.entry.Billclassify;
import com.simpleaccount.util.resultutil.ResultUtil;
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

    /**
     * 查询所有一级分类
     * @return
     */
    List<BillClassfyTree> queryBigBillClassfy(Integer classifyType);


    /**
     * 查询所有二级分类
     * @param userId
     * @param classifyType
     * @return
     */
    List<List<Billclassify>> queryAllTwoClassify(Integer userId, Integer classifyType);


    List<BillClassfyTree> queryAdminClassify(Integer classifyType);

    /**
     * 更新账单分类
     * @param billclassify
     * @return
     */
    ResultUtil updateBillClassify(Billclassify billclassify);
    Boolean AddClassify(Billclassify billclassify);
}
