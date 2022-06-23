# Java-Space-Invaders

### What is this project?

Simple game in Java inspired by game called "Space Invaders"

### How it works?

Multiple classes are being created and drawn in class ```Screen``` which extends JPanel.
These classes mainly are extending class ```Entity```

### Most important Classes and their functions

- ```Player``` - This class uses class ```KeyHandler``` for user event monitoring. User can move visual representation of this class. (ship) By using "space-tab" user can move bullet to his own coridinates and set speed.
- ```Bullet``` - This class is being used by ```User```. When Bullet hits ```Alien``` or bullet y coridinate is <0. User can shoot again. Only one bullet is being used in whole game. Bullet have it's own damage. Speed increases when user kills many aliens.
- ```Alien``` - This class has it's own health. Bullet can damage it. If Aliens health is 0 alien is removed from screen. Aliens as group is moving for difficulty increase.


#### Made by Aleksander Opałka
