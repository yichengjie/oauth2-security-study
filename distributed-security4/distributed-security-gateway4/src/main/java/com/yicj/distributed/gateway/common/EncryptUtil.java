package com.yicj.distributed.gateway.common;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * ClassName: EncryptUtil
 * Description: TODO(描述)
 * Date: 2020/7/15 11:47
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public class EncryptUtil {
    public static final String CHARSET = "UTF-8";

    public static String encodeUTF8StringBase64(String content) {
        try {
            return Base64.getEncoder().encodeToString(content.getBytes(CHARSET)) ;
        }catch (UnsupportedEncodingException e){
            return null ;
        }
    }

    public static String decodeUTF8StringBase64(String content) {
        try {
            byte[] decode = Base64.getDecoder().decode(content.getBytes(CHARSET));
            return new String(decode, CHARSET) ;
        }catch (UnsupportedEncodingException e){
            return null ;
        }
    }


    public static void main(String[] args) {
        // {"name":"yicj","password":"123"}
        String content = "{\"name\":\"yicj\",\"password\":\"123\"}";
        String s = encodeUTF8StringBase64(content);
        String s1 = decodeUTF8StringBase64(s);
        System.out.println(s1);
    }

}
