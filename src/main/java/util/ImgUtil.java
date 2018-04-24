package util;

import kisaki.web.entity.Img;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ImgUtil {
    public static List<Img> getImgSize(List<Img> list) throws IOException {
        for (Img img:list) {
            File picture = new File(img.getImgUrl());
            BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
            img.setImg_height(sourceImg.getHeight());
            img.setImg_width(sourceImg.getWidth());
            img.setImg_size(sourceImg.getWidth()/sourceImg.getHeight());
        }

        return list;
    }
}
