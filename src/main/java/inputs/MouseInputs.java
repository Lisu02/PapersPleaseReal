package inputs;

import gamestates.Stan;
import gamestates.Stangry;
import org.main.GraPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {

    private GraPanel graPanel;

    public MouseInputs(GraPanel graPanel){this.graPanel = graPanel;}
    @Override
    public void mouseClicked(MouseEvent e) {
        switch (Stangry.state){
            case MENU -> graPanel.getGra().getMenu().mouseClicked(e);
            case GRANIE -> graPanel.getGra().getGranie().mouseClicked(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (Stangry.state){
            case MENU -> graPanel.getGra().getMenu().mousePressed(e);
            case GRANIE -> graPanel.getGra().getGranie().mousePressed(e);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (Stangry.state){
            case MENU -> graPanel.getGra().getMenu().mouseReleased(e);
            case GRANIE -> graPanel.getGra().getGranie().mouseReleased(e);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (Stangry.state){
            case GRANIE -> graPanel.getGra().getGranie().mouseDragged(e);
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (Stangry.state){
            case MENU -> graPanel.getGra().getMenu().mouseMoved(e);
            case GRANIE -> graPanel.getGra().getGranie().mouseMoved(e);
        }

    }
}
