"""
https://leetcode-cn.com/problems/n-queens/

"""


def solveNQueens(n: int):
    def backtrack(row, n, board, res):
        if row == n:
            res.append([''.join(bo) for bo in board])
            return None
        for i in range(n):
            board[row][i] = 'Q'
            if islegal(row, i, n, board):
                backtrack(row + 1, n, board, res)
            board[row][i] = '.'

    def islegal(row, col, n, board):
        # dui
        i = row - 1
        j = col - 1
        while i >= 0 and j >= 0:
            if board[i][j] == 'Q':
                return False
            i -= 1
            j -= 1
        # xiedui
        i = row - 1
        j = col + 1
        while i >= 0 and j < n:
            if board[i][j] == 'Q':
                return False
            i -= 1
            j += 1
        # zong
        i = row - 1
        while i >= 0:
            if board[i][col] == 'Q':
                return False
            i -= 1
        return True

    board = [['.' for i in range(n)] for i in range(n)]
    res = []
    backtrack(0, n, board, res)
    return res

if __name__ == '__main__':
    print(solveNQueens(4))