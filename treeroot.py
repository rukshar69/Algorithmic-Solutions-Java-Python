

test = int(input())

for i in range(test):
    n =  int(input())
    sum =0
    for j in range(n):
        id, sum_children_id = input().split()
        id = int(id)
        sum_children_id = int(sum_children_id)
        sum += (id-sum_children_id)
    print(sum)