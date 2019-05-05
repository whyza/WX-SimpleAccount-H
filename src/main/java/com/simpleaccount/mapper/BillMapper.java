package com.simpleaccount.mapper;

import com.simpleaccount.entry.Bill;
import com.simpleaccount.entry.BillDetailsVo;
import com.simpleaccount.entry.BillWeekVo;
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

    /**
     * 根据billid查询bill信息
     * @param billId
     * @return
     */
    BillDetailsVo queryBillDetailsById(@Param(value = "billId")Long billId,@Param(value = "userId")Long userId);

    /**
     * 更新bill
     * @param bill
     * @return
     */
    int updateBill(Bill bill);

    /**
     * 根据id删除关联图片
     * @param billId
     * @return
     */
    int deleteBillImagesById(@Param(value = "billId")Long billId);


    /**
     * 根据用户id查询用户本周消费分类和金额
     * @param userId
     * @return
     */
    List<BillWeekVo> queryWeekBill(@Param(value = "userId")Long userId);
}
