1) Go to TestCreature and compile it.
2) Classes such as Tiger, Ant, Bat, and Fly also have moveStr(), eatStr(), and whatDidYouEatStr() methods, that return be tring instead of printing a message. This is designed so that there could be a unit testing of those methods in TigerTest, AntTest, BatTest, and FlyTest.
3) Also, I added a method showStomach() to class Creature, which returns a String arrayList of things that a Creature has eaten. Since this method returns an ArrayList, I was confused about how to test an ArrayList of Strings.
