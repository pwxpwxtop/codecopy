package pwx.codecopy.util.r;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: pwx
 * @data: 2022/9/10 17:48
 * @version: 1.0
 */
@Data
public class R extends ResultLog implements Serializable {
    private static final long serialVersionUID = 1123123123123L;

    private Code code;  //返回状态,成功和失败
    private String errMsg;//异常信息
    private String msg; //报的错误异常消息
    private Object data; //需要数据
    private Long total; //表格数量
    private Long count; //更新的数据条数

    public static R ok(Page page){
        return ok(page,  null);
    }

    public static R ok(Page page, String msg){
        R result = new R();
        result.setCode(Code.ok);
        result.setCount(result.getCount());
        result.setData(page.getRecords());
        result.setMsg(msg);
        result.setTotal(page.getTotal());
        return result;
    }


    //成功的消息
    public static R ok(){
        return ok(null, null, null, null);
    }

    public static R ok(String msg){
        return ok(null, msg, null, null);
    }

    //成功的消息,count 数据记录条数
    public static  R ok(Long count){
        return ok(null, null, count, null);
    }


    public static  R ok(Object obj){
        return ok(obj, null, null, null);
    }

    public static R ok(Object obj, long count){
        return ok(obj, null, count, null);
    }

    public static  R ok(Object obj, String msg){
        return ok(obj, msg, null, null);
    }


    public static R ok(Object obj, String msg, Long count, Long total){
        R result = new R();
        result.setCode(Code.ok);
        result.setCount(count);
        result.setData(obj);
        result.setMsg(msg);
        result.setTotal(total);
        return result;
    }


    public static R no(String msg){
       return no(msg, null);
    }

    public static R no( String msg, Object obj){
        logger.error(msg);
        R result = new R();
        result.setCode(Code.no);
        result.setData(obj);
        result.setMsg(msg);
        return result;
    }

    public static R err(){
        return err(null, null);
    }
    public static R err(String msg){
        return err(msg, null);
    }

    public static R err(Exception e){
        return err(null, e);
    }



    public static R err(String msg, Exception e){
        logger.error(msg);
        R result = new R();
        if (e != null){
            result.setErrMsg(e.getMessage());
        }
        result.setMsg(msg);
        return result;
    }





    //工具类,返回解析后的map
    private static Map<String, Object> returnMap(R result){
        Map<String, Object> maps = new HashMap<>();
        Field [] fields =  result.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            Object obj = null;
            try {
                obj = fields[i].get(result);
                if (obj != null){
                    maps.put(fields[i].getName(), obj);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return maps;
    }

}
