package lfc.util;
/**
 * 处理 Controller 中文件保存的问题
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

@Component
public class FileUtil implements ServletContextAware {

    private ServletContext servletContext;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String saveImg(MultipartFile uploadedImageFile ,String imgName) throws Exception {
        String relativeFolderPath = "/img";
        File imageFolder = new File(servletContext.getRealPath(relativeFolderPath));
        if (!imageFolder.exists())
            imageFolder.mkdirs();
        File imageFile = new File(imageFolder, imgName);
        uploadedImageFile.transferTo(imageFile);
        return relativeFolderPath+"/"+imgName;
    }
}
