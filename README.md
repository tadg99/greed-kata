# greed-kata

## Questions:

## Assumptions:
 
## Different Paths/Solutions:

### Brute Force
One approach to this problem that I considered was simply hardcoding the best scores for each of the possible dice rolls. Since each roll consists of 5 dice and the order of the dice does not matter, there are 252 different rolls to deal with. This solution would require the space to store these scores, which would quickly increase if the rules were shifted to include higher-sided dice and/or more dice. However, once the work to map these rolls with their best scores is complete, lookup of the high score would be fast.

### Algorithmically
Algorithmically, this problem can be solved in a number of ways. One approach is to check the roll for each of the rules in descending order of score produced from meeting each rule.  In order to do this, a total score is tracked as rules are checked and when a rule is met, the dice used for that rule are thrown out. This way, no one die is double counted. By ordering the rules in terms of decreasing score, this ensures the end total is the highest possible. It should be noted that this strategy might not work with different scoring rules. 

For example, given the roll [6, 6, 6, 5, 5] and our current ruleset, we would see that only the triple 6s rule applies, giving a high score of 600 points. However, if we introduce a new rule where [5, 6] gives 400 points, our new high score would be 800. Unfortunately, this algorithm would first count the triple 6s for 600 points and then see that no other rules apply with the remaining dice.

Another approach, and the strategy that I chose to use, is to check the rules in a logical pattern that makes sense with the given ruleset. For the given ruleset, this meant checking rules in terms of increasing die value. In other words, check if there are triple 1s, then check for remaining 1s, then move on to triple 2s, triple 3s, etc. This approach works since the rules don’t contain any combination of die-values, i.e., different numbers don’t contribute in the same scoring rule. To represent the rolls, I chose to map die values to their counts in the given roll. This works because the order of the dice roll doesn’t matter ([1, 2, 3, 4, 5] gives the same high score as [5, 4, 3, 2, 1]).
