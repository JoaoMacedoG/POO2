package modelo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageTest {

BufferedImage img = null;{

	try
	{
		img = ImageIO.read(new File("resources/imagem.jpg"));
	}catch(
	IOException e)
	{
	}
}}