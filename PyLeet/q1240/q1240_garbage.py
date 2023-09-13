

from typing import List


def tilingRectangle(n: int, m: int) -> int:
    if m == n:
        return 1
    arr = [i**2 for i in range(1, 14)]
    return findMinNoOfSquares(m * n, 0, arr, 0, float('inf'))

def findMinNoOfSquares(target: int, noOfSquares: int, arr: List[int], curSum: int, minNoOfSquares: int) -> int:

    currArr = [i for i in arr if i <= (target - curSum)]
    result = []
    if noOfSquares > minNoOfSquares:
        return minNoOfSquares
    if curSum == target and noOfSquares < minNoOfSquares:
        minNoOfSquares = noOfSquares
        return minNoOfSquares
    
    for i in range(len(currArr)):
        res = findMinNoOfSquares(target, noOfSquares + 1, currArr, currArr[i] + curSum, minNoOfSquares)
        result.append(res)

    return min(result)

def main():
    print(tilingRectangle(11, 13))

if __name__ == "__main__":
    main()
