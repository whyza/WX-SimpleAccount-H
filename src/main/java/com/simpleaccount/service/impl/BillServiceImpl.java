package com.simpleaccount.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.gson.JsonArray;
import com.simpleaccount.entry.Bill;
import com.simpleaccount.entry.DateBills;
import com.simpleaccount.mapper.BillMapper;
import com.simpleaccount.service.BillService;
import com.simpleaccount.util.resultutil.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/25 9:49
 * @Version: 1.0
 */
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillMapper billMaper;

    /**
     * 添加账单
     *
     * @param bill
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultUtil addBill(Bill bill) {
        ResultUtil resultUtil = null;
        String msg = "添加成功";
        boolean flag = true;
        if (billMaper.addBill(bill) > 0) {
            for (String url : bill.getImages()) {
                if (billMaper.addBillImage(url, bill.getBillid()) < 0) {
                    flag = false;
                    msg = "添加失败，请重试";
                }
            }
        } else {
            msg = "添加失败，请重试";
        }
        return new ResultUtil(msg, flag);
    }

    @Override
    public List<DateBills> selectBillByDateAndUid(String year,String month,Integer userId) {
        return billMaper.selectBillByDateAndUid(year,month,userId);
    }

    /**
     * 根据billid删除账单
     *
     * @param billId
     * @return
     */
    @Override
    public boolean deleteBillById(Long billId) {
        return billMaper.deleteBillById(billId);
    }
}
