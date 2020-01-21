package ua.ashypilo.swingy_rpg.MVC.Model.Heroes;

import ua.ashypilo.swingy_rpg.MVC.Model.MyImages.ImagesHeroes;

public class Heroes {
    public String name;
    public String classHeroes;
    public int level;
    public int levelGame;
    public int experience;
    public int attack;
    public int attack_start;
    public int defense;
    public int defense_start;
    public int hitPoints;
    public int hitPoints_start;
    public int maxHitPoints;
    public int heroesX;
    public int heroesY;
    public int squareX;
    public int squareY;
    public int Square;
    public int nextLevel;
    public double move;
    public double sizeSquare;
    public ImagesHeroes images;
    public ImagesHeroes hero;

    public Heroes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void Images(boolean gui) {
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints -= hitPoints;
    }

    public void setExperience(int experience) {
        this.experience += experience;
        if (this.experience >= this.getNextLevel())
                this.level += 1;
    }

    public void setSquareX(int x) {
        squareX = x;
    }


    public void setLevelGame(int game) {
        levelGame = game;
    }

    public void setSquareY(int y) {
        squareY = y;
    }

    public void setHeroesX(int x) {
        heroesX = x;
    }

    public void setHeroesY(int y) {
        heroesY = y;
    }

    public void setMaxHitPoints(int hit) {
        maxHitPoints = (hitPoints_start + hit);
    }

    public void setAttack(int change) {
        attack = attack_start + change;
    }

    public void setDefense(int change) {
        defense = defense_start + change;
    }


    public void HitPointsReturn() {
        hitPoints = maxHitPoints;
    }

    public void setAttackDownload(int change) {
        attack = change;
    }

    public void setDefenseDownload(int change) {
        defense = change;
    }


    public void setHitPointsDownload(int change) {
        hitPoints = change;
    }

    public void HeroImage() {

    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getLevel() {
        return level;
    }

    public int getHeroesX() {
        return heroesX;
    }

    public int getHeroesY() {
        return heroesY;
    }

    public int getSquareY() {
        return squareY;
    }

    public int getSquareX() {
        return squareX;
    }

    public int getSquare() {
        return Square;
    }

    public int getNextLevel() {
        nextLevel = level * 1000 + (level - 1)*(level - 1)*450;
        return nextLevel;
    }

    public int getExperience() {
        return experience;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public double getSizeSquare() {
        return sizeSquare;
    }

    public double getMove() {
        return move;
    }

    public ImagesHeroes getHero() {
        return hero;
    }

    public ImagesHeroes getImages() {
        return images;
    }

    public String getClassHeroes() {
        return classHeroes;
    }

    public int getAttack_start() {
        return attack_start;
    }

    public int getDefense_start() {
        return defense_start;
    }

    public int getHitPoints_start() {
        return hitPoints_start;
    }

    public void getImageHero(int levelGame) {
    }

    public int getLevelGame() {
        return levelGame;
    }
}
