package com.cnarj.ttxs.util;

import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: liz
 * Date: 13-7-5
 * Time: 上午9:45
 * 上传图片工具类
 */
public class UploadFileUtils {
    private static Log log = LogFactory.getLog(UploadFileUtils.class);

    //获取linux服务器中保存商品图片的目录
    public static String getUploadFilePath(){
        InputStream in = null;
        Properties p = new Properties();
        try {
            in = PropertiesUtil.class.getResourceAsStream("/conf.properties");
            p.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p.getProperty("upload.dir").trim();
    }

    //获取linux服务器中广告图片的目录
    public static String getAdvPicPath(){
        InputStream in = null;
        Properties p = new Properties();
        try {
            in = PropertiesUtil.class.getResourceAsStream("/conf.properties");
            p.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p.getProperty("advPic.dir").trim();
    }

    //获取前台路径
    public static String getIndexPath(){
        InputStream in = null;
        Properties p = new Properties();
        try {
            in = PropertiesUtil.class.getResourceAsStream("/conf.properties");
            p.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p.getProperty("index.dir").trim();
    }


    //压缩图片
    public static void compressImages(String diskFilePath, String[] sizes) {
        String compressImagePre = diskFilePath.substring(0, diskFilePath.lastIndexOf("."));
        String compressImageBack = diskFilePath.substring(diskFilePath.lastIndexOf("."));
        for (String size : sizes) {
            String[] wh = size.split("X");
            String imgFilePath = String.format("%s_%s%s", compressImagePre, size, compressImageBack);
            compress(diskFilePath, imgFilePath, Integer.parseInt(wh[0]), Integer.parseInt(wh[1]));
        }
    }


    /**
     * it depended jmagick, so u must make the jmagick.dll in java.libaray path
     * @param srcFilePath the source image
     * @param destFilePath the target image
     * @param width width of target image
     * @param height height of target image
     */
    private static void compress(String srcFilePath, String destFilePath, int width, int height) {
        File input = new File(srcFilePath);
        if (!input.exists()) {
            throw new IllegalArgumentException(String.format("image %s not found!", srcFilePath));
        }
        Image imageOriginal;
        try {
            imageOriginal = ImageIO.read(input);
        } catch (IOException e) {
            throw new IllegalStateException("read image failed!", e);
        }
        int w = imageOriginal.getWidth(null);
        int h = imageOriginal.getHeight(null);
        if (width > w) width = w;
        if (height > h) height = h;
        if (width > height) {
            if (height == h || h < w) height = (h * width) / w;
            else width = (w * height) / h;
        } else {
            if (width == w || h > w) width = (w * height) / h;
            else height = (h * width) / w;
        }
        try {
            imageMagick(new File(srcFilePath).getAbsolutePath(), new File(destFilePath).getAbsolutePath(), width, height);
            //compressToSquarePic(new File(destFilePath).getAbsolutePath(), new File(destFilePath).getAbsolutePath(), 1f);
        } catch (MagickException e) {
            throw new IllegalStateException("jmagick exception!", e);
        }
    }

    private static void imageMagick(String srcFilePath, String destFilePath, int width, int height) throws MagickException {
        try {
            log.info(String.format("compress source image : %s", srcFilePath));
            System.setProperty("jmagick.systemclassloader", "no");
            ImageInfo info = new ImageInfo(srcFilePath);
            MagickImage image = new MagickImage(info);
            MagickImage scaleImg = image.scaleImage(width, height);
            scaleImg.setFileName(destFilePath);
            scaleImg.writeImage(info);
            image = null;
            scaleImg = null;
            log.info(String.format("compress destination image %s success!", destFilePath));
        } catch (Throwable t) {
            log.error("call imageMagick error!", t);
            throw new RuntimeException("call imageMagick error!", t);
        }

    }




}
