package view;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class mouseMotion implements MouseMotionListener, MouseListener {
	View view;
	ArrayList<Button> Buttons;
	//SerializeDemo fileLoader;

	public mouseMotion(View view) {
		this.view = view;

		//fileLoader = SerializeDemo.getSerializeDemo(view);

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	    Buttons=new ArrayList<>(view.getState().stateButton(view));
	    for (Iterator iterator = Buttons.iterator(); iterator.hasNext();) {
            Button button = (Button) iterator.next();
            checkOnButton(button,e);
        }
	    }

	private void checkOnButton(Button b, MouseEvent e) {
		if (e.getX() > b.getX() && e.getX() < b.getX() + b.getWidth()
				&& e.getY() > b.getY() && e.getY() < b.getY() + b.getHeight()) {
			b.setMouseOnButton(true);
		} else
			b.setMouseOnButton(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
        Buttons=new ArrayList<>(view.getState().stateButton(view));
        for (Iterator iterator = Buttons.iterator(); iterator.hasNext();) {
            Button button = (Button) iterator.next();
            checkClicked(button,e);
        }
        }

	private void checkClicked(Button b, MouseEvent e) {
		if (b.isMouseOnButton()) {
			b.setClicked(true);
		}
		//else
			//b.setClicked(false);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
