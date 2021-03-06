package com.simpleaccount.service.impl;

import com.simpleaccount.entry.BillClassfyTree;
import com.simpleaccount.entry.Billclassify;
import com.simpleaccount.expction.CommonException;
import com.simpleaccount.mapper.BillClassfyMapper;
import com.simpleaccount.service.BillClassfyService;
import com.simpleaccount.util.resultutil.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/21 12:49
 * @Version: 1.0
 */
@Service
public class BillClassfyServiceImpl implements BillClassfyService {
    @Resource
    BillClassfyMapper billTypeMapper;


    /**
     * 查询所有分类  tree
     *
     * @return
     */
    @Override
    @Cacheable(value = "billClassfyTree")
    public List<BillClassfyTree> queryAllBillClassfy(Integer userId, Integer classifyType) {
        List<BillClassfyTree> billList = billTypeMapper.queryBigBillClassfy(classifyType);
        for (BillClassfyTree btree : billList) {
            btree.setChildren(billTypeMapper.queryAllBillClassfy(btree.getClassify(), userId, classifyType));
        }
        return billList;
    }

    /**
     * 查询所有一级分类
     *
     * @return
     */
    @Override
    public List<BillClassfyTree> queryBigBillClassfy(Integer classifyType) {
        return billTypeMapper.queryBigBillClassfy(classifyType);
    }

    /**
     * 查询所有一级分类
     *
     * @return
     */
//    @Override
//    public List<Billclassify> queryBigBillClassfy(Integer classifyType) {
//        return billTypeMapper.queryBigBillClassfy(classifyType);
//    }

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
        List<Billclassify> list = billTypeMapper.queryAllTwoClassify(userId, classifyType);
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
        listArr.get(listArr.size() - 1).add(billc);
        return listArr;
    }

    @Override
    public List<BillClassfyTree> queryAdminClassify(Integer classifyType) {
        List<BillClassfyTree> billList = billTypeMapper.queryBigBillClassfy(classifyType);
        for (BillClassfyTree btree : billList) {
            btree.setChildren(billTypeMapper.queryAdminClassify(btree.getClassify(), classifyType));
        }
        return billList;
    }

    @Override
    public ResultUtil updateBillClassify(Billclassify billclassify) {
        boolean flag = false;
        String msg = "更新成功";
        int code = 200;
        try{
            billclassify.setUpdatetime(new Date());
            flag = billTypeMapper.updateBillClassify(billclassify)>0;
        }catch (Exception e){
            code = 500;
            msg = "更新失败";
            throw new CommonException(code,msg);
        }
        return new ResultUtil(msg,code);
    }

    @Override
    public Boolean AddClassify(Billclassify billclassify) {
        billclassify.setCreatetime(new Date());
        billclassify.setFClassfyId(new Long(0));
        return billTypeMapper.AddClassify(billclassify)>0;
    }

    @Override
    public List<Billclassify> setleftSelectData(Integer userId, Integer classifyType) {
        return billTypeMapper.setleftSelectData(userId,classifyType);
    }


}
