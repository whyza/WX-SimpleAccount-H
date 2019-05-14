package com.simpleaccount.controller;

import com.simpleaccount.entry.BillClassfyTree;
import com.simpleaccount.entry.Billclassify;
import com.simpleaccount.service.BillClassfyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/21 12:50
 * @Version: 1.0
 */
@RestController
public class BillClassfyController {
    @Autowired
    BillClassfyService BillTypeService;
    @RequestMapping("/queryAllBillClassfy")
    public List<BillClassfyTree> queryAllBillClassfy(Integer userId,Integer classifyType){
        return BillTypeService.queryAllBillClassfy(userId,classifyType);
    }
    @RequestMapping("/queryAllTwoClassify")
    public List<List<Billclassify>> queryAllTwoClassify(Integer userId,Integer classifyType){
        return BillTypeService.queryAllTwoClassify(userId,classifyType);
    }
}
