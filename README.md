# ProjectTeam4

This project is an adventure game. Players must navigate a map and progress by picking up collectibles to get past obstacles and defeating enemies.

TO PLAY THE GAME:

All files must be contained in the same directory, except for the map and initialization files the game asks for, which must be placed in the PARENT directory.

CONSOLE VERSION:
 
First, compile the files in the console and then run TextApp.java to play the console version.

If done properly, the game will prompt you to either "Play current map", "Load a map" or "Exit".

Select option 2, "Load a map". The game will prompt you to enter the name of a file, which it will read from to create the grid for the map you will be navigating. THE MAP MUST BE CONTAINED IN THE PARENT DIRECTORY TO THE OTHER GAME FILES OR THE GAME WILL NOT BE ABLE TO FIND THE FILE. The game will create a preview of the map from the file you selected, press Y to continue to the next step or N if you wanted to specify another map.

If you are happy with the map you have selected, the game will then prompt you for an "initialization file". This will populate the map with the events contained in the map, such as enemy and item locations, as well as player start locations and the location of the endpoint. Please type the name of the file containing the initialization data. AS WITH THE MAP FILE, THE INITIALIZATION FILE MUST ALSO BE CONTAINED IN THE PARENT DIRECTORY. Press Y to continue on to the game or press N to if you typed the wrong initialization file to try again.

GAME BASICS:

At this point, you will be inside the game. You can prompt your character to move by selecting N for North, E for East, W for West and S for South. You can also open your inventory and look at the items you have collected by pressing I. You can return to the main menu by pressing M.

MAP SYMBOLS:

Walls in the game are represented by a "#"

Basic moveable terrain in the game is represented by "."

The Player is represented by "P"

Collectible items are represented by "o"

Enemies are represented by "E"

Doors are represented by "D"
