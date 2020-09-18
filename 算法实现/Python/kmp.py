t = "asdhjkaafasd"

def kmp(s,t):
    def get_next():
        k = -1
        next = [-1] * len(t)
        for i in range(1, len(t)):
            while k > -1 and t[k+1] != t[i]:
                k = next[k]
            if t[k+1] == t[i]:
                k +=  1
            next[i] = k
        return next

    k = -1
    res = []
    next = get_next()
    movation = [i - next[i] for i in range(len(t))]
    i = 0
    while i < len(s):
        j = 0
        while j < len(t) - s and s[i] == t[j]:
            i +=1
            j +=1
        i = movation[j]


    return res



s = 'cdcdc'
print(kmp("acdcdc","ahcdah"))
suffix = ['']
for i in range(0,len(s)):
    suffix.append(s[i:len(s)])
print(suffix)
