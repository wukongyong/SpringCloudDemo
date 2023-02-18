package wkyyzl.cn.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author wukongyong
 * @since 2023-02-18
 */
@Data
@TableName("tb_product")
public class Product extends Model<Product> {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 价格
     */
    private Long price;

    /**
     * 产品描述
     */
    private String productDesc;

    /**
     * 说明
     */
    private String caption;

    /**
     * 库存
     */
    private Integer inventory;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
