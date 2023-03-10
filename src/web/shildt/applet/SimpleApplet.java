package web.shildt.applet;

import java.applet.Applet;
import java.awt.Graphics;

@SuppressWarnings({ "serial", "removal" })
public class SimpleApplet extends Applet {

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("simple applet", 200, 200);
	}

	
}
