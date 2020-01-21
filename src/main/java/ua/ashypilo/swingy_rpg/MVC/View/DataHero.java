package ua.ashypilo.swingy_rpg.MVC.View;

import javax.swing.*;
import java.awt.*;

public class DataHero {

    static MapGame game;
    static JLabel labelName;
    static JLabel labelClass;
    static JLabel labelLevelHero;
    static JLabel labelExperience;
    static JLabel labelHitPoints;
    static JLabel labelDefense;
    static JLabel labelAttack;
    static JLabel LevelHero;
    static JLabel defense;
    static JLabel basic_defense;
    static JLabel attack;
    static JLabel basic_attack;
    static JLabel Class;
    static JLabel Name;
    static JLabel HitPoints;
    static JLabel basic_hit;
    static JLabel Experience;
    static String Str;
    static String StrMax;
    static Font fontlabel;
    static Font fonthero;
    static Font fontBiglabel;
    static Font fontBigHero;

    public DataHero(MapGame game) {
        this.game = game;
        game.heroes.HeroImage();
        game.heroes.getHero().setBounds(240,380,200,200);
        game.layers.add(game.heroes.getHero(), JLayeredPane.PALETTE_LAYER);
        labelName = new JLabel("Name: ");
        labelClass = new JLabel("Class: ");
        labelLevelHero = new JLabel("Hero level: ");
        labelExperience = new JLabel("Experience: ");
        labelHitPoints = new JLabel("Hit points: ");
        labelDefense = new JLabel("Defense: ");
        labelAttack = new JLabel("Attack: ");
        fontlabel = new Font("Verdana", Font.BOLD,17);
        fonthero = new Font("Verdana", Font.ITALIC, 17);
        fontBigHero = new Font("Snell Roundhand", Font.ITALIC, 60);
        fontBiglabel = new Font("Verdana", Font.BOLD, 23);
    }

    public static void addLabel() {
        labelName.setFont(fontlabel);
        labelClass.setFont(fontlabel);
        labelLevelHero.setFont(fontlabel);
        labelExperience.setFont(fontlabel);
        labelHitPoints.setFont(fontBiglabel);
        labelDefense.setFont(fontBiglabel);
        labelAttack.setFont(fontBiglabel);

        labelClass.setBounds(165,635,150,20);
        labelName.setBounds(165,675,150,20);
        labelLevelHero.setBounds(165, 715, 150, 20);
        labelExperience.setBounds(165, 755, 150, 20);
        labelHitPoints.setBounds(250, 830, 150, 25);
        labelDefense.setBounds(1490,830,150,25);
        labelAttack.setBounds(1510, 470,150,25);

        game.layers.add(labelName, JLayeredPane.PALETTE_LAYER);
        game.layers.add(labelClass, JLayeredPane.PALETTE_LAYER);
        game.layers.add(labelLevelHero, JLayeredPane.PALETTE_LAYER);
        game.layers.add(labelExperience, JLayeredPane.PALETTE_LAYER);
        game.layers.add(labelHitPoints, JLayeredPane.PALETTE_LAYER);
        game.layers.add(labelDefense, JLayeredPane.PALETTE_LAYER);
        game.layers.add(labelAttack, JLayeredPane.POPUP_LAYER);
    }

    public static void addInformationHeroes() {
        addLabel();
        Class = new JLabel(game.heroes.getClassHeroes());
        Name = new JLabel(game.heroes.getName());
        Name.setFont(fonthero);
        Class.setFont(fonthero);
        Class.setBounds(280,635,150,20);
        Name.setBounds(280,675,150,20);
        game.layers.add(Name, JLayeredPane.PALETTE_LAYER);
        game.layers.add(Class, JLayeredPane.PALETTE_LAYER);

        Str = String.valueOf(game.heroes.getExperience());
        StrMax = String.valueOf(game.heroes.getNextLevel());
        Experience = new JLabel(Str + "/" + StrMax);
        Experience.setFont(fonthero);
        Experience.setBounds(280,755,150,20);
        game.layers.add(Experience, JLayeredPane.PALETTE_LAYER);

        Str = String.valueOf(game.heroes.getLevel());
        LevelHero = new JLabel(Str);
        LevelHero.setFont(fonthero);
        LevelHero.setBounds(280,715,150,20);
        game.layers.add(LevelHero, JLayeredPane.PALETTE_LAYER);

        Str = String.valueOf(game.heroes.getAttack_start());
        attack = new JLabel(Str);
        attack.setFont(fontBigHero);
        attack.setBounds(1510,500,190,80);
        game.layers.add(attack,JLayeredPane.POPUP_LAYER);
        basic_attack = new JLabel("Basic: " + Str);
        basic_attack.setFont(fonthero);
        basic_attack.setBounds(1510, 580, 100, 50);
        game.layers.add(basic_attack, JLayeredPane.POPUP_LAYER);
        Str = String.valueOf(game.heroes.getDefense_start());
        defense = new JLabel(Str);
        defense.setFont(fontBigHero);
        defense.setBounds(1500, 870, 190,80);
        game.layers.add(defense, JLayeredPane. POPUP_LAYER);
        basic_defense = new JLabel("Basic: " + Str);
        basic_defense.setFont(fonthero);
        basic_defense.setBounds(1500, 950, 100, 50);
        game.layers.add(basic_defense, JLayeredPane.POPUP_LAYER);
        Str = String.valueOf(game.heroes.getHitPoints_start());
        StrMax = String.valueOf(game.heroes.getMaxHitPoints());
        HitPoints = new JLabel(Str + "/" + StrMax);
        HitPoints.setFont(fontBigHero);
        HitPoints.setBounds(220,870,190,80);
        game.layers.add(HitPoints, JLayeredPane.PALETTE_LAYER);
        basic_hit = new JLabel("Basic: " + Str);
        basic_hit.setFont(fonthero);
        basic_hit.setBounds(270, 950, 100, 50);
        game.layers.add(basic_hit, JLayeredPane.POPUP_LAYER);
        changeDataHero();
    }

    public static void changeAttack() {
        Str = String.valueOf(game.heroes.getAttack());
        attack.setText(Str);
        attack.setFont(fontBigHero);
        attack.setBounds(1510,500,190,80);
    }

    public static void changeDefense() {
        Str = String.valueOf(game.heroes.getDefense());
        defense.setText(Str);
        defense.setFont(fontBigHero);
        defense.setBounds(1500, 870, 190,80);
    }

    public static void changeHitPoints() {
        Str = String.valueOf(game.heroes.getHitPoints());
        StrMax = String.valueOf(game.heroes.getMaxHitPoints());
        HitPoints.setText(Str + "/" + StrMax);
        HitPoints.setFont(fontBigHero);
        HitPoints.setBounds(220,870,220,80);
    }

    public static void changeExperience() {
        Str = String.valueOf(game.heroes.getExperience());
        StrMax = String.valueOf(game.heroes.getNextLevel());
        Experience.setText(Str + "/" + StrMax);
        Experience.setFont(fonthero);
        Experience.setBounds(280,755,150,20);
    }

    public static void changeLevelHero() {
        Str = String.valueOf(game.heroes.getLevel());
        LevelHero.setText(Str);
        LevelHero.setFont(fonthero);
        LevelHero.setBounds(280,715,150,20);
    }

    public static void changeDataHero() {
        changeAttack();
        changeDefense();
        changeHitPoints();
        changeLevelHero();
    }
}
