package com.simpleaccount.util.imagesutil;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @Description: 文件上传工具类
 * @Author: Whyza
 * @CreateDate: 2019/4/17 11:46
 * @Version: 1.0
 */
public class FtpUtil {
    private static final String FTP_ADDRESS = "193.112.11.253";
    private static final int FTP_PORT = 21;
    private static final String FTP_USERNAME = "root";
    private static final String FTP_PASSWORD = "ls892903912";
    private static final String FTP_BASEPATH = "/upload";

    public static boolean uploadFile(String fileName,InputStream inputStream)  throws IOException{
        boolean result = false;
        // 1. 创建一个FtpClient对象
        FTPClient ftpClient = new FTPClient();
        try {
            // 2. 创建 ftp 连接
            ftpClient.connect(FTP_ADDRESS, FTP_PORT);
            // 3. 登录 ftp 服务器
            ftpClient.login(FTP_USERNAME, FTP_PASSWORD);
            // 获取连接ftp 状态返回值
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                // 如果返回状态不再 200 ~ 300 则认为连接失败
                ftpClient.disconnect();
                return false;
            }
            // 4. 读取本地文件
            // FileInputStream inputStream = new FileInputStream(new
            // File("F:\\hello.png"));
            // 5. 设置上传的路径
            ftpClient.changeWorkingDirectory(FTP_BASEPATH);
            // 6. 修改上传文件的格式为二进制
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            // 7. 服务器存储文件，第一个参数是存储在服务器的文件名，第二个参数是文件流
            if (!ftpClient.storeFile(fileName, inputStream)) {
                return result;
            }
            // 8. 关闭连接
            inputStream.close();
            ftpClient.logout();
            result = true;
        } catch (MaxUploadSizeExceededException e) {

        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }
}
