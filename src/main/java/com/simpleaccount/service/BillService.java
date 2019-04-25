package com.simpleaccount.service;

import com.simpleaccount.entry.Bill;
import com.simpleaccount.util.resultutil.ResultUtil;

/**
 * @Description: bill Service
 * @Author: Whyza
 * @CreateDate: 2019/4/25 9:48
 * @Version: 1.0
 */
public interface BillService {
    /**
     * 添加账单
     * @param bill
     * @return
     */
    ResultUtil addBill(Bill bill);
//
//    /**
//     * 账单图片
//     * @param imageUrl
//     * @param billId
//     * @return
//     */
//    Boolean addBillImage(String imageUrl,Integer billId);
}
