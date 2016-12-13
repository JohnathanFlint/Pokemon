package poke.view;

import javax.swing.JFrame;
import poke.controller.PokemonController;
import java.awt.*;

public class PokemonFrame extends JFrame
{
	private PokemonController baseController;
	private PokemonPanel appPanel;
	
	public PokemonFrame (PokemonController baseController)
	{
		super();
		this.baseController = baseController;
		appPanel = new PokemonPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Pokemon");
		GraphicsDevice screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = screen.getDisplayMode().getWidth();
		int height = screen.getDisplayMode().getHeight();
		int windowWidth = width - width/2;
		int windowHeight = height - height/2;
		int xPos = (width - windowWidth)/2;
		int yPos = (height - windowHeight)/2;
		this.setLocation(xPos, yPos);
		this.setSize(new Dimension(windowWidth, windowHeight));
		this.setResizable(false);
		this.setVisible(true);
	}
}
