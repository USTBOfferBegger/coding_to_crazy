# board = [[1,1,1,3,8],
#          [2,3,1,5,8],
#          [1,1,1,8,8],
#          [1,7,6,2,8],
#          [1,1,1,4,2]]

board =[[1,4,2,1],
[4,1,1,2],
[3,2,1,4],
[4,2,2,3]]


n = len(board)

MAX = float('inf')
path = [[MAX for i in range(n*n)] for i in range(n*n)]
for i in range(n*n):
    path[i][i] = 0



for i in range(n):
    for j in range(n):
        if i - 1 >= 0:
            path[i * n + j][(i - 1) * n + j] = abs(board[i][j] - board[i - 1][j])
        if j - 1 >= 0:
            path[i * n + j][i * n + j - 1] = abs(board[i][j] - board[i][j - 1])
        if i + 1 < n:
            path[i * n + j][(i + 1) * n + j] = abs(board[i][j] - board[i + 1][j])
        if j + 1 < n:
            path[i * n + j][i * n + j + 1] = abs(board[i][j] - board[i][j + 1])

print(path)


dfs = path[0].copy()
visited = {0}
path_show = ['0'] * len(path)


def dijkstra(visited, dfs, path, target_node,path_show):
    def find_min_no_visit_node(visited, dfs):
        min_index = -1
        min_tmp = float('inf')
        for i in range(len(dfs)):
            if i not in visited and dfs[i] <= min_tmp:
                min_index = i
                min_tmp = dfs[i]
        return min_index, min_tmp
    while target_node not in visited:
        index, val = find_min_no_visit_node(visited,dfs)
        visited.add(index)
        path_show[index] += '->'+str(index)
        dfs[index] = val
        # loose
        for i in range(len(path[index])):
            if i not in visited and val + path[index][i] < dfs[i]:
                dfs[i] = val + path[index][i]
                path_show[i] = path_show[index]
    return None


#dijkstra(visited,dfs,path,len(path)-1,path_show)
target_node = len(path) - 1
dijkstra(visited,dfs,path,target_node,path_show)
print(dfs[target_node])
print(path_show[target_node])
