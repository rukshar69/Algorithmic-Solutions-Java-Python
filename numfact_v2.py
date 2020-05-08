


# get all the primes less than 1000000
def getPrime():
    primes = []
    # initialize the array
    arr = [0] * 1000001
    for i in range(2, 1000001):
        if arr[i] != 1:
            # set all the multiples of prime to 1
            j = i * 2
            while j <= 1000000:
                arr[j] = 1
                j += i
    for i in range(2, len(arr)):
        # indexes with value zero are the primes
        if arr[i] == 0:
            primes.append(i)
    return primes


# calculate the factors


def populateFactorDict(factorDict, primes, number):
    primesLen = len(primes)
    tmp = number
    for i in range(primesLen):
        # if n is divisible by x increase the value at key == x by 1
        if primes[i] > tmp:
            break

        while number % primes[i] == 0 and number >= primes[i] :
            if primes[i] in factorDict:
                factorDict[primes[i]] += 1
            else:
                factorDict[primes[i]] = 1
            number /= primes[i]

    return factorDict


def getFactorMap(primes, numbers, n):
    factorDict = dict()

    for i in range(n):
        factorDict = populateFactorDict(factorDict, primes, numbers[i])
    return factorDict


def main():

    # calculate primes
    primes = getPrime()
    test = int(input())
    for _ in range(test):
        n = int(input())

        numbers = list(map(int, input().split()))

        factorDict = getFactorMap(primes, numbers, n)
        answer = 1
        for key, value in factorDict.items():
            # number of factor => 12 ->[(2,2), (3,1)] --> (2+1)*(1+1)
            answer *= value + 1
        print(answer)


main()
