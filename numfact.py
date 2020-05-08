

def factorCount(number, divisor):
    count =0
    while number%divisor ==0:
        number//=divisor
        count+=1
    return count, number



def AddFactorMap(factorMap, factor, frequency):
    # append into factor list
    if frequency:
        if factor in factorMap:
            factorMap[factor] += frequency
        else:
            factorMap[factor] = frequency
    return factorMap

def factors_v2(number, factorMap):

    count,number = factorCount(number,2)

    # append into factor list
    factorMap = AddFactorMap(factorMap, 2, count)

    # starting from 3 with a step of 2 till root of 'n'
    limit = int(number ** 0.5) + 1
    factor = 3
    while factor<=limit:
        count,number = factorCount(number,factor)
        factorMap = AddFactorMap(factorMap, factor, count)    

        factor += 2

    # include the last factor
    if number > 2:
        if number in factorMap:
            factorMap[number] += 1
        else:
            factorMap[number] = 1
    return factorMap

def populateFactorDictionary(listNumbers,n):
    factorDict = dict()
    for i in range(n):
        factorDict = factors_v2(listNumbers[i],factorDict)
    return factorDict


def main():
    test = int(input())
    for _ in range(test):
        
        
        n= int(input())
        listNumbers = list(map(int, input().split()))
        factorDict = populateFactorDictionary(listNumbers,n)
        
        result =1
        for key, value in factorDict.items():
            result *= (value + 1)
        print(result)

main()