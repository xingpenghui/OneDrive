package com.feri.onedrive.entity.car;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-18 10:00
 */
@Data
@TableName("t_carbrand")
public class CarBrand {
   @TableId(type = IdType.AUTO)
   private int id;
   private String name;
   private String imgurl;
   private String info;
   private String country ;
}
