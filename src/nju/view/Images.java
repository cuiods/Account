package nju.view;

import java.awt.Image;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Images {
	protected static ImageIcon createImageIcon(String path){
		ImageIcon icon = new ImageIcon(path);
		return icon;
	}
	protected static Image createImage(String path) {
		try {
			Image image = ImageIO.read(new FileInputStream(path));
			return image;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
	public static final Image BACKGROUND_IMAGE = createImage("Images/background.png");
	public static final Image BASE_IMAGE = createImage("Images/base.png");
	public static final Image BASE1_IMAGE = createImage("Images/base1.png");
    public static final Image BACK_IMAGE = createImage("Images/3127.png");
	public static final Image ADD_IMAGE = createImage("Images/ADD_PANEL.png");
	public static final Image AMOUNT_IMAGE = createImage("Images/amount.png");
	public static final Image KIND_IMAGE = createImage("Images/kind.png");
}
