package com.simpleaccount.mapper;

import com.simpleaccount.entry.Bill;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 账单mapper接口
 * @Author: Whyza
 * @CreateDate: 2019/4/25 9:48
 * @Version: 1.0
 */
public interface BillMapper{
    /**
     * 添加账单
     * @param bill
     * @return
     */
    int addBill(Bill bill);

    /**
     * 账单图片
     * @param imageUrl
     * @param billId
     * @return
     */
    int addBillImage(@Param(value = "imageUrl") String imageUrl, @Param(value = "billId") Long billId);
}
