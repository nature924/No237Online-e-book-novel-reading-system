package zl.readCloud.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zl.readCloud.aop.HttpAspect;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangLei
 * Jsoup 工具类
 */
public class JsoupUtil {

    private static final Logger log = LoggerFactory.getLogger(HttpAspect.class);
    /**
     * @param content
     * @return 删除Html标签
     */
    public static String delHTMLTag(String content) {
        content = content.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");

        // 去除字符串中的空格 回车 换行符 制表符 等

        content = content.replaceAll("\\s*|\t|\r|\n", "");

        // 去除空格
        content = content.replaceAll("&nbsp;", "");

        return content;
    }

    /**
     * 字符串转化为UTF-8
     *
     * @param str
     * @return
     */
    public static String toUTF8(String str) {
        String result = str;
        try {
            result = changeCharSet(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;

    }

    /**
     * @param str
     * @param newCharset
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String changeCharSet(String str, String newCharset) throws UnsupportedEncodingException {
        if (str != null) {
            // 用默认字符编码解码字符串。
            byte[] bs = str.getBytes();
            // 用新的字符编码生成字符串
            return new String(bs, newCharset);
        }
        return str;
    }

    /**
     * @param str
     * @return
     */
    public static String sub(String str) {

        if (!str.isEmpty()) {
            return str.substring(str.indexOf("：") + 1);
        }
        return null;
    }

    public static String subContent(String str) {

        if (!str.isEmpty()) {
            return str.substring(0, str.indexOf("http"));
        }
        return null;
    }

    /**
     * 获取链接的document对象
     *
     * @param url  小说的地址
     * @return document
     */
    public static Document getDoc(String url) {
        // Map<String, String> header = new HashMap<String, String>();
        // // 指定请求的服务器的域名和端口号
        // header.put("Host", "http://info.bet007.com");
        // // 客户端使用的操作系统和浏览器的名称和版本响应头  User-Agent的内容包含发出请求的用户信息
        // header.put("User-Agent", "  Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0");
        // // 客户端能接收的资源类型
        // header.put("Accept", "  text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        // // 浏览器可接受的语言
        // header.put("Accept-Language", "zh-cn,zh;q=0.5");
        // // 浏览器可以接受的字符编码集。
        // header.put("Accept-Charset", "  GB2312,utf-8;q=0.7,*;q=0.7");
        // // keep-alive 当一个网页打开完成后，客户端和服务器之间用于传输HTTP数据的TCP连接不会关闭，如果客户端再次访问这个服务器上的网页，
        // // 会继续使用这一条已经建立的连接 Connection: close 代表一个Request完成后，客户端和服务器之间用于传输HTTP数据的TCP连接会关闭，
        // // 当客户端再次发送Request，需要重新建立TCP连接。
        // //     表示是否需要持久连接。
        // header.put("Connection", "keep-alive");
        boolean flag = false;
        Document document = null;
        int i=0;
        do {
            try {
                document = Jsoup
                        .connect(url)
                        .header("Host","www.shuquge.com")
                        .header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                        // 指定浏览器可以支持的web服务器返回内容压缩编码类型。
                        .header("Accept-Encoding","gzip, deflate")
                        .header("Accept-Language","zh-CN,zh;q=0.9")
                        // 指定请求和响应遵循的缓存机制
                        .header("Cache-Control","no-cache")
                        .header("Connection","keep-alive")
                        // 用来包含实现特定的指令  pragma是http/1.1之前版本的历史遗留字段，仅作为与http的向后兼容而定义。
                        .header("Pragma","no-cache")
                        // 在https页面中，如果调用了http资源，那么浏览器就会抛出一些错误。为了改变成这一状况，
                        // chrome(谷歌浏览器)会在http请求中加入 'Upgrade-Insecure-Requests: 1' ，服务器收到请求后
                        // 会返回 "Content-Security-Policy: upgrade-insecure-requests" 头，告诉浏览器，可以把所属本站
                        // 的所有 http 连接升级为 https 连接。
                        .header("Upgrade-Insecure-Requests","1")
                        .timeout(5000)
                        .userAgent("Mozilla")//模拟浏览器
                        .get();
                flag = false;
            } catch (IOException e) {
                i++;
                log.info("获取html失败了"+i+"次");
                flag = true;
            }
        } while (flag);
        return document;
    }

    // public static void main(String[] args) {
    //     Document doc = getDoc("http://www.shuquge.com/txt/8659/33435905.html");
    //     System.out.println("doc = " + doc);
    // }

    public static boolean isConnection(String url) {
        boolean flag = false;
        int counts = 0;
        if (null == url || url.length() <= 0) {
            return flag;
        }
        while (counts < 10) {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url)
                        .openConnection();
                int state = connection.getResponseCode();
                if (state == 200) {
                    flag = true;
                }
                break;
            } catch (Exception e) {
                counts++;
                continue;
            }
        }
        return flag;
    }

}
