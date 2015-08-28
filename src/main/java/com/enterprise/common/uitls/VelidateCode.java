package com.enterprise.common.uitls;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 
 * Description：验证码生成器
 * 
 * @author Chang
 * 
 */
public class VelidateCode {
	// 图片的宽度
	private int width = 160;
	// 图片的高度
	private int height = 40;
	// 验证码字符个数
	private int codeCount = 5;
	// 验证码干扰线数
	private int lineCount = 150;
	// 验证码
	private String code = null;
	// 验证码图片Buffer
	private BufferedImage bufferedImage = null;
	// 验证码内容
	private char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
			'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	// 无参构造
	public VelidateCode() {
		super();
		this.createCode();
	}

	// 可设置宽度和高度
	public VelidateCode(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.createCode();
	}

	// 可设置高度、宽度、字符个数、干扰线数
	public VelidateCode(int width, int height, int codeCount, int lineCount) {
		super();
		this.width = width;
		this.height = height;
		this.codeCount = codeCount;
		this.lineCount = lineCount;
		this.createCode();
	}

	// 生成验证码（包括验证码字符及图片）
	private void createCode() {

		float x = 0, codeY = 0;
		int red = 0, green = 0, blue = 0;// 三原色

		x = (width / (codeCount + 2))*1.2f;// 每个字符的宽度
		codeY = height - 4;
		
		//
		Random random = new Random();

		// 图像Buffer
		this.bufferedImage = new BufferedImage(this.width, this.height,
				BufferedImage.TYPE_INT_RGB);
		// 画笔
		Graphics2D g = bufferedImage.createGraphics();

		// 将图像填充为白色
		g.setColor(Color.WHITE);
		// 设置图像大小
		g.fillRect(0, 0, this.width, this.height);
		// 设置字体
		g.setFont(new Font("黑体", Font.ITALIC, this.height));

		// randomCode记录随机产生的验证码
		StringBuffer randomCode = new StringBuffer();
		// 随机产生codeCount个字符的验证码
		for (int i = 0; i < this.codeCount; i++) {
			String strRand = String.valueOf(codeSequence[random
					.nextInt(codeSequence.length)]);
			// 产生随机的颜色值，让输出的每个字符的颜色值都将不同
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			// 设置颜色
			g.setColor(new Color(red, green, blue));
			// 绘制字符
			g.drawString(strRand, (0.5f+i)* x, codeY-(codeY/5)*random.nextFloat());
			// 将产生的四个随机数组合在一起。
			randomCode.append(strRand);
		}
		
		this.code = randomCode.toString();
		
		// 绘制干扰线
		for (int i = 0; i < this.lineCount; i++) {
			// 生成随机坐标
			int xs = random.nextInt(this.width);
			int ys = random.nextInt(this.height);
			int xe = random.nextInt(this.width);
			int ye = random.nextInt(this.height);
			// 生成随机颜色
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			// 设置颜色
			g.setColor(new Color(red, green, blue));
			// 绘制干扰线
			g.drawLine(xs, ys, xe, ye);
		}
	}

	// 将验证码图片写到文件里
	public void write(String path) throws IOException {
		OutputStream sos = new FileOutputStream(path);
		this.write(sos);
	}

	// 将验证码图片写到输出流中
	public void write(OutputStream sos) throws IOException {
		ImageIO.write(this.bufferedImage, "png", sos);
		sos.close();
	}

	// 对外返回验证码图片
	public BufferedImage getBuffImg() {
		return this.bufferedImage;
	}

	// 对外返回验证码字符
	public String getCode() {
		return code;
	}

}
