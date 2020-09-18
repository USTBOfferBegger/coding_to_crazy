n = int(input().strip())
start_x, start_y, end_x,end_y = list(map(int,input().strip().split()))
board = []
for _ in range(n):
    board.append(input().strip().split())
queue = [(start_x,start_y)]
res = [0]

def bfs(board,queue,end_x,end_y,index,res):
    tmp = []
    for (row,col) in queue:
        board[row][col] = '#'
        if row == end_x and abs(col-end_y) == 1:
            res[0] = index + 1
            return None
        if abs(row - end_x) == 1 and col == end_y:
            res[0] = index + 1
            return None
        if row - 1 >=0 and board[row-1][col] not in ['#','@']:
            tmp.append((row-1,col))
            board[row-1][col] = '#'
        if row + 1 < len(board) and board[row+1][col] not in ['#','@']:
            board[row+1][col] = '#'
            tmp.append((row+1,col))
        if col - 1 >=0 and board[row][col-1] not in ['#','@']:
            board[row][col-1] = '#'
            tmp.append((row,col-1))
        if col + 1 < len(board[0]) and board[row][col+1] not in ['#','@']:
            board[row][col+1] = '#'
            tmp.append((row,col+1))
    queue = tmp
    bfs(board,queue,end_x,end_y,index+1,res)




bfs(board,queue,end_x,end_y,0,res)

print(res[0])