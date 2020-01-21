GUI applications with the SWING framework, in order to create an RPG game.

The game can be launched in 2 modes as described below:

$java -jar swingy-1.0.jar console
$java -jar swingy-1.0.jar gui

You can switch between console view and GUI view at runtime, without closing the game.

A player can have multiple heroes of different types. We leave it at you to name the hero
types and fine tune the different starting stats between them, When the player starts the
game he has 2 options:

• Create a hero

• Select a previously created hero.

Hero stats:

• Hero name

• Hero class

• Level

• Experience

• Attack

• Defense

• Hit Points

Hero stats are affected by the hero level and artifacts. There are 3 types of artefacs:

• Weapon - increases the attack

• Armor - increases defense

• Helm - increases hit points
  
  After choosing a hero the actual game begins. The hero needs to navigate a square
map with the size calculated by the formula (level-1)*5+10-(level%2). For example a
hero of level 7 will be placed on a 39X39 map.
  The initial position of the hero is in the center of the map. He wins the game if he
reaches on of the borders of the map and he will have the necessary level for the next
level of the game Each turn he can move one position in one of the 4 four directions:

• North

• East

• South

• West

  When a map is generated, villains of varying power will be spread randomly over the
map. When a hero moves to a position occupied by a villain, the hero has 2 options:

• Fight, which engages him in a battle with the villain

• Run, which gives him a 50% chance of returning to the previous position. If the
odds aren’t on his side, he must fight the villain.

If a hero wins a battle, he gains:

• Experience points, based on the villain power. 

• An artifact, which he can keep or leave.

Leveling up is based on the following formula level*1000+(level − 1)2*450. So the
necessary experience to level up will follow this pattern:

• Level 1 - 1000 XP

• Level 2 - 2450 XP

• Level 3 - 4800 XP

• Level 4 - 8050 XP

• Level 5 - 12200 XP

https://github.com/Ashypilo/images/raw/blob/master/Swing.png

https://github.com/jon/coolproject/raw/master/Swing.png
