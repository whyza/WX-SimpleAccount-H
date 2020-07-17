package com.simpleaccount.controller;

import com.simpleaccount.entry.BillClassfyTree;
import com.simpleaccount.entry.Billclassify;
import com.simpleaccount.service.BillClassfyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.simpleaccount.util.IconUtil;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/21 12:50
 * @Version: 1.0
 */
@RestController
public class BillClassfyController {
    @Resource
    BillClassfyService BillTypeService;
    @RequestMapping(value = "/queryAllBillClassfy",method = {RequestMethod.GET,RequestMethod.POST})
    public List<BillClassfyTree> queryAllBillClassfy(Integer userId,Integer classifyType){
        return BillTypeService.queryAllBillClassfy(userId,classifyType);
    }
    @RequestMapping(value = "/queryAllTwoClassify",method = {RequestMethod.GET,RequestMethod.POST})
    public List<List<Billclassify>> queryAllTwoClassify(Integer userId,Integer classifyType){
        return BillTypeService.queryAllTwoClassify(userId,classifyType);
    }
    @RequestMapping(value = "/queryBigBillClassfy",method = {RequestMethod.GET,RequestMethod.POST})
    public List<BillClassfyTree> queryBigBillClassfy(Integer classifyType){
        return BillTypeService.queryBigBillClassfy(classifyType);
    }

    @RequestMapping(value = "/getIcon",method = {RequestMethod.GET,RequestMethod.POST})
    public List<List<String>>  getIcon( ){
        if(IconUtil.icon == null || IconUtil.icon.size() == 0){
            IconUtil.addIcon();
        }
        List<List<String>> listArr = new ArrayList<List<String>>();
        List<String> list =  IconUtil.icon;
        //获取被拆分的数组个数
        int arrSize = list.size() % 15 == 0 ? list.size() / 15 : list.size() / 15 + 1;
        for (int i = 0; i < arrSize; i++) {
            List<String> sub = new ArrayList<String>();
            //把指定索引数据放入到list中
            for (int j = i * 15; j <= 15 * (i + 1) - 1; j++) {
                if (j <= list.size() - 1) {
                    //得到拆分后的集合
                    sub.add(list.get(j));
                }
            }
            listArr.add(sub);
        }
        return listArr;
    }

    @RequestMapping(value = "/addClassify",method = {RequestMethod.GET,RequestMethod.POST})
    public Boolean addClassify(@RequestBody Billclassify billclassify){
        return BillTypeService.AddClassify(billclassify);
    }
    @RequestMapping(value = "/setleftSelectData",method = {RequestMethod.GET,RequestMethod.POST})
    public List<Billclassify> setleftSelectData(Integer userId,Integer classifyType){
        return BillTypeService.setleftSelectData(userId,classifyType);
    }

}
