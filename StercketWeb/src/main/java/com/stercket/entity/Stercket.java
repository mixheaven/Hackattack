package com.stercket.entity;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Stercket {
	
	final static int MAX_POINTS=100;
	final static int MIN_POINTS=20;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private int attack;
	private int defense;
	private int lifePoints;
	private int lifePointsMax;
	@NotNull
	@Size(min=4, max=50)
	private String name;
	
	
	public Stercket() {
		Random dice = new Random();
		int points = dice.nextInt(MAX_POINTS - MIN_POINTS + 1)+ MIN_POINTS;
		lifePoints = dice.nextInt(points - 2) + 1;
		lifePointsMax = lifePoints;
		points -= lifePoints;
		attack = dice.nextInt(points - 1) +1;
		defense = points - attack;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	
	
	public int getLifePointsMax() {
		return lifePointsMax;
	}


	public void setLifePointsMax(int lifePointsMax) {
		this.lifePointsMax = lifePointsMax;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
