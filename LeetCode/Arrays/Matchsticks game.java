/*
Two friends, A and B, are playing the game of matchsticks. In this game, a group of N matchsticks is placed on the table. The players can pick any number of matchsticks from 1 to 4 (both inclusive) during their chance. The player who takes the last match stick wins the game. If A starts first, how many matchsticks should he pick on his 1st turn such that he is guaranteed to win the game or determine if it's impossible for him to win. Return -1 if it's impossible for A to win the game, else return the number of matchsticks should he pick on his 1st turn such that he is guaranteed to win.
Note : Consider both A and B play the game optimally.

Example 1:

Input:
N = 48
Output:
3
Explanation:
Player A is guaranteed a win if he
picks 3 matchsticks first.
Example 2:

Input:
N = 15
Output:
-1
Explanation:
Player A is guaranteed a loss no matter
how many matches he picks at first.

Your Task:
You don't need to read input or print anything. Your task is to complete the function matchGame() which takes an Integer N as input and returns the answer.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

A person will win if he is left with max of 4 match sticks. Similarly a person will lose if he has 5 match sticks because whatever he chose from 1 to 4, the no of matches left will be picked up by the last person.

If there are 6 to 10 match sticks left then the person can pick match sticks which will make the  count of left match sticks be 5 so he will lose.... similarly it repeats at an interval of 5 so whenever N is divisible by 5 the first person cannot win the game. and if N is not divisible by 5 so make it divisible by 5 so that other person cannot win the game.

So its -1 for N%5 == 0 and else N%5 
*/

class Solution {
    static int matchGame(Long N) {
        if(N%5==0) return -1;
        else return (int)(N%5);
        // code here
    }
};
