package com.springboot.modules.sys;

import com.springboot.common.utils.DateUtils;
import com.springboot.modules.common.ResponseCode;
import com.springboot.modules.common.ServerResponse;
import io.swagger.annotations.*;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

import static com.springboot.modules.common.ConfigurationFileHelper.saveFilePath;

/**
 * @author keith
 * @date 2018-10-14
 */
@Api(value = "文件服务", description = "H5文件上传下载等操作")
@Controller
@RequestMapping(value = "/sys/file")
public class FileHandleController {

    @ApiOperation(value = "上传图片操作", notes = "MuFile上传图片,文件")
    @RequestMapping(value = "muImageUpload", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<StringBuilder> muImageUpload(@ApiParam(name = "pic", value = "图片信息", required = true) MultipartFile[] pic, HttpServletResponse response) {
        StringBuilder networkPath = new StringBuilder();
        try {
            String path = saveFilePath + "/chat_" + "/" + DateUtils.getDate("yyyyMMdd");
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            //遍历
            for (int i = 0; i < pic.length; i++) {
                // 服务器存放路径
                networkPath.append("|").append(saveImg(pic[i], path, pic[i].getOriginalFilename()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("上传图片出现异常");
        }
        if (networkPath != null) {
            return ServerResponse.createBySuccess(networkPath);
        } else {
            return ServerResponse.createByErrorMessage("上传图片出现异常");
        }
    }

    /**
     * 保存文件，直接以multipartFile形式
     *
     * @param multipartFile 文件流
     * @param path          文件保存绝对路径
     * @return 返回文件名
     * @throws IOException
     */
    private static String saveImg(MultipartFile multipartFile, String path, String picName) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String networkPath;
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        picName = String.valueOf(System.currentTimeMillis()) + picName.substring(picName.lastIndexOf("."));
        networkPath = path + "/" + picName;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(networkPath));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return networkPath;
    }

    @ApiOperation(value = "上传图片操作", notes = "parseRequest组件上传图片")
    @RequestMapping(value = "reqImageUpload", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<StringBuilder> imageUpload(HttpServletRequest request) {
        StringBuilder networkPath = new StringBuilder();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        try {
            List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));
            System.out.println(items);
            if (items.size() != 0) {
                for (FileItem item : items) {
                    String picName = item.getName();
                    // 时间戳文件名
                    picName = String.valueOf(System.currentTimeMillis()) + picName.substring(picName.lastIndexOf("."));
                    // 服务器所需路径
                    String path = saveFilePath + "/chat_" + "/" + DateUtils.getDate("yyyyMMdd");
                    File packageFile = new File(path);
                    if (!packageFile.exists() && !packageFile.isDirectory()) {
                        packageFile.mkdirs();
                    }
                    item.write(new File(path, picName));
                    // 拼网络路径
                    networkPath.append("|").append(path).append("/").append(picName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("上传图片出现异常");
        }
        if (!"".equals(networkPath.toString())) {
            return ServerResponse.createBySuccess(networkPath);
        } else {
            return ServerResponse.createByErrorMessage("上传图片出现异常");
        }
    }

    @ApiOperation(value = "下载文件操作", notes = "下载图片,文件")
    @GetMapping(value = "fileDownload")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "filePath", value = "文件所在地路径", required = true)
    })
    public ServerResponse fileDownload(String filePath, HttpServletResponse response) {
        int result = ResponseCode.SUCCESS.getCode();
        FileInputStream fis = null;
        try {
            File file = new File(filePath);
            fis = new FileInputStream(file);
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            IOUtils.copy(fis, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
            result = ResponseCode.ERROR.getCode();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (result == ResponseCode.SUCCESS.getCode()) {
            return ServerResponse.createBySuccess();
        } else {
            return ServerResponse.createByError();
        }
    }
}
