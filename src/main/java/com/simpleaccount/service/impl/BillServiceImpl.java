package com.simpleaccount.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.gson.JsonArray;
import com.simpleaccount.entry.Bill;
import com.simpleaccount.entry.BillDetailsVo;
import com.simpleaccount.entry.BillWeekVo;
import com.simpleaccount.entry.DateBills;
import com.simpleaccount.mapper.BillMapper;
import com.simpleaccount.service.BillService;
import com.simpleaccount.util.resultutil.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
            if(!this.addImages(bill.getImages(),bill.getBillid())){
                flag = false;
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

    @Override
    public BillDetailsVo queryBillDetailsById(Long billId,Long userId) {
        return billMaper.queryBillDetailsById(billId,userId);
    }

    /**
     * 更新bill
     *
     * @param bill
     * @return
     */
    @Override
    public ResultUtil updateBill(Bill bill) {
        ResultUtil resultUtil = null;
        String msg = "更新成功";
        bill.setUpdatetime(new Timestamp(System.currentTimeMillis()));
        try{
            billMaper.deleteBillImagesById(bill.getBillid());
            if(bill.getImages().length >0){
                this.addImages(bill.getImages(),bill.getBillid());
            }
            billMaper.updateBill(bill);
        }catch (Exception e){
            msg = "更新失败";
        }
        return new ResultUtil(msg);
    }

    /**
     * 根据id删除关联图片
     *
     * @param billId
     * @return
     */
    @Override
    public boolean deleteBillImagesById(Long billId) {
        return billMaper.deleteBillImagesById(billId) > 0;
    }

    @Override
    public boolean addImages(String[] images,Long billId) {
        boolean flag = true;
        for (String url : images) {
            if (billMaper.addBillImage(url, billId) < 0) {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 根据用户id查询用户本周消费分类和金额
     *
     * @param userId
     * @return
     */
    @Override
    public List<BillWeekVo> queryWeekBill(Long userId) {
        return billMaper.queryWeekBill(userId);
    }
}
