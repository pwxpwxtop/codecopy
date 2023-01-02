package pwx.codecopy.conf;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author pwx
 * @version 1.0
 * @describe 实体类自动填充配置
 * @date 2022/9/2 8:40
 */
@Configuration
@Component
public class MyBatisObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        String id = (String) StpUtil.getLoginId();
        setFieldValByName("createTime", new Date(), metaObject);    //创建时间
        setFieldValByName("createBy",id, metaObject);               //创建人
        setFieldValByName("updateTime", new Date(), metaObject);    //更新时间
        setFieldValByName("updateBy", id, metaObject);              //更新人
        setFieldValByName("state", 0, metaObject);          //启用状态
        setFieldValByName("deleteState", 0, metaObject);    //删除状态
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        String id = (String) StpUtil.getLoginId();
        setFieldValByName("updateTime", new Date(), metaObject);    //更新时间
        setFieldValByName("updateBy", id, metaObject);              //更新人
    }



}
