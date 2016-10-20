package ar.fiuba.tdd.tp.view;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by mvbattan on 19/10/16.
 */
public class ImageResizer {

    private final int rowCount;

    public ImageResizer(int rowCount) {
        this.rowCount = rowCount;
    }

    private Image getScaledImage(Image srcImg, int width, int height){
        System.out.println("WWW: " + width);
        System.out.println("HHH: " + height);
        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, width, height, null);
        g2.dispose();

        return resizedImg;
    }

    public Image getScreenScaledImage(Image image) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double correctedWidth = screenSize.getWidth() / (this.rowCount * 2);
        double correctedHeight = screenSize.getHeight() / (this.rowCount * 2);
        int correctedSize = (int) Math.min(correctedHeight, correctedWidth);
        return getScaledImage(image, correctedSize, correctedSize);
    }
}
