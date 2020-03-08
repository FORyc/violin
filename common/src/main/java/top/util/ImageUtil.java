package top.util;


import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author master
 *  图片工具类，操作图片相关方法
 */
@Slf4j
public class ImageUtil {

    /**
     * 将图片写入磁盘
     * @param bufferedImage 所要写入的图片
     * @param format 图片格式
     * @param file 具体的路径
     * @return 返回是否成功
     */
    public static boolean write2File(BufferedImage bufferedImage, String format, File file){
        boolean flag = false;
        try {
            flag = ImageIO.write(bufferedImage, format, file);
        } catch (IOException e) {
            e.printStackTrace();
            log.warn("保存图片出现异常", e);
        }
        return flag;
    }
}
