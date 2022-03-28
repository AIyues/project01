package com.team11.server.util.file;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Configuration
public class GetFilesUtil {
    public static List getFiles(MultipartFile[] files, HttpServletRequest request) {
        List list = new ArrayList();
        for (int i = 0; i < files.length; i++) {
            //保存文件到本地文件，并保存路径到数据库
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Calendar calendar = Calendar.getInstance();
            String fileName = df.format(calendar.getTime()) + files[i].getOriginalFilename();

            //文件类型
//            String fileType = FileTypeUtil.getFileTypeBySuffix(fileName);

            //保存文件的绝对路径
            String filePath = request.getSession().getServletContext().getRealPath("static/"); //项目下static目录
//                String filePath = "src/main/resources/static/cFiles/";//上传到项目的地址

            try {
                //上传文件
                FilesUploadUtil.uploadFile(files[i].getBytes(), filePath, fileName);
                list.add(fileName);
//                list.add(fileType);
                list.add(filePath + fileName);
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
