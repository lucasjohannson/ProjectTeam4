# ProjectTeam4

This project is an adventure game. Players must navigate a map and progress by picking up collectibles to get past obstacles and defeating enemies.

TO PLAY THE GAME:

All files must be contained in the same directory, except for the map and initialization files the game asks for, which must be placed in the PARENT directory.
********************************************************************************************************************************
CONSOLE VERSION:
 
First, compile the files in the console and then run TextApp.java to play the console version.

If done properly, the game will prompt you to either "Play current map", "Load a map" or "Exit".

Select option 2, "Load a map". The game will prompt you to enter the name of a file, which it will read from to create the grid for the map you will be navigating. THE MAP MUST BE CONTAINED IN THE PARENT DIRECTORY TO THE OTHER GAME FILES OR THE GAME WILL NOT BE ABLE TO FIND THE FILE. The game will create a preview of the map from the file you selected, press Y to continue to the next step or N if you wanted to specify another map.

If you are happy with the map you have selected, the game will then prompt you for an "initialization file". This will populate the map with the events contained in the map, such as enemy and item locations, as well as player start locations and the location of the endpoint. Please type the name of the file containing the initialization data. AS WITH THE MAP FILE, THE INITIALIZATION FILE MUST ALSO BE CONTAINED IN THE PARENT DIRECTORY. Press Y to continue on to the game or press N to if you typed the wrong initialization file to try again.

If you select option 1 without loading a map first, the game will default to "map1.txt" and "ini1.txt" as the map and initialization files.

GAME BASICS:

At this point, you will be inside the game. You can prompt your character to move by selecting N for North, E for East, W for West and S for South. You can also open your inventory and look at the items you have collected by pressing I. You can return to the main menu by pressing M. If you move over a tile with an "o", you will collect the item located there. If you move over a tile with an "E", you will be forced to battle the enemy located there. Your goal is to make it to the @ symbol, which signifies the end of the level.

BATTLE:

Input A in the console to attack, and input R in the console to run. If you run out of HP, you lose!
Hint: You can't run from your problems.

MAP SYMBOLS:

Walls in the game are represented by a "#"

Basic moveable terrain in the game is represented by "."

Water tiles are represented by "~"

Lava tiles are represented by "^"

The Player is represented by "P"

Collectible items are represented by "o"

Enemies are represented by "E"

Doors are represented by "D"

********************************************************************************************************************************
GUI VERSION:

First compile files in console and then run GameMenu.java. On the main menu screen, there are 3 options: Play Game, Load Map and Exit.
You will need to load a map first to play the game. Click the Load Map button, which will then prompt you to enter the name of a map file. Enter the name of your desired map text file and click ok. The game will then prompt you to enter the filename of an initialization text file. Enter the name of your desired initialization file and click ok. The game should now load into the main map.

GAME BASICS:

Press the arrow keys to move your character around. You can press the ESC to return to the main menu, or press the I key to access your inventory. To use items contained in your inventory, press the button corresponding to that item. If you encounter an enemy on the map, you will be forced to battle them. Press the attack button to attack the enemy, and the run button to run away. (Hint: you still can't run from your problems). Your goal is to make it to the portal which signifies the end of the map.

****************************************************************************************************************************************

MAKING YOUR OWN MAPS:

You can make your own maps to play through by simply creating a text document and typing the correct characters.

Note: Each line in the text file must contain the same number of characters or the game will not properly recognize the map file.

The characters which the game will recognize are:

"#" - for walls

"." - for basic moveable terrain (grass)

"~" - for water

"^" - for lava


Place the text file in the directory directly above the game files for them to load properly.

********************************************************************************************************************************
MAKING YOUR OWN INITIALIZATION FILES

Initialization files detail enemy, item, player and endpoint data

The game reads each line in a text file as a separate data entry, so make sure to only have one entry per line!
Each argument in a line must be separated by a comma. Whitespace is ok but no other characters other than ones listed below will be recognizable by the game. Please ensure the initialization files are correct if you wish to ensure the game runs properly.

The first character in each line denotes which type of data it represents.

"o" - represents a collectible

"E" - represents an enemy

"P" - represents the player

"@" - represents the endpoint

********************************************************************************************************************************
A runthrough of which things can be initialized:

A potion:

Restores health to the player when used

Identifier: p

o, p, name of potion, xcoordinate, ycoordinate, health restored

Example:

o,p,Red Potion,2,3,20

Creates a Potion named "Red Potion" which restores 20 hp at location (2,2) on the map. (0,0) is the top left corner of the map.
********************************************************************************************************************************

A weapon:

Increases the attack of the player when used

Identifier: w

o, w, name of weapon, xcoordinate, ycoordinate, attack added

Example:

o,w,Sword,10,5,2

Creates a weapon named "Sword" which increases attack by 2 at (10,5) on the map. (0,0) is the top left corner of the map.
********************************************************************************************************************************

A shoe:

Increases the moveable tileset of the player when used

Identifier: s

o, s, name of shoe, xcoordinate, ycoordinate, tile to be added to player's moveable tileset

Example:

o,s,Flipper,1,3,~

Creates a shoe named "Flipper" which allows the player to walk on "~" (water) tiles at (1,3) on the map. (0,0) is the top left corner of the map.
********************************************************************************************************************************

An Enemy:

Places an enemy on the map

Identifier: N/A

E, name of enemy, xcoordinate, ycoordinate, attack, max health

Example:

E,Goblin,2,10,2,30

Creates an enemy named "Goblin" with attack of 2 and max health of 30 at (2,10) on the map. (0,0) is the top left corner of the map.
********************************************************************************************************************************

The Player:

Modifies the player's initial values

Identifier: N/A

P,starting xcoordinate,starting ycoordinate, attack, max health

Example:

P,1,1,3,50

Sets the player's attack to 3, max health to 50 and the starting location of the player to (1,1). (0,0)is the top left corner of the map.

Note: if there are multiple entries for the player in the initialization file, only the last one will be used (the one furthest down)
********************************************************************************************************************************

The endpoint:

Sets the endoint of the map

Identifier: N/A

@, xcoordinate, ycoordinate

Example:

@,9,9

Sets the endpoint of the map at location (9,9). (0,0) is the top left corner of the map.
