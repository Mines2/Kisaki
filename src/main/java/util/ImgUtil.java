package util;

import kisaki.web.entity.Img;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Blob;
import java.util.List;

public class ImgUtil {

    public static List<Img> getImgSize(List<Img> list) throws IOException {
        for (Img img : list) {
            File picture = new File(img.getImgUrl());
            BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
            img.setImg_height(sourceImg.getHeight());
            img.setImg_width(sourceImg.getWidth());
            img.setImg_size(sourceImg.getWidth() / sourceImg.getHeight());
        }

        return list;
    }

    public static Img getImgSize(Img img) throws IOException {
        File picture = new File(img.getImgUrl());
        BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
        img.setImg_height(sourceImg.getHeight());
        img.setImg_width(sourceImg.getWidth());
        img.setImg_size(sourceImg.getWidth() / sourceImg.getHeight());


        return img;
    }

    public static Img readAndWriteImg(Img img) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        try {
            fileInputStream = new FileInputStream(img.getImgUrl());
            String s = ImgUtil.class.getClass().getResource("/").getPath() + "/templates/image/upload"
                    + img.getImgUrl().substring(img.getImgUrl().length() - 4, img.getImgUrl().length());
            byte[] bytes = new byte[1024];
            fileOutputStream = new FileOutputStream(new File(s));
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);

            }
            fileOutputStream.flush();
            fileInputStream.close();
            fileOutputStream.close();
            img.setImgUrl(s.replace(ImgUtil.class.getClass().getResource("/").getPath(), ".."));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{

        }
        return img;
    }

}
