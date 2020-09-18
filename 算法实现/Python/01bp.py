v = 10
# 0为占位元素，从下标1进行统计
w = [1, 2, 3, 9,8]
c = [4, 5, 2, 20,10]


# # 未经优化的代码，时间空间复杂度都是n*v
# dp = [[0 for _ in range(v+1)] for i in range(len(w))]
# for i in range(1,len(w)):
#     for j in range(0,v+1):
#         if j >= w[i]:
#             dp[i][j] = max(dp[i-1][j],dp[i-1][j-w[i]]+c[i])
#         else:
#             dp[i][j] = dp[i-1][j]
#
#
# for i in range(len(dp)):
#     for j in range(len(dp[0])):
#         print(dp[i][j], end=' ')
#     print()
#
# print(dp[4][10])


#用一维数组代替二维
v = 10
# 0为占位元素，从下标1进行统计
w = [2,2, 5,4,4]
c = [3,3,10,12,12]


dp = [0 for i in range(v+1)]
dp[0] = 0
# dp = [0 for i in range(v+1)]


for i in range(0,len(w)):
    for j in range(v,w[i]-1,-1):
        dp[j] = max(dp[j],dp[j-w[i]] + c[i])

print(dp[-1])



