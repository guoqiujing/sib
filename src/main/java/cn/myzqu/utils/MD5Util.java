package cn.myzqu.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * MD5加密工具类
 * Created by 的川 on 2018/5/9.
 */
public class MD5Util {
    /**
     * MD5加密工具类，默认哈希2次
     * @param source 原密码
     * @param salt 加密秘钥
     * @return
     */
    public static String encrypt(String source,String salt) {
        //哈希次数
        int hashIterations = 2;
        Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
        String password_md5 =  md5Hash.toString();
        System.out.println(password_md5);
        return password_md5;
    }

    /**
     * MD5加密工具类
     * @param source 原密码
     * @param salt  加密秘钥
     * @param hashIterations 哈希次数
     * @return
     */

    public static String encrypt(String source,String salt,int hashIterations) {
        Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
        String password_md5 =  md5Hash.toString();
        System.out.println(password_md5);
        return password_md5;
    }

}
