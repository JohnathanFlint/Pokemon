package pokemon.view;

import java.awt.*;
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
	private JTextField healthField;
	private JTextField bombatField;
	private JTextField speedField;
	private JTextField nameField;
	private JTextField numberField;
	private JTextArea advancedArea;
	
	public PokemonPanel(PokemonController baseController)
	{
		super();
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		advancedArea = new JTextArea(5, 25);
		updateButton = new JButton("Update Stats");
		pokedexSelector = new JComboBox(baseController.getPokemon());
		pokemonLabel = new JLabel("Name");
		healthLabel = new JLabel("Health");
		combatLabel = new JLabel("Combat Points");
		speedLabel = new JLabel("Speed");
		numberLabel = new JLabel("Number");
		advancedLabel = new JLabel("Insert Picture");
		
	}
	
}
