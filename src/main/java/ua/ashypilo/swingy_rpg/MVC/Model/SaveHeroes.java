package ua.ashypilo.swingy_rpg.MVC.Model;

import ua.ashypilo.swingy_rpg.MVC.Model.Heroes.Heroes;

import java.sql.*;
import java.util.ArrayList;

public class SaveHeroes {
    int id;
    ArrayList<String> nameHero = new ArrayList<String>();
    ArrayList<String> classHero = new ArrayList<String>();
    ArrayList<Integer> level = new ArrayList<Integer>();
    ArrayList<Integer> exp = new ArrayList<Integer>();
    ArrayList<Integer> attack = new ArrayList<Integer>();
    ArrayList<Integer> defence = new ArrayList<Integer>();
    ArrayList<Integer> hitPoints = new ArrayList<Integer>();
    ArrayList<String> saveHeroes = new ArrayList<String>();
    String sql;
    Statement statement;
    Connection connection;
    ResultSet resultSet;
    String userName;
    String password;
    String connectionUrl;
    int sizeHeroes;

    public SaveHeroes() {
        userName = "root";
        password = "239723";
        connectionUrl = "jdbc:mysql://localhost:3306/MySQL?useSSL=false";
        try {
            setId();
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        catch (ClassNotFoundException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void setId() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionUrl, userName, password);
            statement = connection.createStatement();
            {
                resultSet = statement.executeQuery("select * from heroes_save");
                while (resultSet.next()) {
                    id = resultSet.getInt(1);
                }
            }
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void deleteSaveHeroes() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionUrl, userName, password);
            statement = connection.createStatement();
            {
                statement.executeUpdate("delete from heroes_save");
            }
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }


    public void save(Heroes hero) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sql = "insert into heroes_save (name, class, level, exp, attack, defence, hitPoints) value (" + "'" + hero.getName() + "', '" + hero.getClassHeroes() + "', " + hero.getLevel() + ", " + hero.getExperience() + ", " + hero.getAttack() + ", " + hero.getDefense() + ", " + hero.getHitPoints() + ")";
            connection = DriverManager.getConnection(connectionUrl, userName, password);
            statement = connection.createStatement();
            {
                resultSet = statement.executeQuery("select COUNT(*) from heroes_save");
                if (resultSet.next())
                    sizeHeroes = resultSet.getInt(1);
                if (sizeHeroes == 15) {
                    deleteSaveHeroes();
                }
                statement.executeUpdate(sql);
            }
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void continueGame()throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionUrl, userName, password);
            statement = connection.createStatement();
            {
                resultSet = statement.executeQuery("select * from heroes_save");
                int i = 0;
                while (resultSet.next()) {
                    nameHero.add(resultSet.getString(2));
                    classHero.add(resultSet.getString(3));
                    level.add(resultSet.getInt(4));
                    exp.add(resultSet.getInt(5));
                    attack.add(resultSet.getInt(6));
                    defence.add(resultSet.getInt(7));
                    hitPoints.add(resultSet.getInt(8));
                    saveHeroes.add(classHero.get(i) + " " + nameHero.get(i) + ": level " + level.get(i));
                    i++;
                }
            }
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public ArrayList<String> getSaveHero() {
        return saveHeroes;
    }

    public ArrayList<String> getNameHero() {
        return nameHero;
    }

    public ArrayList<String> getClassHero() {
        return classHero;
    }

    public ArrayList<Integer> getLevel() {
        return level;
    }

    public ArrayList<Integer> getExp() {
        return exp;
    }

    public ArrayList<Integer> getAttack() {
        return attack;
    }

    public ArrayList<Integer> getDefence() {
        return defence;
    }

    public ArrayList<Integer> getHitPoints() {
        return hitPoints;
    }

}
