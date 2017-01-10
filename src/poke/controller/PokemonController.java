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
		 pokedex.add(new Geodude());
		 pokedex.add(new Jigglypuff());
		 pokedex.add(new Lapris());
		 pokedex.add(new Togepi());
	 }

	
	public Component getBaseFrame()
	{
		return baseFrame;
		
	}
	
	public ArrayList<Pokemon> getPokedex()
	{
		return pokedex;
	}
	public void setPokedex(ArrayList<Pokemon> pokedex)
	{
		this.pokedex = pokedex;
	}
	public void setBaseFrame(PokemonFrame baseFrame)
	{
		this.baseFrame = baseFrame;
	}
	
	public void updateSelected(int i, String name, int number, int hp, double speed)
	{
		int index = i;
		Pokemon poke = pokedex.get(index);
		poke.setNumber(number);
		poke.setHealthPoints(hp);
		poke.setSpeed(speed);
		
	}
}
