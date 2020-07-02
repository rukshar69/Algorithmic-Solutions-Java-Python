

n = int(input())

a = input().split()
a = [int(i) for i in a]
#print(a)
nonZero = [0 for i in range(30)]

for num in a:

    for i in range(30):
        andAnswer = num & (1<<i)
        if andAnswer !=0:
            nonZero[i]+=1

answer = 0
for i in range(30):
    answer += (nonZero[i]*(nonZero[i]-1)*(1<<i))

print(answer//2)