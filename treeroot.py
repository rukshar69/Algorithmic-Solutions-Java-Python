

test = int(input())

for i in range(test):
    n =  int(input())
    sum =0
    sum_id = 0
    sum_sid =0
    for j in range(n):
        id, sum_children_id = input().split()
        id = int(id)
        sum_children_id = int(sum_children_id)
        sum_id += id
        sum_sid += sum_children_id
    sum = sum_id - sum_sid
    print(sum)