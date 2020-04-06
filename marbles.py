

def combinatorics(n,r):
    if r>n/2:
        r = n-r
    
    result = 1
    for i in range(r):
        result *=n
        n-=1
        result //= (i+1)
    return result

t = int(input())

for t_ in range(t):
    s = input().split()
    n = int(s[0])
    k = int(s[1])

    answer = combinatorics(n-1,n-k)
    print(answer)