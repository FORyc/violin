package top.util;

import java.io.File;
import java.io.IOException;

/**
 * @author 9527
 * 文件操作类
 */
public class FileUtils {

    public static void main(String[] arg) throws IOException {
    }

    /**
     * 查找指定路径下的所有文件
     */
    public static File[] selectFiles(String path) throws IOException {
        File file = new File(path);
        if (!file.exists() || !file.canRead()){
            throw new IOException();
        }
        return file.listFiles();
    }
}
