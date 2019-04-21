package com.simpleaccount.service.impl;

import com.simpleaccount.entry.BillClassfyTree;
import com.simpleaccount.mapper.BillClassfyMapper;
import com.simpleaccount.service.BillClassfyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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
    /**
     * 查询所有一级分类
     *
     * @return
     */
    @Override
    @Cacheable(value = "billClassfyTree")
    public List<BillClassfyTree> queryAllBillClassfy() {
        return billTypeMapper.queryAllBillClassfy();
    }
}
