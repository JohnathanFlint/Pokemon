package poke.controller;

import java.awt.Component;
import poke.model.*;
import poke.view.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PokemonController
{
	//private Pokemon [] pokemon;
	private PokemonFrame appFrame;
	private ArrayList<Pokemon> pokedex;
	private PokemonFrame baseFrame;
	
	public PokemonController()
	{
		JOptionPane.showMessageDialog(baseFrame,  "Welcdome to Pokemon Inheritance");
		pokedex = new ArrayList<Pokemon>();
		baseFrame = new PokemonFrame(this);
		
		//pokemon = new Pokemon [5];
			
		buildPokedex();
	}
	public void start()
	{
		
	}
	
	private void buildPokedex()
	 {
		 pokedex.add(new Gyrados());
		 
		 
	 }

	
	public Component getBaseFrame()
	{
		return null;
		
	}
	
	public Pokemon[] getPokemon()
	{
		return pokemon;
	}
}
