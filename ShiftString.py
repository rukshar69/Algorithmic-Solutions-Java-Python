

def computeLps(pattern, n):
    lps = [0 for i in range(n)]

    j = 0
    i = 1

    while(i<n):
        if pattern[i] == pattern[j]:
            j+=1
            lps[i]=j
            i+=1
        else:
            if j==0:
                lps[i] = 0
                i +=1
            else:
                j = lps[j-1]

    return lps

def determineAnswer(pattern, string, n):

    lps = computeLps(pattern,n)
    i = 0; j=0
    ind = -1
    min = 0
    for prefixLength in range(1,n+1):
        flag = False
        while(i<n):
            if(pattern[j] == string[i]):
                i+=1;j+=1
            else:
                if i<n:
                    if j!=0:
                        j = lps[j-1]
                    else:
                        i+=1

            if j == prefixLength:
                flag = True; ind = i - j; break

        if flag == False: break
        else: min = ind

    return min



n = int(input())
pattern = input()
string = input()
minShifts = determineAnswer(pattern,string,n)
print(minShifts)

