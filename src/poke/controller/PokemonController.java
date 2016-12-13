package poke.controller;

import java.awt.Component;
import poke.model.Pokemon;
import poke.view.*;

public class PokemonController
{
	private Pokemon [] pokemon;
	private PokemonFrame appFrame;
	
	public PokemonController()
	{
		pokemon = new Pokemon [5];
				
		for (int index = 0; index < pokemon.length; index++)
		{
			pokemon[index] = new Pokemon();
		}
	}
	public void start()
	{
		
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
