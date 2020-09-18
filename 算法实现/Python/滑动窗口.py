n,m,k = list(map(int,input().strip().split()))

gift = list(map(int,input().strip().split()))

res = 0

i = 0

while i < len(gift):
    count = 0
    j = i
    while j < len(gift) and gift[j] >= k and count< m:
        count += 1
        j +=1
    if count == m:
        res +=1
        while j < len(gift) and gift[j] >= k:
            i+=1
            j+=1
            res +=1
        i = j+1
    else:
        i = j + 1
print(res)


