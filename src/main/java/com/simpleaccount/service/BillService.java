package com.simpleaccount.service;

import com.simpleaccount.entry.Bill;
import com.simpleaccount.entry.BillDetailsVo;
import com.simpleaccount.entry.BillWeekVo;
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

    /**
     * 查询billdetail通过id
     * @param billId
     * @param userId
     * @return
     */
    BillDetailsVo queryBillDetailsById(Long billId,Long userId);
    /**
     * 更新bill
     * @param bill
     * @return
     */
    ResultUtil updateBill(Bill bill);

    /**
     * 根据id删除关联图片
     * @param billId
     * @return
     */
    boolean deleteBillImagesById(@Param(value = "billId")Long billId);

    boolean addImages(String[] images,Long billId);


    /**
     * 根据用户id查询用户本周消费分类和金额
     * @param userId
     * @return
     */
    List<BillWeekVo> queryWeekBill(Long userId);
}
