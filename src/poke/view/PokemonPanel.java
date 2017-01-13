package poke.view;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.util.Random;

import poke.controller.PokemonController;

import javax.swing.*;

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
		
		this.baseLayout = new SpringLayout();
		this.advancedArea = new JTextArea(5, 25);
		
		this.updateButton = new JButton("Update Stats");
		
		this.pokedexSelector = new JComboBox();
		
		this.healthLabel = new JLabel("Health");
		this.combatLabel = new JLabel("Combat Points");		
		this.speedLabel = new JLabel("Speed");		
		this.numberLabel = new JLabel("Number");
		
		this.advancedLabel = new JLabel("Advanced Infromation");
		
		this.healthField = new JTextField(5);
		
		this.combatField = new JTextField(5);
		
		this.speedField = new JTextField(5);
		
		this.nameField = new JTextField(5);
		
		this.numberField = new JTextField(5);
		
		this.pokemonIcon = new ImageIcon(getClass().getResource("/poke/view/picture/pokeball.png"));
		this.pokemonLabel = new JLabel(pokemonIcon, SwingConstants.CENTER);
	
		
		this.nameLabel = new JLabel("Name");
		
		
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
		baseLayout.putConstraint(SpringLayout.WEST, pokedexSelector, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, pokemonLabel, 161, SpringLayout.NORTH, combatLabel);
		baseLayout.putConstraint(SpringLayout.WEST, pokemonLabel, 0, SpringLayout.WEST, pokedexSelector);
		baseLayout.putConstraint(SpringLayout.SOUTH, pokemonLabel, 0, SpringLayout.SOUTH, advancedArea);
		baseLayout.putConstraint(SpringLayout.EAST, pokemonLabel, 276, SpringLayout.WEST, pokedexSelector);
	}
	
	private void setupListeners()
	{
		pokedexSelector.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int selected = pokedexSelector.getSelectedIndex();
				
				nameField.setText(baseController.getPokedex().get(selected).getName());
			}
		});
		
		this.addMouseListener(new MouseListener()
		{
		
			public void mouseEntered(MouseEvent entered)
			{
				JOptionPane.showMessageDialog(baseController.getBaseFrame(), "The mouse is in!");
			}
			
			public void mouseExited(MouseEvent exited)
			{
				JOptionPane.showMessageDialog(baseController.getBaseFrame(), "The mouse is out!");
			}
			
			public void mousePressed(MouseEvent pressed)
			{
				JOptionPane.showMessageDialog(baseController.getBaseFrame(), "The mouse was pressed!");
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
		
		/*public  setRandomColor()
		{
			
		}*/
		
		this.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseDragged(MouseEvent dragged)
			{
				//setRandomColor();
			}
			
			public void mouseMoved(MouseEvent moved)
			{
				JOptionPane.showMessageDialog(baseController.getBaseFrame(), "Moving from " + moved.getX() + " Y: " + moved.getY());			}
		});
	}
	
	private void changeColorBasedOnData(String data)
	{
		if(data.contains("Fairy"))
		{
			this.setBackground(Color.PINK);
		}
		else if(data.contains("Water"))
		{
			this.setBackground(Color.blue);
		}
		else if(data.contains("Rock"))
		{
			this.setBackground(Color.gray);
			
		}
		else if(data.contains("Dragon"))
		{
			this.setBackground(Color.black);
		}
		else
		{
			this.setBackground(Color.DARK_GRAY);
		}
	}
	
	private void setRandomColor()
	{
		Random rand = new Random();
		this.setBackground(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
	}
	
	
}
