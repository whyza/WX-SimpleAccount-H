package com.simpleaccount.mapper;

import com.simpleaccount.entry.BillClassfyTree;
import com.simpleaccount.entry.Billclassify;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.URL;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/21 12:22
 * @Version: 1.0
 */
public interface BillClassfyMapper {
    /**
     * 查询所有二级分类
     * @return
     */
    List<Billclassify>  queryAllBillClassfy(@Param(value = "classfyId") Integer classfyId, @Param(value = "userId") Integer userId, @Param(value = "classifyType")Integer classifyType);

    /**
     * 查询所有一级分类
     * @return
     */
    List<BillClassfyTree> queryBigBillClassfy(@Param(value = "classifyType")Integer classifyType);



    /**
     * 查询所有二级分类
     * @param userId
     * @param classifyType
     * @return
     */
    List<Billclassify> queryAllTwoClassify(@Param(value = "userId")Integer userId,@Param(value = "classifyType")Integer classifyType);

    /**
     * 管理员分类查询
     * @param classfyId
     * @param classifyType
     * @return
     */
    List<Billclassify> queryAdminClassify(@Param(value = "classfyId")Integer classfyId,@Param(value = "classifyType")Integer classifyType);

    int updateBillClassify(Billclassify billclassify);

    int AddClassify(Billclassify billclassify);

    /**
     * 根据userId查询用户的账单分类信息
     * @param userId
     * @param classifyType
     * @return
     */
    List<Billclassify> setleftSelectData(@Param(value = "userId")Integer userId,@Param(value = "classifyType")Integer classifyType);

}
