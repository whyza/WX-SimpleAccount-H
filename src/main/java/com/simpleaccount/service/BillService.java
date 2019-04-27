package com.simpleaccount.service;

import com.simpleaccount.entry.Bill;
import com.simpleaccount.entry.DateBills;
import com.simpleaccount.util.resultutil.ResultUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: bill Service
 * @Author: Whyza
 * @CreateDate: 2019/4/25 9:48
 * @Version: 1.0
 */
public interface BillService {
    /**
     * 添加账单
     *
     * @param bill
     * @return
     */
    ResultUtil addBill(Bill bill);

    /**
     * 根据用户id和年月查询账单信息
     * @param year
     * @param month
     * @param userId
     * @return
     */
    List<DateBills> selectBillByDateAndUid(String year,String month,Integer userId);
    /**
     * 根据billid删除账单
     * @param billId
     * @return
     */
    boolean deleteBillById(Long billId);
}
