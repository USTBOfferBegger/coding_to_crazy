def get_next(t):
    k = -1
    next = [-1] * len(t)
    for i in range(1, len(t)):
        while k > -1 and t[k + 1] != t[i]:
            k = next[k]
        if t[k + 1] == t[i]:
            k += 1
        next[i] = k
    return next


s = input().strip()
next = get_next(s)

if len(s) % (len(s) - next[-1] - 1) == 0:
    print(s[:len(s) - next[-1]-1])
else:
    print(s)