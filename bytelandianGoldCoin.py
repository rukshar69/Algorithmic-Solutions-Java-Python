dp = {} #a dictionary/map because the max size 10^9 which is too large for an array
dp[0] = 0 #base case

def dpSolution(n):
    if n in dp:
        return dp[n]
    else:
        temp = dpSolution(n//2) + dpSolution(n//3) + dpSolution(n//4)
        dp[n] = max(n, temp)
        return dp[n]


try:
    while True:
        number = int(input())
        result = dpSolution(number)
        print(result)
except:
    pass
