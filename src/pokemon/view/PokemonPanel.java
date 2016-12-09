package pokemon.view;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.*;
import pokemon.controller.PokemonController;

public class PokemonPanel extends JPanel
{
	private PokemonController baseController;
	private SpringLayout baseLayout;
	private JButton updateButton;
	private JComboBox pokedexSelector;
	private JLabel pokemonLabel;
	private JLabel healthLabel;
	private JLabel combatLabel;
	private JLabel speedLabel;
	private JLabel numberLabel;
	private JLabel advancedLabel;
	private ImageIcon pokemonIcon;
	private JTextField healthField;
	private JTextField combatField;
	private JTextField speedField;
	private JTextField nameField;
	private JTextField numberField;
	private JTextArea advancedArea;
	private JLabel nameLabel;
	
	public PokemonPanel(PokemonController baseController)
	{
		super();
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		advancedArea = new JTextArea(5, 25);
		
		updateButton = new JButton("Update Stats");
		
		pokedexSelector = new JComboBox(baseController.getPokemon());
		baseLayout.putConstraint(SpringLayout.WEST, pokedexSelector, 10, SpringLayout.WEST, this);
		healthLabel = new JLabel("Health");
		combatLabel = new JLabel("Combat Points");		
		speedLabel = new JLabel("Speed");		
		numberLabel = new JLabel("Number");
		
		advancedLabel = new JLabel("Types");
		
		healthField = new JTextField(5);
		
		combatField = new JTextField(5);
		
		speedField = new JTextField(5);
		
		nameField = new JTextField(5);
		
		numberField = new JTextField(5);
		
		pokemonIcon = new ImageIcon(getClass().getResource("picture/pokeball.png"));
		pokemonLabel = new JLabel(pokemonIcon, SwingConstants.CENTER);
		baseLayout.putConstraint(SpringLayout.NORTH, pokemonLabel, 161, SpringLayout.NORTH, combatLabel);
		baseLayout.putConstraint(SpringLayout.WEST, pokemonLabel, 0, SpringLayout.WEST, pokedexSelector);
		baseLayout.putConstraint(SpringLayout.SOUTH, pokemonLabel, 0, SpringLayout.SOUTH, advancedArea);
		baseLayout.putConstraint(SpringLayout.EAST, pokemonLabel, 276, SpringLayout.WEST, pokedexSelector);
		
		nameLabel = new JLabel("Name");
		
		
		setupAdvancedArea();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupAdvancedArea()
	{
		advancedArea.setEditable(false);
		advancedArea.setEnabled(false);
		advancedArea.setWrapStyleWord(true);
		advancedArea.setLineWrap(true);
	}
	
	private void setupPanel()
	{
		this.setPreferredSize(new Dimension(900, 600));
		this.setLayout(baseLayout);
		this.setBackground(Color.DARK_GRAY);
		this.add(advancedArea);
		this.add(updateButton);
		this.add(pokedexSelector);
		this.add(pokemonLabel);
		this.add(healthLabel);
		this.add(combatLabel);
		this.add(speedLabel);
		this.add(numberLabel);
		this.add(advancedLabel);
		this.add(healthField);
		this.add(combatField);
		this.add(speedField);
		this.add(nameField);
		this.add(numberField);
		this.add(nameLabel);
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, advancedArea, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, advancedArea, -6, SpringLayout.NORTH, updateButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, updateButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, updateButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, combatLabel, 0, SpringLayout.EAST, healthLabel);
		baseLayout.putConstraint(SpringLayout.EAST, numberLabel, 0, SpringLayout.EAST, nameLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, nameLabel, 6, SpringLayout.NORTH, nameField);
		baseLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, updateButton);
		baseLayout.putConstraint(SpringLayout.NORTH, healthField, 15, SpringLayout.SOUTH, numberField);
		baseLayout.putConstraint(SpringLayout.NORTH, numberLabel, 6, SpringLayout.NORTH, numberField);
		baseLayout.putConstraint(SpringLayout.NORTH, numberField, 6, SpringLayout.SOUTH, nameField);
		baseLayout.putConstraint(SpringLayout.EAST, numberField, 0, SpringLayout.EAST, advancedArea);
		baseLayout.putConstraint(SpringLayout.NORTH, speedLabel, 16, SpringLayout.SOUTH, combatLabel);
		baseLayout.putConstraint(SpringLayout.EAST, speedLabel, 0, SpringLayout.EAST, healthLabel);
		baseLayout.putConstraint(SpringLayout.EAST, healthLabel, 0, SpringLayout.EAST, numberLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, pokedexSelector, 2, SpringLayout.NORTH, nameField);
		baseLayout.putConstraint(SpringLayout.NORTH, nameField, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, nameField, 0, SpringLayout.EAST, advancedArea);
		baseLayout.putConstraint(SpringLayout.WEST, advancedLabel, 0, SpringLayout.WEST, advancedArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, advancedLabel, -6, SpringLayout.NORTH, advancedArea);
		baseLayout.putConstraint(SpringLayout.NORTH, speedField, 4, SpringLayout.SOUTH, combatField);
		baseLayout.putConstraint(SpringLayout.EAST, speedField, 0, SpringLayout.EAST, advancedArea);
		baseLayout.putConstraint(SpringLayout.NORTH, combatLabel, 6, SpringLayout.NORTH, combatField);
		baseLayout.putConstraint(SpringLayout.NORTH, combatField, 6, SpringLayout.SOUTH, healthField);
		baseLayout.putConstraint(SpringLayout.WEST, combatField, 0, SpringLayout.WEST, healthField);
		baseLayout.putConstraint(SpringLayout.NORTH, healthLabel, 6, SpringLayout.NORTH, healthField);
		baseLayout.putConstraint(SpringLayout.EAST, healthField, 0, SpringLayout.EAST, advancedArea);
	}
	
	private void setupListeners()
	{
		this.addMouseListener(new MouseListener()
		{
			public void mouseEntered(MouseEvent entered)
			{
				//JOptionPane.showMessageDialog
			}
			
			public void mouseExited(MouseEvent exited)
			{
				
			}
			
			public void mousePressed(MouseEvent pressed)
			{
				
			}
			
			public void mouseReleased(MouseEvent released)
			{
				
			}
			
			public void mouseClicked(MouseEvent clicked)
			{
				
			}
			
			public void mouseMoved(MouseEvent moved)
			{
				JOptionPane.showMessageDialog(baseController.getBaseFrame(), "The mouse was clicked!");
			}
		});
		
		public void setRandomColor()
		{
			
		}
		
		this.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseDragged(MouseEvent dragged)
			{
				//setRandomColor();
			}
			
			public void mouseMoved(MouseEvent moved)
			{
				JOptionPane.showMessageDialog(baseController.getBaseFrame(), "Moving from X:" + moved.getX() + ", Y:" + "moved.getY()");
			}
		});
	}
	
	
}
