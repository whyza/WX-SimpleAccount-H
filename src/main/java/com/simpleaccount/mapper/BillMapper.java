package com.simpleaccount.mapper;

import com.simpleaccount.entry.Bill;
import com.simpleaccount.entry.DateBills;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 根据用户id和年月查询账单信息
     * @param year
     * @param month
     * @param userId
     * @return
     */
    List<DateBills> selectBillByDateAndUid(@Param(value = "year")String year, @Param(value = "month")String month, @Param(value = "userId")Integer userId);

    /**
     * 根据billid删除账单
     * @param billId
     * @return
     */
    boolean deleteBillById(@Param(value = "billId")Long billId);
}
