package graphiceditor.Controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
final class EditorPanel extends JPanel implements MouseListener {

  private Point mousePosition;
  private EditorControl editorControl;

  EditorPanel(EditorControl control) {
    editorControl = control;
    addMouseListener(this);
  }

  // Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
  // Methode beim EditorFrame oder beim EditorPanel aufruft.
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    editorControl.allesNeuZeichnen(g);
  }

  @Override
  public void mouseClicked(MouseEvent e) {

  }

  @Override
  public void mousePressed(MouseEvent e) {
    System.out.println("Mouse Pressed!");
    editorControl.setErsterPunkt(e.getPoint());
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    System.out.println("Mouse Released!");
    editorControl.erzeugeFigurMitZweitemPunkt(e.getPoint());
    repaint();
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    System.out.println("Mouse entered!");
  }

  @Override
  public void mouseExited(MouseEvent e) {
    System.out.println("Mouse exited!");
  }
}