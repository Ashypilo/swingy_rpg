package ua.ashypilo.swingy_rpg.MVC.Model.Heroes;

import ua.ashypilo.swingy_rpg.MVC.Model.MyImages.ImagesCleric;
import ua.ashypilo.swingy_rpg.MVC.Model.MyImages.ImagesHeroes;

public class Cleric extends Heroes {

    public Cleric(String name) {
        super(name);
        super.classHeroes = "Cleric";
        super.hitPoints = 110;
        super.hitPoints_start = 110;
        super.maxHitPoints = super.hitPoints;
        super.attack = 80;
        super.attack_start = 80;
        super.defense = 50;
        super.defense_start = 50;
        super.experience = 0;
        super.level = 1;
    }

    @Override
    public ImagesHeroes getImages() {
        return super.images;
    }

    @Override
    public void Images(boolean gui) {
        switch (super.level) {
            case 1: {
                if (gui)
                    super.images = new ImagesCleric.Level1();
                super.move = 1000 / 9;
                super.Square = 9;
                super.sizeSquare = super.move * 9;
                super.heroesX = 435 + ((int)move * 4);
                super.heroesY = 215 + ((int)move * 4);
                super.squareX = 4;
                super.squareY = 4;
                break;
            }
            case 2: {
                if (gui)
                    super.images = new ImagesCleric.Level2();
                super.move = 1000 / 15;
                super.Square = 15;
                super.sizeSquare = super.move * 15;
                super.heroesX = 422 + ((int)move * 7);
                super.heroesY = 199 + ((int)move * 7);
                super.squareX = 7;
                super.squareY = 7;
                break;
            }
            case 3: {
                if (gui)
                    super.images = new ImagesCleric.Level3();
                super.move = 1000 / 19;
                super.Square = 19;
                super.sizeSquare = move * 19;
                super.heroesX = 422 + ((int)move * 9);
                super.heroesY = 200 + ((int)move * 9);
                super.squareX = 9;
                super.squareY = 9;
                break;
            }
            case 4: {
                if (gui)
                    super.images = new ImagesCleric.Level4();
                super.move = 1000 / 25;
                super.Square = 25;
                super.sizeSquare = move * 25;
                super.heroesX = 422 + ((int)move * 12);
                super.heroesY = 201 + ((int)move * 12);
                super.squareX = 12;
                super.squareY = 12;
                break;
            }
            case 5: {
                if (gui)
                    super.images = new ImagesCleric.Level5();
                super.move = 1000 / 29;
                super.Square = 29;
                super.sizeSquare = move * 29;
                super.heroesX = 422 + ((int)move * 14);
                super.heroesY = 202 + ((int)move * 14);
                super.squareX = 14;
                super.squareY = 14;
                break;
            }
            case 6: {
                if (gui)
                    super.images = new ImagesCleric.Level6();
                super.move = 1000 / 35;
                super.Square = 35;
                super.sizeSquare = move * 35;
                super.heroesX = 422 + ((int)move * 17);
                super.heroesY = 202 + ((int)move * 17);
                super.squareX = 17;
                super.squareY = 17;
                break;
            }
            case 7: {
                if (gui)
                    super.images = new ImagesCleric.Level7();
                super.move = 1000 / 39;
                super.Square = 39;
                super.sizeSquare = move * 39;
                super.heroesX = 422 + ((int)move * 19);
                super.heroesY = 202 + ((int)move * 19);
                super.squareX = 19;
                super.squareY = 19;
                break;
            }
        }
    }

    @Override
    public void HeroImage() {
        super.hero = new ImagesCleric.Hero();
    }

    @Override
    public void getImageHero(int levelGame) {
        switch (levelGame) {
            case 1: {
                super.images = new ImagesCleric.Level1();
                break;
            }
            case 2: {
                super.images = new ImagesCleric.Level2();
                break;
            }
            case 3: {
                super.images = new ImagesCleric.Level3();
                break;
            }
            case 4: {
                super.images = new ImagesCleric.Level4();
                break;
            }
            case 5: {
                super.images = new ImagesCleric.Level5();
                break;
            }
            case 6: {
                super.images = new ImagesCleric.Level6();
                break;
            }
            case 7: {
                super.images = new ImagesCleric.Level7();
                break;
            }

        }
    }
}
