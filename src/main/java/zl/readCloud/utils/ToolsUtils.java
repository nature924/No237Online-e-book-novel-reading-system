package zl.readCloud.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * @author ZhangLei
 * @Description:
 * @date 2021/11/5 11:36
 */
@Component
public class ToolsUtils {

    @Value("${winResource.imgPath}")
    public String winFilePath;

    // 无图片时加载的默认图片路径
    public static final String DEFAULT_IMG = "default_novel_img/default.jpg";
    // 书籍照片类型
    private static final Integer TYPE_IMG_BOOK = 1;
    // banner照片类型
    private static final Integer TYPE_IMG_BANNER = 2;
    private static final String IMG_BANNER_FOLDER = "banner";
    // 广告照片类型
    private static final Integer TYPE_IMG_ADVERTISEMENT = 3;
    private static final String IMG_ADVERTISEMENT_FOLDER = "advertisement";



    // 上传照片
    public String uploadImg(MultipartFile file, Integer typeImg) throws Exception {
        String suffix = "";
        String filepathF = "";
        String filepath = "";
        if (file != null) {
            // 获取文件上传时的文件名
            String originalName = file.getOriginalFilename();
            // 获取后缀名
            suffix = originalName.substring(originalName.lastIndexOf(".") + 1);
            // 获取一个8位的uuid名字
            String[] uuid8 = UUID.randomUUID().toString().split("-");
            String uuid = uuid8[0];
            // 定义上传的图片存储的相对路径及名字
            if (typeImg == TYPE_IMG_BOOK) {
                String dateStr = "";
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateStr = simpleDateFormat.format(date);
                filepath += dateStr + "/" + uuid + "." + suffix;
            }else if (typeImg == TYPE_IMG_BANNER) {
                filepath += IMG_BANNER_FOLDER + "/" + uuid + "." + suffix;
            }else if (typeImg == TYPE_IMG_ADVERTISEMENT) {
                filepath += IMG_ADVERTISEMENT_FOLDER + "/" + uuid + "." + suffix;
            }
            filepathF = System.getProperty("user.dir") + winFilePath + filepath;
            File files = new File(filepathF);
            // 是否含有文件夹
            if (!files.getParentFile().exists()) {
                files.getParentFile().mkdirs();
            }
            file.transferTo(files);
        }else if (file == null && typeImg == TYPE_IMG_BOOK) {
            filepathF = DEFAULT_IMG;
        }
        if (!filepathF.equals("")){
            return filepath;
        }else {
            return null;
        }
    }

    /**
     * 获取照片地址
     * @param imgPath
     * @return
     */
    public static String getImgPath(String imgPath) {
        return "http://127.0.0.1:8001/" + imgPath;
    }




}
