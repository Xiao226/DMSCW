# Introduction to F2A and Our Work
<p align="right">Jan 1, 2023</p>

## Group Introduction
Our team name is F2A, which comes from StarCraft. And our team members are Xiaotian ZHANG(20319043), and Yibo SUN(20320401). We together developed this game. We all love such games lie in the backgrounds of space war or space travelling, so it is quite enjoyable during the developing process.

## Accidents
Because of various reasons, like being caught in the sudden covid epidemic, Zhang was caught in a quite severe sickness, which greatly cut down our available time for developing this project. Consequently,  there are still some parts of our assumption that have not been developed completely. For example, adding some extra bosses with outstanding characteristics, switching the space map along with the asteroid type during the fight, and increasing the diversity of the functionality and appearance of the spacecraft and the bullet, above are some hypothesis which are not implemented due to the lack of time, and we feel quite pity about that.

## Developing Procedure
We first separate the source code into different parts. Fix several bugs in it, and then some repeated codes and turned them into different functions.

We seperate the game into 6 stages, each stage has one contoller. And we initial the stages in one java file. We also extract some useful storeages out of source code to help the potential later change or maintance.

The 6 stages are:

1. startStage: To show the starting page to the player and serve as the media for the switching to any page in this game. All the other pages except the end page can be accessible from the startStage.
2. endStage: To show the billing interface to the player. The player can choose to exit, play again and record their grades.
3. ruleNameStage: To ask for the player for their ID and impart the player of the game rule. This page works as the informer to tell the user some necessary information. This page will show up compulsory before the game start.
4. rankingStage: This page is optional in the start page. The player can check the ranking and grades by other players.
5. appearanceStage: This stage is also optional for the player. The player can choose the outlook of their spacecraft, their bullet style and the appearance of their enemies.
6. info: This is a page giving simple information about our developing team.



## Work Allocation
In this work, Yibo Sun mainly covers adding new functions, building several stages, and writing JavaDoc. Xiaotian Zhang mainly covers fixing initial bugs, designing UI, and maintaining the git. 