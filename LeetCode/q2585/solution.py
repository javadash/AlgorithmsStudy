import copy
from typing import List

class Solution:
    def waysToReachTarget(self, target: int, types: List[List[int]]) -> int:
        typCopy = sorted(types, key=lambda a: a[1])
        return self.sumToTarget(target, 0, typCopy)
    
    def sumToTarget(self, target: int, questSum: int, types: List[List[int]]) -> int:
        currTypes = [i for i in types if i[0] > 0]
        
        result = 0
        if questSum == target:
            return 1
        elif not currTypes:
            return 0
        elif currTypes[0][1] > (target - questSum): #if the smallest mark we can get is greater than the difference to target
            return 0
        
        for i in range(len(currTypes)):
            currTypesCopy = copy.deepcopy(currTypes)
            currTypesCopy[i][0] -= 1
            result += self.sumToTarget(target, questSum + currTypes[i][1], currTypesCopy)

        return result
    
    def waysToReachTarget(self, target: int, types: List[List[int]]) -> int:
        typCopy = sorted(types, key=lambda a: a[1])
        results = []
        for i in range(len(typCopy)):
            score = target
            curr_combo = []
            currTypesCopy = copy.deepcopy(typCopy)
            for j in range(i,len(currTypesCopy)):
                result_found = False
                while score > 0 and score >= currTypesCopy[j][1]:
                    if currTypesCopy[j][0] > 0:
                        curr_combo.append(currTypesCopy[j][1])
                        currTypesCopy[j][0] = currTypesCopy[j][0] - 1
                        score = score - currTypesCopy[j][1]
                    else:
                        break

                    if score == 0:
                        results.append(curr_combo)
                        result_found =  True
                        break
                if result_found:
                    break
                    


def main():
    tests = [[6,1],[2,3],[3,2]]
    target = 6
    sol = Solution()
    result = sol.waysToReachTarget(target , tests)
    print(result)

if __name__ == "__main__":
    main()