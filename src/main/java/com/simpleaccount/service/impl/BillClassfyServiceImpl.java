package com.simpleaccount.service.impl;

import com.simpleaccount.entry.BillClassfyTree;
import com.simpleaccount.entry.Billclassify;
import com.simpleaccount.mapper.BillClassfyMapper;
import com.simpleaccount.service.BillClassfyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/21 12:49
 * @Version: 1.0
 */
@Service
public class BillClassfyServiceImpl implements BillClassfyService {
    @Autowired
    BillClassfyMapper billTypeMapper;
//    /**
//     * 查询所有分类  tree
//     *
//     * @return
//     */
//    @Override
//    @Cacheable(value = "billClassfyTree")
//    public List<BillClassfyTree> queryAllBillClassfy(Integer userId) {
//        return billTypeMapper.queryAllBillClassfy(userId);
//    }


    /**
     * 查询所有分类  tree
     *
     * @return
     */
    @Override
    @Cacheable(value = "billClassfyTree")
    public List<BillClassfyTree> queryAllBillClassfy(Integer userId,Integer classifyType) {
        List<BillClassfyTree> billList = billTypeMapper.queryBigBillClassfy(classifyType);
        for (BillClassfyTree btree :billList) {
            btree.setChildrenBillClassfy(billTypeMapper.queryAllBillClassfy(btree.getClassify(),userId,classifyType));
        }
        return billList;
    }

    /**
     * 查询所有二级分类
     *
     * @param userId
     * @param classifyType
     * @return
     */
    @Override
    public List<List<Billclassify>> queryAllTwoClassify(Integer userId, Integer classifyType) {
        List<List<Billclassify>> listArr = new ArrayList<List<Billclassify>>();
        List<Billclassify> list = billTypeMapper.queryAllTwoClassify(userId,classifyType);
        //获取被拆分的数组个数
        int arrSize = list.size() % 10 == 0 ? list.size() / 10 : list.size() / 10 + 1;
        for (int i = 0; i < arrSize; i++) {
            List<Billclassify> sub = new ArrayList<Billclassify>();
            //把指定索引数据放入到list中
            for (int j = i * 10; j <= 10 * (i + 1) - 1; j++) {
                if (j <= list.size() - 1) {
                    //得到拆分后的集合
                    sub.add(list.get(j));
                }
            }
            listArr.add(sub);
        }
        Billclassify billc = new Billclassify();
        billc.setIcon("iconbianji");
        billc.setClassfyName("添加分类");
        listArr.get(listArr.size()-1).add(billc);
        return listArr;
    }

    @Override
    public List<BillClassfyTree> queryAdminClassify(Integer classifyType) {
        List<BillClassfyTree> billList = billTypeMapper.queryBigBillClassfy(classifyType);
        for (BillClassfyTree btree :billList) {
            btree.setChildrenBillClassfy(billTypeMapper.queryAdminClassify(btree.getClassify(),classifyType));
        }
        return billList;
    }

}
