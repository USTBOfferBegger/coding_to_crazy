def find_k(height,s):
    for k in range(len(s)//2,0,-1):
        min_sa = float('inf')
        max_sa = float('-inf')
        for i in range(1,len(height)):
            if height[i] >= k:
                min_sa = min(min_sa, sa[i])
                max_sa = max(max_sa, sa[i])
            else:
                if max_sa - min_sa >= k:
                    print('max_sa', max_sa)
                    print('min_sa', min_sa)
                    return 2 * k
                else:
                    min_sa = height[i]
                    max_sa = height[i]
    return 0


def find_k_new(height,s):
    res = []
    k = 5
    min_sa = float('inf')
    max_sa = float('-inf')
    tmp = []
    for i in range(2,len(height)):
        if height[i] >= k:
            tmp.append(height[i])
        else:
            if tmp:
                res.append(tmp)
            tmp = []
    return res


s = input().strip()
suffix = ['']
for i in range(0,len(s)):
    suffix.append(s[i:len(s)])
sort_suffix = sorted(suffix)
# 第i个后缀字符按字典序的排位
rank = []
for i in suffix:
    rank.append(sort_suffix.index(i))
# 排序后的第i个后缀实际是第几个后缀字符串（后缀数组就是这个)
# sa[rank[i]] == i rank[sa[i]] == i
sa = []
for i in sort_suffix:
    sa.append(suffix.index(i))
# height[i] = suffix[sa[i]]和suffix[sa[i-1]]的最长公共前缀的长度（排名i和排名前一个的后缀最长公共前缀长）
height = [0] * len(suffix)
# h[i] = height[rank[i]]  h[i]表达第i个后缀和排名在他之前一位的后缀的最长公共前缀 h[i] >= h[i-1] -1
h = [0] * len(suffix)


for i in range(1,len(suffix)):
    start = h[i-1] - 1 if h[i-1] >0 else 0
    i_suffix = suffix[sa[rank[i]]]
    pre_rank_i_suffix = suffix[sa[rank[i] -1]]
    min_length = min(i_suffix, pre_rank_i_suffix)
    while start < len(min_length) and i_suffix[start] == pre_rank_i_suffix[start]:
        start += 1
    h[i] = start
    height[rank[i]] = h[i]

print('k',find_k(height,s))
print(sa)
print(sort_suffix)
print(suffix)
print(sa[2])
# 2112211211122212112111112212122221111111112212221121122122122111122212221112112112111111212212211112