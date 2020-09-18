def prim(board):
    start = 0
    res = 0
    visited = set()
    visited.add(start)
    while len(visited) < len(board):
        min_val = float('inf')
        min_node = -1
        for node in visited:
            for i,val in enumerate(board[node]):
                if i not in visited:
                    if board[node][i] < min_val:
                        min_val = board[node][i]
                        min_node = i
        if min_node == -1:
            break
        else:
            res += min_val
            visited.add(min_node)
    if len(visited) == len(board):
        return "Yes"
    else:
        return "No"



T = int(input().strip())



for i in range(T):
    n,m,k = list(map(int, input().split()))
    board = [[float('inf') for i in range(n)] for i in range(n)]
    for i in range(n):
        board[i][i] = 0
    for i in range(m):
        a,b,c = list(map(int, input().split()))
        if c < k:
            a -= 1
            b -= 1
            board[a][b] = c
            board[b][a] = c
    print(prim(board))


