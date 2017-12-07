package view;


import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

public class Button {

	private boolean mouseOnButton, clicked, moving;
	private int hight, width;
	String Name;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getHight() {
		return hight;
	}

	public void setHight(int hight) {
		this.hight = hight;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	private String type;
	private int x, y;

	public Button() {
		x = 0;
		y = 0;
		mouseOnButton = false;
		clicked = false;
		moving = false;
		hight = 130;
		width = 300;
	}

	public boolean isMouseOnButton() {
		return mouseOnButton;
	}

	public void setMouseOnButton(boolean mouseOnButton) {
		this.mouseOnButton = mouseOnButton;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getHeight() {
		return hight;
	}

	public int getWidth() {
		return width;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void paint(Graphics g, Applet view, URL url) {
		Image buttonImg = view.getImage(url, getImagePath());
		if (mouseOnButton)
			g.drawImage(buttonImg, x - 1, y - 2, view);
		else
			g.drawImage(buttonImg, x, y, view);
	}

	private String getImagePath() {
		
		switch(type){
		
		case "newGame":
			if (mouseOnButton)
				return "images/newGameButton2.png";
			return "images/newGameButton1.png";
		
		case "loadGame":
			if (mouseOnButton)
				return "images/loadGameButton2.png";
			return "images/loadGameButton1.png";
		case "exit":
			if (mouseOnButton)
				return "images/exit2.png";
			return "images/exit1.png";
			
		case "import":
			if (mouseOnButton)
				return "images/importButton2.png";
			return "images/importButton1.png";
			
		case "onePlayer":
			if (mouseOnButton)
				return "images/onePlayerButton2.png";
			return "images/onePlayerButton1.png";
			
		case "twoPlayers":
			if (mouseOnButton)
				return "images/twoPlayersButton2.png";
			return "images/twoPlayersButton1.png";
			
		case "mainMenu":
			if (mouseOnButton)
				return "images/mainMenuButton2.png";
			return "images/mainMenuButton1.png";
			
		case "pause":
			if (mouseOnButton)
				return "images/pauseButton2.png";
			return "images/pauseButton1.png";
			
		case "save":
			if (mouseOnButton)
				return "images/saveButton2.png";
			return "images/saveButton1.png";
			
		case "resume":
			if (mouseOnButton)
				return "images/resumeButton2.png";
			return "images/resumeButton1.png";
		}
		
		
		return null;
	}
}
