package com.feri.onedrive.api.msg;

import com.alibaba.fastjson.JSON;
import com.feri.onedrive.api.dao.CarIndexDao;
import com.feri.onedrive.api.model.CarIndex;
import com.feri.onedrive.api.util.RedissonUtil;
import com.feri.onedrive.common.config.RedisKeyConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: OneDrive
 * @description: 监听RabbitMQ 的队列信息的变化
 * @author: Feri
 * @create: 2019-09-25 11:00
 */
@Component
public class EsCarMsg {

    @Autowired
    private CarIndexDao carIndexDao;
    @RabbitListener(queues = "escar")
    public void recMsg(String msg){
        System.out.println("消息监听器："+msg);
        //从Redis 内容  三个key
        //获取数据
        List<String> adds= RedissonUtil.getList(RedisKeyConfig.ES_ADDKEY);
        if(adds!=null){
            //有数据 新增到ES服务器
            //获取新增的数据源 转换为对象
            List<CarIndex> carIndices=new ArrayList<>();
            for(String s:adds){
                carIndices.add(JSON.parseObject(s,CarIndex.class));
            }
            //将数据添加到ES服务器中
            carIndexDao.saveAll(carIndices);
            //清空List集合的数据
            RedissonUtil.delList(RedisKeyConfig.ES_ADDKEY);
        }
        //删除
        List<String> dels=RedissonUtil.getList(RedisKeyConfig.ES_DELKEY);
        if(dels!=null){
            //有删除
            //删除ES中的数据
            for(String s:dels) {
                carIndexDao.deleteById(Integer.parseInt(s));
            }
            //清空Redis 中的数据
            RedissonUtil.delList(RedisKeyConfig.ES_DELKEY);
        }
        //修改
        List<String> updates=RedissonUtil.getList(RedisKeyConfig.ES_UPDATEKEY);
        if(updates!=null){
            List<CarIndex> carIndices=new ArrayList<>();
            for(String s:updates){
                carIndices.add(JSON.parseObject(s,CarIndex.class));
            }
            carIndexDao.saveAll(carIndices);
            //清空Redis 中的数据
            RedissonUtil.delList(RedisKeyConfig.ES_UPDATEKEY);
        }
    }
}
