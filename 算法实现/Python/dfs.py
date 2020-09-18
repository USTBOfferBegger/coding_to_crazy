
def dfs(board,queue,word,index,res,visited):
    print(visited)
    print(queue)
    tmp = []
    for (row,col) in queue:
        visited.add((row,col))
        if index == len(word)-1:
            res[0] = True
            return None
        up = row - 1
        down = row+1
        left=col-1
        right=col+1
        if (up,col) not in visited and up >=0 and board[up][col] == word[index+1]:
            tmp.append((up,col))
            visited.add((up,col))
        if (down,col) not in visited and down < len(board) and board[down][col] == word[index+1]:
            tmp.append((down,col))
            visited.add((down,col))
        if (row,left) not in visited and left >=0 and board[row][left] ==word[index+1]:
            tmp.append((row,left))
            visited.add((row,left))
        if (row,right) not in visited and right < len(board[0]) and board[row][right] ==word[index+1]:
            tmp.append((row,right))
            visited.add((row,right))
    queue = tmp
    if queue:
        dfs(board,queue,word,index+1,res,visited)